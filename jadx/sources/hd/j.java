package hd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class j extends k {
    private short f(short s10, short s11) {
        long[] jArr = {2301339409586323456L, 4494803534348288L, 8778913153024L, 17146314752L, 33423360, 122880};
        long j10 = s10;
        long j11 = s11;
        long j12 = (j11 << 18) * (64 & j10);
        long j13 = j10 ^ (j10 << 21);
        long j14 = ((j11 * (j13 & 8589934624L)) << 15) ^ (((((j12 ^ ((268435457 & j13) * j11)) ^ (((536870914 & j13) * j11) << 3)) ^ (((1073741828 & j13) * j11) << 6)) ^ (((2147483656L & j13) * j11) << 9)) ^ (((4294967312L & j13) * j11) << 12));
        for (int i10 = 0; i10 < 6; i10++) {
            long j15 = jArr[i10] & j14;
            j14 ^= (j15 >> 13) ^ (((j15 >> 9) ^ (j15 >> 10)) ^ (j15 >> 12));
        }
        return (short) (j14 & ((long) this.f10994b));
    }

    private short g(short s10, short s11) {
        long[] jArr = {137170518016L, 267911168, 516096};
        long j10 = s10;
        long j11 = s11;
        long j12 = (j11 << 6) * (64 & j10);
        long j13 = j10 ^ (j10 << 7);
        long j14 = ((j11 * (j13 & 524320)) << 5) ^ (((((j12 ^ ((16385 & j13) * j11)) ^ (((32770 & j13) * j11) << 1)) ^ (((65540 & j13) * j11) << 2)) ^ (((131080 & j13) * j11) << 3)) ^ (((262160 & j13) * j11) << 4));
        for (int i10 = 0; i10 < 3; i10++) {
            long j15 = jArr[i10] & j14;
            j14 ^= (j15 >> 13) ^ (((j15 >> 9) ^ (j15 >> 10)) ^ (j15 >> 12));
        }
        return (short) (j14 & ((long) this.f10994b));
    }

    @Override // hd.k
    protected short b(short s10) {
        return d(s10, (short) 1);
    }

    @Override // hd.k
    protected short c(short s10, short s11) {
        long j10 = s10;
        long j11 = s11;
        long j12 = (1 & j11) * j10;
        for (int i10 = 1; i10 < this.f10993a; i10++) {
            j12 ^= (((long) (1 << i10)) & j11) * j10;
        }
        long j13 = 33488896 & j12;
        long j14 = ((j13 >> 13) ^ (((j13 >> 9) ^ (j13 >> 10)) ^ (j13 >> 12))) ^ j12;
        long j15 = 57344 & j14;
        return (short) ((j14 ^ ((((j15 >> 10) ^ (j15 >> 9)) ^ (j15 >> 12)) ^ (j15 >> 13))) & ((long) this.f10994b));
    }

    protected short e(short s10) {
        long[] jArr = {1229782938247303441L, 217020518514230019L, 4222189076152335L, 1095216660735L};
        long[] jArr2 = {561850441793536L, 1097364144128L, 2143289344, 4186112};
        long j10 = s10;
        long j11 = (j10 | (j10 << 24)) & jArr[3];
        long j12 = (j11 | (j11 << 12)) & jArr[2];
        long j13 = (j12 | (j12 << 6)) & jArr[1];
        long j14 = (j13 | (j13 << 3)) & jArr[0];
        for (int i10 = 0; i10 < 4; i10++) {
            long j15 = jArr2[i10] & j14;
            j14 ^= (j15 >> 13) ^ (((j15 >> 9) ^ (j15 >> 10)) ^ (j15 >> 12));
        }
        return (short) (((long) this.f10994b) & j14);
    }

    public j(int i10) {
        super(i10);
    }

    protected short d(short s10, short s11) {
        short sG = g(s10, s10);
        short sF = f(sG, sG);
        return g(f(e(f(e(sF), sF)), sF), s11);
    }
}
