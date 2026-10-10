package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f13657b = new g(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<a, i.f<?, ?>> f13658a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f13659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13660b;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13659a == aVar.f13659a && this.f13660b == aVar.f13660b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f13659a) * 65535) + this.f13660b;
        }

        a(Object obj, int i10) {
            this.f13659a = obj;
            this.f13660b = i10;
        }
    }

    g() {
        this.f13658a = new HashMap();
    }

    public static g c() {
        return f13657b;
    }

    public static g d() {
        return new g();
    }

    public final void a(i.f<?, ?> fVar) {
        this.f13658a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public <ContainingType extends q> i.f<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (i.f) this.f13658a.get(new a(containingtype, i10));
    }

    private g(boolean z10) {
        this.f13658a = Collections.EMPTY_MAP;
    }
}
