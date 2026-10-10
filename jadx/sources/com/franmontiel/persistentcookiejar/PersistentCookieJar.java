package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.m;
import okhttp3.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class PersistentCookieJar implements ClearableCookieJar {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CookieCache f1476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CookiePersistor f1477d;

    @Override // okhttp3.n
    public synchronized void a(v vVar, List<m> list) {
        this.f1476c.addAll(list);
        this.f1477d.b(c(list));
    }

    @Override // okhttp3.n
    public synchronized List<m> b(v vVar) {
        ArrayList arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            arrayList = new ArrayList();
            Iterator<m> it = this.f1476c.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (d(next)) {
                    arrayList2.add(next);
                    it.remove();
                } else if (next.i(vVar)) {
                    arrayList.add(next);
                }
            }
            this.f1477d.removeAll(arrayList2);
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    private static List<m> c(List<m> list) {
        ArrayList arrayList = new ArrayList();
        for (m mVar : list) {
            if (mVar.getPersistent()) {
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.f1476c = cookieCache;
        this.f1477d = cookiePersistor;
        cookieCache.addAll(cookiePersistor.a());
    }

    private static boolean d(m mVar) {
        if (mVar.getExpiresAt() < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }
}
