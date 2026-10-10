package retrofit2;

import java.util.Objects;
import org.apache.log4j.varia.ExternallyRolledFileAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.d0 f18000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f18001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.e0 f18002c;

    public static <T> f0<T> c(okhttp3.e0 e0Var, okhttp3.d0 d0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.n()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new f0<>(d0Var, null, e0Var);
    }

    public static <T> f0<T> i(T t10) {
        return j(t10, new okhttp3.d0.a().g(200).m(ExternallyRolledFileAppender.OK).p(okhttp3.a0.HTTP_1_1).r(new okhttp3.b0.a().k("http://localhost/").b()).c());
    }

    public static <T> f0<T> j(T t10, okhttp3.d0 d0Var) {
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.n()) {
            return new f0<>(d0Var, t10, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f18001b;
    }

    public int b() {
        return this.f18000a.getCode();
    }

    public okhttp3.e0 d() {
        return this.f18002c;
    }

    public okhttp3.u e() {
        return this.f18000a.getHeaders();
    }

    public boolean f() {
        return this.f18000a.n();
    }

    public String g() {
        return this.f18000a.getMessage();
    }

    public okhttp3.d0 h() {
        return this.f18000a;
    }

    public String toString() {
        return this.f18000a.toString();
    }

    private f0(okhttp3.d0 d0Var, T t10, okhttp3.e0 e0Var) {
        this.f18000a = d0Var;
        this.f18001b = t10;
        this.f18002c = e0Var;
    }
}
