package a6;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f133a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static z5.c g(int i10, z5.a aVar) throws v5.c {
        for (int i11 = 1; i11 <= 40; i11++) {
            z5.c cVarD = z5.c.d(i11);
            if (cVarD.c() - cVarD.b(aVar).d() >= (i10 + 7) / 8) {
                return cVarD;
            }
        }
        throw new v5.c("Data too big");
    }

    private static boolean q(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & 255;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static byte[] r(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new x5.c(x5.a.f21845n).a(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static g a(String str, z5.a aVar, Map map) throws v5.c {
        w5.c cVarF;
        String str2 = map == null ? null : (String) map.get(v5.b.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        z5.b bVarF = f(str, str2);
        w5.a aVar2 = new w5.a();
        z5.b bVar = z5.b.BYTE;
        if (bVarF == bVar && !"ISO-8859-1".equals(str2) && (cVarF = w5.c.f(str2)) != null) {
            k(cVarF, aVar2);
        }
        l(bVarF, aVar2);
        w5.a aVar3 = new w5.a();
        p(str, bVarF, aVar3, str2);
        z5.c cVarG = g(bVarF.i(g(aVar2.h() + bVarF.i(z5.c.d(1)) + aVar3.h(), aVar)) + aVar2.h() + aVar3.h(), aVar);
        w5.a aVar4 = new w5.a();
        aVar4.c(aVar2);
        j(bVarF == bVar ? aVar3.i() : str.length(), cVarG, bVarF, aVar4);
        aVar4.c(aVar3);
        z5.e eVarB = cVarG.b(aVar);
        int iC = cVarG.c() - eVarB.d();
        i(iC, aVar4);
        w5.a aVarE = e(aVar4, cVarG.c(), iC, eVarB.c());
        g gVar = new g();
        gVar.c(aVar);
        gVar.f(bVarF);
        gVar.g(cVarG);
        int iA = cVarG.a();
        b bVar2 = new b(iA, iA);
        int iC2 = c(aVarE, aVar, cVarG, bVar2);
        gVar.d(iC2);
        f.e(aVarE, aVar, cVarG, iC2, bVar2);
        gVar.e(bVar2);
        return gVar;
    }

    static int b(int i10) {
        int[] iArr = f133a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    private static z5.b f(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return q(str) ? z5.b.KANJI : z5.b.BYTE;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z11 = true;
            } else {
                if (b(cCharAt) == -1) {
                    return z5.b.BYTE;
                }
                z10 = true;
            }
        }
        if (z10) {
            return z5.b.ALPHANUMERIC;
        }
        return z11 ? z5.b.NUMERIC : z5.b.BYTE;
    }

    static void h(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws v5.c {
        if (i13 >= i12) {
            throw new v5.c("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new v5.c("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new v5.c("RS blocks mismatch");
        }
        if (i10 != (i14 * (i19 + i21)) + ((i18 + i20) * i15)) {
            throw new v5.c("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    static void i(int i10, w5.a aVar) throws v5.c {
        int i11 = i10 * 8;
        if (aVar.h() > i11) {
            throw new v5.c("data bits cannot fit in the QR Code" + aVar.h() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.h() < i11; i12++) {
            aVar.a(false);
        }
        int iH = aVar.h() & 7;
        if (iH > 0) {
            while (iH < 8) {
                aVar.a(false);
                iH++;
            }
        }
        int i13 = i10 - aVar.i();
        for (int i14 = 0; i14 < i13; i14++) {
            aVar.d((i14 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.h() != i11) {
            throw new v5.c("Bits size does not equal capacity");
        }
    }

    private static void k(w5.c cVar, w5.a aVar) {
        aVar.d(z5.b.ECI.f(), 4);
        aVar.d(cVar.i(), 8);
    }

    static void n(String str, w5.a aVar) throws v5.c {
        int i10;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i11 = 0; i11 < length; i11 += 2) {
                int i12 = ((bytes[i11] & 255) << 8) | (bytes[i11 + 1] & 255);
                int i13 = 33088;
                if (i12 >= 33088 && i12 <= 40956) {
                    i10 = i12 - i13;
                } else if (i12 < 57408 || i12 > 60351) {
                    i10 = -1;
                } else {
                    i13 = 49472;
                    i10 = i12 - i13;
                }
                if (i10 == -1) {
                    throw new v5.c("Invalid byte sequence");
                }
                aVar.d((i10 & 255) + ((i10 >> 8) * RsaOaep.DerParser.PRIVATE), 13);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new v5.c(e10);
        }
    }

    static void p(String str, z5.b bVar, w5.a aVar, String str2) throws v5.c {
        int i10 = d.f134a[bVar.ordinal()];
        if (i10 == 1) {
            m(str, aVar);
            return;
        }
        if (i10 == 2) {
            s(str, aVar);
            return;
        }
        if (i10 == 3) {
            o(str, aVar, str2);
        } else {
            if (i10 == 4) {
                n(str, aVar);
                return;
            }
            throw new v5.c("Invalid mode: " + bVar);
        }
    }

    private static int c(w5.a aVar, z5.a aVar2, z5.c cVar, b bVar) throws v5.c {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            f.e(aVar, aVar2, cVar, i12, bVar);
            int iD = d(bVar);
            if (iD < i10) {
                i11 = i12;
                i10 = iD;
            }
        }
        return i11;
    }

    private static int d(b bVar) {
        return e.a(bVar) + e.f(bVar) + e.g(bVar) + e.h(bVar);
    }

    static w5.a e(w5.a aVar, int i10, int i11, int i12) throws v5.c {
        if (aVar.i() == i11) {
            ArrayList arrayList = new ArrayList(i12);
            int i13 = 0;
            int i14 = 0;
            int iMax = 0;
            int iMax2 = 0;
            while (i13 < i12) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int i15 = i10;
                int i16 = i11;
                int i17 = i12;
                h(i15, i16, i17, i13, iArr, iArr2);
                int i18 = iArr[0];
                byte[] bArr = new byte[i18];
                aVar.l(i14 * 8, bArr, 0, i18);
                byte[] bArrR = r(bArr, iArr2[0]);
                arrayList.add(new a(bArr, bArrR));
                iMax = Math.max(iMax, i18);
                i13++;
                iMax2 = Math.max(iMax2, bArrR.length);
                i14 += iArr[0];
                i10 = i15;
                i11 = i16;
                i12 = i17;
            }
            int i19 = i10;
            if (i11 == i14) {
                w5.a aVar2 = new w5.a();
                for (int i20 = 0; i20 < iMax; i20++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA = ((a) it.next()).a();
                        if (i20 < bArrA.length) {
                            aVar2.d(bArrA[i20], 8);
                        }
                    }
                }
                for (int i21 = 0; i21 < iMax2; i21++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((a) it2.next()).b();
                        if (i21 < bArrB.length) {
                            aVar2.d(bArrB[i21], 8);
                        }
                    }
                }
                if (i19 == aVar2.i()) {
                    return aVar2;
                }
                throw new v5.c("Interleaving error: " + i19 + " and " + aVar2.i() + " differ.");
            }
            throw new v5.c("Data bytes does not match offset");
        }
        throw new v5.c("Number of bits and data bytes does not match");
    }

    static void j(int i10, z5.c cVar, z5.b bVar, w5.a aVar) throws v5.c {
        int i11 = bVar.i(cVar);
        int i12 = 1 << i11;
        if (i10 < i12) {
            aVar.d(i10, i11);
            return;
        }
        throw new v5.c(i10 + " is bigger than " + (i12 - 1));
    }

    static void l(z5.b bVar, w5.a aVar) {
        aVar.d(bVar.f(), 4);
    }

    static void m(CharSequence charSequence, w5.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iCharAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.d((iCharAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.d((iCharAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.d(iCharAt, 4);
                }
            }
        }
    }

    static void o(String str, w5.a aVar, String str2) throws v5.c {
        try {
            for (byte b10 : str.getBytes(str2)) {
                aVar.d(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new v5.c(e10);
        }
    }

    static void s(CharSequence charSequence, w5.a aVar) throws v5.c {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iB = b(charSequence.charAt(i10));
            if (iB != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int iB2 = b(charSequence.charAt(i11));
                    if (iB2 != -1) {
                        aVar.d((iB * 45) + iB2, 11);
                        i10 += 2;
                    } else {
                        throw new v5.c();
                    }
                } else {
                    aVar.d(iB, 6);
                    i10 = i11;
                }
            } else {
                throw new v5.c();
            }
        }
    }
}
