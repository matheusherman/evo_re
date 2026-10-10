package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/internal/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/g;", "Lkotlinx/coroutines/flow/f;", "flow", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/f;Lv8/j;ILkotlinx/coroutines/channels/a;)V", "Lkotlinx/coroutines/flow/internal/e;", "f", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "m", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class h<T> extends g<T, T> {
    public /* synthetic */ h(kotlinx.coroutines.flow.f fVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(fVar, (i11 & 2) != 0 ? v8.k.f19724a : jVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? kotlinx.coroutines.channels.a.SUSPEND : aVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected e<T> f(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return new h(this.flow, context, capacity, onBufferOverflow);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.g
    protected Object m(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
        Object objCollect = this.flow.collect((kotlinx.coroutines.flow.g<? super S>) gVar, fVar);
        return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
    }

    public h(kotlinx.coroutines.flow.f<? extends T> fVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        super(fVar, jVar, i10, aVar);
    }
}
