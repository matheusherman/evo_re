package com.live.evo.util;

import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class p0 extends k {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Pattern f7318a = Pattern.compile("([\\\\:;])");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Pattern f7319b = Pattern.compile("\\n");

        /* synthetic */ a(q0 q0Var) {
            this();
        }

        private a() {
        }

        @Override // com.live.evo.util.u
        public CharSequence a(CharSequence charSequence, int i10) {
            return ':' + f7319b.matcher(f7318a.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Pattern f7320a = Pattern.compile(",");

        /* synthetic */ b(q0 q0Var) {
            this();
        }

        private b() {
        }

        @Override // com.live.evo.util.u
        public CharSequence a(CharSequence charSequence, int i10) {
            return f7320a.matcher(charSequence).replaceAll("");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Pattern f7321a = Pattern.compile("[^0-9+]+");

        /* synthetic */ c(q0 q0Var) {
            this();
        }

        private c() {
        }

        @Override // com.live.evo.util.u
        public CharSequence a(CharSequence charSequence, int i10) {
            return f7321a.matcher(k.d(charSequence.toString())).replaceAll("");
        }
    }

    @Override // com.live.evo.util.k
    public String[] c(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("MECARD:");
        StringBuilder sb3 = new StringBuilder(100);
        q0 q0Var = null;
        a aVar = new a(q0Var);
        k.b(sb2, sb3, "N", list, 1, new b(q0Var), aVar, ';');
        k.a(sb2, sb3, "ORG", str, aVar, ';');
        k.b(sb2, sb3, "ADR", list2, 1, null, aVar, ';');
        k.b(sb2, sb3, "TEL", list3, Integer.MAX_VALUE, new c(q0Var), aVar, ';');
        k.b(sb2, sb3, "EMAIL", list5, Integer.MAX_VALUE, null, aVar, ';');
        k.b(sb2, sb3, "URL", list6, Integer.MAX_VALUE, null, aVar, ';');
        k.a(sb2, sb3, "NOTE", str2, aVar, ';');
        sb2.append(';');
        return new String[]{sb2.toString(), sb3.toString()};
    }

    p0() {
    }
}
