package com.koushikdutta.async.http;

import com.koushikdutta.async.q;
import com.pengrad.telegrambot.request.ContentTypes;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class j {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends q {

        /* JADX INFO: renamed from: com.koushikdutta.async.http.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class RunnableC0062a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Exception f5095b;

            RunnableC0062a(Exception exc) {
                this.f5095b = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.w(this.f5095b);
            }
        }

        public static a z(com.koushikdutta.async.f fVar, Exception exc) {
            a aVar = new a();
            fVar.n(aVar.new RunnableC0062a(exc));
            return aVar;
        }

        private a() {
        }
    }

    public static q4.a a(com.koushikdutta.async.n nVar, o4.a aVar, h hVar) {
        String strC = hVar.c("Content-Type");
        if (strC == null) {
            return null;
        }
        String[] strArrSplit = strC.split(";");
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            strArrSplit[i10] = strArrSplit[i10].trim();
        }
        for (String str : strArrSplit) {
            if (ContentTypes.GENERAL_MIME_TYPE.equals(str)) {
                return new q4.h();
            }
            if ("application/json".equals(str)) {
                return new q4.b();
            }
            if (ContentTypes.DOC_MIME_TYPE.equals(str)) {
                return new q4.f();
            }
            if (str != null && str.startsWith("multipart/")) {
                return new q4.c(strC);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    public static com.koushikdutta.async.n b(com.koushikdutta.async.n nVar, m mVar, h hVar, boolean z10) {
        long j10;
        q bVar;
        q gVar;
        try {
            String strC = hVar.c("Content-Length");
            j10 = strC != null ? Long.parseLong(strC) : -1L;
        } catch (NumberFormatException unused) {
        }
        if (-1 == j10) {
            if ("chunked".equalsIgnoreCase(hVar.c("Transfer-Encoding"))) {
                bVar = new r4.b();
                bVar.x(nVar);
            } else if (z10) {
                a aVarZ = a.z(nVar.a(), null);
                aVarZ.x(nVar);
                return aVarZ;
            }
            if ("gzip".equals(hVar.c("Content-Encoding"))) {
                gVar = new r4.f();
                gVar.x(nVar);
            } else {
                if ("deflate".equals(hVar.c("Content-Encoding"))) {
                    return nVar;
                }
                gVar = new r4.g();
                gVar.x(nVar);
            }
            return gVar;
        }
        if (j10 < 0) {
            a aVarZ2 = a.z(nVar.a(), new g("not using chunked encoding, and no content-length found."));
            aVarZ2.x(nVar);
            return aVarZ2;
        }
        if (j10 == 0) {
            a aVarZ3 = a.z(nVar.a(), null);
            aVarZ3.x(nVar);
            return aVarZ3;
        }
        bVar = new r4.d(j10);
        bVar.x(nVar);
        nVar = bVar;
        if ("gzip".equals(hVar.c("Content-Encoding"))) {
            gVar = new r4.f();
            gVar.x(nVar);
        } else {
            if ("deflate".equals(hVar.c("Content-Encoding"))) {
                return nVar;
            }
            gVar = new r4.g();
            gVar.x(nVar);
        }
        return gVar;
    }

    public static boolean c(m mVar, h hVar) {
        String strC = hVar.c("Connection");
        if (strC == null) {
            return mVar == m.f5099b;
        }
        return "keep-alive".equalsIgnoreCase(strC);
    }

    public static boolean d(String str, h hVar) {
        String strC = hVar.c("Connection");
        if (strC == null) {
            return m.a(str) == m.f5099b;
        }
        return "keep-alive".equalsIgnoreCase(strC);
    }
}
