package pe;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17582b;

    public int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f17581a == aVar.f17581a && this.f17582b == aVar.f17582b) {
                return true;
            }
        }
        return false;
    }

    private static String c(int i10) {
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
        for (int i11 = 0; i11 < this.f17581a; i11++) {
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

    public int hashCode() {
        return this.f17582b;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f17581a + ") = GF(2)[X]/<" + c(this.f17582b) + "> ";
    }

    public a(int i10) {
        this.f17581a = 0;
        if (i10 < 32) {
            if (i10 >= 1) {
                this.f17581a = i10;
                this.f17582b = d.c(i10);
                return;
            }
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
        throw new IllegalArgumentException(" Error: the degree of field is too large ");
    }
}
