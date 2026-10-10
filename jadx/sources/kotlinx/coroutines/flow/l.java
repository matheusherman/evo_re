package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "a", "(Lkotlinx/coroutines/flow/f;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "d", "(Lkotlinx/coroutines/flow/f;)Lkotlinx/coroutines/flow/f;", "Lv8/j;", "context", "e", "(Lkotlinx/coroutines/flow/f;Lv8/j;)Lkotlinx/coroutines/flow/f;", "Lr8/z;", "c", "(Lv8/j;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class l {
    public static final <T> f<T> a(f<? extends T> fVar, int i10, kotlinx.coroutines.channels.a aVar) {
        int i11;
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && aVar != kotlinx.coroutines.channels.a.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i10 == -1) {
            aVar = kotlinx.coroutines.channels.a.DROP_OLDEST;
            i11 = 0;
        } else {
            i11 = i10;
        }
        kotlinx.coroutines.channels.a aVar2 = aVar;
        return fVar instanceof kotlinx.coroutines.flow.internal.m ? kotlinx.coroutines.flow.internal.m.a.a((kotlinx.coroutines.flow.internal.m) fVar, null, i11, aVar2, 1, null) : new kotlinx.coroutines.flow.internal.h(fVar, null, i11, aVar2, 2, null);
    }

    public static final <T> f<T> d(f<? extends T> fVar) {
        return b(fVar, -1, null, 2, null);
    }

    public static /* synthetic */ f b(f fVar, int i10, kotlinx.coroutines.channels.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            aVar = kotlinx.coroutines.channels.a.SUSPEND;
        }
        return h.c(fVar, i10, aVar);
    }

    private static final void c(v8.j jVar) {
        if (jVar.get(u1.INSTANCE) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + jVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> f<T> e(f<? extends T> fVar, v8.j jVar) {
        c(jVar);
        if (kotlin.jvm.internal.m.a(jVar, v8.k.f19724a)) {
            return fVar;
        }
        if (fVar instanceof kotlinx.coroutines.flow.internal.m) {
            return kotlinx.coroutines.flow.internal.m.a.a((kotlinx.coroutines.flow.internal.m) fVar, jVar, 0, null, 6, null);
        }
        return new kotlinx.coroutines.flow.internal.h(fVar, jVar, 0, null, 12, null);
    }
}
