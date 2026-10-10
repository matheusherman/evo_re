package p9;

import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class l implements t9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f17450a = new l();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements t9.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f17451b;

        public a(p javaElement) {
            kotlin.jvm.internal.m.f(javaElement, "javaElement");
            this.f17451b = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
        public b1 a() {
            b1 NO_SOURCE_FILE = b1.f12738a;
            kotlin.jvm.internal.m.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // t9.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public p b() {
            return this.f17451b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    @Override // t9.b
    public t9.a a(u9.l javaElement) {
        kotlin.jvm.internal.m.f(javaElement, "javaElement");
        return new a((p) javaElement);
    }

    private l() {
    }
}
