package l;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class n implements j.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f15112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f15115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f15116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j.f f15117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, j.m<?>> f15118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j.i f15119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15120j;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f15112b.equals(nVar.f15112b) && this.f15117g.equals(nVar.f15117g) && this.f15114d == nVar.f15114d && this.f15113c == nVar.f15113c && this.f15118h.equals(nVar.f15118h) && this.f15115e.equals(nVar.f15115e) && this.f15116f.equals(nVar.f15116f) && this.f15119i.equals(nVar.f15119i)) {
                return true;
            }
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        if (this.f15120j == 0) {
            int iHashCode = this.f15112b.hashCode();
            this.f15120j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f15117g.hashCode()) * 31) + this.f15113c) * 31) + this.f15114d;
            this.f15120j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f15118h.hashCode();
            this.f15120j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f15115e.hashCode();
            this.f15120j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f15116f.hashCode();
            this.f15120j = iHashCode5;
            this.f15120j = (iHashCode5 * 31) + this.f15119i.hashCode();
        }
        return this.f15120j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f15112b + ", width=" + this.f15113c + ", height=" + this.f15114d + ", resourceClass=" + this.f15115e + ", transcodeClass=" + this.f15116f + ", signature=" + this.f15117g + ", hashCode=" + this.f15120j + ", transformations=" + this.f15118h + ", options=" + this.f15119i + '}';
    }

    n(Object obj, j.f fVar, int i10, int i11, Map<Class<?>, j.m<?>> map, Class<?> cls, Class<?> cls2, j.i iVar) {
        this.f15112b = e0.k.d(obj);
        this.f15117g = (j.f) e0.k.e(fVar, "Signature must not be null");
        this.f15113c = i10;
        this.f15114d = i11;
        this.f15118h = (Map) e0.k.d(map);
        this.f15115e = (Class) e0.k.e(cls, "Resource class must not be null");
        this.f15116f = (Class) e0.k.e(cls2, "Transcode class must not be null");
        this.f15119i = (j.i) e0.k.d(iVar);
    }
}
