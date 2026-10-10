package f1;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j extends GLSurfaceView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f9982m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f9983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f9984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Sensor f9985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f9986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f9987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f9988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f9989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private SurfaceTexture f9990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Surface f9991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9992j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9993k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9994l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    final class a implements GLSurfaceView.Renderer, k.a, c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f9995a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f9998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float[] f9999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f10000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f10001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f10002h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f9996b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f9997c = new float[16];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float[] f10003i = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f10004j = new float[16];

        @Override // f1.c.a
        @BinderThread
        public synchronized void a(float[] fArr, float f10) {
            float[] fArr2 = this.f9998d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f10002h = -f10;
            d();
        }

        @Override // f1.k.a
        @UiThread
        public synchronized void b(PointF pointF) {
            this.f10001g = pointF.y;
            d();
            Matrix.setRotateM(this.f10000f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f10004j, 0, this.f9998d, 0, this.f10000f, 0);
                Matrix.multiplyMM(this.f10003i, 0, this.f9999e, 0, this.f10004j, 0);
            }
            Matrix.multiplyMM(this.f9997c, 0, this.f9996b, 0, this.f10003i, 0);
            this.f9995a.b(this.f9997c, false);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
            float f10 = i10 / i11;
            Matrix.perspectiveM(this.f9996b, 0, c(f10), f10, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            j.this.d(this.f9995a.c());
        }

        public a(g gVar) {
            float[] fArr = new float[16];
            this.f9998d = fArr;
            float[] fArr2 = new float[16];
            this.f9999e = fArr2;
            float[] fArr3 = new float[16];
            this.f10000f = fArr3;
            this.f9995a = gVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f10002h = 3.1415927f;
        }

        private float c(float f10) {
            if (f10 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f10))) * 2.0d);
            }
            return 90.0f;
        }

        @AnyThread
        private void d() {
            Matrix.setRotateM(this.f9999e, 0, -this.f10001g, (float) Math.cos(this.f10002h), (float) Math.sin(this.f10002h), 0.0f);
        }

        @Override // f1.k.a
        @UiThread
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return j.this.performClick();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a(Surface surface);

        void b(Surface surface);
    }

    public j(Context context) {
        this(context, null);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f9993k = false;
        f();
        super.onPause();
    }

    public j(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9983a = new CopyOnWriteArrayList<>();
        this.f9987e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) d1.a.b(context.getSystemService("sensor"));
        this.f9984b = sensorManager;
        Sensor defaultSensor = d1.k.f9577a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f9985c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.f9989g = gVar;
        a aVar = new a(gVar);
        k kVar = new k(context, aVar, 25.0f);
        this.f9988f = kVar;
        this.f9986d = new c(((WindowManager) d1.a.b((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), kVar, aVar);
        this.f9992j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(kVar);
    }

    public static /* synthetic */ void a(j jVar) {
        Surface surface = jVar.f9991i;
        if (surface != null) {
            Iterator<b> it = jVar.f9983a.iterator();
            while (it.hasNext()) {
                it.next().a(surface);
            }
        }
        e(jVar.f9990h, surface);
        jVar.f9990h = null;
        jVar.f9991i = null;
    }

    public static /* synthetic */ void b(j jVar, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = jVar.f9990h;
        Surface surface = jVar.f9991i;
        Surface surface2 = new Surface(surfaceTexture);
        jVar.f9990h = surfaceTexture;
        jVar.f9991i = surface2;
        Iterator<b> it = jVar.f9983a.iterator();
        while (it.hasNext()) {
            it.next().b(surface2);
        }
        e(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final SurfaceTexture surfaceTexture) {
        this.f9987e.post(new Runnable() { // from class: f1.h
            @Override // java.lang.Runnable
            public final void run() {
                j.b(this.f9979a, surfaceTexture);
            }
        });
    }

    private static void e(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void f() {
        boolean z10 = this.f9992j && this.f9993k;
        Sensor sensor = this.f9985c;
        if (sensor == null || z10 == this.f9994l) {
            return;
        }
        if (z10) {
            this.f9984b.registerListener(this.f9986d, sensor, 0);
        } else {
            this.f9984b.unregisterListener(this.f9986d);
        }
        this.f9994l = z10;
    }

    public f1.a getCameraMotionListener() {
        return this.f9989g;
    }

    public e1.d getVideoFrameMetadataListener() {
        return this.f9989g;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f9991i;
    }

    public void setDefaultStereoMode(int i10) {
        this.f9989g.d(i10);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f9992j = z10;
        f();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9987e.post(new Runnable() { // from class: f1.i
            @Override // java.lang.Runnable
            public final void run() {
                j.a(this.f9981a);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f9993k = true;
        f();
    }
}
