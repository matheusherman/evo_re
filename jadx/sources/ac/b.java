package ac;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    static boolean b(CharSequence charSequence, boolean z10, int i10, CharSequence charSequence2, int i11, int i12) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z10, i10, (String) charSequence2, i11, i12);
        }
        while (true) {
            int i13 = i12 - 1;
            if (i12 <= 0) {
                return true;
            }
            int i14 = i10 + 1;
            char cCharAt = charSequence.charAt(i10);
            int i15 = i11 + 1;
            char cCharAt2 = charSequence2.charAt(i11);
            if (cCharAt != cCharAt2) {
                if (!z10) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i10 = i14;
            i12 = i13;
            i11 = i15;
        }
    }

    static int a(CharSequence charSequence, CharSequence charSequence2, int i10) {
        return charSequence.toString().indexOf(charSequence2.toString(), i10);
    }
}
