package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/l2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/o;", "continuation", "<init>", "(Lkotlinx/coroutines/o;)V", "", "cause", "Lr8/z;", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/o;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class l2<T> extends b2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final o<T> continuation;

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        s(th);
        return r8.z.f17874a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l2(o<? super T> oVar) {
        this.continuation = oVar;
    }

    @Override // kotlinx.coroutines.d0
    public void s(Throwable cause) {
        Object objB0 = t().b0();
        if (objB0 instanceof b0) {
            o<T> oVar = this.continuation;
            r8.q.Companion companion = r8.q.INSTANCE;
            oVar.resumeWith(r8.q.a(r8.r.a(((b0) objB0).cause)));
        } else {
            o<T> oVar2 = this.continuation;
            r8.q.Companion companion2 = r8.q.INSTANCE;
            oVar2.resumeWith(r8.q.a(d2.h(objB0)));
        }
    }
}
