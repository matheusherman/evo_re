package l;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class c implements f, com.bumptech.glide.load.data.d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<j.f> f14963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f14964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.a f14965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j.f f14967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<p.o<File, ?>> f14968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile p.o.a<?> f14970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f14971i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    c(List<j.f> list, g<?> gVar, f.a aVar) {
        this.f14966d = -1;
        this.f14963a = list;
        this.f14964b = gVar;
        this.f14965c = aVar;
    }

    private boolean b() {
        return this.f14969g < this.f14968f.size();
    }

    @Override // l.f
    public boolean a() {
        f0.b.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z10 = false;
                if (this.f14968f != null && b()) {
                    this.f14970h = null;
                    while (!z10 && b()) {
                        List<p.o<File, ?>> list = this.f14968f;
                        int i10 = this.f14969g;
                        this.f14969g = i10 + 1;
                        this.f14970h = list.get(i10).b(this.f14971i, this.f14964b.t(), this.f14964b.f(), this.f14964b.k());
                        if (this.f14970h != null && this.f14964b.u(this.f14970h.f17203c.a())) {
                            this.f14970h.f17203c.d(this.f14964b.l(), this);
                            z10 = true;
                        }
                    }
                    f0.b.e();
                    return z10;
                }
                int i11 = this.f14966d + 1;
                this.f14966d = i11;
                if (i11 >= this.f14963a.size()) {
                    f0.b.e();
                    return false;
                }
                j.f fVar = this.f14963a.get(this.f14966d);
                File fileB = this.f14964b.d().b(new d(fVar, this.f14964b.p()));
                this.f14971i = fileB;
                if (fileB != null) {
                    this.f14967e = fVar;
                    this.f14968f = this.f14964b.j(fileB);
                    this.f14969g = 0;
                }
            } catch (Throwable th) {
                f0.b.e();
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f14965c.f(this.f14967e, exc, this.f14970h.f17203c, j.a.DATA_DISK_CACHE);
    }

    @Override // l.f
    public void cancel() {
        p.o.a<?> aVar = this.f14970h;
        if (aVar != null) {
            aVar.f17203c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(Object obj) {
        this.f14965c.j(this.f14967e, obj, this.f14970h.f17203c, j.a.DATA_DISK_CACHE, this.f14967e);
    }
}
