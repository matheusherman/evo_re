package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LivePagedList$callback$1 extends o implements c9.a<z> {
    final /* synthetic */ LivePagedList this$0;

    @Override // c9.a
    public /* bridge */ /* synthetic */ z invoke() {
        invoke2();
        return z.f17874a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LivePagedList$callback$1(LivePagedList livePagedList) {
        super(0);
        this.this$0 = livePagedList;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.invalidate(true);
    }
}
