package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class a extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17938a = true;

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0347a implements i<okhttp3.e0, okhttp3.e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0347a f17939a = new C0347a();

        C0347a() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public okhttp3.e0 a(okhttp3.e0 e0Var) {
            try {
                return k0.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b implements i<okhttp3.c0, okhttp3.c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f17940a = new b();

        b() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public okhttp3.c0 a(okhttp3.c0 c0Var) {
            return c0Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c implements i<okhttp3.e0, okhttp3.e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f17941a = new c();

        c() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public okhttp3.e0 a(okhttp3.e0 e0Var) {
            return e0Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d implements i<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f17942a = new d();

        d() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e implements i<okhttp3.e0, r8.z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f17943a = new e();

        e() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r8.z a(okhttp3.e0 e0Var) {
            e0Var.close();
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f implements i<okhttp3.e0, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f17944a = new f();

        f() {
        }

        @Override // retrofit2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(okhttp3.e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    @Override // retrofit2.i.a
    public i<?, okhttp3.c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, g0 g0Var) {
        if (okhttp3.c0.class.isAssignableFrom(k0.h(type))) {
            return b.f17940a;
        }
        return null;
    }

    @Override // retrofit2.i.a
    public i<okhttp3.e0, ?> d(Type type, Annotation[] annotationArr, g0 g0Var) {
        if (type == okhttp3.e0.class) {
            return k0.l(annotationArr, gf.w.class) ? c.f17941a : C0347a.f17939a;
        }
        if (type == Void.class) {
            return f.f17944a;
        }
        if (!this.f17938a || type != r8.z.class) {
            return null;
        }
        try {
            return e.f17943a;
        } catch (NoClassDefFoundError unused) {
            this.f17938a = false;
            return null;
        }
    }

    a() {
    }
}
