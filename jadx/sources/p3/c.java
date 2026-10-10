package p3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f17256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17258c;

    public int d(int i10) {
        if (i10 < 1 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f17258c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int iMin = Math.min(i10, i13);
            int i14 = i13 - iMin;
            byte[] bArr = this.f17256a;
            int i15 = this.f17257b;
            int i16 = (((255 >> (8 - iMin)) << i14) & bArr[i15]) >> i14;
            i10 -= iMin;
            int i17 = this.f17258c + iMin;
            this.f17258c = i17;
            if (i17 == 8) {
                this.f17258c = 0;
                this.f17257b = i15 + 1;
            }
            i12 = i16;
        }
        if (i10 > 0) {
            while (i10 >= 8) {
                int i18 = i12 << 8;
                byte[] bArr2 = this.f17256a;
                int i19 = this.f17257b;
                i12 = (bArr2[i19] & 255) | i18;
                this.f17257b = i19 + 1;
                i10 -= 8;
            }
            if (i10 > 0) {
                int i20 = 8 - i10;
                int i21 = ((((255 >> i20) << i20) & this.f17256a[this.f17257b]) >> i20) | (i12 << i10);
                this.f17258c += i10;
                return i21;
            }
        }
        return i12;
    }

    public int a() {
        return ((this.f17256a.length - this.f17257b) * 8) - this.f17258c;
    }

    public int b() {
        return this.f17258c;
    }

    public int c() {
        return this.f17257b;
    }

    public c(byte[] bArr) {
        this.f17256a = bArr;
    }
}
