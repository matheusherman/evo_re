package j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<h<?>, Object> f11526b = new e0.b();

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f11526b.getSize(); i10++) {
            g(this.f11526b.keyAt(i10), this.f11526b.valueAt(i10), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull h<T> hVar) {
        return this.f11526b.containsKey(hVar) ? (T) this.f11526b.get(hVar) : hVar.c();
    }

    public void d(@NonNull i iVar) {
        this.f11526b.putAll((SimpleArrayMap<? extends h<?>, ? extends Object>) iVar.f11526b);
    }

    public i e(@NonNull h<?> hVar) {
        this.f11526b.remove(hVar);
        return this;
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f11526b.equals(((i) obj).f11526b);
        }
        return false;
    }

    @NonNull
    public <T> i f(@NonNull h<T> hVar, @NonNull T t10) {
        this.f11526b.put(hVar, t10);
        return this;
    }

    @Override // j.f
    public int hashCode() {
        return this.f11526b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f11526b + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void g(@NonNull h<T> hVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        hVar.g(obj, messageDigest);
    }
}
