package vd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b f19913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a f19914d;

    public f(e eVar, byte[] bArr) {
        super(true, eVar);
        int iB = eVar.b();
        int i10 = iB * 4;
        if (bArr.length != i10) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i11 = iB * 2;
        this.f19913c = new b(re.a.i(bArr, 0, iB), re.a.i(bArr, iB, i11));
        int i12 = iB * 3;
        this.f19914d = new a(re.a.i(bArr, i11, i12), re.a.i(bArr, i12, i10));
    }

    public byte[] b() {
        byte[] bArrD = re.f.d(e.a(a()).intValue());
        a aVar = this.f19914d;
        return re.a.g(bArrD, aVar.f19837a, aVar.f19838b);
    }

    public byte[] getEncoded() {
        byte[] bArrD = re.f.d(e.a(a()).intValue());
        b bVar = this.f19913c;
        byte[] bArr = bVar.f19839a;
        byte[] bArr2 = bVar.f19840b;
        a aVar = this.f19914d;
        return re.a.f(bArrD, re.a.h(bArr, bArr2, aVar.f19837a, aVar.f19838b));
    }
}
