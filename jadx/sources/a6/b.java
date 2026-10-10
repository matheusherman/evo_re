package a6;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f132c;

    public void a(byte b10) {
        for (int i10 = 0; i10 < this.f132c; i10++) {
            for (int i11 = 0; i11 < this.f131b; i11++) {
                this.f130a[i10][i11] = b10;
            }
        }
    }

    public byte b(int i10, int i11) {
        return this.f130a[i11][i10];
    }

    public byte[][] c() {
        return this.f130a;
    }

    public int d() {
        return this.f132c;
    }

    public int e() {
        return this.f131b;
    }

    public void f(int i10, int i11, int i12) {
        this.f130a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f130a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f131b * 2 * this.f132c) + 2);
        for (int i10 = 0; i10 < this.f132c; i10++) {
            for (int i11 = 0; i11 < this.f131b; i11++) {
                byte b10 = this.f130a[i10][i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append(10);
        }
        return sb2.toString();
    }

    public b(int i10, int i11) {
        this.f130a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f131b = i10;
        this.f132c = i11;
    }
}
