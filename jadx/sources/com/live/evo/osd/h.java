package com.live.evo.osd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, g> f7098a = new HashMap();

    public void a(String str, g gVar) {
        f7098a.put(str, gVar);
    }

    public void b(g gVar) {
        gVar.d(8);
    }

    public void c(g gVar) {
        Iterator<String> it = f7098a.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g gVar2 = f7098a.get(it.next());
            if (gVar2 != gVar) {
                if (gVar.a() <= gVar2.a()) {
                    gVar2 = gVar;
                }
                gVar2.d(8);
            }
        }
        gVar.d(gVar.b() != 0 ? 0 : 8);
    }
}
