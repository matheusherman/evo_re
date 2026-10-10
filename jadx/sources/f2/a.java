package f2;

import com.google.common.base.c;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f10012a = c.d('.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f10013b = c.d(':');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Inet4Address f10014c = (Inet4Address) c("127.0.0.1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Inet4Address f10015d = (Inet4Address) c("0.0.0.0");

    private static byte[] e(String str) {
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            if (i10 >= str.length()) {
                i10 = -1;
                break;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '.') {
                z10 = true;
            } else if (cCharAt == ':') {
                if (z10) {
                    return null;
                }
                z11 = true;
            } else {
                if (cCharAt == '%') {
                    break;
                }
                if (Character.digit(cCharAt, 16) == -1) {
                    return null;
                }
            }
            i10++;
        }
        if (!z11) {
            if (z10 && i10 == -1) {
                return i(str);
            }
            return null;
        }
        if (z10 && (str = b(str)) == null) {
            return null;
        }
        if (i10 != -1) {
            str = str.substring(0, i10);
        }
        return j(str);
    }

    private static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrI = i(str.substring(iLastIndexOf));
        if (bArrI == null) {
            return null;
        }
        return strSubstring + Integer.toHexString(((bArrI[0] & 255) << 8) | (bArrI[1] & 255)) + ":" + Integer.toHexString((bArrI[3] & 255) | ((bArrI[2] & 255) << 8));
    }

    private static IllegalArgumentException d(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    private static short g(String str, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 <= 0 || i12 > 4) {
            throw new NumberFormatException();
        }
        int iDigit = 0;
        while (i10 < i11) {
            iDigit = (iDigit << 4) | Character.digit(str.charAt(i10), 16);
            i10++;
        }
        return (short) iDigit;
    }

    private static byte h(String str, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 <= 0 || i12 > 3) {
            throw new NumberFormatException();
        }
        if (i12 > 1 && str.charAt(i10) == '0') {
            throw new NumberFormatException();
        }
        int i13 = 0;
        while (i10 < i11) {
            int i14 = i13 * 10;
            int iDigit = Character.digit(str.charAt(i10), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i13 = i14 + iDigit;
            i10++;
        }
        if (i13 <= 255) {
            return (byte) i13;
        }
        throw new NumberFormatException();
    }

    private static byte[] i(String str) {
        if (f10012a.c(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int iIndexOf = str.indexOf(46, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            try {
                bArr[i11] = h(str, i10, iIndexOf);
                i10 = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    private static byte[] j(String str) {
        int iC = f10013b.c(str);
        if (iC >= 2 && iC <= 8) {
            int i10 = 1;
            int i11 = iC + 1;
            int i12 = 8 - i11;
            boolean z10 = false;
            for (int i13 = 0; i13 < str.length() - 1; i13++) {
                if (str.charAt(i13) == ':' && str.charAt(i13 + 1) == ':') {
                    if (z10) {
                        return null;
                    }
                    int i14 = i12 + 1;
                    if (i13 == 0) {
                        i14 = i12 + 2;
                    }
                    if (i13 == str.length() - 2) {
                        i14++;
                    }
                    i12 = i14;
                    z10 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z10 && i12 <= 0) {
                return null;
            }
            if (!z10 && i11 != 8) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i10 = 0;
                }
                while (i10 < str.length()) {
                    int iIndexOf = str.indexOf(58, i10);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    if (str.charAt(i10) == ':') {
                        for (int i15 = 0; i15 < i12; i15++) {
                            byteBufferAllocate.putShort((short) 0);
                        }
                    } else {
                        byteBufferAllocate.putShort(g(str, i10, iIndexOf));
                    }
                    i10 = iIndexOf + 1;
                }
                return byteBufferAllocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static InetAddress a(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static InetAddress c(String str) {
        byte[] bArrE = e(str);
        if (bArrE != null) {
            return a(bArrE);
        }
        throw d("'%s' is not an IP string literal.", str);
    }

    public static boolean f(String str) {
        if (e(str) != null) {
            return true;
        }
        return false;
    }
}
