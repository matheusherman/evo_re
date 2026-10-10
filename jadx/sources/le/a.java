package le;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends xc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f15412c;

    public a(int i10, byte[] bArr) {
        super(true);
        if (bArr.length != c.b(i10)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f15411b = i10;
        this.f15412c = re.a.d(bArr);
    }

    public byte[] a() {
        return re.a.d(this.f15412c);
    }

    public int b() {
        return this.f15411b;
    }
}
