package b4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d extends h {
    d(p3.a aVar) {
        super(aVar);
    }

    @Override // b4.j
    public String d() throws h3.m {
        if (c().m() >= 48) {
            StringBuilder sb2 = new StringBuilder();
            f(sb2, 8);
            int iF = b().f(48, 2);
            sb2.append("(393");
            sb2.append(iF);
            sb2.append(')');
            int iF2 = b().f(50, 10);
            if (iF2 / 100 == 0) {
                sb2.append('0');
            }
            if (iF2 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(iF2);
            sb2.append(b().c(60, null).b());
            return sb2.toString();
        }
        throw h3.m.a();
    }
}
