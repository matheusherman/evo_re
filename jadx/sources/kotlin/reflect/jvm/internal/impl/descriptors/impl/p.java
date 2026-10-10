package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class p extends k implements kotlin.reflect.jvm.internal.impl.descriptors.y {
    private final kotlin.reflect.jvm.internal.impl.descriptors.y A;
    private final kotlin.reflect.jvm.internal.impl.descriptors.b.a B;
    private kotlin.reflect.jvm.internal.impl.descriptors.y C;
    protected Map<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<f1> f12885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<j1> f12886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.g0 f12887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<x0> f12888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private x0 f12889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x0 f12890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.e0 f12891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.u f12892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f12895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f12896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f12897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f12898r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f12899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f12900t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f12901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f12902v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f12903w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f12904x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> f12905y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile c9.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> f12906z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p1 f12907a;

        a(p1 p1Var) {
            this.f12907a = p1Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> invoke() {
            sa.f fVar = new sa.f();
            Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = p.this.e().iterator();
            while (it.hasNext()) {
                fVar.add(it.next().c(this.f12907a));
            }
            return fVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements c9.a<List<k1>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f12909a;

        b(List list) {
            this.f12909a = list;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<k1> invoke() {
            return this.f12909a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class c implements kotlin.reflect.jvm.internal.impl.descriptors.y.a<kotlin.reflect.jvm.internal.impl.descriptors.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected n1 f12910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.m f12911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.e0 f12912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.u f12913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.y f12914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.b.a f12915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected List<j1> f12916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected List<x0> f12917h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected x0 f12918i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected x0 f12919j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.types.g0 f12920k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        protected ba.f f12921l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        protected boolean f12922m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        protected boolean f12923n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        protected boolean f12924o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        protected boolean f12925p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f12926q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private List<f1> f12927r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f12928s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f12929t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Map<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> f12930u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Boolean f12931v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        protected boolean f12932w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ p f12933x;

        public c(p pVar, n1 n1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, List<j1> list, List<x0> list2, x0 x0Var, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, ba.f fVar) {
            if (n1Var == null) {
                u(0);
            }
            if (mVar == null) {
                u(1);
            }
            if (e0Var == null) {
                u(2);
            }
            if (uVar == null) {
                u(3);
            }
            if (aVar == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (list2 == null) {
                u(6);
            }
            if (g0Var == null) {
                u(7);
            }
            this.f12933x = pVar;
            this.f12914e = null;
            this.f12919j = pVar.f12890j;
            this.f12922m = true;
            this.f12923n = false;
            this.f12924o = false;
            this.f12925p = false;
            this.f12926q = pVar.s0();
            this.f12927r = null;
            this.f12928s = null;
            this.f12929t = pVar.y0();
            this.f12930u = new LinkedHashMap();
            this.f12931v = null;
            this.f12932w = false;
            this.f12910a = n1Var;
            this.f12911b = mVar;
            this.f12912c = e0Var;
            this.f12913d = uVar;
            this.f12915f = aVar;
            this.f12916g = list;
            this.f12917h = list2;
            this.f12918i = x0Var;
            this.f12920k = g0Var;
            this.f12921l = fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.f12925p = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public c h() {
            this.f12929t = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public c q() {
            this.f12926q = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public c e() {
            this.f12924o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f12923n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public c s(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
            if (gVar == null) {
                u(35);
            }
            this.f12928s = gVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public c i(boolean z10) {
            this.f12922m = z10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public c d(x0 x0Var) {
            this.f12919j = x0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c j(x0 x0Var) {
            this.f12918i = x0Var;
            return this;
        }

        public c J(boolean z10) {
            this.f12932w = z10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public c r(kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar) {
            if (aVar == null) {
                u(14);
            }
            this.f12915f = aVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public c c(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var) {
            if (e0Var == null) {
                u(10);
            }
            this.f12912c = e0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public c o(ba.f fVar) {
            if (fVar == null) {
                u(17);
            }
            this.f12921l = fVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public c g(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f12914e = (kotlin.reflect.jvm.internal.impl.descriptors.y) bVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public c p(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar == null) {
                u(8);
            }
            this.f12911b = mVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c f(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
            if (g0Var == null) {
                u(23);
            }
            this.f12920k = g0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public c k(n1 n1Var) {
            if (n1Var == null) {
                u(37);
            }
            this.f12910a = n1Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public c l(List<f1> list) {
            if (list == null) {
                u(21);
            }
            this.f12927r = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public c b(List<j1> list) {
            if (list == null) {
                u(19);
            }
            this.f12916g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public c n(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
            if (uVar == null) {
                u(12);
            }
            this.f12913d = uVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public kotlin.reflect.jvm.internal.impl.descriptors.y build() {
            return this.f12933x.I0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public <V> kotlin.reflect.jvm.internal.impl.descriptors.y.a<kotlin.reflect.jvm.internal.impl.descriptors.y> m(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a, V v10) {
            if (interfaceC0217a == null) {
                u(39);
            }
            this.f12930u.put(interfaceC0217a, v10);
            return this;
        }

        private static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i11 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i11 = 3;
                    break;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i10) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i10) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(str2);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        public c G(boolean z10) {
            this.f12931v = Boolean.valueOf(z10);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected p(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        super(mVar, gVar, fVar, a1Var);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (fVar == null) {
            C(2);
        }
        if (aVar == null) {
            C(3);
        }
        if (a1Var == null) {
            C(4);
        }
        this.f12892l = kotlin.reflect.jvm.internal.impl.descriptors.t.f13072i;
        this.f12893m = false;
        this.f12894n = false;
        this.f12895o = false;
        this.f12896p = false;
        this.f12897q = false;
        this.f12898r = false;
        this.f12899s = false;
        this.f12900t = false;
        this.f12901u = false;
        this.f12902v = false;
        this.f12903w = true;
        this.f12904x = false;
        this.f12905y = null;
        this.f12906z = null;
        this.C = null;
        this.D = null;
        this.A = yVar == null ? this : yVar;
        this.B = aVar;
    }

    protected abstract p H0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var);

    private a1 J0(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        a1 source;
        if (z10) {
            if (yVar == null) {
                yVar = a();
            }
            source = yVar.getSource();
        } else {
            source = a1.f12668a;
        }
        if (source == null) {
            C(27);
        }
        return source;
    }

    public static List<j1> K0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, List<j1> list, p1 p1Var) {
        if (list == null) {
            C(28);
        }
        if (p1Var == null) {
            C(29);
        }
        return L0(yVar, list, p1Var, false, false, null);
    }

    public static List<j1> L0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, List<j1> list, p1 p1Var, boolean z10, boolean z11, boolean[] zArr) {
        if (list == null) {
            C(30);
        }
        if (p1Var == null) {
            C(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (j1 j1Var : list) {
            kotlin.reflect.jvm.internal.impl.types.g0 type = j1Var.getType();
            w1 w1Var = w1.IN_VARIANCE;
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = p1Var.p(type, w1Var);
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarH0 = j1Var.h0();
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarP2 = g0VarH0 == null ? null : p1Var.p(g0VarH0, w1Var);
            if (g0VarP == null) {
                return null;
            }
            if ((g0VarP != j1Var.getType() || g0VarH0 != g0VarP2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(l0.G0(yVar, z10 ? null : j1Var, j1Var.getIndex(), j1Var.getAnnotations(), j1Var.getName(), g0VarP, j1Var.q0(), j1Var.X(), j1Var.T(), g0VarP2, z11 ? j1Var.getSource() : a1.f12668a, j1Var instanceof l0.b ? new b(((l0.b) j1Var).J0()) : null));
        }
        return arrayList;
    }

    private void P0() {
        c9.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> aVar = this.f12906z;
        if (aVar != null) {
            this.f12905y = aVar.invoke();
            this.f12906z = null;
        }
    }

    private void W0(boolean z10) {
        this.f12901u = z10;
    }

    private void X0(boolean z10) {
        this.f12900t = z10;
    }

    private void Z0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        this.C = yVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return this.f12904x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return this.f12899s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return this.f12898r;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.y I0(c cVar) {
        f0 f0Var;
        if (cVar == null) {
            C(25);
        }
        boolean[] zArr = new boolean[1];
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarA = cVar.f12928s != null ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(getAnnotations(), cVar.f12928s) : getAnnotations();
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = cVar.f12911b;
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar = cVar.f12914e;
        p pVarH0 = H0(mVar, yVar, cVar.f12915f, cVar.f12921l, gVarA, J0(cVar.f12924o, yVar));
        List<f1> typeParameters = cVar.f12927r == null ? getTypeParameters() : cVar.f12927r;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        p1 p1VarC = kotlin.reflect.jvm.internal.impl.types.t.c(typeParameters, cVar.f12910a, pVarH0, arrayList, zArr);
        x0 x0Var = null;
        if (p1VarC == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cVar.f12917h.isEmpty()) {
            int i10 = 0;
            for (x0 x0Var2 : cVar.f12917h) {
                kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = p1VarC.p(x0Var2.getType(), w1.IN_VARIANCE);
                if (g0VarP == null) {
                    return null;
                }
                int i11 = i10 + 1;
                arrayList2.add(kotlin.reflect.jvm.internal.impl.resolve.d.b(pVarH0, g0VarP, ((ha.f) x0Var2.getValue()).a(), x0Var2.getAnnotations(), i10));
                zArr[0] = zArr[0] | (g0VarP != x0Var2.getType());
                i10 = i11;
            }
        }
        x0 x0Var3 = cVar.f12918i;
        if (x0Var3 != null) {
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarP2 = p1VarC.p(x0Var3.getType(), w1.IN_VARIANCE);
            if (g0VarP2 == null) {
                return null;
            }
            f0 f0Var2 = new f0(pVarH0, new ha.d(pVarH0, g0VarP2, cVar.f12918i.getValue()), cVar.f12918i.getAnnotations());
            zArr[0] = (g0VarP2 != cVar.f12918i.getType()) | zArr[0];
            f0Var = f0Var2;
        } else {
            f0Var = null;
        }
        x0 x0Var4 = cVar.f12919j;
        if (x0Var4 != null) {
            x0 x0VarC = x0Var4.c(p1VarC);
            if (x0VarC == null) {
                return null;
            }
            zArr[0] = zArr[0] | (x0VarC != cVar.f12919j);
            x0Var = x0VarC;
        }
        List<j1> listL0 = L0(pVarH0, cVar.f12916g, p1VarC, cVar.f12925p, cVar.f12924o, zArr);
        if (listL0 == null) {
            return 0;
        }
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarP3 = p1VarC.p(cVar.f12920k, w1.OUT_VARIANCE);
        if (g0VarP3 == null) {
            return x0Var;
        }
        boolean z10 = zArr[0] | (g0VarP3 != cVar.f12920k);
        zArr[0] = z10;
        if (!z10 && cVar.f12932w) {
            return this;
        }
        pVarH0.N0(f0Var, x0Var, arrayList2, arrayList, listL0, g0VarP3, cVar.f12912c, cVar.f12913d);
        pVarH0.b1(this.f12893m);
        pVarH0.Y0(this.f12894n);
        pVarH0.T0(this.f12895o);
        pVarH0.a1(this.f12896p);
        pVarH0.e1(this.f12897q);
        pVarH0.d1(this.f12902v);
        pVarH0.S0(this.f12898r);
        pVarH0.R0(this.f12899s);
        pVarH0.U0(this.f12903w);
        pVarH0.X0(cVar.f12926q);
        pVarH0.W0(cVar.f12929t);
        pVarH0.V0(cVar.f12931v != null ? cVar.f12931v.booleanValue() : this.f12904x);
        if (!cVar.f12930u.isEmpty() || this.D != null) {
            Map<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> map = cVar.f12930u;
            Map<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> map2 = this.D;
            if (map2 != null) {
                for (Map.Entry<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                pVarH0.D = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                pVarH0.D = map;
            }
        }
        if (cVar.f12923n || Z() != null) {
            pVarH0.Z0((Z() != null ? Z() : this).c(p1VarC));
        }
        if (cVar.f12922m && !a().e().isEmpty()) {
            if (cVar.f12910a.f()) {
                c9.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.y>> aVar = this.f12906z;
                if (aVar != null) {
                    pVarH0.f12906z = aVar;
                    return pVarH0;
                }
                pVarH0.t0(e());
                return pVarH0;
            }
            pVarH0.f12906z = new a(p1VarC);
        }
        return pVarH0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean L() {
        return this.f12897q;
    }

    public boolean M0() {
        return this.f12903w;
    }

    public p N0(x0 x0Var, x0 x0Var2, List<x0> list, List<? extends f1> list2, List<j1> list3, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (list == null) {
            C(5);
        }
        if (list2 == null) {
            C(6);
        }
        if (list3 == null) {
            C(7);
        }
        if (uVar == null) {
            C(8);
        }
        this.f12885e = kotlin.collections.r.O0(list2);
        this.f12886f = kotlin.collections.r.O0(list3);
        this.f12887g = g0Var;
        this.f12891k = e0Var;
        this.f12892l = uVar;
        this.f12889i = x0Var;
        this.f12890j = x0Var2;
        this.f12888h = list;
        for (int i10 = 0; i10 < list2.size(); i10++) {
            f1 f1Var = list2.get(i10);
            if (f1Var.getIndex() != i10) {
                throw new IllegalStateException(f1Var + " index is " + f1Var.getIndex() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list3.size(); i11++) {
            j1 j1Var = list3.get(i11);
            if (j1Var.getIndex() != i11) {
                throw new IllegalStateException(j1Var + "index is " + j1Var.getIndex() + " but position is " + i11);
            }
        }
        return this;
    }

    protected c O0(p1 p1Var) {
        if (p1Var == null) {
            C(24);
        }
        return new c(this, p1Var.j(), b(), i(), getVisibility(), g(), f(), n0(), i0(), getReturnType(), null);
    }

    public <V> void Q0(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a, Object obj) {
        if (this.D == null) {
            this.D = new LinkedHashMap();
        }
        this.D.put(interfaceC0217a, obj);
    }

    public void R0(boolean z10) {
        this.f12899s = z10;
    }

    public void S0(boolean z10) {
        this.f12898r = z10;
    }

    public void T0(boolean z10) {
        this.f12895o = z10;
    }

    public void U0(boolean z10) {
        this.f12903w = z10;
    }

    public void V0(boolean z10) {
        this.f12904x = z10;
    }

    public void Y0(boolean z10) {
        this.f12894n = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public kotlin.reflect.jvm.internal.impl.descriptors.y Z() {
        return this.C;
    }

    public void a1(boolean z10) {
        this.f12896p = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 b0() {
        return this.f12890j;
    }

    public void b1(boolean z10) {
        this.f12893m = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.c1
    public kotlin.reflect.jvm.internal.impl.descriptors.y c(p1 p1Var) {
        if (p1Var == null) {
            C(22);
        }
        return p1Var.k() ? this : O0(p1Var).g(a()).e().J(true).build();
    }

    public void c1(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (g0Var == null) {
            C(11);
        }
        this.f12887g = g0Var;
    }

    public void d1(boolean z10) {
        this.f12902v = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V e0(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a) {
        Map<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, Object> map = this.D;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0217a);
    }

    public void e1(boolean z10) {
        this.f12897q = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<j1> f() {
        List<j1> list = this.f12886f;
        if (list == null) {
            C(19);
        }
        return list;
    }

    public void f1(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (uVar == null) {
            C(10);
        }
        this.f12892l = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public kotlin.reflect.jvm.internal.impl.descriptors.b.a g() {
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar = this.B;
        if (aVar == null) {
            C(21);
        }
        return aVar;
    }

    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        return this.f12887g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<f1> getTypeParameters() {
        List<f1> list = this.f12885e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.f12892l;
        if (uVar == null) {
            C(16);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = this.f12891k;
        if (e0Var == null) {
            C(15);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 i0() {
        return this.f12889i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return this.f12895o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInfix() {
        if (this.f12894n) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return this.f12896p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isOperator() {
        if (this.f12893m) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return this.f12902v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<x0> n0() {
        List<x0> list = this.f12888h;
        if (list == null) {
            C(13);
        }
        return list;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.y.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> q() {
        c cVarO0 = O0(p1.f14355b);
        if (cVarO0 == null) {
            C(23);
        }
        return cVarO0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean s0() {
        return this.f12900t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == 0) {
            C(17);
        }
        this.f12905y = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.y) it.next()).y0()) {
                this.f12901u = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean y0() {
        return this.f12901u;
    }

    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i11 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: G0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.y g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarBuild = q().p(mVar).c(e0Var).n(uVar).r(aVar).i(z10).build();
        if (yVarBuild == null) {
            C(26);
        }
        return yVarBuild;
    }

    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.g(this, d10);
    }

    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> e() {
        P0();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> collection = this.f12905y;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            C(14);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    public kotlin.reflect.jvm.internal.impl.descriptors.y a() {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar = this.A;
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarA = yVar == this ? this : yVar.a();
        if (yVarA == null) {
            C(20);
        }
        return yVarA;
    }
}
