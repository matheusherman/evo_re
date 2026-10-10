package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ha extends p8<Integer> implements la, ac, RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f2750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ha f2751e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f2752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2753c;

    static {
        int[] iArr = new int[0];
        f2750d = iArr;
        f2751e = new ha(iArr, 0, false);
    }

    ha() {
        this(f2750d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        int iIntValue = ((Integer) obj).intValue();
        e();
        if (i10 < 0 || i10 > (i11 = this.f2753c)) {
            throw new IndexOutOfBoundsException(m(i10));
        }
        int[] iArr = this.f2752b;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
        } else {
            int[] iArr2 = new int[k(iArr.length)];
            System.arraycopy(this.f2752b, 0, iArr2, 0, i10);
            System.arraycopy(this.f2752b, i10, iArr2, i10 + 1, this.f2753c - i10);
            this.f2752b = iArr2;
        }
        this.f2752b[i10] = iIntValue;
        this.f2753c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ha)) {
            return super.equals(obj);
        }
        ha haVar = (ha) obj;
        if (this.f2753c != haVar.f2753c) {
            return false;
        }
        int[] iArr = haVar.f2752b;
        for (int i10 = 0; i10 < this.f2753c; i10++) {
            if (this.f2752b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f2753c; i11++) {
            i10 = (i10 * 31) + this.f2752b[i11];
        }
        return i10;
    }

    private ha(int[] iArr, int i10, boolean z10) {
        super(z10);
        this.f2752b = iArr;
        this.f2753c = i10;
    }

    public static ha g() {
        return f2751e;
    }

    private static int k(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    private final String m(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2753c;
    }

    private final void n(int i10) {
        if (i10 < 0 || i10 >= this.f2753c) {
            throw new IndexOutOfBoundsException(m(i10));
        }
    }

    final void i(int i10) {
        int[] iArr = this.f2752b;
        if (i10 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.f2752b = new int[Math.max(i10, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i10) {
            length = k(length);
        }
        this.f2752b = Arrays.copyOf(this.f2752b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f2752b[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.na
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final la a(int i10) {
        if (i10 >= this.f2753c) {
            return new ha(i10 == 0 ? f2750d : Arrays.copyOf(this.f2752b, i10), this.f2753c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        e();
        n(i10);
        int[] iArr = this.f2752b;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2753c;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        e();
        ga.e(collection);
        if (!(collection instanceof ha)) {
            return super.addAll(collection);
        }
        ha haVar = (ha) collection;
        int i10 = haVar.f2753c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2753c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f2752b;
            if (i12 > iArr.length) {
                this.f2752b = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy(haVar.f2752b, 0, this.f2752b, this.f2753c, haVar.f2753c);
            this.f2753c = i12;
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

    public final int f(int i10) {
        n(i10);
        return this.f2752b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Integer.valueOf(f(i10));
    }

    public final void h(int i10) {
        e();
        int i11 = this.f2753c;
        int[] iArr = this.f2752b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[k(iArr.length)];
            System.arraycopy(this.f2752b, 0, iArr2, 0, this.f2753c);
            this.f2752b = iArr2;
        }
        int[] iArr3 = this.f2752b;
        int i12 = this.f2753c;
        this.f2753c = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        e();
        n(i10);
        int[] iArr = this.f2752b;
        int i11 = iArr[i10];
        int i12 = this.f2753c;
        if (i10 < i12 - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (i12 - i10) - 1);
        }
        this.f2753c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        e();
        if (i11 >= i10) {
            int[] iArr = this.f2752b;
            System.arraycopy(iArr, i11, iArr, i10, this.f2753c - i11);
            this.f2753c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }
}
