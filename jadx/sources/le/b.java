package le;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b extends xc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f15414c;

    public b(int i10, byte[] bArr) {
        super(false);
        if (bArr.length != c.c(i10)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f15413b = i10;
        this.f15414c = re.a.d(bArr);
    }

    public byte[] a() {
        return re.a.d(this.f15414c);
    }

    public int b() {
        return this.f15413b;
    }
}
