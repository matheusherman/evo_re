package n;

import e0.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f15811a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f15812b = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f15815a = new ArrayDeque();

        a a() {
            a aVarPoll;
            synchronized (this.f15815a) {
                aVarPoll = this.f15815a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void b(a aVar) {
            synchronized (this.f15815a) {
                try {
                    if (this.f15815a.size() < 10) {
                        this.f15815a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        b() {
        }
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            try {
                aVarA = this.f15811a.get(str);
                if (aVarA == null) {
                    aVarA = this.f15812b.a();
                    this.f15811a.put(str, aVarA);
                }
                aVarA.f15814b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVarA.f15813a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) k.d(this.f15811a.get(str));
                int i10 = aVar.f15814b;
                if (i10 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f15814b);
                }
                int i11 = i10 - 1;
                aVar.f15814b = i11;
                if (i11 == 0) {
                    a aVarRemove = this.f15811a.remove(str);
                    if (!aVarRemove.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                    }
                    this.f15812b.b(aVarRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f15813a.unlock();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f15813a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15814b;

        a() {
        }
    }

    c() {
    }
}
