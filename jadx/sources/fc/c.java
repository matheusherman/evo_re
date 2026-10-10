package fc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c extends z implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10117b = new a(c.class, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f10118c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10119a;

    c(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f10119a = re.a.s(bArr, (byte) i10);
    }

    static c x(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i10 = bArr[0] & 255;
        if (i10 > 0) {
            if (i10 > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b10 = bArr[length - 1];
            if (b10 != ((byte) ((255 << i10) & b10))) {
                return new d2(bArr, false);
            }
        }
        return new h1(bArr, false);
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z c(c0 c0Var) {
            return c0Var.C();
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return c.x(q1Var.A());
        }
    }

    c(byte[] bArr, boolean z10) {
        if (z10) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i10 = bArr[0] & 255;
            if (i10 > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i10 > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.f10119a = bArr;
    }

    public static c A(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof f) {
            z zVarF = ((f) obj).f();
            if (zVarF instanceof c) {
                return (c) zVarF;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (c) f10117b.b((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static c z(h0 h0Var, boolean z10) {
        return (c) f10117b.e(h0Var, z10);
    }

    public byte[] B() {
        byte[] bArr = this.f10119a;
        if (bArr[0] == 0) {
            return re.a.i(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // fc.d
    public InputStream g() {
        byte[] bArr = this.f10119a;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    @Override // fc.d
    public int h() {
        return this.f10119a[0] & 255;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        byte[] bArr = this.f10119a;
        if (bArr.length < 2) {
            return 1;
        }
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        return (re.a.m(bArr, 0, length) * 257) ^ ((byte) ((255 << i10) & bArr[length]));
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (!(zVar instanceof c)) {
            return false;
        }
        byte[] bArr = this.f10119a;
        byte[] bArr2 = ((c) zVar).f10119a;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i10 = length - 1;
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        int i12 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i10] & i12)) == ((byte) (bArr2[i10] & i12));
    }

    @Override // fc.z
    z v() {
        return new h1(this.f10119a, false);
    }

    @Override // fc.z
    z w() {
        return new d2(this.f10119a, false);
    }

    public byte[] y() {
        byte[] bArr = this.f10119a;
        if (bArr.length == 1) {
            return v.f10241c;
        }
        int i10 = bArr[0] & 255;
        byte[] bArrI = re.a.i(bArr, 1, bArr.length);
        int length = bArrI.length - 1;
        bArrI[length] = (byte) (((byte) (255 << i10)) & bArrI[length]);
        return bArrI;
    }

    public String C() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append('#');
            for (int i10 = 0; i10 != encoded.length; i10++) {
                byte b10 = encoded[i10];
                char[] cArr = f10118c;
                stringBuffer.append(cArr[(b10 >>> 4) & 15]);
                stringBuffer.append(cArr[b10 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new y("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    @Override // fc.p2
    public z i() {
        return f();
    }

    public String toString() {
        return C();
    }
}
