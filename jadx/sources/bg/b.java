package bg;

import androidx.annotation.ColorInt;
import com.youth.banner.config.BannerConfig;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1081b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f1090k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1082c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1083d = bg.a.f1076c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1084e = bg.a.f1074a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1085f = bg.a.f1075b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColorInt
    private int f1086g = BannerConfig.INDICATOR_NORMAL_COLOR;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColorInt
    private int f1087h = BannerConfig.INDICATOR_SELECTED_COLOR;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1088i = bg.a.f1079f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1089j = bg.a.f1078e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1091l = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1095d;

        public a() {
            this(bg.a.f1077d);
        }

        public a(int i10) {
            this(i10, i10, i10, i10);
        }

        public a(int i10, int i11, int i12, int i13) {
            this.f1092a = i10;
            this.f1093b = i11;
            this.f1094c = i12;
            this.f1095d = i13;
        }
    }

    public int a() {
        return this.f1081b;
    }

    public int b() {
        return this.f1082c;
    }

    public int c() {
        return this.f1089j;
    }

    public int d() {
        return this.f1080a;
    }

    public int e() {
        return this.f1083d;
    }

    public a f() {
        if (this.f1090k == null) {
            o(new a());
        }
        return this.f1090k;
    }

    public int g() {
        return this.f1086g;
    }

    public int h() {
        return this.f1084e;
    }

    public int i() {
        return this.f1088i;
    }

    public int j() {
        return this.f1087h;
    }

    public int k() {
        return this.f1085f;
    }

    public boolean l() {
        return this.f1091l;
    }

    public b m(int i10) {
        this.f1081b = i10;
        return this;
    }

    public b n(int i10) {
        this.f1080a = i10;
        return this;
    }

    public b o(a aVar) {
        this.f1090k = aVar;
        return this;
    }
}
