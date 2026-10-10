package s5;

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
public class n extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18408i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f18409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RectF f18410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18412m;

    private void y(float f10) {
        Paint paint = new Paint(1);
        this.f18409j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18409j.setStrokeWidth(f10);
        this.f18409j.setColor(-1);
        this.f18409j.setDither(true);
        this.f18409j.setFilterBitmap(true);
        this.f18409j.setStrokeCap(Paint.Cap.ROUND);
        this.f18409j.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18411l = (int) (360.0f * f10);
        int i10 = this.f18408i;
        if (i10 == 0) {
            this.f18412m = (int) (f10 * 320.0f);
        } else {
            if (i10 != 1) {
                return;
            }
            this.f18412m = 320 - ((int) (f10 * 320.0f));
        }
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18408i + 1;
        this.f18408i = i10;
        if (i10 > 2) {
            this.f18408i = 0;
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18409j.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18409j.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d();
        y(0.6f * fD * 0.3f);
        this.f18411l = 0;
        RectF rectF = new RectF();
        this.f18410k = rectF;
        rectF.set(g() - fD, h() - fD, g() + fD, h() + fD);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.drawArc(this.f18410k, this.f18411l % 360, this.f18412m % 360, false, this.f18409j);
        canvas.restore();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
