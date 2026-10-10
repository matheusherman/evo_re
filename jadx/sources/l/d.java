package l;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d implements j.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j.f f14972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.f f14973c;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.f14972b.a(messageDigest);
        this.f14973c.a(messageDigest);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f14972b.equals(dVar.f14972b) && this.f14973c.equals(dVar.f14973c)) {
                return true;
            }
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return (this.f14972b.hashCode() * 31) + this.f14973c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f14972b + ", signature=" + this.f14973c + '}';
    }

    d(j.f fVar, j.f fVar2) {
        this.f14972b = fVar;
        this.f14973c = fVar2;
    }
}
