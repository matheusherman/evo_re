package vd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f19915c;

    public g(e eVar, byte[] bArr) {
        super(false, eVar);
        int iB = eVar.b();
        int i10 = iB * 2;
        if (bArr.length != i10) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.f19915c = new a(re.a.i(bArr, 0, iB), re.a.i(bArr, iB, i10));
    }

    public byte[] getEncoded() {
        byte[] bArrD = re.f.d(e.a(a()).intValue());
        a aVar = this.f19915c;
        return re.a.g(bArrD, aVar.f19837a, aVar.f19838b);
    }
}
