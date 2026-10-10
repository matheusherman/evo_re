package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
abstract class n<ResponseT, ReturnT> extends h0<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f18052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.e.a f18053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i<okhttp3.e0, ResponseT> f18054c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<ResponseT, ReturnT> extends n<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, ReturnT> f18055d;

        @Override // retrofit2.n
        protected ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return this.f18055d.b(bVar);
        }

        a(e0 e0Var, okhttp3.e.a aVar, i<okhttp3.e0, ResponseT> iVar, retrofit2.c<ResponseT, ReturnT> cVar) {
            super(e0Var, aVar, iVar);
            this.f18055d = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<ResponseT> extends n<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f18056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f18057e;

        @Override // retrofit2.n
        protected Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f18056d.b(bVar);
            v8.f fVar = (v8.f) objArr[objArr.length - 1];
            try {
                return this.f18057e ? p.b(bVarB, fVar) : p.a(bVarB, fVar);
            } catch (Exception e10) {
                return p.d(e10, fVar);
            }
        }

        b(e0 e0Var, okhttp3.e.a aVar, i<okhttp3.e0, ResponseT> iVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar, boolean z10) {
            super(e0Var, aVar, iVar);
            this.f18056d = cVar;
            this.f18057e = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c<ResponseT> extends n<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f18058d;

        @Override // retrofit2.n
        protected Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f18058d.b(bVar);
            v8.f fVar = (v8.f) objArr[objArr.length - 1];
            try {
                return p.c(bVarB, fVar);
            } catch (Exception e10) {
                return p.d(e10, fVar);
            }
        }

        c(e0 e0Var, okhttp3.e.a aVar, i<okhttp3.e0, ResponseT> iVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar) {
            super(e0Var, aVar, iVar);
            this.f18058d = cVar;
        }
    }

    protected abstract ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr);

    static <ResponseT, ReturnT> n<ResponseT, ReturnT> f(g0 g0Var, Method method, e0 e0Var) {
        Type genericReturnType;
        boolean z10;
        boolean z11 = e0Var.f17974k;
        Annotation[] annotations = method.getAnnotations();
        if (z11) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = k0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (k0.h(typeF) == f0.class && (typeF instanceof ParameterizedType)) {
                typeF = k0.g(0, (ParameterizedType) typeF);
                z10 = true;
            } else {
                z10 = false;
            }
            genericReturnType = new k0.b(null, retrofit2.b.class, typeF);
            annotations = j0.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
        }
        retrofit2.c cVarD = d(g0Var, method, genericReturnType, annotations);
        Type typeA = cVarD.a();
        if (typeA == okhttp3.d0.class) {
            throw k0.m(method, "'" + k0.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == f0.class) {
            throw k0.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (e0Var.f17966c.equals("HEAD") && !Void.class.equals(typeA)) {
            throw k0.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        i iVarE = e(g0Var, method, typeA);
        okhttp3.e.a aVar = g0Var.f18004b;
        if (z11) {
            return z10 ? new c(e0Var, aVar, iVarE, cVarD) : new b(e0Var, aVar, iVarE, cVarD, false);
        }
        return new a(e0Var, aVar, iVarE, cVarD);
    }

    @Override // retrofit2.h0
    final ReturnT a(Object[] objArr) {
        return c(new q(this.f18052a, objArr, this.f18053b, this.f18054c), objArr);
    }

    n(e0 e0Var, okhttp3.e.a aVar, i<okhttp3.e0, ResponseT> iVar) {
        this.f18052a = e0Var;
        this.f18053b = aVar;
        this.f18054c = iVar;
    }

    private static <ResponseT, ReturnT> retrofit2.c<ResponseT, ReturnT> d(g0 g0Var, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (retrofit2.c<ResponseT, ReturnT>) g0Var.a(type, annotationArr);
        } catch (RuntimeException e10) {
            throw k0.n(method, e10, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> i<okhttp3.e0, ResponseT> e(g0 g0Var, Method method, Type type) {
        try {
            return g0Var.h(type, method.getAnnotations());
        } catch (RuntimeException e10) {
            throw k0.n(method, e10, "Unable to create converter for %s", type);
        }
    }
}
