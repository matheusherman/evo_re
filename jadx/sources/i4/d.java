package i4;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p3.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f11028a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    private static void f(p3.c cVar, StringBuilder sb2, int i10) throws h3.h {
        while (i10 >= 3) {
            if (cVar.a() < 10) {
                throw h3.h.a();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw h3.h.a();
            }
            sb2.append(h(iD / 100));
            sb2.append(h((iD / 10) % 10));
            sb2.append(h(iD % 10));
            i10 -= 3;
        }
        if (i10 == 2) {
            if (cVar.a() < 7) {
                throw h3.h.a();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw h3.h.a();
            }
            sb2.append(h(iD2 / 10));
            sb2.append(h(iD2 % 10));
            return;
        }
        if (i10 == 1) {
            if (cVar.a() < 4) {
                throw h3.h.a();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw h3.h.a();
            }
            sb2.append(h(iD3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11029a;

        static {
            int[] iArr = new int[h.values().length];
            f11029a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11029a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11029a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11029a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11029a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11029a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11029a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11029a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11029a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11029a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00da  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00df  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:61:0x0103 A[LOOP:0: B:64:0x001e->B:61:0x0103, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8 A[SYNTHETIC] */
    static p3.e a(byte[] bArr, j jVar, f fVar, Map<h3.e, ?> map) throws h3.h {
        int i10;
        String string;
        byte[] bArr2 = bArr;
        p3.c cVar = new p3.c(bArr2);
        StringBuilder sb2 = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        p3.d dVarJ = null;
        int iD = -1;
        int iD2 = -1;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            try {
                h hVarF = cVar.a() < 4 ? h.TERMINATOR : h.f(cVar.d(4));
                int[] iArr = a.f11029a;
                switch (iArr[hVarF.ordinal()]) {
                    case 5:
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string2 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string2, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                    case 6:
                        hVarF = hVarF;
                        z10 = true;
                        z11 = true;
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string3 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string3, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                    case 7:
                        hVarF = hVarF;
                        z10 = true;
                        z12 = true;
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string4 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string4, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                    case 8:
                        hVarF = hVarF;
                        if (cVar.a() < 16) {
                            throw h3.h.a();
                        }
                        iD = cVar.d(8);
                        iD2 = cVar.d(8);
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string5 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string5, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                        break;
                    case 9:
                        hVarF = hVarF;
                        dVarJ = p3.d.j(g(cVar));
                        if (dVarJ == null) {
                            throw h3.h.a();
                        }
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string6 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string6, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                        break;
                    case 10:
                        hVarF = hVarF;
                        int iD3 = cVar.d(4);
                        int iD4 = cVar.d(hVarF.j(jVar));
                        if (iD3 == 1) {
                            d(cVar, sb2, iD4);
                        }
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string7 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string7, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                    default:
                        int iD5 = cVar.d(hVarF.j(jVar));
                        int i11 = iArr[hVarF.ordinal()];
                        if (i11 == 1) {
                            f(cVar, sb2, iD5);
                        } else if (i11 == 2) {
                            b(cVar, sb2, iD5, z10);
                        } else if (i11 == 3) {
                            c(cVar, sb2, iD5, dVarJ, arrayList, map);
                        } else {
                            if (i11 != 4) {
                                throw h3.h.a();
                            }
                            e(cVar, sb2, iD5);
                        }
                        if (hVarF == h.TERMINATOR) {
                            if (dVarJ != null) {
                                if (z11) {
                                    i10 = 4;
                                } else if (z12) {
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            } else if (z11) {
                                i10 = 3;
                            } else if (z12) {
                                i10 = 5;
                            } else {
                                i10 = 1;
                            }
                            String string8 = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new p3.e(bArr2, string8, arrayList, string, iD, iD2, i10);
                        }
                        bArr2 = bArr;
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw h3.h.a();
            }
        }
    }

    private static void c(p3.c cVar, StringBuilder sb2, int i10, p3.d dVar, Collection<byte[]> collection, Map<h3.e, ?> map) throws h3.h {
        if (i10 * 8 > cVar.a()) {
            throw h3.h.a();
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) cVar.d(8);
        }
        sb2.append(new String(bArr, dVar == null ? p.a(bArr, map) : dVar.k()));
        collection.add(bArr);
    }

    private static void d(p3.c cVar, StringBuilder sb2, int i10) throws h3.h {
        if (p.f17326c == null) {
            throw h3.h.a();
        }
        if (i10 * 13 > cVar.a()) {
            throw h3.h.a();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iD = cVar.d(13);
            int i12 = (iD % 96) | ((iD / 96) << 8);
            int i13 = i12 + (i12 < 2560 ? 41377 : 42657);
            bArr[i11] = (byte) ((i13 >> 8) & 255);
            bArr[i11 + 1] = (byte) (i13 & 255);
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, p.f17326c));
    }

    private static void e(p3.c cVar, StringBuilder sb2, int i10) throws h3.h {
        if (p.f17325b == null) {
            throw h3.h.a();
        }
        if (i10 * 13 > cVar.a()) {
            throw h3.h.a();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iD = cVar.d(13);
            int i12 = (iD % RsaOaep.DerParser.PRIVATE) | ((iD / RsaOaep.DerParser.PRIVATE) << 8);
            int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, p.f17325b));
    }

    private static int g(p3.c cVar) throws h3.h {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & RsaOaep.DerParser.PRIVATE) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw h3.h.a();
    }

    private static char h(int i10) throws h3.h {
        char[] cArr = f11028a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw h3.h.a();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    private static void b(p3.c cVar, StringBuilder sb2, int i10, boolean z10) throws h3.h {
        while (i10 > 1) {
            if (cVar.a() >= 11) {
                int iD = cVar.d(11);
                sb2.append(h(iD / 45));
                sb2.append(h(iD % 45));
                i10 -= 2;
            } else {
                throw h3.h.a();
            }
        }
        if (i10 == 1) {
            if (cVar.a() >= 6) {
                sb2.append(h(cVar.d(6)));
            } else {
                throw h3.h.a();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        } else {
                            sb2.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb2.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }
}
