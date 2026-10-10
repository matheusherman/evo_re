package com.live.evo.fragment.subjuect;

import android.text.TextUtils;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f6636g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f6637h = "0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f6638i = "1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f6639j = "2";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f6640k = "-1";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f6641l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f6642a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Long> f6643b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<j5.g> f6644c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6645d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f6646e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f6647f = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Comparator<j5.c> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(j5.c cVar, j5.c cVar2) {
            return new Date(cVar.g()).compareTo(new Date(cVar2.g()));
        }

        a(b bVar) {
        }
    }

    public static b c() {
        if (f6636g == null) {
            f6636g = new b();
        }
        return f6636g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r8.z k(j5.h hVar) {
        if (hVar != null) {
            i(hVar);
        }
        this.f6647f.set(false);
        return null;
    }

    public List<String> d(j5.a aVar) {
        ArrayList arrayList = new ArrayList();
        if (aVar.k() != null && aVar.k().size() > 0) {
            arrayList.clear();
            arrayList.addAll(aVar.k());
        }
        return arrayList;
    }

    public void e() {
        s0 s0Var = s0.f7342a;
        if (s0Var.N()) {
            x1.f1.lb.media.j.f20845a.z();
            if (this.f6647f.compareAndSet(false, true)) {
                s0Var.I(new c9.l() { // from class: com.live.evo.fragment.subjuect.a
                    @Override // c9.l
                    public final Object invoke(Object obj) {
                        return this.f6634a.k((j5.h) obj);
                    }
                });
            }
        }
    }

    public List<j5.g> f() {
        return this.f6644c;
    }

    public Map<String, List<j5.b>> g(j5.a aVar, String str) {
        if (aVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.clear();
        j5.b bVar = new j5.b();
        bVar.f(f6640k);
        bVar.e(x1.j(R$string.all));
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, bVar);
        if (aVar.l() != null && !aVar.l().isEmpty()) {
            for (j5.e eVar : aVar.l()) {
                if (eVar != null && eVar.a() != null) {
                    arrayList.addAll(eVar.a());
                }
            }
        }
        map.put(str, arrayList);
        return map;
    }

    public Map<String, Map<String, List<j5.c>>> h(List<j5.b> list) {
        HashMap map;
        long j10;
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (j5.b bVar : list) {
            if (bVar != null && !TextUtils.isEmpty(bVar.b()) && bVar.d() != null && !bVar.d().isEmpty() && !bVar.b().equals(f6640k)) {
                map3.put(bVar.b(), bVar.d());
                arrayList.addAll(bVar.d());
            }
        }
        Collections.sort(arrayList, new a(this));
        map3.put(f6640k, arrayList);
        long jB = q1.b();
        HashMap map4 = new HashMap();
        boolean zB = a5.b.a().b();
        for (String str : map3.keySet()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (j5.c cVar : (List) map3.get(str)) {
                String strM = q1.m(cVar.g(), x1.j(R$string.yyyymmdd));
                if (TextUtils.isEmpty(strM) || !linkedHashMap.containsKey(strM)) {
                    map = map3;
                    j10 = jB;
                    if (!TextUtils.isEmpty(strM) && !linkedHashMap.containsKey(strM)) {
                        if (cVar.h() < j10) {
                            s0.f7342a.M(cVar.c(), cVar.a(), Long.valueOf(cVar.g()));
                            ArrayList arrayList2 = new ArrayList();
                            if ((zB && map4.containsKey(cVar.a())) || !zB) {
                                arrayList2.add(cVar);
                            }
                            linkedHashMap.put(strM, arrayList2);
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            if ((zB && map4.containsKey(cVar.a())) || !zB) {
                                arrayList3.add(cVar);
                            }
                            linkedHashMap.put(strM, arrayList3);
                        }
                    }
                } else if (cVar.h() < jB) {
                    map = map3;
                    j10 = jB;
                    s0.f7342a.M(cVar.c(), cVar.a(), Long.valueOf(cVar.g()));
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll((Collection) linkedHashMap.get(strM));
                    if ((zB && map4.containsKey(cVar.a())) || !zB) {
                        arrayList4.add(cVar);
                    }
                    linkedHashMap.put(strM, arrayList4);
                } else {
                    map = map3;
                    j10 = jB;
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.addAll((Collection) linkedHashMap.get(strM));
                    if ((zB && map4.containsKey(cVar.a())) || !zB) {
                        arrayList5.add(cVar);
                    }
                    linkedHashMap.put(strM, arrayList5);
                }
                map3 = map;
                jB = j10;
            }
            HashMap map5 = map3;
            long j11 = jB;
            ArrayList arrayList6 = new ArrayList();
            for (String str2 : linkedHashMap.keySet()) {
                if (!TextUtils.isEmpty(str2) && linkedHashMap.get(str2) != null) {
                    arrayList6.addAll((Collection) linkedHashMap.get(str2));
                }
            }
            if (f6640k != str && arrayList6.size() == 0) {
                map2.remove(str);
                for (j5.b bVar2 : list) {
                    if (bVar2 != null && bVar2.b().equals(str)) {
                        list.remove(bVar2);
                        break;
                    }
                }
            } else {
                map2.put(str, linkedHashMap);
            }
            map3 = map5;
            jB = j11;
        }
        return map2;
    }

    public List<j5.g> i(j5.h hVar) {
        if (hVar == null || hVar.k() == null || hVar.k().size() == 0) {
            return null;
        }
        this.f6644c.clear();
        this.f6644c.addAll(hVar.k());
        return this.f6644c;
    }

    public boolean j() {
        return s0.f7342a.N();
    }

    private b() {
    }

    public long b(String str) {
        Map<String, Long> map;
        Long l10;
        if (TextUtils.isEmpty(str) || (map = this.f6642a) == null || (l10 = map.get(str)) == null) {
            return 0L;
        }
        return l10.longValue();
    }
}
