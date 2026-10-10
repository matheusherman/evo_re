package org.apache.log4j.helpers;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Transform {
    private static final String CDATA_EMBEDED_END = "]]>]]&gt;<![CDATA[";
    private static final String CDATA_END = "]]>";
    private static final int CDATA_END_LEN = 3;
    private static final String CDATA_PSEUDO_END = "]]&gt;";
    private static final String CDATA_START = "<![CDATA[";

    public static void appendEscapingCDATA(StringBuffer stringBuffer, String str) {
        if (str != null) {
            int iIndexOf = str.indexOf(CDATA_END);
            if (iIndexOf < 0) {
                stringBuffer.append(str);
                return;
            }
            int i10 = 0;
            while (iIndexOf > -1) {
                stringBuffer.append(str.substring(i10, iIndexOf));
                stringBuffer.append(CDATA_EMBEDED_END);
                i10 = CDATA_END_LEN + iIndexOf;
                if (i10 >= str.length()) {
                    return;
                } else {
                    iIndexOf = str.indexOf(CDATA_END, i10);
                }
            }
            stringBuffer.append(str.substring(i10));
        }
    }

    public static String escapeTags(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.indexOf(34) == -1 && str.indexOf(38) == -1 && str.indexOf(60) == -1 && str.indexOf(62) == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 6);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt > '>') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '<') {
                stringBuffer.append("&lt;");
            } else if (cCharAt == '>') {
                stringBuffer.append("&gt;");
            } else if (cCharAt == '&') {
                stringBuffer.append("&amp;");
            } else if (cCharAt == '\"') {
                stringBuffer.append("&quot;");
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }
}
