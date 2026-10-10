package l3;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final f f15194f = new f(g.f15200b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f15196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15199e;

    f b(int i10) {
        g gVarA;
        g gVar = j(4, 0).f15196b;
        int length = 3;
        if (i10 < 0) {
            gVarA = gVar.a(0, 3);
        } else {
            if (i10 > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i10).getBytes(StandardCharsets.ISO_8859_1);
            g gVarA2 = gVar.a(bytes.length, 3);
            for (byte b10 : bytes) {
                gVarA2 = gVarA2.a(b10 - 46, 4);
            }
            length = 3 + (bytes.length * 4);
            gVarA = gVarA2;
        }
        return new f(gVarA, this.f15195a, 0, this.f15198d + length);
    }

    private static int c(int i10) {
        if (i10 > 62) {
            return 21;
        }
        if (i10 > 31) {
            return 20;
        }
        return i10 > 0 ? 10 : 0;
    }

    f a(int i10) {
        int i11;
        g gVarA = this.f15196b;
        int i12 = this.f15195a;
        int i13 = this.f15198d;
        if (i12 == 4 || i12 == 2) {
            int i14 = d.f15186d[i12][0];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVarA = gVarA.a(i15, i16);
            i13 += i16;
            i12 = 0;
        }
        int i17 = this.f15197c;
        if (i17 == 0 || i17 == 31) {
            i11 = 18;
        } else {
            i11 = i17 == 62 ? 9 : 8;
        }
        f fVar = new f(gVarA, i12, i17 + 1, i13 + i11);
        return fVar.f15197c == 2078 ? fVar.d(i10 + 1) : fVar;
    }

    f d(int i10) {
        int i11 = this.f15197c;
        return i11 == 0 ? this : new f(this.f15196b.b(i10 - i11, i11), this.f15195a, 0, this.f15198d);
    }

    int e() {
        return this.f15197c;
    }

    int f() {
        return this.f15198d;
    }

    int g() {
        return this.f15195a;
    }

    boolean h(f fVar) {
        int i10 = this.f15198d + (d.f15186d[this.f15195a][fVar.f15195a] >> 16);
        int i11 = this.f15197c;
        int i12 = fVar.f15197c;
        if (i11 < i12) {
            i10 += fVar.f15199e - this.f15199e;
        } else if (i11 > i12 && i12 > 0) {
            i10 += 10;
        }
        return i10 <= fVar.f15198d;
    }

    f i(int i10, int i11) {
        int i12 = this.f15198d;
        g gVarA = this.f15196b;
        int i13 = this.f15195a;
        if (i10 != i13) {
            int i14 = d.f15186d[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVarA = gVarA.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new f(gVarA.a(i11, i17), i10, 0, i12 + i17);
    }

    f j(int i10, int i11) {
        g gVar = this.f15196b;
        int i12 = this.f15195a;
        int i13 = i12 == 2 ? 4 : 5;
        return new f(gVar.a(d.f15188f[i12][i10], i13).a(i11, 5), this.f15195a, 0, this.f15198d + i13 + 5);
    }

    p3.a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (g gVarD = d(bArr.length).f15196b; gVarD != null; gVarD = gVarD.d()) {
            arrayList.add(gVarD);
        }
        p3.a aVar = new p3.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((g) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f15185c[this.f15195a], Integer.valueOf(this.f15198d), Integer.valueOf(this.f15197c));
    }

    private f(g gVar, int i10, int i11, int i12) {
        this.f15196b = gVar;
        this.f15195a = i10;
        this.f15197c = i11;
        this.f15198d = i12;
        this.f15199e = c(i11);
    }
}
