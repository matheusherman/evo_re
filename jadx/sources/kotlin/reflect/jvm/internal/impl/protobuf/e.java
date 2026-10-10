package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f13639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f13644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f13651m;

    private e(InputStream inputStream) {
        this.f13646h = false;
        this.f13648j = Integer.MAX_VALUE;
        this.f13650l = 64;
        this.f13651m = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.f13639a = new byte[4096];
        this.f13641c = 0;
        this.f13643e = 0;
        this.f13647i = 0;
        this.f13644f = inputStream;
        this.f13640b = false;
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static int B(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int i13 = inputStream.read();
            if (i13 == -1) {
                throw k.k();
            }
            i11 |= (i13 & 127) << i12;
            if ((i13 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        while (i12 < 64) {
            int i14 = inputStream.read();
            if (i14 == -1) {
                throw k.k();
            }
            if ((i14 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        throw k.f();
    }

    private void N() {
        int i10 = this.f13641c + this.f13642d;
        this.f13641c = i10;
        int i11 = this.f13647i + i10;
        int i12 = this.f13648j;
        if (i11 <= i12) {
            this.f13642d = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f13642d = i13;
        this.f13641c = i10 - i13;
    }

    private void S(int i10) throws k {
        if (i10 < 0) {
            throw k.g();
        }
        int i11 = this.f13647i;
        int i12 = this.f13643e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f13648j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.k();
        }
        int i15 = this.f13641c;
        int i16 = i15 - i12;
        this.f13643e = i15;
        O(1);
        while (true) {
            int i17 = i10 - i16;
            int i18 = this.f13641c;
            if (i17 <= i18) {
                this.f13643e = i17;
                return;
            } else {
                i16 += i18;
                this.f13643e = i18;
                O(1);
            }
        }
    }

    private boolean T(int i10) throws IOException {
        int i11 = this.f13643e;
        int i12 = i11 + i10;
        int i13 = this.f13641c;
        if (i12 <= i13) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i10);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f13647i + i11 + i10 <= this.f13648j && this.f13644f != null) {
            if (i11 > 0) {
                if (i13 > i11) {
                    byte[] bArr = this.f13639a;
                    System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                }
                this.f13647i += i11;
                this.f13641c -= i11;
                this.f13643e = 0;
            }
            InputStream inputStream = this.f13644f;
            byte[] bArr2 = this.f13639a;
            int i14 = this.f13641c;
            int i15 = inputStream.read(bArr2, i14, bArr2.length - i14);
            if (i15 == 0 || i15 < -1 || i15 > this.f13639a.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(i15);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (i15 > 0) {
                this.f13641c += i15;
                if ((this.f13647i + i10) - this.f13651m > 0) {
                    throw k.j();
                }
                N();
                if (this.f13641c >= i10) {
                    return true;
                }
                return T(i10);
            }
        }
        return false;
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    private void d(int i10) throws k {
        if (this.f13641c - this.f13643e < i10) {
            O(i10);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    static e h(p pVar) {
        e eVar = new e(pVar);
        try {
            eVar.j(pVar.size());
            return eVar;
        } catch (k e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    private byte[] x(int i10) throws k {
        if (i10 <= 0) {
            if (i10 == 0) {
                return j.f13686a;
            }
            throw k.g();
        }
        int i11 = this.f13647i;
        int i12 = this.f13643e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f13648j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.k();
        }
        if (i10 < 4096) {
            byte[] bArr = new byte[i10];
            int i15 = this.f13641c - i12;
            System.arraycopy(this.f13639a, i12, bArr, 0, i15);
            this.f13643e = this.f13641c;
            int i16 = i10 - i15;
            d(i16);
            System.arraycopy(this.f13639a, 0, bArr, i15, i16);
            this.f13643e = i16;
            return bArr;
        }
        int i17 = this.f13641c;
        this.f13647i = i11 + i17;
        this.f13643e = 0;
        this.f13641c = 0;
        int length = i17 - i12;
        int i18 = i10 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i18 > 0) {
            int iMin = Math.min(i18, 4096);
            byte[] bArr2 = new byte[iMin];
            int i19 = 0;
            while (i19 < iMin) {
                InputStream inputStream = this.f13644f;
                int i20 = inputStream == null ? -1 : inputStream.read(bArr2, i19, iMin - i19);
                if (i20 == -1) {
                    throw k.k();
                }
                this.f13647i += i20;
                i19 += i20;
            }
            i18 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(this.f13639a, i12, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public int A() {
        int i10;
        int i11 = this.f13643e;
        int i12 = this.f13641c;
        if (i12 != i11) {
            byte[] bArr = this.f13639a;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f13643e = i13;
                return b10;
            }
            if (i12 - i13 >= 9) {
                int i14 = i11 + 2;
                int i15 = (bArr[i13] << 7) ^ b10;
                long j10 = i15;
                if (j10 < 0) {
                    i10 = (int) ((-128) ^ j10);
                } else {
                    int i16 = i11 + 3;
                    int i17 = (bArr[i14] << 14) ^ i15;
                    long j11 = i17;
                    if (j11 >= 0) {
                        i10 = (int) (16256 ^ j11);
                    } else {
                        int i18 = i11 + 4;
                        int i19 = i17 ^ (bArr[i16] << 21);
                        long j12 = i19;
                        if (j12 < 0) {
                            i10 = (int) ((-2080896) ^ j12);
                        } else {
                            i16 = i11 + 5;
                            byte b11 = bArr[i18];
                            int i20 = (int) (((long) (i19 ^ (b11 << 28))) ^ 266354560);
                            if (b11 < 0) {
                                i18 = i11 + 6;
                                if (bArr[i16] < 0) {
                                    i16 = i11 + 7;
                                    if (bArr[i18] < 0) {
                                        i18 = i11 + 8;
                                        if (bArr[i16] < 0) {
                                            i16 = i11 + 9;
                                            if (bArr[i18] < 0) {
                                                int i21 = i11 + 10;
                                                if (bArr[i16] >= 0) {
                                                    i14 = i21;
                                                    i10 = i20;
                                                }
                                            }
                                        }
                                    }
                                }
                                i10 = i20;
                            }
                            i10 = i20;
                        }
                        i14 = i18;
                    }
                    i14 = i16;
                }
                this.f13643e = i14;
                return i10;
            }
        }
        return (int) D();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        if (r2[r7] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long C() {
        long j10;
        long j11;
        long j12;
        int i10 = this.f13643e;
        int i11 = this.f13641c;
        if (i11 != i10) {
            byte[] bArr = this.f13639a;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f13643e = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                long j13 = (bArr[i12] << 7) ^ b10;
                if (j13 >= 0) {
                    int i14 = i10 + 3;
                    long j14 = j13 ^ ((long) (bArr[i13] << 14));
                    if (j14 >= 0) {
                        j12 = 16256;
                    } else {
                        i13 = i10 + 4;
                        j13 = j14 ^ ((long) (bArr[i14] << 21));
                        if (j13 < 0) {
                            j11 = -2080896;
                        } else {
                            i14 = i10 + 5;
                            j14 = j13 ^ (((long) bArr[i13]) << 28);
                            if (j14 >= 0) {
                                j12 = 266354560;
                            } else {
                                i13 = i10 + 6;
                                j13 = j14 ^ (((long) bArr[i14]) << 35);
                                if (j13 >= 0) {
                                    i14 = i10 + 7;
                                    j14 = j13 ^ (((long) bArr[i13]) << 42);
                                    if (j14 >= 0) {
                                        j12 = 4363953127296L;
                                    } else {
                                        i13 = i10 + 8;
                                        j13 = j14 ^ (((long) bArr[i14]) << 49);
                                        if (j13 < 0) {
                                            j11 = -558586000294016L;
                                        } else {
                                            i14 = i10 + 9;
                                            j10 = (j13 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                            i13 = j10 < 0 ? i10 + 10 : i14;
                                        }
                                    }
                                    this.f13643e = i13;
                                    return j10;
                                }
                                j11 = -34093383808L;
                            }
                        }
                    }
                    j10 = j14 ^ j12;
                    this.f13643e = i13;
                    return j10;
                }
                j11 = -128;
                j10 = j13 ^ j11;
                this.f13643e = i13;
                return j10;
            }
        }
        return D();
    }

    long D() throws k {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte bW = w();
            j10 |= ((long) (bW & 127)) << i10;
            if ((bW & 128) == 0) {
                return j10;
            }
        }
        throw k.f();
    }

    public void R(int i10) throws k {
        int i11 = this.f13641c;
        int i12 = this.f13643e;
        if (i10 > i11 - i12 || i10 < 0) {
            S(i10);
        } else {
            this.f13643e = i12 + i10;
        }
    }

    public void a(int i10) throws k {
        if (this.f13645g != i10) {
            throw k.b();
        }
    }

    public int e() {
        int i10 = this.f13648j;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - (this.f13647i + this.f13643e);
    }

    public boolean f() {
        return this.f13643e == this.f13641c && !T(1);
    }

    public void i(int i10) {
        this.f13648j = i10;
        N();
    }

    public int j(int i10) throws k {
        if (i10 < 0) {
            throw k.g();
        }
        int i11 = i10 + this.f13647i + this.f13643e;
        int i12 = this.f13648j;
        if (i11 > i12) {
            throw k.k();
        }
        this.f13648j = i11;
        N();
        return i12;
    }

    public void r(int i10, q.a aVar, g gVar) throws k {
        int i11 = this.f13649k;
        if (i11 >= this.f13650l) {
            throw k.h();
        }
        this.f13649k = i11 + 1;
        aVar.i(this, gVar);
        a(z.c(i10, 4));
        this.f13649k--;
    }

    public byte w() throws k {
        if (this.f13643e == this.f13641c) {
            O(1);
        }
        byte[] bArr = this.f13639a;
        int i10 = this.f13643e;
        this.f13643e = i10 + 1;
        return bArr[i10];
    }

    public int y() throws k {
        int i10 = this.f13643e;
        if (this.f13641c - i10 < 4) {
            O(4);
            i10 = this.f13643e;
        }
        byte[] bArr = this.f13639a;
        this.f13643e = i10 + 4;
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public long z() throws k {
        int i10 = this.f13643e;
        if (this.f13641c - i10 < 8) {
            O(8);
            i10 = this.f13643e;
        }
        byte[] bArr = this.f13639a;
        this.f13643e = i10 + 8;
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    private void O(int i10) throws k {
        if (T(i10)) {
        } else {
            throw k.k();
        }
    }

    public int E() {
        return y();
    }

    public long F() {
        return z();
    }

    public int G() {
        return b(A());
    }

    public long H() {
        return c(C());
    }

    public String I() {
        int iA = A();
        int i10 = this.f13641c;
        int i11 = this.f13643e;
        if (iA <= i10 - i11 && iA > 0) {
            String str = new String(this.f13639a, i11, iA, "UTF-8");
            this.f13643e += iA;
            return str;
        }
        if (iA == 0) {
            return "";
        }
        return new String(x(iA), "UTF-8");
    }

    public String J() throws k {
        byte[] bArrX;
        int iA = A();
        int i10 = this.f13643e;
        if (iA <= this.f13641c - i10 && iA > 0) {
            bArrX = this.f13639a;
            this.f13643e = i10 + iA;
        } else {
            if (iA == 0) {
                return "";
            }
            bArrX = x(iA);
            i10 = 0;
        }
        if (y.f(bArrX, i10, i10 + iA)) {
            return new String(bArrX, i10, iA, "UTF-8");
        }
        throw k.d();
    }

    public int K() throws k {
        if (f()) {
            this.f13645g = 0;
            return 0;
        }
        int iA = A();
        this.f13645g = iA;
        if (z.a(iA) != 0) {
            return this.f13645g;
        }
        throw k.c();
    }

    public int L() {
        return A();
    }

    public long M() {
        return C();
    }

    public boolean P(int i10, f fVar) throws k {
        int iB = z.b(i10);
        if (iB != 0) {
            if (iB != 1) {
                if (iB != 2) {
                    if (iB != 3) {
                        if (iB != 4) {
                            if (iB == 5) {
                                int iY = y();
                                fVar.o0(i10);
                                fVar.U(iY);
                                return true;
                            }
                            throw k.e();
                        }
                        return false;
                    }
                    fVar.o0(i10);
                    Q(fVar);
                    int iC = z.c(z.a(i10), 4);
                    a(iC);
                    fVar.o0(iC);
                    return true;
                }
                d dVarL = l();
                fVar.o0(i10);
                fVar.P(dVarL);
                return true;
            }
            long jZ = z();
            fVar.o0(i10);
            fVar.V(jZ);
            return true;
        }
        long jT = t();
        fVar.o0(i10);
        fVar.z0(jT);
        return true;
    }

    public void Q(f fVar) throws k {
        int iK;
        do {
            iK = K();
            if (iK == 0) {
                return;
            }
        } while (P(iK, fVar));
    }

    public boolean k() {
        if (C() != 0) {
            return true;
        }
        return false;
    }

    public d l() {
        d dVarI;
        int iA = A();
        int i10 = this.f13641c;
        int i11 = this.f13643e;
        if (iA <= i10 - i11 && iA > 0) {
            if (this.f13640b && this.f13646h) {
                dVarI = new c(this.f13639a, this.f13643e, iA);
            } else {
                dVarI = d.i(this.f13639a, i11, iA);
            }
            this.f13643e += iA;
            return dVarI;
        }
        if (iA == 0) {
            return d.f13632a;
        }
        return new p(x(iA));
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public int n() {
        return A();
    }

    public int o() {
        return y();
    }

    public long p() {
        return z();
    }

    public float q() {
        return Float.intBitsToFloat(y());
    }

    public int s() {
        return A();
    }

    public long t() {
        return C();
    }

    public <T extends q> T u(s<T> sVar, g gVar) throws k {
        int iA = A();
        if (this.f13649k < this.f13650l) {
            int iJ = j(iA);
            this.f13649k++;
            T tB = sVar.b(this, gVar);
            a(0);
            this.f13649k--;
            i(iJ);
            return tB;
        }
        throw k.h();
    }

    public void v(q.a aVar, g gVar) throws k {
        int iA = A();
        if (this.f13649k < this.f13650l) {
            int iJ = j(iA);
            this.f13649k++;
            aVar.i(this, gVar);
            a(0);
            this.f13649k--;
            i(iJ);
            return;
        }
        throw k.h();
    }

    private e(p pVar) {
        this.f13646h = false;
        this.f13648j = Integer.MAX_VALUE;
        this.f13650l = 64;
        this.f13651m = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.f13639a = pVar.f13697b;
        int iH = pVar.H();
        this.f13643e = iH;
        this.f13641c = iH + pVar.size();
        this.f13647i = -this.f13643e;
        this.f13644f = null;
        this.f13640b = true;
    }
}
