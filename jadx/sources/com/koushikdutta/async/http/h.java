package com.koushikdutta.async.http;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final k f5093a = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends k {
        a() {
        }

        @Override // com.koushikdutta.async.http.k
        protected List<String> k() {
            return new u4.f();
        }
    }

    public h a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.f5093a.e(lowerCase, str2);
        ((u4.f) this.f5093a.get(lowerCase)).g(str);
        return this;
    }

    public h b(String str) {
        if (str != null) {
            String[] strArrSplit = str.trim().split(":", 2);
            if (strArrSplit.length == 2) {
                a(strArrSplit[0].trim(), strArrSplit[1].trim());
                return this;
            }
            a(strArrSplit[0].trim(), "");
        }
        return this;
    }

    public String c(String str) {
        return this.f5093a.i(str.toLowerCase(Locale.US));
    }

    public k d() {
        return this.f5093a;
    }

    public String e(String str) {
        List<String> listF = f(str.toLowerCase(Locale.US));
        if (listF == null || listF.size() == 0) {
            return null;
        }
        return listF.get(0);
    }

    public List<String> f(String str) {
        return this.f5093a.remove(str.toLowerCase(Locale.US));
    }

    public h g(String str, String str2) {
        if (str2 != null && (str2.contains("\n") || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f5093a.t(lowerCase, str2);
        ((u4.f) this.f5093a.get(lowerCase)).g(str);
        return this;
    }

    public StringBuilder i() {
        StringBuilder sb2 = new StringBuilder(256);
        Iterator<String> it = this.f5093a.keySet().iterator();
        while (it.hasNext()) {
            u4.f<String> fVar = (u4.f) this.f5093a.get(it.next());
            for (String str : fVar) {
                sb2.append((String) fVar.e());
                sb2.append(": ");
                sb2.append(str);
                sb2.append("\r\n");
            }
        }
        sb2.append("\r\n");
        return sb2;
    }

    public String h(String str) {
        return i().insert(0, str + "\r\n").toString();
    }

    public String toString() {
        return i().toString();
    }
}
