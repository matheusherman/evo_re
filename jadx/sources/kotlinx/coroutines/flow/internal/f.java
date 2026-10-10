package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.h0;
import kotlinx.coroutines.internal.j0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a]\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lv8/j;", "emitContext", "d", "(Lkotlinx/coroutines/flow/g;Lv8/j;)Lkotlinx/coroutines/flow/g;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lv8/f;", "block", "b", "(Lv8/j;Ljava/lang/Object;Ljava/lang/Object;Lc9/p;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class f {
    public static /* synthetic */ Object c(v8.j jVar, Object obj, Object obj2, c9.p pVar, v8.f fVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = j0.b(jVar);
        }
        return b(jVar, obj, obj2, pVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.g<T> d(kotlinx.coroutines.flow.g<? super T> gVar, v8.j jVar) {
        return gVar instanceof t ? true : gVar instanceof o ? gVar : new v(gVar, jVar);
    }

    public static final <T, V> Object b(v8.j jVar, V v10, Object obj, c9.p<? super V, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        Object objC = j0.c(jVar, obj);
        try {
            Object objInvoke = ((c9.p) h0.f(pVar, 2)).invoke(v10, new u(fVar, jVar));
            j0.a(jVar, objC);
            if (objInvoke == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.h.c(fVar);
            }
            return objInvoke;
        } catch (Throwable th) {
            j0.a(jVar, objC);
            throw th;
        }
    }
}
