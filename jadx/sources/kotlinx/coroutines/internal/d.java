package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aN\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a0\u0010\u0013\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/c0;", ExifInterface.LATITUDE_SOUTH, "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lkotlin/Function2;", "createNewSegment", "Lkotlinx/coroutines/internal/d0;", "c", "(Lkotlinx/coroutines/internal/c0;JLc9/p;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/e;", "N", "b", "(Lkotlinx/coroutines/internal/e;)Lkotlinx/coroutines/internal/e;", "Lkotlinx/atomicfu/AtomicInt;", "", "delta", "Lkotlin/Function1;", "", "condition", "addConditionally", "(Lkotlinx/atomicfu/AtomicInt;ILc9/l;)Z", "Lkotlinx/coroutines/internal/f0;", "a", "Lkotlinx/coroutines/internal/f0;", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f0 f14816a = new f0("CLOSED");

    public static final <S extends c0<S>> Object c(S s10, long j10, c9.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= j10 && !s10.h()) {
                return d0.a(s10);
            }
            Object objF = s10.f();
            if (objF == f14816a) {
                return d0.a(f14816a);
            }
            S sInvoke = (S) ((e) objF);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s10.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String + 1), s10);
                if (s10.l(sInvoke)) {
                    if (s10.h()) {
                        s10.k();
                    }
                }
            }
            s10 = (Object) sInvoke;
        }
    }

    public static final <N extends e<N>> N b(N n10) {
        while (true) {
            Object objF = n10.f();
            if (objF == f14816a) {
                return n10;
            }
            e eVar = (e) objF;
            if (eVar == null) {
                if (n10.j()) {
                    return n10;
                }
            } else {
                n10 = (N) eVar;
            }
        }
    }
}
