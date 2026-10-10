package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\u000b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lr8/q;", "Lkotlin/Function1;", "", "Lr8/z;", "onCancellation", "", "b", "(Ljava/lang/Object;Lc9/l;)Ljava/lang/Object;", "Lkotlinx/coroutines/n;", "caller", "c", "(Ljava/lang/Object;Lkotlinx/coroutines/n;)Ljava/lang/Object;", "state", "Lv8/f;", "uCont", "a", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class f0 {
    public static final <T> Object a(Object obj, v8.f<? super T> fVar) {
        if (!(obj instanceof b0)) {
            return r8.q.a(obj);
        }
        r8.q.Companion companion = r8.q.INSTANCE;
        return r8.q.a(r8.r.a(((b0) obj).cause));
    }

    public static /* synthetic */ Object d(Object obj, c9.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }

    public static final <T> Object b(Object obj, c9.l<? super Throwable, r8.z> lVar) {
        Throwable thC = r8.q.c(obj);
        if (thC == null) {
            if (lVar != null) {
                return new CompletedWithCancellation(obj, lVar);
            }
            return obj;
        }
        return new b0(thC, false, 2, null);
    }

    public static final <T> Object c(Object obj, n<?> nVar) {
        Throwable thC = r8.q.c(obj);
        if (thC == null) {
            return obj;
        }
        return new b0(thC, false, 2, null);
    }
}
