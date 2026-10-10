package me;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short[][][] f15798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private short[][][] f15799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[][] f15800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short[] f15801g;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f15795a == aVar.f() && this.f15796b == aVar.g() && this.f15797c == aVar.e() && ne.a.k(this.f15798d, aVar.a()) && ne.a.k(this.f15799e, aVar.b()) && ne.a.j(this.f15800f, aVar.d()) && ne.a.i(this.f15801g, aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public short[][][] a() {
        return this.f15798d;
    }

    public short[][][] b() {
        return this.f15799e;
    }

    public short[] c() {
        return this.f15801g;
    }

    public short[][] d() {
        return this.f15800f;
    }

    public int e() {
        return this.f15797c;
    }

    public int f() {
        return this.f15795a;
    }

    public int g() {
        return this.f15796b;
    }

    public int hashCode() {
        return (((((((((((this.f15795a * 37) + this.f15796b) * 37) + this.f15797c) * 37) + re.a.r(this.f15798d)) * 37) + re.a.r(this.f15799e)) * 37) + re.a.q(this.f15800f)) * 37) + re.a.p(this.f15801g);
    }

    public a(byte b10, byte b11, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i10 = b10 & 255;
        this.f15795a = i10;
        int i11 = b11 & 255;
        this.f15796b = i11;
        this.f15797c = i11 - i10;
        this.f15798d = sArr;
        this.f15799e = sArr2;
        this.f15800f = sArr3;
        this.f15801g = sArr4;
    }
}
