package n9;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface e {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16099a = new a();

        @Override // n9.e
        public o0 a(ba.b classId, o0 computedType) {
            m.f(classId, "classId");
            m.f(computedType, "computedType");
            return computedType;
        }

        private a() {
        }
    }

    o0 a(ba.b bVar, o0 o0Var);
}
