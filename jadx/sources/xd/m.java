package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final fc.u f22112g;

    protected int a() {
        return this.f22109d;
    }

    public fc.u b() {
        return this.f22112g;
    }

    protected int c() {
        return this.f22107b;
    }

    protected int d() {
        return this.f22108c;
    }

    protected m(fc.u uVar) {
        if (uVar != null) {
            this.f22112g = uVar;
            tc.i iVarA = f.a(uVar);
            int iH = a0.h(iVarA);
            this.f22107b = iH;
            this.f22108c = 16;
            int iCeil = (int) Math.ceil(((double) (iH * 8)) / ((double) a0.o(16)));
            this.f22110e = iCeil;
            int iFloor = ((int) Math.floor(a0.o((16 - 1) * iCeil) / a0.o(16))) + 1;
            this.f22111f = iFloor;
            int i10 = iCeil + iFloor;
            this.f22109d = i10;
            l lVarC = l.c(iVarA.a(), iH, 16, i10);
            this.f22106a = lVarC;
            if (lVarC != null) {
                return;
            }
            throw new IllegalArgumentException("cannot find OID for digest algorithm: " + iVarA.a());
        }
        throw new NullPointerException("treeDigest == null");
    }
}
