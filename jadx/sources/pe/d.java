package pe;

import java.io.PrintStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d {
    public static int a(int i10) {
        int i11 = -1;
        while (i10 != 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static int b(int i10, int i11) {
        while (true) {
            int i12 = i11;
            int i13 = i10;
            i10 = i12;
            if (i10 == 0) {
                return i13;
            }
            i11 = f(i13, i10);
        }
    }

    public static int c(int i10) {
        PrintStream printStream;
        String str;
        if (i10 < 0) {
            printStream = System.err;
            str = "The Degree is negative";
        } else {
            if (i10 <= 31) {
                if (i10 == 0) {
                    return 1;
                }
                int i11 = 1 << (i10 + 1);
                for (int i12 = (1 << i10) + 1; i12 < i11; i12 += 2) {
                    if (d(i12)) {
                        return i12;
                    }
                }
                return 0;
            }
            printStream = System.err;
            str = "The Degree is more then 31";
        }
        printStream.println(str);
        return 0;
    }

    public static boolean d(int i10) {
        if (i10 == 0) {
            return false;
        }
        int iA = a(i10) >>> 1;
        int iE = 2;
        for (int i11 = 0; i11 < iA; i11++) {
            iE = e(iE, iE, i10);
            if (b(iE ^ 2, i10) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int f(int i10, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (a(i10) >= a(i11)) {
            i10 ^= i11 << (a(i10) - a(i11));
        }
        return i10;
    }

    public static int e(int i10, int i11, int i12) {
        int iF = f(i10, i12);
        int iF2 = f(i11, i12);
        int i13 = 0;
        if (iF2 != 0) {
            int iA = 1 << a(i12);
            while (iF != 0) {
                if (((byte) (iF & 1)) == 1) {
                    i13 ^= iF2;
                }
                iF >>>= 1;
                iF2 <<= 1;
                if (iF2 >= iA) {
                    iF2 ^= i12;
                }
            }
        }
        return i13;
    }
}
