package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final f[] f10150d = new f[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f[] f10151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10153c;

    public g() {
        this(10);
    }

    static f[] b(f[] fVarArr) {
        return fVarArr.length < 1 ? f10150d : (f[]) fVarArr.clone();
    }

    public g(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f10151a = i10 == 0 ? f10150d : new f[i10];
        this.f10152b = 0;
        this.f10153c = false;
    }

    private void e(int i10) {
        f[] fVarArr = new f[Math.max(this.f10151a.length, i10 + (i10 >> 1))];
        System.arraycopy(this.f10151a, 0, fVarArr, 0, this.f10152b);
        this.f10151a = fVarArr;
        this.f10153c = false;
    }

    public void a(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        int length = this.f10151a.length;
        int i10 = this.f10152b + 1;
        if (this.f10153c | (i10 > length)) {
            e(i10);
        }
        this.f10151a[this.f10152b] = fVar;
        this.f10152b = i10;
    }

    f[] c() {
        int i10 = this.f10152b;
        if (i10 == 0) {
            return f10150d;
        }
        f[] fVarArr = new f[i10];
        System.arraycopy(this.f10151a, 0, fVarArr, 0, i10);
        return fVarArr;
    }

    public f d(int i10) {
        if (i10 < this.f10152b) {
            return this.f10151a[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10 + " >= " + this.f10152b);
    }

    public int f() {
        return this.f10152b;
    }

    f[] g() {
        int i10 = this.f10152b;
        if (i10 == 0) {
            return f10150d;
        }
        f[] fVarArr = this.f10151a;
        if (fVarArr.length == i10) {
            this.f10153c = true;
            return fVarArr;
        }
        f[] fVarArr2 = new f[i10];
        System.arraycopy(fVarArr, 0, fVarArr2, 0, i10);
        return fVarArr2;
    }
}
