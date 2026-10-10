package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c0 extends n0 implements u0 {
    private kotlin.reflect.jvm.internal.impl.descriptors.w A;
    private kotlin.reflect.jvm.internal.impl.descriptors.w B;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e0 f12782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.u f12783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Collection<? extends u0> f12784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final u0 f12785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.b.a f12786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f12787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f12788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f12789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f12790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f12791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f12792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<x0> f12793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private x0 f12794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private x0 f12795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List<f1> f12796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private d0 f12797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private w0 f12798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f12799z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.m f12800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.e0 f12801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.u f12802c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.b.a f12805f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private x0 f12808i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ba.f f12810k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.types.g0 f12811l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private u0 f12803d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f12804e = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private n1 f12806g = n1.f14344b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12807h = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<f1> f12809j = null;

        public a() {
            this.f12800a = c0.this.b();
            this.f12801b = c0.this.i();
            this.f12802c = c0.this.getVisibility();
            this.f12805f = c0.this.g();
            this.f12808i = c0.this.f12794u;
            this.f12810k = c0.this.getName();
            this.f12811l = c0.this.getType();
        }

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 2) {
                objArr[1] = "setOriginal";
            } else if (i10 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i10 == 5) {
                objArr[1] = "setReturnType";
            } else if (i10 == 7) {
                objArr[1] = "setModality";
            } else if (i10 == 9) {
                objArr[1] = "setVisibility";
            } else if (i10 == 11) {
                objArr[1] = "setKind";
            } else if (i10 == 19) {
                objArr[1] = "setName";
            } else if (i10 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i10 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i10 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 5 && i10 != 7 && i10 != 9 && i10 != 11 && i10 != 19 && i10 != 13 && i10 != 14 && i10 != 16 && i10 != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public u0 n() {
            return c0.this.M0(this);
        }

        v0 o() {
            u0 u0Var = this.f12803d;
            if (u0Var == null) {
                return null;
            }
            return u0Var.getGetter();
        }

        w0 p() {
            u0 u0Var = this.f12803d;
            if (u0Var == null) {
                return null;
            }
            return u0Var.getSetter();
        }

        public a q(boolean z10) {
            this.f12807h = z10;
            return this;
        }

        public a r(kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f12805f = aVar;
            return this;
        }

        public a s(kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var) {
            if (e0Var == null) {
                a(6);
            }
            this.f12801b = e0Var;
            return this;
        }

        public a t(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f12803d = (u0) bVar;
            return this;
        }

        public a u(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar == null) {
                a(0);
            }
            this.f12800a = mVar;
            return this;
        }

        public a v(n1 n1Var) {
            if (n1Var == null) {
                a(15);
            }
            this.f12806g = n1Var;
            return this;
        }

        public a w(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
            if (uVar == null) {
                a(8);
            }
            this.f12802c = uVar;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected c0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z10, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        super(mVar, gVar, fVar, null, z10, a1Var);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (e0Var == null) {
            C(2);
        }
        if (uVar == null) {
            C(3);
        }
        if (fVar == null) {
            C(4);
        }
        if (aVar == null) {
            C(5);
        }
        if (a1Var == null) {
            C(6);
        }
        this.f12784k = null;
        this.f12793t = Collections.EMPTY_LIST;
        this.f12782i = e0Var;
        this.f12783j = uVar;
        this.f12785l = u0Var == null ? this : u0Var;
        this.f12786m = aVar;
        this.f12787n = z11;
        this.f12788o = z12;
        this.f12789p = z13;
        this.f12790q = z14;
        this.f12791r = z15;
        this.f12792s = z16;
    }

    public static c0 K0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z10, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (mVar == null) {
            C(7);
        }
        if (gVar == null) {
            C(8);
        }
        if (e0Var == null) {
            C(9);
        }
        if (uVar == null) {
            C(10);
        }
        if (fVar == null) {
            C(11);
        }
        if (aVar == null) {
            C(12);
        }
        if (a1Var == null) {
            C(13);
        }
        return new c0(mVar, null, gVar, e0Var, uVar, z10, fVar, aVar, a1Var, z11, z12, z13, z14, z15, z16);
    }

    public void Q0(d0 d0Var, w0 w0Var) {
        R0(d0Var, w0Var, null, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V e0(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        if (i10 != 28 && i10 != 38 && i10 != 39 && i10 != 41 && i10 != 42) {
            switch (i10) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 28 && i10 != 38 && i10 != 39 && i10 != 41 && i10 != 42) {
            switch (i10) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 20:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 35:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 37:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "inType";
                break;
            case 15:
            case 17:
                objArr[0] = "outType";
                break;
            case 16:
            case 18:
                objArr[0] = "typeParameters";
                break;
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 27:
                objArr[0] = "originalSubstitutor";
                break;
            case 29:
                objArr[0] = "copyConfiguration";
                break;
            case 30:
                objArr[0] = "substitutor";
                break;
            case 31:
                objArr[0] = "accessorDescriptor";
                break;
            case 32:
                objArr[0] = "newOwner";
                break;
            case 33:
                objArr[0] = "newModality";
                break;
            case 34:
                objArr[0] = "newVisibility";
                break;
            case 36:
                objArr[0] = "newName";
                break;
            case 40:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i10 == 28) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i10 == 38) {
            objArr[1] = "getOriginal";
        } else if (i10 == 39) {
            objArr[1] = "getKind";
        } else if (i10 == 41) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 != 42) {
            switch (i10) {
                case 21:
                    objArr[1] = "getTypeParameters";
                    break;
                case 22:
                    objArr[1] = "getContextReceiverParameters";
                    break;
                case 23:
                    objArr[1] = "getReturnType";
                    break;
                case 24:
                    objArr[1] = "getModality";
                    break;
                case 25:
                    objArr[1] = "getVisibility";
                    break;
                case 26:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
                objArr[2] = "setInType";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "setType";
                break;
            case 20:
                objArr[2] = "setVisibility";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                break;
            case 27:
                objArr[2] = "substitute";
                break;
            case 29:
                objArr[2] = "doSubstitute";
                break;
            case 30:
            case 31:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 40:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 28 && i10 != 38 && i10 != 39 && i10 != 41 && i10 != 42) {
            switch (i10) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    private a1 O0(boolean z10, u0 u0Var) {
        a1 source;
        if (z10) {
            if (u0Var == null) {
                u0Var = a();
            }
            source = u0Var.getSource();
        } else {
            source = a1.f12668a;
        }
        if (source == null) {
            C(28);
        }
        return source;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.y P0(p1 p1Var, t0 t0Var) {
        if (p1Var == null) {
            C(30);
        }
        if (t0Var == null) {
            C(31);
        }
        if (t0Var.Z() != null) {
            return t0Var.Z().c(p1Var);
        }
        return null;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.u U0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar) {
        return (aVar == kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE && kotlin.reflect.jvm.internal.impl.descriptors.t.g(uVar.f())) ? kotlin.reflect.jvm.internal.impl.descriptors.t.f13071h : uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return this.f12790q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return this.f12789p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1
    public boolean K() {
        return this.f12792s;
    }

    protected c0 L0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, a1 a1Var) {
        if (mVar == null) {
            C(32);
        }
        if (e0Var == null) {
            C(33);
        }
        if (uVar == null) {
            C(34);
        }
        if (aVar == null) {
            C(35);
        }
        if (fVar == null) {
            C(36);
        }
        if (a1Var == null) {
            C(37);
        }
        return new c0(mVar, u0Var, getAnnotations(), e0Var, uVar, f0(), fVar, aVar, a1Var, o0(), isConst(), I(), A0(), isExternal(), K());
    }

    protected u0 M0(a aVar) {
        x0 x0Var;
        c9.a<ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> aVar2;
        if (aVar == null) {
            C(29);
        }
        c0 c0VarL0 = L0(aVar.f12800a, aVar.f12801b, aVar.f12802c, aVar.f12803d, aVar.f12805f, aVar.f12810k, O0(aVar.f12804e, aVar.f12803d));
        List<f1> typeParameters = aVar.f12809j == null ? getTypeParameters() : aVar.f12809j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        p1 p1VarB = kotlin.reflect.jvm.internal.impl.types.t.b(typeParameters, aVar.f12806g, c0VarL0, arrayList);
        kotlin.reflect.jvm.internal.impl.types.g0 g0Var = aVar.f12811l;
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = p1VarB.p(g0Var, w1.OUT_VARIANCE);
        if (g0VarP == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarP2 = p1VarB.p(g0Var, w1.IN_VARIANCE);
        if (g0VarP2 != null) {
            c0VarL0.V0(g0VarP2);
        }
        x0 x0Var2 = aVar.f12808i;
        if (x0Var2 != null) {
            x0 x0VarC = x0Var2.c(p1VarB);
            if (x0VarC == null) {
                return null;
            }
            x0Var = x0VarC;
        } else {
            x0Var = null;
        }
        x0 x0Var3 = this.f12795v;
        x0 x0VarA1 = x0Var3 != null ? a1(p1VarB, c0VarL0, x0Var3) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator<x0> it = this.f12793t.iterator();
        while (it.hasNext()) {
            x0 x0VarZ0 = Z0(p1VarB, c0VarL0, it.next());
            if (x0VarZ0 != null) {
                arrayList2.add(x0VarZ0);
            }
        }
        c0VarL0.X0(g0VarP, arrayList, x0Var, x0VarA1, arrayList2);
        d0 d0Var = this.f12797x == null ? null : new d0(c0VarL0, this.f12797x.getAnnotations(), aVar.f12801b, U0(this.f12797x.getVisibility(), aVar.f12805f), this.f12797x.Q(), this.f12797x.isExternal(), this.f12797x.isInline(), aVar.f12805f, aVar.o(), a1.f12668a);
        if (d0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.g0 returnType = this.f12797x.getReturnType();
            d0Var.J0(P0(p1VarB, this.f12797x));
            d0Var.M0(returnType != null ? p1VarB.p(returnType, w1.OUT_VARIANCE) : null);
        }
        e0 e0Var = this.f12798y == null ? null : new e0(c0VarL0, this.f12798y.getAnnotations(), aVar.f12801b, U0(this.f12798y.getVisibility(), aVar.f12805f), this.f12798y.Q(), this.f12798y.isExternal(), this.f12798y.isInline(), aVar.f12805f, aVar.p(), a1.f12668a);
        if (e0Var != null) {
            List<j1> listL0 = p.L0(e0Var, this.f12798y.f(), p1VarB, false, false, null);
            if (listL0 == null) {
                c0VarL0.W0(true);
                listL0 = Collections.singletonList(e0.L0(e0Var, ea.c.j(aVar.f12800a).H(), this.f12798y.f().get(0).getAnnotations()));
            }
            if (listL0.size() != 1) {
                throw new IllegalStateException();
            }
            e0Var.J0(P0(p1VarB, this.f12798y));
            e0Var.N0(listL0.get(0));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar = this.A;
        o oVar = wVar == null ? null : new o(wVar.getAnnotations(), c0VarL0);
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar2 = this.B;
        c0VarL0.R0(d0Var, e0Var, oVar, wVar2 == null ? null : new o(wVar2.getAnnotations(), c0VarL0));
        if (aVar.f12807h) {
            sa.g gVarE = sa.g.e();
            Iterator<? extends u0> it2 = e().iterator();
            while (it2.hasNext()) {
                gVarE.add(it2.next().c(p1VarB));
            }
            c0VarL0.t0(gVarE);
        }
        if (isConst() && (aVar2 = this.f12883h) != null) {
            c0VarL0.G0(this.f12882g, aVar2);
        }
        return c0VarL0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public d0 getGetter() {
        return this.f12797x;
    }

    public void R0(d0 d0Var, w0 w0Var, kotlin.reflect.jvm.internal.impl.descriptors.w wVar, kotlin.reflect.jvm.internal.impl.descriptors.w wVar2) {
        this.f12797x = d0Var;
        this.f12798y = w0Var;
        this.A = wVar;
        this.B = wVar2;
    }

    public boolean S0() {
        return this.f12799z;
    }

    public a T0() {
        return new a();
    }

    public void V0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (g0Var == null) {
            C(14);
        }
    }

    public void W0(boolean z10) {
        this.f12799z = z10;
    }

    public void X0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var, List<? extends f1> list, x0 x0Var, x0 x0Var2, List<x0> list2) {
        if (g0Var == null) {
            C(17);
        }
        if (list == null) {
            C(18);
        }
        if (list2 == null) {
            C(19);
        }
        B0(g0Var);
        this.f12796w = new ArrayList(list);
        this.f12795v = x0Var2;
        this.f12794u = x0Var;
        this.f12793t = list2;
    }

    public void Y0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (uVar == null) {
            C(20);
        }
        this.f12783j = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 b0() {
        return this.f12794u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    public u0 c(p1 p1Var) {
        if (p1Var == null) {
            C(27);
        }
        return p1Var.k() ? this : T0().v(p1Var.j()).t(a()).n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends u0> e() {
        Collection<? extends u0> collection = this.f12784k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            C(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public kotlin.reflect.jvm.internal.impl.descriptors.b.a g() {
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar = this.f12786m;
        if (aVar == null) {
            C(39);
        }
        return aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public w0 getSetter() {
        return this.f12798y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<f1> getTypeParameters() {
        List<f1> list = this.f12796w;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.f12783j;
        if (uVar == null) {
            C(25);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = this.f12782i;
        if (e0Var == null) {
            C(24);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 i0() {
        return this.f12795v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean isConst() {
        return this.f12788o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return this.f12791r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public kotlin.reflect.jvm.internal.impl.descriptors.w j0() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public kotlin.reflect.jvm.internal.impl.descriptors.w m0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<x0> n0() {
        List<x0> list = this.f12793t;
        if (list == null) {
            C(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean o0() {
        return this.f12787n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public List<t0> s() {
        ArrayList arrayList = new ArrayList(2);
        d0 d0Var = this.f12797x;
        if (d0Var != null) {
            arrayList.add(d0Var);
        }
        w0 w0Var = this.f12798y;
        if (w0Var != null) {
            arrayList.add(w0Var);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public void t0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == 0) {
            C(40);
        }
        this.f12784k = collection;
    }

    private static x0 Z0(p1 p1Var, u0 u0Var, x0 x0Var) {
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = p1Var.p(x0Var.getType(), w1.IN_VARIANCE);
        if (g0VarP == null) {
            return null;
        }
        return new f0(u0Var, new ha.c(u0Var, g0VarP, ((ha.f) x0Var.getValue()).a(), x0Var.getValue()), x0Var.getAnnotations());
    }

    private static x0 a1(p1 p1Var, u0 u0Var, x0 x0Var) {
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = p1Var.p(x0Var.getType(), w1.IN_VARIANCE);
        if (g0VarP == null) {
            return null;
        }
        return new f0(u0Var, new ha.d(u0Var, g0VarP, x0Var.getValue()), x0Var.getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.d(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public u0 g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        u0 u0VarN = T0().u(mVar).t(null).s(e0Var).w(uVar).r(aVar).q(z10).n();
        if (u0VarN == null) {
            C(42);
        }
        return u0VarN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.g0 type = getType();
        if (type == null) {
            C(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    public u0 a() {
        u0 u0Var = this.f12785l;
        u0 u0VarA = u0Var == this ? this : u0Var.a();
        if (u0VarA == null) {
            C(38);
        }
        return u0VarA;
    }
}
