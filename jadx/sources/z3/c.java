package z3;

import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f22659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s[] f22660c;

    public s[] a() {
        return this.f22660c;
    }

    public int[] b() {
        return this.f22659b;
    }

    public int c() {
        return this.f22658a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f22658a == ((c) obj).f22658a;
    }

    public int hashCode() {
        return this.f22658a;
    }

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f22658a = i10;
        this.f22659b = iArr;
        float f10 = i11;
        float f11 = i13;
        this.f22660c = new s[]{new s(f10, f11), new s(i12, f11)};
    }
}
