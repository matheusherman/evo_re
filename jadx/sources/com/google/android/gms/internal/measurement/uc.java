package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class uc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final uc f3106f = new uc(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f3108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f3109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3111e;

    private uc() {
        this(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof uc)) {
            return false;
        }
        uc ucVar = (uc) obj;
        int i10 = this.f3107a;
        if (i10 == ucVar.f3107a) {
            int[] iArr = this.f3108b;
            int[] iArr2 = ucVar.f3108b;
            for (int i11 = 0; i11 < i10; i11++) {
                if (iArr[i11] == iArr2[i11]) {
                }
            }
            Object[] objArr = this.f3109c;
            Object[] objArr2 = ucVar.f3109c;
            int i12 = this.f3107a;
            for (int i13 = 0; i13 < i12; i13++) {
                if (objArr[i13].equals(objArr2[i13])) {
                }
            }
            return true;
        }
        return false;
    }

    final void h(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f3107a; i11++) {
            pb.d(sb2, i10, String.valueOf(this.f3108b[i11] >>> 3), this.f3109c[i11]);
        }
    }

    private uc(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f3110d = -1;
        this.f3107a = i10;
        this.f3108b = iArr;
        this.f3109c = objArr;
        this.f3111e = z10;
    }

    static uc c(uc ucVar, uc ucVar2) {
        int i10 = ucVar.f3107a + ucVar2.f3107a;
        int[] iArrCopyOf = Arrays.copyOf(ucVar.f3108b, i10);
        System.arraycopy(ucVar2.f3108b, 0, iArrCopyOf, ucVar.f3107a, ucVar2.f3107a);
        Object[] objArrCopyOf = Arrays.copyOf(ucVar.f3109c, i10);
        System.arraycopy(ucVar2.f3109c, 0, objArrCopyOf, ucVar.f3107a, ucVar2.f3107a);
        return new uc(i10, iArrCopyOf, objArrCopyOf, true);
    }

    private final void d(int i10) {
        int[] iArr = this.f3108b;
        if (i10 > iArr.length) {
            int i11 = this.f3107a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f3108b = Arrays.copyOf(iArr, i10);
            this.f3109c = Arrays.copyOf(this.f3109c, i10);
        }
    }

    private static void f(int i10, Object obj, nd ndVar) {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        if (i12 == 0) {
            ndVar.e(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 1) {
            ndVar.w(i11, ((Long) obj).longValue());
            return;
        }
        if (i12 == 2) {
            ndVar.K(i11, (v8) obj);
            return;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new RuntimeException(ma.a());
            }
            ndVar.g(i11, ((Integer) obj).intValue());
        } else if (ndVar.b() == 1) {
            ndVar.l(i11);
            ((uc) obj).j(ndVar);
            ndVar.a(i11);
        } else {
            ndVar.a(i11);
            ((uc) obj).j(ndVar);
            ndVar.l(i11);
        }
    }

    public static uc k() {
        return f3106f;
    }

    static uc l() {
        return new uc();
    }

    private final void n() {
        if (!this.f3111e) {
            throw new UnsupportedOperationException();
        }
    }

    public final int a() {
        int iQ0;
        int i10 = this.f3110d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f3107a; i12++) {
            int i13 = this.f3108b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 == 0) {
                iQ0 = m9.q0(i14, ((Long) this.f3109c[i12]).longValue());
            } else if (i15 == 1) {
                iQ0 = m9.T(i14, ((Long) this.f3109c[i12]).longValue());
            } else if (i15 == 2) {
                iQ0 = m9.U(i14, (v8) this.f3109c[i12]);
            } else if (i15 == 3) {
                iQ0 = (m9.w0(i14) << 1) + ((uc) this.f3109c[i12]).a();
            } else {
                if (i15 != 5) {
                    throw new IllegalStateException(ma.a());
                }
                iQ0 = m9.l0(i14, ((Integer) this.f3109c[i12]).intValue());
            }
            i11 += iQ0;
        }
        this.f3110d = i11;
        return i11;
    }

    final uc b(uc ucVar) {
        if (ucVar.equals(f3106f)) {
            return this;
        }
        n();
        int i10 = this.f3107a + ucVar.f3107a;
        d(i10);
        System.arraycopy(ucVar.f3108b, 0, this.f3108b, this.f3107a, ucVar.f3107a);
        System.arraycopy(ucVar.f3109c, 0, this.f3109c, this.f3107a, ucVar.f3107a);
        this.f3107a = i10;
        return this;
    }

    public final int hashCode() {
        int i10 = this.f3107a;
        int i11 = (i10 + 527) * 31;
        int[] iArr = this.f3108b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i11 + i12) * 31;
        Object[] objArr = this.f3109c;
        int i15 = this.f3107a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public final int i() {
        int i10 = this.f3110d;
        if (i10 != -1) {
            return i10;
        }
        int iD0 = 0;
        for (int i11 = 0; i11 < this.f3107a; i11++) {
            iD0 += m9.d0(this.f3108b[i11] >>> 3, (v8) this.f3109c[i11]);
        }
        this.f3110d = iD0;
        return iD0;
    }

    public final void j(nd ndVar) {
        if (this.f3107a == 0) {
            return;
        }
        if (ndVar.b() == 1) {
            for (int i10 = 0; i10 < this.f3107a; i10++) {
                f(this.f3108b[i10], this.f3109c[i10], ndVar);
            }
            return;
        }
        for (int i11 = this.f3107a - 1; i11 >= 0; i11--) {
            f(this.f3108b[i11], this.f3109c[i11], ndVar);
        }
    }

    public final void m() {
        if (this.f3111e) {
            this.f3111e = false;
        }
    }

    final void e(int i10, Object obj) {
        n();
        d(this.f3107a + 1);
        int[] iArr = this.f3108b;
        int i11 = this.f3107a;
        iArr[i11] = i10;
        this.f3109c[i11] = obj;
        this.f3107a = i11 + 1;
    }

    final void g(nd ndVar) {
        if (ndVar.b() == 2) {
            for (int i10 = this.f3107a - 1; i10 >= 0; i10--) {
                ndVar.m(this.f3108b[i10] >>> 3, this.f3109c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f3107a; i11++) {
            ndVar.m(this.f3108b[i11] >>> 3, this.f3109c[i11]);
        }
    }
}
