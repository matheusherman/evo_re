package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$historyCollection$1", f = "CachedPageEventFlow.kt", l = {295}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class CachedPageEventFlow$downstreamFlow$1$historyCollection$1 extends l implements p<l0, v8.f<? super z>, Object> {
    final /* synthetic */ kotlin.jvm.internal.z $lastReceivedHistoryIndex;
    final /* synthetic */ TemporaryDownstream $snapshot;
    final /* synthetic */ s $this_channelFlow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$downstreamFlow$1$historyCollection$1(s sVar, TemporaryDownstream temporaryDownstream, kotlin.jvm.internal.z zVar, v8.f fVar) {
        super(2, fVar);
        this.$this_channelFlow = sVar;
        this.$snapshot = temporaryDownstream;
        this.$lastReceivedHistoryIndex = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new CachedPageEventFlow$downstreamFlow$1$historyCollection$1(this.$this_channelFlow, this.$snapshot, this.$lastReceivedHistoryIndex, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((CachedPageEventFlow$downstreamFlow$1$historyCollection$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
            kotlinx.coroutines.flow.f fVarConsumeHistory = this.$snapshot.consumeHistory();
            Object obj2 = new g<IndexedValue<? extends PageEvent<T>>>() { // from class: androidx.paging.CachedPageEventFlow$downstreamFlow$1$historyCollection$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.g
                public Object emit(Object obj3, v8.f fVar) {
                    IndexedValue indexedValue = (IndexedValue) obj3;
                    this.this$0.$lastReceivedHistoryIndex.element = indexedValue.c();
                    Object objB = this.this$0.$this_channelFlow.b(indexedValue.d(), fVar);
                    return objB == b.c() ? objB : z.f17874a;
                }
            };
            this.label = 1;
            if (fVarConsumeHistory.collect(obj2, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
