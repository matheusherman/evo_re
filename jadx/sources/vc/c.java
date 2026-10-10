package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class c implements tc.i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final long[] f19779p = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final tc.d f19780a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f19785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected long f19786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected long f19787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f19788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected long f19789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected long f19790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected long f19791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected long f19792m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f19794o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f19781b = new byte[8];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long[] f19793n = new long[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19782c = 0;

    private long f(long j10, long j11, long j12) {
        return ((~j10) & j12) ^ (j11 & j10);
    }

    private long g(long j10, long j11, long j12) {
        return ((j10 & j12) ^ (j10 & j11)) ^ (j11 & j12);
    }

    private long h(long j10) {
        return (j10 >>> 7) ^ (((j10 << 63) | (j10 >>> 1)) ^ ((j10 << 56) | (j10 >>> 8)));
    }

    private long i(long j10) {
        return (j10 >>> 6) ^ (((j10 << 45) | (j10 >>> 19)) ^ ((j10 << 3) | (j10 >>> 61)));
    }

    private long j(long j10) {
        return ((j10 >>> 39) | (j10 << 25)) ^ (((j10 << 36) | (j10 >>> 28)) ^ ((j10 << 30) | (j10 >>> 34)));
    }

    private long k(long j10) {
        return ((j10 >>> 41) | (j10 << 23)) ^ (((j10 << 50) | (j10 >>> 14)) ^ ((j10 << 46) | (j10 >>> 18)));
    }

    private void l() {
        long j10 = this.f19783d;
        if (j10 > 2305843009213693951L) {
            this.f19784e += j10 >>> 61;
            this.f19783d = j10 & 2305843009213693951L;
        }
    }

    @Override // tc.i
    public void c(byte b10) {
        byte[] bArr = this.f19781b;
        int i10 = this.f19782c;
        int i11 = i10 + 1;
        this.f19782c = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            p(bArr, 0);
            this.f19782c = 0;
        }
        this.f19783d++;
    }

    protected void n() {
        l();
        for (int i10 = 16; i10 <= 79; i10++) {
            long[] jArr = this.f19793n;
            long jI = i(jArr[i10 - 2]);
            long[] jArr2 = this.f19793n;
            jArr[i10] = jI + jArr2[i10 - 7] + h(jArr2[i10 - 15]) + this.f19793n[i10 - 16];
        }
        long j10 = this.f19785f;
        long j11 = this.f19786g;
        long j12 = this.f19787h;
        long j13 = this.f19788i;
        long j14 = this.f19789j;
        long j15 = j13;
        long j16 = this.f19790k;
        int i11 = 0;
        int i12 = 0;
        long j17 = j12;
        long j18 = this.f19791l;
        long j19 = this.f19792m;
        long j20 = j10;
        long j21 = j14;
        long j22 = j11;
        while (i11 < 10) {
            long j23 = j16;
            long j24 = j21;
            long j25 = j18;
            long jK = k(j21) + f(j21, j23, j18);
            long[] jArr3 = f19779p;
            int i13 = i12 + 1;
            long j26 = j19 + jK + jArr3[i12] + this.f19793n[i12];
            long j27 = j15 + j26;
            long j28 = j20;
            long j29 = j22;
            long j30 = j17;
            long j31 = j26 + j(j20) + g(j28, j29, j30);
            int i14 = i12 + 2;
            long jK2 = j25 + k(j27) + f(j27, j24, j23) + jArr3[i13] + this.f19793n[i13];
            long j32 = j30 + jK2;
            long j33 = jK2 + j(j31) + g(j31, j28, j29);
            int i15 = i12 + 3;
            long jK3 = j23 + k(j32) + f(j32, j27, j24) + jArr3[i14] + this.f19793n[i14];
            long j34 = j29 + jK3;
            long j35 = jK3 + j(j33) + g(j33, j31, j28);
            int i16 = i12 + 4;
            long jK4 = j24 + k(j34) + f(j34, j32, j27) + jArr3[i15] + this.f19793n[i15];
            long j36 = j28 + jK4;
            long j37 = jK4 + j(j35) + g(j35, j33, j31);
            int i17 = i12 + 5;
            long jK5 = j27 + k(j36) + f(j36, j34, j32) + jArr3[i16] + this.f19793n[i16];
            long j38 = j31 + jK5;
            long j39 = jK5 + j(j37) + g(j37, j35, j33);
            int i18 = i12 + 6;
            long jK6 = j32 + k(j38) + f(j38, j36, j34) + jArr3[i17] + this.f19793n[i17];
            long j40 = j33 + jK6;
            long j41 = jK6 + j(j39) + g(j39, j37, j35);
            int i19 = i12 + 7;
            long jK7 = j34 + k(j40) + f(j40, j38, j36) + jArr3[i18] + this.f19793n[i18];
            long j42 = j35 + jK7;
            long j43 = jK7 + j(j41) + g(j41, j39, j37);
            i12 += 8;
            long jK8 = j36 + k(j42) + f(j42, j40, j38) + jArr3[i19] + this.f19793n[i19];
            long j44 = j37 + jK8;
            j20 = jK8 + j(j43) + g(j43, j41, j39);
            i11++;
            j22 = j43;
            j21 = j44;
            j17 = j41;
            j19 = j38;
            j16 = j42;
            j18 = j40;
            j15 = j39;
        }
        this.f19785f += j20;
        this.f19786g += j22;
        this.f19787h += j17;
        this.f19788i += j15;
        this.f19789j += j21;
        this.f19790k += j16;
        this.f19791l += j18;
        this.f19792m += j19;
        this.f19794o = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.f19793n[i20] = 0;
        }
    }

    protected void o(long j10, long j11) {
        if (this.f19794o > 14) {
            n();
        }
        long[] jArr = this.f19793n;
        jArr[14] = j11;
        jArr[15] = j10;
    }

    protected void p(byte[] bArr, int i10) {
        this.f19793n[this.f19794o] = re.f.b(bArr, i10);
        int i11 = this.f19794o + 1;
        this.f19794o = i11;
        if (i11 == 16) {
            n();
        }
    }

    public void q() {
        this.f19783d = 0L;
        this.f19784e = 0L;
        int i10 = 0;
        this.f19782c = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f19781b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = 0;
            i11++;
        }
        this.f19794o = 0;
        while (true) {
            long[] jArr = this.f19793n;
            if (i10 == jArr.length) {
                return;
            }
            jArr[i10] = 0;
            i10++;
        }
    }

    @Override // tc.i
    public void update(byte[] bArr, int i10, int i11) {
        while (this.f19782c != 0 && i11 > 0) {
            c(bArr[i10]);
            i10++;
            i11--;
        }
        while (i11 >= this.f19781b.length) {
            p(bArr, i10);
            byte[] bArr2 = this.f19781b;
            i10 += bArr2.length;
            i11 -= bArr2.length;
            this.f19783d += (long) bArr2.length;
        }
        while (i11 > 0) {
            c(bArr[i10]);
            i10++;
            i11--;
        }
    }

    protected c(tc.d dVar) {
        this.f19780a = dVar;
        q();
    }

    public void m() {
        l();
        long j10 = this.f19783d << 3;
        long j11 = this.f19784e;
        byte b10 = -128;
        while (true) {
            c(b10);
            if (this.f19782c != 0) {
                b10 = 0;
            } else {
                o(j10, j11);
                n();
                return;
            }
        }
    }
}
