package sa;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.j;
import kotlin.collections.v0;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class g<T> extends AbstractSet<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f18524c = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f18525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18526b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<T> implements Iterator<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<T> f18527a;

        public a(T[] array) {
            m.f(array, "array");
            this.f18527a = kotlin.jvm.internal.b.a(array);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18527a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f18527a.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final <T> g<T> a() {
            return new g<>(null);
        }

        public final <T> g<T> b(Collection<? extends T> set) {
            m.f(set, "set");
            g<T> gVar = new g<>(null);
            gVar.addAll(set);
            return gVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c<T> implements Iterator<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f18528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f18529b = true;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18529b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f18529b) {
                throw new NoSuchElementException();
            }
            this.f18529b = false;
            return this.f18528a;
        }

        public c(T t10) {
            this.f18528a = t10;
        }
    }

    public /* synthetic */ g(kotlin.jvm.internal.g gVar) {
        this();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f18525a = null;
        g(0);
    }

    private g() {
    }

    public static final <T> g<T> e() {
        return f18524c.a();
    }

    public int f() {
        return this.f18526b;
    }

    public void g(int i10) {
        this.f18526b = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t10) {
        Object obj;
        if (size() == 0) {
            this.f18525a = t10;
        } else if (size() == 1) {
            if (m.a(this.f18525a, t10)) {
                return false;
            }
            this.f18525a = new Object[]{this.f18525a, t10};
        } else if (size() < 5) {
            Object obj2 = this.f18525a;
            m.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj2;
            if (j.J(objArr, t10)) {
                return false;
            }
            if (size() == 4) {
                LinkedHashSet linkedHashSetF = v0.f(Arrays.copyOf(objArr, objArr.length));
                linkedHashSetF.add(t10);
                obj = linkedHashSetF;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                m.e(objArrCopyOf, "copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t10;
                obj = objArrCopyOf;
            }
            this.f18525a = obj;
        } else {
            Object obj3 = this.f18525a;
            m.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!h0.e(obj3).add(t10)) {
                return false;
            }
        }
        g(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.a(this.f18525a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f18525a;
            m.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return j.J((Object[]) obj2, obj);
        }
        Object obj3 = this.f18525a;
        m.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new c(this.f18525a);
        }
        if (size() < 5) {
            Object obj = this.f18525a;
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f18525a;
        m.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return h0.e(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
