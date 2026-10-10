package f6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f10032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f10033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f10034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f10035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f10036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f10037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f10038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a[] f10039o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10041b;

    static {
        a aVar = new a(0, false);
        f10027c = aVar;
        a aVar2 = new a(1, true);
        f10028d = aVar2;
        a aVar3 = new a(2, false);
        f10029e = aVar3;
        a aVar4 = new a(3, true);
        f10030f = aVar4;
        a aVar5 = new a(4, false);
        f10031g = aVar5;
        a aVar6 = new a(5, true);
        f10032h = aVar6;
        a aVar7 = new a(6, false);
        f10033i = aVar7;
        a aVar8 = new a(7, true);
        f10034j = aVar8;
        a aVar9 = new a(8, false);
        f10035k = aVar9;
        a aVar10 = new a(9, true);
        f10036l = aVar10;
        a aVar11 = new a(10, false);
        f10037m = aVar11;
        a aVar12 = new a(10, true);
        f10038n = aVar12;
        f10039o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    public boolean a(a aVar) {
        int i10 = this.f10040a;
        int i11 = aVar.f10040a;
        if (i10 >= i11) {
            return (!this.f10041b || f10036l == this) && i10 == i11;
        }
        return true;
    }

    public a b() {
        return !this.f10041b ? f10039o[this.f10040a + 1] : this;
    }

    private a(int i10, boolean z10) {
        this.f10040a = i10;
        this.f10041b = z10;
    }
}
