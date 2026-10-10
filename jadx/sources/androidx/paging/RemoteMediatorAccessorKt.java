package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "scope", "Landroidx/paging/RemoteMediator;", "delegate", "Landroidx/paging/RemoteMediatorAccessor;", "RemoteMediatorAccessor", "(Lkotlinx/coroutines/l0;Landroidx/paging/RemoteMediator;)Landroidx/paging/RemoteMediatorAccessor;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class RemoteMediatorAccessorKt {
    public static final <Key, Value> RemoteMediatorAccessor<Key, Value> RemoteMediatorAccessor(l0 scope, RemoteMediator<Key, Value> delegate) {
        m.f(scope, "scope");
        m.f(delegate, "delegate");
        return new RemoteMediatorAccessImpl(scope, delegate);
    }
}
