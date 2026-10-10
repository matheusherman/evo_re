package com.google.gson;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.h<String, k> f4923a = new com.google.gson.internal.h<>(false);

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof n) && ((n) obj).f4923a.equals(this.f4923a);
        }
        return true;
    }

    public int hashCode() {
        return this.f4923a.hashCode();
    }

    public void n(String str, k kVar) {
        com.google.gson.internal.h<String, k> hVar = this.f4923a;
        if (kVar == null) {
            kVar = m.f4922a;
        }
        hVar.put(str, kVar);
    }

    public Set<Map.Entry<String, k>> o() {
        return this.f4923a.entrySet();
    }

    public p q(String str) {
        return (p) this.f4923a.get(str);
    }
}
