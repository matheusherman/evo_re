package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f10810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f10814g;

    private void h(int i10, int i11) {
        byte[] bArr = this.f10810c;
        int i12 = (this.f10814g * this.f10811d) + this.f10813f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f10811d;
        }
    }

    @Override // h3.j
    public byte[] c(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f10810c, ((i10 + this.f10814g) * this.f10811d) + this.f10813f, bArr, 0, iD);
        return bArr;
    }

    public n(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 <= i10 && i13 + i15 <= i11) {
            this.f10810c = bArr;
            this.f10811d = i10;
            this.f10812e = i11;
            this.f10813f = i12;
            this.f10814g = i13;
            if (z10) {
                h(i14, i15);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // h3.j
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i10 = this.f10811d;
        if (iD == i10 && iA == this.f10812e) {
            return this.f10810c;
        }
        int i11 = iD * iA;
        byte[] bArr = new byte[i11];
        int i12 = (this.f10814g * i10) + this.f10813f;
        if (iD == i10) {
            System.arraycopy(this.f10810c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iA; i13++) {
            System.arraycopy(this.f10810c, i12, bArr, i13 * iD, iD);
            i12 += this.f10811d;
        }
        return bArr;
    }
}
