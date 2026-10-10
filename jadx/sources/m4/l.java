package m4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15645c;

    @Override // m4.f
    protected h3.c e(h3.j jVar) {
        if (this.f15645c) {
            this.f15645c = false;
            return new h3.c(new p3.m(jVar.e()));
        }
        this.f15645c = true;
        return new h3.c(new p3.m(jVar));
    }

    public l(h3.o oVar) {
        super(oVar);
        this.f15645c = true;
    }
}
