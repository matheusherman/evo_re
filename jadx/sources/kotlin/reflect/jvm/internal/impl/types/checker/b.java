package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.l0;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.q1;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b extends q1, na.r {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.checker.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0266a extends f1.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f14233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p1 f14234b;

            C0266a(b bVar, p1 p1Var) {
                this.f14233a = bVar;
                this.f14234b = p1Var;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f1.c
            public na.k a(f1 state, na.i type) {
                kotlin.jvm.internal.m.f(state, "state");
                kotlin.jvm.internal.m.f(type, "type");
                b bVar = this.f14233a;
                p1 p1Var = this.f14234b;
                Object objM = bVar.M(type);
                kotlin.jvm.internal.m.d(objM, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                g0 g0VarN = p1Var.n((g0) objM, w1.INVARIANT);
                kotlin.jvm.internal.m.e(g0VarN, "substitutor.safeSubstitu…VARIANT\n                )");
                na.k kVarA = bVar.a(g0VarN);
                kotlin.jvm.internal.m.c(kVarA);
                return kVarA;
            }
        }

        public static na.u A(b bVar, na.m receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof k1) {
                w1 w1VarA = ((k1) receiver).a();
                kotlin.jvm.internal.m.e(w1VarA, "this.projectionKind");
                return na.q.a(w1VarA);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.u B(b bVar, na.o receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
                w1 w1VarJ = ((kotlin.reflect.jvm.internal.impl.descriptors.f1) receiver).j();
                kotlin.jvm.internal.m.e(w1VarJ, "this.variance");
                return na.q.a(w1VarJ);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean C(b bVar, na.i receiver, ba.c fqName) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            kotlin.jvm.internal.m.f(fqName, "fqName");
            if (receiver instanceof g0) {
                return ((g0) receiver).getAnnotations().F(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean D(b bVar, na.o receiver, na.n nVar) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (!(receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
            }
            if (nVar == null ? true : nVar instanceof g1) {
                return oa.a.m((kotlin.reflect.jvm.internal.impl.descriptors.f1) receiver, (g1) nVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean E(b bVar, na.k a10, na.k b10) {
            kotlin.jvm.internal.m.f(a10, "a");
            kotlin.jvm.internal.m.f(b10, "b");
            if (!(a10 instanceof o0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a10 + ", " + c0.b(a10.getClass())).toString());
            }
            if (b10 instanceof o0) {
                return ((o0) a10).H0() == ((o0) b10).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b10 + ", " + c0.b(b10.getClass())).toString());
        }

        public static na.i F(b bVar, List<? extends na.i> types) {
            kotlin.jvm.internal.m.f(types, "types");
            return d.a(types);
        }

        public static boolean G(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.w0((g1) receiver, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12600b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean H(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return ((g1) receiver).d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean I(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
                return (eVar == null || !f0.a(eVar) || eVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY || eVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean J(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return ((g1) receiver).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean K(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return i0.a((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean L(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
                return (eVar != null ? eVar.v0() : null) instanceof z;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean M(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean N(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.types.f0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean O(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return ((o0) receiver).K0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean P(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            return receiver instanceof l0;
        }

        public static boolean Q(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.w0((g1) receiver, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12602c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean R(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return s1.l((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean S(b bVar, na.d receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean T(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.s0((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean U(b bVar, na.d receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).V0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean V(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                if (i0.a((g0) receiver)) {
                    return false;
                }
                o0 o0Var = (o0) receiver;
                if (o0Var.J0().d() instanceof e1) {
                    return false;
                }
                return o0Var.J0().d() != null || (receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a) || (receiver instanceof i) || (receiver instanceof kotlin.reflect.jvm.internal.impl.types.p) || (o0Var.J0() instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n) || W(bVar, receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        private static boolean W(b bVar, na.k kVar) {
            return (kVar instanceof r0) && bVar.b(((r0) kVar).B0());
        }

        public static boolean X(b bVar, na.m receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof k1) {
                return ((k1) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Y(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return oa.a.p((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Z(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return oa.a.q((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean a(b bVar, na.n c10, na.n c11) {
            kotlin.jvm.internal.m.f(c10, "c1");
            kotlin.jvm.internal.m.f(c11, "c2");
            if (!(c10 instanceof g1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c10 + ", " + c0.b(c10.getClass())).toString());
            }
            if (c11 instanceof g1) {
                return kotlin.jvm.internal.m.a(c10, c11);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c11 + ", " + c0.b(c11.getClass())).toString());
        }

        public static boolean a0(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            return (receiver instanceof v1) && (((v1) receiver).J0() instanceof n);
        }

        public static int b(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return ((g0) receiver).H0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static boolean b0(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                return hVarD != null && kotlin.reflect.jvm.internal.impl.builtins.h.B0(hVarD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.l c(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return (na.l) receiver;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k c0(b bVar, na.g receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof a0) {
                return ((a0) receiver).R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.d d(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                if (receiver instanceof r0) {
                    return bVar.d(((r0) receiver).B0());
                }
                if (receiver instanceof i) {
                    return (i) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i d0(b bVar, na.d receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).U0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.e e(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.p) {
                    return (kotlin.reflect.jvm.internal.impl.types.p) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i e0(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof v1) {
                return c.b((v1) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.f f(b bVar, na.g receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof a0) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.v) {
                    return (kotlin.reflect.jvm.internal.impl.types.v) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static f1 f0(b bVar, boolean z10, boolean z11) {
            return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z10, z11, bVar, null, null, 24, null);
        }

        public static na.g g(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                v1 v1VarM0 = ((g0) receiver).M0();
                if (v1VarM0 instanceof a0) {
                    return (a0) v1VarM0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k g0(b bVar, na.e receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.p) {
                return ((kotlin.reflect.jvm.internal.impl.types.p) receiver).V0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.j h(b bVar, na.g receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof a0) {
                if (receiver instanceof n0) {
                    return (n0) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static int h0(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                return ((g1) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k i(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                v1 v1VarM0 = ((g0) receiver).M0();
                if (v1VarM0 instanceof o0) {
                    return (o0) v1VarM0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static Collection<na.i> i0(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            na.n nVarF = bVar.f(receiver);
            if (nVarF instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n) {
                return ((kotlin.reflect.jvm.internal.impl.resolve.constants.n) nVarF).k();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.m j(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return oa.a.a((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.m j0(b bVar, na.c receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof j) {
                return ((j) receiver).f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k k(b bVar, na.k type, na.b status) {
            kotlin.jvm.internal.m.f(type, "type");
            kotlin.jvm.internal.m.f(status, "status");
            if (type instanceof o0) {
                return k.b((o0) type, status);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + c0.b(type.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static f1.c k0(b bVar, na.k type) {
            kotlin.jvm.internal.m.f(type, "type");
            if (type instanceof o0) {
                return new C0266a(bVar, h1.f14318c.a((g0) type).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + c0.b(type.getClass())).toString());
        }

        public static na.b l(b bVar, na.d receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).S0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static Collection<na.i> l0(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                Collection<g0> collectionB = ((g1) receiver).b();
                kotlin.jvm.internal.m.e(collectionB, "this.supertypes");
                return collectionB;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i m(b bVar, na.k lowerBound, na.k upperBound) {
            kotlin.jvm.internal.m.f(lowerBound, "lowerBound");
            kotlin.jvm.internal.m.f(upperBound, "upperBound");
            if (!(lowerBound instanceof o0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + c0.b(bVar.getClass())).toString());
            }
            if (upperBound instanceof o0) {
                return h0.d((o0) lowerBound, (o0) upperBound);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + c0.b(bVar.getClass())).toString());
        }

        public static na.c m0(b bVar, na.d receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof i) {
                return ((i) receiver).J0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.m n(b bVar, na.i receiver, int i10) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return ((g0) receiver).H0().get(i10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.n n0(b bVar, na.k receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return ((o0) receiver).J0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static List<na.m> o(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return ((g0) receiver).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k o0(b bVar, na.g receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof a0) {
                return ((a0) receiver).S0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static ba.d p(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                kotlin.jvm.internal.m.d(hVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return ea.c.m((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i p0(b bVar, na.i receiver, boolean z10) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof na.k) {
                return bVar.g((na.k) receiver, z10);
            }
            if (!(receiver instanceof na.g)) {
                throw new IllegalStateException("sealed");
            }
            na.g gVar = (na.g) receiver;
            return bVar.b0(bVar.g(bVar.c(gVar), z10), bVar.g(bVar.e(gVar), z10));
        }

        public static na.o q(b bVar, na.n receiver, int i10) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var = ((g1) receiver).getParameters().get(i10);
                kotlin.jvm.internal.m.e(f1Var, "this.parameters[index]");
                return f1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.k q0(b bVar, na.k receiver, boolean z10) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof o0) {
                return ((o0) receiver).N0(z10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static List<na.o> r(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = ((g1) receiver).getParameters();
                kotlin.jvm.internal.m.e(parameters, "this.parameters");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.builtins.i s(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                kotlin.jvm.internal.m.d(hVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.h.P((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static kotlin.reflect.jvm.internal.impl.builtins.i t(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                kotlin.jvm.internal.m.d(hVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return kotlin.reflect.jvm.internal.impl.builtins.h.S((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i u(b bVar, na.o receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
                return oa.a.j((kotlin.reflect.jvm.internal.impl.descriptors.f1) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i v(b bVar, na.m receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof k1) {
                return ((k1) receiver).getType().M0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.o w(b bVar, na.t receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof n) {
                return ((n) receiver).a();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.o x(b bVar, na.n receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g1) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g1) receiver).d();
                if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
                    return (kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static na.i y(b bVar, na.i receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof g0) {
                return kotlin.reflect.jvm.internal.impl.resolve.g.g((g0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }

        public static List<na.i> z(b bVar, na.o receiver) {
            kotlin.jvm.internal.m.f(receiver, "$receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
                List<g0> upperBounds = ((kotlin.reflect.jvm.internal.impl.descriptors.f1) receiver).getUpperBounds();
                kotlin.jvm.internal.m.e(upperBounds, "this.upperBounds");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + c0.b(receiver.getClass())).toString());
        }
    }

    @Override // na.p
    na.k a(na.i iVar);

    @Override // na.p
    boolean b(na.k kVar);

    na.i b0(na.k kVar, na.k kVar2);

    @Override // na.p
    na.k c(na.g gVar);

    @Override // na.p
    na.d d(na.k kVar);

    @Override // na.p
    na.k e(na.g gVar);

    @Override // na.p
    na.n f(na.k kVar);

    @Override // na.p
    na.k g(na.k kVar, boolean z10);
}
