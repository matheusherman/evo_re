package s5;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f18369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18370m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f18371n;

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f18371n;
        int i10 = this.f18370m;
        if (i10 == 0) {
            valueAnimator.setDuration(888L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f12 = f10 * f11;
            this.f18330i.get(2).f(f12);
            this.f18330i.get(3).f(f12);
            this.f18330i.get(4).f(f12);
            return;
        }
        if (i10 == 1) {
            valueAnimator.setDuration(222L);
            valueAnimator.setInterpolator(new LinearInterpolator());
            float f13 = f10 * f11;
            this.f18330i.get(5).f(f13);
            this.f18330i.get(6).f(f13);
            this.f18330i.get(7).f(f13);
            this.f18330i.get(1).f(f13);
            this.f18330i.get(0).f(f13);
            this.f18330i.get(11).f(f13);
            return;
        }
        if (i10 == 2) {
            valueAnimator.setDuration(333L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            for (int i11 = 0; i11 < this.f18330i.size(); i11++) {
                if (i11 > 10 || i11 < 8) {
                    this.f18330i.get(i11).f((f10 * f11) + f11);
                } else {
                    this.f18330i.get(i11).f(f10 * f11);
                }
            }
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            valueAnimator.setDuration(1333L);
            this.f18331j.setAlpha((int) ((1.0f - f10) * 255.0f));
            return;
        }
        valueAnimator.setDuration(1333L);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        float f14 = f10 * f11;
        float f15 = f14 + f11;
        this.f18330i.get(8).f(f15);
        this.f18330i.get(9).f(f15);
        this.f18330i.get(10).f(f15);
        this.f18330i.get(5).e(f14);
        this.f18330i.get(6).e(f14);
        this.f18330i.get(7).e(f14);
        float f16 = (-f10) * f11;
        this.f18330i.get(1).e(f16);
        this.f18330i.get(0).e(f16);
        this.f18330i.get(11).e(f16);
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18370m + 1;
        this.f18370m = i10;
        if (i10 > 4) {
            this.f18370m = 0;
            for (a.C0354a c0354a : this.f18330i) {
                c0354a.f(0.0f);
                c0354a.e(0.0f);
            }
            this.f18331j.setAlpha(255);
        }
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f18331j.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.translate(0.0f, -this.f18371n);
        super.y(canvas, this.f18369l, this.f18331j);
        canvas.restore();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18368k = d() / 3.0f;
        this.f18371n = f() / 3.0f;
        this.f18369l = new Path();
        z(5.0f);
        A(this.f18368k);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        B(canvas);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
