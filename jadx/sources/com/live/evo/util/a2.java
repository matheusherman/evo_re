package com.live.evo.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a2 implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Map<String, Set<String>>> f7178a;

    private static CharSequence b(CharSequence charSequence, Map<String, Set<String>> map) {
        if (map == null || map.isEmpty()) {
            return charSequence;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map.Entry<String, Set<String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Set<String> value = it.next().getValue();
            if (value != null && !value.isEmpty()) {
                Iterator<String> it2 = value.iterator();
                sb2.append(it2.next());
                while (it2.hasNext()) {
                    sb2.append(',');
                    sb2.append(it2.next());
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append(' ');
        }
        sb2.append(charSequence);
        return sb2;
    }

    a2(List<Map<String, Set<String>>> list) {
        this.f7178a = list;
    }

    @Override // com.live.evo.util.u
    public CharSequence a(CharSequence charSequence, int i10) {
        Map<String, Set<String>> map;
        String strD = k.d(charSequence.toString());
        List<Map<String, Set<String>>> list = this.f7178a;
        if (list != null && list.size() > i10) {
            map = this.f7178a.get(i10);
        } else {
            map = null;
        }
        return b(strD, map);
    }
}
