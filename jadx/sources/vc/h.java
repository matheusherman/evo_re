package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class h extends c {
    public h() {
        this(tc.d.ANY);
    }

    public h(tc.d dVar) {
        super(dVar);
        tc.g.a(r());
        q();
    }

    @Override // tc.i
    public String a() {
        return "SHA-384";
    }

    @Override // tc.i
    public int e() {
        return 48;
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
        q();
        return 48;
    }

    @Override // vc.c
    public void q() {
        super.q();
        this.f19785f = -3766243637369397544L;
        this.f19786g = 7105036623409894663L;
        this.f19787h = -7973340178411365097L;
        this.f19788i = 1526699215303891257L;
        this.f19789j = 7436329637833083697L;
        this.f19790k = -8163818279084223215L;
        this.f19791l = -2662702644619276377L;
        this.f19792m = 5167115440072839076L;
    }
}
