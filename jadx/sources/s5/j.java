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
public class j extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f18384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RectF f18385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18388m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f18390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f18392q;

    private void y() {
        Paint paint = new Paint(1);
        this.f18384i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18384i.setColor(-1);
        this.f18384i.setDither(true);
        this.f18384i.setFilterBitmap(true);
        this.f18384i.setStrokeCap(Paint.Cap.ROUND);
        this.f18384i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f18390o / 5;
        int i10 = this.f18388m;
        if (i10 < 5) {
            this.f18389n = 0;
            this.f18387l = this.f18391p + (f11 * f10);
        } else {
            this.f18389n = 180;
            this.f18387l = this.f18391p - (f11 * f10);
        }
        if (i10 % 2 == 0) {
            this.f18386k = ((int) (f10 * 45.0f)) + 5;
        } else {
            this.f18386k = ((int) ((1.0f - f10) * 45.0f)) + 5;
        }
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18388m + 1;
        this.f18388m = i10;
        if (i10 > 9) {
            this.f18388m = 0;
        }
        float f10 = this.f18390o / 5;
        int i11 = this.f18388m;
        if (i11 < 5) {
            this.f18391p = f10 * i11;
        } else {
            this.f18391p = f10 * (5 - (i11 % 5));
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(333L);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18384i.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18384i.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d() * 0.7f;
        this.f18390o = f() + (2.0f * fD);
        y();
        this.f18386k = 45;
        this.f18389n = 0;
        this.f18392q = (-this.f18390o) * 0.5f;
        this.f18387l = 0.0f;
        this.f18385j = new RectF(g() - fD, h() - fD, g() + fD, h() + fD);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f18392q + this.f18387l, 0.0f);
        canvas.rotate(this.f18389n, g(), h());
        RectF rectF = this.f18385j;
        int i10 = this.f18386k;
        canvas.drawArc(rectF, i10, 360 - (i10 * 2), true, this.f18384i);
        canvas.restore();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }
}
