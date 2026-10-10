package xd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class v {
    static u b(k kVar, u uVar, u uVar2, o oVar) {
        if (uVar == null) {
            throw new NullPointerException("left == null");
        }
        if (uVar2 == null) {
            throw new NullPointerException("right == null");
        }
        if (uVar.a() != uVar2.a()) {
            throw new IllegalStateException("height of both nodes must be equal");
        }
        if (oVar == null) {
            throw new NullPointerException("address == null");
        }
        byte[] bArrF = kVar.f();
        if (oVar instanceof i) {
            i iVar = (i) oVar;
            oVar = (i) new i.b().g(iVar.b()).h(iVar.c()).n(iVar.e()).o(iVar.f()).p(iVar.g()).f(0).l();
        } else if (oVar instanceof g) {
            g gVar = (g) oVar;
            oVar = (g) new g.b().g(gVar.b()).h(gVar.c()).m(gVar.e()).n(gVar.f()).f(0).k();
        }
        byte[] bArrC = kVar.c().c(bArrF, oVar.d());
        if (oVar instanceof i) {
            i iVar2 = (i) oVar;
            oVar = (i) new i.b().g(iVar2.b()).h(iVar2.c()).n(iVar2.e()).o(iVar2.f()).p(iVar2.g()).f(1).l();
        } else if (oVar instanceof g) {
            g gVar2 = (g) oVar;
            oVar = (g) new g.b().g(gVar2.b()).h(gVar2.c()).m(gVar2.e()).n(gVar2.f()).f(1).k();
        }
        byte[] bArrC2 = kVar.c().c(bArrF, oVar.d());
        if (oVar instanceof i) {
            i iVar3 = (i) oVar;
            oVar = (i) new i.b().g(iVar3.b()).h(iVar3.c()).n(iVar3.e()).o(iVar3.f()).p(iVar3.g()).f(2).l();
        } else if (oVar instanceof g) {
            g gVar3 = (g) oVar;
            oVar = (g) new g.b().g(gVar3.b()).h(gVar3.c()).m(gVar3.e()).n(gVar3.f()).f(2).k();
        }
        byte[] bArrC3 = kVar.c().c(bArrF, oVar.d());
        int iC = kVar.d().c();
        byte[] bArr = new byte[iC * 2];
        for (int i10 = 0; i10 < iC; i10++) {
            bArr[i10] = (byte) (uVar.b()[i10] ^ bArrC2[i10]);
        }
        for (int i11 = 0; i11 < iC; i11++) {
            bArr[i11 + iC] = (byte) (uVar2.b()[i11] ^ bArrC3[i11]);
        }
        return new u(uVar.a(), kVar.c().b(bArrC, bArr));
    }

    static u a(k kVar, n nVar, i iVar) {
        double d10;
        if (nVar == null) {
            throw new NullPointerException("publicKey == null");
        }
        if (iVar == null) {
            throw new NullPointerException("address == null");
        }
        int iA = kVar.d().a();
        byte[][] bArrA = nVar.a();
        u[] uVarArr = new u[bArrA.length];
        for (int i10 = 0; i10 < bArrA.length; i10++) {
            uVarArr[i10] = new u(0, bArrA[i10]);
        }
        i.b bVarF = new i.b().g(iVar.b()).h(iVar.c()).n(iVar.e()).o(0).p(iVar.g()).f(iVar.a());
        while (true) {
            i iVar2 = (i) bVarF.l();
            if (iA <= 1) {
                return uVarArr[0];
            }
            int i11 = 0;
            while (true) {
                d10 = iA / 2;
                if (i11 >= ((int) Math.floor(d10))) {
                    break;
                }
                iVar2 = (i) new i.b().g(iVar2.b()).h(iVar2.c()).n(iVar2.e()).o(iVar2.f()).p(i11).f(iVar2.a()).l();
                int i12 = i11 * 2;
                uVarArr[i11] = b(kVar, uVarArr[i12], uVarArr[i12 + 1], iVar2);
                i11++;
            }
            if (iA % 2 == 1) {
                uVarArr[(int) Math.floor(d10)] = uVarArr[iA - 1];
            }
            iA = (int) Math.ceil(((double) iA) / 2.0d);
            bVarF = new i.b().g(iVar2.b()).h(iVar2.c()).n(iVar2.e()).o(iVar2.f() + 1).p(iVar2.g()).f(iVar2.a());
        }
    }
}
