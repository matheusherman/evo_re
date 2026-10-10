package oe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f16577a;

    private boolean b(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i10 : iArr) {
            if (i10 < 0 || i10 >= length || zArr[i10]) {
                return false;
            }
            zArr[i10] = true;
        }
        return true;
    }

    public byte[] a() {
        int length = this.f16577a.length;
        int iA = e.a(length - 1);
        byte[] bArr = new byte[(length * iA) + 4];
        f.a(length, bArr, 0);
        for (int i10 = 0; i10 < length; i10++) {
            f.b(this.f16577a[i10], bArr, (i10 * iA) + 4, iA);
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return d.b(this.f16577a, ((h) obj).f16577a);
        }
        return false;
    }

    public int hashCode() {
        return re.a.o(this.f16577a);
    }

    public String toString() {
        String str = "[" + this.f16577a[0];
        for (int i10 = 1; i10 < this.f16577a.length; i10++) {
            str = str + ", " + this.f16577a[i10];
        }
        return str + "]";
    }

    public h(byte[] bArr) {
        if (bArr.length > 4) {
            int iE = f.e(bArr, 0);
            int iA = e.a(iE - 1);
            if (bArr.length == (iE * iA) + 4) {
                this.f16577a = new int[iE];
                for (int i10 = 0; i10 < iE; i10++) {
                    this.f16577a[i10] = f.f(bArr, (i10 * iA) + 4, iA);
                }
                if (b(this.f16577a)) {
                    return;
                } else {
                    throw new IllegalArgumentException("invalid encoding");
                }
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }
}
