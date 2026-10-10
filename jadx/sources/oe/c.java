package oe;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class c {
    public static a a(b bVar, i iVar) {
        int iD = bVar.d();
        int i10 = 1 << iD;
        int iG = iVar.g();
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, iG, i10);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, iG, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            iArr2[0][i11] = bVar.f(iVar.e(i11));
        }
        for (int i12 = 1; i12 < iG; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                iArr2[i12][i13] = bVar.h(iArr2[i12 - 1][i13], i13);
            }
        }
        for (int i14 = 0; i14 < iG; i14++) {
            for (int i15 = 0; i15 < i10; i15++) {
                for (int i16 = 0; i16 <= i14; i16++) {
                    int[] iArr3 = iArr[i14];
                    iArr3[i15] = bVar.a(iArr3[i15], bVar.h(iArr2[i16][i15], iVar.f((iG + i16) - i14)));
                }
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) cls, iG * iD, (i10 + 31) >>> 5);
        for (int i17 = 0; i17 < i10; i17++) {
            int i18 = i17 >>> 5;
            int i19 = 1 << (i17 & 31);
            for (int i20 = 0; i20 < iG; i20++) {
                int i21 = iArr[i20][i17];
                for (int i22 = 0; i22 < iD; i22++) {
                    if (((i21 >>> i22) & 1) != 0) {
                        int[] iArr5 = iArr4[(((i20 + 1) * iD) - i22) - 1];
                        iArr5[i18] = iArr5[i18] ^ i19;
                    }
                }
            }
        }
        return new a(i10, iArr4);
    }
}
