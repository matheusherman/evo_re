package f1;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f10009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GestureDetector f10010e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f10006a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f10007b = new PointF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile float f10011f = 3.1415927f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    @Override // f1.c.a
    @BinderThread
    public void a(float[] fArr, float f10) {
        this.f10011f = -f10;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f10006a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f10008c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f10010e.onTouchEvent(motionEvent);
    }

    public k(Context context, a aVar, float f10) {
        this.f10008c = aVar;
        this.f10009d = f10;
        this.f10010e = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = (motionEvent2.getX() - this.f10006a.x) / this.f10009d;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f10006a;
        float f12 = (y10 - pointF.y) / this.f10009d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.f10011f;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        PointF pointF2 = this.f10007b;
        pointF2.x -= (fCos * x10) - (fSin * f12);
        float f13 = pointF2.y + (fSin * x10) + (fCos * f12);
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        this.f10008c.b(this.f10007b);
        return true;
    }
}
