package j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b<Object> f11521e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f11522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<T> f11523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte[] f11525d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t10, @NonNull MessageDigest messageDigest);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements b<Object> {
        a() {
        }

        @Override // j.h.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    @NonNull
    public static <T> h<T> a(@NonNull String str, @Nullable T t10, @NonNull b<T> bVar) {
        return new h<>(str, t10, bVar);
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f11521e;
    }

    @NonNull
    private byte[] d() {
        if (this.f11525d == null) {
            this.f11525d = this.f11524c.getBytes(f.f11519a);
        }
        return this.f11525d;
    }

    @NonNull
    public static <T> h<T> e(@NonNull String str) {
        return new h<>(str, null, b());
    }

    @NonNull
    public static <T> h<T> f(@NonNull String str, @NonNull T t10) {
        return new h<>(str, t10, b());
    }

    @Nullable
    public T c() {
        return this.f11522a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f11524c.equals(((h) obj).f11524c);
        }
        return false;
    }

    public void g(@NonNull T t10, @NonNull MessageDigest messageDigest) {
        this.f11523b.a(d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f11524c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f11524c + "'}";
    }

    private h(@NonNull String str, @Nullable T t10, @NonNull b<T> bVar) {
        this.f11524c = e0.k.b(str);
        this.f11522a = t10;
        this.f11523b = (b) e0.k.d(bVar);
    }
}
