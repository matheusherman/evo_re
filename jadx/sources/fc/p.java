package fc;

import java.math.BigInteger;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final m0 f10205c = new a(p.class, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10207b;

    public p(long j10) {
        this.f10206a = BigInteger.valueOf(j10).toByteArray();
        this.f10207b = 0;
    }

    static int C(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int iMax = Math.max(i10, length - 4);
        int i12 = i11 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i12;
            }
            i12 = (i12 << 8) | (bArr[iMax] & 255);
        }
    }

    static boolean E(byte[] bArr) {
        int length = bArr.length;
        if (length != 0) {
            return (length == 1 || bArr[0] != (bArr[1] >> 7) || re.g.b("org.bouncycastle.asn1.allow_unsafe_integer")) ? false : true;
        }
        return true;
    }

    static long H(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int iMax = Math.max(i10, length - 8);
        long j10 = i11 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return j10;
            }
            j10 = (j10 << 8) | ((long) (bArr[iMax] & 255));
        }
    }

    static int J(byte[] bArr) {
        int length = bArr.length - 1;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (bArr[i10] != (bArr[i11] >> 7)) {
                break;
            }
            i10 = i11;
        }
        return i10;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 2, this.f10206a);
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
            return p.x(q1Var.A());
        }
    }

    public p(BigInteger bigInteger) {
        this.f10206a = bigInteger.toByteArray();
        this.f10207b = 0;
    }

    static p x(byte[] bArr) {
        return new p(bArr, false);
    }

    public static p y(h0 h0Var, boolean z10) {
        return (p) f10205c.e(h0Var, z10);
    }

    public static p z(Object obj) {
        if (obj == null || (obj instanceof p)) {
            return (p) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (p) f10205c.b((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    public BigInteger A() {
        return new BigInteger(this.f10206a);
    }

    public boolean B(int i10) {
        byte[] bArr = this.f10206a;
        int length = bArr.length;
        int i11 = this.f10207b;
        return length - i11 <= 4 && C(bArr, i11, -1) == i10;
    }

    public int D() {
        byte[] bArr = this.f10206a;
        int length = bArr.length;
        int i10 = this.f10207b;
        if (length - i10 <= 4) {
            return C(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long I() {
        byte[] bArr = this.f10206a;
        int length = bArr.length;
        int i10 = this.f10207b;
        if (length - i10 <= 8) {
            return H(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return re.a.l(this.f10206a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof p) {
            return re.a.a(this.f10206a, ((p) zVar).f10206a);
        }
        return false;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10206a.length);
    }

    p(byte[] bArr, boolean z10) {
        if (E(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f10206a = z10 ? re.a.d(bArr) : bArr;
        this.f10207b = J(bArr);
    }

    public String toString() {
        return A().toString();
    }
}
