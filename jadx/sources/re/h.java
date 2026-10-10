package re;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f17937a;

    static class a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            return System.getProperty("line.separator");
        }

        a() {
        }
    }

    public static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    public static String c(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int iC = se.e.c(bArr, cArr);
        if (iC >= 0) {
            return new String(cArr, 0, iC);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    static {
        try {
            try {
                f17937a = (String) AccessController.doPrivileged(new a());
            } catch (Exception unused) {
                f17937a = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            f17937a = "\n";
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    public static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) str.charAt(i10);
        }
        return bArr;
    }

    public static String e(String str) {
        char[] charArray = str.toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 != charArray.length; i10++) {
            char c10 = charArray[i10];
            if ('A' <= c10 && 'Z' >= c10) {
                charArray[i10] = (char) (c10 + ' ');
                z10 = true;
            }
        }
        if (z10) {
            return new String(charArray);
        }
        return str;
    }
}
