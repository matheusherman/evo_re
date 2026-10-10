package io.reactivex.rxjava3.internal.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f11492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f11493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f11494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f11495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    T[] f11496e;

    public d() {
        this(16, 0.75f);
    }

    public d(int i10, float f10) {
        this.f11492a = f10;
        int iA = e.a(i10);
        this.f11493b = iA - 1;
        this.f11495d = (int) (f10 * iA);
        this.f11496e = (T[]) new Object[iA];
    }

    public boolean a(T t10) {
        T t11;
        T[] tArr = this.f11496e;
        int i10 = this.f11493b;
        int iC = c(t10.hashCode()) & i10;
        T t12 = tArr[iC];
        if (t12 != null) {
            if (t12.equals(t10)) {
                return false;
            }
            do {
                iC = (iC + 1) & i10;
                t11 = tArr[iC];
                if (t11 == null) {
                }
            } while (!t11.equals(t10));
            return false;
        }
        tArr[iC] = t10;
        int i11 = this.f11494c + 1;
        this.f11494c = i11;
        if (i11 >= this.f11495d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f11496e;
    }

    void d() {
        T t10;
        T[] tArr = this.f11496e;
        int length = tArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        T[] tArr2 = (T[]) new Object[i10];
        int i12 = this.f11494c;
        while (true) {
            int i13 = i12 - 1;
            if (i12 == 0) {
                this.f11493b = i11;
                this.f11495d = (int) (i10 * this.f11492a);
                this.f11496e = tArr2;
                return;
            }
            do {
                length--;
                t10 = tArr[length];
            } while (t10 == null);
            int iC = c(t10.hashCode()) & i11;
            if (tArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i11;
                } while (tArr2[iC] != null);
            }
            tArr2[iC] = tArr[length];
            i12 = i13;
        }
    }

    public boolean e(T t10) {
        T t11;
        T[] tArr = this.f11496e;
        int i10 = this.f11493b;
        int iC = c(t10.hashCode()) & i10;
        T t12 = tArr[iC];
        if (t12 == null) {
            return false;
        }
        if (t12.equals(t10)) {
            return f(iC, tArr, i10);
        }
        do {
            iC = (iC + 1) & i10;
            t11 = tArr[iC];
            if (t11 == null) {
                return false;
            }
        } while (!t11.equals(t10));
        return f(iC, tArr, i10);
    }

    boolean f(int i10, T[] tArr, int i11) {
        int i12;
        T t10;
        this.f11494c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                t10 = tArr[i12];
                if (t10 != null) {
                    int iC = c(t10.hashCode()) & i11;
                    if (i10 > i12) {
                        if (i10 >= iC && iC > i12) {
                            break;
                        }
                        i13 = i12 + 1;
                    } else {
                        if (i10 >= iC || iC > i12) {
                            break;
                        }
                        i13 = i12 + 1;
                    }
                } else {
                    tArr[i10] = null;
                    return true;
                }
            }
            tArr[i10] = t10;
            i10 = i12;
        }
    }

    static int c(int i10) {
        int i11 = i10 * (-1640531527);
        return i11 ^ (i11 >>> 16);
    }
}
