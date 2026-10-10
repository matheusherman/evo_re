package b3;

import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a<E> extends x<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f745c = new C0029a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<E> f747b;

    /* JADX INFO: renamed from: b3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0029a implements y {
        C0029a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            Type typeD = aVar.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = com.google.gson.internal.b.g(typeD);
            return new a(eVar, eVar.p(f3.a.b(typeG)), com.google.gson.internal.b.k(typeG));
        }
    }

    @Override // com.google.gson.x
    public void d(g3.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.q();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f747b.d(cVar, (E) Array.get(obj, i10));
        }
        cVar.i();
    }

    public a(com.google.gson.e eVar, x<E> xVar, Class<E> cls) {
        this.f747b = new n(eVar, xVar, cls);
        this.f746a = cls;
    }

    @Override // com.google.gson.x
    public Object b(g3.a aVar) throws IOException {
        if (aVar.B() == g3.b.NULL) {
            aVar.x();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.n()) {
            arrayList.add(this.f747b.b(aVar));
        }
        aVar.i();
        int size = arrayList.size();
        if (this.f746a.isPrimitive()) {
            Object objNewInstance = Array.newInstance((Class<?>) this.f746a, size);
            for (int i10 = 0; i10 < size; i10++) {
                Array.set(objNewInstance, i10, arrayList.get(i10));
            }
            return objNewInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f746a, size));
    }
}
