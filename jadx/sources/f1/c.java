package f1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import com.taobao.sophix.PatchStatus;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f9946a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f9947b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f9948c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f9949d = new float[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Display f9950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a[] f9951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9952g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(float[] fArr, float f10);
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, PatchStatus.CODE_LOAD_LIB_UNDEFINED, this.f9947b);
        SensorManager.getOrientation(this.f9947b, this.f9949d);
        return this.f9949d[2];
    }

    private void b(float[] fArr, float f10) {
        for (a aVar : this.f9951f) {
            aVar.a(fArr, f10);
        }
    }

    private void c(float[] fArr) {
        if (!this.f9952g) {
            b.a(this.f9948c, fArr);
            this.f9952g = true;
        }
        float[] fArr2 = this.f9947b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f9947b, 0, this.f9948c, 0);
    }

    private void d(float[] fArr, int i10) {
        if (i10 != 0) {
            int i11 = 129;
            int i12 = 1;
            if (i10 == 1) {
                i11 = 2;
                i12 = 129;
            } else if (i10 == 2) {
                i12 = 130;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException();
                }
                i11 = 130;
            }
            float[] fArr2 = this.f9947b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f9947b, i11, i12, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f9946a, sensorEvent.values);
        d(this.f9946a, this.f9950e.getRotation());
        float fA = a(this.f9946a);
        e(this.f9946a);
        c(this.f9946a);
        b(this.f9946a, fA);
    }

    public c(Display display, a... aVarArr) {
        this.f9950e = display;
        this.f9951f = aVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
