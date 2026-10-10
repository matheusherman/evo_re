package d0;

import androidx.annotation.NonNull;
import e0.k;
import j.f;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9553b;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f9553b.toString().getBytes(f.f11519a));
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f9553b.equals(((d) obj).f9553b);
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return this.f9553b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f9553b + '}';
    }

    public d(@NonNull Object obj) {
        this.f9553b = k.d(obj);
    }
}
