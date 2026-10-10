package nd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class m {
    static void a(byte[] bArr, tc.i iVar) {
        iVar.update(bArr, 0, bArr.length);
    }

    static void b(short s10, tc.i iVar) {
        iVar.c((byte) (s10 >>> 8));
        iVar.c((byte) s10);
    }

    static void c(int i10, tc.i iVar) {
        iVar.c((byte) (i10 >>> 24));
        iVar.c((byte) (i10 >>> 16));
        iVar.c((byte) (i10 >>> 8));
        iVar.c((byte) i10);
    }
}
