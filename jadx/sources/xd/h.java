package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tc.i f22085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22086b;

    private byte[] d(int i10, byte[] bArr, byte[] bArr2) {
        byte[] bArrQ = a0.q(i10, this.f22086b);
        this.f22085a.update(bArrQ, 0, bArrQ.length);
        this.f22085a.update(bArr, 0, bArr.length);
        this.f22085a.update(bArr2, 0, bArr2.length);
        int i11 = this.f22086b;
        byte[] bArr3 = new byte[i11];
        tc.i iVar = this.f22085a;
        if (iVar instanceof tc.l) {
            ((tc.l) iVar).d(bArr3, 0, i11);
            return bArr3;
        }
        iVar.b(bArr3, 0);
        return bArr3;
    }

    protected byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f22086b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i10) {
            return d(0, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    protected byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f22086b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i10 * 2) {
            return d(1, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    protected byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f22086b) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return d(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }

    protected h(fc.u uVar, int i10) {
        if (uVar != null) {
            this.f22085a = f.a(uVar);
            this.f22086b = i10;
            return;
        }
        throw new NullPointerException("digest == null");
    }
}
