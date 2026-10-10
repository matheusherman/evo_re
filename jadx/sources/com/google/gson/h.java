package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h extends k implements Iterable<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<k> f4853a = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof h) && ((h) obj).f4853a.equals(this.f4853a);
        }
        return true;
    }

    public int hashCode() {
        return this.f4853a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f4853a.iterator();
    }

    public void n(k kVar) {
        if (kVar == null) {
            kVar = m.f4922a;
        }
        this.f4853a.add(kVar);
    }
}
