package xd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class x {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<Integer, x> f22154i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final fc.u f22158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m f22162h;

    public x(int i10, fc.u uVar) {
        if (i10 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        if (uVar == null) {
            throw new NullPointerException("digest == null");
        }
        this.f22156b = i10;
        this.f22157c = a();
        String strB = f.b(uVar);
        this.f22160f = strB;
        this.f22158d = uVar;
        m mVar = new m(uVar);
        this.f22162h = mVar;
        int iC = mVar.c();
        this.f22161g = iC;
        int iD = mVar.d();
        this.f22159e = iD;
        this.f22155a = e.c(strB, iC, iD, mVar.a(), i10);
    }

    private int a() {
        int i10 = 2;
        while (true) {
            int i11 = this.f22156b;
            if (i10 > i11) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i11 - i10) % 2 == 0) {
                return i10;
            }
            i10++;
        }
    }

    static {
        HashMap map = new HashMap();
        Integer numA = re.d.a(1);
        fc.u uVar = nc.a.f16308c;
        map.put(numA, new x(10, uVar));
        map.put(re.d.a(2), new x(16, uVar));
        map.put(re.d.a(3), new x(20, uVar));
        Integer numA2 = re.d.a(4);
        fc.u uVar2 = nc.a.f16312e;
        map.put(numA2, new x(10, uVar2));
        map.put(re.d.a(5), new x(16, uVar2));
        map.put(re.d.a(6), new x(20, uVar2));
        Integer numA3 = re.d.a(7);
        fc.u uVar3 = nc.a.f16328m;
        map.put(numA3, new x(10, uVar3));
        map.put(re.d.a(8), new x(16, uVar3));
        map.put(re.d.a(9), new x(20, uVar3));
        Integer numA4 = re.d.a(10);
        fc.u uVar4 = nc.a.f16330n;
        map.put(numA4, new x(10, uVar4));
        map.put(re.d.a(11), new x(16, uVar4));
        map.put(re.d.a(12), new x(20, uVar4));
        f22154i = Collections.unmodifiableMap(map);
    }

    public x(int i10, tc.i iVar) {
        this(i10, f.c(iVar.a()));
    }

    public static x k(int i10) {
        return f22154i.get(re.d.a(i10));
    }

    public int b() {
        return this.f22156b;
    }

    int c() {
        return this.f22157c;
    }

    int d() {
        return this.f22162h.a();
    }

    w e() {
        return this.f22155a;
    }

    String f() {
        return this.f22160f;
    }

    public fc.u g() {
        return this.f22158d;
    }

    public int h() {
        return this.f22161g;
    }

    k i() {
        return new k(this.f22162h);
    }

    int j() {
        return this.f22159e;
    }
}
