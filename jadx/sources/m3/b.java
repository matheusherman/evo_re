package m3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n4.h f15590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n4.i f15591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Sensor f15592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f15593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f15594e = new Handler();

    private void b(final boolean z10) {
        this.f15594e.post(new Runnable() { // from class: m3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15588a.f15590a.t(z10);
            }
        });
    }

    public void c() {
        if (this.f15591b.d()) {
            SensorManager sensorManager = (SensorManager) this.f15593d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f15592c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f15592c != null) {
            ((SensorManager) this.f15593d.getSystemService("sensor")).unregisterListener(this);
            this.f15592c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f10 = sensorEvent.values[0];
        if (this.f15590a != null) {
            if (f10 <= 45.0f) {
                b(true);
            } else if (f10 >= 450.0f) {
                b(false);
            }
        }
    }

    public b(Context context, n4.h hVar, n4.i iVar) {
        this.f15593d = context;
        this.f15590a = hVar;
        this.f15591b = iVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
