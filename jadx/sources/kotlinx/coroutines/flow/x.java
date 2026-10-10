package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096Aø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00028\u00008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/flow/x;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/d0;", "", "Lkotlinx/coroutines/flow/internal/m;", "flow", "Lkotlinx/coroutines/u1;", "job", "<init>", "(Lkotlinx/coroutines/flow/d0;Lkotlinx/coroutines/u1;)V", "Lkotlinx/coroutines/flow/g;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlinx/coroutines/flow/f;", "b", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "a", "Lkotlinx/coroutines/u1;", "getValue", "()Ljava/lang/Object;", "value", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class x<T> implements d0<T>, f, kotlinx.coroutines.flow.internal.m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final u1 job;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ d0<T> f14801b;

    @Override // kotlinx.coroutines.flow.z, kotlinx.coroutines.flow.f
    public Object collect(g<? super T> gVar, v8.f<?> fVar) {
        return this.f14801b.collect(gVar, fVar);
    }

    @Override // kotlinx.coroutines.flow.d0
    public T getValue() {
        return this.f14801b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(d0<? extends T> d0Var, u1 u1Var) {
        this.job = u1Var;
        this.f14801b = d0Var;
    }

    @Override // kotlinx.coroutines.flow.internal.m
    public f<T> b(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return f0.d(this, context, capacity, onBufferOverflow);
    }
}
