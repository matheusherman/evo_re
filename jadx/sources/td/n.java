package td;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class n extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f19205c;

    public n(l lVar, byte[] bArr) {
        super(false, lVar);
        this.f19205c = re.a.d(bArr);
    }

    public byte[] b() {
        return re.a.d(this.f19205c);
    }

    public byte[] getEncoded() {
        return b();
    }
}
