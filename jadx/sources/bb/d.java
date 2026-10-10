package bb;

import eb.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h[] f1032a;

    @Override // bb.h
    public void a(eb.f fVar) {
        for (h hVar : this.f1032a) {
            hVar.a(fVar);
        }
    }

    @Override // bb.h
    public void b(j jVar) {
        for (h hVar : this.f1032a) {
            hVar.b(jVar);
        }
    }

    @Override // bb.h
    public void c(eb.g gVar) {
        for (h hVar : this.f1032a) {
            hVar.c(gVar);
        }
    }

    @Override // bb.h
    public void d(eb.h hVar) {
        for (h hVar2 : this.f1032a) {
            hVar2.d(hVar);
        }
    }

    public d(h... hVarArr) {
        this.f1032a = hVarArr;
    }
}
