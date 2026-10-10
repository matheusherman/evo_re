package y9;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import w9.q;
import w9.t;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<q> f22526a;

    public g(t typeTable) {
        m.f(typeTable, "typeTable");
        List<q> listZ = typeTable.z();
        if (typeTable.A()) {
            int iW = typeTable.w();
            List<q> listZ2 = typeTable.z();
            m.e(listZ2, "typeTable.typeList");
            List<q> list = listZ2;
            ArrayList arrayList = new ArrayList(r.w(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.v();
                }
                q qVarU = (q) obj;
                if (i10 >= iW) {
                    qVarU = qVarU.c().O(true).build();
                }
                arrayList.add(qVarU);
                i10 = i11;
            }
            listZ = arrayList;
        }
        m.e(listZ, "run {\n        val origin… else originalTypes\n    }");
        this.f22526a = listZ;
    }

    public final q a(int i10) {
        return this.f22526a.get(i10);
    }
}
