package x7;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RectF f21906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RectF f21907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f21908l;

    private void y(float f10) {
        Paint paint = new Paint(1);
        this.f21905i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f21905i.setStrokeWidth(f10);
        this.f21905i.setColor(-1);
        this.f21905i.setDither(true);
        this.f21905i.setAntiAlias(true);
        this.f21905i.setFilterBitmap(true);
        this.f21905i.setStrokeCap(Paint.Cap.ROUND);
        this.f21905i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21908l = (int) (f10 * 360.0f);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21905i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21905i.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d();
        float f10 = 0.6f * fD;
        y(0.3f * f10);
        this.f21908l = 0;
        RectF rectF = new RectF();
        this.f21906j = rectF;
        rectF.set(g() - fD, h() - fD, g() + fD, h() + fD);
        RectF rectF2 = new RectF();
        this.f21907k = rectF2;
        rectF2.set(g() - f10, h() - f10, g() + f10, h() + f10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.drawArc(this.f21906j, this.f21908l % 360, 270.0f, false, this.f21905i);
        canvas.drawArc(this.f21907k, 270 - (this.f21908l % 360), 90.0f, false, this.f21905i);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
