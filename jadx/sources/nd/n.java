package nd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f16404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f16405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final tc.i f16406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16408e;

    public byte[] b(byte[] bArr, int i10) {
        if (bArr.length < this.f16406c.e()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        tc.i iVar = this.f16406c;
        byte[] bArr2 = this.f16404a;
        iVar.update(bArr2, 0, bArr2.length);
        this.f16406c.c((byte) (this.f16407d >>> 24));
        this.f16406c.c((byte) (this.f16407d >>> 16));
        this.f16406c.c((byte) (this.f16407d >>> 8));
        this.f16406c.c((byte) this.f16407d);
        this.f16406c.c((byte) (this.f16408e >>> 8));
        this.f16406c.c((byte) this.f16408e);
        this.f16406c.c((byte) -1);
        tc.i iVar2 = this.f16406c;
        byte[] bArr3 = this.f16405b;
        iVar2.update(bArr3, 0, bArr3.length);
        this.f16406c.b(bArr, i10);
        return bArr;
    }

    public void c(int i10) {
        this.f16408e = i10;
    }

    public void d(int i10) {
        this.f16407d = i10;
    }

    public n(byte[] bArr, byte[] bArr2, tc.i iVar) {
        this.f16404a = bArr;
        this.f16405b = bArr2;
        this.f16406c = iVar;
    }

    public void a(byte[] bArr, boolean z10, int i10) {
        b(bArr, i10);
        if (z10) {
            this.f16408e++;
        }
    }
}
