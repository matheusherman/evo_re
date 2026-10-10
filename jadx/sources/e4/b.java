package e4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9879f = new b(929, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f9880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f9881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f9882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f9883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9884e;

    int a(int i10, int i11) {
        return (i10 + i11) % this.f9884e;
    }

    c b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f9882c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new c(this, iArr);
    }

    int c(int i10) {
        return this.f9880a[i10];
    }

    c d() {
        return this.f9883d;
    }

    int e() {
        return this.f9884e;
    }

    c f() {
        return this.f9882c;
    }

    int g(int i10) {
        if (i10 != 0) {
            return this.f9880a[(this.f9884e - this.f9881b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i10) {
        if (i10 != 0) {
            return this.f9881b[i10];
        }
        throw new IllegalArgumentException();
    }

    int i(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f9880a;
        int[] iArr2 = this.f9881b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f9884e - 1)];
    }

    int j(int i10, int i11) {
        int i12 = this.f9884e;
        return ((i10 + i12) - i11) % i12;
    }

    private b(int i10, int i11) {
        this.f9884e = i10;
        this.f9880a = new int[i10];
        this.f9881b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f9880a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f9881b[this.f9880a[i14]] = i14;
        }
        this.f9882c = new c(this, new int[]{0});
        this.f9883d = new c(this, new int[]{1});
    }
}
