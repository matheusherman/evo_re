package md;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f15794c;

    public e(c cVar, byte[] bArr) {
        super(true, cVar);
        this.f15794c = re.a.d(bArr);
    }

    public byte[] b() {
        return re.a.d(this.f15794c);
    }

    public byte[] getEncoded() {
        return b();
    }
}
