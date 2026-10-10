package va;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.p;
import kotlin.Metadata;
import kotlinx.coroutines.internal.k;
import r8.q;
import r8.r;
import r8.z;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001al\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000e\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0011\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lv8/f;", "", "receiver", "completion", "Lkotlin/Function1;", "", "Lr8/z;", "onCancellation", "b", "(Lc9/p;Ljava/lang/Object;Lv8/f;Lc9/l;)V", "fatalCompletion", "c", "(Lv8/f;Lv8/f;)V", "e", "a", "(Lv8/f;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class a {
    private static final void a(f<?> fVar, Throwable th) throws Throwable {
        q.Companion companion = q.INSTANCE;
        fVar.resumeWith(q.a(r.a(th)));
        throw th;
    }

    public static /* synthetic */ void d(p pVar, Object obj, f fVar, l lVar, int i10, Object obj2) throws Throwable {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        b(pVar, obj, fVar, lVar);
    }

    public static final <R, T> void b(p<? super R, ? super f<? super T>, ? extends Object> pVar, R r10, f<? super T> fVar, l<? super Throwable, z> lVar) throws Throwable {
        try {
            f fVarB = kotlin.coroutines.intrinsics.b.b(kotlin.coroutines.intrinsics.b.a(pVar, r10, fVar));
            q.Companion companion = q.INSTANCE;
            k.b(fVarB, q.a(z.f17874a), lVar);
        } catch (Throwable th) {
            a(fVar, th);
        }
    }

    public static final void c(f<? super z> fVar, f<?> fVar2) throws Throwable {
        try {
            f fVarB = kotlin.coroutines.intrinsics.b.b(fVar);
            q.Companion companion = q.INSTANCE;
            k.c(fVarB, q.a(z.f17874a), null, 2, null);
        } catch (Throwable th) {
            a(fVar2, th);
        }
    }
}
