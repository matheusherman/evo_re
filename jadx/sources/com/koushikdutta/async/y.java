package com.koushikdutta.async;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5166a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements o4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f5167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f5168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o4.a f5169c;

        a(p pVar, l lVar, o4.a aVar) {
            this.f5167a = pVar;
            this.f5168b = lVar;
            this.f5169c = aVar;
        }

        @Override // o4.e
        public void a() {
            this.f5167a.n(this.f5168b);
            if (this.f5168b.A() != 0 || this.f5169c == null) {
                return;
            }
            this.f5167a.p(null);
            this.f5169c.c(null);
        }
    }

    public static void a(n nVar, l lVar) {
        int iA;
        o4.b bVarU = null;
        while (!nVar.t() && (bVarU = nVar.u()) != null && (iA = lVar.A()) > 0) {
            bVarU.i(nVar, lVar);
            if (iA == lVar.A() && bVarU == nVar.u() && !nVar.t()) {
                System.out.println("handler: " + bVarU);
                lVar.z();
                if (!f5166a) {
                    throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
                }
                return;
            }
        }
        if (lVar.A() == 0 || nVar.t()) {
            return;
        }
        System.out.println("handler: " + bVarU);
        System.out.println("emitter: " + nVar);
        lVar.z();
    }

    public static void c(p pVar, byte[] bArr, o4.a aVar) {
        ByteBuffer byteBufferR = l.r(bArr.length);
        byteBufferR.put(bArr);
        byteBufferR.flip();
        l lVar = new l();
        lVar.a(byteBufferR);
        b(pVar, lVar, aVar);
    }

    public static void b(p pVar, l lVar, o4.a aVar) {
        a aVar2 = new a(pVar, lVar, aVar);
        pVar.p(aVar2);
        aVar2.a();
    }
}
