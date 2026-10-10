package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface r {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14189a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.r
        public g0 a(w9.q proto, String flexibleId, o0 lowerBound, o0 upperBound) {
            kotlin.jvm.internal.m.f(proto, "proto");
            kotlin.jvm.internal.m.f(flexibleId, "flexibleId");
            kotlin.jvm.internal.m.f(lowerBound, "lowerBound");
            kotlin.jvm.internal.m.f(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }

        private a() {
        }
    }

    g0 a(w9.q qVar, String str, o0 o0Var, o0 o0Var2);
}
