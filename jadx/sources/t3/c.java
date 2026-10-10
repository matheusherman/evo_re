package t3;

import androidx.recyclerview.widget.ItemTouchHelper;
import h3.h;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import p3.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f18873b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f18875d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f18872a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f18874c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f18876e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0071  */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094 A[PHI: r0
      0x0094: PHI (r0v9 int) = (r0v3 int), (r0v6 int), (r0v0 int), (r0v0 int), (r0v12 int) binds: [B:50:0x00b5, B:49:0x00b3, B:26:0x007a, B:28:0x0080, B:36:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3  */
    static p3.e a(byte[] bArr) throws h {
        int i10 = 5;
        p3.c cVar = new p3.c(bArr);
        j jVar = new j(100);
        boolean z10 = false;
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        a aVarC = a.ASCII_ENCODE;
        HashSet hashSet = new HashSet();
        do {
            a aVar = a.ASCII_ENCODE;
            if (aVarC == aVar) {
                aVarC = c(cVar, jVar, sb2, hashSet);
            } else {
                switch (aVarC.ordinal()) {
                    case 2:
                        e(cVar, jVar, hashSet);
                        break;
                    case 3:
                        h(cVar, jVar, hashSet);
                        break;
                    case 4:
                        b(cVar, jVar);
                        break;
                    case 5:
                        g(cVar, jVar);
                        break;
                    case 6:
                        d(cVar, jVar, arrayList);
                        break;
                    case 7:
                        f(cVar, jVar);
                        z10 = true;
                        break;
                    default:
                        throw h.a();
                }
                aVarC = aVar;
            }
            if (aVarC != a.PAD_ENCODE) {
            }
            if (sb2.length() > 0) {
                jVar.e(sb2);
            }
            if (z10) {
                if (hashSet.contains(0) && !hashSet.contains(4)) {
                    if (hashSet.contains(1) || hashSet.contains(5)) {
                        i10 = 6;
                    } else {
                        i10 = 4;
                    }
                }
            } else if (!hashSet.contains(0) || hashSet.contains(4)) {
                i10 = 2;
            } else if (hashSet.contains(1) || hashSet.contains(5)) {
                i10 = 3;
            } else {
                i10 = 1;
            }
            String string = jVar.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new p3.e(bArr, string, arrayList, null, i10);
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            jVar.e(sb2);
        }
        if (z10) {
            if (hashSet.contains(0)) {
            }
        } else if (hashSet.contains(0)) {
            i10 = 2;
        } else {
            i10 = 2;
        }
        String string2 = jVar.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new p3.e(bArr, string2, arrayList, null, i10);
    }

    private static void b(p3.c cVar, j jVar) throws h {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    jVar.b('\r');
                } else if (i11 == 1) {
                    jVar.b('*');
                } else if (i11 == 2) {
                    jVar.b('>');
                } else if (i11 == 3) {
                    jVar.b(' ');
                } else if (i11 < 14) {
                    jVar.b((char) (i11 + 44));
                } else {
                    if (i11 >= 40) {
                        throw h.a();
                    }
                    jVar.b((char) (i11 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static a c(p3.c cVar, j jVar, StringBuilder sb2, Set<Integer> set) throws h {
        boolean z10 = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw h.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case 230:
                                return a.C40_ENCODE;
                            case 231:
                                return a.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(jVar.i()));
                                jVar.b((char) 29);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z10 = true;
                                break;
                            case 236:
                                jVar.d("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                jVar.d("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return a.ANSIX12_ENCODE;
                            case 239:
                                return a.TEXT_ENCODE;
                            case 240:
                                return a.EDIFACT_ENCODE;
                            case 241:
                                return a.ECI_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw h.a();
                                }
                                break;
                        }
                    } else {
                        int i10 = iD - 130;
                        if (i10 < 10) {
                            jVar.b('0');
                        }
                        jVar.c(i10);
                    }
                } else {
                    return a.PAD_ENCODE;
                }
            } else {
                if (z10) {
                    iD += 128;
                }
                jVar.b((char) (iD - 1));
                return a.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return a.ASCII_ENCODE;
    }

    private static void e(p3.c cVar, j jVar, Set<Integer> set) throws h {
        int iD;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f18873b;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    jVar.b((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    jVar.b(c10);
                                }
                            } else if (i12 == 27) {
                                set.add(Integer.valueOf(jVar.i()));
                                jVar.b((char) 29);
                            } else {
                                if (i12 != 30) {
                                    throw h.a();
                                }
                                z10 = true;
                            }
                        } else {
                            if (i10 != 3) {
                                throw h.a();
                            }
                            if (z10) {
                                jVar.b((char) (i12 + 224));
                                z10 = false;
                            } else {
                                jVar.b((char) (i12 + 96));
                            }
                        }
                    } else if (z10) {
                        jVar.b((char) (i12 + 128));
                        z10 = false;
                    } else {
                        jVar.b((char) i12);
                    }
                    i10 = 0;
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = f18872a;
                    if (i12 >= cArr2.length) {
                        throw h.a();
                    }
                    char c11 = cArr2[i12];
                    if (z10) {
                        jVar.b((char) (c11 + 128));
                        z10 = false;
                    } else {
                        jVar.b(c11);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(p3.c cVar, j jVar, Set<Integer> set) throws h {
        int iD;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f18875d;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    jVar.b((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    jVar.b(c10);
                                }
                            } else if (i12 == 27) {
                                set.add(Integer.valueOf(jVar.i()));
                                jVar.b((char) 29);
                            } else {
                                if (i12 != 30) {
                                    throw h.a();
                                }
                                z10 = true;
                            }
                        } else {
                            if (i10 != 3) {
                                throw h.a();
                            }
                            char[] cArr2 = f18876e;
                            if (i12 >= cArr2.length) {
                                throw h.a();
                            }
                            char c11 = cArr2[i12];
                            if (z10) {
                                jVar.b((char) (c11 + 128));
                                z10 = false;
                            } else {
                                jVar.b(c11);
                            }
                        }
                    } else if (z10) {
                        jVar.b((char) (i12 + 128));
                        z10 = false;
                    } else {
                        jVar.b((char) i12);
                    }
                    i10 = 0;
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = f18874c;
                    if (i12 >= cArr3.length) {
                        throw h.a();
                    }
                    char c12 = cArr3[i12];
                    if (z10) {
                        jVar.b((char) (c12 + 128));
                        z10 = false;
                    } else {
                        jVar.b(c12);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f18873b = cArr;
        f18875d = cArr;
    }

    private static void i(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    private static int j(int i10, int i11) {
        int i12 = i10 - (((i11 * 149) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }

    private static void d(p3.c cVar, j jVar, Collection<byte[]> collection) throws h {
        int iC = cVar.c();
        int i10 = iC + 2;
        int iJ = j(cVar.d(8), iC + 1);
        if (iJ == 0) {
            iJ = cVar.a() / 8;
        } else if (iJ >= 250) {
            iJ = ((iJ - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + j(cVar.d(8), i10);
            i10 = iC + 3;
        }
        if (iJ >= 0) {
            byte[] bArr = new byte[iJ];
            int i11 = 0;
            while (i11 < iJ) {
                if (cVar.a() >= 8) {
                    bArr[i11] = (byte) j(cVar.d(8), i10);
                    i11++;
                    i10++;
                } else {
                    throw h.a();
                }
            }
            collection.add(bArr);
            jVar.d(new String(bArr, StandardCharsets.ISO_8859_1));
            return;
        }
        throw h.a();
    }

    private static void f(p3.c cVar, j jVar) throws h {
        if (cVar.a() >= 8) {
            int iD = cVar.d(8);
            if (iD <= 127) {
                jVar.f(iD - 1);
                return;
            }
            return;
        }
        throw h.a();
    }

    private static void g(p3.c cVar, j jVar) {
        while (cVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                jVar.b((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }
}
