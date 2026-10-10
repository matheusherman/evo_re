package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u0000 &2\u00020\u0001:\u0001'J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H'¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlinx/coroutines/u1;", "Lv8/j$b;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "j", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "Lr8/z;", "a", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/v;", "child", "Lkotlinx/coroutines/t;", "z", "(Lkotlinx/coroutines/v;)Lkotlinx/coroutines/t;", "s", "(Lv8/f;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/b1;", "x", "(Lc9/l;)Lkotlinx/coroutines/b1;", "onCancelling", "invokeImmediately", "n", "(ZZLc9/l;)Lkotlinx/coroutines/b1;", "getParent", "()Lkotlinx/coroutines/u1;", "getParent$annotations", "()V", "parent", "isActive", "isCancelled", "k0", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface u1 extends v8.j.b {

    /* JADX INFO: renamed from: k0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f14940a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(u1 u1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            u1Var.a(cancellationException);
        }

        public static /* synthetic */ b1 d(u1 u1Var, boolean z10, boolean z11, c9.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return u1Var.n(z10, z11, lVar);
        }

        public static <R> R b(u1 u1Var, R r10, c9.p<? super R, ? super v8.j.b, ? extends R> pVar) {
            return (R) v8.j.b.a.a(u1Var, r10, pVar);
        }

        public static <E extends v8.j.b> E c(u1 u1Var, v8.j.c<E> cVar) {
            return (E) v8.j.b.a.b(u1Var, cVar);
        }

        public static v8.j e(u1 u1Var, v8.j.c<?> cVar) {
            return v8.j.b.a.c(u1Var, cVar);
        }

        public static v8.j f(u1 u1Var, v8.j jVar) {
            return v8.j.b.a.d(u1Var, jVar);
        }
    }

    void a(CancellationException cause);

    u1 getParent();

    boolean isActive();

    boolean isCancelled();

    CancellationException j();

    b1 n(boolean onCancelling, boolean invokeImmediately, c9.l<? super Throwable, r8.z> handler);

    Object s(v8.f<? super r8.z> fVar);

    boolean start();

    b1 x(c9.l<? super Throwable, r8.z> handler);

    t z(v child);

    /* JADX INFO: renamed from: kotlinx.coroutines.u1$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/u1$b;", "Lv8/j$c;", "Lkotlinx/coroutines/u1;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements v8.j.c<u1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f14940a = new Companion();

        private Companion() {
        }
    }
}
