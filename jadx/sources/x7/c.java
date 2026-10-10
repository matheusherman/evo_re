package x7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f21899n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f21900o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Paint f21901p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f21902q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RectF f21903r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RectF f21904s;

    private void A() {
        Paint paint = new Paint(1);
        this.f21901p = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f21901p.setStrokeWidth(this.f21900o);
        this.f21901p.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void z() {
        Paint paint = new Paint(1);
        this.f21902q = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f21902q.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void B(Context context) {
        float fD = d();
        this.f21900o = 4.0f;
        this.f21899n = fD - 4.0f;
        float fB = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 8.0f);
        float fB2 = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 3.0f);
        float fB3 = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 3.0f);
        float fB4 = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 2.0f);
        float f10 = fB / 2.0f;
        this.f21903r = new RectF(g() - f10, ((h() - fD) - fB4) - fB2, g() + f10, (h() - fD) - fB4);
        float f11 = fB3 / 2.0f;
        this.f21904s = new RectF(g() - f11, (h() - fD) - fB4, g() + f11, h() - fD);
    }

    @Override // x7.b, com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        super.k(context, i10);
        B(context);
        A();
        z();
    }

    @Override // x7.b, com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        super.n(canvas);
        canvas.drawCircle(g(), h(), this.f21899n, this.f21901p);
        canvas.drawRect(this.f21903r, this.f21902q);
        canvas.drawRect(this.f21904s, this.f21902q);
        canvas.save();
        canvas.rotate(45.0f, g(), h());
        canvas.drawRect(this.f21904s, this.f21902q);
        canvas.restore();
        canvas.translate(0.0f, 20.0f);
    }

    @Override // x7.b, com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        super.q(i10);
        this.f21901p.setAlpha(i10);
        this.f21902q.setAlpha(i10);
    }

    @Override // x7.b, com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        super.t(colorFilter);
        this.f21901p.setColorFilter(colorFilter);
        this.f21902q.setColorFilter(colorFilter);
    }
}
