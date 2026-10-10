package m2;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class y<T> implements r2.b<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Set<T> f15587b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Set<r2.b<T>> f15586a = Collections.newSetFromMap(new ConcurrentHashMap());

    private synchronized void d() {
        try {
            Iterator<r2.b<T>> it = this.f15586a.iterator();
            while (it.hasNext()) {
                this.f15587b.add(it.next().get());
            }
            this.f15586a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void a(r2.b<T> bVar) {
        try {
            if (this.f15587b == null) {
                this.f15586a.add(bVar);
            } else {
                this.f15587b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static y<?> b(Collection<r2.b<?>> collection) {
        return new y<>((Set) collection);
    }

    @Override // r2.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f15587b == null) {
            synchronized (this) {
                try {
                    if (this.f15587b == null) {
                        this.f15587b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableSet(this.f15587b);
    }

    y(Collection<r2.b<T>> collection) {
        this.f15586a.addAll(collection);
    }
}
