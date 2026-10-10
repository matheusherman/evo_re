package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\bR\u0013\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00108\u0002X\u0082\u0004¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/y;", "<init>", "()V", "", "decision", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "d", "failure", "Lr8/z;", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "Lkotlinx/atomicfu/AtomicRef;", "_consensus", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class b<T> extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14811a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f14810a;

    public abstract void b(T affected, Object failure);

    public abstract Object d(T affected);

    private final Object c(Object decision) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14811a;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Object obj2 = a.f14810a;
        if (obj != obj2) {
            return obj;
        }
        return androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, decision) ? decision : atomicReferenceFieldUpdater.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.y
    public final Object a(Object affected) {
        Object objC = f14811a.get(this);
        if (objC == a.f14810a) {
            objC = c(d(affected));
        }
        b(affected, objC);
        return objC;
    }
}
