package androidx.paging;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import v8.f;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Landroidx/paging/PagingSource;", "invoke", "(Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class Pager$flow$1<Key, Value> extends k implements l<f<? super PagingSource<Key, Value>>, Object> {
    Pager$flow$1(c9.a aVar) {
        super(1, aVar, SuspendingPagingSourceFactory.class, "create", "create(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // c9.l
    public final Object invoke(f<? super PagingSource<Key, Value>> fVar) {
        return ((SuspendingPagingSourceFactory) ((c9.a) this.receiver)).create(fVar);
    }
}
