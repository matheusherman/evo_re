package xc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f22063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22064c;

    public e(byte[] bArr, int i10) {
        this(bArr, i10, -1);
    }

    public e(byte[] bArr, int i10, int i11) {
        this.f22063b = re.a.d(bArr);
        this.f22064c = i10;
        this.f22062a = i11;
    }

    public int a() {
        return this.f22064c;
    }

    public byte[] b() {
        return re.a.d(this.f22063b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar.f22064c != this.f22064c) {
            return false;
        }
        return re.a.a(this.f22063b, eVar.f22063b);
    }

    public int hashCode() {
        return this.f22064c ^ re.a.l(this.f22063b);
    }
}
