package oe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16567b;

    public int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public int c(int i10, int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i11 < 0) {
            i10 = f(i10);
            i11 = -i11;
        }
        int iH = 1;
        while (i11 != 0) {
            if ((i11 & 1) == 1) {
                iH = h(iH, i10);
            }
            i10 = h(i10, i10);
            i11 >>>= 1;
        }
        return iH;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.f16566a == bVar.f16566a && this.f16567b == bVar.f16567b) {
                return true;
            }
        }
        return false;
    }

    public int f(int i10) {
        return c(i10, (1 << this.f16566a) - 2);
    }

    private static String i(int i10) {
        if (i10 == 0) {
            return "0";
        }
        String str = ((byte) (i10 & 1)) == 1 ? "1" : "";
        int i11 = i10 >>> 1;
        int i12 = 1;
        while (i11 != 0) {
            if (((byte) (i11 & 1)) == 1) {
                str = str + "+x^" + i12;
            }
            i11 >>>= 1;
            i12++;
        }
        return str;
    }

    public String b(int i10) {
        StringBuilder sb2;
        String str;
        String string = "";
        for (int i11 = 0; i11 < this.f16566a; i11++) {
            if ((((byte) i10) & 1) == 0) {
                sb2 = new StringBuilder();
                str = "0";
            } else {
                sb2 = new StringBuilder();
                str = "1";
            }
            sb2.append(str);
            sb2.append(string);
            string = sb2.toString();
            i10 >>>= 1;
        }
        return string;
    }

    public int d() {
        return this.f16566a;
    }

    public byte[] e() {
        return f.c(this.f16567b);
    }

    public boolean g(int i10) {
        int i11 = this.f16566a;
        if (i11 == 31) {
            return i10 >= 0;
        }
        return i10 >= 0 && i10 < (1 << i11);
    }

    public int h(int i10, int i11) {
        return j.d(i10, i11, this.f16567b);
    }

    public int hashCode() {
        return this.f16567b;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f16566a + ") = GF(2)[X]/<" + i(this.f16567b) + "> ";
    }

    public b(byte[] bArr) {
        this.f16566a = 0;
        if (bArr.length == 4) {
            int iD = f.d(bArr);
            this.f16567b = iD;
            if (j.c(iD)) {
                this.f16566a = j.a(this.f16567b);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }
}
