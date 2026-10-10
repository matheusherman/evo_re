package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B4\u0012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR9\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/flow/y;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/a;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/g;", "Lv8/f;", "Lr8/z;", "", "block", "<init>", "(Lc9/p;)V", "collector", "c", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "a", "Lc9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class y<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c9.p<g<? super T>, v8.f<? super r8.z>, Object> block;

    @Override // kotlinx.coroutines.flow.a
    public Object c(g<? super T> gVar, v8.f<? super r8.z> fVar) {
        Object objInvoke = this.block.invoke(gVar, fVar);
        return objInvoke == kotlin.coroutines.intrinsics.b.c() ? objInvoke : r8.z.f17874a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(c9.p<? super g<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        this.block = pVar;
    }
}
