package y3;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends s {
    private static void i(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }

    @Override // y3.s
    protected Collection<h3.a> g() {
        return Collections.singleton(h3.a.CODE_39);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    private static String j(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != 0) {
                if (cCharAt != ' ') {
                    if (cCharAt != '@') {
                        if (cCharAt != '`') {
                            if (cCharAt != '-' && cCharAt != '.') {
                                if (cCharAt <= 26) {
                                    sb2.append('$');
                                    sb2.append((char) (cCharAt + '@'));
                                } else if (cCharAt < ' ') {
                                    sb2.append('%');
                                    sb2.append((char) (cCharAt + '&'));
                                } else if (cCharAt > ',' && cCharAt != '/' && cCharAt != ':') {
                                    if (cCharAt <= '9') {
                                        sb2.append(cCharAt);
                                    } else if (cCharAt <= '?') {
                                        sb2.append('%');
                                        sb2.append((char) (cCharAt + 11));
                                    } else if (cCharAt <= 'Z') {
                                        sb2.append(cCharAt);
                                    } else if (cCharAt <= '_') {
                                        sb2.append('%');
                                        sb2.append((char) (cCharAt - 16));
                                    } else if (cCharAt <= 'z') {
                                        sb2.append('+');
                                        sb2.append((char) (cCharAt - ' '));
                                    } else if (cCharAt <= 127) {
                                        sb2.append('%');
                                        sb2.append((char) (cCharAt - '+'));
                                    } else {
                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i10) + "'");
                                    }
                                } else {
                                    sb2.append('/');
                                    sb2.append((char) (cCharAt + ' '));
                                }
                            } else {
                                sb2.append(cCharAt);
                            }
                        } else {
                            sb2.append("%W");
                        }
                    } else {
                        sb2.append("%V");
                    }
                } else {
                    sb2.append(cCharAt);
                }
            } else {
                sb2.append("%U");
            }
        }
        return sb2.toString();
    }

    @Override // y3.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 80) {
            for (int i10 = 0; i10 < length; i10++) {
                if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i10)) < 0) {
                    str = j(str);
                    length = str.length();
                    if (length <= 80) {
                        break;
                    }
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            }
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[(length * 13) + 25];
            i(148, iArr);
            int iB = s.b(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iB2 = iB + s.b(zArr, iB, iArr2, false);
            for (int i11 = 0; i11 < length; i11++) {
                i(e.f22351e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11))], iArr);
                int iB3 = iB2 + s.b(zArr, iB2, iArr, true);
                iB2 = iB3 + s.b(zArr, iB3, iArr2, false);
            }
            i(148, iArr);
            s.b(zArr, iB2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
