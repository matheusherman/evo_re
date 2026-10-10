package p3;

import androidx.core.view.InputDeviceCompat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f17309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17310b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f17311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f17313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f17314d;

        /* synthetic */ b(char c10, h hVar, int i10, b bVar, int i11, a aVar) {
            this(c10, hVar, i10, bVar, i11);
        }

        private b(char c10, h hVar, int i10, b bVar, int i11) {
            char c11 = c10 == i11 ? (char) 1000 : c10;
            this.f17311a = c11;
            this.f17312b = i10;
            this.f17313c = bVar;
            int length = c11 == 1000 ? 1 : hVar.b(c10, i10).length;
            length = (bVar == null ? 0 : bVar.f17312b) != i10 ? length + 3 : length;
            this.f17314d = bVar != null ? length + bVar.f17314d : length;
        }

        boolean e() {
            return this.f17311a == 1000;
        }
    }

    static void c(b[][] bVarArr, int i10, b bVar) {
        if (bVarArr[i10][bVar.f17312b] == null || bVarArr[i10][bVar.f17312b].f17314d > bVar.f17314d) {
            bVarArr[i10][bVar.f17312b] = bVar;
        }
    }

    @Override // p3.i
    public int a(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (b(i10)) {
            return this.f17309a[i10] + InputDeviceCompat.SOURCE_ANY;
        }
        throw new IllegalArgumentException("value at " + i10 + " is not an ECI but a character");
    }

    @Override // p3.i
    public boolean b(int i10) {
        if (i10 >= 0 && i10 < length()) {
            int i11 = this.f17309a[i10];
            return i11 > 255 && i11 <= 999;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // p3.i
    public char charAt(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (!b(i10)) {
            return (char) (h(i10) ? this.f17310b : this.f17309a[i10]);
        }
        throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
    }

    public int f() {
        return this.f17310b;
    }

    public boolean g(int i10, int i11) {
        if ((i10 + i11) - 1 >= this.f17309a.length) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (b(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i10) {
        if (i10 >= 0 && i10 < length()) {
            return this.f17309a[i10] == 1000;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // p3.i
    public int length() {
        return this.f17309a.length;
    }

    @Override // p3.i
    public CharSequence subSequence(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < i11) {
            if (b(i10)) {
                throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
            }
            sb2.append(charAt(i10));
            i10++;
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length(); i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (b(i10)) {
                sb2.append("ECI(");
                sb2.append(a(i10));
                sb2.append(')');
            } else if (charAt(i10) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i10));
                sb2.append('\'');
            } else {
                sb2.append((int) charAt(i10));
            }
        }
        return sb2.toString();
    }

    public n(String str, Charset charset, int i10) {
        this.f17310b = i10;
        h hVar = new h(str, charset, i10);
        if (hVar.g() == 1) {
            this.f17309a = new int[str.length()];
            for (int i11 = 0; i11 < this.f17309a.length; i11++) {
                char cCharAt = str.charAt(i11);
                int[] iArr = this.f17309a;
                if (cCharAt == i10) {
                    cCharAt = 1000;
                }
                iArr[i11] = cCharAt;
            }
            return;
        }
        this.f17309a = e(str, hVar, i10);
    }

    static void d(String str, h hVar, b[][] bVarArr, int i10, b bVar, int i11) {
        int i12;
        int iF;
        h hVar2;
        b bVar2;
        int i13;
        char cCharAt = str.charAt(i10);
        int iG = hVar.g();
        if (hVar.f() >= 0 && (cCharAt == i11 || hVar.a(cCharAt, hVar.f()))) {
            iF = hVar.f();
            i12 = iF + 1;
        } else {
            i12 = iG;
            iF = 0;
        }
        int i14 = iF;
        while (i14 < i12) {
            if (cCharAt != i11 && !hVar.a(cCharAt, i14)) {
                hVar2 = hVar;
                bVar2 = bVar;
                i13 = i11;
            } else {
                hVar2 = hVar;
                bVar2 = bVar;
                i13 = i11;
                c(bVarArr, i10 + 1, new b(cCharAt, hVar2, i14, bVar2, i13, null));
            }
            i14++;
            hVar = hVar2;
            bVar = bVar2;
            i11 = i13;
        }
    }

    static int[] e(String str, h hVar, int i10) {
        int i11;
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, hVar.g());
        d(str, hVar, bVarArr, 0, null, i10);
        for (int i12 = 1; i12 <= length; i12++) {
            for (int i13 = 0; i13 < hVar.g(); i13++) {
                b bVar = bVarArr[i12][i13];
                if (bVar != null && i12 < length) {
                    d(str, hVar, bVarArr, i12, bVar, i10);
                }
            }
            for (int i14 = 0; i14 < hVar.g(); i14++) {
                bVarArr[i12 - 1][i14] = null;
            }
        }
        int i15 = -1;
        int i16 = Integer.MAX_VALUE;
        for (int i17 = 0; i17 < hVar.g(); i17++) {
            b bVar2 = bVarArr[length][i17];
            if (bVar2 != null && bVar2.f17314d < i16) {
                i16 = bVar2.f17314d;
                i15 = i17;
            }
        }
        if (i15 >= 0) {
            ArrayList arrayList = new ArrayList();
            for (b bVar3 = bVarArr[length][i15]; bVar3 != null; bVar3 = bVar3.f17313c) {
                if (bVar3.e()) {
                    arrayList.add(0, 1000);
                } else {
                    byte[] bArrB = hVar.b(bVar3.f17311a, bVar3.f17312b);
                    for (int length2 = bArrB.length - 1; length2 >= 0; length2--) {
                        arrayList.add(0, Integer.valueOf(bArrB[length2] & 255));
                    }
                }
                if (bVar3.f17313c != null) {
                    i11 = bVar3.f17313c.f17312b;
                } else {
                    i11 = 0;
                }
                if (i11 != bVar3.f17312b) {
                    arrayList.add(0, Integer.valueOf(hVar.e(bVar3.f17312b) + 256));
                }
            }
            int size = arrayList.size();
            int[] iArr = new int[size];
            for (int i18 = 0; i18 < size; i18++) {
                iArr[i18] = ((Integer) arrayList.get(i18)).intValue();
            }
            return iArr;
        }
        throw new IllegalStateException("Failed to encode \"" + str + "\"");
    }
}
