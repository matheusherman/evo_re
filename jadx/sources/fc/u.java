package fc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final m0 f10229c = new a(u.class, 6);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentMap<b, u> f10230d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f10232b;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f10234b;

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return re.a.a(this.f10234b, ((b) obj).f10234b);
            }
            return false;
        }

        public int hashCode() {
            return this.f10233a;
        }

        b(byte[] bArr) {
            this.f10233a = re.a.l(bArr);
            this.f10234b = bArr;
        }
    }

    u(u uVar, String str) {
        if (!b0.B(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f10231a = uVar.B() + "." + str;
    }

    private synchronized byte[] A() {
        try {
            if (this.f10232b == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                z(byteArrayOutputStream);
                this.f10232b = byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10232b;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 6, A());
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return u.y(q1Var.A(), false);
        }
    }

    public u(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        }
        if (E(str)) {
            this.f10231a = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public static u C(Object obj) {
        if (obj == null || (obj instanceof u)) {
            return (u) obj;
        }
        if (obj instanceof f) {
            z zVarF = ((f) obj).f();
            if (zVarF instanceof u) {
                return (u) zVarF;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (u) f10229c.b((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    static u y(byte[] bArr, boolean z10) {
        u uVar = f10230d.get(new b(bArr));
        return uVar == null ? new u(bArr, z10) : uVar;
    }

    private void z(ByteArrayOutputStream byteArrayOutputStream) {
        u2 u2Var = new u2(this.f10231a);
        int i10 = Integer.parseInt(u2Var.b()) * 40;
        String strB = u2Var.b();
        if (strB.length() <= 18) {
            b0.C(byteArrayOutputStream, ((long) i10) + Long.parseLong(strB));
        } else {
            b0.D(byteArrayOutputStream, new BigInteger(strB).add(BigInteger.valueOf(i10)));
        }
        while (u2Var.a()) {
            String strB2 = u2Var.b();
            if (strB2.length() <= 18) {
                b0.C(byteArrayOutputStream, Long.parseLong(strB2));
            } else {
                b0.D(byteArrayOutputStream, new BigInteger(strB2));
            }
        }
    }

    public String B() {
        return this.f10231a;
    }

    public u D() {
        b bVar = new b(A());
        ConcurrentMap<b, u> concurrentMap = f10230d;
        u uVar = concurrentMap.get(bVar);
        if (uVar != null) {
            return uVar;
        }
        u uVarPutIfAbsent = concurrentMap.putIfAbsent(bVar, this);
        return uVarPutIfAbsent == null ? this : uVarPutIfAbsent;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return this.f10231a.hashCode();
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar == this) {
            return true;
        }
        if (zVar instanceof u) {
            return this.f10231a.equals(((u) zVar).f10231a);
        }
        return false;
    }

    public u x(String str) {
        return new u(this, str);
    }

    u(byte[] bArr, boolean z10) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z11 = true;
        BigInteger bigIntegerShiftLeft = null;
        long j10 = 0;
        for (int i10 = 0; i10 != bArr2.length; i10++) {
            byte b10 = bArr2[i10];
            if (j10 <= 72057594037927808L) {
                long j11 = j10 + ((long) (b10 & 127));
                if ((b10 & 128) == 0) {
                    if (z11) {
                        if (j11 < 40) {
                            stringBuffer.append('0');
                        } else if (j11 < 80) {
                            stringBuffer.append('1');
                            j11 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j11 -= 80;
                        }
                        z11 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j11);
                    j10 = 0;
                } else {
                    j10 = j11 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j10) : bigIntegerShiftLeft).or(BigInteger.valueOf(b10 & 127));
                if ((b10 & 128) == 0) {
                    if (z11) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z11 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j10 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f10231a = stringBuffer.toString();
        this.f10232b = z10 ? re.a.d(bArr2) : bArr2;
    }

    private static boolean E(String str) {
        char cCharAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2') {
            return false;
        }
        return b0.B(str, 2);
    }

    public boolean H(u uVar) {
        String strB = B();
        String strB2 = uVar.B();
        if (strB.length() > strB2.length() && strB.charAt(strB2.length()) == '.' && strB.startsWith(strB2)) {
            return true;
        }
        return false;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, A().length);
    }

    public String toString() {
        return B();
    }
}
