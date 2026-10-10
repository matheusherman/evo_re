package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n0 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f4647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f4648b;

        /* JADX INFO: renamed from: com.google.common.collect.n0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0050a extends com.google.common.collect.b<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<? extends E> f4649c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final Iterator<? extends E> f4650d;

            C0050a() {
                this.f4649c = a.this.f4647a.iterator();
                this.f4650d = a.this.f4648b.iterator();
            }

            @Override // com.google.common.collect.b
            protected E c() {
                if (this.f4649c.hasNext()) {
                    return this.f4649c.next();
                }
                while (this.f4650d.hasNext()) {
                    E next = this.f4650d.next();
                    if (!a.this.f4647a.contains(next)) {
                        return next;
                    }
                }
                return d();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f4647a = set;
            this.f4648b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f4647a.contains(obj) || this.f4648b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public s0<E> iterator() {
            return new C0050a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f4647a.isEmpty() && this.f4648b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f4647a.size();
            Iterator<E> it = this.f4648b.iterator();
            while (it.hasNext()) {
                if (!this.f4647a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<E> extends AbstractSet<E> {
        /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX INFO: renamed from: e */
        public abstract s0<E> iterator();

        private b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> b<E> c(Set<? extends E> set, Set<? extends E> set2) {
        com.google.common.base.m.j(set, "set1");
        com.google.common.base.m.j(set2, "set2");
        return new a(set, set2);
    }

    static int b(Set<?> set) {
        int iHashCode;
        int i10 = 0;
        for (Object obj : set) {
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            i10 = ~(~(i10 + iHashCode));
        }
        return i10;
    }
}
