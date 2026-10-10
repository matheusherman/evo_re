package l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class z implements f, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<?> f15163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f15164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f15165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile c f15166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f15167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile p.o.a<?> f15168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile d f15169g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements com.bumptech.glide.load.data.d.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p.o.a f15170a;

        a(p.o.a aVar) {
            this.f15170a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            if (z.this.d(this.f15170a)) {
                z.this.g(this.f15170a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void e(@Nullable Object obj) {
            if (z.this.d(this.f15170a)) {
                z.this.e(this.f15170a, obj);
            }
        }
    }

    private boolean b(Object obj) throws Throwable {
        Throwable th;
        long jB = e0.g.b();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.e<T> eVarO = this.f15163a.o(obj);
            Object objA = eVarO.a();
            j.d<X> dVarQ = this.f15163a.q(objA);
            e eVar = new e(dVarQ, objA, this.f15163a.k());
            d dVar = new d(this.f15168f.f17201a, this.f15163a.p());
            n.a aVarD = this.f15163a.d();
            aVarD.a(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + dVarQ + ", duration: " + e0.g.a(jB));
            }
            if (aVarD.b(dVar) != null) {
                this.f15169g = dVar;
                this.f15166d = new c(Collections.singletonList(this.f15168f.f17201a), this.f15163a, this);
                this.f15168f.f17203c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f15169g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f15164b.j(this.f15168f.f17201a, eVarO.a(), this.f15168f.f17203c, this.f15168f.f17203c.getDataSource(), this.f15168f.f17201a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (z10) {
                    throw th;
                }
                this.f15168f.f17203c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean c() {
        return this.f15165c < this.f15163a.g().size();
    }

    private void h(p.o.a<?> aVar) {
        this.f15168f.f17203c.d(this.f15163a.l(), new a(aVar));
    }

    @Override // l.f
    public boolean a() {
        if (this.f15167e != null) {
            Object obj = this.f15167e;
            this.f15167e = null;
            try {
                if (!b(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.f15166d != null && this.f15166d.a()) {
            return true;
        }
        this.f15166d = null;
        this.f15168f = null;
        boolean z10 = false;
        while (!z10 && c()) {
            List<p.o.a<?>> listG = this.f15163a.g();
            int i10 = this.f15165c;
            this.f15165c = i10 + 1;
            this.f15168f = listG.get(i10);
            if (this.f15168f != null && (this.f15163a.e().c(this.f15168f.f17203c.getDataSource()) || this.f15163a.u(this.f15168f.f17203c.a()))) {
                h(this.f15168f);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // l.f
    public void cancel() {
        p.o.a<?> aVar = this.f15168f;
        if (aVar != null) {
            aVar.f17203c.cancel();
        }
    }

    boolean d(p.o.a<?> aVar) {
        p.o.a<?> aVar2 = this.f15168f;
        return aVar2 != null && aVar2 == aVar;
    }

    void e(p.o.a<?> aVar, Object obj) {
        j jVarE = this.f15163a.e();
        if (obj != null && jVarE.c(aVar.f17203c.getDataSource())) {
            this.f15167e = obj;
            this.f15164b.k();
        } else {
            f.a aVar2 = this.f15164b;
            j.f fVar = aVar.f17201a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f17203c;
            aVar2.j(fVar, obj, dVar, dVar.getDataSource(), this.f15169g);
        }
    }

    @Override // l.f.a
    public void f(j.f fVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, j.a aVar) {
        this.f15164b.f(fVar, exc, dVar, this.f15168f.f17203c.getDataSource());
    }

    void g(p.o.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.f15164b;
        d dVar = this.f15169g;
        com.bumptech.glide.load.data.d<?> dVar2 = aVar.f17203c;
        aVar2.f(dVar, exc, dVar2, dVar2.getDataSource());
    }

    @Override // l.f.a
    public void j(j.f fVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, j.a aVar, j.f fVar2) {
        this.f15164b.j(fVar, obj, dVar, this.f15168f.f17203c.getDataSource(), fVar);
    }

    @Override // l.f.a
    public void k() {
        throw new UnsupportedOperationException();
    }

    z(g<?> gVar, f.a aVar) {
        this.f15163a = gVar;
        this.f15164b = aVar;
    }
}
