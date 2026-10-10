package m4;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collection<h3.a> f15641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<h3.e, ?> f15642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15644d;

    public j() {
    }

    public j(Collection<h3.a> collection, Map<h3.e, ?> map, String str, int i10) {
        this.f15641a = collection;
        this.f15642b = map;
        this.f15643c = str;
        this.f15644d = i10;
    }

    @Override // m4.g
    public f a(Map<h3.e, ?> map) {
        EnumMap enumMap = new EnumMap(h3.e.class);
        enumMap.putAll(map);
        Map<h3.e, ?> map2 = this.f15642b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection<h3.a> collection = this.f15641a;
        if (collection != null) {
            enumMap.put(h3.e.POSSIBLE_FORMATS, collection);
        }
        String str = this.f15643c;
        if (str != null) {
            enumMap.put(h3.e.CHARACTER_SET, str);
        }
        h3.k kVar = new h3.k();
        kVar.e(enumMap);
        int i10 = this.f15644d;
        if (i10 == 0) {
            return new f(kVar);
        }
        if (i10 != 1) {
            return i10 != 2 ? new f(kVar) : new l(kVar);
        }
        return new k(kVar);
    }
}
