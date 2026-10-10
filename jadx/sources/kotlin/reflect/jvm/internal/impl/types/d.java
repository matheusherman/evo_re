package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14269a = new d();

    private final boolean c(na.p pVar, na.i iVar, na.i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        na.k kVarA = pVar.a(iVar);
        na.k kVarA2 = pVar.a(iVar2);
        if (kVarA != null && kVarA2 != null) {
            return a(pVar, kVarA, kVarA2);
        }
        na.g gVarR0 = pVar.r0(iVar);
        na.g gVarR1 = pVar.r0(iVar2);
        return gVarR0 != null && gVarR1 != null && a(pVar, pVar.c(gVarR0), pVar.c(gVarR1)) && a(pVar, pVar.e(gVarR0), pVar.e(gVarR1));
    }

    public final boolean b(na.p context, na.i a10, na.i b10) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        return c(context, a10, b10);
    }

    private d() {
    }

    private final boolean a(na.p pVar, na.k kVar, na.k kVar2) {
        boolean z10;
        boolean z11;
        if (pVar.D0(kVar) == pVar.D0(kVar2) && pVar.h0(kVar) == pVar.h0(kVar2)) {
            if (pVar.x0(kVar) == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (pVar.x0(kVar2) == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 == z11 && pVar.S(pVar.f(kVar), pVar.f(kVar2))) {
                if (pVar.B0(kVar, kVar2)) {
                    return true;
                }
                int iD0 = pVar.D0(kVar);
                for (int i10 = 0; i10 < iD0; i10++) {
                    na.m mVarP = pVar.P(kVar, i10);
                    na.m mVarP2 = pVar.P(kVar2, i10);
                    if (pVar.o(mVarP) != pVar.o(mVarP2)) {
                        return false;
                    }
                    if (!pVar.o(mVarP) && (pVar.h(mVarP) != pVar.h(mVarP2) || !c(pVar, pVar.m(mVarP), pVar.m(mVarP2)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
