package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/g0;", "Lkotlinx/coroutines/flow/internal/d;", "Lkotlinx/coroutines/flow/e0;", "<init>", "()V", "flow", "", "d", "(Lkotlinx/coroutines/flow/e0;)Z", "", "Lv8/f;", "Lr8/z;", "f", "(Lkotlinx/coroutines/flow/e0;)[Lv8/f;", "g", "h", "()Z", "e", "(Lv8/f;)Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class g0 extends kotlinx.coroutines.flow.internal.d<e0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14718a = AtomicReferenceFieldUpdater.newUpdater(g0.class, Object.class, "_state");
    private volatile Object _state;

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(e0<?> flow) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14718a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, f0.f14716a);
        return true;
    }

    public final Object e(v8.f<? super r8.z> fVar) {
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        if (!androidx.concurrent.futures.a.a(f14718a, this, f0.f14716a, oVar)) {
            r8.q.Companion companion = r8.q.INSTANCE;
            oVar.resumeWith(r8.q.a(r8.z.f17874a));
        }
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public v8.f<r8.z>[] b(e0<?> flow) {
        f14718a.set(this, null);
        return kotlinx.coroutines.flow.internal.c.f14726a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14718a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == f0.f14717b) {
                return;
            }
            if (obj == f0.f14716a) {
                if (androidx.concurrent.futures.a.a(f14718a, this, obj, f0.f14717b)) {
                    return;
                }
            } else if (androidx.concurrent.futures.a.a(f14718a, this, obj, f0.f14716a)) {
                r8.q.Companion companion = r8.q.INSTANCE;
                ((kotlinx.coroutines.o) obj).resumeWith(r8.q.a(r8.z.f17874a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f14718a.getAndSet(this, f0.f14716a);
        kotlin.jvm.internal.m.c(andSet);
        return andSet == f0.f14717b;
    }
}
