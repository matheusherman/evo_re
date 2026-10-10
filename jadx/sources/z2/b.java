package z2;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import m2.e;
import m2.h;
import m2.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements j {
    @Override // m2.j
    public List<m2.c<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final m2.c<?> cVarR : componentRegistrar.getComponents()) {
            final String strI = cVarR.i();
            if (strI != null) {
                cVarR = cVarR.r(new h() { // from class: z2.a
                    @Override // m2.h
                    public final Object a(e eVar) {
                        return b.b(strI, cVarR, eVar);
                    }
                });
            }
            arrayList.add(cVarR);
        }
        return arrayList;
    }

    public static /* synthetic */ Object b(String str, m2.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }
}
