package ua;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000e2\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "marginPrefix", "k", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "newIndent", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "j", "(Ljava/lang/String;)Ljava/lang/String;", "h", "", "g", "(Ljava/lang/String;)I", "indent", "Lkotlin/Function1;", "d", "(Ljava/lang/String;)Lc9/l;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class r extends o {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(String line) {
        kotlin.jvm.internal.m.f(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String str, String line) {
        kotlin.jvm.internal.m.f(line, "line");
        return str + line;
    }

    public static final String h(String str, String newIndent) {
        String strInvoke;
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(newIndent, "newIndent");
        List<String> listK0 = b0.k0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK0) {
            if (!b0.d0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) kotlin.collections.r.x0(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listK0.size());
        c9.l<String, String> lVarD = d(newIndent);
        int iN = kotlin.collections.r.n(listK0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listK0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            String str2 = (String) obj2;
            if ((i10 == 0 || i10 == iN) && b0.d0(str2)) {
                str2 = null;
            } else {
                String strS0 = d0.S0(str2, iIntValue);
                if (strS0 != null && (strInvoke = lVarD.invoke(strS0)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i10 = i11;
        }
        return ((StringBuilder) kotlin.collections.c0.n0(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static final String i(String str, String newIndent, String marginPrefix) {
        String str2;
        String strInvoke;
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(newIndent, "newIndent");
        kotlin.jvm.internal.m.f(marginPrefix, "marginPrefix");
        if (b0.d0(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> listK0 = b0.k0(str);
        int length = str.length() + (newIndent.length() * listK0.size());
        c9.l<String, String> lVarD = d(newIndent);
        int iN = kotlin.collections.r.n(listK0);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listK0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            String str3 = (String) obj;
            String strSubstring = null;
            if ((i10 == 0 || i10 == iN) && b0.d0(str3)) {
                str2 = marginPrefix;
                str3 = null;
            } else {
                int length2 = str3.length();
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        i12 = -1;
                        break;
                    }
                    if (!b.c(str3.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
                if (i12 == -1) {
                    str2 = marginPrefix;
                } else {
                    int i13 = i12;
                    str2 = marginPrefix;
                    if (y.H(str3, str2, i13, false, 4, null)) {
                        int length3 = str2.length() + i13;
                        kotlin.jvm.internal.m.d(str3, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str3.substring(length3);
                        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strInvoke = lVarD.invoke(strSubstring)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i10 = i11;
            marginPrefix = str2;
        }
        return ((StringBuilder) kotlin.collections.c0.n0(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String j(String str) {
        kotlin.jvm.internal.m.f(str, "<this>");
        return h(str, "");
    }

    public static final String k(String str, String marginPrefix) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(marginPrefix, "marginPrefix");
        return i(str, "", marginPrefix);
    }

    public static /* synthetic */ String l(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return k(str, str2);
    }

    private static final c9.l<String, String> d(final String str) {
        if (str.length() == 0) {
            return new c9.l() { // from class: ua.p
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return r.e((String) obj);
                }
            };
        }
        return new c9.l() { // from class: ua.q
            @Override // c9.l
            public final Object invoke(Object obj) {
                return r.f(str, (String) obj);
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:13:0x001e A[RETURN] */
    private static final int g(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (b.c(str.charAt(i10))) {
                i10++;
            } else {
                if (i10 == -1) {
                    return str.length();
                }
                return i10;
            }
        }
        i10 = -1;
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }
}
