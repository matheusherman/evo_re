package g4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10474b = 0;

    void a(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f10474b;
            this.f10474b = i12 + 1;
            c(i12, z10);
        }
    }

    private void c(int i10, boolean z10) {
        this.f10473a[i10] = z10 ? (byte) 1 : (byte) 0;
    }

    byte[] b(int i10) {
        int length = this.f10473a.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.f10473a[i11 / i10];
        }
        return bArr;
    }

    b(int i10) {
        this.f10473a = new byte[i10];
    }
}
