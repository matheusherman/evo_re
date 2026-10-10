package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<Integer, String> f9695c = fb.f.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Short, h> f9696a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cb.c f9697b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private n f9698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private l f9699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f f9700c;

        public f a() {
            return this.f9700c;
        }

        public l b() {
            return this.f9699b;
        }

        public n c() {
            return this.f9698a;
        }

        public a(n nVar, l lVar, f fVar) {
            this.f9698a = nVar;
            this.f9699b = lVar;
            this.f9700c = fVar;
        }
    }

    public void a(h hVar) {
        this.f9696a.put(Short.valueOf(hVar.c()), hVar);
    }

    public h b(short s10) {
        return this.f9696a.get(Short.valueOf(s10));
    }

    public List<a> c(long j10) {
        cb.b bVarD;
        short s10 = (short) (255 & (j10 >> 16));
        int i10 = (int) (65535 & j10);
        h hVarB = b((short) ((j10 >> 24) & 255));
        if (hVarB == null) {
            return Collections.EMPTY_LIST;
        }
        n nVarE = hVarB.e(s10);
        List<l> listG = hVarB.g(s10);
        if (nVarE == null || listG == null) {
            return Collections.EMPTY_LIST;
        }
        if (!nVarE.a(i10)) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (l lVar : listG) {
            f fVarD = lVar.d(i10);
            if (fVarD != null && (bVarD = fVarD.d()) != null && (!(bVarD instanceof cb.b.j) || j10 != ((cb.b.j) bVarD).m())) {
                arrayList.add(new a(nVarE, lVar, fVarD));
            }
        }
        return arrayList;
    }

    public void d(cb.c cVar) {
        this.f9697b = cVar;
    }
}
