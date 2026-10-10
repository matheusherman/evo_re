package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RectF f21894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f21895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21896k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21897l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f21898m = true;

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        if (this.f21898m) {
            this.f21897l = (f10 * 360.0f) - 90.0f;
        } else {
            this.f21896k = (f10 * 360.0f) - 90.0f;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        Paint paint = new Paint(1);
        this.f21895j = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        y(context);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f21896k = -90.0f;
        this.f21897l = -90.0f;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f21896k = -90.0f;
        this.f21897l = -90.0f;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        boolean z10 = this.f21898m;
        this.f21898m = !z10;
        if (z10) {
            this.f21896k = -90.0f;
            this.f21897l = 270.0f;
        } else {
            this.f21896k = -90.0f;
            this.f21897l = -90.0f;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f21896k = -90.0f;
        this.f21897l = -90.0f;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21895j.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21895j.setColorFilter(colorFilter);
    }

    private void y(Context context) {
        float fD = d() - com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 3.0f);
        this.f21894i = new RectF();
        this.f21896k = -90.0f;
        this.f21897l = -90.0f;
        float fG = g();
        float fH = h();
        this.f21894i.set(fG - fD, fH - fD, fG + fD, fH + fD);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        RectF rectF = this.f21894i;
        float f10 = this.f21896k;
        canvas.drawArc(rectF, f10, this.f21897l - f10, true, this.f21895j);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
