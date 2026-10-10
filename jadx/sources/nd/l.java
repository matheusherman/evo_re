package nd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class l {
    static byte[] a(e eVar, byte[] bArr, int i10, byte[] bArr2) {
        boolean z10;
        tc.i iVarA = b.a(eVar.b());
        byte[] bArrB = a.f().d(bArr).i(i10).h(-32640).g(0, 22).b();
        iVarA.update(bArrB, 0, bArrB.length);
        tc.i iVarA2 = b.a(eVar.b());
        byte[] bArrB2 = a.f().d(bArr).i(i10).g(0, iVarA2.e() + 23).b();
        n nVar = new n(bArr, bArr2, b.a(eVar.b()));
        nVar.d(i10);
        nVar.c(0);
        int iD = eVar.d();
        int iC = eVar.c();
        int iG = (1 << eVar.g()) - 1;
        for (int i11 = 0; i11 < iD; i11++) {
            if (i11 < iD - 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            nVar.a(bArrB2, z10, 23);
            re.f.l((short) i11, bArrB2, 20);
            for (int i12 = 0; i12 < iG; i12++) {
                bArrB2[22] = (byte) i12;
                iVarA2.update(bArrB2, 0, bArrB2.length);
                iVarA2.b(bArrB2, 23);
            }
            iVarA.update(bArrB2, 23, iC);
        }
        byte[] bArr3 = new byte[iVarA.e()];
        iVarA.b(bArr3, 0);
        return bArr3;
    }
}
