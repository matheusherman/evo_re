package m;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i implements m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<a, Object> f15433a = new g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f15434b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f15435c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, m.a<?>> f15436d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15438f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f15439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f15441c;

        @Override // m.m
        public void a() {
            this.f15439a.c(this);
        }

        void b(int i10, Class<?> cls) {
            this.f15440b = i10;
            this.f15441c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f15440b == aVar.f15440b && this.f15441c == aVar.f15441c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = this.f15440b * 31;
            Class<?> cls = this.f15441c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f15440b + "array=" + this.f15441c + '}';
        }

        a(b bVar) {
            this.f15439a = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b extends c<a> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        b() {
        }

        a e(int i10, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i10, cls);
            return aVarB;
        }
    }

    @Override // m.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                g(this.f15437e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // m.b
    public synchronized void b() {
        g(0);
    }

    @Override // m.b
    public synchronized <T> T c(int i10, Class<T> cls) {
        return (T) k(this.f15434b.e(i10, cls), cls);
    }

    @Override // m.b
    public synchronized <T> T d(int i10, Class<T> cls) {
        Integer numCeilingKey;
        try {
            numCeilingKey = l(cls).ceilingKey(Integer.valueOf(i10));
        } catch (Throwable th) {
            throw th;
        }
        return (T) k(o(i10, numCeilingKey) ? this.f15434b.e(numCeilingKey.intValue(), cls) : this.f15434b.e(i10, cls), cls);
    }

    @Override // m.b
    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        m.a<T> aVarI = i(cls);
        int iB = aVarI.b(t10);
        int iA = aVarI.a() * iB;
        if (n(iA)) {
            a aVarE = this.f15434b.e(iB, cls);
            this.f15433a.d(aVarE, t10);
            NavigableMap<Integer, Integer> navigableMapL = l(cls);
            Integer num = navigableMapL.get(Integer.valueOf(aVarE.f15440b));
            Integer numValueOf = Integer.valueOf(aVarE.f15440b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f15438f += iA;
            f();
        }
    }

    private void f() {
        g(this.f15437e);
    }

    private void g(int i10) {
        while (this.f15438f > i10) {
            Object objF = this.f15433a.f();
            e0.k.d(objF);
            m.a aVarH = h(objF);
            this.f15438f -= aVarH.b(objF) * aVarH.a();
            e(aVarH.b(objF), objF.getClass());
            if (Log.isLoggable(aVarH.getTag(), 2)) {
                Log.v(aVarH.getTag(), "evicted: " + aVarH.b(objF));
            }
        }
    }

    private <T> m.a<T> i(Class<T> cls) {
        m.a<T> fVar;
        m.a<T> aVar = (m.a) this.f15436d.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            fVar = new h();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            fVar = new f();
        }
        this.f15436d.put(cls, fVar);
        return fVar;
    }

    @Nullable
    private <T> T j(a aVar) {
        return (T) this.f15433a.a(aVar);
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f15435c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f15435c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i10 = this.f15438f;
        return i10 == 0 || this.f15437e / i10 >= 2;
    }

    private boolean n(int i10) {
        return i10 <= this.f15437e / 2;
    }

    private boolean o(int i10, Integer num) {
        if (num != null) {
            return m() || num.intValue() <= i10 * 8;
        }
        return false;
    }

    public i(int i10) {
        this.f15437e = i10;
    }

    private void e(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapL = l(cls);
        Integer num = navigableMapL.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i10));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    private <T> m.a<T> h(T t10) {
        return i(t10.getClass());
    }

    private <T> T k(a aVar, Class<T> cls) {
        m.a<T> aVarI = i(cls);
        T t10 = (T) j(aVar);
        if (t10 != null) {
            this.f15438f -= aVarI.b(t10) * aVarI.a();
            e(aVarI.b(t10), cls);
        }
        if (t10 == null) {
            if (Log.isLoggable(aVarI.getTag(), 2)) {
                Log.v(aVarI.getTag(), "Allocated " + aVar.f15440b + " bytes");
            }
            return aVarI.newArray(aVar.f15440b);
        }
        return t10;
    }
}
