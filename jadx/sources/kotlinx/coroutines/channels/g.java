package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlin/Function1;", "Lr8/z;", "onUndeliveredElement", "Lkotlinx/coroutines/channels/d;", "a", "(ILkotlinx/coroutines/channels/a;Lc9/l;)Lkotlinx/coroutines/channels/d;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class g {
    public static final <E> d<E> a(int i10, a aVar, c9.l<? super E, z> lVar) {
        if (i10 == -2) {
            return aVar == a.SUSPEND ? new b(d.INSTANCE.a(), lVar) : new p(1, aVar, lVar);
        }
        if (i10 == -1) {
            if (aVar == a.SUSPEND) {
                return new p(1, a.DROP_OLDEST, lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i10 == 0) {
            return aVar == a.SUSPEND ? new b(0, lVar) : new p(1, aVar, lVar);
        }
        if (i10 != Integer.MAX_VALUE) {
            return aVar == a.SUSPEND ? new b(i10, lVar) : new p(i10, aVar, lVar);
        }
        return new b(Integer.MAX_VALUE, lVar);
    }

    public static /* synthetic */ d b(int i10, a aVar, c9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return a(i10, aVar, lVar);
    }
}
