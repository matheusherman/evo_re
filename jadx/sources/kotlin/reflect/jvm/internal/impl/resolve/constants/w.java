package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f13918c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<h0, g0> {
        final /* synthetic */ g0 $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g0 g0Var) {
            super(1);
            this.$type = g0Var;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(h0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return this.$type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(List<? extends g<?>> value, g0 type) {
        super(value, new a(type));
        kotlin.jvm.internal.m.f(value, "value");
        kotlin.jvm.internal.m.f(type, "type");
        this.f13918c = type;
    }

    public final g0 c() {
        return this.f13918c;
    }
}
