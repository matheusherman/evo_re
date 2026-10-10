package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class za extends p8<Long> implements ka, ac, RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f3319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final za f3320e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f3321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3322c;

    static {
        long[] jArr = new long[0];
        f3319d = jArr;
        f3320e = new za(jArr, 0, false);
    }

    za() {
        this(f3319d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        e();
        if (i10 < 0 || i10 > (i11 = this.f3322c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        long[] jArr = this.f3321b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[i(jArr.length)];
            System.arraycopy(this.f3321b, 0, jArr2, 0, i10);
            System.arraycopy(this.f3321b, i10, jArr2, i10 + 1, this.f3322c - i10);
            this.f3321b = jArr2;
        }
        this.f3321b[i10] = jLongValue;
        this.f3322c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof za)) {
            return super.equals(obj);
        }
        za zaVar = (za) obj;
        if (this.f3322c != zaVar.f3322c) {
            return false;
        }
        long[] jArr = zaVar.f3321b;
        for (int i10 = 0; i10 < this.f3322c; i10++) {
            if (this.f3321b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i10 = 0; i10 < this.f3322c; i10++) {
            iB = (iB * 31) + ga.b(this.f3321b[i10]);
        }
        return iB;
    }

    private za(long[] jArr, int i10, boolean z10) {
        super(z10);
        this.f3321b = jArr;
        this.f3322c = i10;
    }

    public static za g() {
        return f3320e;
    }

    private static int i(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    private final String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f3322c;
    }

    private final void m(int i10) {
        if (i10 < 0 || i10 >= this.f3322c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    final void h(int i10) {
        long[] jArr = this.f3321b;
        if (i10 <= jArr.length) {
            return;
        }
        if (jArr.length == 0) {
            this.f3321b = new long[Math.max(i10, 10)];
            return;
        }
        int length = jArr.length;
        while (length < i10) {
            length = i(length);
        }
        this.f3321b = Arrays.copyOf(this.f3321b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f3321b[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.na
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final ka a(int i10) {
        if (i10 >= this.f3322c) {
            return new za(i10 == 0 ? f3319d : Arrays.copyOf(this.f3321b, i10), this.f3322c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        e();
        m(i10);
        long[] jArr = this.f3321b;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3322c;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        e();
        ga.e(collection);
        if (!(collection instanceof za)) {
            return super.addAll(collection);
        }
        za zaVar = (za) collection;
        int i10 = zaVar.f3322c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3322c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f3321b;
            if (i12 > jArr.length) {
                this.f3321b = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy(zaVar.f3321b, 0, this.f3321b, this.f3322c, zaVar.f3322c);
            this.f3322c = i12;
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

    public final void f(long j10) {
        e();
        int i10 = this.f3322c;
        long[] jArr = this.f3321b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[i(jArr.length)];
            System.arraycopy(this.f3321b, 0, jArr2, 0, this.f3322c);
            this.f3321b = jArr2;
        }
        long[] jArr3 = this.f3321b;
        int i11 = this.f3322c;
        this.f3322c = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Long.valueOf(l(i10));
    }

    @Override // com.google.android.gms.internal.measurement.ka
    public final long l(int i10) {
        m(i10);
        return this.f3321b[i10];
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        e();
        m(i10);
        long[] jArr = this.f3321b;
        long j10 = jArr[i10];
        int i11 = this.f3322c;
        if (i10 < i11 - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (i11 - i10) - 1);
        }
        this.f3322c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        e();
        if (i11 >= i10) {
            long[] jArr = this.f3321b;
            System.arraycopy(jArr, i11, jArr, i10, this.f3322c - i11);
            this.f3322c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Long) obj).longValue());
        return true;
    }
}
