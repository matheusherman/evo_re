package oe;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BigInteger f16568a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BigInteger f16569b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigInteger f16570c = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f16571d = BigInteger.valueOf(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f16572e = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SecureRandom f16573f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f16574g = {0, 1, 0, -1, 0, -1, 0, 1};

    public static int a(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 < 0) {
            i10 = -i10;
        }
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 8;
        }
        return i11;
    }
}
