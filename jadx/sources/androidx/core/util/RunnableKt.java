package androidx.core.util;

import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lv8/f;", "Lr8/z;", "Ljava/lang/Runnable;", "asRunnable", "(Lv8/f;)Ljava/lang/Runnable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RunnableKt {
    public static final Runnable asRunnable(v8.f<? super z> fVar) {
        return new ContinuationRunnable(fVar);
    }
}
