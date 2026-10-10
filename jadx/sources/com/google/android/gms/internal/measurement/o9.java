package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o9 extends p8<Double> implements na<Double>, ac, RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double[] f2915d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f2916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2917c;

    static {
        double[] dArr = new double[0];
        f2915d = dArr;
        new o9(dArr, 0, false);
    }

    o9() {
        this(f2915d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        double dDoubleValue = ((Double) obj).doubleValue();
        e();
        if (i10 < 0 || i10 > (i11 = this.f2917c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        double[] dArr = this.f2916b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[i(dArr.length)];
            System.arraycopy(this.f2916b, 0, dArr2, 0, i10);
            System.arraycopy(this.f2916b, i10, dArr2, i10 + 1, this.f2917c - i10);
            this.f2916b = dArr2;
        }
        this.f2916b[i10] = dDoubleValue;
        this.f2917c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o9)) {
            return super.equals(obj);
        }
        o9 o9Var = (o9) obj;
        if (this.f2917c != o9Var.f2917c) {
            return false;
        }
        double[] dArr = o9Var.f2916b;
        for (int i10 = 0; i10 < this.f2917c; i10++) {
            if (Double.doubleToLongBits(this.f2916b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i10 = 0; i10 < this.f2917c; i10++) {
            iB = (iB * 31) + ga.b(Double.doubleToLongBits(this.f2916b[i10]));
        }
        return iB;
    }

    private o9(double[] dArr, int i10, boolean z10) {
        super(z10);
        this.f2916b = dArr;
        this.f2917c = i10;
    }

    private static int i(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    private final String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2917c;
    }

    private final void m(int i10) {
        if (i10 < 0 || i10 >= this.f2917c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.na
    public final /* synthetic */ na<Double> a(int i10) {
        if (i10 >= this.f2917c) {
            return new o9(i10 == 0 ? f2915d : Arrays.copyOf(this.f2916b, i10), this.f2917c, true);
        }
        throw new IllegalArgumentException();
    }

    final void h(int i10) {
        double[] dArr = this.f2916b;
        if (i10 <= dArr.length) {
            return;
        }
        if (dArr.length == 0) {
            this.f2916b = new double[Math.max(i10, 10)];
            return;
        }
        int length = dArr.length;
        while (length < i10) {
            length = i(length);
        }
        this.f2916b = Arrays.copyOf(this.f2916b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f2916b[i10] == dDoubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        e();
        m(i10);
        double[] dArr = this.f2916b;
        double d10 = dArr[i10];
        dArr[i10] = dDoubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2917c;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        e();
        ga.e(collection);
        if (!(collection instanceof o9)) {
            return super.addAll(collection);
        }
        o9 o9Var = (o9) collection;
        int i10 = o9Var.f2917c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2917c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            double[] dArr = this.f2916b;
            if (i12 > dArr.length) {
                this.f2916b = Arrays.copyOf(dArr, i12);
            }
            System.arraycopy(o9Var.f2916b, 0, this.f2916b, this.f2917c, o9Var.f2917c);
            this.f2917c = i12;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void f(double d10) {
        e();
        int i10 = this.f2917c;
        double[] dArr = this.f2916b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[i(dArr.length)];
            System.arraycopy(this.f2916b, 0, dArr2, 0, this.f2917c);
            this.f2916b = dArr2;
        }
        double[] dArr3 = this.f2916b;
        int i11 = this.f2917c;
        this.f2917c = i11 + 1;
        dArr3[i11] = d10;
    }

    public final double g(int i10) {
        m(i10);
        return this.f2916b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Double.valueOf(g(i10));
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        e();
        m(i10);
        double[] dArr = this.f2916b;
        double d10 = dArr[i10];
        int i11 = this.f2917c;
        if (i10 < i11 - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (i11 - i10) - 1);
        }
        this.f2917c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        e();
        if (i11 >= i10) {
            double[] dArr = this.f2916b;
            System.arraycopy(dArr, i11, dArr, i10, this.f2917c - i11);
            this.f2917c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Double) obj).doubleValue());
        return true;
    }
}
