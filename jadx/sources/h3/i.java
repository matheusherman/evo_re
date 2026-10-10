package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f10802c;

    @Override // h3.j
    public byte[] b() {
        byte[] bArrB = this.f10802c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i10 = 0; i10 < iD; i10++) {
            bArr[i10] = (byte) (255 - (bArrB[i10] & 255));
        }
        return bArr;
    }

    @Override // h3.j
    public byte[] c(int i10, byte[] bArr) {
        byte[] bArrC = this.f10802c.c(i10, bArr);
        int iD = d();
        for (int i11 = 0; i11 < iD; i11++) {
            bArrC[i11] = (byte) (255 - (bArrC[i11] & 255));
        }
        return bArrC;
    }

    @Override // h3.j
    public j e() {
        return this.f10802c;
    }

    @Override // h3.j
    public boolean f() {
        return this.f10802c.f();
    }

    @Override // h3.j
    public j g() {
        return new i(this.f10802c.g());
    }

    public i(j jVar) {
        super(jVar.d(), jVar.a());
        this.f10802c = jVar;
    }
}
