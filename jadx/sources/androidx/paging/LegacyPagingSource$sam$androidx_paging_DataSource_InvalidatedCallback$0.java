package androidx.paging;

import androidx.annotation.AnyThread;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import r8.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final class LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0 implements DataSource.InvalidatedCallback, h {
    private final /* synthetic */ c9.a function;

    public boolean equals(Object obj) {
        return (obj instanceof DataSource.InvalidatedCallback) && (obj instanceof h) && m.a(this.function, ((h) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.h
    public c getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    @Override // androidx.paging.DataSource.InvalidatedCallback
    @AnyThread
    public final /* synthetic */ void onInvalidated() {
        m.e(this.function.invoke(), "invoke(...)");
    }

    LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(c9.a aVar) {
        this.function = aVar;
    }
}
