package nd;

import fc.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, u> f16347a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<u, String> f16348b = new HashMap();

    static {
        Map<String, u> map = f16347a;
        u uVar = nc.a.f16308c;
        map.put("SHA-256", uVar);
        Map<String, u> map2 = f16347a;
        u uVar2 = nc.a.f16312e;
        map2.put("SHA-512", uVar2);
        Map<String, u> map3 = f16347a;
        u uVar3 = nc.a.f16328m;
        map3.put("SHAKE128", uVar3);
        Map<String, u> map4 = f16347a;
        u uVar4 = nc.a.f16330n;
        map4.put("SHAKE256", uVar4);
        f16348b.put(uVar, "SHA-256");
        f16348b.put(uVar2, "SHA-512");
        f16348b.put(uVar3, "SHAKE128");
        f16348b.put(uVar4, "SHAKE256");
    }

    static tc.i a(u uVar) {
        if (uVar.t(nc.a.f16308c)) {
            return new vc.g();
        }
        if (uVar.t(nc.a.f16312e)) {
            return new vc.j();
        }
        if (uVar.t(nc.a.f16328m)) {
            return new vc.k(128);
        }
        if (uVar.t(nc.a.f16330n)) {
            return new vc.k(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + uVar);
    }
}
