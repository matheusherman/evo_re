package c7;

import ac.g;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.z;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final q6.b f1135j = q6.c.d(c.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f1137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z f1138c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private v6.c f1141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f1142g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedBlockingQueue<e> f1139d = new LinkedBlockingQueue<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Boolean> f1140e = new z6.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1143h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1144i = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    private int e(byte[] bArr) throws Throwable {
        ?? r10 = 0;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    List<String> listA = i7.a.a(byteArrayInputStream2);
                    if (listA.isEmpty()) {
                        yb.e.b(byteArrayInputStream2);
                        return -1;
                    }
                    String strSubstring = listA.get(listA.size() - 1);
                    int iIndexOf = strSubstring.indexOf(LocationInfo.NA);
                    if (iIndexOf > 0) {
                        strSubstring = strSubstring.substring(0, iIndexOf);
                    }
                    String[] strArrSplit = yb.d.b(strSubstring).split("_");
                    int length = strArrSplit.length;
                    if (length > 1) {
                        int i10 = Integer.parseInt(strArrSplit[strArrSplit.length - 1]);
                        yb.e.b(byteArrayInputStream2);
                        return i10;
                    }
                    yb.e.b(byteArrayInputStream2);
                    r10 = length;
                } catch (Exception e10) {
                    e = e10;
                    byteArrayInputStream = byteArrayInputStream2;
                    f1135j.error("Parser index error.", e);
                    r10 = byteArrayInputStream;
                    if (byteArrayInputStream != null) {
                        yb.e.b(byteArrayInputStream);
                        r10 = byteArrayInputStream;
                    }
                } catch (Throwable th) {
                    th = th;
                    r10 = byteArrayInputStream2;
                    if (r10 != 0) {
                        yb.e.b(r10);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return -1;
    }

    public void j() {
        this.f1144i = true;
        f1135j.a("[HTTP] Stop.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:64:0x018f  */
    /* JADX WARN: Code duplicated, block: B:66:0x019a  */
    public void d() throws Throwable {
        e0 body;
        String strE;
        while (!this.f1144i) {
            e eVar = null;
            d0 d0Var = null;
            eVar = null;
            try {
                e eVarTake = this.f1139d.take();
                if (eVarTake != null) {
                    try {
                        if (this.f1140e.containsKey(eVarTake.a())) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (!g.f(eVarTake.a()) && !g.f(this.f1136a)) {
                                v6.b bVarC = eVarTake.c();
                                v6.b bVar = v6.b.INDEX;
                                if (bVarC.equals(bVar)) {
                                    strE = this.f1142g.e();
                                } else if (g.f(eVarTake.e())) {
                                    strE = this.f1136a + "/" + eVarTake.a();
                                } else {
                                    strE = eVarTake.e();
                                }
                                d0 d0VarExecute = this.f1138c.a(new b0.a().k(strE).c().b()).execute();
                                if (d0VarExecute.n()) {
                                    byte[] bArrB = d0VarExecute.getBody().b();
                                    if (eVarTake.c().equals(bVar)) {
                                        this.f1137b.b(eVarTake.b(), this.f1141f.equals(v6.c.LIVE) ? e(bArrB) : 0, eVarTake.a(), bArrB);
                                    } else if (eVarTake.c().equals(v6.b.BLOCK)) {
                                        this.f1137b.a(eVarTake.b(), eVarTake.a(), bArrB);
                                    } else if (eVarTake.c().equals(v6.b.SUBTITLE)) {
                                        this.f1137b.c(eVarTake.b(), eVarTake.a(), bArrB);
                                    }
                                    f1135j.a("[HTTP] download [{}] cost:[{}]ms,left tasks[{}],stopped:[{}]", eVarTake.a(), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Integer.valueOf(this.f1139d.size()), Boolean.valueOf(this.f1144i));
                                }
                                this.f1140e.remove(eVarTake.a());
                                body = d0VarExecute.getBody();
                                body.close();
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        eVar = eVarTake;
                        try {
                            f1135j.error("[HTTP] execute error. ", e);
                            if (eVar != null) {
                                eVar.i(eVar.d() + 1);
                                if (eVar.d() < 3) {
                                    this.f1139d.offer(eVar);
                                }
                            }
                            if (eVar != null) {
                                this.f1140e.remove(eVar.a());
                            }
                            if (eVar != 0) {
                                body = eVar.getBody();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (eVar != null) {
                                this.f1140e.remove(eVar.a());
                            }
                            if (d0Var != null) {
                                d0Var.getBody().close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        d0Var = null;
                        eVar = eVarTake;
                        if (eVar != null) {
                            this.f1140e.remove(eVar.a());
                        }
                        if (d0Var != null) {
                            d0Var.getBody().close();
                        }
                        throw th;
                    }
                } else if (eVarTake != null) {
                }
                this.f1140e.remove(eVarTake.a());
            } catch (Exception e11) {
                e = e11;
            } catch (Throwable th3) {
                th = th3;
                d0Var = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        while (!this.f1144i) {
            try {
                Thread.sleep(1000L);
                e eVar = this.f1142g;
                if (eVar != null && !g.f(eVar.e()) && this.f1141f.equals(v6.c.LIVE)) {
                    this.f1140e.put(this.f1142g.a(), Boolean.TRUE);
                    this.f1139d.offer(this.f1142g);
                }
            } catch (Exception e10) {
                f1135j.error("[HTTP]Live index task error.", e10);
            }
        }
    }

    public void c(int i10, v6.b bVar, String str) {
        e eVar = new e();
        eVar.g(i10);
        eVar.h(bVar);
        eVar.f(str);
        if (this.f1140e.containsKey(str)) {
            return;
        }
        this.f1140e.put(str, Boolean.TRUE);
        this.f1139d.offer(eVar);
        f1135j.a("[HTTP] add http task.[{}]", str);
    }

    public int f() {
        return this.f1143h;
    }

    public boolean g() {
        return this.f1144i;
    }

    public void i(int i10, String str) {
        this.f1143h = i10;
        this.f1136a = str.substring(0, str.lastIndexOf("/"));
        e eVar = new e();
        this.f1142g = eVar;
        eVar.g(i10);
        this.f1142g.h(v6.b.INDEX);
        this.f1142g.f("index.m3u8");
        this.f1142g.j(str);
        this.f1144i = false;
        f1135j.a("[HTTP][{}] Start.", this.f1141f.name());
    }

    public c(v6.c cVar, d dVar) {
        this.f1141f = cVar;
        this.f1137b = dVar;
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f1138c = aVar.d(5L, timeUnit).P(5L, timeUnit).Q(false).c();
        new Thread(new Runnable() { // from class: c7.a
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f1133a.d();
            }
        }).start();
        if (cVar.equals(v6.c.LIVE)) {
            new Thread(new Runnable() { // from class: c7.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1134a.h();
                }
            }).start();
        }
    }
}
