package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f2 extends j {
    public f2(g gVar) {
        this(g2.a(gVar));
    }

    public f2(u uVar, p pVar, z zVar, int i10, z zVar2) {
        super(uVar, pVar, zVar, i10, zVar2);
    }

    @Override // fc.j
    c0 x() {
        g gVar = new g(4);
        u uVar = this.f10169a;
        if (uVar != null) {
            gVar.a(uVar);
        }
        p pVar = this.f10170b;
        if (pVar != null) {
            gVar.a(pVar);
        }
        z zVar = this.f10171c;
        if (zVar != null) {
            gVar.a(zVar.w());
        }
        int i10 = this.f10172d;
        gVar.a(new m2(i10 == 0, i10, this.f10173e));
        return new i2(gVar);
    }

    public f2(i2 i2Var) {
        super(i2Var);
    }

    @Override // fc.j, fc.z
    z w() {
        return this;
    }
}
