package bc;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1048a = 0;

    public a g(Object obj, Object obj2) {
        return h(obj, obj2, null);
    }

    public a a(byte b10, byte b11) {
        int i10;
        if (this.f1048a != 0) {
            return this;
        }
        if (b10 < b11) {
            i10 = -1;
        } else {
            i10 = b10 > b11 ? 1 : 0;
        }
        this.f1048a = i10;
        return this;
    }

    public a b(char c10, char c11) {
        int i10;
        if (this.f1048a != 0) {
            return this;
        }
        if (c10 < c11) {
            i10 = -1;
        } else {
            i10 = c10 > c11 ? 1 : 0;
        }
        this.f1048a = i10;
        return this;
    }

    public a c(double d10, double d11) {
        if (this.f1048a != 0) {
            return this;
        }
        this.f1048a = Double.compare(d10, d11);
        return this;
    }

    public a d(float f10, float f11) {
        if (this.f1048a != 0) {
            return this;
        }
        this.f1048a = Float.compare(f10, f11);
        return this;
    }

    public a e(int i10, int i11) {
        int i12;
        if (this.f1048a != 0) {
            return this;
        }
        if (i10 < i11) {
            i12 = -1;
        } else {
            i12 = i10 > i11 ? 1 : 0;
        }
        this.f1048a = i12;
        return this;
    }

    public a f(long j10, long j11) {
        int i10;
        if (this.f1048a != 0) {
            return this;
        }
        if (j10 < j11) {
            i10 = -1;
        } else {
            i10 = j10 > j11 ? 1 : 0;
        }
        this.f1048a = i10;
        return this;
    }

    public a h(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.f1048a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.f1048a = -1;
            return this;
        }
        if (obj2 == null) {
            this.f1048a = 1;
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (comparator == null) {
                this.f1048a = ((Comparable) obj).compareTo(obj2);
                return this;
            }
            this.f1048a = comparator.compare(obj, obj2);
            return this;
        }
        if (obj instanceof long[]) {
            p((long[]) obj, (long[]) obj2);
            return this;
        }
        if (obj instanceof int[]) {
            o((int[]) obj, (int[]) obj2);
            return this;
        }
        if (obj instanceof short[]) {
            r((short[]) obj, (short[]) obj2);
            return this;
        }
        if (obj instanceof char[]) {
            l((char[]) obj, (char[]) obj2);
            return this;
        }
        if (obj instanceof byte[]) {
            k((byte[]) obj, (byte[]) obj2);
            return this;
        }
        if (obj instanceof double[]) {
            m((double[]) obj, (double[]) obj2);
            return this;
        }
        if (obj instanceof float[]) {
            n((float[]) obj, (float[]) obj2);
            return this;
        }
        if (obj instanceof boolean[]) {
            s((boolean[]) obj, (boolean[]) obj2);
            return this;
        }
        q((Object[]) obj, (Object[]) obj2, comparator);
        return this;
    }

    public a i(short s10, short s11) {
        int i10;
        if (this.f1048a != 0) {
            return this;
        }
        if (s10 < s11) {
            i10 = -1;
        } else {
            i10 = s10 > s11 ? 1 : 0;
        }
        this.f1048a = i10;
        return this;
    }

    public a j(boolean z10, boolean z11) {
        if (this.f1048a != 0 || z10 == z11) {
            return this;
        }
        if (z10) {
            this.f1048a = 1;
            return this;
        }
        this.f1048a = -1;
        return this;
    }

    public a k(byte[] bArr, byte[] bArr2) {
        if (this.f1048a == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (bArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (bArr.length != bArr2.length) {
                this.f1048a = bArr.length >= bArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < bArr.length && this.f1048a == 0; i10++) {
                a(bArr[i10], bArr2[i10]);
            }
        }
        return this;
    }

    public a l(char[] cArr, char[] cArr2) {
        if (this.f1048a == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (cArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (cArr.length != cArr2.length) {
                this.f1048a = cArr.length >= cArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < cArr.length && this.f1048a == 0; i10++) {
                b(cArr[i10], cArr2[i10]);
            }
        }
        return this;
    }

    public a m(double[] dArr, double[] dArr2) {
        if (this.f1048a == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (dArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (dArr.length != dArr2.length) {
                this.f1048a = dArr.length >= dArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < dArr.length && this.f1048a == 0; i10++) {
                c(dArr[i10], dArr2[i10]);
            }
        }
        return this;
    }

    public a n(float[] fArr, float[] fArr2) {
        if (this.f1048a == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (fArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (fArr.length != fArr2.length) {
                this.f1048a = fArr.length >= fArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < fArr.length && this.f1048a == 0; i10++) {
                d(fArr[i10], fArr2[i10]);
            }
        }
        return this;
    }

    public a o(int[] iArr, int[] iArr2) {
        if (this.f1048a == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (iArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (iArr.length != iArr2.length) {
                this.f1048a = iArr.length >= iArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < iArr.length && this.f1048a == 0; i10++) {
                e(iArr[i10], iArr2[i10]);
            }
        }
        return this;
    }

    public a p(long[] jArr, long[] jArr2) {
        if (this.f1048a == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (jArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (jArr.length != jArr2.length) {
                this.f1048a = jArr.length >= jArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < jArr.length && this.f1048a == 0; i10++) {
                f(jArr[i10], jArr2[i10]);
            }
        }
        return this;
    }

    public a q(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.f1048a == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (objArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (objArr.length != objArr2.length) {
                this.f1048a = objArr.length >= objArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < objArr.length && this.f1048a == 0; i10++) {
                h(objArr[i10], objArr2[i10], comparator);
            }
        }
        return this;
    }

    public a r(short[] sArr, short[] sArr2) {
        if (this.f1048a == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (sArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (sArr.length != sArr2.length) {
                this.f1048a = sArr.length >= sArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < sArr.length && this.f1048a == 0; i10++) {
                i(sArr[i10], sArr2[i10]);
            }
        }
        return this;
    }

    public a s(boolean[] zArr, boolean[] zArr2) {
        if (this.f1048a == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.f1048a = -1;
                return this;
            }
            if (zArr2 == null) {
                this.f1048a = 1;
                return this;
            }
            if (zArr.length != zArr2.length) {
                this.f1048a = zArr.length >= zArr2.length ? 1 : -1;
                return this;
            }
            for (int i10 = 0; i10 < zArr.length && this.f1048a == 0; i10++) {
                j(zArr[i10], zArr2[i10]);
            }
        }
        return this;
    }

    public int t() {
        return this.f1048a;
    }
}
