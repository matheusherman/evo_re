package lb;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.w;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Llb/b;", "Lokhttp3/w;", "", "forWebSocket", "<init>", "(Z)V", "", "code", "b", "(I)Z", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean forWebSocket;

    private final boolean b(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0098 A[Catch: IOException -> 0x0069, TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:17:0x0054, B:19:0x005a, B:30:0x0092, B:32:0x0098, B:22:0x006b, B:23:0x007a, B:25:0x0087), top: B:83:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ab  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, okhttp3.d0$a] */
    /* JADX WARN: Type inference failed for: r9v5, types: [okhttp3.d0$a] */
    @Override // okhttp3.w
    public d0 a(w.a chain) throws IOException {
        d0.a aVarQ;
        boolean z10;
        ?? r10;
        ?? Q;
        d0.a aVar;
        m.f(chain, "chain");
        g gVar = (g) chain;
        okhttp3.internal.connection.c cVarH = gVar.getExchange();
        m.c(cVarH);
        b0 b0VarJ = gVar.j();
        c0 body = b0VarJ.getBody();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            cVarH.u(b0VarJ);
            ?? A = f.a(b0VarJ.getMethod());
            try {
                if (A == 0 || body == null) {
                    cVarH.o();
                    A = 0;
                    z10 = true;
                } else {
                    if (n.w("100-continue", b0VarJ.d("Expect"), true)) {
                        cVarH.f();
                        aVarQ = cVarH.q(true);
                        try {
                            cVarH.s();
                            z10 = false;
                            aVar = aVarQ;
                        } catch (IOException e10) {
                            e = e10;
                            z10 = true;
                            r10 = aVarQ;
                            if (!(e instanceof nb.a)) {
                                throw e;
                            }
                            if (!cVarH.getHasFailure()) {
                                Q = r10;
                                throw e;
                            }
                        }
                    } else {
                        aVar = null;
                        z10 = true;
                    }
                    if (aVar != null) {
                        cVarH.o();
                        if (!cVarH.getConnection().w()) {
                            A = aVar;
                            cVarH.n();
                            A = aVar;
                        }
                    } else if (body.g()) {
                        cVarH.f();
                        body.i(tb.n.a(cVarH.c(b0VarJ, true)));
                    } else {
                        tb.e eVarA = tb.n.a(cVarH.c(b0VarJ, false));
                        body.i(eVarA);
                        eVarA.close();
                    }
                }
                if (body != null) {
                    A = aVar;
                    if (!body.g()) {
                        A = aVar;
                        A = aVar;
                        A = aVar;
                        cVarH.e();
                    }
                } else {
                    A = aVar;
                    A = aVar;
                    A = aVar;
                    cVarH.e();
                }
                A = aVar;
                e = null;
                Q = A;
            } catch (IOException e11) {
                e = e11;
                r10 = A;
                if (!(e instanceof nb.a)) {
                    throw e;
                }
                if (!cVarH.getHasFailure()) {
                    Q = r10;
                    throw e;
                }
            }
        } catch (IOException e12) {
            e = e12;
            aVarQ = null;
        }
        if (Q == 0) {
            try {
                Q = cVarH.q(false);
                m.c(Q);
                if (z10) {
                    cVarH.s();
                    z10 = false;
                }
            } catch (IOException e13) {
                if (e == null) {
                    throw e13;
                }
                r8.a.a(e, e13);
                throw e;
            }
        }
        d0 d0VarC = Q.r(b0VarJ).i(cVarH.getConnection().getHandshake()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
        int code = d0VarC.getCode();
        if (b(code)) {
            d0.a aVarQ2 = cVarH.q(false);
            m.c(aVarQ2);
            if (z10) {
                cVarH.s();
            }
            d0VarC = aVarQ2.r(b0VarJ).i(cVarH.getConnection().getHandshake()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
            code = d0VarC.getCode();
        }
        cVarH.r(d0VarC);
        d0 d0VarC2 = (this.forWebSocket && code == 101) ? d0VarC.q().b(hb.d.f10915c).c() : d0VarC.q().b(cVarH.p(d0VarC)).c();
        if (n.w("close", d0VarC2.getRequest().d("Connection"), true) || n.w("close", d0.l(d0VarC2, "Connection", null, 2, null), true)) {
            cVarH.n();
        }
        if (code == 204 || code == 205) {
            e0 body2 = d0VarC2.getBody();
            if ((body2 != null ? body2.getContentLength() : -1L) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(code);
                sb2.append(" had non-zero Content-Length: ");
                e0 body3 = d0VarC2.getBody();
                sb2.append(body3 != null ? Long.valueOf(body3.getContentLength()) : null);
                throw new ProtocolException(sb2.toString());
            }
        }
        return d0VarC2;
    }

    public b(boolean z10) {
        this.forWebSocket = z10;
    }
}
