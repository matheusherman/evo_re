package id;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f11348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final byte[] f11349d;

    public d(b bVar, byte[] bArr) {
        super(false, bVar);
        this.f11348c = re.a.i(bArr, 0, 32);
        this.f11349d = re.a.i(bArr, 32, bArr.length);
    }

    public d(b bVar, byte[] bArr, byte[] bArr2) {
        super(false, bVar);
        this.f11348c = re.a.d(bArr);
        this.f11349d = re.a.d(bArr2);
    }

    public byte[] b() {
        return re.a.d(this.f11348c);
    }

    public byte[] c() {
        return re.a.d(this.f11349d);
    }
}
