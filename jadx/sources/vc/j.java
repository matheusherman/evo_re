package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class j extends c {
    public j() {
        this(tc.d.ANY);
    }

    public j(tc.d dVar) {
        super(dVar);
        tc.g.a(r());
        q();
    }

    @Override // tc.i
    public String a() {
        return "SHA-512";
    }

    @Override // tc.i
    public int e() {
        return 64;
    }

    protected tc.c r() {
        return l.a(this, 256, this.f19780a);
    }

    @Override // tc.i
    public int b(byte[] bArr, int i10) {
        m();
        re.f.i(this.f19785f, bArr, i10);
        re.f.i(this.f19786g, bArr, i10 + 8);
        re.f.i(this.f19787h, bArr, i10 + 16);
        re.f.i(this.f19788i, bArr, i10 + 24);
        re.f.i(this.f19789j, bArr, i10 + 32);
        re.f.i(this.f19790k, bArr, i10 + 40);
        re.f.i(this.f19791l, bArr, i10 + 48);
        re.f.i(this.f19792m, bArr, i10 + 56);
        q();
        return 64;
    }

    @Override // vc.c
    public void q() {
        super.q();
        this.f19785f = 7640891576956012808L;
        this.f19786g = -4942790177534073029L;
        this.f19787h = 4354685564936845355L;
        this.f19788i = -6534734903238641935L;
        this.f19789j = 5840696475078001361L;
        this.f19790k = -7276294671716946913L;
        this.f19791l = 2270897969802886507L;
        this.f19792m = 6620516959819538809L;
    }
}
