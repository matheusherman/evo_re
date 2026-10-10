package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import u9.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface f {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13179a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.f
        public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(n field, u0 descriptor) {
            m.f(field, "field");
            m.f(descriptor, "descriptor");
            return null;
        }

        private a() {
        }
    }

    kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(n nVar, u0 u0Var);
}
