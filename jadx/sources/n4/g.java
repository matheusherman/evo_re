package n4;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R$id;
import m4.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f15884n = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f15885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f15886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f15887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f15888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m f15889e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f15892h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15890f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15891g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i f15893i = new i();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f15894j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Runnable f15895k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Runnable f15896l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f15897m = new d();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f15884n, "Opening camera");
                g.this.f15887c.l();
            } catch (Exception e10) {
                g.this.q(e10);
                Log.e(g.f15884n, "Failed to open camera", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f15884n, "Configuring camera");
                g.this.f15887c.e();
                if (g.this.f15888d != null) {
                    g.this.f15888d.obtainMessage(R$id.zxing_prewiew_size_ready, g.this.o()).sendToTarget();
                }
            } catch (Exception e10) {
                g.this.q(e10);
                Log.e(g.f15884n, "Failed to configure camera", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f15884n, "Starting preview");
                g.this.f15887c.s(g.this.f15886b);
                g.this.f15887c.u();
            } catch (Exception e10) {
                g.this.q(e10);
                Log.e(g.f15884n, "Failed to start preview", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(g.f15884n, "Closing camera");
                g.this.f15887c.v();
                g.this.f15887c.d();
            } catch (Exception e10) {
                Log.e(g.f15884n, "Failed to close camera", e10);
            }
            g.this.f15891g = true;
            g.this.f15888d.sendEmptyMessage(R$id.zxing_camera_closed);
            g.this.f15885a.b();
        }
    }

    public static /* synthetic */ void c(final g gVar, final p pVar) {
        if (gVar.f15890f) {
            gVar.f15885a.c(new Runnable() { // from class: n4.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15882a.f15887c.m(pVar);
                }
            });
        } else {
            Log.d(f15884n, "Camera is closed, not requesting preview");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m4.p o() {
        return this.f15887c.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Exception exc) {
        Handler handler = this.f15888d;
        if (handler != null) {
            handler.obtainMessage(R$id.zxing_camera_error, exc).sendToTarget();
        }
    }

    private void z() {
        if (!this.f15890f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public m n() {
        return this.f15889e;
    }

    public boolean p() {
        return this.f15891g;
    }

    public void s(final p pVar) {
        this.f15892h.post(new Runnable() { // from class: n4.d
            @Override // java.lang.Runnable
            public final void run() {
                g.c(this.f15878a, pVar);
            }
        });
    }

    public void t(i iVar) {
        if (this.f15890f) {
            return;
        }
        this.f15893i = iVar;
        this.f15887c.o(iVar);
    }

    public void u(m mVar) {
        this.f15889e = mVar;
        this.f15887c.q(mVar);
    }

    public void v(Handler handler) {
        this.f15888d = handler;
    }

    public void w(j jVar) {
        this.f15886b = jVar;
    }

    public g(Context context) {
        r.a();
        this.f15885a = k.d();
        h hVar = new h(context);
        this.f15887c = hVar;
        hVar.o(this.f15893i);
        this.f15892h = new Handler();
    }

    public void l() {
        r.a();
        if (this.f15890f) {
            this.f15885a.c(this.f15897m);
        } else {
            this.f15891g = true;
        }
        this.f15890f = false;
    }

    public void m() {
        r.a();
        z();
        this.f15885a.c(this.f15895k);
    }

    public void r() {
        r.a();
        this.f15890f = true;
        this.f15891g = false;
        this.f15885a.e(this.f15894j);
    }

    public void x(final boolean z10) {
        r.a();
        if (this.f15890f) {
            this.f15885a.c(new Runnable() { // from class: n4.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15880a.f15887c.t(z10);
                }
            });
        }
    }

    public void y() {
        r.a();
        z();
        this.f15885a.c(this.f15896l);
    }
}
