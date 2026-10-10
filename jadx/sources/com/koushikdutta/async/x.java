package com.koushikdutta.async;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class x extends LinkedList<Runnable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<Thread, x> f5165a = new WeakHashMap<>();
    Semaphore queueSemaphore = new Semaphore(0);
    b waiter;

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Runnable runnable) {
        boolean zAdd;
        synchronized (this) {
            zAdd = super.add(runnable);
        }
        return zAdd;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Runnable remove() {
        synchronized (this) {
            try {
                if (isEmpty()) {
                    return null;
                }
                return (Runnable) super.remove();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static x g(Thread thread) {
        x xVar;
        WeakHashMap<Thread, x> weakHashMap = f5165a;
        synchronized (weakHashMap) {
            try {
                xVar = weakHashMap.get(thread);
                if (xVar == null) {
                    xVar = new x();
                    weakHashMap.put(thread, xVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    static void h(b bVar) {
        WeakHashMap<Thread, x> weakHashMap = f5165a;
        synchronized (weakHashMap) {
            try {
                for (x xVar : weakHashMap.values()) {
                    if (xVar.waiter == bVar) {
                        xVar.queueSemaphore.release();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this) {
            zRemove = super.remove(obj);
        }
        return zRemove;
    }

    x() {
    }
}
