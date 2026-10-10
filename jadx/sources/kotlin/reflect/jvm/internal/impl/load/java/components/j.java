package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import u9.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13185a = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements j {
        private static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i10 == 5 || i10 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, List<String> list) {
            if (bVar == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public b b(r rVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, g0 g0Var, g0 g0Var2, List<j1> list, List<f1> list2) {
            if (rVar == null) {
                c(0);
            }
            if (eVar == null) {
                c(1);
            }
            if (g0Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(g0Var, g0Var2, list, list2, Collections.EMPTY_LIST, false);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g0 f13186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g0 f13187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<j1> f13188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<f1> f13189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f13190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f13191f;

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
            switch (i10) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i10 == 4) {
                objArr[1] = "getReturnType";
            } else if (i10 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i10 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i10 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public b(g0 g0Var, g0 g0Var2, List<j1> list, List<f1> list2, List<String> list3, boolean z10) {
            if (g0Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f13186a = g0Var;
            this.f13187b = g0Var2;
            this.f13188c = list;
            this.f13189d = list2;
            this.f13190e = list3;
            this.f13191f = z10;
        }

        public List<String> b() {
            List<String> list = this.f13190e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public g0 c() {
            return this.f13187b;
        }

        public g0 d() {
            g0 g0Var = this.f13186a;
            if (g0Var == null) {
                a(4);
            }
            return g0Var;
        }

        public List<f1> e() {
            List<f1> list = this.f13189d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List<j1> f() {
            List<j1> list = this.f13188c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f13191f;
        }
    }

    void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, List<String> list);

    b b(r rVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, g0 g0Var, g0 g0Var2, List<j1> list, List<f1> list2);
}
