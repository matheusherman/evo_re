package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.CachedPageEventFlow$multicastedSrc$1", f = "CachedPageEventFlow.kt", l = {295}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class CachedPageEventFlow$multicastedSrc$1<T> extends l implements p<g<? super IndexedValue<? extends PageEvent<T>>>, v8.f<? super z>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.f $src;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedPageEventFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$multicastedSrc$1(CachedPageEventFlow cachedPageEventFlow, kotlinx.coroutines.flow.f fVar, v8.f fVar2) {
        super(2, fVar2);
        this.this$0 = cachedPageEventFlow;
        this.$src = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        CachedPageEventFlow$multicastedSrc$1 cachedPageEventFlow$multicastedSrc$1 = new CachedPageEventFlow$multicastedSrc$1(this.this$0, this.$src, completion);
        cachedPageEventFlow$multicastedSrc$1.L$0 = obj;
        return cachedPageEventFlow$multicastedSrc$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((CachedPageEventFlow$multicastedSrc$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            r.b(obj);
            g<? super T> gVar = (g) this.L$0;
            if (this.this$0.collectedFromSource.compareAndSet(false, true)) {
                kotlinx.coroutines.flow.f fVarI = h.I(this.$src);
                this.label = 1;
                if (fVarI.collect(gVar, this) == objC) {
                    return objC;
                }
            }
        }
        return z.f17874a;
    }
}
