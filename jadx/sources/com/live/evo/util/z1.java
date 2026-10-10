package com.live.evo.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class z1 implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f7394b = Pattern.compile("([\\\\,;])");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f7395c = Pattern.compile("\\n");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Map<String, Set<String>>> f7396a;

    z1() {
        this(null);
    }

    z1(List<Map<String, Set<String>>> list) {
        this.f7396a = list;
    }

    private static CharSequence b(CharSequence charSequence, Map<String, Set<String>> map) {
        StringBuilder sb2 = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                Set<String> value = entry.getValue();
                if (value != null && !value.isEmpty()) {
                    sb2.append(';');
                    sb2.append(entry.getKey());
                    sb2.append('=');
                    if (value.size() > 1) {
                        sb2.append('\"');
                    }
                    Iterator<String> it = value.iterator();
                    sb2.append(it.next());
                    while (it.hasNext()) {
                        sb2.append(',');
                        sb2.append(it.next());
                    }
                    if (value.size() > 1) {
                        sb2.append('\"');
                    }
                }
            }
        }
        sb2.append(':');
        sb2.append(charSequence);
        return sb2;
    }

    @Override // com.live.evo.util.u
    public CharSequence a(CharSequence charSequence, int i10) {
        String strReplaceAll = f7395c.matcher(f7394b.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        List<Map<String, Set<String>>> list = this.f7396a;
        return b(strReplaceAll, (list == null || list.size() <= i10) ? null : this.f7396a.get(i10));
    }
}
