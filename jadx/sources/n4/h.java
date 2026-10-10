package n4;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f15902n = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f15903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Camera.CameraInfo f15904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n4.a f15905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m3.b f15906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15908f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m f15910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m4.p f15911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private m4.p f15912j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f15914l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f15909g = new i();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15913k = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final a f15915m = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p f15916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m4.p f15917b;

        public a() {
        }

        public void a(p pVar) {
            this.f15916a = pVar;
        }

        public void b(m4.p pVar) {
            this.f15917b = pVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            m4.p pVar = this.f15917b;
            p pVar2 = this.f15916a;
            if (pVar == null || pVar2 == null) {
                Log.d(h.f15902n, "Got preview callback, but no handler or resolution available");
                if (pVar2 != null) {
                    pVar2.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                m4.q qVar = new m4.q(bArr, pVar.f15654a, pVar.f15655b, camera.getParameters().getPreviewFormat(), h.this.f());
                if (h.this.f15904b.facing == 1) {
                    qVar.e(true);
                }
                pVar2.b(qVar);
            } catch (RuntimeException e10) {
                Log.e(h.f15902n, "Camera preview failed", e10);
                pVar2.a(e10);
            }
        }
    }

    private int c() {
        int iC = this.f15910h.c();
        int i10 = 0;
        if (iC != 0) {
            if (iC == 1) {
                i10 = 90;
            } else if (iC == 2) {
                i10 = 180;
            } else if (iC == 3) {
                i10 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f15904b;
        int i11 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i10) % 360)) % 360 : ((cameraInfo.orientation - i10) + 360) % 360;
        Log.i(f15902n, "Camera Display Orientation: " + i11);
        return i11;
    }

    private Camera.Parameters g() {
        Camera.Parameters parameters = this.f15903a.getParameters();
        String str = this.f15908f;
        if (str == null) {
            this.f15908f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    private void n(int i10) {
        this.f15903a.setDisplayOrientation(i10);
    }

    public void d() {
        Camera camera = this.f15903a;
        if (camera != null) {
            camera.release();
            this.f15903a = null;
        }
    }

    public void e() {
        if (this.f15903a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f15913k;
    }

    public m4.p h() {
        if (this.f15912j == null) {
            return null;
        }
        return j() ? this.f15912j.f() : this.f15912j;
    }

    public boolean j() {
        int i10 = this.f15913k;
        if (i10 != -1) {
            return i10 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f15903a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void l() {
        Camera cameraB = n3.a.b(this.f15909g.b());
        this.f15903a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = n3.a.a(this.f15909g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f15904b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void m(p pVar) {
        Camera camera = this.f15903a;
        if (camera == null || !this.f15907e) {
            return;
        }
        this.f15915m.a(pVar);
        camera.setOneShotPreviewCallback(this.f15915m);
    }

    public void o(i iVar) {
        this.f15909g = iVar;
    }

    public void q(m mVar) {
        this.f15910h = mVar;
    }

    public void s(j jVar) throws IOException {
        jVar.a(this.f15903a);
    }

    public void t(boolean z10) {
        if (this.f15903a != null) {
            try {
                if (z10 != k()) {
                    n4.a aVar = this.f15905c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f15903a.getParameters();
                    c.k(parameters, z10);
                    if (this.f15909g.f()) {
                        c.d(parameters, z10);
                    }
                    this.f15903a.setParameters(parameters);
                    n4.a aVar2 = this.f15905c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e10) {
                Log.e(f15902n, "Failed to set torch", e10);
            }
        }
    }

    public void u() {
        Camera camera = this.f15903a;
        if (camera == null || this.f15907e) {
            return;
        }
        camera.startPreview();
        this.f15907e = true;
        this.f15905c = new n4.a(this.f15903a, this.f15909g);
        m3.b bVar = new m3.b(this.f15914l, this, this.f15909g);
        this.f15906d = bVar;
        bVar.c();
    }

    public void v() {
        n4.a aVar = this.f15905c;
        if (aVar != null) {
            aVar.j();
            this.f15905c = null;
        }
        m3.b bVar = this.f15906d;
        if (bVar != null) {
            bVar.d();
            this.f15906d = null;
        }
        Camera camera = this.f15903a;
        if (camera == null || !this.f15907e) {
            return;
        }
        camera.stopPreview();
        this.f15915m.a(null);
        this.f15907e = false;
    }

    public h(Context context) {
        this.f15914l = context;
    }

    private static List<m4.p> i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new m4.p(previewSize.width, previewSize.height);
                arrayList.add(new m4.p(previewSize.width, previewSize.height));
                return arrayList;
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new m4.p(size.width, size.height));
            }
        }
        return arrayList;
    }

    private void p(boolean z10) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(f15902n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f15902n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z10) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        c.g(parametersG, this.f15909g.a(), z10);
        if (!z10) {
            c.k(parametersG, false);
            if (this.f15909g.h()) {
                c.i(parametersG);
            }
            if (this.f15909g.e()) {
                c.c(parametersG);
            }
            if (this.f15909g.g()) {
                c.l(parametersG);
                c.h(parametersG);
                c.j(parametersG);
            }
        }
        List<m4.p> listI = i(parametersG);
        if (listI.size() == 0) {
            this.f15911i = null;
        } else {
            m4.p pVarA = this.f15910h.a(listI, j());
            this.f15911i = pVarA;
            parametersG.setPreviewSize(pVarA.f15654a, pVarA.f15655b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            c.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.f15903a.setParameters(parametersG);
    }

    private void r() {
        try {
            int iC = c();
            this.f15913k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(f15902n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f15902n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f15903a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f15912j = this.f15911i;
        } else {
            this.f15912j = new m4.p(previewSize.width, previewSize.height);
        }
        this.f15915m.b(this.f15912j);
    }
}
