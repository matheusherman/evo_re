package io.netty.util.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class StringUtil {
    private static final byte[] HEX2B;
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i10) {
        int i11 = 0;
        while (i11 < i10 && isOws(charSequence.charAt(i11))) {
            i11++;
        }
        return i11;
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    static {
        String str;
        int i10 = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i10 >= strArr.length) {
                byte[] bArr = new byte[65536];
                HEX2B = bArr;
                Arrays.fill(bArr, (byte) -1);
                bArr[48] = 0;
                bArr[49] = 1;
                bArr[50] = 2;
                bArr[51] = 3;
                bArr[52] = 4;
                bArr[53] = 5;
                bArr[54] = 6;
                bArr[55] = 7;
                bArr[56] = 8;
                bArr[57] = 9;
                bArr[65] = 10;
                bArr[66] = 11;
                bArr[67] = 12;
                bArr[68] = 13;
                bArr[69] = 14;
                bArr[70] = 15;
                bArr[97] = 10;
                bArr[98] = 11;
                bArr[99] = 12;
                bArr[100] = 13;
                bArr[101] = 14;
                bArr[102] = 15;
                return;
            }
            String hexString = Integer.toHexString(i10);
            if (i10 > 15) {
                str = hexString;
            } else {
                str = '0' + hexString;
            }
            strArr[i10] = str;
            BYTE2HEX_NOPAD[i10] = hexString;
            i10++;
        }
    }

    public static String byteToHexStringPadded(int i10) {
        return BYTE2HEX_PAD[i10 & 255];
    }

    public static int decodeHexNibble(char c10) {
        return HEX2B[c10];
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x006a  */
    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00d7 A[SYNTHETIC] */
    public static CharSequence escapeCsv(CharSequence charSequence, boolean z10) {
        int iIndexOfLastNonOwsChar;
        int iIndexOfFirstNonOwsChar;
        int i10;
        boolean z11;
        int i11;
        StringBuilder sb2;
        char cCharAt;
        int i12;
        int i13;
        char cCharAt2;
        int i14;
        int i15;
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, "value")).length();
        boolean z12 = false;
        if (z10) {
            iIndexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
            iIndexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, iIndexOfFirstNonOwsChar, length);
        } else {
            iIndexOfLastNonOwsChar = length - 1;
            iIndexOfFirstNonOwsChar = 0;
        }
        if (iIndexOfFirstNonOwsChar > iIndexOfLastNonOwsChar) {
            return "";
        }
        if (isDoubleQuote(charSequence.charAt(iIndexOfFirstNonOwsChar))) {
            if (isDoubleQuote(charSequence.charAt(iIndexOfLastNonOwsChar)) && iIndexOfLastNonOwsChar > iIndexOfFirstNonOwsChar) {
                z12 = true;
            }
            if (z12) {
                iIndexOfFirstNonOwsChar++;
                z11 = z12;
                i10 = iIndexOfLastNonOwsChar - 1;
            } else {
                z11 = z12;
                i10 = iIndexOfLastNonOwsChar;
                i11 = iIndexOfFirstNonOwsChar;
            }
            if (iIndexOfFirstNonOwsChar < 0) {
                if (z11) {
                    i13 = i11;
                    while (i13 <= i10) {
                        cCharAt2 = charSequence.charAt(i13);
                        if (cCharAt2 == '\n' && cCharAt2 != '\r' && cCharAt2 != ',') {
                            if (isDoubleQuote(cCharAt2)) {
                                if (i13 != i10) {
                                    int i16 = i13 + 1;
                                    if (isDoubleQuote(charSequence.charAt(i16))) {
                                        i13 = i16;
                                    }
                                }
                            }
                            i13++;
                        }
                        iIndexOfFirstNonOwsChar = i13;
                        break;
                    }
                }
                i13 = i11;
                while (i13 <= i10) {
                    if (!isDoubleQuote(charSequence.charAt(i13))) {
                        if (i13 != i10) {
                            i15 = i13 + 1;
                            if (!isDoubleQuote(charSequence.charAt(i15))) {
                                i13 = i15;
                            }
                        }
                        iIndexOfFirstNonOwsChar = i13;
                        break;
                    }
                    i13++;
                }
                if (iIndexOfFirstNonOwsChar < 0) {
                    if (z11) {
                        i11--;
                        i14 = i10 + 2;
                    } else {
                        i14 = i10 + 1;
                    }
                    return charSequence.subSequence(i11, i14);
                }
            }
            sb2 = new StringBuilder((i10 - i11) + 8);
            sb2.append('\"');
            sb2.append(charSequence, i11, iIndexOfFirstNonOwsChar);
            while (iIndexOfFirstNonOwsChar <= i10) {
                cCharAt = charSequence.charAt(iIndexOfFirstNonOwsChar);
                if (isDoubleQuote(cCharAt)) {
                    sb2.append('\"');
                    if (iIndexOfFirstNonOwsChar < i10) {
                        i12 = iIndexOfFirstNonOwsChar + 1;
                        if (isDoubleQuote(charSequence.charAt(i12))) {
                            iIndexOfFirstNonOwsChar = i12;
                        }
                    }
                }
                sb2.append(cCharAt);
                iIndexOfFirstNonOwsChar++;
            }
            sb2.append('\"');
            return sb2;
        }
        i10 = iIndexOfLastNonOwsChar;
        z11 = false;
        i11 = iIndexOfFirstNonOwsChar;
        iIndexOfFirstNonOwsChar = -1;
        if (iIndexOfFirstNonOwsChar < 0) {
            if (z11) {
                i13 = i11;
                while (i13 <= i10) {
                    cCharAt2 = charSequence.charAt(i13);
                    if (cCharAt2 == '\n') {
                    }
                    iIndexOfFirstNonOwsChar = i13;
                    break;
                }
            }
            i13 = i11;
            while (i13 <= i10) {
                if (!isDoubleQuote(charSequence.charAt(i13))) {
                    if (i13 != i10) {
                        i15 = i13 + 1;
                        if (!isDoubleQuote(charSequence.charAt(i15))) {
                            i13 = i15;
                        }
                    }
                    iIndexOfFirstNonOwsChar = i13;
                    break;
                }
                i13++;
            }
            if (iIndexOfFirstNonOwsChar < 0) {
                if (z11) {
                    i11--;
                    i14 = i10 + 2;
                } else {
                    i14 = i10 + 1;
                }
                return charSequence.subSequence(i11, i14);
            }
        }
        sb2 = new StringBuilder((i10 - i11) + 8);
        sb2.append('\"');
        sb2.append(charSequence, i11, iIndexOfFirstNonOwsChar);
        while (iIndexOfFirstNonOwsChar <= i10) {
            cCharAt = charSequence.charAt(iIndexOfFirstNonOwsChar);
            if (isDoubleQuote(cCharAt)) {
                sb2.append('\"');
                if (iIndexOfFirstNonOwsChar < i10) {
                    i12 = iIndexOfFirstNonOwsChar + 1;
                    if (isDoubleQuote(charSequence.charAt(i12))) {
                        iIndexOfFirstNonOwsChar = i12;
                    }
                }
            }
            sb2.append(cCharAt);
            iIndexOfFirstNonOwsChar++;
        }
        sb2.append('\"');
        return sb2;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - 1;
        while (i12 > i10 && isOws(charSequence.charAt(i12))) {
            i12--;
        }
        return i12;
    }

    private static boolean isDoubleQuote(char c10) {
        return c10 == '\"';
    }

    private static boolean isOws(char c10) {
        return c10 == ' ' || c10 == '\t';
    }

    public static CharSequence join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(charSequence, "separator");
        ObjectUtil.checkNotNull(iterable, "elements");
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        CharSequence next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder(next);
        do {
            sb2.append(charSequence);
            sb2.append(it.next());
        } while (it.hasNext());
        return sb2;
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i10) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i10);
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder sbStringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            char cCharAt = charSequence.charAt(i10);
            if (!z10) {
                if (cCharAt != '\n' && cCharAt != '\r') {
                    if (cCharAt != '\"') {
                        if (cCharAt != ',') {
                            sbStringBuilder.append(cCharAt);
                        } else {
                            arrayList.add(sbStringBuilder.toString());
                            sbStringBuilder.setLength(0);
                        }
                    } else if (sbStringBuilder.length() == 0) {
                        z10 = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i10);
            }
            if (cCharAt != '\"') {
                sbStringBuilder.append(cCharAt);
            } else {
                if (i10 == length) {
                    arrayList.add(sbStringBuilder.toString());
                    return arrayList;
                }
                int i11 = i10 + 1;
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt2 == '\"') {
                    sbStringBuilder.append('\"');
                    i10 = i11;
                } else {
                    if (cCharAt2 != ',') {
                        throw newInvalidEscapedCsvFieldException(charSequence, i10);
                    }
                    arrayList.add(sbStringBuilder.toString());
                    sbStringBuilder.setLength(0);
                    i10 = i11;
                    z10 = false;
                }
            }
            i10++;
        }
        if (z10) {
            throw newInvalidEscapedCsvFieldException(charSequence, length);
        }
        arrayList.add(sbStringBuilder.toString());
        return arrayList;
    }

    public static byte decodeHexByte(CharSequence charSequence, int i10) {
        int iDecodeHexNibble = decodeHexNibble(charSequence.charAt(i10));
        int iDecodeHexNibble2 = decodeHexNibble(charSequence.charAt(i10 + 1));
        if (iDecodeHexNibble != -1 && iDecodeHexNibble2 != -1) {
            return (byte) ((iDecodeHexNibble << 4) + iDecodeHexNibble2);
        }
        throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", charSequence.subSequence(i10, i10 + 2), Integer.valueOf(i10), charSequence));
    }

    public static boolean isSurrogate(char c10) {
        if (c10 >= 55296 && c10 <= 57343) {
            return true;
        }
        return false;
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf > -1 ? name.substring(iLastIndexOf + 1) : name;
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            int iIndexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
            int iIndexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, iIndexOfFirstNonOwsChar, length);
            if (iIndexOfFirstNonOwsChar != 0 || iIndexOfLastNonOwsChar != length - 1) {
                return charSequence.subSequence(iIndexOfFirstNonOwsChar, iIndexOfLastNonOwsChar + 1);
            }
        }
        return charSequence;
    }
}
