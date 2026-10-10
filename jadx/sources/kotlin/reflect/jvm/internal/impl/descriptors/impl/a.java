package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.s1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ba.f f12762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ka.i<o0> f12763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> f12764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.i<x0> f12765e;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0219a implements c9.a<o0> {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0220a implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
            C0220a() {
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarF = gVar.f(a.this);
                if (hVarF == null) {
                    return a.this.f12763c.invoke();
                }
                if (hVarF instanceof e1) {
                    return kotlin.reflect.jvm.internal.impl.types.h0.b((e1) hVarF, s1.g(hVarF.h().getParameters()));
                }
                return hVarF instanceof t ? s1.v(hVarF.h().c(gVar), ((t) hVarF).G(gVar), this) : hVarF.p();
            }
        }

        C0219a() {
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o0 invoke() {
            a aVar = a.this;
            return s1.u(aVar, aVar.z0(), new C0220a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
        b() {
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(a.this.z0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements c9.a<x0> {
        c() {
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x0 invoke() {
            return new q(a.this);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.e a() {
        return this;
    }

    public a(ka.n nVar, ba.f fVar) {
        if (nVar == null) {
            w0(0);
        }
        if (fVar == null) {
            w0(1);
        }
        this.f12762b = fVar;
        this.f12763c = nVar.c(new C0219a());
        this.f12764d = nVar.c(new b());
        this.f12765e = nVar.c(new c());
    }

    private static /* synthetic */ void w0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i10 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i10 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i10 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i10 == 19) {
            objArr[1] = "substitute";
        } else if (i10 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 9 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 17 && i10 != 19 && i10 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(p1 p1Var) {
        if (p1Var == null) {
            w0(18);
        }
        return p1Var.k() ? this : new s(this, p1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h C(n1 n1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (n1Var == null) {
            w0(10);
        }
        if (gVar == null) {
            w0(11);
        }
        if (!n1Var.f()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(G(gVar), p1.g(n1Var));
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarG = G(gVar);
        if (hVarG == null) {
            w0(12);
        }
        return hVarG;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public List<x0> C0() {
        List<x0> list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(6);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public x0 F0() {
        x0 x0VarInvoke = this.f12765e.invoke();
        if (x0VarInvoke == null) {
            w0(5);
        }
        return x0VarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h W(n1 n1Var) {
        if (n1Var == null) {
            w0(15);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarC = C(n1Var, ea.c.o(kotlin.reflect.jvm.internal.impl.resolve.e.g(this)));
        if (hVarC == null) {
            w0(16);
        }
        return hVarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    public ba.f getName() {
        ba.f fVar = this.f12762b;
        if (fVar == null) {
            w0(2);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.h
    public o0 p() {
        o0 o0VarInvoke = this.f12763c.invoke();
        if (o0VarInvoke == null) {
            w0(20);
        }
        return o0VarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h u0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarInvoke = this.f12764d.invoke();
        if (hVarInvoke == null) {
            w0(4);
        }
        return hVarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.a(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h z0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarG = G(ea.c.o(kotlin.reflect.jvm.internal.impl.resolve.e.g(this)));
        if (hVarG == null) {
            w0(17);
        }
        return hVarG;
    }
}
