package b3;

import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f748a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<E> extends x<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x<E> f749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.internal.i<? extends Collection<E>> f750b;

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.q();
                return;
            }
            cVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f749a.d(cVar, it.next());
            }
            cVar.i();
        }

        public a(com.google.gson.e eVar, Type type, x<E> xVar, com.google.gson.internal.i<? extends Collection<E>> iVar) {
            this.f749a = new n(eVar, xVar, type);
            this.f750b = iVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            Collection<E> collectionA = this.f750b.a();
            aVar.a();
            while (aVar.n()) {
                collectionA.add(this.f749a.b(aVar));
            }
            aVar.i();
            return collectionA;
        }
    }

    public b(com.google.gson.internal.c cVar) {
        this.f748a = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = com.google.gson.internal.b.h(typeD, clsC);
        return new a(eVar, typeH, eVar.p(f3.a.b(typeH)), this.f748a.b(aVar));
    }
}
