package b3;

import com.google.gson.p;
import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f771b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a<K, V> extends x<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x<K> f772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x<V> f773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.gson.internal.i<? extends Map<K, V>> f774c;

        public a(com.google.gson.e eVar, Type type, x<K> xVar, Type type2, x<V> xVar2, com.google.gson.internal.i<? extends Map<K, V>> iVar) {
            this.f772a = new n(eVar, xVar, type);
            this.f773b = new n(eVar, xVar2, type2);
            this.f774c = iVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(g3.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.q();
                return;
            }
            if (!h.this.f771b) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.o(String.valueOf(entry.getKey()));
                    this.f773b.d(cVar, entry.getValue());
                }
                cVar.j();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.k kVarC = this.f772a.c(entry2.getKey());
                arrayList.add(kVarC);
                arrayList2.add(entry2.getValue());
                z10 |= kVarC.h() || kVarC.k();
            }
            if (!z10) {
                cVar.d();
                int size = arrayList.size();
                while (i10 < size) {
                    cVar.o(e((com.google.gson.k) arrayList.get(i10)));
                    this.f773b.d(cVar, (V) arrayList2.get(i10));
                    i10++;
                }
                cVar.j();
                return;
            }
            cVar.c();
            int size2 = arrayList.size();
            while (i10 < size2) {
                cVar.c();
                com.google.gson.internal.m.b((com.google.gson.k) arrayList.get(i10), cVar);
                this.f773b.d(cVar, (V) arrayList2.get(i10));
                cVar.i();
                i10++;
            }
            cVar.i();
        }

        private String e(com.google.gson.k kVar) {
            if (kVar.m()) {
                p pVarG = kVar.g();
                if (pVarG.w()) {
                    return String.valueOf(pVarG.s());
                }
                if (pVarG.u()) {
                    return Boolean.toString(pVarG.n());
                }
                if (pVarG.x()) {
                    return pVarG.t();
                }
                throw new AssertionError();
            }
            if (kVar.i()) {
                return Configurator.NULL;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(g3.a aVar) throws IOException {
            g3.b bVarB = aVar.B();
            if (bVarB == g3.b.NULL) {
                aVar.x();
                return null;
            }
            Map<K, V> mapA = this.f774c.a();
            if (bVarB == g3.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.n()) {
                    aVar.a();
                    K kB = this.f772a.b(aVar);
                    if (mapA.put(kB, this.f773b.b(aVar)) == null) {
                        aVar.i();
                    } else {
                        throw new s("duplicate key: " + kB);
                    }
                }
                aVar.i();
                return mapA;
            }
            aVar.b();
            while (aVar.n()) {
                com.google.gson.internal.f.f4891a.a(aVar);
                K kB2 = this.f772a.b(aVar);
                if (mapA.put(kB2, this.f773b.b(aVar)) != null) {
                    throw new s("duplicate key: " + kB2);
                }
            }
            aVar.j();
            return mapA;
        }
    }

    private x<?> b(com.google.gson.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.f832f : eVar.p(f3.a.b(type));
    }

    public h(com.google.gson.internal.c cVar, boolean z10) {
        this.f770a = cVar;
        this.f771b = z10;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
        Type typeD = aVar.d();
        Class<? super T> clsC = aVar.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = com.google.gson.internal.b.j(typeD, clsC);
        return new a(eVar, typeArrJ[0], b(eVar, typeArrJ[0]), typeArrJ[1], eVar.p(f3.a.b(typeArrJ[1])), this.f770a.b(aVar));
    }
}
