package y3;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f22371b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f22372c = {3, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f22373d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // y3.s
    protected Collection<h3.a> g() {
        return Collections.singleton(h3.a.ITF);
    }

    @Override // y3.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length <= 80) {
                s.c(str);
                boolean[] zArr = new boolean[(length * 9) + 9];
                int iB = s.b(zArr, 0, f22371b, true);
                for (int i10 = 0; i10 < length; i10 += 2) {
                    int iDigit = Character.digit(str.charAt(i10), 10);
                    int iDigit2 = Character.digit(str.charAt(i10 + 1), 10);
                    int[] iArr = new int[10];
                    for (int i11 = 0; i11 < 5; i11++) {
                        int i12 = i11 * 2;
                        int[][] iArr2 = f22373d;
                        iArr[i12] = iArr2[iDigit][i11];
                        iArr[i12 + 1] = iArr2[iDigit2][i11];
                    }
                    iB += s.b(zArr, iB, iArr, true);
                }
                s.b(zArr, iB, f22372c, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
