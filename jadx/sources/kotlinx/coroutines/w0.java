package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000b\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/w0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/b0;", "Lv8/j;", "context", "Lv8/f;", "uCont", "<init>", "(Lv8/j;Lv8/f;)V", "", "O0", "()Z", "N0", "", "state", "Lr8/z;", "F", "(Ljava/lang/Object;)V", "I0", "M0", "()Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicInt;", "_decision", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class w0<T> extends kotlinx.coroutines.internal.b0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14944e = AtomicIntegerFieldUpdater.newUpdater(w0.class, "_decision");
    private volatile int _decision;

    private final boolean N0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14944e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f14944e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean O0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14944e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f14944e.compareAndSet(this, 0, 1));
        return true;
    }

    public w0(v8.j jVar, v8.f<? super T> fVar) {
        super(jVar, fVar);
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.c2
    protected void F(Object state) {
        I0(state);
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    protected void I0(Object state) {
        if (N0()) {
            return;
        }
        kotlinx.coroutines.internal.k.c(kotlin.coroutines.intrinsics.b.b(this.uCont), f0.a(state, this.uCont), null, 2, null);
    }

    public final Object M0() {
        if (O0()) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        Object objH = d2.h(b0());
        if (!(objH instanceof b0)) {
            return objH;
        }
        throw ((b0) objH).cause;
    }
}
