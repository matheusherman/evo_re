package tc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected byte[] f19097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f19098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f19099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected j f19100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f19101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f19102f;

    public b(a aVar) {
        boolean z10;
        this.f19099c = aVar;
        if (aVar instanceof j) {
            j jVar = (j) aVar;
            this.f19100d = jVar;
            this.f19097a = new byte[jVar.b()];
        } else {
            this.f19100d = null;
            this.f19097a = new byte[aVar.c()];
        }
        boolean z11 = false;
        this.f19098b = 0;
        String strA = aVar.a();
        int iIndexOf = strA.indexOf(47) + 1;
        if (iIndexOf > 0 && strA.startsWith("PGP", iIndexOf)) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f19102f = z10;
        if (!z10) {
            if (iIndexOf > 0 && strA.startsWith("OpenPGP", iIndexOf)) {
                z11 = true;
            }
            this.f19101e = z11;
            return;
        }
        this.f19101e = true;
    }
}
