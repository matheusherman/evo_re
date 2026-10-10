package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10112b = new a(b.class, 30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final char[] f10113a;

    b(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        int length = bArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        int i10 = length / 2;
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 != i10; i11++) {
            int i12 = i11 * 2;
            cArr[i11] = (char) ((bArr[i12 + 1] & 255) | (bArr[i12] << 8));
        }
        this.f10113a = cArr;
    }

    @Override // fc.z
    final boolean o() {
        return false;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return b.x(q1Var.A());
        }
    }

    b(char[] cArr) {
        if (cArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.f10113a = cArr;
    }

    static b x(byte[] bArr) {
        return new g1(bArr);
    }

    static b y(char[] cArr) {
        return new g1(cArr);
    }

    @Override // fc.z, fc.s
    public final int hashCode() {
        return re.a.n(this.f10113a);
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (zVar instanceof b) {
            return re.a.b(this.f10113a, ((b) zVar).f10113a);
        }
        return false;
    }

    @Override // fc.z
    final void n(x xVar, boolean z10) throws IOException {
        int length = this.f10113a.length;
        xVar.s(z10, 30);
        xVar.k(length * 2);
        byte[] bArr = new byte[8];
        int i10 = length & (-4);
        int i11 = 0;
        while (i11 < i10) {
            char[] cArr = this.f10113a;
            char c10 = cArr[i11];
            char c11 = cArr[i11 + 1];
            char c12 = cArr[i11 + 2];
            char c13 = cArr[i11 + 3];
            i11 += 4;
            bArr[0] = (byte) (c10 >> '\b');
            bArr[1] = (byte) c10;
            bArr[2] = (byte) (c11 >> '\b');
            bArr[3] = (byte) c11;
            bArr[4] = (byte) (c12 >> '\b');
            bArr[5] = (byte) c12;
            bArr[6] = (byte) (c13 >> '\b');
            bArr[7] = (byte) c13;
            xVar.j(bArr, 0, 8);
        }
        if (i11 < length) {
            int i12 = 0;
            do {
                char c14 = this.f10113a[i11];
                i11++;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (c14 >> '\b');
                i12 += 2;
                bArr[i13] = (byte) c14;
            } while (i11 < length);
            xVar.j(bArr, 0, i12);
        }
    }

    @Override // fc.z
    final int s(boolean z10) {
        return x.g(z10, this.f10113a.length * 2);
    }

    public final String z() {
        return new String(this.f10113a);
    }

    public String toString() {
        return z();
    }
}
