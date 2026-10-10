package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.h;
import r8.z;
import v8.f;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"androidx/paging/PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
public final class PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1<T> implements g<PageEvent<T>> {
    final /* synthetic */ PagingDataDiffer.AnonymousClass2 this$0;

    public PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1(PagingDataDiffer.AnonymousClass2 anonymousClass2) {
        this.this$0 = anonymousClass2;
    }

    @Override // kotlinx.coroutines.flow.g
    public Object emit(Object obj, f fVar) {
        Object objG = h.g(PagingDataDiffer.this.mainDispatcher, new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1((PageEvent) obj, null, this), fVar);
        return objG == b.c() ? objG : z.f17874a;
    }
}
