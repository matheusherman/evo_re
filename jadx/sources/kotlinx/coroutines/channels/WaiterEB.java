package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.x2;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.w, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/w;", "", "Lkotlinx/coroutines/x2;", "waiter", "<init>", "(Lkotlinx/coroutines/x2;)V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/x2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class WaiterEB {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final x2 waiter;

    public String toString() {
        return "WaiterEB(" + this.waiter + ')';
    }

    public WaiterEB(x2 x2Var) {
        this.waiter = x2Var;
    }
}
