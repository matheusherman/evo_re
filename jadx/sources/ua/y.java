package ua;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0015\u001a\u00020\u0000*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0005\u001a+\u0010\u001c\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0005\u001a;\u0010#\u001a\u00020\u0002*\u00020\u00002\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010'\u001a\u00020\u0000*\u00020%2\u0006\u0010&\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"", TransactionPartnerType.OTHER, "", "ignoreCase", "w", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "", "oldChar", "newChar", "B", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "C", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "", "r", "([C)Ljava/lang/String;", "", "startIndex", "endIndex", "s", "([CII)Ljava/lang/String;", "", "t", "([B)Ljava/lang/String;", "prefix", "G", "F", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "suffix", "u", "thisOffset", "otherOffset", "length", "y", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "", "n", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class y extends x {
    public static String A(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        int i11 = 1;
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                cArr[i12] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        if (1 <= i10) {
            while (true) {
                sb2.append(charSequence);
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.c(string);
        return string;
    }

    public static final String B(String str, char c10, char c11, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kotlin.jvm.internal.m.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (c.d(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String C(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(oldValue, "oldValue");
        kotlin.jvm.internal.m.f(newValue, "newValue");
        int i10 = 0;
        int iX = b0.X(str, oldValue, 0, z10);
        if (iX < 0) {
            return str;
        }
        int length = oldValue.length();
        int iC = h9.f.c(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iX);
            sb2.append(newValue);
            i10 = iX + length;
            if (iX >= str.length()) {
                break;
            }
            iX = b0.X(str, oldValue, iX + iC, z10);
        } while (iX > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String D(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return B(str, c10, c11, z10);
    }

    public static /* synthetic */ String E(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return C(str, str2, str3, z10);
    }

    public static boolean F(String str, String prefix, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix, i10) : y(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean G(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : y(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean H(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return F(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean I(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return G(str, str2, z10);
    }

    public static String r(char[] cArr) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String s(char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        kotlin.collections.d.INSTANCE.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static String t(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        return new String(bArr, d.UTF_8);
    }

    public static boolean u(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : y(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean v(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return u(str, str2, z10);
    }

    public static boolean w(String str, String str2, boolean z10) {
        if (str == null) {
            return str2 == null;
        }
        return !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return w(str, str2, z10);
    }

    public static final boolean y(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }
}
