package y3;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t extends y {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final y f22379i = new i();

    @Override // y3.r, h3.o
    public h3.q a(h3.c cVar) {
        return s(this.f22379i.a(cVar));
    }

    @Override // y3.r, h3.o
    public h3.q b(h3.c cVar, Map<h3.e, ?> map) {
        return s(this.f22379i.b(cVar, map));
    }

    @Override // y3.y, y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) {
        return s(this.f22379i.c(i10, aVar, map));
    }

    @Override // y3.y
    protected int l(p3.a aVar, int[] iArr, StringBuilder sb2) {
        return this.f22379i.l(aVar, iArr, sb2);
    }

    @Override // y3.y
    public h3.q m(int i10, p3.a aVar, int[] iArr, Map<h3.e, ?> map) {
        return s(this.f22379i.m(i10, aVar, iArr, map));
    }

    @Override // y3.y
    h3.a q() {
        return h3.a.UPC_A;
    }

    private static h3.q s(h3.q qVar) throws h3.h {
        String strF = qVar.f();
        if (strF.charAt(0) == '0') {
            h3.q qVar2 = new h3.q(strF.substring(1), null, qVar.e(), h3.a.UPC_A);
            if (qVar.d() != null) {
                qVar2.g(qVar.d());
            }
            return qVar2;
        }
        throw h3.h.a();
    }
}
