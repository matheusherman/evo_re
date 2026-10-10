package x7;

import android.animation.Animator;
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
public class j extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RectF f21942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21945m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f21946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f21947o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f21948p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f21949q;

    private void y() {
        Paint paint = new Paint(1);
        this.f21941i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21941i.setColor(-1);
        this.f21941i.setDither(true);
        this.f21941i.setFilterBitmap(true);
        this.f21941i.setStrokeCap(Paint.Cap.ROUND);
        this.f21941i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f21947o / 5;
        int i10 = this.f21945m;
        if (i10 < 5) {
            this.f21946n = 0;
            this.f21944l = this.f21948p + (f11 * f10);
        } else {
            this.f21946n = 180;
            this.f21944l = this.f21948p - (f11 * f10);
        }
        if (i10 % 2 == 0) {
            this.f21943k = ((int) (f10 * 45.0f)) + 5;
        } else {
            this.f21943k = ((int) ((1.0f - f10) * 45.0f)) + 5;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21945m + 1;
        this.f21945m = i10;
        if (i10 > 9) {
            this.f21945m = 0;
        }
        float f10 = this.f21947o / 5;
        int i11 = this.f21945m;
        if (i11 < 5) {
            this.f21948p = f10 * i11;
        } else {
            this.f21948p = f10 * (5 - (i11 % 5));
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(333L);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21941i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21941i.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d() * 0.7f;
        this.f21947o = f() + (2.0f * fD);
        y();
        this.f21943k = 45;
        this.f21946n = 0;
        this.f21949q = (-this.f21947o) * 0.5f;
        this.f21944l = 0.0f;
        this.f21942j = new RectF(g() - fD, h() - fD, g() + fD, h() + fD);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f21949q + this.f21944l, 0.0f);
        canvas.rotate(this.f21946n, g(), h());
        RectF rectF = this.f21942j;
        int i10 = this.f21943k;
        canvas.drawArc(rectF, i10, 360 - (i10 * 2), true, this.f21941i);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }
}
