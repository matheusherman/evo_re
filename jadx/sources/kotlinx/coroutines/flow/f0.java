package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a=\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010\"\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/flow/v;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/v;", "Lkotlinx/coroutines/flow/d0;", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlinx/coroutines/flow/f;", "d", "(Lkotlinx/coroutines/flow/d0;Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/internal/f0;", "Lkotlinx/coroutines/internal/f0;", "NONE", "b", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.f0 f14716a = new kotlinx.coroutines.internal.f0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.f0 f14717b = new kotlinx.coroutines.internal.f0("PENDING");

    public static final <T> v<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.p.f14741a;
        }
        return new e0(t10);
    }

    public static final <T> f<T> d(d0<? extends T> d0Var, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        return (((i10 < 0 || i10 >= 2) && i10 != -2) || aVar != kotlinx.coroutines.channels.a.DROP_OLDEST) ? b0.e(d0Var, jVar, i10, aVar) : d0Var;
    }
}
