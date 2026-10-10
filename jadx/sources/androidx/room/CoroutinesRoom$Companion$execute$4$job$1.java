package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 7, 1})
final class CoroutinesRoom$Companion$execute$4$job$1 extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ kotlinx.coroutines.n<R> $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.n<? super R> nVar, v8.f<? super CoroutinesRoom$Companion$execute$4$job$1> fVar) {
        super(2, fVar);
        this.$callable = callable;
        this.$continuation = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, fVar);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            r.b(obj);
            try {
                this.$continuation.resumeWith(r8.q.a(this.$callable.call()));
            } catch (Throwable th) {
                v8.f fVar = this.$continuation;
                r8.q.Companion companion = r8.q.INSTANCE;
                fVar.resumeWith(r8.q.a(r.a(th)));
            }
            return r8.z.f17874a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
