package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<T> extends s0<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f4689b = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f4690a;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4690a != f4689b;
        }

        @Override // java.util.Iterator
        public T next() {
            T t10 = (T) this.f4690a;
            Object obj = f4689b;
            if (t10 == obj) {
                throw new NoSuchElementException();
            }
            this.f4690a = obj;
            return t10;
        }

        a(T t10) {
            this.f4690a = t10;
        }
    }

    public static <T> s0<T> d(T t10) {
        return new a(t10);
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.m.i(collection);
        com.google.common.base.m.i(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean b(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.k.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> T c(Iterator<? extends T> it, T t10) {
        if (it.hasNext()) {
            return it.next();
        }
        return t10;
    }
}
