package xd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<Integer, r> f22124e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f22126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22128d;

    public r(int i10, int i11, fc.u uVar) {
        this.f22127c = i10;
        this.f22128d = i11;
        this.f22126b = new x(j(i10, i11), uVar);
        this.f22125a = d.c(e(), f(), g(), c(), a(), i11);
    }

    private static int j(int i10, int i11) {
        if (i10 < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i10 % i11 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i12 = i10 / i11;
        if (i12 != 1) {
            return i12;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
    }

    static {
        HashMap map = new HashMap();
        Integer numA = re.d.a(1);
        fc.u uVar = nc.a.f16308c;
        map.put(numA, new r(20, 2, uVar));
        map.put(re.d.a(2), new r(20, 4, uVar));
        map.put(re.d.a(3), new r(40, 2, uVar));
        map.put(re.d.a(4), new r(40, 4, uVar));
        map.put(re.d.a(5), new r(40, 8, uVar));
        map.put(re.d.a(6), new r(60, 3, uVar));
        map.put(re.d.a(7), new r(60, 6, uVar));
        map.put(re.d.a(8), new r(60, 12, uVar));
        Integer numA2 = re.d.a(9);
        fc.u uVar2 = nc.a.f16312e;
        map.put(numA2, new r(20, 2, uVar2));
        map.put(re.d.a(10), new r(20, 4, uVar2));
        map.put(re.d.a(11), new r(40, 2, uVar2));
        map.put(re.d.a(12), new r(40, 4, uVar2));
        map.put(re.d.a(13), new r(40, 8, uVar2));
        map.put(re.d.a(14), new r(60, 3, uVar2));
        map.put(re.d.a(15), new r(60, 6, uVar2));
        map.put(re.d.a(16), new r(60, 12, uVar2));
        Integer numA3 = re.d.a(17);
        fc.u uVar3 = nc.a.f16328m;
        map.put(numA3, new r(20, 2, uVar3));
        map.put(re.d.a(18), new r(20, 4, uVar3));
        map.put(re.d.a(19), new r(40, 2, uVar3));
        map.put(re.d.a(20), new r(40, 4, uVar3));
        map.put(re.d.a(21), new r(40, 8, uVar3));
        map.put(re.d.a(22), new r(60, 3, uVar3));
        map.put(re.d.a(23), new r(60, 6, uVar3));
        map.put(re.d.a(24), new r(60, 12, uVar3));
        Integer numA4 = re.d.a(25);
        fc.u uVar4 = nc.a.f16330n;
        map.put(numA4, new r(20, 2, uVar4));
        map.put(re.d.a(26), new r(20, 4, uVar4));
        map.put(re.d.a(27), new r(40, 2, uVar4));
        map.put(re.d.a(28), new r(40, 4, uVar4));
        map.put(re.d.a(29), new r(40, 8, uVar4));
        map.put(re.d.a(30), new r(60, 3, uVar4));
        map.put(re.d.a(31), new r(60, 6, uVar4));
        map.put(re.d.a(32), new r(60, 12, uVar4));
        f22124e = Collections.unmodifiableMap(map);
    }

    public r(int i10, int i11, tc.i iVar) {
        this(i10, i11, f.c(iVar.a()));
    }

    public static r i(int i10) {
        return f22124e.get(re.d.a(i10));
    }

    public int a() {
        return this.f22127c;
    }

    public int b() {
        return this.f22128d;
    }

    protected int c() {
        return this.f22126b.d();
    }

    protected w d() {
        return this.f22125a;
    }

    protected String e() {
        return this.f22126b.f();
    }

    public int f() {
        return this.f22126b.h();
    }

    int g() {
        return this.f22126b.j();
    }

    protected x h() {
        return this.f22126b;
    }
}
