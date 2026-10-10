package xd;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, fc.u> f22078a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<fc.u, String> f22079b = new HashMap();

    static {
        Map<String, fc.u> map = f22078a;
        fc.u uVar = nc.a.f16308c;
        map.put("SHA-256", uVar);
        Map<String, fc.u> map2 = f22078a;
        fc.u uVar2 = nc.a.f16312e;
        map2.put("SHA-512", uVar2);
        Map<String, fc.u> map3 = f22078a;
        fc.u uVar3 = nc.a.f16328m;
        map3.put("SHAKE128", uVar3);
        Map<String, fc.u> map4 = f22078a;
        fc.u uVar4 = nc.a.f16330n;
        map4.put("SHAKE256", uVar4);
        f22079b.put(uVar, "SHA-256");
        f22079b.put(uVar2, "SHA-512");
        f22079b.put(uVar3, "SHAKE128");
        f22079b.put(uVar4, "SHAKE256");
    }

    static tc.i a(fc.u uVar) {
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

    static String b(fc.u uVar) {
        String str = f22079b.get(uVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unrecognized digest oid: " + uVar);
    }

    static fc.u c(String str) {
        fc.u uVar = f22078a.get(str);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("unrecognized digest name: " + str);
    }
}
