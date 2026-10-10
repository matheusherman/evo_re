package t3;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.taobao.sophix.PatchStatus;
import h3.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e[] f18887h = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f18893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18894g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18896b;

        /* synthetic */ b(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        private b(int i10, int i11) {
            this.f18895a = i10;
            this.f18896b = i11;
        }

        int a() {
            return this.f18895a;
        }

        int b() {
            return this.f18896b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f18898b;

        /* synthetic */ c(int i10, b bVar, a aVar) {
            this(i10, bVar);
        }

        /* synthetic */ c(int i10, b bVar, b bVar2, a aVar) {
            this(i10, bVar, bVar2);
        }

        b[] a() {
            return this.f18898b;
        }

        int b() {
            return this.f18897a;
        }

        private c(int i10, b bVar) {
            this.f18897a = i10;
            this.f18898b = new b[]{bVar};
        }

        private c(int i10, b bVar, b bVar2) {
            this.f18897a = i10;
            this.f18898b = new b[]{bVar, bVar2};
        }
    }

    private static e[] a() {
        int i10 = 1;
        a aVar = null;
        int i11 = 5;
        e eVar = new e(1, 10, 10, 8, 8, new c(i11, new b(i10, 3, aVar), aVar));
        e eVar2 = new e(2, 12, 12, 10, 10, new c(7, new b(i10, i11, aVar), aVar));
        e eVar3 = new e(3, 14, 14, 12, 12, new c(10, new b(i10, 8, aVar), aVar));
        int i12 = 12;
        e eVar4 = new e(4, 16, 16, 14, 14, new c(i12, new b(i10, i12, aVar), aVar));
        e eVar5 = new e(5, 18, 18, 16, 16, new c(14, new b(i10, 18, aVar), aVar));
        e eVar6 = new e(6, 20, 20, 18, 18, new c(18, new b(i10, 22, aVar), aVar));
        e eVar7 = new e(7, 22, 22, 20, 20, new c(20, new b(i10, 30, aVar), aVar));
        int i13 = 36;
        e eVar8 = new e(8, 24, 24, 22, 22, new c(24, new b(i10, i13, aVar), aVar));
        e eVar9 = new e(9, 26, 26, 24, 24, new c(28, new b(i10, 44, aVar), aVar));
        e eVar10 = new e(10, 32, 32, 14, 14, new c(i13, new b(i10, 62, aVar), aVar));
        int i14 = 42;
        e eVar11 = new e(11, 36, 36, 16, 16, new c(i14, new b(i10, 86, aVar), aVar));
        int i15 = 114;
        int i16 = 48;
        e eVar12 = new e(12, 40, 40, 18, 18, new c(i16, new b(i10, i15, aVar), aVar));
        int i17 = 144;
        int i18 = 56;
        e eVar13 = new e(13, 44, 44, 20, 20, new c(i18, new b(i10, i17, aVar), aVar));
        e eVar14 = new e(14, 48, 48, 22, 22, new c(68, new b(i10, 174, aVar), aVar));
        int i19 = 2;
        e eVar15 = new e(15, 52, 52, 24, 24, new c(i14, new b(i19, 102, aVar), aVar));
        e eVar16 = new e(16, 64, 64, 14, 14, new c(i18, new b(i19, ModuleDescriptor.MODULE_VERSION, aVar), aVar));
        int i20 = 4;
        e eVar17 = new e(17, 72, 72, 16, 16, new c(i13, new b(i20, 92, aVar), aVar));
        e eVar18 = new e(18, 80, 80, 18, 18, new c(i16, new b(i20, i15, aVar), aVar));
        e eVar19 = new e(19, 88, 88, 20, 20, new c(i18, new b(i20, i17, aVar), aVar));
        e eVar20 = new e(20, 96, 96, 22, 22, new c(68, new b(i20, 174, aVar), aVar));
        int i21 = 6;
        e eVar21 = new e(21, 104, 104, 24, 24, new c(i18, new b(i21, 136, aVar), aVar));
        e eVar22 = new e(22, 120, 120, 18, 18, new c(68, new b(i21, 175, aVar), aVar));
        e eVar23 = new e(23, PatchStatus.CODE_LOAD_LIB_CPUABIS, PatchStatus.CODE_LOAD_LIB_CPUABIS, 20, 20, new c(62, new b(8, 163, aVar), aVar));
        e eVar24 = new e(24, 144, 144, 22, 22, new c(62, new b(8, 156, aVar), new b(i19, 155, aVar), aVar));
        int i22 = 1;
        e eVar25 = new e(25, 8, 18, 6, 16, new c(7, new b(i22, 5, aVar), aVar));
        e eVar26 = new e(26, 8, 32, 6, 14, new c(11, new b(i22, 10, aVar), aVar));
        int i23 = 1;
        e eVar27 = new e(27, 12, 26, 10, 24, new c(14, new b(i23, 16, aVar), aVar));
        e eVar28 = new e(28, 12, 36, 10, 16, new c(18, new b(i23, 22, aVar), aVar));
        int i24 = 32;
        e eVar29 = new e(29, 16, 36, 14, 16, new c(24, new b(1, i24, aVar), aVar));
        int i25 = 1;
        e eVar30 = new e(30, 16, 48, 14, 22, new c(28, new b(i25, 49, aVar), aVar));
        e eVar31 = new e(31, 8, 48, 6, 22, new c(15, new b(i25, 18, aVar), aVar));
        int i26 = 1;
        e eVar32 = new e(32, 8, 64, 6, 14, new c(18, new b(i26, 24, aVar), aVar));
        e eVar33 = new e(33, 8, 80, 6, 18, new c(22, new b(i26, i24, aVar), aVar));
        int i27 = 38;
        int i28 = 1;
        return new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar12, eVar13, eVar14, eVar15, eVar16, eVar17, eVar18, eVar19, eVar20, eVar21, eVar22, eVar23, eVar24, eVar25, eVar26, eVar27, eVar28, eVar29, eVar30, eVar31, eVar32, eVar33, new e(34, 8, 96, 6, 22, new c(28, new b(1, i27, aVar), aVar)), new e(35, 8, 120, 6, 18, new c(i24, new b(1, 49, aVar), aVar)), new e(36, 8, 144, 6, 22, new c(i13, new b(1, 63, aVar), aVar)), new e(37, 12, 64, 10, 14, new c(27, new b(1, 43, aVar), aVar)), new e(38, 12, 88, 10, 20, new c(i13, new b(i28, 64, aVar), aVar)), new e(39, 16, 64, 14, 14, new c(i13, new b(i28, 62, aVar), aVar)), new e(40, 20, 36, 18, 16, new c(28, new b(i28, 44, aVar), aVar)), new e(41, 20, 44, 18, 20, new c(34, new b(i28, i18, aVar), aVar)), new e(42, 20, 64, 18, 14, new c(42, new b(1, 84, aVar), aVar)), new e(43, 22, 48, 20, 22, new c(i27, new b(1, 72, aVar), aVar)), new e(44, 24, 48, 22, 22, new c(41, new b(1, 80, aVar), aVar)), new e(45, 24, 64, 22, 14, new c(46, new b(1, 108, aVar), aVar)), new e(46, 26, 40, 24, 18, new c(i27, new b(1, 70, aVar), aVar)), new e(47, 26, 48, 24, 22, new c(42, new b(1, 90, aVar), aVar)), new e(48, 26, 64, 24, 14, new c(50, new b(1, 118, aVar), aVar))};
    }

    public static e h(int i10, int i11) throws h {
        if ((i10 & 1) != 0 || (i11 & 1) != 0) {
            throw h.a();
        }
        for (e eVar : f18887h) {
            if (eVar.f18889b == i10 && eVar.f18890c == i11) {
                return eVar;
            }
        }
        throw h.a();
    }

    public int b() {
        return this.f18892e;
    }

    public int c() {
        return this.f18891d;
    }

    c d() {
        return this.f18893f;
    }

    public int e() {
        return this.f18890c;
    }

    public int f() {
        return this.f18889b;
    }

    public int g() {
        return this.f18894g;
    }

    public int i() {
        return this.f18888a;
    }

    public String toString() {
        return String.valueOf(this.f18888a);
    }

    private e(int i10, int i11, int i12, int i13, int i14, c cVar) {
        this.f18888a = i10;
        this.f18889b = i11;
        this.f18890c = i12;
        this.f18891d = i13;
        this.f18892e = i14;
        this.f18893f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f18894g = iA;
    }
}
