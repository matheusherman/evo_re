package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x2;
import r8.z;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017RD\u0010\u001f\u001a2\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u001a0\u0018j\u0002`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070#8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/sync/b;", "Lkotlinx/coroutines/sync/d;", "Lkotlinx/coroutines/sync/a;", "", "locked", "<init>", "(Z)V", "", "owner", "", "m", "(Ljava/lang/Object;)I", "Lr8/z;", "p", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "r", "a", "q", "(Ljava/lang/Object;)Z", "b", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function3;", "Lxa/b;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "h", "Lc9/q;", "onSelectCancellationUnlockConstructor", "n", "()Z", "isLocked", "Lkotlinx/atomicfu/AtomicRef;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class b extends d implements kotlinx.coroutines.sync.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14912i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final q<xa.b<?>, Object, Object, l<Throwable, z>> onSelectCancellationUnlockConstructor;
    private volatile Object owner;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0097\u0001¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0015\u001a\u00020\u00022\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\u0012j\u0002`\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011J\u001c\u0010\u001c\u001a\u00020\u0002*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\"\u001a\u00020\u00022\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010!\u001a\u00020 H\u0096\u0001¢\u0006\u0004\b\"\u0010#J9\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00062\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010*R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010+R\u0014\u0010/\u001a\u00020,8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lkotlinx/coroutines/sync/b$a;", "Lkotlinx/coroutines/n;", "Lr8/z;", "Lkotlinx/coroutines/x2;", "Lkotlinx/coroutines/o;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/b;Lkotlinx/coroutines/o;Ljava/lang/Object;)V", "", "cause", "", "u", "(Ljava/lang/Throwable;)Z", "token", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "h", "(Lc9/l;)V", "Lr8/q;", "result", "resumeWith", "Lkotlinx/coroutines/i0;", "value", "c", "(Lkotlinx/coroutines/i0;Lr8/z;)V", "Lkotlinx/coroutines/internal/c0;", "segment", "", "index", "b", "(Lkotlinx/coroutines/internal/c0;I)V", "idempotent", "onCancellation", "d", "(Lr8/z;Ljava/lang/Object;Lc9/l;)Ljava/lang/Object;", "a", "(Lr8/z;Lc9/l;)V", "Lkotlinx/coroutines/o;", "Ljava/lang/Object;", "Lv8/j;", "getContext", "()Lv8/j;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a implements n<z>, x2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final o<z> cont;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Object owner;

        /* JADX INFO: renamed from: kotlinx.coroutines.sync.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class C0293a extends kotlin.jvm.internal.o implements l<Throwable, z> {
            final /* synthetic */ b this$0;
            final /* synthetic */ a this$1;

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(Throwable th) {
                invoke2(th);
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0293a(b bVar, a aVar) {
                super(1);
                this.this$0 = bVar;
                this.this$1 = aVar;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.b(this.this$1.owner);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.sync.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class C0294b extends kotlin.jvm.internal.o implements l<Throwable, z> {
            final /* synthetic */ b this$0;
            final /* synthetic */ a this$1;

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(Throwable th) {
                invoke2(th);
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0294b(b bVar, a aVar) {
                super(1);
                this.this$0 = bVar;
                this.this$1 = aVar;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                b.f14912i.set(this.this$0, this.this$1.owner);
                this.this$0.b(this.this$1.owner);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(o<? super z> oVar, Object obj) {
            this.cont = oVar;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.n
        public void A(Object token) {
            this.cont.A(token);
        }

        @Override // kotlinx.coroutines.x2
        public void b(c0<?> segment, int index) {
            this.cont.b(segment, index);
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void o(i0 i0Var, z zVar) {
            this.cont.o(i0Var, zVar);
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object e(z value, Object idempotent, l<? super Throwable, z> onCancellation) {
            Object objE = this.cont.e(value, idempotent, new C0294b(b.this, this));
            if (objE != null) {
                b.f14912i.set(b.this, this.owner);
            }
            return objE;
        }

        @Override // v8.f
        public j getContext() {
            return this.cont.getContext();
        }

        @Override // kotlinx.coroutines.n
        public void h(l<? super Throwable, z> handler) {
            this.cont.h(handler);
        }

        @Override // v8.f
        public void resumeWith(Object result) {
            this.cont.resumeWith(result);
        }

        @Override // kotlinx.coroutines.n
        public boolean u(Throwable cause) {
            return this.cont.u(cause);
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void q(z value, l<? super Throwable, z> onCancellation) {
            b.f14912i.set(b.this, this.owner);
            this.cont.q(value, new C0293a(b.this, this));
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lxa/b;", "<anonymous parameter 0>", "", "owner", "<anonymous parameter 2>", "Lkotlin/Function1;", "", "Lr8/z;", "a", "(Lxa/b;Ljava/lang/Object;Ljava/lang/Object;)Lc9/l;"}, k = 3, mv = {1, 8, 0})
    static final class C0295b extends kotlin.jvm.internal.o implements q<xa.b<?>, Object, Object, l<? super Throwable, ? extends z>> {

        /* JADX INFO: renamed from: kotlinx.coroutines.sync.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements l<Throwable, z> {
            final /* synthetic */ Object $owner;
            final /* synthetic */ b this$0;

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(Throwable th) {
                invoke2(th);
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.this$0 = bVar;
                this.$owner = obj;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.b(this.$owner);
            }
        }

        C0295b() {
            super(3);
        }

        @Override // c9.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l<Throwable, z> invoke(xa.b<?> bVar, Object obj, Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : c.f14917a;
        this.onSelectCancellationUnlockConstructor = new C0295b();
    }

    public String toString() {
        return "Mutex@" + p0.b(this) + "[isLocked=" + n() + ",owner=" + f14912i.get(this) + ']';
    }

    private final int m(Object owner) {
        while (n()) {
            Object obj = f14912i.get(this);
            if (obj != c.f14917a) {
                if (obj == owner) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object o(b bVar, Object obj, v8.f<? super z> fVar) {
        if (bVar.q(obj)) {
            return z.f17874a;
        }
        Object objP = bVar.p(obj, fVar);
        if (objP == kotlin.coroutines.intrinsics.b.c()) {
            return objP;
        }
        return z.f17874a;
    }

    private final Object p(Object obj, v8.f<? super z> fVar) {
        o oVarB = kotlinx.coroutines.q.b(kotlin.coroutines.intrinsics.b.b(fVar));
        try {
            c(new a(oVarB, obj));
            Object objZ = oVarB.z();
            if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                h.c(fVar);
            }
            if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                return objZ;
            }
            return z.f17874a;
        } catch (Throwable th) {
            oVarB.M();
            throw th;
        }
    }

    private final int r(Object owner) {
        while (!i()) {
            if (owner == null) {
                return 1;
            }
            int iM = m(owner);
            if (iM == 1) {
                return 2;
            }
            if (iM == 2) {
                return 1;
            }
        }
        f14912i.set(this, owner);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.a
    public Object a(Object obj, v8.f<? super z> fVar) {
        return o(this, obj, fVar);
    }

    @Override // kotlinx.coroutines.sync.a
    public void b(Object owner) {
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14912i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != c.f14917a) {
                if (obj != owner && owner != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj + ", but " + owner + " is expected").toString());
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c.f14917a)) {
                    h();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public boolean n() {
        if (g() == 0) {
            return true;
        }
        return false;
    }

    public boolean q(Object owner) {
        int iR = r(owner);
        if (iR == 0) {
            return true;
        }
        if (iR != 1) {
            if (iR != 2) {
                throw new IllegalStateException("unexpected");
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
        }
        return false;
    }
}
