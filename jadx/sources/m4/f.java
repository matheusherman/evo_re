package m4;

import h3.s;
import h3.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h3.o f15625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<s> f15626b = new ArrayList();

    @Override // h3.t
    public void a(s sVar) {
        this.f15626b.add(sVar);
    }

    protected h3.q b(h3.c cVar) {
        this.f15626b.clear();
        try {
            h3.o oVar = this.f15625a;
            return oVar instanceof h3.k ? ((h3.k) oVar).d(cVar) : oVar.a(cVar);
        } catch (Exception unused) {
            return null;
        } finally {
            this.f15625a.reset();
        }
    }

    public List<s> d() {
        return new ArrayList(this.f15626b);
    }

    protected h3.c e(h3.j jVar) {
        return new h3.c(new p3.m(jVar));
    }

    public f(h3.o oVar) {
        this.f15625a = oVar;
    }

    public h3.q c(h3.j jVar) {
        return b(e(jVar));
    }
}
