package oe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class j {
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
            i11 = e(i13, i10);
        }
    }

    public static boolean c(int i10) {
        if (i10 == 0) {
            return false;
        }
        int iA = a(i10) >>> 1;
        int iD = 2;
        for (int i11 = 0; i11 < iA; i11++) {
            iD = d(iD, iD, i10);
            if (b(iD ^ 2, i10) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int e(int i10, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (a(i10) >= a(i11)) {
            i10 ^= i11 << (a(i10) - a(i11));
        }
        return i10;
    }

    public static int d(int i10, int i11, int i12) {
        int iE = e(i10, i12);
        int iE2 = e(i11, i12);
        int i13 = 0;
        if (iE2 != 0) {
            int iA = 1 << a(i12);
            while (iE != 0) {
                if (((byte) (iE & 1)) == 1) {
                    i13 ^= iE2;
                }
                iE >>>= 1;
                iE2 <<= 1;
                if (iE2 >= iA) {
                    iE2 ^= i12;
                }
            }
        }
        return i13;
    }
}
