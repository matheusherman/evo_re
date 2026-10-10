package androidx.paging;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PageKeyedDataSource", f = "PageKeyedDataSource.kt", l = {185, 191, RsaOaep.DerParser.PRIVATE}, m = "load$paging_common")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Key", "Value", "Landroidx/paging/DataSource$Params;", "params", "Lv8/f;", "Landroidx/paging/DataSource$BaseResult;", "continuation", "load", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
final class PageKeyedDataSource$load$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageKeyedDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageKeyedDataSource$load$1(PageKeyedDataSource pageKeyedDataSource, v8.f fVar) {
        super(fVar);
        this.this$0 = pageKeyedDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load$paging_common(null, this);
    }
}
