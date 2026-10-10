package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.i0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.resolve.f> f13932e = r.O0(ServiceLoader.load(kotlin.reflect.jvm.internal.impl.resolve.f.class, kotlin.reflect.jvm.internal.impl.resolve.f.class.getClassLoader()));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f13933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.types.checker.e.a f13934g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f13935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.f f13936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.e.a f13937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c9.p<g0, g0, Boolean> f13938d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements kotlin.reflect.jvm.internal.impl.types.checker.e.a {
        private static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
        public boolean a(g1 g1Var, g1 g1Var2) {
            if (g1Var == null) {
                b(0);
            }
            if (g1Var2 == null) {
                b(1);
            }
            return g1Var.equals(g1Var2);
        }

        a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b<D> implements c9.p<D, D, r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lr8/p<Lkotlin/reflect/jvm/internal/impl/descriptors/a;Lkotlin/reflect/jvm/internal/impl/descriptors/a;>; */
        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r8.p invoke(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            return new r8.p(aVar, aVar2);
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.m f13939a;

        c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            this.f13939a = mVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z10;
            if (bVar.b() == this.f13939a) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class e implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f13940a;

        e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            this.f13940a = eVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z10 = false;
            if (!t.g(bVar.getVisibility()) && t.h(bVar, this.f13940a, false)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class g implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f13941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b f13942b;

        g(j jVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f13941a = jVar;
            this.f13942b = bVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f13941a.b(this.f13942b, bVar);
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final i f13946c = new i(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f13947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13948b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? 3 : 2];
            if (i10 == 1 || i10 == 2) {
                objArr[0] = "debugMessage";
            } else if (i10 == 3) {
                objArr[0] = "success";
            } else if (i10 != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            } else {
                objArr[0] = "debugMessage";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i10 == 1) {
                objArr[2] = "incompatible";
            } else if (i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        public i(a aVar, String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f13947a = aVar;
            this.f13948b = str;
        }

        public static i b(String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        public static i d(String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        public static i e() {
            i iVar = f13946c;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        public a c() {
            a aVar = this.f13947a;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class d implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        d() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.b invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class f implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        f() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f13945c;

        static {
            int[] iArr = new int[e0.values().length];
            f13945c = iArr;
            try {
                iArr[e0.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13945c[e0.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13945c[e0.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13945c[e0.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            f13944b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13944b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13944b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[kotlin.reflect.jvm.internal.impl.resolve.f.b.values().length];
            f13943a = iArr3;
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.resolve.f.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13943a[kotlin.reflect.jvm.internal.impl.resolve.f.b.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13943a[kotlin.reflect.jvm.internal.impl.resolve.f.b.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13943a[kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        a aVar = new a();
        f13934g = aVar;
        f13933f = new k(aVar, kotlin.reflect.jvm.internal.impl.types.checker.g.a.f14237a, kotlin.reflect.jvm.internal.impl.types.checker.f.a.f14236a, null);
    }

    private k(kotlin.reflect.jvm.internal.impl.types.checker.e.a aVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, kotlin.reflect.jvm.internal.impl.types.checker.f fVar, c9.p<g0, g0, Boolean> pVar) {
        if (aVar == null) {
            a(5);
        }
        if (gVar == null) {
            a(6);
        }
        if (fVar == null) {
            a(7);
        }
        this.f13937c = aVar;
        this.f13935a = gVar;
        this.f13936b = fVar;
        this.f13938d = pVar;
    }

    private static boolean A(t0 t0Var, t0 t0Var2) {
        if (t0Var == null || t0Var2 == null) {
            return true;
        }
        return H(t0Var, t0Var2);
    }

    public static boolean B(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if (aVar == null) {
            a(67);
        }
        if (aVar2 == null) {
            a(68);
        }
        g0 returnType = aVar.getReturnType();
        g0 returnType2 = aVar2.getReturnType();
        if (!H(aVar, aVar2)) {
            return false;
        }
        f1 f1VarL = f13933f.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof y) {
            return G(aVar, returnType, aVar2, returnType2, f1VarL);
        }
        if (!(aVar instanceof u0)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        u0 u0Var = (u0) aVar;
        u0 u0Var2 = (u0) aVar2;
        if (!A(u0Var.getSetter(), u0Var2.getSetter())) {
            return false;
        }
        if (u0Var.f0() && u0Var2.f0()) {
            return kotlin.reflect.jvm.internal.impl.types.f.f14277a.k(f1VarL, returnType.M0(), returnType2.M0());
        }
        return (u0Var.f0() || !u0Var2.f0()) && G(aVar, returnType, aVar2, returnType2, f1VarL);
    }

    private static boolean C(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        if (aVar == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!B(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean G(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, g0 g0Var2, f1 f1Var) {
        if (aVar == null) {
            a(73);
        }
        if (g0Var == null) {
            a(74);
        }
        if (aVar2 == null) {
            a(75);
        }
        if (g0Var2 == null) {
            a(76);
        }
        if (f1Var == null) {
            a(77);
        }
        return kotlin.reflect.jvm.internal.impl.types.f.f14277a.r(f1Var, g0Var.M0(), g0Var2.M0());
    }

    private static boolean H(kotlin.reflect.jvm.internal.impl.descriptors.q qVar, kotlin.reflect.jvm.internal.impl.descriptors.q qVar2) {
        if (qVar == null) {
            a(69);
        }
        if (qVar2 == null) {
            a(70);
        }
        Integer numD = t.d(qVar.getVisibility(), qVar2.getVisibility());
        return numD == null || numD.intValue() >= 0;
    }

    public static boolean I(d0 d0Var, d0 d0Var2, boolean z10) {
        if (d0Var == null) {
            a(57);
        }
        if (d0Var2 == null) {
            a(58);
        }
        return !t.g(d0Var2.getVisibility()) && t.h(d0Var2, d0Var, z10);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean J(D d10, D d11, boolean z10, boolean z11) {
        if (d10 == null) {
            a(13);
        }
        if (d11 == null) {
            a(14);
        }
        if (!d10.equals(d11) && kotlin.reflect.jvm.internal.impl.resolve.c.f13885a.f(d10.a(), d11.a(), z10, z11)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = d11.a();
        Iterator it = kotlin.reflect.jvm.internal.impl.resolve.e.d(d10).iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.jvm.internal.impl.resolve.c.f13885a.f(aVarA, (kotlin.reflect.jvm.internal.impl.descriptors.a) it.next(), z10, z11)) {
                return true;
            }
        }
        return false;
    }

    public static void K(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, z> lVar) {
        u uVar;
        if (bVar == null) {
            a(107);
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : bVar.e()) {
            if (bVar2.getVisibility() == t.f13070g) {
                K(bVar2, lVar);
            }
        }
        if (bVar.getVisibility() != t.f13070g) {
            return;
        }
        u uVarH = h(bVar);
        if (uVarH == null) {
            if (lVar != null) {
                lVar.invoke(bVar);
            }
            uVar = t.f13068e;
        } else {
            uVar = uVarH;
        }
        if (bVar instanceof c0) {
            ((c0) bVar).Y0(uVar);
            Iterator<t0> it = ((u0) bVar).s().iterator();
            while (it.hasNext()) {
                K(it.next(), uVarH == null ? null : lVar);
            }
            return;
        }
        if (bVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.p) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.p) bVar).f1(uVar);
            return;
        }
        b0 b0Var = (b0) bVar;
        b0Var.K0(uVar);
        if (uVar != b0Var.x0().getVisibility()) {
            b0Var.I0(false);
        }
    }

    public static <H> H L(Collection<H> collection, c9.l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> lVar) {
        H h10;
        if (collection == null) {
            a(78);
        }
        if (lVar == null) {
            a(79);
        }
        if (collection.size() == 1) {
            H h11 = (H) r.f0(collection);
            if (h11 == null) {
                a(80);
            }
            return h11;
        }
        ArrayList arrayList = new ArrayList(2);
        List listV0 = r.v0(collection, lVar);
        H h12 = (H) r.f0(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = lVar.invoke(h12);
        for (H h13 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke2 = lVar.invoke(h13);
            if (C(aVarInvoke2, listV0)) {
                arrayList.add(h13);
            }
            if (B(aVarInvoke2, aVarInvoke) && !B(aVarInvoke, aVarInvoke2)) {
                h12 = h13;
            }
        }
        if (arrayList.isEmpty()) {
            if (h12 == null) {
                a(81);
            }
            return h12;
        }
        if (arrayList.size() == 1) {
            H h14 = (H) r.f0(arrayList);
            if (h14 == null) {
                a(82);
            }
            return h14;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                h10 = null;
                break;
            }
            h10 = (H) it.next();
        } while (kotlin.reflect.jvm.internal.impl.types.d0.b(lVar.invoke(h10).getReturnType()));
        if (h10 != null) {
            return h10;
        }
        H h15 = (H) r.f0(arrayList);
        if (h15 == null) {
            a(84);
        }
        return h15;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[FALL_THROUGH] */
    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 11 && i10 != 12 && i10 != 16 && i10 != 21 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 11 && i10 != 12 && i10 != 16 && i10 != 21 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            i11 = 3;
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    i11 = 2;
                                    break;
                            }
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            i11 = 2;
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    i11 = 2;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 7:
                objArr[0] = "kotlinTypePreparator";
                break;
            case 2:
                objArr[0] = "customSubtype";
                break;
            case 3:
            case 6:
            default:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 4:
                objArr[0] = "equalityAxioms";
                break;
            case 5:
                objArr[0] = "axioms";
                break;
            case 8:
            case 9:
                objArr[0] = "candidateSet";
                break;
            case 10:
                objArr[0] = "transformFirst";
                break;
            case 11:
            case 12:
            case 16:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case 91:
            case 92:
            case 95:
            case 98:
            case 103:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 13:
                objArr[0] = "f";
                break;
            case 14:
                objArr[0] = "g";
                break;
            case 15:
            case 17:
                objArr[0] = "descriptor";
                break;
            case 18:
                objArr[0] = "result";
                break;
            case 19:
            case 22:
            case 30:
            case 40:
                objArr[0] = "superDescriptor";
                break;
            case 20:
            case 23:
            case 31:
            case 41:
                objArr[0] = "subDescriptor";
                break;
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 46:
                objArr[0] = "typeInSuper";
                break;
            case 47:
                objArr[0] = "typeInSub";
                break;
            case 48:
            case 51:
            case 77:
                objArr[0] = "typeCheckerState";
                break;
            case 49:
                objArr[0] = "superTypeParameter";
                break;
            case 50:
                objArr[0] = "subTypeParameter";
                break;
            case 52:
                objArr[0] = "name";
                break;
            case 53:
                objArr[0] = "membersFromSupertypes";
                break;
            case 54:
                objArr[0] = "membersFromCurrent";
                break;
            case 55:
            case 61:
            case 64:
            case 86:
            case 89:
            case 96:
                objArr[0] = "current";
                break;
            case 56:
            case 62:
            case 66:
            case 87:
            case 106:
                objArr[0] = "strategy";
                break;
            case 57:
                objArr[0] = "overriding";
                break;
            case 58:
                objArr[0] = "fromSuper";
                break;
            case 59:
                objArr[0] = "fromCurrent";
                break;
            case 60:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 63:
            case 65:
                objArr[0] = "notOverridden";
                break;
            case 67:
            case 69:
            case 73:
                objArr[0] = "a";
                break;
            case 68:
            case 70:
            case 75:
                objArr[0] = "b";
                break;
            case 71:
                objArr[0] = "candidate";
                break;
            case 72:
            case 88:
            case 93:
            case 109:
                objArr[0] = "descriptors";
                break;
            case 74:
                objArr[0] = "aReturnType";
                break;
            case 76:
                objArr[0] = "bReturnType";
                break;
            case 78:
            case 85:
                objArr[0] = "overridables";
                break;
            case 79:
            case 101:
                objArr[0] = "descriptorByHandle";
                break;
            case 94:
                objArr[0] = "classModality";
                break;
            case 97:
                objArr[0] = "toFilter";
                break;
            case 99:
            case 104:
                objArr[0] = "overrider";
                break;
            case 100:
            case 105:
                objArr[0] = "extractFrom";
                break;
            case 102:
                objArr[0] = "onConflict";
                break;
            case 107:
            case 108:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i10 == 11 || i10 == 12) {
            objArr[1] = "filterOverrides";
        } else if (i10 == 16) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i10 == 21) {
            objArr[1] = "isOverridableBy";
        } else if (i10 == 95) {
            objArr[1] = "getMinimalModality";
        } else if (i10 == 98) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i10 == 103) {
            objArr[1] = "extractMembersOverridableInBothWays";
        } else if (i10 != 44 && i10 != 45) {
            switch (i10) {
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    objArr[1] = "isOverridableBy";
                    break;
                default:
                    switch (i10) {
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i10) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i10) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "createTypeCheckerState";
        }
        switch (i10) {
            case 1:
            case 2:
                objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                break;
            case 3:
            case 4:
                objArr[2] = "create";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "<init>";
                break;
            case 8:
                objArr[2] = "filterOutOverridden";
                break;
            case 9:
            case 10:
                objArr[2] = "filterOverrides";
                break;
            case 11:
            case 12:
            case 16:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case 91:
            case 92:
            case 95:
            case 98:
            case 103:
                break;
            case 13:
            case 14:
                objArr[2] = "overrides";
                break;
            case 15:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 17:
            case 18:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 19:
            case 20:
            case 22:
            case 23:
                objArr[2] = "isOverridableBy";
                break;
            case 30:
            case 31:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 40:
            case 41:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerState";
                break;
            case 46:
            case 47:
            case 48:
                objArr[2] = "areTypesEquivalent";
                break;
            case 49:
            case 50:
            case 51:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 57:
            case 58:
                objArr[2] = "isVisibleForOverride";
                break;
            case 59:
            case 60:
            case 61:
            case 62:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 63:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 64:
            case 65:
            case 66:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 67:
            case 68:
                objArr[2] = "isMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 71:
            case 72:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 78:
            case 79:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 85:
            case 86:
            case 87:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 88:
            case 89:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 93:
            case 94:
                objArr[2] = "getMinimalModality";
                break;
            case 96:
            case 97:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 104:
            case 105:
            case 106:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 107:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 108:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 109:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithTypeRefiner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 11 && i10 != 12 && i10 != 16 && i10 != 21 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    break;
                default:
                    switch (i10) {
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            break;
                        default:
                            switch (i10) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    break;
                                default:
                                    switch (i10) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    private static boolean b(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        return r.Y(collection, new c(collection.iterator().next().b()));
    }

    private static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var2, f1 f1Var3) {
        if (f1Var == null) {
            a(49);
        }
        if (f1Var2 == null) {
            a(50);
        }
        if (f1Var3 == null) {
            a(51);
        }
        List<g0> upperBounds = f1Var.getUpperBounds();
        ArrayList arrayList = new ArrayList(f1Var2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (g0 g0Var : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (d(g0Var, (g0) listIterator.next(), f1Var3)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    private static boolean d(g0 g0Var, g0 g0Var2, f1 f1Var) {
        if (g0Var == null) {
            a(46);
        }
        if (g0Var2 == null) {
            a(47);
        }
        if (f1Var == null) {
            a(48);
        }
        if (i0.a(g0Var) && i0.a(g0Var2)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.types.f.f14277a.k(f1Var, g0Var.M0(), g0Var2.M0());
    }

    private static void f(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Set<kotlin.reflect.jvm.internal.impl.descriptors.b> set) {
        if (bVar == null) {
            a(17);
        }
        if (set == null) {
            a(18);
        }
        if (bVar.g().a()) {
            set.add(bVar);
            return;
        }
        if (bVar.e().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = bVar.e().iterator();
        while (it.hasNext()) {
            f(it.next(), set);
        }
    }

    private static u h(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (bVar == null) {
            a(108);
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collectionE = bVar.e();
        u uVarU = u(collectionE);
        if (uVarU == null) {
            return null;
        }
        if (bVar.g() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
            return uVarU.f();
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : collectionE) {
            if (bVar2.i() != e0.ABSTRACT && !bVar2.getVisibility().equals(uVarU)) {
                return null;
            }
        }
        return uVarU;
    }

    public static k i(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, kotlin.reflect.jvm.internal.impl.types.checker.e.a aVar) {
        if (gVar == null) {
            a(3);
        }
        if (aVar == null) {
            a(4);
        }
        return new k(aVar, gVar, kotlin.reflect.jvm.internal.impl.types.checker.f.a.f14236a, null);
    }

    private static void j(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, j jVar) {
        if (collection == null) {
            a(85);
        }
        if (eVar == null) {
            a(86);
        }
        if (jVar == null) {
            a(87);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionT = t(eVar, collection);
        boolean zIsEmpty = collectionT.isEmpty();
        if (!zIsEmpty) {
            collection = collectionT;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarG0 = ((kotlin.reflect.jvm.internal.impl.descriptors.b) L(collection, new d())).g0(eVar, n(collection, eVar), zIsEmpty ? t.f13071h : t.f13070g, kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE, false);
        jVar.d(bVarG0, collection);
        jVar.a(bVarG0);
    }

    private static void k(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, j jVar) {
        if (eVar == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (jVar == null) {
            a(66);
        }
        if (b(collection)) {
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton(it.next()), eVar, jVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(q(q.a(linkedList), linkedList, jVar), eVar, jVar);
            }
        }
    }

    private f1 l(List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list, List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            f1 f1VarI0 = new l(null, this.f13937c, this.f13935a, this.f13936b, this.f13938d).I0(true, true);
            if (f1VarI0 == null) {
                a(44);
            }
            return f1VarI0;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.put(list.get(i10).h(), list2.get(i10).h());
        }
        f1 f1VarI1 = new l(map, this.f13937c, this.f13935a, this.f13936b, this.f13938d).I0(true, true);
        if (f1VarI1 == null) {
            a(45);
        }
        return f1VarI1;
    }

    public static k m(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            a(0);
        }
        return new k(f13934g, gVar, kotlin.reflect.jvm.internal.impl.types.checker.f.a.f14236a, null);
    }

    private static e0 n(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (collection == null) {
            a(88);
        }
        if (eVar == null) {
            a(89);
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collection) {
            int i10 = h.f13945c[bVar.i().ordinal()];
            if (i10 == 1) {
                e0 e0Var = e0.FINAL;
                if (e0Var == null) {
                    a(90);
                }
                return e0Var;
            }
            if (i10 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + bVar);
            }
            if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (eVar.I() && eVar.i() != e0.ABSTRACT && eVar.i() != e0.SEALED) {
            z10 = true;
        }
        if (z11 && !z12) {
            e0 e0Var2 = e0.OPEN;
            if (e0Var2 == null) {
                a(91);
            }
            return e0Var2;
        }
        if (!z11 && z12) {
            e0 e0VarI = z10 ? eVar.i() : e0.ABSTRACT;
            if (e0VarI == null) {
                a(92);
            }
            return e0VarI;
        }
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(z(it.next()));
        }
        return y(r(hashSet), z10, eVar.i());
    }

    private Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> o(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, j jVar) {
        if (bVar == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (eVar == null) {
            a(61);
        }
        if (jVar == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        sa.g gVarE = sa.g.e();
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : collection) {
            i.a aVarC = D(bVar2, bVar, eVar).c();
            boolean zI = I(bVar, bVar2, false);
            int i10 = h.f13944b[aVarC.ordinal()];
            if (i10 == 1) {
                if (zI) {
                    gVarE.add(bVar2);
                }
                arrayList.add(bVar2);
            } else if (i10 == 2) {
                if (zI) {
                    jVar.c(bVar2, bVar);
                }
                arrayList.add(bVar2);
            }
        }
        jVar.d(bVar, gVarE);
        return arrayList;
    }

    public static <H> Collection<H> p(H h10, Collection<H> collection, c9.l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> lVar, c9.l<H, z> lVar2) {
        if (h10 == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (lVar == null) {
            a(101);
        }
        if (lVar2 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h10);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = lVar.invoke(h10);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke2 = lVar.invoke(next);
            if (h10 == next) {
                it.remove();
            } else {
                i.a aVarX = x(aVarInvoke, aVarInvoke2);
                if (aVarX == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (aVarX == i.a.CONFLICT) {
                    lVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> q(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Queue<kotlin.reflect.jvm.internal.impl.descriptors.b> queue, j jVar) {
        if (bVar == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (jVar == null) {
            a(106);
        }
        return p(bVar, queue, new f(), new g(jVar, bVar));
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> r(Set<D> set) {
        if (set == null) {
            a(8);
        }
        return s(set, !set.isEmpty() && ea.c.u(ea.c.p(set.iterator().next())), null, new b());
    }

    public static <D> Set<D> s(Set<D> set, boolean z10, c9.a<?> aVar, c9.p<? super D, ? super D, r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> pVar) {
        if (set == null) {
            a(9);
        }
        if (pVar == null) {
            a(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (aVar != null) {
                aVar.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> pVarInvoke = pVar.invoke(obj, (Object) it.next());
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = pVarInvoke.a();
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarB = pVarInvoke.b();
                if (!J(aVarA, aVarB, z10, true)) {
                    if (J(aVarB, aVarA, z10, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> t(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (eVar == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        List listE0 = r.e0(collection, new e(eVar));
        if (listE0 == null) {
            a(98);
        }
        return listE0;
    }

    public static u u(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        u uVar;
        if (collection == null) {
            a(109);
        }
        if (collection.isEmpty()) {
            return t.f13075l;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                u visibility = it.next().getVisibility();
                if (uVar != null) {
                    Integer numD = t.d(visibility, uVar);
                    if (numD == null) {
                        break;
                    }
                    if (numD.intValue() > 0) {
                    }
                }
                uVar = visibility;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numD2 = t.d(uVar, it2.next().getVisibility());
            if (numD2 == null || numD2.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    public static i w(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z10;
        if (aVar == null) {
            a(40);
        }
        if (aVar2 == null) {
            a(41);
        }
        boolean z11 = aVar instanceof y;
        if ((z11 && !(aVar2 instanceof y)) || (((z10 = aVar instanceof u0)) && !(aVar2 instanceof u0))) {
            return i.d("Member kind mismatch");
        }
        if (!z11 && !z10) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return i.d("Name mismatch");
        }
        i iVarE = e(aVar, aVar2);
        if (iVarE != null) {
            return iVarE;
        }
        return null;
    }

    public static i.a x(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        k kVar = f13933f;
        i.a aVarC = kVar.D(aVar2, aVar, null).c();
        i.a aVarC2 = kVar.D(aVar, aVar2, null).c();
        i.a aVar3 = i.a.OVERRIDABLE;
        if (aVarC == aVar3 && aVarC2 == aVar3) {
            return aVar3;
        }
        i.a aVar4 = i.a.CONFLICT;
        return (aVarC == aVar4 || aVarC2 == aVar4) ? aVar4 : i.a.INCOMPATIBLE;
    }

    private static e0 y(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, boolean z10, e0 e0Var) {
        if (collection == null) {
            a(93);
        }
        if (e0Var == null) {
            a(94);
        }
        e0 e0Var2 = e0.ABSTRACT;
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collection) {
            e0 e0VarI = (z10 && bVar.i() == e0.ABSTRACT) ? e0Var : bVar.i();
            if (e0VarI.compareTo(e0Var2) < 0) {
                e0Var2 = e0VarI;
            }
        }
        if (e0Var2 == null) {
            a(95);
        }
        return e0Var2;
    }

    public static Set<kotlin.reflect.jvm.internal.impl.descriptors.b> z(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (bVar == null) {
            a(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(bVar, linkedHashSet);
        return linkedHashSet;
    }

    public i D(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (aVar == null) {
            a(19);
        }
        if (aVar2 == null) {
            a(20);
        }
        i iVarE = E(aVar, aVar2, eVar, false);
        if (iVarE == null) {
            a(21);
        }
        return iVarE;
    }

    public i E(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, boolean z10) {
        if (aVar == null) {
            a(22);
        }
        if (aVar2 == null) {
            a(23);
        }
        i iVarF = F(aVar, aVar2, z10);
        boolean z11 = iVarF.c() == i.a.OVERRIDABLE;
        for (kotlin.reflect.jvm.internal.impl.resolve.f fVar : f13932e) {
            if (fVar.a() != kotlin.reflect.jvm.internal.impl.resolve.f.a.CONFLICTS_ONLY && (!z11 || fVar.a() != kotlin.reflect.jvm.internal.impl.resolve.f.a.SUCCESS_ONLY)) {
                int i10 = h.f13943a[fVar.b(aVar, aVar2, eVar).ordinal()];
                if (i10 == 1) {
                    z11 = true;
                } else {
                    if (i10 == 2) {
                        i iVarB = i.b("External condition failed");
                        if (iVarB == null) {
                            a(24);
                        }
                        return iVarB;
                    }
                    if (i10 == 3) {
                        i iVarD = i.d("External condition");
                        if (iVarD == null) {
                            a(25);
                        }
                        return iVarD;
                    }
                }
            }
        }
        if (!z11) {
            return iVarF;
        }
        for (kotlin.reflect.jvm.internal.impl.resolve.f fVar2 : f13932e) {
            if (fVar2.a() == kotlin.reflect.jvm.internal.impl.resolve.f.a.CONFLICTS_ONLY) {
                int i11 = h.f13943a[fVar2.b(aVar, aVar2, eVar).ordinal()];
                if (i11 == 1) {
                    throw new IllegalStateException("Contract violation in " + fVar2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i11 == 2) {
                    i iVarB2 = i.b("External condition failed");
                    if (iVarB2 == null) {
                        a(27);
                    }
                    return iVarB2;
                }
                if (i11 == 3) {
                    i iVarD2 = i.d("External condition");
                    if (iVarD2 == null) {
                        a(28);
                    }
                    return iVarD2;
                }
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(29);
        }
        return iVarE;
    }

    public i F(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z10) {
        if (aVar == null) {
            a(30);
        }
        if (aVar2 == null) {
            a(31);
        }
        i iVarW = w(aVar, aVar2);
        if (iVarW != null) {
            return iVarW;
        }
        List<g0> listG = g(aVar);
        List<g0> listG2 = g(aVar2);
        List<kotlin.reflect.jvm.internal.impl.descriptors.f1> typeParameters = aVar.getTypeParameters();
        List<kotlin.reflect.jvm.internal.impl.descriptors.f1> typeParameters2 = aVar2.getTypeParameters();
        int i10 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i10 < listG.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a.b(listG.get(i10), listG2.get(i10))) {
                    i iVarD = i.d("Type parameter number mismatch");
                    if (iVarD == null) {
                        a(33);
                    }
                    return iVarD;
                }
                i10++;
            }
            i iVarB = i.b("Type parameter number mismatch");
            if (iVarB == null) {
                a(34);
            }
            return iVarB;
        }
        f1 f1VarL = l(typeParameters, typeParameters2);
        for (int i11 = 0; i11 < typeParameters.size(); i11++) {
            if (!c(typeParameters.get(i11), typeParameters2.get(i11), f1VarL)) {
                i iVarD2 = i.d("Type parameter bounds mismatch");
                if (iVarD2 == null) {
                    a(35);
                }
                return iVarD2;
            }
        }
        while (i10 < listG.size()) {
            if (!d(listG.get(i10), listG2.get(i10), f1VarL)) {
                i iVarD3 = i.d("Value parameter type mismatch");
                if (iVarD3 == null) {
                    a(36);
                }
                return iVarD3;
            }
            i10++;
        }
        if ((aVar instanceof y) && (aVar2 instanceof y) && ((y) aVar).isSuspend() != ((y) aVar2).isSuspend()) {
            i iVarB2 = i.b("Incompatible suspendability");
            if (iVarB2 == null) {
                a(37);
            }
            return iVarB2;
        }
        if (z10) {
            g0 returnType = aVar.getReturnType();
            g0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null && ((!i0.a(returnType2) || !i0.a(returnType)) && !kotlin.reflect.jvm.internal.impl.types.f.f14277a.r(f1VarL, returnType2.M0(), returnType.M0()))) {
                i iVarB3 = i.b("Return type mismatch");
                if (iVarB3 == null) {
                    a(38);
                }
                return iVarB3;
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(39);
        }
        return iVarE;
    }

    public void v(ba.f fVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, j jVar) {
        if (fVar == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (eVar == null) {
            a(55);
        }
        if (jVar == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(o(it.next(), collection, eVar, jVar));
        }
        k(eVar, linkedHashSet, jVar);
    }

    private static i e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z10;
        boolean z11 = false;
        if (aVar.i0() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (aVar2.i0() == null) {
            z11 = true;
        }
        if (z10 != z11) {
            return i.d("Receiver presence mismatch");
        }
        if (aVar.f().size() != aVar2.f().size()) {
            return i.d("Value parameter number mismatch");
        }
        return null;
    }

    private static List<g0> g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        x0 x0VarI0 = aVar.i0();
        ArrayList arrayList = new ArrayList();
        if (x0VarI0 != null) {
            arrayList.add(x0VarI0.getType());
        }
        Iterator<j1> it = aVar.f().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }
}
