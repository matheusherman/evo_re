package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00060\u0000j\u0002`\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0082\u0010¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0011\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001a\u001a\u00020\u00192\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0015\u0010(\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0015\u0010*\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\b)\u0010\u001fR\u0011\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010+8\u0002X\u0082\u0004R\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00000+8\u0002X\u0082\u0004R\u0013\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0082\u0004¨\u00060"}, d2 = {"Lkotlinx/coroutines/internal/q;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/z;", "q", "()Lkotlinx/coroutines/internal/z;", "Lkotlinx/coroutines/internal/Node;", "current", "h", "(Lkotlinx/coroutines/internal/q;)Lkotlinx/coroutines/internal/q;", "next", "Lr8/z;", "j", "(Lkotlinx/coroutines/internal/q;)V", "Lkotlinx/coroutines/internal/y;", "op", "g", "(Lkotlinx/coroutines/internal/y;)Lkotlinx/coroutines/internal/q;", "node", "", "e", "(Lkotlinx/coroutines/internal/q;)Z", "Lkotlinx/coroutines/internal/q$a;", "condAdd", "", "r", "(Lkotlinx/coroutines/internal/q;Lkotlinx/coroutines/internal/q;Lkotlinx/coroutines/internal/q$a;)I", "o", "()Z", "p", "()Lkotlinx/coroutines/internal/q;", "", "toString", "()Ljava/lang/String;", "n", "isRemoved", "k", "()Ljava/lang/Object;", "l", "nextNode", "m", "prevNode", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "_removedRef", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14860a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14861b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14862c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/internal/q$a;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/internal/Node;", "newNode", "<init>", "(Lkotlinx/coroutines/internal/q;)V", "affected", "", "failure", "Lr8/z;", "e", "(Lkotlinx/coroutines/internal/q;Ljava/lang/Object;)V", "b", "Lkotlinx/coroutines/internal/q;", "c", "oldNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class a extends kotlinx.coroutines.internal.b<q> {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final q newNode;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public q oldNext;

        @Override // kotlinx.coroutines.internal.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(q affected, Object failure) {
            boolean z10 = failure == null;
            q qVar = z10 ? this.newNode : this.oldNext;
            if (qVar != null && androidx.concurrent.futures.a.a(q.f14860a, affected, this, qVar) && z10) {
                q qVar2 = this.newNode;
                q qVar3 = this.oldNext;
                kotlin.jvm.internal.m.c(qVar3);
                qVar2.j(qVar3);
            }
        }

        public a(q qVar) {
            this.newNode = qVar;
        }
    }

    public final q m() {
        q qVarG = g(null);
        return qVarG == null ? h((q) f14861b.get(this)) : qVarG;
    }

    private final q g(y op) {
        q qVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        loop0: while (true) {
            q qVar2 = (q) f14861b.get(this);
            qVar = qVar2;
            while (true) {
                q qVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f14860a;
                    obj = atomicReferenceFieldUpdater.get(qVar);
                    if (obj == this) {
                        if (qVar2 != qVar && !androidx.concurrent.futures.a.a(f14861b, this, qVar2, qVar)) {
                            break;
                        }
                        break;
                    }
                    if (n()) {
                        return null;
                    }
                    if (obj == op) {
                        break loop0;
                    }
                    if (obj instanceof y) {
                        ((y) obj).a(qVar);
                        break;
                    }
                    if (!(obj instanceof z)) {
                        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        qVar3 = qVar;
                        qVar = (q) obj;
                    } else {
                        if (qVar3 != null) {
                            break;
                        }
                        qVar = (q) f14861b.get(qVar);
                    }
                }
                if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, qVar3, qVar, ((z) obj).ref)) {
                    break;
                }
                qVar = qVar3;
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(q next) {
        q qVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14861b;
        do {
            qVar = (q) atomicReferenceFieldUpdater.get(next);
            if (k() != next) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f14861b, next, qVar, this));
        if (n()) {
            next.g(null);
        }
    }

    private final z q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14862c;
        z zVar = (z) atomicReferenceFieldUpdater.get(this);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        atomicReferenceFieldUpdater.lazySet(this, zVar2);
        return zVar2;
    }

    public final boolean e(q node) {
        f14861b.lazySet(node, this);
        f14860a.lazySet(node, this);
        while (k() == this) {
            if (androidx.concurrent.futures.a.a(f14860a, this, this, node)) {
                node.j(this);
                return true;
            }
        }
        return false;
    }

    public final Object k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14860a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final int r(q node, q next, a condAdd) {
        f14861b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14860a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return condAdd.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new kotlin.jvm.internal.u(this) { // from class: kotlinx.coroutines.internal.q.b
            @Override // kotlin.jvm.internal.u, i9.l
            public Object get() {
                return kotlinx.coroutines.p0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.p0.b(this);
    }

    private final q h(q current) {
        while (current.n()) {
            current = (q) f14861b.get(current);
        }
        return current;
    }

    public final q l() {
        return p.b(k());
    }

    public boolean n() {
        return k() instanceof z;
    }

    public boolean o() {
        if (p() == null) {
            return true;
        }
        return false;
    }

    public final q p() {
        Object objK;
        q qVar;
        do {
            objK = k();
            if (objK instanceof z) {
                return ((z) objK).ref;
            }
            if (objK == this) {
                return (q) objK;
            }
            kotlin.jvm.internal.m.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            qVar = (q) objK;
        } while (!androidx.concurrent.futures.a.a(f14860a, this, objK, qVar.q()));
        qVar.g(null);
        return null;
    }
}
