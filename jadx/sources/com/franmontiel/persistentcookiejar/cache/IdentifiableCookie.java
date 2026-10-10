package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class IdentifiableCookie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f1478a;

    static List<IdentifiableCookie> a(Collection<m> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<m> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new IdentifiableCookie(it.next()));
        }
        return arrayList;
    }

    m b() {
        return this.f1478a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        return identifiableCookie.f1478a.getName().equals(this.f1478a.getName()) && identifiableCookie.f1478a.getDomain().equals(this.f1478a.getDomain()) && identifiableCookie.f1478a.getPath().equals(this.f1478a.getPath()) && identifiableCookie.f1478a.getSecure() == this.f1478a.getSecure() && identifiableCookie.f1478a.getHostOnly() == this.f1478a.getHostOnly();
    }

    public int hashCode() {
        return ((((((((527 + this.f1478a.getName().hashCode()) * 31) + this.f1478a.getDomain().hashCode()) * 31) + this.f1478a.getPath().hashCode()) * 31) + (!this.f1478a.getSecure() ? 1 : 0)) * 31) + (!this.f1478a.getHostOnly() ? 1 : 0);
    }

    IdentifiableCookie(m mVar) {
        this.f1478a = mVar;
    }
}
