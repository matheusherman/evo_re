package nd;

import com.taobao.sophix.PatchStatus;
import fc.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f16358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f16359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f16360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f16361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Object, e> f16362l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u f16369g;

    static class a extends HashMap<Object, e> {
        a() {
            e eVar = e.f16358h;
            put(Integer.valueOf(eVar.f16363a), eVar);
            e eVar2 = e.f16359i;
            put(Integer.valueOf(eVar2.f16363a), eVar2);
            e eVar3 = e.f16360j;
            put(Integer.valueOf(eVar3.f16363a), eVar3);
            e eVar4 = e.f16361k;
            put(Integer.valueOf(eVar4.f16363a), eVar4);
        }
    }

    static {
        u uVar = nc.a.f16308c;
        f16358h = new e(1, 32, 1, 265, 7, 8516, uVar);
        f16359i = new e(2, 32, 2, PatchStatus.CODE_LOAD_LIB_JSON, 6, 4292, uVar);
        f16360j = new e(3, 32, 4, 67, 4, 2180, uVar);
        f16361k = new e(4, 32, 8, 34, 0, 1124, uVar);
        f16362l = new a();
    }

    public static e e(int i10) {
        return f16362l.get(Integer.valueOf(i10));
    }

    public u b() {
        return this.f16369g;
    }

    public int c() {
        return this.f16364b;
    }

    public int d() {
        return this.f16366d;
    }

    public int f() {
        return this.f16363a;
    }

    public int g() {
        return this.f16365c;
    }

    protected e(int i10, int i11, int i12, int i13, int i14, int i15, u uVar) {
        this.f16363a = i10;
        this.f16364b = i11;
        this.f16365c = i12;
        this.f16366d = i13;
        this.f16367e = i14;
        this.f16368f = i15;
        this.f16369g = uVar;
    }
}
