package l;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x implements j.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e0.h<Class<?>, byte[]> f15152j = new e0.h<>(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.b f15153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.f f15154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j.f f15155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f15158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j.i f15159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j.m<?> f15160i;

    private byte[] c() {
        e0.h<Class<?>, byte[]> hVar = f15152j;
        byte[] bArrG = hVar.g(this.f15158g);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.f15158g.getName().getBytes(j.f.f11519a);
        hVar.k(this.f15158g, bytes);
        return bytes;
    }

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f15153b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f15156e).putInt(this.f15157f).array();
        this.f15155d.a(messageDigest);
        this.f15154c.a(messageDigest);
        messageDigest.update(bArr);
        j.m<?> mVar = this.f15160i;
        if (mVar != null) {
            mVar.a(messageDigest);
        }
        this.f15159h.a(messageDigest);
        messageDigest.update(c());
        this.f15153b.put(bArr);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f15157f == xVar.f15157f && this.f15156e == xVar.f15156e && e0.l.d(this.f15160i, xVar.f15160i) && this.f15158g.equals(xVar.f15158g) && this.f15154c.equals(xVar.f15154c) && this.f15155d.equals(xVar.f15155d) && this.f15159h.equals(xVar.f15159h)) {
                return true;
            }
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        int iHashCode = (((((this.f15154c.hashCode() * 31) + this.f15155d.hashCode()) * 31) + this.f15156e) * 31) + this.f15157f;
        j.m<?> mVar = this.f15160i;
        if (mVar != null) {
            iHashCode = (iHashCode * 31) + mVar.hashCode();
        }
        return (((iHashCode * 31) + this.f15158g.hashCode()) * 31) + this.f15159h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f15154c + ", signature=" + this.f15155d + ", width=" + this.f15156e + ", height=" + this.f15157f + ", decodedResourceClass=" + this.f15158g + ", transformation='" + this.f15160i + "', options=" + this.f15159h + '}';
    }

    x(m.b bVar, j.f fVar, j.f fVar2, int i10, int i11, j.m<?> mVar, Class<?> cls, j.i iVar) {
        this.f15153b = bVar;
        this.f15154c = fVar;
        this.f15155d = fVar2;
        this.f15156e = i10;
        this.f15157f = i11;
        this.f15160i = mVar;
        this.f15158g = cls;
        this.f15159h = iVar;
    }
}
