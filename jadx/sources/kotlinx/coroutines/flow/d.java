package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BR\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R9\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/s;", "Lv8/f;", "Lr8/z;", "", "block", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lc9/p;Lv8/j;ILkotlinx/coroutines/channels/a;)V", "f", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/internal/e;", "scope", "e", "(Lkotlinx/coroutines/channels/s;Lv8/f;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "d", "Lc9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
class d<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c9.p<kotlinx.coroutines.channels.s<? super T>, v8.f<? super r8.z>, Object> block;

    public /* synthetic */ d(c9.p pVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(pVar, (i11 & 2) != 0 ? v8.k.f19724a : jVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? kotlinx.coroutines.channels.a.SUSPEND : aVar);
    }

    static /* synthetic */ <T> Object j(d<T> dVar, kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super r8.z> fVar) {
        Object objInvoke = ((d) dVar).block.invoke(sVar, fVar);
        return objInvoke == kotlin.coroutines.intrinsics.b.c() ? objInvoke : r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected kotlinx.coroutines.flow.internal.e<T> f(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return new d(this.block, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected Object e(kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super r8.z> fVar) {
        return j(this, sVar, fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(c9.p<? super kotlinx.coroutines.channels.s<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        super(jVar, i10, aVar);
        this.block = pVar;
    }
}
