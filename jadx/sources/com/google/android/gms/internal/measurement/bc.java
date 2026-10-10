package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class bc<E> extends p8<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object[] f2563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bc<Object> f2564e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private E[] f2565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2566c;

    static {
        Object[] objArr = new Object[0];
        f2563d = objArr;
        f2564e = new bc<>(objArr, 0, false);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        int i11;
        e();
        if (i10 < 0 || i10 > (i11 = this.f2566c)) {
            throw new IndexOutOfBoundsException(i(i10));
        }
        E[] eArr = this.f2565b;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] eArr2 = (E[]) new Object[g(eArr.length)];
            System.arraycopy(this.f2565b, 0, eArr2, 0, i10);
            System.arraycopy(this.f2565b, i10, eArr2, i10 + 1, this.f2566c - i10);
            this.f2565b = eArr2;
        }
        this.f2565b[i10] = e10;
        this.f2566c++;
        ((AbstractList) this).modCount++;
    }

    private static int g(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    public static <E> bc<E> h() {
        return (bc<E>) f2564e;
    }

    private final String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2566c;
    }

    private final void k(int i10) {
        if (i10 < 0 || i10 >= this.f2566c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.na
    public final /* synthetic */ na a(int i10) {
        if (i10 >= this.f2566c) {
            return new bc(i10 == 0 ? f2563d : Arrays.copyOf(this.f2565b, i10), this.f2566c, true);
        }
        throw new IllegalArgumentException();
    }

    final void f(int i10) {
        E[] eArr = this.f2565b;
        if (i10 <= eArr.length) {
            return;
        }
        if (eArr.length == 0) {
            this.f2565b = (E[]) new Object[Math.max(i10, 10)];
            return;
        }
        int length = eArr.length;
        while (length < i10) {
            length = g(length);
        }
        this.f2565b = (E[]) Arrays.copyOf(this.f2565b, length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2566c;
    }

    private bc(E[] eArr, int i10, boolean z10) {
        super(z10);
        this.f2565b = eArr;
        this.f2566c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        k(i10);
        return this.f2565b[i10];
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final E remove(int i10) {
        e();
        k(i10);
        E[] eArr = this.f2565b;
        E e10 = eArr[i10];
        int i11 = this.f2566c;
        if (i10 < i11 - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (i11 - i10) - 1);
        }
        this.f2566c--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        e();
        k(i10);
        E[] eArr = this.f2565b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        e();
        int i10 = this.f2566c;
        E[] eArr = this.f2565b;
        if (i10 == eArr.length) {
            this.f2565b = (E[]) Arrays.copyOf(this.f2565b, g(eArr.length));
        }
        E[] eArr2 = this.f2565b;
        int i11 = this.f2566c;
        this.f2566c = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }
}
