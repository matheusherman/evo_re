package ff;

import com.google.gson.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.c0;
import okhttp3.e0;
import retrofit2.g0;
import retrofit2.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10351a;

    public static a f() {
        return g(new e());
    }

    public static a g(e eVar) {
        if (eVar != null) {
            return new a(eVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.i.a
    public i<?, c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, g0 g0Var) {
        return new b(this.f10351a, this.f10351a.p(f3.a.b(type)));
    }

    @Override // retrofit2.i.a
    public i<e0, ?> d(Type type, Annotation[] annotationArr, g0 g0Var) {
        return new c(this.f10351a, this.f10351a.p(f3.a.b(type)));
    }

    private a(e eVar) {
        this.f10351a = eVar;
    }
}
