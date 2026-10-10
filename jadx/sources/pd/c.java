package pd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f17579c;

    public c(b bVar, byte[] bArr) {
        super(true, bVar);
        this.f17579c = re.a.d(bArr);
    }

    public byte[] b() {
        return re.a.d(this.f17579c);
    }

    public byte[] getEncoded() {
        return b();
    }
}
