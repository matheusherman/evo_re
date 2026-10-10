package nd;

import fc.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f16394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f16395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f16396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f16397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f16398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<Object, k> f16399j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u f16403d;

    static class a extends HashMap<Object, k> {
        a() {
            k kVar = k.f16394e;
            put(Integer.valueOf(kVar.f16400a), kVar);
            k kVar2 = k.f16395f;
            put(Integer.valueOf(kVar2.f16400a), kVar2);
            k kVar3 = k.f16396g;
            put(Integer.valueOf(kVar3.f16400a), kVar3);
            k kVar4 = k.f16397h;
            put(Integer.valueOf(kVar4.f16400a), kVar4);
            k kVar5 = k.f16398i;
            put(Integer.valueOf(kVar5.f16400a), kVar5);
        }
    }

    static {
        u uVar = nc.a.f16308c;
        f16394e = new k(5, 32, 5, uVar);
        f16395f = new k(6, 32, 10, uVar);
        f16396g = new k(7, 32, 15, uVar);
        f16397h = new k(8, 32, 20, uVar);
        f16398i = new k(9, 32, 25, uVar);
        f16399j = new a();
    }

    static k e(int i10) {
        return f16399j.get(Integer.valueOf(i10));
    }

    public u b() {
        return this.f16403d;
    }

    public int c() {
        return this.f16402c;
    }

    public int d() {
        return this.f16401b;
    }

    public int f() {
        return this.f16400a;
    }

    protected k(int i10, int i11, int i12, u uVar) {
        this.f16400a = i10;
        this.f16401b = i11;
        this.f16402c = i12;
        this.f16403d = uVar;
    }
}
