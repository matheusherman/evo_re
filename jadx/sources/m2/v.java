package m2;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class v implements p2.d, p2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<Class<?>, ConcurrentHashMap<p2.b<Object>, Executor>> f15580a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private Queue<p2.a<?>> f15581b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f15582c;

    private synchronized Set<Map.Entry<p2.b<Object>, Executor>> d(p2.a<?> aVar) {
        ConcurrentHashMap<p2.b<Object>, Executor> concurrentHashMap;
        try {
            concurrentHashMap = this.f15580a.get(aVar.b());
        } catch (Throwable th) {
            throw th;
        }
        return concurrentHashMap == null ? Collections.EMPTY_SET : concurrentHashMap.entrySet();
    }

    @Override // p2.d
    public synchronized <T> void a(Class<T> cls, Executor executor, p2.b<? super T> bVar) {
        try {
            d0.b(cls);
            d0.b(bVar);
            d0.b(executor);
            if (!this.f15580a.containsKey(cls)) {
                this.f15580a.put(cls, new ConcurrentHashMap<>());
            }
            this.f15580a.get(cls).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    void c() {
        Queue<p2.a<?>> queue;
        synchronized (this) {
            try {
                queue = this.f15581b;
                if (queue != null) {
                    this.f15581b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator<p2.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
        }
    }

    v(Executor executor) {
        this.f15582c = executor;
    }

    public void e(final p2.a<?> aVar) {
        d0.b(aVar);
        synchronized (this) {
            try {
                Queue<p2.a<?>> queue = this.f15581b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry<p2.b<Object>, Executor> entry : d(aVar)) {
                    entry.getValue().execute(new Runnable() { // from class: m2.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((p2.b) entry.getKey()).a(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
