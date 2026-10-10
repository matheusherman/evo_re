package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k extends LinkedHashMap<String, List<String>> implements Iterable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5096a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f5097b = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        String b(String str);
    }

    public k() {
    }

    public static k o(String str) {
        return n(str, "&", false, f5096a);
    }

    public static k q(String str) {
        return n(str, ";", true, null);
    }

    public static k s(String str) {
        return n(str, "&", false, f5097b);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements c {
        a() {
        }

        @Override // com.koushikdutta.async.http.k.c
        public String b(String str) {
            return Uri.decode(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements c {
        b() {
        }

        @Override // com.koushikdutta.async.http.k.c
        public String b(String str) {
            return URLDecoder.decode(str);
        }
    }

    public k(k kVar) {
        putAll(kVar);
    }

    public static k m(String str, String str2, String str3, boolean z10, c cVar) {
        k kVar = new k();
        if (str != null) {
            for (String str4 : str.split(str2)) {
                String[] strArrSplit = str4.split(str3, 2);
                String strTrim = strArrSplit[0].trim();
                if (!TextUtils.isEmpty(strTrim)) {
                    String strB = strArrSplit.length > 1 ? strArrSplit[1] : null;
                    if (strB != null && z10 && strB.endsWith("\"") && strB.startsWith("\"")) {
                        strB = strB.substring(1, strB.length() - 1);
                    }
                    if (strB != null && cVar != null) {
                        strTrim = cVar.b(strTrim);
                        strB = cVar.b(strB);
                    }
                    kVar.e(strTrim, strB);
                }
            }
        }
        return kVar;
    }

    public static k n(String str, String str2, boolean z10, c cVar) {
        return m(str, str2, "=", z10, cVar);
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            Iterator it = ((List) get(str)).iterator();
            while (it.hasNext()) {
                arrayList.add(new f(str, (String) it.next()));
            }
        }
        return arrayList.iterator();
    }

    protected List<String> k() {
        return new ArrayList();
    }

    public void e(String str, String str2) {
        h(str).add(str2);
    }

    public List<String> h(String str) {
        List<String> list = get(str);
        if (list == null) {
            List<String> listK = k();
            put(str, listK);
            return listK;
        }
        return list;
    }

    public String i(String str) {
        List<String> list = get(str);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    public void t(String str, String str2) {
        List<String> listK = k();
        listK.add(str2);
        put(str, listK);
    }
}
