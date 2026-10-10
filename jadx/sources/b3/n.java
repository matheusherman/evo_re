package b3;

import com.google.gson.x;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class n<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f826c;

    private static Type e(Type type, Object obj) {
        if (obj != null) {
            return ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type;
        }
        return type;
    }

    private static boolean f(x<?> xVar) {
        x<?> xVarE;
        while ((xVar instanceof l) && (xVarE = ((l) xVar).e()) != xVar) {
            xVar = xVarE;
        }
        return xVar instanceof k.b;
    }

    @Override // com.google.gson.x
    public T b(g3.a aVar) {
        return this.f825b.b(aVar);
    }

    @Override // com.google.gson.x
    public void d(g3.c cVar, T t10) {
        x<T> xVarP = this.f825b;
        Type typeE = e(this.f826c, t10);
        if (typeE != this.f826c) {
            xVarP = this.f824a.p(f3.a.b(typeE));
            if ((xVarP instanceof k.b) && !f(this.f825b)) {
                xVarP = this.f825b;
            }
        }
        xVarP.d(cVar, t10);
    }

    n(com.google.gson.e eVar, x<T> xVar, Type type) {
        this.f824a = eVar;
        this.f825b = xVar;
        this.f826c = type;
    }
}
