package y6;

import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final q6.b f22426u = q6.c.d(k.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f22427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v6.b f22429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BitSet f22433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BitSet f22434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f22436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f22437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f22439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f22440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f22441o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f22442p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f22443q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f22444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f22445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f22446t;

    public k(v6.b bVar, int i10, String str, int i11, String str2) {
        this.f22431e = -1;
        this.f22432f = 0;
        this.f22435i = 0;
        this.f22436j = 0;
        this.f22438l = false;
        this.f22439m = false;
        this.f22443q = 0;
        this.f22444r = 0;
        this.f22445s = false;
        this.f22446t = -1;
        this.f22429c = bVar;
        this.f22427a = Integer.valueOf(i10);
        this.f22428b = str;
        this.f22431e = i11;
        this.f22430d = str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f22440n = jCurrentTimeMillis;
        this.f22441o = jCurrentTimeMillis;
        this.f22442p = jCurrentTimeMillis;
    }

    public void A(BitSet bitSet) {
        this.f22434h = bitSet;
    }

    public void B(int i10) {
        this.f22432f = i10;
    }

    public void C(boolean z10) {
        this.f22439m = z10;
    }

    public void a() {
        this.f22444r++;
    }

    public void b(int i10, byte[] bArr, boolean z10, int i11, long j10) {
        String str;
        this.f22442p = System.currentTimeMillis();
        if (this.f22438l || this.f22434h.get(i10)) {
            return;
        }
        System.arraycopy(bArr, 0, this.f22437k, i10 * 1128, bArr.length);
        this.f22434h.set(i10);
        this.f22435i += bArr.length;
        if (!z10) {
            this.f22436j += bArr.length;
        }
        if (this.f22434h.cardinality() == this.f22432f) {
            int i12 = this.f22435i;
            byte[] bArr2 = new byte[i12];
            System.arraycopy(this.f22437k, 0, bArr2, 0, i12);
            this.f22437k = bArr2;
            this.f22438l = true;
            this.f22443q = (this.f22433g.cardinality() * 100) / this.f22432f;
            q6.b bVar = f22426u;
            if (this.f22429c.equals(v6.b.BLOCK)) {
                str = "BK";
            } else {
                str = this.f22429c.equals(v6.b.INDEX) ? "IDX" : "ST";
            }
            bVar.a("[{}][{}][{}] complete rcv,total:[{}],size:[{}] [S:{}],time:[{}]ms, resend count[{}],resendRate:[{}],speed:[{}],rtt:[{}]", str, this.f22428b, this.f22430d, Integer.valueOf(this.f22432f), Integer.valueOf(this.f22435i), Integer.valueOf(this.f22436j), Long.valueOf(this.f22442p - this.f22440n), Integer.valueOf(this.f22444r), Integer.valueOf(this.f22443q), Integer.valueOf(i11), Long.valueOf(j10));
        }
    }

    public int c() {
        return this.f22431e;
    }

    public int d() {
        return this.f22435i;
    }

    public String e() {
        return this.f22430d;
    }

    public byte[] f() {
        return this.f22437k;
    }

    public long g() {
        return this.f22441o;
    }

    public long h() {
        return this.f22442p;
    }

    public Integer i() {
        return this.f22427a;
    }

    public String j() {
        return this.f22428b;
    }

    public long k() {
        return this.f22440n;
    }

    public int l() {
        return this.f22444r;
    }

    public List<Integer> m() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f22432f; i10++) {
            if (!this.f22434h.get(i10)) {
                arrayList.add(Integer.valueOf(i10));
                this.f22433g.set(i10);
            }
        }
        return arrayList;
    }

    public int n() {
        return this.f22443q;
    }

    public BitSet o() {
        return this.f22434h;
    }

    public int p() {
        return this.f22432f;
    }

    public boolean q() {
        return this.f22438l;
    }

    public boolean r() {
        return this.f22445s;
    }

    public boolean s() {
        return this.f22439m;
    }

    public void t(PipedOutputStream pipedOutputStream) {
        if (pipedOutputStream == null || this.f22445s || this.f22434h == null || !this.f22438l) {
            return;
        }
        f22426u.a("[{}][{}][{}] start to push block", "BK", this.f22428b, this.f22430d);
        try {
            pipedOutputStream.write(this.f22437k);
            pipedOutputStream.flush();
            this.f22445s = true;
        } catch (Exception e10) {
            f22426u.error("[{}][{}][{}] push pipedOutputStream[{}] error [{}]", "BK", this.f22428b, this.f22430d, Integer.valueOf(pipedOutputStream.hashCode()), e10.getClass().getSimpleName());
        }
    }

    public void u(PipedOutputStream pipedOutputStream) {
        if (pipedOutputStream == null || this.f22445s || this.f22434h == null) {
            return;
        }
        try {
            int i10 = this.f22446t + 1;
            while (i10 < this.f22432f && this.f22434h.get(i10)) {
                pipedOutputStream.write(this.f22437k, i10 * 1128, i10 == this.f22432f - 1 ? this.f22435i - (i10 * 1128) : 1128);
                pipedOutputStream.flush();
                if (this.f22446t < 0) {
                    f22426u.a("[{}][{}][{}] start to push stream slice", "BK", this.f22428b, this.f22430d, Integer.valueOf(i10));
                }
                this.f22446t = i10;
                if (i10 == this.f22432f - 1) {
                    this.f22445s = true;
                }
                i10++;
            }
        } catch (Exception e10) {
            f22426u.error("[{}][{}][{}] push pipedOutputStream[{}] error [{}]", "BK", this.f22428b, this.f22430d, Integer.valueOf(pipedOutputStream.hashCode()), e10.getClass().getSimpleName());
        }
    }

    public void v(byte[] bArr) {
        this.f22437k = bArr;
    }

    public void w(long j10) {
        this.f22441o = j10;
    }

    public void x(long j10) {
        this.f22442p = j10;
    }

    public void y(boolean z10) {
        this.f22445s = z10;
    }

    public void z(BitSet bitSet) {
        this.f22433g = bitSet;
    }

    public k(v6.b bVar, int i10, String str, int i11, String str2, int i12) {
        this.f22431e = -1;
        this.f22432f = 0;
        this.f22435i = 0;
        this.f22436j = 0;
        this.f22438l = false;
        this.f22439m = false;
        this.f22443q = 0;
        this.f22444r = 0;
        this.f22445s = false;
        this.f22446t = -1;
        this.f22429c = bVar;
        this.f22427a = Integer.valueOf(i10);
        this.f22428b = str;
        this.f22431e = i11;
        this.f22430d = str2;
        this.f22432f = i12;
        this.f22434h = new BitSet(i12);
        this.f22433g = new BitSet(i12);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f22440n = jCurrentTimeMillis;
        this.f22441o = jCurrentTimeMillis;
        this.f22442p = jCurrentTimeMillis;
        this.f22437k = new byte[this.f22432f * 1128];
    }

    public k(v6.b bVar, int i10, String str, int i11, String str2, byte[] bArr) {
        this.f22431e = -1;
        this.f22432f = 0;
        this.f22435i = 0;
        this.f22436j = 0;
        this.f22438l = false;
        this.f22439m = false;
        this.f22443q = 0;
        this.f22444r = 0;
        this.f22445s = false;
        this.f22446t = -1;
        this.f22429c = bVar;
        this.f22427a = Integer.valueOf(i10);
        this.f22428b = str;
        this.f22431e = i11;
        this.f22430d = str2;
        this.f22432f = (int) Math.ceil((((double) bArr.length) * 1.0d) / 1128.0d);
        this.f22434h = new BitSet(this.f22432f);
        this.f22433g = new BitSet(this.f22432f);
        this.f22435i = bArr.length;
        this.f22437k = bArr;
        this.f22438l = true;
    }
}
