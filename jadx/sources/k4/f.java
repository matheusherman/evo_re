package k4;

import h3.v;
import i4.j;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p3.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f12140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i4.f f12141d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i4.h f12143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f12145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f12146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b f12147e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f12148f;

        /* synthetic */ b(f fVar, i4.h hVar, int i10, int i11, int i12, b bVar, j jVar, a aVar) {
            this(hVar, i10, i11, i12, bVar, jVar);
        }

        private b(i4.h hVar, int i10, int i11, int i12, b bVar, j jVar) {
            this.f12143a = hVar;
            this.f12144b = i10;
            i4.h hVar2 = i4.h.BYTE;
            int i13 = (hVar == hVar2 || bVar == null) ? i11 : bVar.f12145c;
            this.f12145c = i13;
            this.f12146d = i12;
            this.f12147e = bVar;
            boolean z10 = false;
            int iJ = bVar != null ? bVar.f12148f : 0;
            if ((hVar == hVar2 && bVar == null && i13 != 0) || (bVar != null && i13 != bVar.f12145c)) {
                z10 = true;
            }
            iJ = (bVar == null || hVar != bVar.f12143a || z10) ? iJ + hVar.j(jVar) + 4 : iJ;
            int i14 = a.f12142a[hVar.ordinal()];
            if (i14 == 1) {
                iJ += 13;
            } else if (i14 == 2) {
                iJ += i12 == 1 ? 6 : 11;
            } else if (i14 == 3) {
                iJ += i12 != 1 ? i12 == 2 ? 7 : 10 : 4;
            } else if (i14 == 4) {
                iJ += f.this.f12140c.c(f.this.f12138a.substring(i10, i12 + i10), i11).length * 8;
                if (z10) {
                    iJ += 12;
                }
            }
            this.f12148f = iJ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<a> f12150a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f12151b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final i4.h f12153a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f12154b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f12155c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f12156d;

            a(i4.h hVar, int i10, int i11, int i12) {
                this.f12153a = hVar;
                this.f12154b = i10;
                this.f12155c = i11;
                this.f12156d = i12;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void d(p3.a aVar) {
                aVar.d(this.f12153a.i(), 4);
                if (this.f12156d > 0) {
                    aVar.d(e(), this.f12153a.j(c.this.f12151b));
                }
                if (this.f12153a == i4.h.ECI) {
                    aVar.d(f.this.f12140c.e(this.f12155c), 8);
                } else if (this.f12156d > 0) {
                    String str = f.this.f12138a;
                    int i10 = this.f12154b;
                    k4.c.c(str.substring(i10, this.f12156d + i10), this.f12153a, aVar, f.this.f12140c.d(this.f12155c));
                }
            }

            private int e() {
                if (this.f12153a != i4.h.BYTE) {
                    return this.f12156d;
                }
                h hVar = f.this.f12140c;
                String str = f.this.f12138a;
                int i10 = this.f12154b;
                return hVar.c(str.substring(i10, this.f12156d + i10), this.f12155c).length;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int f(j jVar) {
                int iE;
                int iJ = this.f12153a.j(jVar);
                int i10 = iJ + 4;
                int i11 = a.f12142a[this.f12153a.ordinal()];
                if (i11 != 1) {
                    int i12 = 0;
                    if (i11 == 2) {
                        int i13 = this.f12156d;
                        return i10 + ((i13 / 2) * 11) + (i13 % 2 == 1 ? 6 : 0);
                    }
                    if (i11 == 3) {
                        int i14 = this.f12156d;
                        int i15 = i10 + ((i14 / 3) * 10);
                        int i16 = i14 % 3;
                        if (i16 == 1) {
                            i12 = 4;
                        } else if (i16 == 2) {
                            i12 = 7;
                        }
                        return i15 + i12;
                    }
                    if (i11 != 4) {
                        return i11 != 5 ? i10 : iJ + 12;
                    }
                    iE = e() * 8;
                } else {
                    iE = this.f12156d * 13;
                }
                return i10 + iE;
            }

            private String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < str.length(); i10++) {
                    if (str.charAt(i10) < ' ' || str.charAt(i10) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i10));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f12153a);
                sb2.append('(');
                if (this.f12153a == i4.h.ECI) {
                    sb2.append(f.this.f12140c.d(this.f12155c).displayName());
                } else {
                    String str = f.this.f12138a;
                    int i10 = this.f12154b;
                    sb2.append(g(str.substring(i10, this.f12156d + i10)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        c(j jVar, b bVar) {
            int i10;
            int i11;
            int i12;
            b bVar2 = bVar;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                i10 = 1;
                if (bVar2 == null) {
                    break;
                }
                int i15 = i13 + bVar2.f12146d;
                b bVar3 = bVar2.f12147e;
                boolean z10 = (bVar2.f12143a == i4.h.BYTE && bVar3 == null && bVar2.f12145c != 0) || !(bVar3 == null || bVar2.f12145c == bVar3.f12145c);
                i10 = z10 ? 1 : i14;
                if (bVar3 == null || bVar3.f12143a != bVar2.f12143a || z10) {
                    this.f12150a.add(0, new a(bVar2.f12143a, bVar2.f12144b, bVar2.f12145c, i15));
                    i12 = 0;
                } else {
                    i12 = i15;
                }
                if (z10) {
                    this.f12150a.add(0, new a(i4.h.ECI, bVar2.f12144b, bVar2.f12145c, 0));
                }
                i14 = i10;
                bVar2 = bVar3;
                i13 = i12;
            }
            if (f.this.f12139b) {
                a aVar = this.f12150a.get(0);
                if (aVar != null) {
                    i4.h hVar = aVar.f12153a;
                    int i16 = i14;
                    i4.h hVar2 = i4.h.ECI;
                    if (hVar != hVar2 && i16 != 0) {
                        this.f12150a.add(0, new a(hVar2, 0, 0, 0));
                    }
                }
                this.f12150a.add(this.f12150a.get(0).f12153a == i4.h.ECI ? 1 : 0, new a(i4.h.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iJ = jVar.j();
            int iOrdinal = f.m(jVar).ordinal();
            if (iOrdinal == 0) {
                i11 = 9;
            } else if (iOrdinal != 1) {
                i10 = 27;
                i11 = 40;
            } else {
                i10 = 10;
                i11 = 26;
            }
            int iD = d(jVar);
            while (iJ < i11 && !k4.c.v(iD, j.i(iJ), f.this.f12141d)) {
                iJ++;
            }
            while (iJ > i10 && k4.c.v(iD, j.i(iJ - 1), f.this.f12141d)) {
                iJ--;
            }
            this.f12151b = j.i(iJ);
        }

        private int d(j jVar) {
            Iterator<a> it = this.f12150a.iterator();
            int iF = 0;
            while (it.hasNext()) {
                iF += it.next().f(jVar);
            }
            return iF;
        }

        void b(p3.a aVar) {
            Iterator<a> it = this.f12150a.iterator();
            while (it.hasNext()) {
                it.next().d(aVar);
            }
        }

        int c() {
            return d(this.f12151b);
        }

        j e() {
            return this.f12151b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f12150a) {
                if (aVar != null) {
                    sb2.append(",");
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum d {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }

        d(String str) {
            this.description = str;
        }
    }

    static int k(i4.h hVar) {
        int i10;
        if (hVar == null || (i10 = a.f12142a[hVar.ordinal()]) == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + hVar);
    }

    void f(j jVar, b[][][] bVarArr, int i10, b bVar) {
        int i11;
        int iG = this.f12140c.g();
        int iF = this.f12140c.f();
        if (iF < 0 || !this.f12140c.a(this.f12138a.charAt(i10), iF)) {
            iF = 0;
        } else {
            iG = iF + 1;
        }
        int i12 = iG;
        for (int i13 = iF; i13 < i12; i13++) {
            if (this.f12140c.a(this.f12138a.charAt(i10), i13)) {
                e(bVarArr, i10, new b(this, i4.h.BYTE, i10, i13, 1, bVar, jVar, null));
            }
        }
        i4.h hVar = i4.h.KANJI;
        if (g(hVar, this.f12138a.charAt(i10))) {
            e(bVarArr, i10, new b(this, hVar, i10, 0, 1, bVar, jVar, null));
        }
        int length = this.f12138a.length();
        i4.h hVar2 = i4.h.ALPHANUMERIC;
        if (g(hVar2, this.f12138a.charAt(i10))) {
            int i14 = i10 + 1;
            e(bVarArr, i10, new b(this, hVar2, i10, 0, (i14 >= length || !g(hVar2, this.f12138a.charAt(i14))) ? 1 : 2, bVar, jVar, null));
        }
        i4.h hVar3 = i4.h.NUMERIC;
        if (g(hVar3, this.f12138a.charAt(i10))) {
            int i15 = i10 + 1;
            if (i15 >= length || !g(hVar3, this.f12138a.charAt(i15))) {
                i11 = 1;
            } else {
                int i16 = i10 + 2;
                i11 = (i16 >= length || !g(hVar3, this.f12138a.charAt(i16))) ? 2 : 3;
            }
            e(bVarArr, i10, new b(this, hVar3, i10, 0, i11, bVar, jVar, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12142a;

        static {
            int[] iArr = new int[i4.h.values().length];
            f12142a = iArr;
            try {
                iArr[i4.h.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12142a[i4.h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12142a[i4.h.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12142a[i4.h.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12142a[i4.h.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static c i(String str, j jVar, Charset charset, boolean z10, i4.f fVar) {
        return new f(str, charset, z10, fVar).h(jVar);
    }

    static boolean p(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    boolean g(i4.h hVar, char c10) {
        int i10 = a.f12142a[hVar.ordinal()];
        if (i10 == 1) {
            return o(c10);
        }
        if (i10 == 2) {
            return n(c10);
        }
        if (i10 != 3) {
            return i10 == 4;
        }
        return p(c10);
    }

    c h(j jVar) throws v {
        if (jVar != null) {
            c cVarJ = j(jVar);
            if (k4.c.v(cVarJ.c(), l(m(cVarJ.e())), this.f12141d)) {
                return cVarJ;
            }
            throw new v("Data too big for version" + jVar);
        }
        j[] jVarArr = {l(d.SMALL), l(d.MEDIUM), l(d.LARGE)};
        c[] cVarArr = {j(jVarArr[0]), j(jVarArr[1]), j(jVarArr[2])};
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 3; i12++) {
            int iC = cVarArr[i12].c();
            if (k4.c.v(iC, jVarArr[i12], this.f12141d) && iC < i10) {
                i10 = iC;
                i11 = i12;
            }
        }
        if (i11 >= 0) {
            return cVarArr[i11];
        }
        throw new v("Data too big for any version");
    }

    c j(j jVar) throws v {
        int length = this.f12138a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f12140c.g(), 4);
        f(jVar, bVarArr, 0, null);
        for (int i10 = 1; i10 <= length; i10++) {
            for (int i11 = 0; i11 < this.f12140c.g(); i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    b bVar = bVarArr[i10][i11][i12];
                    if (bVar != null && i10 < length) {
                        f(jVar, bVarArr, i10, bVar);
                    }
                }
            }
        }
        int i13 = -1;
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < this.f12140c.g(); i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                b bVar2 = bVarArr[length][i16][i17];
                if (bVar2 != null && bVar2.f12148f < i15) {
                    i15 = bVar2.f12148f;
                    i13 = i16;
                    i14 = i17;
                }
            }
        }
        if (i13 >= 0) {
            return new c(jVar, bVarArr[length][i13][i14]);
        }
        throw new v("Internal error: failed to encode \"" + this.f12138a + "\"");
    }

    f(String str, Charset charset, boolean z10, i4.f fVar) {
        this.f12138a = str;
        this.f12139b = z10;
        this.f12140c = new h(str, charset, -1);
        this.f12141d = fVar;
    }

    static j l(d dVar) {
        int iOrdinal = dVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return j.i(40);
            }
            return j.i(26);
        }
        return j.i(9);
    }

    static d m(j jVar) {
        if (jVar.j() <= 9) {
            return d.SMALL;
        }
        if (jVar.j() <= 26) {
            return d.MEDIUM;
        }
        return d.LARGE;
    }

    static boolean n(char c10) {
        if (k4.c.p(c10) != -1) {
            return true;
        }
        return false;
    }

    static boolean o(char c10) {
        return k4.c.s(String.valueOf(c10));
    }

    void e(b[][][] bVarArr, int i10, b bVar) {
        b[] bVarArr2 = bVarArr[i10 + bVar.f12146d][bVar.f12145c];
        int iK = k(bVar.f12143a);
        b bVar2 = bVarArr2[iK];
        if (bVar2 != null && bVar2.f12148f <= bVar.f12148f) {
            return;
        }
        bVarArr2[iK] = bVar;
    }
}
