package hd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class i extends k {
    @Override // hd.k
    protected short c(short s10, short s11) {
        int i10 = (s11 & 1) * s10;
        int i11 = 1;
        while (true) {
            int i12 = this.f10993a;
            if (i11 >= i12) {
                int i13 = 8372224 & i10;
                int i14 = (i13 >> 12) ^ ((i13 >> 9) ^ i10);
                int i15 = i14 & 12288;
                return (short) (((i14 ^ (i15 >> 9)) ^ (i15 >> 12)) & ((1 << i12) - 1));
            }
            i10 ^= ((1 << i11) & s11) * s10;
            i11++;
        }
    }

    public i(int i10) {
        super(i10);
    }

    @Override // hd.k
    protected short b(short s10) {
        short sC = c(d(s10), s10);
        short sC2 = c(d(d(sC)), sC);
        return d(c(d(c(d(d(c(d(d(d(d(sC2)))), sC2))), sC)), s10));
    }

    protected short d(short s10) {
        int[] iArr = {1431655765, 858993459, 252645135, 16711935};
        int i10 = (s10 | (s10 << 8)) & iArr[3];
        int i11 = (i10 | (i10 << 4)) & iArr[2];
        int i12 = (i11 | (i11 << 2)) & iArr[1];
        int i13 = (i12 | (i12 << 1)) & iArr[0];
        int i14 = 8372224 & i13;
        int i15 = (i13 ^ (i14 >> 9)) ^ (i14 >> 12);
        int i16 = i15 & 12288;
        return (short) (((i15 ^ (i16 >> 9)) ^ (i16 >> 12)) & ((1 << this.f10993a) - 1));
    }
}
