package gd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f10683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f10684e;

    public d(c cVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(true, cVar);
        this.f10682c = re.a.d(bArr);
        this.f10683d = re.a.d(bArr2);
        this.f10684e = re.a.d(bArr3);
    }

    public byte[] getEncoded() {
        return re.a.f(re.a.f(this.f10682c, this.f10683d), this.f10684e);
    }
}
