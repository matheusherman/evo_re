package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class da extends p8<Float> implements na<Float>, ac, RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f2608d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f2609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2610c;

    static {
        float[] fArr = new float[0];
        f2608d = fArr;
        new da(fArr, 0, false);
    }

    da() {
        this(f2608d, 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        float fFloatValue = ((Float) obj).floatValue();
        e();
        if (i10 < 0 || i10 > (i11 = this.f2610c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        float[] fArr = this.f2609b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[i(fArr.length)];
            System.arraycopy(this.f2609b, 0, fArr2, 0, i10);
            System.arraycopy(this.f2609b, i10, fArr2, i10 + 1, this.f2610c - i10);
            this.f2609b = fArr2;
        }
        this.f2609b[i10] = fFloatValue;
        this.f2610c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof da)) {
            return super.equals(obj);
        }
        da daVar = (da) obj;
        if (this.f2610c != daVar.f2610c) {
            return false;
        }
        float[] fArr = daVar.f2609b;
        for (int i10 = 0; i10 < this.f2610c; i10++) {
            if (Float.floatToIntBits(this.f2609b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.f2610c; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f2609b[i10]);
        }
        return iFloatToIntBits;
    }

    private da(float[] fArr, int i10, boolean z10) {
        super(z10);
        this.f2609b = fArr;
        this.f2610c = i10;
    }

    private static int i(int i10) {
        return Math.max(((i10 * 3) / 2) + 1, 10);
    }

    private final String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f2610c;
    }

    private final void m(int i10) {
        if (i10 < 0 || i10 >= this.f2610c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.na
    public final /* synthetic */ na<Float> a(int i10) {
        if (i10 >= this.f2610c) {
            return new da(i10 == 0 ? f2608d : Arrays.copyOf(this.f2609b, i10), this.f2610c, true);
        }
        throw new IllegalArgumentException();
    }

    final void h(int i10) {
        float[] fArr = this.f2609b;
        if (i10 <= fArr.length) {
            return;
        }
        if (fArr.length == 0) {
            this.f2609b = new float[Math.max(i10, 10)];
            return;
        }
        int length = fArr.length;
        while (length < i10) {
            length = i(length);
        }
        this.f2609b = Arrays.copyOf(this.f2609b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f2609b[i10] == fFloatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        e();
        m(i10);
        float[] fArr = this.f2609b;
        float f10 = fArr[i10];
        fArr[i10] = fFloatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2610c;
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        e();
        ga.e(collection);
        if (!(collection instanceof da)) {
            return super.addAll(collection);
        }
        da daVar = (da) collection;
        int i10 = daVar.f2610c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2610c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f2609b;
            if (i12 > fArr.length) {
                this.f2609b = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy(daVar.f2609b, 0, this.f2609b, this.f2610c, daVar.f2610c);
            this.f2610c = i12;
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

    public final void f(float f10) {
        e();
        int i10 = this.f2610c;
        float[] fArr = this.f2609b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[i(fArr.length)];
            System.arraycopy(this.f2609b, 0, fArr2, 0, this.f2610c);
            this.f2609b = fArr2;
        }
        float[] fArr3 = this.f2609b;
        int i11 = this.f2610c;
        this.f2610c = i11 + 1;
        fArr3[i11] = f10;
    }

    public final float g(int i10) {
        m(i10);
        return this.f2609b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Float.valueOf(g(i10));
    }

    @Override // com.google.android.gms.internal.measurement.p8, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        e();
        m(i10);
        float[] fArr = this.f2609b;
        float f10 = fArr[i10];
        int i11 = this.f2610c;
        if (i10 < i11 - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (i11 - i10) - 1);
        }
        this.f2610c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        e();
        if (i11 >= i10) {
            float[] fArr = this.f2609b;
            System.arraycopy(fArr, i11, fArr, i10, this.f2610c - i11);
            this.f2610c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Float) obj).floatValue());
        return true;
    }
}
