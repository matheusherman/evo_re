package ua;

import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"", "", "T0", "(Ljava/lang/CharSequence;)C", "U0", "", "", "n", "S0", "(Ljava/lang/String;I)Ljava/lang/String;", "V0", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class d0 extends c0 {
    public static final String S0(String str, int i10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(h9.f.e(i10, str.length()));
            kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char T0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char U0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(b0.V(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String V0(String str, int i10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, h9.f.e(i10, str.length()));
            kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}
