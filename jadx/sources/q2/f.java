package q2;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.UserManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import m2.e0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r2.b<q> f17623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f17624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r2.b<y2.i> f17625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<g> f17626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f17627e;

    private f(final Context context, final String str, Set<g> set, r2.b<y2.i> bVar, Executor executor) {
        this((r2.b<q>) new r2.b() { // from class: q2.e
            @Override // r2.b
            public final Object get() {
                return f.c(context, str);
            }
        }, set, executor, bVar, context);
    }

    public static /* synthetic */ String b(f fVar) {
        String string;
        synchronized (fVar) {
            try {
                q qVar = fVar.f17623a.get();
                List<r> listC = qVar.c();
                qVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < listC.size(); i10++) {
                    r rVar = listC.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", rVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) rVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", ExifInterface.GPS_MEASUREMENT_2D);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } catch (Throwable th) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return string;
    }

    public static /* synthetic */ Void e(f fVar) {
        synchronized (fVar) {
            fVar.f17623a.get().g(System.currentTimeMillis(), fVar.f17625c.get().a());
        }
        return null;
    }

    @VisibleForTesting
    f(r2.b<q> bVar, Set<g> set, Executor executor, r2.b<y2.i> bVar2, Context context) {
        this.f17623a = bVar;
        this.f17626d = set;
        this.f17627e = executor;
        this.f17625c = bVar2;
        this.f17624b = context;
    }

    public static /* synthetic */ q c(Context context, String str) {
        return new q(context, str);
    }

    public static /* synthetic */ f d(e0 e0Var, m2.e eVar) {
        return new f((Context) eVar.a(Context.class), ((j2.e) eVar.a(j2.e.class)).n(), (Set<g>) eVar.d(g.class), (r2.b<y2.i>) eVar.c(y2.i.class), (Executor) eVar.e(e0Var));
    }

    @NonNull
    public static m2.c<f> f() {
        final e0 e0VarA = e0.a(l2.a.class, Executor.class);
        return m2.c.d(f.class, i.class, j.class).b(m2.r.h(Context.class)).b(m2.r.h(j2.e.class)).b(m2.r.k(g.class)).b(m2.r.j(y2.i.class)).b(m2.r.i(e0VarA)).e(new m2.h() { // from class: q2.d
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return f.d(e0VarA, eVar);
            }
        }).c();
    }

    @Override // q2.i
    public e2.g<String> a() {
        return !UserManagerCompat.isUserUnlocked(this.f17624b) ? e2.j.d("") : e2.j.c(this.f17627e, new Callable() { // from class: q2.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.b(this.f17619a);
            }
        });
    }

    public e2.g<Void> g() {
        if (this.f17626d.size() <= 0) {
            return e2.j.d(null);
        }
        return !UserManagerCompat.isUserUnlocked(this.f17624b) ? e2.j.d(null) : e2.j.c(this.f17627e, new Callable() { // from class: q2.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.e(this.f17618a);
            }
        });
    }
}
