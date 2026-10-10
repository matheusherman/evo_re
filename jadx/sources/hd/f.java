package hd;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int[] f10969h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f f10974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f10975n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f10988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f10990g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int[] f10970i = {10, 9, 6, 0};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int[] f10971j = {7, 2, 1, 0};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f10972k = {8, 0};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int[] f10973l = {7, 2, 1, 0};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f f10976o = new f("mceliece460896", 13, 4608, 96, f10970i, false, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f10977p = new f("mceliece460896f", 13, 4608, 96, f10970i, true, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f f10978q = new f("mceliece6688128", 13, 6688, 128, f10971j, false, 256);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final f f10979r = new f("mceliece6688128f", 13, 6688, 128, f10971j, true, 256);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f10980s = new f("mceliece6960119", 13, 6960, 119, f10972k, false, 256);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f f10981t = new f("mceliece6960119f", 13, 6960, 119, f10972k, true, 256);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f f10982u = new f("mceliece8192128", 13, 8192, 128, f10973l, false, 256);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f f10983v = new f("mceliece8192128f", 13, 8192, 128, f10973l, true, 256);

    static {
        int[] iArr = {3, 1, 0};
        f10969h = iArr;
        f10974m = new f("mceliece348864", 12, 3488, 64, iArr, false, 128);
        f10975n = new f("mceliece348864f", 12, 3488, 64, f10969h, true, 128);
    }

    d a() {
        return this.f10990g;
    }

    public int b() {
        return this.f10987d;
    }

    private f(String str, int i10, int i11, int i12, int[] iArr, boolean z10, int i13) {
        this.f10984a = str;
        this.f10985b = i10;
        this.f10986c = i11;
        this.f10987d = i12;
        this.f10988e = z10;
        this.f10989f = i13;
        this.f10990g = new d(i10, i11, i12, iArr, z10, i13);
    }
}
