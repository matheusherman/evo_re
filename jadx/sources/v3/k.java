package v3;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f19552a = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int[] f19554g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int[] f19555h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, 144, 174, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int[] f19556i = {5, 10, 16, 33, 32, 49};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f19557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f19558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f19559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f19560d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b f19561e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f19562f;

        /* synthetic */ b(c cVar, d dVar, int i10, int i11, b bVar, a aVar) {
            this(cVar, dVar, i10, i11, bVar);
        }

        static byte[] h(int i10) {
            return new byte[]{(byte) i10};
        }

        static byte[] i(int i10, int i11) {
            return new byte[]{(byte) i10, (byte) i11};
        }

        int g() {
            int i10 = 0;
            for (b bVar = this; bVar != null && bVar.f19558b == d.B256 && i10 <= 250; bVar = bVar.f19561e) {
                i10++;
            }
            return i10;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0046 A[PHI: r11
          0x0046: PHI (r11v7 int) = (r11v4 int), (r11v4 int), (r11v4 int), (r11v10 int), (r11v10 int), (r11v18 int) binds: [B:77:0x00c2, B:79:0x00c6, B:81:0x00ca, B:58:0x0091, B:60:0x0095, B:26:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:34:0x0056 A[PHI: r11
          0x0056: PHI (r11v12 int) = (r11v10 int), (r11v10 int), (r11v10 int), (r11v18 int), (r11v18 int), (r11v18 int) binds: [B:64:0x009c, B:66:0x00a0, B:67:0x00a2, B:29:0x004c, B:31:0x0050, B:33:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
        private b(c cVar, d dVar, int i10, int i11, b bVar) {
            this.f19557a = cVar;
            this.f19558b = dVar;
            this.f19559c = i10;
            this.f19560d = i11;
            this.f19561e = bVar;
            int iJ = bVar != null ? bVar.f19562f : 0;
            d dVarT = t();
            int iOrdinal = dVar.ordinal();
            if (iOrdinal == 0) {
                iJ = (cVar.b(i10) || k.k(cVar.charAt(i10), cVar.f())) ? iJ + 2 : iJ + 1;
                if (dVarT == d.C40 || dVarT == d.TEXT || dVarT == d.X12) {
                    iJ++;
                }
            } else if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                d dVar2 = d.X12;
                if (dVar == dVar2) {
                    iJ += 2;
                } else {
                    iJ += k.j(cVar, i10, dVar == d.C40, new int[1]) * 2;
                }
                if (dVarT == d.ASCII || dVarT == d.B256) {
                    iJ++;
                } else if (dVarT != dVar && (dVarT == d.C40 || dVarT == d.TEXT || dVarT == dVar2)) {
                    iJ += 2;
                }
            } else if (iOrdinal == 4) {
                iJ = (dVarT == d.ASCII || dVarT == d.B256) ? iJ + 4 : (dVarT == d.C40 || dVarT == d.TEXT || dVarT == d.X12) ? iJ + 5 : iJ + 3;
            } else if (iOrdinal == 5) {
                iJ = (dVarT == d.B256 && g() != 250) ? iJ + 1 : iJ + 2;
                if (dVarT == d.ASCII) {
                    iJ++;
                } else if (dVarT == d.C40 || dVarT == d.TEXT || dVarT == d.X12) {
                    iJ += 2;
                }
            }
            this.f19562f = iJ;
        }

        private static int j(boolean z10, int i10, char c10, int i11) {
            if (c10 == i11) {
                return 27;
            }
            if (z10) {
                if (c10 <= 31) {
                    return c10;
                }
                if (c10 == ' ') {
                    return 3;
                }
                if (c10 <= '/') {
                    return c10 - '!';
                }
                if (c10 <= '9') {
                    return c10 - ',';
                }
                if (c10 <= '@') {
                    return c10 - '+';
                }
                if (c10 <= 'Z') {
                    return c10 - '3';
                }
                if (c10 <= '_') {
                    return c10 - 'E';
                }
                return c10 <= 127 ? c10 - '`' : c10;
            }
            if (c10 == 0) {
                return 0;
            }
            if (i10 == 0 && c10 <= 3) {
                return c10 - 1;
            }
            if (i10 == 1 && c10 <= 31) {
                return c10;
            }
            if (c10 == ' ') {
                return 3;
            }
            if (c10 >= '!' && c10 <= '/') {
                return c10 - '!';
            }
            if (c10 >= '0' && c10 <= '9') {
                return c10 - ',';
            }
            if (c10 >= ':' && c10 <= '@') {
                return c10 - '+';
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                return c10 - '@';
            }
            if (c10 >= '[' && c10 <= '_') {
                return c10 - 'E';
            }
            if (c10 == '`') {
                return 0;
            }
            if (c10 < 'a' || c10 > 'z') {
                return (c10 < '{' || c10 > 127) ? c10 : c10 - '`';
            }
            return c10 - 'S';
        }

        static int v(char c10, boolean z10, int i10) {
            if (z10 && k.l(c10)) {
                return 0;
            }
            if (!z10 && k.n(c10)) {
                return 0;
            }
            if (z10 && k.m(c10, i10)) {
                return 1;
            }
            return (z10 || !k.o(c10, i10)) ? 2 : 1;
        }

        private static int w(char c10) {
            if (c10 == '\r') {
                return 0;
            }
            if (c10 == '*') {
                return 1;
            }
            if (c10 == '>') {
                return 2;
            }
            if (c10 == ' ') {
                return 3;
            }
            if (c10 < '0' || c10 > '9') {
                return (c10 < 'A' || c10 > 'Z') ? c10 : c10 - '3';
            }
            return c10 - ',';
        }

        static void y(byte[] bArr, int i10, int i11, int i12, int i13) {
            int i14 = ((i11 & 255) * 1600) + ((i12 & 255) * 40) + (i13 & 255) + 1;
            bArr[i10] = (byte) (i14 / 256);
            bArr[i10 + 1] = (byte) (i14 % 256);
        }

        byte[] k(boolean z10, int i10) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f19560d; i11++) {
                char cCharAt = this.f19557a.charAt(this.f19559c + i11);
                if ((z10 && j.h(cCharAt)) || (!z10 && j.j(cCharAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z10, 0, cCharAt, i10)));
                } else if (k.k(cCharAt, i10)) {
                    char c10 = (char) ((cCharAt & 255) - 128);
                    if (!(z10 && j.h(c10)) && (z10 || !j.j(c10))) {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        int iV = v(c10, z10, i10);
                        arrayList.add(Byte.valueOf((byte) iV));
                        arrayList.add(Byte.valueOf((byte) j(z10, iV, c10, i10)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        arrayList.add(Byte.valueOf((byte) j(z10, 0, c10, i10)));
                    }
                } else {
                    int iV2 = v(cCharAt, z10, i10);
                    arrayList.add(Byte.valueOf((byte) iV2));
                    arrayList.add(Byte.valueOf((byte) j(z10, iV2, cCharAt, i10)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i12 = 0;
            for (int i13 = 0; i13 < arrayList.size(); i13 += 3) {
                y(bArr, i12, ((Byte) arrayList.get(i13)).byteValue() & 255, ((Byte) arrayList.get(i13 + 1)).byteValue() & 255, ((Byte) arrayList.get(i13 + 2)).byteValue() & 255);
                i12 += 2;
            }
            return bArr;
        }

        byte[] m() {
            int iOrdinal = this.f19558b.ordinal();
            if (iOrdinal == 0) {
                if (this.f19557a.b(this.f19559c)) {
                    return i(241, this.f19557a.a(this.f19559c) + 1);
                }
                if (k.k(this.f19557a.charAt(this.f19559c), this.f19557a.f())) {
                    return i(235, this.f19557a.charAt(this.f19559c) - 127);
                }
                if (this.f19560d == 2) {
                    return h(((this.f19557a.charAt(this.f19559c) - '0') * 10) + this.f19557a.charAt(this.f19559c + 1) + 82);
                }
                return this.f19557a.h(this.f19559c) ? h(232) : h(this.f19557a.charAt(this.f19559c) + 1);
            }
            if (iOrdinal == 1) {
                return k(true, this.f19557a.f());
            }
            if (iOrdinal == 2) {
                return k(false, this.f19557a.f());
            }
            if (iOrdinal == 3) {
                return x();
            }
            if (iOrdinal != 4) {
                return iOrdinal != 5 ? new byte[0] : h(this.f19557a.charAt(this.f19559c));
            }
            return n();
        }

        byte[] n() {
            int iCeil = (int) Math.ceil(((double) this.f19560d) / 4.0d);
            byte[] bArr = new byte[iCeil * 3];
            int i10 = this.f19559c;
            int iMin = Math.min((this.f19560d + i10) - 1, this.f19557a.length() - 1);
            for (int i11 = 0; i11 < iCeil; i11 += 3) {
                int[] iArr = new int[4];
                for (int i12 = 0; i12 < 4; i12++) {
                    if (i10 <= iMin) {
                        iArr[i12] = this.f19557a.charAt(i10) & '?';
                        i10++;
                    } else {
                        iArr[i12] = i10 == iMin + 1 ? 31 : 0;
                    }
                }
                int i13 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i11] = (byte) ((i13 >> 16) & 255);
                bArr[i11 + 1] = (byte) ((i13 >> 8) & 255);
                bArr[i11 + 2] = (byte) (i13 & 255);
            }
            return bArr;
        }

        d o() {
            if (this.f19558b == d.EDF) {
                if (this.f19560d < 4) {
                    return d.ASCII;
                }
                int iP = p();
                if (iP > 0 && l(this.f19562f + iP) <= 2 - iP) {
                    return d.ASCII;
                }
            }
            d dVar = this.f19558b;
            if (dVar == d.C40 || dVar == d.TEXT || dVar == d.X12) {
                if (this.f19559c + this.f19560d >= this.f19557a.length() && l(this.f19562f) == 0) {
                    return d.ASCII;
                }
                if (p() == 1 && l(this.f19562f + 1) == 0) {
                    return d.ASCII;
                }
            }
            return this.f19558b;
        }

        int p() {
            int length = this.f19557a.length();
            int i10 = this.f19559c + this.f19560d;
            int i11 = length - i10;
            if (i11 <= 4 && i10 < length) {
                if (i11 == 1) {
                    return k.k(this.f19557a.charAt(i10), this.f19557a.f()) ? 0 : 1;
                }
                if (i11 == 2) {
                    if (!k.k(this.f19557a.charAt(i10), this.f19557a.f())) {
                        int i12 = i10 + 1;
                        if (!k.k(this.f19557a.charAt(i12), this.f19557a.f())) {
                            return (j.f(this.f19557a.charAt(i10)) && j.f(this.f19557a.charAt(i12))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i11 == 3) {
                    if (j.f(this.f19557a.charAt(i10)) && j.f(this.f19557a.charAt(i10 + 1)) && !k.k(this.f19557a.charAt(i10 + 2), this.f19557a.f())) {
                        return 2;
                    }
                    return (j.f(this.f19557a.charAt(i10 + 1)) && j.f(this.f19557a.charAt(i10 + 2)) && !k.k(this.f19557a.charAt(i10), this.f19557a.f())) ? 2 : 0;
                }
                if (j.f(this.f19557a.charAt(i10)) && j.f(this.f19557a.charAt(i10 + 1)) && j.f(this.f19557a.charAt(i10 + 2)) && j.f(this.f19557a.charAt(i10 + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        int r(int i10) {
            int i11 = a.f19553a[this.f19557a.l().ordinal()];
            if (i11 == 1) {
                for (int i12 : f19555h) {
                    if (i12 >= i10) {
                        return i12;
                    }
                }
            } else if (i11 == 2) {
                for (int i13 : f19556i) {
                    if (i13 >= i10) {
                        return i13;
                    }
                }
            }
            for (int i14 : f19554g) {
                if (i14 >= i10) {
                    return i14;
                }
            }
            int[] iArr = f19554g;
            return iArr[iArr.length - 1];
        }

        d s() {
            return this.f19558b;
        }

        d t() {
            b bVar = this.f19561e;
            return bVar == null ? d.ASCII : bVar.o();
        }

        d u() {
            b bVar = this.f19561e;
            return bVar == null ? d.ASCII : bVar.f19558b;
        }

        byte[] x() {
            int i10 = (this.f19560d / 3) * 2;
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                int i12 = (i11 / 2) * 3;
                y(bArr, i11, w(this.f19557a.charAt(this.f19559c + i12)), w(this.f19557a.charAt(this.f19559c + i12 + 1)), w(this.f19557a.charAt(this.f19559c + i12 + 2)));
            }
            return bArr;
        }

        int l(int i10) {
            return r(i10) - i10;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x005f  */
        /* JADX WARN: Code duplicated, block: B:34:0x0067 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:35:0x0069 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:36:0x006b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:37:0x006d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0073  */
        /* JADX WARN: Code duplicated, block: B:42:0x0078  */
        /* JADX WARN: Code duplicated, block: B:44:0x007d  */
        /* JADX WARN: Code duplicated, block: B:46:0x0082  */
        /* JADX WARN: Code duplicated, block: B:48:0x0087  */
        byte[] q() {
            int iOrdinal;
            int iOrdinal2 = t().ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1 && iOrdinal2 != 2 && iOrdinal2 != 3) {
                    if (iOrdinal2 != 4 && iOrdinal2 == 5) {
                        iOrdinal = this.f19558b.ordinal();
                        if (iOrdinal != 1) {
                            if (iOrdinal != 2) {
                                if (iOrdinal != 3) {
                                    if (iOrdinal != 4) {
                                        if (iOrdinal == 5) {
                                            return h(231);
                                        }
                                    } else {
                                        return h(240);
                                    }
                                } else {
                                    return h(238);
                                }
                            } else {
                                return h(239);
                            }
                        } else {
                            return h(230);
                        }
                    }
                } else if (this.f19558b != t()) {
                    int iOrdinal3 = this.f19558b.ordinal();
                    if (iOrdinal3 != 0) {
                        if (iOrdinal3 != 1) {
                            if (iOrdinal3 != 2) {
                                if (iOrdinal3 != 3) {
                                    if (iOrdinal3 != 4) {
                                        if (iOrdinal3 == 5) {
                                            return i(254, 231);
                                        }
                                    } else {
                                        return i(254, 240);
                                    }
                                } else {
                                    return i(254, 238);
                                }
                            } else {
                                return i(254, 239);
                            }
                        } else {
                            return i(254, 230);
                        }
                    } else {
                        return h(254);
                    }
                }
            } else {
                iOrdinal = this.f19558b.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            if (iOrdinal != 4) {
                                if (iOrdinal == 5) {
                                    return h(231);
                                }
                            } else {
                                return h(240);
                            }
                        } else {
                            return h(238);
                        }
                    } else {
                        return h(239);
                    }
                } else {
                    return h(230);
                }
            }
            return new byte[0];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c extends p3.n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m f19563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f19564d;

        /* synthetic */ c(String str, Charset charset, int i10, m mVar, int i11, a aVar) {
            this(str, charset, i10, mVar, i11);
        }

        private c(String str, Charset charset, int i10, m mVar, int i11) {
            super(str, charset, i10);
            this.f19563c = mVar;
            this.f19564d = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int k() {
            return this.f19564d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public m l() {
            return this.f19563c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    enum d {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f19572a;

        static void a(List<Byte> list, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i10 + i12;
                int iByteValue = (list.get(i13).byteValue() & 255) + (((i13 + 1) * 149) % 255) + 1;
                if (iByteValue > 255) {
                    iByteValue += InputDeviceCompat.SOURCE_ANY;
                }
                list.set(i13, Byte.valueOf((byte) iByteValue));
            }
        }

        static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        private static int d(int i10) {
            int i11 = (i10 * 149) % 253;
            int i12 = i11 + 130;
            return i12 <= 254 ? i12 : i11 - 124;
        }

        public byte[] b() {
            return this.f19572a;
        }

        e(b bVar) {
            int iC;
            int i10;
            c cVar = bVar.f19557a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i11 = 0;
            if ((bVar.f19558b == d.C40 || bVar.f19558b == d.TEXT || bVar.f19558b == d.X12) && bVar.o() != d.ASCII) {
                iC = c(b.h(254), arrayList);
            } else {
                iC = 0;
            }
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f19561e) {
                iC += c(bVar2.m(), arrayList);
                if (bVar2.f19561e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == d.B256) {
                        if (iC <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) iC));
                            i10 = iC + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (iC % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)));
                            arrayList.add(0, Byte.valueOf((byte) ((iC / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249)));
                            i10 = iC + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i10));
                    }
                    c(bVar2.q(), arrayList);
                    iC = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.f() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i12)).intValue(), ((Integer) arrayList3.get(i12)).intValue());
            }
            int iR = bVar.r(arrayList.size());
            if (arrayList.size() < iR) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < iR) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f19572a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f19572a;
                if (i11 < bArr.length) {
                    bArr[i11] = ((Byte) arrayList.get(i11)).byteValue();
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    static int j(c cVar, int i10, boolean z10, int[] iArr) {
        int i11 = 0;
        for (int i12 = i10; i12 < cVar.length(); i12++) {
            if (cVar.b(i12)) {
                iArr[0] = 0;
                return 0;
            }
            char cCharAt = cVar.charAt(i12);
            if ((z10 && j.h(cCharAt)) || (!z10 && j.j(cCharAt))) {
                i11++;
            } else if (k(cCharAt, cVar.f())) {
                int i13 = cCharAt & 255;
                i11 = (i13 < 128 || (!(z10 && j.h((char) (i13 + (-128)))) && (z10 || !j.j((char) (i13 + (-128)))))) ? i11 + 4 : i11 + 3;
            } else {
                i11 += 2;
            }
            if (i11 % 3 == 0 || ((i11 - 2) % 3 == 0 && i12 + 1 == cVar.length())) {
                iArr[0] = (i12 - i10) + 1;
                return (int) Math.ceil(((double) i11) / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19553a;

        static {
            int[] iArr = new int[m.values().length];
            f19553a = iArr;
            try {
                iArr[m.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19553a[m.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static byte[] g(String str, Charset charset, int i10, m mVar, int i11) {
        return i(new c(str, charset, i10, mVar, i11, null)).b();
    }

    public static String h(String str, Charset charset, int i10, m mVar) {
        int i11;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i11 = 5;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i11 = 6;
        } else {
            i11 = 0;
        }
        return new String(g(str, charset, i10, mVar, i11), StandardCharsets.ISO_8859_1);
    }

    static boolean k(char c10, int i10) {
        return c10 != i10 && c10 >= 128 && c10 <= 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(char c10) {
        return c10 <= 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(char c10, int i10) {
        for (char c11 : f19552a) {
            if (c11 == c10) {
                return true;
            }
        }
        return c10 == i10;
    }

    static void e(b[][] bVarArr, b bVar) {
        int i10 = bVar.f19559c + bVar.f19560d;
        if (bVarArr[i10][bVar.o().ordinal()] != null && bVarArr[i10][bVar.o().ordinal()].f19562f <= bVar.f19562f) {
            return;
        }
        bVarArr[i10][bVar.o().ordinal()] = bVar;
    }

    static void f(c cVar, b[][] bVarArr, int i10, b bVar) {
        boolean z10;
        if (cVar.b(i10)) {
            e(bVarArr, new b(cVar, d.ASCII, i10, 1, bVar, null));
            return;
        }
        char cCharAt = cVar.charAt(i10);
        int i11 = 0;
        if (bVar == null || bVar.o() != d.EDF) {
            if (j.f(cCharAt) && cVar.g(i10, 2) && j.f(cVar.charAt(i10 + 1))) {
                e(bVarArr, new b(cVar, d.ASCII, i10, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, d.ASCII, i10, 1, bVar, null));
            }
            d[] dVarArr = {d.C40, d.TEXT};
            for (int i12 = 0; i12 < 2; i12++) {
                d dVar = dVarArr[i12];
                int[] iArr = new int[1];
                if (dVar == d.C40) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (j(cVar, i10, z10, iArr) > 0) {
                    e(bVarArr, new b(cVar, dVar, i10, iArr[0], bVar, null));
                }
            }
            if (cVar.g(i10, 3) && j.k(cVar.charAt(i10)) && j.k(cVar.charAt(i10 + 1)) && j.k(cVar.charAt(i10 + 2))) {
                e(bVarArr, new b(cVar, d.X12, i10, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, d.B256, i10, 1, bVar, null));
        }
        while (i11 < 3) {
            int i13 = i10 + i11;
            if (!cVar.g(i13, 1) || !j.i(cVar.charAt(i13))) {
                break;
            }
            int i14 = i11 + 1;
            e(bVarArr, new b(cVar, d.EDF, i10, i14, bVar, null));
            i11 = i14;
        }
        if (i11 == 3 && cVar.g(i10, 4) && j.i(cVar.charAt(i10 + 3))) {
            e(bVarArr, new b(cVar, d.EDF, i10, 4, bVar, null));
        }
    }

    static e i(c cVar) {
        int i10;
        int length = cVar.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        f(cVar, bVarArr, 0, null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < 6; i12++) {
                b bVar = bVarArr[i11][i12];
                if (bVar != null && i11 < length) {
                    f(cVar, bVarArr, i11, bVar);
                }
            }
            for (int i13 = 0; i13 < 6; i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < 6; i16++) {
            b bVar2 = bVarArr[length][i16];
            if (bVar2 != null) {
                if (i16 < 1 || i16 > 3) {
                    i10 = bVar2.f19562f;
                } else {
                    i10 = bVar2.f19562f + 1;
                }
                if (i10 < i15) {
                    i14 = i16;
                    i15 = i10;
                }
            }
        }
        if (i14 >= 0) {
            return new e(bVarArr[length][i14]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(char c10) {
        return l(c10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(char c10, int i10) {
        return m(c10, i10);
    }
}
