package wb;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final vb.a f20462h = vb.a.LENIENT;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final byte[] f20463i = {13, 10};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected final byte f20464a = 61;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte f20465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f20468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final vb.a f20470g;

    protected boolean c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b10 : bArr) {
            if (this.f20465b == b10 || n(b10)) {
                return true;
            }
        }
        return false;
    }

    abstract void e(byte[] bArr, int i10, int i11, a aVar);

    abstract void h(byte[] bArr, int i10, int i11, a aVar);

    public long m(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f20466c;
        long j10 = ((long) (((length + i10) - 1) / i10)) * ((long) this.f20467d);
        int i11 = this.f20468e;
        return i11 > 0 ? j10 + ((((((long) i11) + j10) - 1) / ((long) i11)) * ((long) this.f20469f)) : j10;
    }

    protected abstract boolean n(byte b10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f20472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte[] f20473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f20475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f20476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f20477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f20478h;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.f20473c), Integer.valueOf(this.f20477g), Boolean.valueOf(this.f20476f), Integer.valueOf(this.f20471a), Long.valueOf(this.f20472b), Integer.valueOf(this.f20478h), Integer.valueOf(this.f20474d), Integer.valueOf(this.f20475e));
        }
    }

    private static int b(int i10, int i11) {
        return Integer.compare(i10 - Integer.MIN_VALUE, i11 - Integer.MIN_VALUE);
    }

    private static int d(int i10) {
        if (i10 >= 0) {
            if (i10 > 2147483639) {
                return i10;
            }
            return 2147483639;
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (((long) i10) & 4294967295L));
    }

    private static byte[] q(a aVar, int i10) {
        int length = aVar.f20473c.length * 2;
        if (b(length, i10) < 0) {
            length = i10;
        }
        if (b(length, 2147483639) > 0) {
            length = d(i10);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = aVar.f20473c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        aVar.f20473c = bArr;
        return bArr;
    }

    int a(a aVar) {
        if (aVar.f20473c != null) {
            return aVar.f20474d - aVar.f20475e;
        }
        return 0;
    }

    public byte[] g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        e(bArr, 0, bArr.length, aVar);
        e(bArr, 0, -1, aVar);
        int i10 = aVar.f20474d;
        byte[] bArr2 = new byte[i10];
        p(bArr2, 0, i10, aVar);
        return bArr2;
    }

    public byte[] i(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : j(bArr, 0, bArr.length);
    }

    public byte[] j(byte[] bArr, int i10, int i11) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        h(bArr, i10, i11, aVar);
        h(bArr, i10, -1, aVar);
        int i12 = aVar.f20474d - aVar.f20475e;
        byte[] bArr2 = new byte[i12];
        p(bArr2, 0, i12, aVar);
        return bArr2;
    }

    protected byte[] k(int i10, a aVar) {
        byte[] bArr = aVar.f20473c;
        if (bArr == null) {
            aVar.f20473c = new byte[Math.max(i10, l())];
            aVar.f20474d = 0;
            aVar.f20475e = 0;
        } else {
            int i11 = aVar.f20474d;
            if ((i11 + i10) - bArr.length > 0) {
                return q(aVar, i11 + i10);
            }
        }
        return aVar.f20473c;
    }

    protected int l() {
        return 8192;
    }

    public boolean o() {
        return this.f20470g == vb.a.STRICT;
    }

    int p(byte[] bArr, int i10, int i11, a aVar) {
        if (aVar.f20473c == null) {
            return aVar.f20476f ? -1 : 0;
        }
        int iMin = Math.min(a(aVar), i11);
        System.arraycopy(aVar.f20473c, aVar.f20475e, bArr, i10, iMin);
        int i12 = aVar.f20475e + iMin;
        aVar.f20475e = i12;
        if (i12 >= aVar.f20474d) {
            aVar.f20473c = null;
        }
        return iMin;
    }

    protected b(int i10, int i11, int i12, int i13, byte b10, vb.a aVar) {
        int i14;
        this.f20466c = i10;
        this.f20467d = i11;
        if (i12 > 0 && i13 > 0) {
            i14 = (i12 / i11) * i11;
        } else {
            i14 = 0;
        }
        this.f20468e = i14;
        this.f20469f = i13;
        this.f20465b = b10;
        Objects.requireNonNull(aVar, "codecPolicy");
        this.f20470g = aVar;
    }

    public byte[] f(String str) {
        return g(c.b(str));
    }
}
