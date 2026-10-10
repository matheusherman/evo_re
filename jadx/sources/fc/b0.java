package fc;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b0 extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final m0 f10114c = new a(b0.class, 13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f10116b;

    private synchronized byte[] z() {
        try {
            if (this.f10116b == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                y(byteArrayOutputStream);
                this.f10116b = byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10116b;
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
            return b0.x(q1Var.A(), false);
        }
    }

    private b0(byte[] bArr, boolean z10) {
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
                        z11 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(j11);
                    j10 = 0;
                } else {
                    j10 = j11 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j10) : bigIntegerShiftLeft).or(BigInteger.valueOf(b10 & 127));
                if ((b10 & 128) == 0) {
                    if (z11) {
                        z11 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j10 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f10115a = stringBuffer.toString();
        this.f10116b = z10 ? re.a.d(bArr2) : bArr2;
    }

    static void C(ByteArrayOutputStream byteArrayOutputStream, long j10) {
        byte[] bArr = new byte[9];
        int i10 = 8;
        bArr[8] = (byte) (((int) j10) & 127);
        while (j10 >= 128) {
            j10 >>= 7;
            i10--;
            bArr[i10] = (byte) (((int) j10) | 128);
        }
        byteArrayOutputStream.write(bArr, i10, 9 - i10);
    }

    static b0 x(byte[] bArr, boolean z10) {
        return new b0(bArr, z10);
    }

    private void y(ByteArrayOutputStream byteArrayOutputStream) {
        u2 u2Var = new u2(this.f10115a);
        while (u2Var.a()) {
            String strB = u2Var.b();
            if (strB.length() <= 18) {
                C(byteArrayOutputStream, Long.parseLong(strB));
            } else {
                D(byteArrayOutputStream, new BigInteger(strB));
            }
        }
    }

    public String A() {
        return this.f10115a;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return this.f10115a.hashCode();
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (this == zVar) {
            return true;
        }
        if (zVar instanceof b0) {
            return this.f10115a.equals(((b0) zVar).f10115a);
        }
        return false;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 13, z());
    }

    static boolean B(String str, int i10) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            int i12 = length - 1;
            if (i12 >= i10) {
                char cCharAt = str.charAt(i12);
                if (cCharAt == '.') {
                    if (i11 == 0 || (i11 > 1 && str.charAt(length) == '0')) {
                        return false;
                    }
                    i11 = 0;
                } else {
                    if ('0' > cCharAt || cCharAt > '9') {
                        return false;
                    }
                    i11++;
                }
                length = i12;
            } else {
                if (i11 == 0 || (i11 > 1 && str.charAt(length) == '0')) {
                    return false;
                }
                return true;
            }
        }
    }

    static void D(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i10 = iBitLength - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            bArr[i11] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i10] = (byte) (bArr[i10] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, z().length);
    }

    public String toString() {
        return A();
    }
}
