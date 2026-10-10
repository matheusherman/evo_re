package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/q;", "Lv8/j;", "currentContext", "Lr8/z;", "a", "(Lkotlinx/coroutines/flow/internal/q;Lv8/j;)V", "Lkotlinx/coroutines/u1;", "collectJob", "b", "(Lkotlinx/coroutines/u1;Lkotlinx/coroutines/u1;)Lkotlinx/coroutines/u1;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class s {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "count", "Lv8/j$b;", "element", "a", "(ILv8/j$b;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.p<Integer, v8.j.b, Integer> {
        final /* synthetic */ q<?> $this_checkContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q<?> qVar) {
            super(2);
            this.$this_checkContext = qVar;
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, v8.j.b bVar) {
            return a(num.intValue(), bVar);
        }

        public final Integer a(int i10, v8.j.b bVar) {
            int i11;
            v8.j.c<?> key = bVar.getKey();
            v8.j.b bVar2 = this.$this_checkContext.collectContext.get(key);
            if (key != u1.INSTANCE) {
                if (bVar != bVar2) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i11 = i10 + 1;
                }
                return Integer.valueOf(i11);
            }
            u1 u1Var = (u1) bVar2;
            kotlin.jvm.internal.m.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            u1 u1VarB = s.b((u1) bVar, u1Var);
            if (u1VarB == u1Var) {
                if (u1Var != null) {
                    i10++;
                }
                return Integer.valueOf(i10);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + u1VarB + ", expected child of " + u1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
    }

    public static final void a(q<?> qVar, v8.j jVar) {
        if (((Number) jVar.fold(0, new a(qVar))).intValue() == qVar.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + qVar.collectContext + ",\n\t\tbut emission happened in " + jVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final u1 b(u1 u1Var, u1 u1Var2) {
        while (u1Var != null) {
            if (u1Var == u1Var2 || !(u1Var instanceof b0)) {
                return u1Var;
            }
            u1Var = u1Var.getParent();
        }
        return null;
    }
}
