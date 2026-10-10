package x7;

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
    private float f21925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f21926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21927m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f21928n;

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f21928n;
        int i10 = this.f21927m;
        if (i10 == 0) {
            valueAnimator.setDuration(888L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f12 = f10 * f11;
            this.f21887i.get(2).f(f12);
            this.f21887i.get(3).f(f12);
            this.f21887i.get(4).f(f12);
            return;
        }
        if (i10 == 1) {
            valueAnimator.setDuration(222L);
            valueAnimator.setInterpolator(new LinearInterpolator());
            float f13 = f10 * f11;
            this.f21887i.get(5).f(f13);
            this.f21887i.get(6).f(f13);
            this.f21887i.get(7).f(f13);
            this.f21887i.get(1).f(f13);
            this.f21887i.get(0).f(f13);
            this.f21887i.get(11).f(f13);
            return;
        }
        if (i10 == 2) {
            valueAnimator.setDuration(333L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            for (int i11 = 0; i11 < this.f21887i.size(); i11++) {
                if (i11 > 10 || i11 < 8) {
                    this.f21887i.get(i11).f((f10 * f11) + f11);
                } else {
                    this.f21887i.get(i11).f(f10 * f11);
                }
            }
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            valueAnimator.setDuration(1333L);
            this.f21888j.setAlpha((int) ((1.0f - f10) * 255.0f));
            return;
        }
        valueAnimator.setDuration(1333L);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        float f14 = f10 * f11;
        float f15 = f14 + f11;
        this.f21887i.get(8).f(f15);
        this.f21887i.get(9).f(f15);
        this.f21887i.get(10).f(f15);
        this.f21887i.get(5).e(f14);
        this.f21887i.get(6).e(f14);
        this.f21887i.get(7).e(f14);
        float f16 = (-f10) * f11;
        this.f21887i.get(1).e(f16);
        this.f21887i.get(0).e(f16);
        this.f21887i.get(11).e(f16);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21927m + 1;
        this.f21927m = i10;
        if (i10 > 4) {
            this.f21927m = 0;
            for (a.C0472a c0472a : this.f21887i) {
                c0472a.f(0.0f);
                c0472a.e(0.0f);
            }
            this.f21888j.setAlpha(255);
        }
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f21888j.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.translate(0.0f, -this.f21928n);
        super.y(canvas, this.f21926l, this.f21888j);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f21925k = d() / 3.0f;
        this.f21928n = f() / 3.0f;
        this.f21926l = new Path();
        z(5.0f);
        A(this.f21925k);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        B(canvas);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
