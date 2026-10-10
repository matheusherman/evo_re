package h2;

import com.google.common.base.i;
import com.google.common.base.m;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b extends c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Future<V> f10742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h2.a<? super V> f10743b;

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f10742a;
            if ((future instanceof i2.a) && (thA = i2.b.a((i2.a) future)) != null) {
                this.f10743b.b(thA);
                return;
            }
            try {
                this.f10743b.a(b.b(this.f10742a));
            } catch (ExecutionException e10) {
                this.f10743b.b(e10.getCause());
            } catch (Throwable th) {
                this.f10743b.b(th);
            }
        }

        a(Future<V> future, h2.a<? super V> aVar) {
            this.f10742a = future;
            this.f10743b = aVar;
        }

        public String toString() {
            return i.a(this).c(this.f10743b).toString();
        }
    }

    public static <V> void a(d<V> dVar, h2.a<? super V> aVar, Executor executor) {
        m.i(aVar);
        dVar.addListener(new a(dVar, aVar), executor);
    }

    public static <V> V b(Future<V> future) {
        m.p(future.isDone(), "Future was expected to be done: %s", future);
        return (V) e.a(future);
    }
}
