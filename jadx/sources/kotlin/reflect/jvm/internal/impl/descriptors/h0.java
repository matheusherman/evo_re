package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface h0 extends m {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public static m b(h0 h0Var) {
            return null;
        }

        public static <R, D> R a(h0 h0Var, o<R, D> visitor, D d10) {
            kotlin.jvm.internal.m.f(visitor, "visitor");
            return visitor.j(h0Var, d10);
        }
    }

    <T> T D0(g0<T> g0Var);

    q0 U(ba.c cVar);

    boolean a0(h0 h0Var);

    kotlin.reflect.jvm.internal.impl.builtins.h l();

    Collection<ba.c> m(ba.c cVar, c9.l<? super ba.f, Boolean> lVar);

    List<h0> p0();
}
