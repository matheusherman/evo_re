package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.i0;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0002*\u00020\u0004\"\b\b\u0003\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "invoke"}, k = 3, mv = {1, 4, 1})
final class DataSource$Factory$asPagingSourceFactory$1<Key, Value> extends o implements c9.a<PagingSource<Key, Value>> {
    final /* synthetic */ i0 $fetchDispatcher;
    final /* synthetic */ DataSource.Factory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataSource$Factory$asPagingSourceFactory$1(DataSource.Factory factory, i0 i0Var) {
        super(0);
        this.this$0 = factory;
        this.$fetchDispatcher = i0Var;
    }

    @Override // c9.a
    public final PagingSource<Key, Value> invoke() {
        return new LegacyPagingSource(this.$fetchDispatcher, this.this$0.create());
    }
}
