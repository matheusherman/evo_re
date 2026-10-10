package pd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f17580c;

    public d(b bVar, byte[] bArr) {
        super(false, bVar);
        this.f17580c = re.a.d(bArr);
    }

    public byte[] b() {
        return re.a.d(this.f17580c);
    }

    public byte[] getEncoded() {
        return b();
    }
}
