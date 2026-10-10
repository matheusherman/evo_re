package p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f17204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f17205b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0332a<?>> f17206a = new HashMap();

        /* JADX INFO: renamed from: p.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private static class C0332a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List<o<Model, ?>> f17207a;

            public C0332a(List<o<Model, ?>> list) {
                this.f17207a = list;
            }
        }

        public void a() {
            this.f17206a.clear();
        }

        @Nullable
        public <Model> List<o<Model, ?>> b(Class<Model> cls) {
            C0332a<?> c0332a = this.f17206a.get(cls);
            if (c0332a == null) {
                return null;
            }
            return (List<o<Model, ?>>) c0332a.f17207a;
        }

        public <Model> void c(Class<Model> cls, List<o<Model, ?>> list) {
            if (this.f17206a.put(cls, new C0332a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        a() {
        }
    }

    public q(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new s(pool));
    }

    @NonNull
    private synchronized <A> List<o<A, ?>> e(@NonNull Class<A> cls) {
        List<o<A, ?>> listB;
        listB = this.f17205b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f17204a.c(cls));
            this.f17205b.c(cls, listB);
        }
        return listB;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        this.f17204a.b(cls, cls2, pVar);
        this.f17205b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.f17204a.g(cls);
    }

    public synchronized <Model, Data> void f(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        g(this.f17204a.j(cls, cls2, pVar));
        this.f17205b.a();
    }

    private q(@NonNull s sVar) {
        this.f17205b = new a();
        this.f17204a = sVar;
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a10) {
        return (Class<A>) a10.getClass();
    }

    private <Model, Data> void g(@NonNull List<p<? extends Model, ? extends Data>> list) {
        Iterator<p<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @NonNull
    public <A> List<o<A, ?>> d(@NonNull A a10) {
        List<o<A, ?>> listE = e(b(a10));
        if (!listE.isEmpty()) {
            int size = listE.size();
            List<o<A, ?>> arrayList = Collections.EMPTY_LIST;
            boolean z10 = true;
            for (int i10 = 0; i10 < size; i10++) {
                o<A, ?> oVar = listE.get(i10);
                if (oVar.a(a10)) {
                    if (z10) {
                        arrayList = new ArrayList<>(size - i10);
                        z10 = false;
                    }
                    arrayList.add(oVar);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new com.bumptech.glide.i.c(a10, listE);
        }
        throw new com.bumptech.glide.i.c(a10);
    }
}
