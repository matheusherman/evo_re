package ac;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || b.a(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == null && charSequence2 == null;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return b.b(charSequence, z10, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
    }

    public static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        return b(charSequence, charSequence2, true);
    }

    public static String j(String str, String str2, String str3) {
        return k(str, str2, str3, -1);
    }

    public static String[] l(String str, String str2) {
        return m(str, str2, -1, false);
    }

    public static boolean n(CharSequence charSequence, CharSequence charSequence2) {
        return o(charSequence, charSequence2, false);
    }

    private static boolean o(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == null && charSequence2 == null;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return b.b(charSequence, z10, 0, charSequence2, 0, charSequence2.length());
    }

    public static boolean d(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? charSequence.equals(charSequence2) : b.b(charSequence, false, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
    }

    public static int e(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return b.a(charSequence, charSequence2, i10);
    }

    public static boolean f(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String g(String str, int i10, char c10) {
        if (str == null) {
            return null;
        }
        int length = i10 - str.length();
        if (length <= 0) {
            return str;
        }
        return length > 8192 ? h(str, i10, String.valueOf(c10)) : i(c10, length).concat(str);
    }

    public static String h(String str, int i10, String str2) {
        if (str == null) {
            return null;
        }
        if (f(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i10 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return g(str, i10, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i11 = 0; i11 < length2; i11++) {
            cArr[i11] = charArray[i11 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String i(char c10, int i10) {
        char[] cArr = new char[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            cArr[i11] = c10;
        }
        return new String(cArr);
    }

    private static String[] m(String str, String str2, int i10, boolean z10) {
        int i11;
        boolean z11;
        boolean z12;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        int i14;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return a.f194c;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i13 = 0;
            z13 = false;
            z14 = false;
            i14 = 0;
            int i15 = 1;
            while (i13 < length) {
                if (Character.isWhitespace(str.charAt(i13))) {
                    if (z13 || z10) {
                        int i16 = i15 + 1;
                        if (i15 == i10) {
                            i13 = length;
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        arrayList.add(str.substring(i14, i13));
                        i15 = i16;
                        z13 = false;
                    }
                    i14 = i13 + 1;
                    i13 = i14;
                } else {
                    i13++;
                    z13 = true;
                    z14 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char cCharAt = str2.charAt(0);
                i11 = 0;
                z11 = false;
                z12 = false;
                i12 = 0;
                int i17 = 1;
                while (i11 < length) {
                    if (str.charAt(i11) == cCharAt) {
                        if (z11 || z10) {
                            int i18 = i17 + 1;
                            if (i17 == i10) {
                                i11 = length;
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            arrayList.add(str.substring(i12, i11));
                            i17 = i18;
                            z11 = false;
                        }
                        i12 = i11 + 1;
                        i11 = i12;
                    } else {
                        i11++;
                        z11 = true;
                        z12 = false;
                    }
                }
            } else {
                i11 = 0;
                z11 = false;
                z12 = false;
                i12 = 0;
                int i19 = 1;
                while (i11 < length) {
                    if (str2.indexOf(str.charAt(i11)) >= 0) {
                        if (z11 || z10) {
                            int i20 = i19 + 1;
                            if (i19 == i10) {
                                i11 = length;
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            arrayList.add(str.substring(i12, i11));
                            i19 = i20;
                            z11 = false;
                        }
                        i12 = i11 + 1;
                        i11 = i12;
                    } else {
                        i11++;
                        z11 = true;
                        z12 = false;
                    }
                }
            }
            i13 = i11;
            z13 = z11;
            z14 = z12;
            i14 = i12;
        }
        if (z13 || (z10 && z14)) {
            arrayList.add(str.substring(i14, i13));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String p(String str, int i10) {
        if (str == null) {
            return null;
        }
        if (i10 < 0) {
            i10 += str.length();
        }
        if (i10 < 0) {
            i10 = 0;
        }
        return i10 > str.length() ? "" : str.substring(i10);
    }

    public static String q(String str, int i10, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0) {
            i11 += str.length();
        }
        if (i10 < 0) {
            i10 += str.length();
        }
        if (i11 > str.length()) {
            i11 = str.length();
        }
        if (i10 > i11) {
            return "";
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        return str.substring(i10, i11);
    }

    public static String r(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String s(String str) {
        return str == null ? "" : str.trim();
    }

    public static String k(String str, String str2, String str3, int i10) {
        int i11;
        if (!f(str) && !f(str2) && str3 != null && i10 != 0) {
            int i12 = 0;
            int iIndexOf = str.indexOf(str2, 0);
            if (iIndexOf == -1) {
                return str;
            }
            int length = str2.length();
            int length2 = str3.length() - length;
            if (length2 < 0) {
                length2 = 0;
            }
            if (i10 < 0) {
                i11 = 16;
            } else {
                i11 = 64;
                if (i10 <= 64) {
                    i11 = i10;
                }
            }
            StringBuilder sb2 = new StringBuilder(str.length() + (length2 * i11));
            while (iIndexOf != -1) {
                sb2.append(str.substring(i12, iIndexOf));
                sb2.append(str3);
                i12 = iIndexOf + length;
                i10--;
                if (i10 == 0) {
                    break;
                }
                iIndexOf = str.indexOf(str2, i12);
            }
            sb2.append(str.substring(i12));
            return sb2.toString();
        }
        return str;
    }

    public static String t(String str) {
        String strR = r(str);
        if (f(strR)) {
            return null;
        }
        return strR;
    }
}
