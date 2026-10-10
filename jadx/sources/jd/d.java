package jd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f11710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final byte[] f11711d;

    public d(b bVar, byte[] bArr) {
        super(false, bVar);
        this.f11710c = re.a.i(bArr, 0, bArr.length - 32);
        this.f11711d = re.a.i(bArr, bArr.length - 32, bArr.length);
    }

    public d(b bVar, byte[] bArr, byte[] bArr2) {
        super(false, bVar);
        this.f11710c = re.a.d(bArr);
        this.f11711d = re.a.d(bArr2);
    }

    public byte[] b() {
        return re.a.d(this.f11711d);
    }

    public byte[] c() {
        return re.a.d(this.f11710c);
    }
}
