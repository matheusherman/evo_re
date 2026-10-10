package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final m0 f10158c = new a(h.class, 10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h[] f10159d = new h[12];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10161b;

    static h x(byte[] bArr, boolean z10) {
        if (bArr.length > 1) {
            return new h(bArr, z10);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i10 = bArr[0] & 255;
        h[] hVarArr = f10159d;
        if (i10 >= hVarArr.length) {
            return new h(bArr, z10);
        }
        h hVar = hVarArr[i10];
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(bArr, z10);
        hVarArr[i10] = hVar2;
        return hVar2;
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return h.x(q1Var.A(), false);
        }
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return re.a.l(this.f10160a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof h) {
            return re.a.a(this.f10160a, ((h) zVar).f10160a);
        }
        return false;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 10, this.f10160a);
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10160a.length);
    }

    h(byte[] bArr, boolean z10) {
        byte[] bArrD;
        if (!p.E(bArr)) {
            if ((bArr[0] & 128) == 0) {
                if (z10) {
                    bArrD = re.a.d(bArr);
                } else {
                    bArrD = bArr;
                }
                this.f10160a = bArrD;
                this.f10161b = p.J(bArr);
                return;
            }
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        throw new IllegalArgumentException("malformed enumerated");
    }
}
