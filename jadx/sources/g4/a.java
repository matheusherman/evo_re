package g4;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f10469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10472d;

    b a() {
        return this.f10469a[this.f10470b];
    }

    public byte[][] b(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f10471c * i11, this.f10472d * i10);
        int i12 = this.f10471c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f10469a[i13 / i11].b(i10);
        }
        return bArr;
    }

    void c() {
        this.f10470b++;
    }

    a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f10469a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f10469a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f10472d = i11 * 17;
        this.f10471c = i10;
        this.f10470b = -1;
    }
}
