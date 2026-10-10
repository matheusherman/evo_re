package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class SortedKeyEnumeration implements Enumeration {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Enumeration f17064e;

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f17064e.hasMoreElements();
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return this.f17064e.nextElement();
    }

    public SortedKeyEnumeration(Hashtable hashtable) {
        Enumeration enumerationKeys = hashtable.keys();
        Vector vector = new Vector(hashtable.size());
        int i10 = 0;
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            int i11 = 0;
            while (i11 < i10 && str.compareTo((String) vector.get(i11)) > 0) {
                i11++;
            }
            vector.add(i11, str);
            i10++;
        }
        this.f17064e = vector.elements();
    }
}
