package k4;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import h3.v;
import i4.h;
import i4.j;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p3.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f12131a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f12132b = StandardCharsets.ISO_8859_1;

    private static j m(int i10, i4.f fVar) throws v {
        for (int i11 = 1; i11 <= 40; i11++) {
            j jVarI = j.i(i11);
            if (v(i10, jVarI, fVar)) {
                return jVarI;
            }
        }
        throw new v("Data too big");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:61:0x013f  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public static g n(String str, i4.f fVar, Map<h3.g, ?> map) throws v {
        boolean z10;
        boolean z11;
        j jVarT;
        h hVar;
        j jVarE;
        p3.a aVar;
        p3.d dVarF;
        int iK;
        boolean z12 = false;
        if (map != null) {
            h3.g gVar = h3.g.GS1_FORMAT;
            if (map.containsKey(gVar) && Boolean.parseBoolean(map.get(gVar).toString())) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        if (map != null) {
            h3.g gVar2 = h3.g.QR_COMPACT;
            if (map.containsKey(gVar2) && Boolean.parseBoolean(map.get(gVar2).toString())) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        Charset charsetForName = f12132b;
        if (map != null && map.containsKey(h3.g.CHARACTER_SET)) {
            z12 = true;
        }
        if (z12) {
            try {
                charsetForName = Charset.forName(map.get(h3.g.CHARACTER_SET).toString());
            } catch (UnsupportedCharsetException unused) {
            }
        }
        if (z11) {
            hVar = h.BYTE;
            if (charsetForName.equals(f12132b)) {
                charsetForName = null;
            }
            f.c cVarI = f.i(str, null, charsetForName, z10, fVar);
            aVar = new p3.a();
            cVarI.b(aVar);
            jVarE = cVarI.e();
        } else {
            h hVarL = l(str, charsetForName);
            p3.a aVar2 = new p3.a();
            h hVar2 = h.BYTE;
            if (hVarL == hVar2 && z12 && (dVarF = p3.d.f(charsetForName)) != null) {
                d(dVarF, aVar2);
            }
            if (z10) {
                g(h.FNC1_FIRST_POSITION, aVar2);
            }
            g(hVarL, aVar2);
            p3.a aVar3 = new p3.a();
            c(str, hVarL, aVar3, charsetForName);
            if (map != null) {
                h3.g gVar3 = h3.g.QR_VERSION;
                if (map.containsKey(gVar3)) {
                    jVarT = j.i(Integer.parseInt(map.get(gVar3).toString()));
                    if (!v(i(hVarL, aVar2, aVar3, jVarT), jVarT, fVar)) {
                        throw new v("Data too big for requested version");
                    }
                } else {
                    jVarT = t(fVar, hVarL, aVar2, aVar3);
                }
            } else {
                jVarT = t(fVar, hVarL, aVar2, aVar3);
            }
            p3.a aVar4 = new p3.a();
            aVar4.c(aVar2);
            f(hVarL == hVar2 ? aVar3.n() : str.length(), jVarT, hVarL, aVar4);
            aVar4.c(aVar3);
            hVar = hVarL;
            jVarE = jVarT;
            aVar = aVar4;
        }
        j.b bVarF = jVarE.f(fVar);
        int iH = jVarE.h() - bVarF.d();
        u(iH, aVar);
        p3.a aVarR = r(aVar, jVarE.h(), iH, bVarF.c());
        g gVar4 = new g();
        gVar4.c(fVar);
        gVar4.f(hVar);
        gVar4.g(jVarE);
        int iE = jVarE.e();
        b bVar = new b(iE, iE);
        if (map != null) {
            h3.g gVar5 = h3.g.QR_MASK_PATTERN;
            if (map.containsKey(gVar5)) {
                iK = Integer.parseInt(map.get(gVar5).toString());
                if (!g.b(iK)) {
                    iK = -1;
                }
            } else {
                iK = -1;
            }
        } else {
            iK = -1;
        }
        if (iK == -1) {
            iK = k(aVarR, fVar, jVarE, bVar);
        }
        gVar4.d(iK);
        e.a(aVarR, fVar, jVarE, iK, bVar);
        gVar4.e(bVar);
        return gVar4;
    }

    static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new r3.d(r3.a.f17796l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    private static j t(i4.f fVar, h hVar, p3.a aVar, p3.a aVar2) {
        return m(i(hVar, aVar, aVar2, m(i(hVar, aVar, aVar2, j.i(1)), fVar)), fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12133a;

        static {
            int[] iArr = new int[h.values().length];
            f12133a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12133a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12133a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12133a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void c(String str, h hVar, p3.a aVar, Charset charset) {
        int i10 = a.f12133a[hVar.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
            return;
        }
        if (i10 == 2) {
            b(str, aVar);
            return;
        }
        if (i10 == 3) {
            a(str, aVar, charset);
        } else {
            if (i10 == 4) {
                e(str, aVar);
                return;
            }
            throw new v("Invalid mode: " + hVar);
        }
    }

    private static void d(p3.d dVar, p3.a aVar) {
        aVar.d(h.ECI.i(), 4);
        aVar.d(dVar.l(), 8);
    }

    static void e(String str, p3.a aVar) throws v {
        int i10;
        Charset charset = p.f17325b;
        if (charset == null) {
            throw new v("SJIS Charset not supported on this platform");
        }
        byte[] bytes = str.getBytes(charset);
        if (bytes.length % 2 != 0) {
            throw new v("Kanji byte size not even");
        }
        int length = bytes.length - 1;
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
                throw new v("Invalid byte sequence");
            }
            aVar.d(((i10 >> 8) * RsaOaep.DerParser.PRIVATE) + (i10 & 255), 13);
        }
    }

    private static h l(String str, Charset charset) {
        Charset charset2 = p.f17325b;
        if (charset2 != null && charset2.equals(charset) && s(str)) {
            return h.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z11 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return h.BYTE;
                }
                z10 = true;
            }
        }
        if (z10) {
            return h.ALPHANUMERIC;
        }
        return z11 ? h.NUMERIC : h.BYTE;
    }

    static int p(int i10) {
        int[] iArr = f12131a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws v {
        if (i13 >= i12) {
            throw new v("Block ID too large");
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
            throw new v("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new v("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new v("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    static boolean s(String str) {
        byte[] bytes = str.getBytes(p.f17325b);
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
    }

    static void u(int i10, p3.a aVar) throws v {
        int i11 = i10 * 8;
        if (aVar.m() > i11) {
            throw new v("data bits cannot fit in the QR Code" + aVar.m() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.m() < i11; i12++) {
            aVar.a(false);
        }
        int iM = aVar.m() & 7;
        if (iM > 0) {
            while (iM < 8) {
                aVar.a(false);
                iM++;
            }
        }
        int iN = i10 - aVar.n();
        for (int i13 = 0; i13 < iN; i13++) {
            aVar.d((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.m() != i11) {
            throw new v("Bits size does not equal capacity");
        }
    }

    static void a(String str, p3.a aVar, Charset charset) {
        for (byte b10 : str.getBytes(charset)) {
            aVar.d(b10, 8);
        }
    }

    static void b(CharSequence charSequence, p3.a aVar) throws v {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iP = p(charSequence.charAt(i10));
            if (iP != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int iP2 = p(charSequence.charAt(i11));
                    if (iP2 != -1) {
                        aVar.d((iP * 45) + iP2, 11);
                        i10 += 2;
                    } else {
                        throw new v();
                    }
                } else {
                    aVar.d(iP, 6);
                    i10 = i11;
                }
            } else {
                throw new v();
            }
        }
    }

    static void f(int i10, j jVar, h hVar, p3.a aVar) throws v {
        int iJ = hVar.j(jVar);
        int i11 = 1 << iJ;
        if (i10 < i11) {
            aVar.d(i10, iJ);
            return;
        }
        throw new v(i10 + " is bigger than " + (i11 - 1));
    }

    static void g(h hVar, p3.a aVar) {
        aVar.d(hVar.i(), 4);
    }

    static void h(CharSequence charSequence, p3.a aVar) {
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

    private static int i(h hVar, p3.a aVar, p3.a aVar2, j jVar) {
        return aVar.m() + hVar.j(jVar) + aVar2.m();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(p3.a aVar, i4.f fVar, j jVar, b bVar) throws v {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            e.a(aVar, fVar, jVar, i12, bVar);
            int iJ = j(bVar);
            if (iJ < i10) {
                i11 = i12;
                i10 = iJ;
            }
        }
        return i11;
    }

    static p3.a r(p3.a aVar, int i10, int i11, int i12) throws v {
        if (aVar.n() == i11) {
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
                q(i15, i16, i17, i13, iArr, iArr2);
                int i18 = iArr[0];
                byte[] bArr = new byte[i18];
                aVar.u(i14 * 8, bArr, 0, i18);
                byte[] bArrO = o(bArr, iArr2[0]);
                arrayList.add(new k4.a(bArr, bArrO));
                iMax = Math.max(iMax, i18);
                iMax2 = Math.max(iMax2, bArrO.length);
                i14 += iArr[0];
                i13++;
                i10 = i15;
                i11 = i16;
                i12 = i17;
            }
            int i19 = i10;
            if (i11 == i14) {
                p3.a aVar2 = new p3.a();
                for (int i20 = 0; i20 < iMax; i20++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA = ((k4.a) it.next()).a();
                        if (i20 < bArrA.length) {
                            aVar2.d(bArrA[i20], 8);
                        }
                    }
                }
                for (int i21 = 0; i21 < iMax2; i21++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((k4.a) it2.next()).b();
                        if (i21 < bArrB.length) {
                            aVar2.d(bArrB[i21], 8);
                        }
                    }
                }
                if (i19 == aVar2.n()) {
                    return aVar2;
                }
                throw new v("Interleaving error: " + i19 + " and " + aVar2.n() + " differ.");
            }
            throw new v("Data bytes does not match offset");
        }
        throw new v("Number of bits and data bytes does not match");
    }

    static boolean v(int i10, j jVar, i4.f fVar) {
        if (jVar.h() - jVar.f(fVar).d() >= (i10 + 7) / 8) {
            return true;
        }
        return false;
    }
}
