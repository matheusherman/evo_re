package kd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f12242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f12243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f12244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f12245f;

    public c(b bVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, bVar);
        this.f12243d = re.a.d(bArr);
        this.f12244e = re.a.d(bArr2);
        this.f12245f = re.a.d(bArr3);
        this.f12242c = re.a.d(bArr4);
    }

    public byte[] b() {
        return re.a.d(this.f12244e);
    }

    public byte[] c() {
        return re.a.d(this.f12242c);
    }

    public byte[] d() {
        return re.a.d(this.f12245f);
    }

    public byte[] e() {
        return re.a.d(this.f12243d);
    }

    public byte[] getEncoded() {
        return re.a.g(this.f12243d, this.f12244e, this.f12245f);
    }
}
