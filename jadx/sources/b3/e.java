package b3;

import com.google.gson.r;
import com.google.gson.x;
import com.google.gson.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f757a;

    public e(com.google.gson.internal.c cVar) {
        this.f757a = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
        a3.b bVar = (a3.b) aVar.c().getAnnotation(a3.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) b(this.f757a, eVar, aVar, bVar);
    }

    x<?> b(com.google.gson.internal.c cVar, com.google.gson.e eVar, f3.a<?> aVar, a3.b bVar) {
        r rVar;
        x<?> xVarA;
        Object objA = cVar.b(f3.a.a(bVar.value())).a();
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof x) {
            xVarA = (x) objA;
        } else if (objA instanceof y) {
            xVarA = ((y) objA).a(eVar, aVar);
        } else {
            boolean z10 = objA instanceof r;
            if (!z10 && !(objA instanceof com.google.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            com.google.gson.j jVar = null;
            if (z10) {
                rVar = (r) objA;
            } else {
                rVar = null;
            }
            if (objA instanceof com.google.gson.j) {
                jVar = (com.google.gson.j) objA;
            }
            m mVar = new m(rVar, jVar, eVar, aVar, null, zNullSafe);
            zNullSafe = false;
            xVarA = mVar;
        }
        if (xVarA != null && zNullSafe) {
            return xVarA.a();
        }
        return xVarA;
    }
}
