package d4;

import h3.m;
import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f9603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f9604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f9605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f9606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f9607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9611i;

    c(p3.b bVar, s sVar, s sVar2, s sVar3, s sVar4) throws m {
        boolean z10 = sVar == null || sVar2 == null;
        boolean z11 = sVar3 == null || sVar4 == null;
        if (z10 && z11) {
            throw m.a();
        }
        if (z10) {
            sVar = new s(0.0f, sVar3.d());
            sVar2 = new s(0.0f, sVar4.d());
        } else if (z11) {
            sVar3 = new s(bVar.n() - 1, sVar.d());
            sVar4 = new s(bVar.n() - 1, sVar2.d());
        }
        this.f9603a = bVar;
        this.f9604b = sVar;
        this.f9605c = sVar2;
        this.f9606d = sVar3;
        this.f9607e = sVar4;
        this.f9608f = (int) Math.min(sVar.c(), sVar2.c());
        this.f9609g = (int) Math.max(sVar3.c(), sVar4.c());
        this.f9610h = (int) Math.min(sVar.d(), sVar3.d());
        this.f9611i = (int) Math.max(sVar2.d(), sVar4.d());
    }

    static c j(c cVar, c cVar2) {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.f9603a, cVar.f9604b, cVar.f9605c, cVar2.f9606d, cVar2.f9607e);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    c a(int i10, int i11, boolean z10) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        int iD;
        s sVar6;
        s sVar7 = this.f9604b;
        s sVar8 = this.f9605c;
        s sVar9 = this.f9606d;
        s sVar10 = this.f9607e;
        if (i10 > 0) {
            s sVar11 = z10 ? sVar7 : sVar9;
            int iD2 = ((int) sVar11.d()) - i10;
            if (iD2 < 0) {
                iD2 = 0;
            }
            s sVar12 = new s(sVar11.c(), iD2);
            if (z10) {
                sVar = sVar12;
            } else {
                sVar2 = sVar12;
                sVar = sVar7;
            }
            if (i11 > 0) {
                if (z10) {
                    sVar5 = this.f9605c;
                } else {
                    sVar5 = this.f9607e;
                }
                iD = ((int) sVar5.d()) + i11;
                if (iD >= this.f9603a.k()) {
                    iD = this.f9603a.k() - 1;
                }
                sVar6 = new s(sVar5.c(), iD);
                if (z10) {
                    sVar3 = sVar6;
                } else {
                    sVar4 = sVar6;
                    sVar3 = sVar8;
                }
                return new c(this.f9603a, sVar, sVar3, sVar2, sVar4);
            }
            sVar3 = sVar8;
            sVar4 = sVar10;
            return new c(this.f9603a, sVar, sVar3, sVar2, sVar4);
        }
        sVar = sVar7;
        sVar2 = sVar9;
        if (i11 > 0) {
            if (z10) {
                sVar5 = this.f9605c;
            } else {
                sVar5 = this.f9607e;
            }
            iD = ((int) sVar5.d()) + i11;
            if (iD >= this.f9603a.k()) {
                iD = this.f9603a.k() - 1;
            }
            sVar6 = new s(sVar5.c(), iD);
            if (z10) {
                sVar3 = sVar6;
            } else {
                sVar4 = sVar6;
                sVar3 = sVar8;
            }
            return new c(this.f9603a, sVar, sVar3, sVar2, sVar4);
        }
        sVar3 = sVar8;
        sVar4 = sVar10;
        return new c(this.f9603a, sVar, sVar3, sVar2, sVar4);
    }

    s b() {
        return this.f9605c;
    }

    s c() {
        return this.f9607e;
    }

    int d() {
        return this.f9609g;
    }

    int e() {
        return this.f9611i;
    }

    int f() {
        return this.f9608f;
    }

    int g() {
        return this.f9610h;
    }

    s h() {
        return this.f9604b;
    }

    s i() {
        return this.f9606d;
    }

    c(c cVar) {
        this.f9603a = cVar.f9603a;
        this.f9604b = cVar.f9604b;
        this.f9605c = cVar.f9605c;
        this.f9606d = cVar.f9606d;
        this.f9607e = cVar.f9607e;
        this.f9608f = cVar.f9608f;
        this.f9609g = cVar.f9609g;
        this.f9610h = cVar.f9610h;
        this.f9611i = cVar.f9611i;
    }
}
