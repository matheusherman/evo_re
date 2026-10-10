package ziyi.kit.keyboard;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f23351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f23352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f23354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f23355f;

    public a(int i10, CharSequence charSequence) {
        this(i10, charSequence, charSequence, -1);
    }

    public a(int i10, CharSequence charSequence, CharSequence charSequence2) {
        this(i10, charSequence, charSequence2, -1);
    }

    public int a() {
        return this.f23353d;
    }

    public float b() {
        return this.f23354e;
    }

    public int c() {
        return this.f23350a;
    }

    public CharSequence d() {
        return this.f23351b;
    }

    public CharSequence e() {
        return this.f23352c;
    }

    public boolean f() {
        return this.f23355f;
    }

    public void g(int i10) {
        this.f23353d = i10;
    }

    public void h(float f10) {
        this.f23354e = f10;
    }

    public void i(CharSequence charSequence) {
        this.f23351b = charSequence;
    }

    public void j(CharSequence charSequence) {
        this.f23352c = charSequence;
    }

    public a(int i10, CharSequence charSequence, boolean z10) {
        this(i10, charSequence, charSequence, -1, 1.0f, z10);
    }

    public a(int i10, CharSequence charSequence, CharSequence charSequence2, int i11) {
        this(i10, charSequence, charSequence2, i11, 1.0f, false);
    }

    public a(int i10, CharSequence charSequence, CharSequence charSequence2, int i11, float f10, boolean z10) {
        this.f23350a = i10;
        this.f23351b = charSequence;
        this.f23352c = charSequence2;
        this.f23353d = i11;
        this.f23354e = f10;
        this.f23355f = z10;
    }
}
