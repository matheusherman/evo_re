package c3;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f1117a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Code duplicated, block: B:55:0x00e2 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e8 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:65:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x0119 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0193 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01c6 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:92:0x01f2  */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x0119, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:87:0x01d2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x01f2, please report this as an issue */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i10;
        int i11;
        int i12;
        int iD;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i13 = index + 4;
            int iD2 = d(str, index, i13);
            if (a(str, i13, '-')) {
                i13 = index + 5;
            }
            int i14 = i13 + 2;
            int iD3 = d(str, i13, i14);
            if (a(str, i14, '-')) {
                i14 = i13 + 3;
            }
            int i15 = i14 + 2;
            int iD4 = d(str, i14, i15);
            boolean zA = a(str, i15, 'T');
            if (!zA && str.length() <= i15) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i15);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i16 = i14 + 5;
                int iD5 = d(str, i14 + 3, i16);
                if (a(str, i16, ':')) {
                    i16 = i14 + 6;
                }
                int i17 = i16 + 2;
                int iD6 = d(str, i16, i17);
                if (a(str, i17, ':')) {
                    i17 = i16 + 3;
                }
                if (str.length() <= i17 || (cCharAt2 = str.charAt(i17)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i15 = i17;
                    i10 = iD5;
                    i11 = iD6;
                } else {
                    int i18 = i17 + 2;
                    iD = d(str, i17, i18);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i18, '.')) {
                        int i19 = i17 + 3;
                        int iB = b(str, i17 + 4);
                        int iMin = Math.min(iB, i17 + 6);
                        int iD7 = d(str, i19, iMin);
                        int i20 = iMin - i19;
                        if (i20 == 1) {
                            iD7 *= 100;
                        } else if (i20 == 2) {
                            iD7 *= 10;
                        }
                        i10 = iD5;
                        i15 = iB;
                        i11 = iD6;
                        i12 = iD7;
                    } else {
                        i10 = iD5;
                        i15 = i18;
                        i11 = iD6;
                        i12 = 0;
                    }
                }
                if (str.length() > i15) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i15);
                if (cCharAt == 'Z') {
                    timeZone = f1117a;
                    length = i15 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i15);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i15 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = f1117a;
                    } else {
                        String str3 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id2 = timeZone2.getID();
                        if (!id2.equals(str3) && !id2.replace(":", "").equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, iD2);
                gregorianCalendar2.set(2, iD3 - 1);
                gregorianCalendar2.set(5, iD4);
                gregorianCalendar2.set(11, i10);
                gregorianCalendar2.set(12, i11);
                gregorianCalendar2.set(13, iD);
                gregorianCalendar2.set(14, i12);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i10 = 0;
            i11 = 0;
            i12 = 0;
            iD = 0;
            if (str.length() > i15) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i15);
            if (cCharAt == 'Z') {
                timeZone = f1117a;
                length = i15 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i15);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i15 + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = f1117a;
                } else {
                    timeZone = f1117a;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, iD2);
            gregorianCalendar3.set(2, iD3 - 1);
            gregorianCalendar3.set(5, iD4);
            gregorianCalendar3.set(11, i10);
            gregorianCalendar3.set(12, i11);
            gregorianCalendar3.set(13, iD);
            gregorianCalendar3.set(14, i12);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IndexOutOfBoundsException e10) {
            e = e10;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (NumberFormatException e11) {
            e = e11;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (IllegalArgumentException e12) {
            e = e12;
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(e);
            throw parseException3;
        }
    }

    private static int d(String str, int i10, int i11) {
        int i12;
        int i13;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        if (i10 < i11) {
            i13 = i10 + 1;
            int iDigit = Character.digit(str.charAt(i10), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = -iDigit;
        } else {
            i12 = 0;
            i13 = i10;
        }
        while (i13 < i11) {
            int i14 = i13 + 1;
            int iDigit2 = Character.digit(str.charAt(i13), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = (i12 * 10) - iDigit2;
            i13 = i14;
        }
        return -i12;
    }

    private static boolean a(String str, int i10, char c10) {
        if (i10 < str.length() && str.charAt(i10) == c10) {
            return true;
        }
        return false;
    }

    private static int b(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i10++;
            } else {
                return i10;
            }
        }
        return str.length();
    }
}
