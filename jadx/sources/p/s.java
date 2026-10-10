package p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f17217e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final o<Object, Object> f17218f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f17219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f17220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f17221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17222d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<Model> f17223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<Data> f17224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final p<? extends Model, ? extends Data> f17225c;

        public boolean a(@NonNull Class<?> cls) {
            return this.f17223a.isAssignableFrom(cls);
        }

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
            this.f17223a = cls;
            this.f17224b = cls2;
            this.f17225c = pVar;
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (a(cls) && this.f17224b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c {
        @NonNull
        public <Model, Data> r<Model, Data> a(@NonNull List<o<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new r<>(list, pool);
        }

        c() {
        }
    }

    public s(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f17217e);
    }

    synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        a(cls, cls2, pVar, true);
    }

    @NonNull
    synchronized <Model> List<o<Model, ?>> c(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f17219a) {
                if (!this.f17221c.contains(bVar) && bVar.a(cls)) {
                    this.f17221c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f17221c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f17221c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> o<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f17219a) {
                if (this.f17221c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f17221c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f17221c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f17220b.a(arrayList, this.f17222d);
            }
            if (arrayList.size() == 1) {
                return (o) arrayList.get(0);
            }
            if (!z10) {
                throw new com.bumptech.glide.i.c((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f17221c.clear();
            throw th;
        }
    }

    @NonNull
    synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f17219a) {
            if (!arrayList.contains(bVar.f17224b) && bVar.a(cls)) {
                arrayList.add(bVar.f17224b);
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model, Data> List<p<? extends Model, ? extends Data>> i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f17219a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model, Data> List<p<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        List<p<? extends Model, ? extends Data>> listI;
        listI = i(cls, cls2);
        b(cls, cls2, pVar);
        return listI;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a implements o<Object, Object> {
        @Override // p.o
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // p.o
        @Nullable
        public o.a<Object> b(@NonNull Object obj, int i10, int i11, @NonNull j.i iVar) {
            return null;
        }

        a() {
        }
    }

    @VisibleForTesting
    s(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f17219a = new ArrayList();
        this.f17221c = new HashSet();
        this.f17222d = pool;
        this.f17220b = cVar;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar, boolean z10) {
        b<?, ?> bVar = new b<>(cls, cls2, pVar);
        List<b<?, ?>> list = this.f17219a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> o<Model, Data> e(@NonNull b<?, ?> bVar) {
        return (o) e0.k.d(bVar.f17225c.c(this));
    }

    @NonNull
    private static <Model, Data> o<Model, Data> f() {
        return (o<Model, Data>) f17218f;
    }

    @NonNull
    private <Model, Data> p<Model, Data> h(@NonNull b<?, ?> bVar) {
        return (p<Model, Data>) bVar.f17225c;
    }
}
