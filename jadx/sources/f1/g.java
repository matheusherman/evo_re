package f1;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class g implements e1.d, a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SurfaceTexture f9976j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f9967a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f9968b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f9969c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f9970d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d1.i<Long> f9971e = new d1.i<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d1.i<d> f9972f = new d1.i<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f9973g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f9974h = new float[16];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f9977k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9978l = -1;

    public void b(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        d1.c.g();
        if (this.f9967a.compareAndSet(true, false)) {
            ((SurfaceTexture) d1.a.b(this.f9976j)).updateTexImage();
            d1.c.g();
            if (this.f9968b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f9973g, 0);
            }
            long timestamp = this.f9976j.getTimestamp();
            Long lB = this.f9971e.b(timestamp);
            if (lB != null) {
                this.f9970d.c(this.f9973g, lB.longValue());
            }
            d dVarD = this.f9972f.d(timestamp);
            if (dVarD != null) {
                this.f9969c.d(dVarD);
            }
        }
        Matrix.multiplyMM(this.f9974h, 0, fArr, 0, this.f9973g, 0);
        this.f9969c.a(this.f9975i, this.f9974h, z10);
    }

    public SurfaceTexture c() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        d1.c.g();
        this.f9969c.b();
        d1.c.g();
        this.f9975i = d1.c.j();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f9975i);
        this.f9976j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: f1.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f9966a.f9967a.set(true);
            }
        });
        return this.f9976j;
    }

    public void d(int i10) {
        this.f9977k = i10;
    }
}
