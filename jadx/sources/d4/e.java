package d4;

import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f9617a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f9618b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigInteger[] f9619c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    private static int a(int i10, int[] iArr, int i11, p3.j jVar) throws h3.h {
        int i12;
        int i13;
        boolean z10 = false;
        while (i11 < iArr[0] && !z10) {
            while (true) {
                i12 = iArr[0];
                if (i11 >= i12 || iArr[i11] != 927) {
                    break;
                }
                jVar.f(iArr[i11 + 1]);
                i11 += 2;
            }
            if (i11 >= i12 || iArr[i11] >= 900) {
                z10 = true;
            } else {
                long j10 = 0;
                int i14 = 0;
                while (true) {
                    i13 = i11 + 1;
                    j10 = (j10 * 900) + ((long) iArr[i11]);
                    i14++;
                    if (i14 >= 5 || i13 >= iArr[0] || iArr[i13] >= 900) {
                        break;
                    }
                    i11 = i13;
                }
                if (i14 != 5 || (i10 != 924 && (i13 >= iArr[0] || iArr[i13] >= 900))) {
                    i13 -= i14;
                    while (i13 < iArr[0] && !z10) {
                        int i15 = i13 + 1;
                        int i16 = iArr[i13];
                        if (i16 < 900) {
                            jVar.a((byte) i16);
                            i13 = i15;
                        } else if (i16 == 927) {
                            i13 += 2;
                            jVar.f(iArr[i15]);
                        } else {
                            z10 = true;
                        }
                    }
                } else {
                    for (int i17 = 0; i17 < 6; i17++) {
                        jVar.a((byte) (j10 >> ((5 - i17) * 8)));
                    }
                }
                i11 = i13;
            }
        }
        return i11;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x003d. Please report as an issue. */
    private static int g(int[] iArr, int i10, p3.j jVar) throws h3.h {
        int i11;
        int i12;
        int i13 = iArr[0];
        int[] iArr2 = new int[(i13 - i10) * 2];
        int[] iArr3 = new int[(i13 - i10) * 2];
        a aVar = a.ALPHA;
        boolean z10 = false;
        while (true) {
            i11 = 0;
            while (true) {
                if (i10 < iArr[0] && !z10) {
                    i12 = i10 + 1;
                    int i14 = iArr[i10];
                    if (i14 < 900) {
                        iArr2[i11] = i14 / 30;
                        iArr2[i11 + 1] = i14 % 30;
                        i11 += 2;
                    } else if (i14 == 913) {
                        iArr2[i11] = 913;
                        i10 += 2;
                        iArr3[i11] = iArr[i12];
                        i11++;
                    } else if (i14 != 927) {
                        if (i14 != 928) {
                            switch (i14) {
                                case 900:
                                    iArr2[i11] = 900;
                                    i11++;
                                    break;
                                case 901:
                                case 902:
                                    break;
                                default:
                                    switch (i14) {
                                        case 922:
                                        case 923:
                                        case 924:
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                            }
                        }
                        z10 = true;
                    }
                    i10 = i12;
                }
            }
            a aVarE = e(iArr2, iArr3, i11, jVar, aVar);
            i10 += 2;
            jVar.f(iArr[i12]);
            int i15 = iArr[0];
            if (i10 > i15) {
                throw h3.h.a();
            }
            aVar = aVarE;
            iArr3 = new int[(i15 - i10) * 2];
            iArr2 = new int[(i15 - i10) * 2];
        }
        e(iArr2, iArr3, i11, jVar, aVar);
        return i10;
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f9619c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f9619c;
            if (i10 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(bigIntegerValueOf);
            i10++;
        }
    }

    static p3.e b(int[] iArr, String str) throws h3.h {
        p3.j jVar = new p3.j(iArr.length * 2);
        int iG = g(iArr, 1, jVar);
        c4.c cVar = new c4.c();
        while (iG < iArr[0]) {
            int i10 = iG + 1;
            int i11 = iArr[iG];
            if (i11 != 913) {
                switch (i11) {
                    case 900:
                        iG = g(iArr, i10, jVar);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iG = f(iArr, i10, jVar);
                        continue;
                    default:
                        switch (i11) {
                            case 922:
                            case 923:
                                throw h3.h.a();
                            case 924:
                                break;
                            case 925:
                                iG += 2;
                                continue;
                            case 926:
                                iG += 3;
                                continue;
                            case 927:
                                iG += 2;
                                jVar.f(iArr[i10]);
                                continue;
                            case 928:
                                iG = d(iArr, i10, cVar);
                                continue;
                            default:
                                iG = g(iArr, iG, jVar);
                                continue;
                        }
                        break;
                }
                iG = a(i11, iArr, i10, jVar);
            } else {
                iG += 2;
                jVar.b((char) iArr[i10]);
            }
        }
        if (jVar.h() && cVar.a() == null) {
            throw h3.h.a();
        }
        p3.e eVar = new p3.e(null, jVar.toString(), null, str);
        eVar.p(cVar);
        return eVar;
    }

    private static String c(int[] iArr, int i10) throws h3.h {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigIntegerAdd = bigIntegerAdd.add(f9619c[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw h3.h.a();
    }

    static int d(int[] iArr, int i10, c4.c cVar) throws h3.h {
        int i11;
        if (i10 + 2 > iArr[0]) {
            throw h3.h.a();
        }
        int[] iArr2 = new int[2];
        int i12 = 0;
        while (i12 < 2) {
            iArr2[i12] = iArr[i10];
            i12++;
            i10++;
        }
        String strC = c(iArr2, 2);
        if (strC.isEmpty()) {
            cVar.k(0);
        } else {
            try {
                cVar.k(Integer.parseInt(strC));
            } catch (NumberFormatException unused) {
                throw h3.h.a();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < iArr[0] && i10 < iArr.length && (i11 = iArr[i10]) != 922 && i11 != 923) {
            sb2.append(String.format("%03d", Integer.valueOf(i11)));
            i10++;
        }
        if (sb2.length() == 0) {
            throw h3.h.a();
        }
        cVar.e(sb2.toString());
        int i13 = iArr[i10] == 923 ? i10 + 1 : -1;
        while (i10 < iArr[0]) {
            int i14 = iArr[i10];
            if (i14 == 922) {
                i10++;
                cVar.h(true);
            } else {
                if (i14 != 923) {
                    throw h3.h.a();
                }
                switch (iArr[i10 + 1]) {
                    case 0:
                        p3.j jVar = new p3.j();
                        i10 = g(iArr, i10 + 2, jVar);
                        cVar.f(jVar.toString());
                        break;
                    case 1:
                        p3.j jVar2 = new p3.j();
                        i10 = f(iArr, i10 + 2, jVar2);
                        try {
                            cVar.j(Integer.parseInt(jVar2.toString()));
                        } catch (NumberFormatException unused2) {
                            throw h3.h.a();
                        }
                        break;
                    case 2:
                        p3.j jVar3 = new p3.j();
                        i10 = f(iArr, i10 + 2, jVar3);
                        try {
                            cVar.m(Long.parseLong(jVar3.toString()));
                        } catch (NumberFormatException unused3) {
                            throw h3.h.a();
                        }
                        break;
                    case 3:
                        p3.j jVar4 = new p3.j();
                        i10 = g(iArr, i10 + 2, jVar4);
                        cVar.l(jVar4.toString());
                        break;
                    case 4:
                        p3.j jVar5 = new p3.j();
                        i10 = g(iArr, i10 + 2, jVar5);
                        cVar.c(jVar5.toString());
                        break;
                    case 5:
                        p3.j jVar6 = new p3.j();
                        i10 = f(iArr, i10 + 2, jVar6);
                        try {
                            cVar.g(Long.parseLong(jVar6.toString()));
                        } catch (NumberFormatException unused4) {
                            throw h3.h.a();
                        }
                        break;
                    case 6:
                        p3.j jVar7 = new p3.j();
                        i10 = f(iArr, i10 + 2, jVar7);
                        try {
                            cVar.d(Integer.parseInt(jVar7.toString()));
                        } catch (NumberFormatException unused5) {
                            throw h3.h.a();
                        }
                        break;
                    default:
                        throw h3.h.a();
                }
            }
        }
        if (i13 != -1) {
            int i15 = i10 - i13;
            if (cVar.b()) {
                i15--;
            }
            if (i15 > 0) {
                cVar.i(Arrays.copyOfRange(iArr, i13, i15 + i13));
            }
        }
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[FALL_THROUGH, PHI: r2 r3 r4
      0x0058: PHI (r2v7 d4.e$a) = 
      (r2v3 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v10 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v13 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
      (r2v1 d4.e$a)
     binds: [B:81:0x00e5, B:83:0x00eb, B:77:0x00d7, B:79:0x00dc, B:69:0x00bf, B:71:0x00c4, B:64:0x00b3, B:67:0x00b9, B:55:0x009a, B:57:0x009f, B:51:0x008e, B:53:0x0092, B:34:0x005a, B:32:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0058: PHI (r3v7 d4.e$a) = 
      (r3v2 d4.e$a)
      (r3v1 d4.e$a)
      (r3v1 d4.e$a)
      (r3v3 d4.e$a)
      (r3v10 d4.e$a)
      (r3v1 d4.e$a)
      (r3v1 d4.e$a)
      (r3v11 d4.e$a)
      (r3v12 d4.e$a)
      (r3v1 d4.e$a)
      (r3v1 d4.e$a)
      (r3v13 d4.e$a)
      (r3v18 d4.e$a)
      (r3v19 d4.e$a)
     binds: [B:81:0x00e5, B:83:0x00eb, B:77:0x00d7, B:79:0x00dc, B:69:0x00bf, B:71:0x00c4, B:64:0x00b3, B:67:0x00b9, B:55:0x009a, B:57:0x009f, B:51:0x008e, B:53:0x0092, B:34:0x005a, B:32:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0058: PHI (r4v7 d4.e$a) = 
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v3 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v12 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
      (r4v15 d4.e$a)
      (r4v1 d4.e$a)
      (r4v1 d4.e$a)
     binds: [B:81:0x00e5, B:83:0x00eb, B:77:0x00d7, B:79:0x00dc, B:69:0x00bf, B:71:0x00c4, B:64:0x00b3, B:67:0x00b9, B:55:0x009a, B:57:0x009f, B:51:0x008e, B:53:0x0092, B:34:0x005a, B:32:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    private static a e(int[] iArr, int[] iArr2, int i10, p3.j jVar, a aVar) {
        int i11;
        char c10;
        char c11;
        a aVar2;
        a aVar3 = aVar;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = iArr[i12];
            int iOrdinal = aVar4.ordinal();
            char c12 = ' ';
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            if (iOrdinal != 4) {
                                if (iOrdinal == 5) {
                                    if (i13 < 29) {
                                        c11 = f9617a[i13];
                                    } else if (i13 == 29 || i13 == 900) {
                                        aVar4 = a.ALPHA;
                                    } else if (i13 == 913) {
                                        jVar.b((char) iArr2[i12]);
                                    }
                                }
                                c11 = 0;
                            } else if (i13 < 26) {
                                c11 = (char) (i13 + 65);
                            } else {
                                if (i13 != 26) {
                                    aVar4 = i13 != 900 ? aVar5 : a.ALPHA;
                                    c12 = 0;
                                } else {
                                    aVar4 = aVar5;
                                }
                                aVar5 = aVar5;
                                aVar5 = aVar4;
                                c11 = c12;
                            }
                            aVar5 = aVar5;
                        } else if (i13 < 29) {
                            c10 = f9617a[i13];
                            a aVar6 = aVar5;
                            aVar5 = aVar4;
                            c11 = c10;
                            aVar5 = aVar6;
                        } else if (i13 == 29 || i13 == 900) {
                            aVar3 = a.ALPHA;
                            aVar4 = aVar3;
                        } else if (i13 == 913) {
                            jVar.b((char) iArr2[i12]);
                        }
                        aVar5 = aVar4;
                        c11 = 0;
                    } else if (i13 < 25) {
                        c10 = f9618b[i13];
                        a aVar7 = aVar5;
                        aVar5 = aVar4;
                        c11 = c10;
                        aVar5 = aVar7;
                    } else {
                        if (i13 == 900) {
                            aVar3 = a.ALPHA;
                            aVar4 = aVar3;
                            c12 = 0;
                        } else {
                            if (i13 != 913) {
                                switch (i13) {
                                    case 25:
                                        aVar3 = a.PUNCT;
                                        aVar4 = aVar3;
                                        break;
                                    case 26:
                                        break;
                                    case 27:
                                        aVar3 = a.LOWER;
                                        aVar4 = aVar3;
                                        break;
                                    case 28:
                                        aVar3 = a.ALPHA;
                                        aVar4 = aVar3;
                                        break;
                                    case 29:
                                        aVar5 = aVar4;
                                        aVar4 = a.PUNCT_SHIFT;
                                    default:
                                        c12 = 0;
                                        break;
                                }
                            } else {
                                jVar.b((char) iArr2[i12]);
                            }
                            c12 = 0;
                        }
                        aVar5 = aVar5;
                        aVar5 = aVar4;
                        c11 = c12;
                    }
                } else if (i13 < 26) {
                    i11 = i13 + 97;
                    c10 = (char) i11;
                    a aVar8 = aVar5;
                    aVar5 = aVar4;
                    c11 = c10;
                    aVar5 = aVar8;
                } else {
                    if (i13 != 900) {
                        if (i13 != 913) {
                            switch (i13) {
                                case 27:
                                    aVar2 = a.ALPHA_SHIFT;
                                    a aVar9 = aVar2;
                                    aVar5 = aVar4;
                                    aVar4 = aVar9;
                                    break;
                                case 28:
                                    aVar3 = a.MIXED;
                                    break;
                                case 29:
                                    aVar2 = a.PUNCT_SHIFT;
                                    a aVar10 = aVar2;
                                    aVar5 = aVar4;
                                    aVar4 = aVar10;
                                    break;
                            }
                            aVar5 = aVar5;
                            aVar5 = aVar4;
                            c11 = c12;
                        } else {
                            jVar.b((char) iArr2[i12]);
                        }
                        c12 = 0;
                        aVar5 = aVar5;
                        aVar5 = aVar4;
                        c11 = c12;
                    } else {
                        aVar3 = a.ALPHA;
                    }
                    aVar4 = aVar3;
                    c12 = 0;
                    aVar5 = aVar5;
                    aVar5 = aVar4;
                    c11 = c12;
                }
            } else if (i13 < 26) {
                i11 = i13 + 65;
                c10 = (char) i11;
                a aVar11 = aVar5;
                aVar5 = aVar4;
                c11 = c10;
                aVar5 = aVar11;
            } else {
                if (i13 != 900) {
                    if (i13 != 913) {
                        switch (i13) {
                            case 26:
                                break;
                            case 27:
                                aVar3 = a.LOWER;
                                break;
                            case 28:
                                aVar3 = a.MIXED;
                                break;
                            case 29:
                                aVar5 = aVar4;
                                aVar4 = a.PUNCT_SHIFT;
                            default:
                                c12 = 0;
                                break;
                        }
                        aVar5 = aVar5;
                        aVar5 = aVar4;
                        c11 = c12;
                    } else {
                        jVar.b((char) iArr2[i12]);
                    }
                    c12 = 0;
                    aVar5 = aVar5;
                    aVar5 = aVar4;
                    c11 = c12;
                } else {
                    aVar3 = a.ALPHA;
                }
                aVar4 = aVar3;
                c12 = 0;
                aVar5 = aVar5;
                aVar5 = aVar4;
                c11 = c12;
            }
            if (c11 != 0) {
                jVar.b(c11);
            }
            i12++;
            aVar4 = aVar5;
            aVar5 = aVar5;
        }
        return aVar3;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0036  */
    /* JADX WARN: Code duplicated, block: B:34:0x003c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0007 A[SYNTHETIC] */
    private static int f(int[] iArr, int i10, p3.j jVar) {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        while (true) {
            int i11 = 0;
            while (true) {
                int i12 = iArr[0];
                if (i10 < i12 && !z10) {
                    int i13 = i10 + 1;
                    int i14 = iArr[i10];
                    if (i13 == i12) {
                        z10 = true;
                    }
                    if (i14 < 900) {
                        iArr2[i11] = i14;
                        i11++;
                    } else {
                        if (i14 != 900 && i14 != 901 && i14 != 927 && i14 != 928) {
                            switch (i14) {
                            }
                            if (i11 % 15 != 0 || i14 == 902 || z10) {
                                if (i11 > 0) {
                                    break;
                                }
                            }
                        }
                        z10 = true;
                        if (i11 % 15 != 0) {
                        }
                        if (i11 > 0) {
                            break;
                        }
                    }
                    i10 = i13;
                    if (i11 % 15 != 0) {
                    }
                    if (i11 > 0) {
                        break;
                    }
                }
            }
            jVar.d(c(iArr2, i11));
        }
        return i10;
    }
}
