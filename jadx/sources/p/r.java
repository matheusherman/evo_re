package p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class r<Model, Data> implements o<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o<Model, Data>> f17208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17209b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, com.bumptech.glide.load.data.d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f17210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f17211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f17212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bumptech.glide.h f17213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bumptech.glide.load.data.d.a<? super Data> f17214e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private List<Throwable> f17215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f17216g;

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f17216g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f17210a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        private void f() {
            if (this.f17216g) {
                return;
            }
            if (this.f17212c < this.f17210a.size() - 1) {
                this.f17212c++;
                d(this.f17213d, this.f17214e);
            } else {
                e0.k.d(this.f17215f);
                this.f17214e.c(new l.q("Fetch failed", new ArrayList(this.f17215f)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17210a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f17215f;
            if (list != null) {
                this.f17211b.release(list);
            }
            this.f17215f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f17210a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            ((List) e0.k.d(this.f17215f)).add(exc);
            f();
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super Data> aVar) {
            this.f17213d = hVar;
            this.f17214e = aVar;
            this.f17215f = this.f17211b.acquire();
            this.f17210a.get(this.f17212c).d(hVar, this);
            if (this.f17216g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void e(@Nullable Data data) {
            if (data != null) {
                this.f17214e.e(data);
            } else {
                f();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return this.f17210a.get(0).getDataSource();
        }

        a(@NonNull List<com.bumptech.glide.load.data.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f17211b = pool;
            e0.k.c(list);
            this.f17210a = list;
            this.f17212c = 0;
        }
    }

    @Override // p.o
    public boolean a(@NonNull Model model) {
        Iterator<o<Model, Data>> it = this.f17208a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // p.o
    public o.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull j.i iVar) {
        o.a<Data> aVarB;
        int size = this.f17208a.size();
        ArrayList arrayList = new ArrayList(size);
        j.f fVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            o<Model, Data> oVar = this.f17208a.get(i12);
            if (oVar.a(model) && (aVarB = oVar.b(model, i10, i11, iVar)) != null) {
                fVar = aVarB.f17201a;
                arrayList.add(aVarB.f17203c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new o.a<>(fVar, new a(arrayList, this.f17209b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f17208a.toArray()) + '}';
    }

    r(@NonNull List<o<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f17208a = list;
        this.f17209b = pool;
    }
}
