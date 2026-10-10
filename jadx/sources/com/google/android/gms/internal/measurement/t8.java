package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class t8 extends p8<Boolean> implements na<Boolean>, ac, RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean[] f3077d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f3078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3079c;

    static {
        boolean[] zArr = new boolean[0];
        f3077d = zArr;
        new t8(zArr, 0, false);
    }

    t8() {
        this(f3077d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        e();
        if (i10 < 0 || i10 > (i11 = this.f3079c)) {
            throw new IndexOutOfBoundsException(i(i10));
        }
        boolean[] zArr = this.f3078b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[h(zArr.length)];
            System.arraycopy(this.f3078b, 0, zArr2, 0, i10);
            System.arraycopy(this.f3078b, i10, zArr2, i10 + 1, this.f3079c - i10);
            this.f3078b = zArr2;
        }
        this.f3078b[i10] = zBooleanValue;
        this.f3079c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t8)) {
            return super.equals(obj);
        }
        t8 t8Var = (t8) obj;
        if (this.f3079c != t8Var.f3079c) {
            return false;
        }
        boolean[] zArr = t8Var.f3078b;
        for (int i10 = 0; i10 < this.f3079c; i10++) {
            if (this.f3078b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iC = 1;
        for (int i10 = 0; i10 < this.f3079c; i10++) {
            iC = (iC * 31) + ga.c(this.f3078b[i10]);
        }
        return iC;
    }

    private t8(boolean[] zArr, int i10, boolean z10) {
        super(z10);
        this.f3078b = zArr;
        this.f3079c = i10;
    }

    private static int h(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    private final String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f3079c;
    }

    private final void k(int i10) {
        if (i10 < 0 || i10 >= this.f3079c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.na
    public final /* synthetic */ na<Boolean> a(int i10) {
        if (i10 >= this.f3079c) {
            return new t8(i10 == 0 ? f3077d : Arrays.copyOf(this.f3078b, i10), this.f3079c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f3078b[i10] == zBooleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        e();
        k(i10);
        boolean[] zArr = this.f3078b;
        boolean z10 = zArr[i10];
        zArr[i10] = zBooleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3079c;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        e();
        ga.e(collection);
        if (!(collection instanceof t8)) {
            return super.addAll(collection);
        }
        t8 t8Var = (t8) collection;
        int i10 = t8Var.f3079c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3079c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f3078b;
            if (i12 > zArr.length) {
                this.f3078b = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy(t8Var.f3078b, 0, this.f3078b, this.f3079c, t8Var.f3079c);
            this.f3079c = i12;
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

    public final void f(boolean z10) {
        e();
        int i10 = this.f3079c;
        boolean[] zArr = this.f3078b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[h(zArr.length)];
            System.arraycopy(this.f3078b, 0, zArr2, 0, this.f3079c);
            this.f3078b = zArr2;
        }
        boolean[] zArr3 = this.f3078b;
        int i11 = this.f3079c;
        this.f3079c = i11 + 1;
        zArr3[i11] = z10;
    }

    public final boolean g(int i10) {
        k(i10);
        return this.f3078b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Boolean.valueOf(g(i10));
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        e();
        k(i10);
        boolean[] zArr = this.f3078b;
        boolean z10 = zArr[i10];
        int i11 = this.f3079c;
        if (i10 < i11 - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (i11 - i10) - 1);
        }
        this.f3079c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        e();
        if (i11 >= i10) {
            boolean[] zArr = this.f3078b;
            System.arraycopy(zArr, i11, zArr, i10, this.f3079c - i11);
            this.f3079c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Boolean) obj).booleanValue());
        return true;
    }
}
