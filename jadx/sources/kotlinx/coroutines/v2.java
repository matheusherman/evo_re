package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/v2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/b0;", "Lv8/j;", "context", "Lv8/f;", "uCont", "<init>", "(Lv8/j;Lv8/f;)V", "", "oldValue", "Lr8/z;", "N0", "(Lv8/j;Ljava/lang/Object;)V", "", "M0", "()Z", "state", "I0", "(Ljava/lang/Object;)V", "Ljava/lang/ThreadLocal;", "Lr8/p;", "e", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "threadLocalIsSet", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class v2<T> extends kotlinx.coroutines.internal.b0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ThreadLocal<r8.p<v8.j, Object>> threadStateToRecover;
    private volatile boolean threadLocalIsSet;

    public final void N0(v8.j context, Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(r8.v.a(context, oldValue));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public v2(v8.j jVar, v8.f<? super T> fVar) {
        w2 w2Var = w2.f14945a;
        super(jVar.get(w2Var) == null ? jVar.plus(w2Var) : jVar, fVar);
        this.threadStateToRecover = new ThreadLocal<>();
        if (fVar.getContext().get(v8.g.INSTANCE) instanceof i0) {
            return;
        }
        Object objC = kotlinx.coroutines.internal.j0.c(jVar, null);
        kotlinx.coroutines.internal.j0.a(jVar, objC);
        N0(jVar, objC);
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    protected void I0(Object state) {
        if (this.threadLocalIsSet) {
            r8.p<v8.j, Object> pVar = this.threadStateToRecover.get();
            if (pVar != null) {
                kotlinx.coroutines.internal.j0.a(pVar.a(), pVar.b());
            }
            this.threadStateToRecover.remove();
        }
        Object objA = f0.a(state, this.uCont);
        v8.f<T> fVar = this.uCont;
        v8.j context = fVar.getContext();
        Object objC = kotlinx.coroutines.internal.j0.c(context, null);
        v2<?> v2VarG = objC != kotlinx.coroutines.internal.j0.f14832a ? h0.g(fVar, context, objC) : null;
        try {
            this.uCont.resumeWith(objA);
            r8.z zVar = r8.z.f17874a;
        } finally {
            if (v2VarG == null || v2VarG.M0()) {
                kotlinx.coroutines.internal.j0.a(context, objC);
            }
        }
    }

    public final boolean M0() {
        boolean z10 = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z10;
    }
}
