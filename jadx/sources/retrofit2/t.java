package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@IgnoreJRERequirement
final class t extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final i.a f18082a = new t();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @IgnoreJRERequirement
    static final class a<T> implements i<okhttp3.e0, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<okhttp3.e0, T> f18083a;

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Optional<T> a(okhttp3.e0 e0Var) {
            return Optional.ofNullable(this.f18083a.a(e0Var));
        }

        a(i<okhttp3.e0, T> iVar) {
            this.f18083a = iVar;
        }
    }

    t() {
    }

    @Override // retrofit2.i.a
    public i<okhttp3.e0, ?> d(Type type, Annotation[] annotationArr, g0 g0Var) {
        if (i.a.b(type) != r.a()) {
            return null;
        }
        return new a(g0Var.h(i.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
