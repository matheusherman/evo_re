package cd;

import fc.o1;
import fc.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<u, String> f1165a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, rc.a> f1166b = new HashMap();

    static {
        f1165a.put(pc.a.I, "MD2");
        f1165a.put(pc.a.J, "MD4");
        f1165a.put(pc.a.K, "MD5");
        Map<u, String> map = f1165a;
        u uVar = oc.a.f16558i;
        map.put(uVar, "SHA-1");
        Map<u, String> map2 = f1165a;
        u uVar2 = nc.a.f16314f;
        map2.put(uVar2, "SHA-224");
        Map<u, String> map3 = f1165a;
        u uVar3 = nc.a.f16308c;
        map3.put(uVar3, "SHA-256");
        Map<u, String> map4 = f1165a;
        u uVar4 = nc.a.f16310d;
        map4.put(uVar4, "SHA-384");
        Map<u, String> map5 = f1165a;
        u uVar5 = nc.a.f16312e;
        map5.put(uVar5, "SHA-512");
        f1165a.put(nc.a.f16316g, "SHA-512(224)");
        f1165a.put(nc.a.f16318h, "SHA-512(256)");
        f1165a.put(qc.a.f17689c, "RIPEMD-128");
        f1165a.put(qc.a.f17688b, "RIPEMD-160");
        f1165a.put(qc.a.f17690d, "RIPEMD-128");
        f1165a.put(lc.a.f15363d, "RIPEMD-128");
        f1165a.put(lc.a.f15362c, "RIPEMD-160");
        f1165a.put(hc.a.f10923b, "GOST3411");
        f1165a.put(jc.a.f11675g, "Tiger");
        f1165a.put(lc.a.f15364e, "Whirlpool");
        Map<u, String> map6 = f1165a;
        u uVar6 = nc.a.f16320i;
        map6.put(uVar6, "SHA3-224");
        Map<u, String> map7 = f1165a;
        u uVar7 = nc.a.f16322j;
        map7.put(uVar7, "SHA3-256");
        Map<u, String> map8 = f1165a;
        u uVar8 = nc.a.f16324k;
        map8.put(uVar8, "SHA3-384");
        Map<u, String> map9 = f1165a;
        u uVar9 = nc.a.f16326l;
        map9.put(uVar9, "SHA3-512");
        f1165a.put(nc.a.f16328m, "SHAKE128");
        f1165a.put(nc.a.f16330n, "SHAKE256");
        f1165a.put(ic.a.f11295b0, "SM3");
        Map<u, String> map10 = f1165a;
        u uVar10 = mc.a.N;
        map10.put(uVar10, "BLAKE3-256");
        f1166b.put("SHA-1", new rc.a(uVar, o1.f10200b));
        f1166b.put("SHA-224", new rc.a(uVar2));
        f1166b.put("SHA224", new rc.a(uVar2));
        f1166b.put("SHA-256", new rc.a(uVar3));
        f1166b.put("SHA256", new rc.a(uVar3));
        f1166b.put("SHA-384", new rc.a(uVar4));
        f1166b.put("SHA384", new rc.a(uVar4));
        f1166b.put("SHA-512", new rc.a(uVar5));
        f1166b.put("SHA512", new rc.a(uVar5));
        f1166b.put("SHA3-224", new rc.a(uVar6));
        f1166b.put("SHA3-256", new rc.a(uVar7));
        f1166b.put("SHA3-384", new rc.a(uVar8));
        f1166b.put("SHA3-512", new rc.a(uVar9));
        f1166b.put("BLAKE3-256", new rc.a(uVar10));
    }

    public static rc.a a(String str) {
        if (f1166b.containsKey(str)) {
            return f1166b.get(str);
        }
        throw new IllegalArgumentException("unknown digest: " + str);
    }
}
