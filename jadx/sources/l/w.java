package l;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class w implements f, com.bumptech.glide.load.data.d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a f15142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f15143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15145d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j.f f15146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<p.o<File, ?>> f15147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile p.o.a<?> f15149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f15150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x f15151j;

    private boolean b() {
        return this.f15148g < this.f15147f.size();
    }

    @Override // l.f
    public boolean a() {
        f0.b.a("ResourceCacheGenerator.startNext");
        try {
            List<j.f> listC = this.f15143b.c();
            boolean z10 = false;
            if (listC.isEmpty()) {
                f0.b.e();
                return false;
            }
            List<Class<?>> listM = this.f15143b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.f15143b.r())) {
                    f0.b.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f15143b.i() + " to " + this.f15143b.r());
            }
            while (true) {
                if (this.f15147f != null && b()) {
                    this.f15149h = null;
                    while (!z10 && b()) {
                        List<p.o<File, ?>> list = this.f15147f;
                        int i10 = this.f15148g;
                        this.f15148g = i10 + 1;
                        this.f15149h = list.get(i10).b(this.f15150i, this.f15143b.t(), this.f15143b.f(), this.f15143b.k());
                        if (this.f15149h != null && this.f15143b.u(this.f15149h.f17203c.a())) {
                            this.f15149h.f17203c.d(this.f15143b.l(), this);
                            z10 = true;
                        }
                    }
                    f0.b.e();
                    return z10;
                }
                int i11 = this.f15145d + 1;
                this.f15145d = i11;
                if (i11 >= listM.size()) {
                    int i12 = this.f15144c + 1;
                    this.f15144c = i12;
                    if (i12 >= listC.size()) {
                        f0.b.e();
                        return false;
                    }
                    this.f15145d = 0;
                }
                j.f fVar = listC.get(this.f15144c);
                Class<?> cls = listM.get(this.f15145d);
                this.f15151j = new x(this.f15143b.b(), fVar, this.f15143b.p(), this.f15143b.t(), this.f15143b.f(), this.f15143b.s(cls), cls, this.f15143b.k());
                File fileB = this.f15143b.d().b(this.f15151j);
                this.f15150i = fileB;
                if (fileB != null) {
                    this.f15146e = fVar;
                    this.f15147f = this.f15143b.j(fileB);
                    this.f15148g = 0;
                }
            }
        } catch (Throwable th) {
            f0.b.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f15142a.f(this.f15151j, exc, this.f15149h.f17203c, j.a.RESOURCE_DISK_CACHE);
    }

    @Override // l.f
    public void cancel() {
        p.o.a<?> aVar = this.f15149h;
        if (aVar != null) {
            aVar.f17203c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(Object obj) {
        this.f15142a.j(this.f15146e, obj, this.f15149h.f17203c, j.a.RESOURCE_DISK_CACHE, this.f15151j);
    }

    w(g<?> gVar, f.a aVar) {
        this.f15143b = gVar;
        this.f15142a = aVar;
    }
}
