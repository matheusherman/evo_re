package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f22113a;

    protected byte[][] a() {
        return a0.d(this.f22113a);
    }

    protected n(m mVar, byte[][] bArr) {
        if (mVar != null) {
            if (bArr != null) {
                if (!a0.k(bArr)) {
                    if (bArr.length == mVar.a()) {
                        for (byte[] bArr2 : bArr) {
                            if (bArr2.length != mVar.c()) {
                                throw new IllegalArgumentException("wrong publicKey format");
                            }
                        }
                        this.f22113a = a0.d(bArr);
                        return;
                    }
                    throw new IllegalArgumentException("wrong publicKey size");
                }
                throw new NullPointerException("publicKey byte array == null");
            }
            throw new NullPointerException("publicKey == null");
        }
        throw new NullPointerException("params == null");
    }
}
