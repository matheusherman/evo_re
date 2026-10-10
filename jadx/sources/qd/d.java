package qd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f17737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f17738d;

    public d(b bVar, byte[] bArr) {
        super(false, bVar);
        byte[] bArrI = re.a.i(bArr, 0, 32);
        this.f17737c = bArrI;
        this.f17738d = re.a.i(bArr, bArrI.length, bArr.length);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[a().a()];
        byte[] bArr2 = this.f17737c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f17738d;
        System.arraycopy(bArr3, 0, bArr, this.f17737c.length, bArr3.length);
        return bArr;
    }
}
