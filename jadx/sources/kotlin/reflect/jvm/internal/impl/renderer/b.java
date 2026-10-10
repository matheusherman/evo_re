package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13781a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(kotlin.reflect.jvm.internal.impl.descriptors.h classifier, kotlin.reflect.jvm.internal.impl.renderer.c renderer) {
            kotlin.jvm.internal.m.f(classifier, "classifier");
            kotlin.jvm.internal.m.f(renderer, "renderer");
            if (classifier instanceof f1) {
                ba.f name = ((f1) classifier).getName();
                kotlin.jvm.internal.m.e(name, "classifier.name");
                return renderer.v(name, false);
            }
            ba.d dVarM = kotlin.reflect.jvm.internal.impl.resolve.e.m(classifier);
            kotlin.jvm.internal.m.e(dVarM, "getFqName(classifier)");
            return renderer.u(dVarM);
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0247b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0247b f13782a = new C0247b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.h] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.j0, kotlin.reflect.jvm.internal.impl.descriptors.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(kotlin.reflect.jvm.internal.impl.descriptors.h classifier, kotlin.reflect.jvm.internal.impl.renderer.c renderer) {
            kotlin.jvm.internal.m.f(classifier, "classifier");
            kotlin.jvm.internal.m.f(renderer, "renderer");
            if (classifier instanceof f1) {
                ba.f name = ((f1) classifier).getName();
                kotlin.jvm.internal.m.e(name, "classifier.name");
                return renderer.v(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.b();
            } while (classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.e);
            return n.c(r.R(arrayList));
        }

        private C0247b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13783a = new c();

        private final String c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                return b((kotlin.reflect.jvm.internal.impl.descriptors.h) mVar);
            }
            if (!(mVar instanceof l0)) {
                return null;
            }
            ba.d dVarJ = ((l0) mVar).d().j();
            kotlin.jvm.internal.m.e(dVarJ, "descriptor.fqName.toUnsafe()");
            return n.a(dVarJ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(kotlin.reflect.jvm.internal.impl.descriptors.h classifier, kotlin.reflect.jvm.internal.impl.renderer.c renderer) {
            kotlin.jvm.internal.m.f(classifier, "classifier");
            kotlin.jvm.internal.m.f(renderer, "renderer");
            return b(classifier);
        }

        private c() {
        }

        private final String b(kotlin.reflect.jvm.internal.impl.descriptors.h hVar) {
            ba.f name = hVar.getName();
            kotlin.jvm.internal.m.e(name, "descriptor.name");
            String strB = n.b(name);
            if (hVar instanceof f1) {
                return strB;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = hVar.b();
            kotlin.jvm.internal.m.e(mVarB, "descriptor.containingDeclaration");
            String strC = c(mVarB);
            if (strC != null && !kotlin.jvm.internal.m.a(strC, "")) {
                return strC + '.' + strB;
            }
            return strB;
        }
    }

    String a(kotlin.reflect.jvm.internal.impl.descriptors.h hVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar);
}
