package v4;

import android.content.Context;
import android.text.TextUtils;
import com.live.evo.MyApplication;
import com.live.evo.util.u1;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static g f19657g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19661d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f19658a = q6.c.d(g.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i5.c f19662e = new i5.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<i5.e> f19663f = new ArrayList();

    private boolean b() {
        i5.c cVar = this.f19662e;
        if (cVar == null) {
            return true;
        }
        long j10 = cVar.f11077a;
        u1.b().a();
        return true;
    }

    public static g e() {
        if (f19657g == null) {
            synchronized (g.class) {
                try {
                    if (f19657g == null) {
                        g(StubApp.getOrigApplicationContext(MyApplication.a().getApplicationContext()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f19657g;
    }

    public static void g(Context context) {
        f19657g = new g();
    }

    public boolean c() {
        if (this.f19659b != 1) {
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            if ((!aVar.k0() || this.f19659b != 2) && (aVar.k0() || this.f19659b != 3)) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        return this.f19661d;
    }

    public i5.f f(String str) {
        List<i5.f> listA;
        List<i5.e> list = this.f19663f;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i10 = 0; i10 < this.f19663f.size(); i10++) {
            if (this.f19663f.get(i10) != null && this.f19663f.get(i10).a() != null && (listA = this.f19663f.get(i10).a()) != null) {
                for (int i11 = 0; i11 < listA.size(); i11++) {
                    if (TextUtils.equals(listA.get(i11).b(), str)) {
                        return listA.get(i11);
                    }
                }
            }
        }
        return null;
    }

    public void h() {
        try {
            final com.google.gson.e eVarB = new com.google.gson.f().b();
            w0.f21452a.n("ad_info", new w0.a() { // from class: v4.f
                @Override // x1.f1.lb.util.w0.a
                public final void a(Object obj) {
                    this.f19655a.i(eVarB, (String) obj);
                }
            }, "");
        } catch (Exception e10) {
            this.f19658a.error("AD init saved info error", e10);
        }
    }

    public g() {
        this.f19659b = -1;
        this.f19660c = false;
        this.f19661d = false;
        this.f19659b = -1;
        this.f19660c = false;
        this.f19661d = false;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(com.google.gson.e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            i5.c cVar = (i5.c) eVar.n(str, i5.c.class);
            this.f19662e = cVar;
            if (cVar != null) {
                this.f19663f.clear();
                this.f19663f.addAll(this.f19662e.f11078b);
            }
        }
    }

    public void k() {
        if (b()) {
            j();
        }
    }

    private void j() {
    }
}
