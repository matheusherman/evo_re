package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import r8.r;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/l0;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class CoroutinesRoom$Companion$execute$2<R> extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super R>, Object> {
    final /* synthetic */ Callable<R> $callable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$2(Callable<R> callable, v8.f<? super CoroutinesRoom$Companion$execute$2> fVar) {
        super(2, fVar);
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, fVar);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super R> fVar) {
        return ((CoroutinesRoom$Companion$execute$2) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            r.b(obj);
            return this.$callable.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
