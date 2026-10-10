package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class m9 extends x8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f2867b = Logger.getLogger(m9.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f2868c = xc.w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p9 f2869a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a extends m9 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f2870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2871e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2872f;

        a(byte[] bArr, int i10, int i11) {
            super(null);
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i11) | i11) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
            }
            this.f2870d = bArr;
            this.f2872f = 0;
            this.f2871e = i11;
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void O(int i10, int i11) {
            Z(i10, 0);
            L(i11);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void P(int i10, long j10) {
            Z(i10, 0);
            R(j10);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void Q(int i10, v8 v8Var) {
            Z(1, 3);
            f0(2, i10);
            p(3, v8Var);
            Z(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void f0(int i10, int i11) {
            Z(i10, 0);
            Y(i11);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void n(int i10, int i11) {
            Z(i10, 5);
            m(i11);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void o(int i10, long j10) {
            Z(i10, 1);
            u(j10);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void p(int i10, v8 v8Var) {
            Z(i10, 2);
            v(v8Var);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void q(int i10, ob obVar) {
            Z(1, 3);
            f0(2, i10);
            Z(3, 2);
            w(obVar);
            Z(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        final void r(int i10, ob obVar, fc fcVar) {
            Z(i10, 2);
            Y(((n8) obVar).f(fcVar));
            fcVar.g(obVar, this.f2869a);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void s(int i10, String str) {
            Z(i10, 2);
            x(str);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void t(int i10, boolean z10) {
            Z(i10, 0);
            l(z10 ? (byte) 1 : (byte) 0);
        }

        private final void E0(byte[] bArr, int i10, int i11) throws b {
            try {
                System.arraycopy(bArr, i10, this.f2870d, this.f2872f, i11);
                this.f2872f += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new b(this.f2872f, this.f2871e, i11, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void L(int i10) {
            if (i10 >= 0) {
                Y(i10);
            } else {
                R(i10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void R(long j10) throws b {
            int i10;
            int i11 = this.f2872f;
            if (!m9.f2868c || b() < 10) {
                while ((j10 & (-128)) != 0) {
                    try {
                        int i12 = i11 + 1;
                        try {
                            this.f2870d[i11] = (byte) (((int) j10) | 128);
                            j10 >>>= 7;
                            i11 = i12;
                        } catch (IndexOutOfBoundsException e10) {
                            e = e10;
                            i11 = i12;
                            throw new b(i11, this.f2871e, 1, (Throwable) e);
                        }
                    } catch (IndexOutOfBoundsException e11) {
                        e = e11;
                    }
                }
                i10 = i11 + 1;
                try {
                    this.f2870d[i11] = (byte) j10;
                } catch (IndexOutOfBoundsException e12) {
                    e = e12;
                    i11 = i10;
                    throw new b(i11, this.f2871e, 1, (Throwable) e);
                }
            } else {
                while ((j10 & (-128)) != 0) {
                    xc.m(this.f2870d, i11, (byte) (((int) j10) | 128));
                    j10 >>>= 7;
                    i11++;
                }
                i10 = i11 + 1;
                xc.m(this.f2870d, i11, (byte) j10);
            }
            this.f2872f = i10;
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void Y(int i10) throws b {
            int i11;
            int i12 = this.f2872f;
            while ((i10 & (-128)) != 0) {
                try {
                    i11 = i12 + 1;
                    try {
                        this.f2870d[i12] = (byte) (i10 | 128);
                        i10 >>>= 7;
                        i12 = i11;
                    } catch (IndexOutOfBoundsException e10) {
                        e = e10;
                        i12 = i11;
                        throw new b(i12, this.f2871e, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e11) {
                    e = e11;
                    throw new b(i12, this.f2871e, 1, (Throwable) e);
                }
            }
            i11 = i12 + 1;
            this.f2870d[i12] = (byte) i10;
            this.f2872f = i11;
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void Z(int i10, int i11) {
            Y((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final int b() {
            return this.f2871e - this.f2872f;
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void l(byte b10) throws b {
            int i10 = this.f2872f;
            try {
                int i11 = i10 + 1;
                try {
                    this.f2870d[i10] = b10;
                    this.f2872f = i11;
                } catch (IndexOutOfBoundsException e10) {
                    e = e10;
                    i10 = i11;
                    throw new b(i10, this.f2871e, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e11) {
                e = e11;
            }
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void m(int i10) throws b {
            int i11 = this.f2872f;
            try {
                byte[] bArr = this.f2870d;
                bArr[i11] = (byte) i10;
                bArr[i11 + 1] = (byte) (i10 >> 8);
                bArr[i11 + 2] = (byte) (i10 >> 16);
                bArr[i11 + 3] = i10 >> 24;
                this.f2872f = i11 + 4;
            } catch (IndexOutOfBoundsException e10) {
                throw new b(i11, this.f2871e, 4, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void u(long j10) throws b {
            int i10 = this.f2872f;
            try {
                byte[] bArr = this.f2870d;
                bArr[i10] = (byte) j10;
                bArr[i10 + 1] = (byte) (j10 >> 8);
                bArr[i10 + 2] = (byte) (j10 >> 16);
                bArr[i10 + 3] = (byte) (j10 >> 24);
                bArr[i10 + 4] = (byte) (j10 >> 32);
                bArr[i10 + 5] = (byte) (j10 >> 40);
                bArr[i10 + 6] = (byte) (j10 >> 48);
                bArr[i10 + 7] = (byte) (j10 >> 56);
                this.f2872f = i10 + 8;
            } catch (IndexOutOfBoundsException e10) {
                throw new b(i10, this.f2871e, 8, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void x(String str) throws b {
            int i10 = this.f2872f;
            try {
                int iZ0 = m9.z0(str.length() * 3);
                int iZ1 = m9.z0(str.length());
                if (iZ1 != iZ0) {
                    Y(bd.a(str));
                    this.f2872f = bd.b(str, this.f2870d, this.f2872f, b());
                    return;
                }
                int i11 = i10 + iZ1;
                this.f2872f = i11;
                int iB = bd.b(str, this.f2870d, i11, b());
                this.f2872f = i10;
                Y((iB - i10) - iZ1);
                this.f2872f = iB;
            } catch (fd e10) {
                this.f2872f = i10;
                y(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new b(e11);
            }
        }

        @Override // com.google.android.gms.internal.measurement.x8
        public final void a(byte[] bArr, int i10, int i11) throws b {
            E0(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void v(v8 v8Var) {
            Y(v8Var.r());
            v8Var.o(this);
        }

        @Override // com.google.android.gms.internal.measurement.m9
        public final void w(ob obVar) {
            Y(obVar.e());
            obVar.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b extends IOException {
        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        b(int i10, int i11, int i12, Throwable th) {
            this(i10, i11, i12, th);
        }

        private b(long j10, long j11, int i10, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10)), th);
        }
    }

    /* synthetic */ m9(n9 n9Var) {
        this();
    }

    public static m9 H(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b0(int i10) {
        return r0(i10);
    }

    public static int d(float f10) {
        return 4;
    }

    public static int g0(int i10) {
        return 4;
    }

    public static int j(boolean z10) {
        return 1;
    }

    public static int k(byte[] bArr) {
        int length = bArr.length;
        return z0(length) + length;
    }

    public static int k0(int i10) {
        return r0(i10);
    }

    public static int o0(int i10) {
        return 4;
    }

    private static long y0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public abstract void L(int i10);

    public abstract void O(int i10, int i11);

    public abstract void P(int i10, long j10);

    public abstract void Q(int i10, v8 v8Var);

    public abstract void R(long j10);

    public final void S(boolean z10) {
        l(z10 ? (byte) 1 : (byte) 0);
    }

    public abstract void Y(int i10);

    public abstract void Z(int i10, int i11);

    public abstract int b();

    public abstract void f0(int i10, int i11);

    public abstract void l(byte b10);

    public abstract void m(int i10);

    public abstract void n(int i10, int i11);

    public abstract void o(int i10, long j10);

    public abstract void p(int i10, v8 v8Var);

    public abstract void q(int i10, ob obVar);

    abstract void r(int i10, ob obVar, fc fcVar);

    public abstract void s(int i10, String str);

    public abstract void t(int i10, boolean z10);

    public abstract void u(long j10);

    public abstract void v(v8 v8Var);

    public abstract void w(ob obVar);

    public abstract void x(String str);

    private m9() {
    }

    public static int A(int i10, ob obVar) {
        return (z0(8) << 1) + A0(2, i10) + z0(24) + X(obVar);
    }

    public static int A0(int i10, int i11) {
        return z0(i10 << 3) + z0(i11);
    }

    @Deprecated
    static int B(int i10, ob obVar, fc fcVar) {
        return (z0(i10 << 3) << 1) + ((n8) obVar).f(fcVar);
    }

    public static int C(int i10, String str) {
        return z0(i10 << 3) + G(str);
    }

    public static int D(int i10, boolean z10) {
        return z0(i10 << 3) + 1;
    }

    private static int D0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static int T(int i10, long j10) {
        return z0(i10 << 3) + 8;
    }

    public static int U(int i10, v8 v8Var) {
        int iZ0 = z0(i10 << 3);
        int iR = v8Var.r();
        return iZ0 + z0(iR) + iR;
    }

    static int V(int i10, ob obVar, fc fcVar) {
        return z0(i10 << 3) + i(obVar, fcVar);
    }

    public static int W(long j10) {
        return 8;
    }

    public static int c(double d10) {
        return 8;
    }

    public static int c0(int i10, long j10) {
        return z0(i10 << 3) + r0(j10);
    }

    public static int d0(int i10, v8 v8Var) {
        return (z0(8) << 1) + A0(2, i10) + U(3, v8Var);
    }

    public static int e(int i10, double d10) {
        return z0(i10 << 3) + 8;
    }

    public static int f(int i10, float f10) {
        return z0(i10 << 3) + 4;
    }

    public static int g(int i10, va vaVar) {
        return (z0(8) << 1) + A0(2, i10) + z(3, vaVar);
    }

    public static int h0(int i10, int i11) {
        return z0(i10 << 3) + r0(i11);
    }

    static int i(ob obVar, fc fcVar) {
        int iF = ((n8) obVar).f(fcVar);
        return z0(iF) + iF;
    }

    public static int i0(int i10, long j10) {
        return z0(i10 << 3) + 8;
    }

    public static int j0(long j10) {
        return 8;
    }

    public static int l0(int i10, int i11) {
        return z0(i10 << 3) + 4;
    }

    public static int m0(int i10, long j10) {
        return z0(i10 << 3) + r0(y0(j10));
    }

    public static int p0(int i10, int i11) {
        return z0(i10 << 3) + r0(i11);
    }

    public static int q0(int i10, long j10) {
        return z0(i10 << 3) + r0(j10);
    }

    public static int t0(int i10, int i11) {
        return z0(i10 << 3) + 4;
    }

    public static int w0(int i10) {
        return z0(i10 << 3);
    }

    public static int x0(int i10, int i11) {
        return z0(i10 << 3) + z0(D0(i11));
    }

    public static int z(int i10, va vaVar) {
        int iZ0 = z0(i10 << 3);
        int iA = vaVar.a();
        return iZ0 + z0(iA) + iA;
    }

    final void y(String str, fd fdVar) throws b {
        f2867b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) fdVar);
        byte[] bytes = str.getBytes(ga.f2717a);
        try {
            Y(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new b(e10);
        }
    }

    public static int E(v8 v8Var) {
        int iR = v8Var.r();
        return z0(iR) + iR;
    }

    @Deprecated
    public static int F(ob obVar) {
        return obVar.e();
    }

    public static int G(String str) {
        int length;
        try {
            length = bd.a(str);
        } catch (fd unused) {
            length = str.getBytes(ga.f2717a).length;
        }
        return z0(length) + length;
    }

    public static int X(ob obVar) {
        int iE = obVar.e();
        return z0(iE) + iE;
    }

    public static int e0(long j10) {
        return r0(j10);
    }

    public static int h(va vaVar) {
        int iA = vaVar.a();
        return z0(iA) + iA;
    }

    public static int n0(long j10) {
        return r0(y0(j10));
    }

    public static int r0(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int s0(int i10) {
        return z0(D0(i10));
    }

    public static int z0(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void B0(int i10) {
        Y(D0(i10));
    }

    public final void C0(int i10, int i11) {
        f0(i10, D0(i11));
    }

    public final void I() {
        if (b() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void J(double d10) {
        u(Double.doubleToRawLongBits(d10));
    }

    public final void K(float f10) {
        m(Float.floatToRawIntBits(f10));
    }

    public final void M(int i10, double d10) {
        o(i10, Double.doubleToRawLongBits(d10));
    }

    public final void N(int i10, float f10) {
        n(i10, Float.floatToRawIntBits(f10));
    }

    public final void u0(int i10, long j10) {
        P(i10, y0(j10));
    }

    public final void v0(long j10) {
        R(y0(j10));
    }
}
