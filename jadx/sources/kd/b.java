package kd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12237d = new b("falcon-512", 9, 40);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f12238e = new b("falcon-1024", 10, 40);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12241c;

    public int a() {
        return this.f12240b;
    }

    private b(String str, int i10, int i11) {
        if (i10 >= 1 && i10 <= 10) {
            this.f12239a = str;
            this.f12240b = i10;
            this.f12241c = i11;
            return;
        }
        throw new IllegalArgumentException("Log N degree should be between 1 and 10");
    }
}
