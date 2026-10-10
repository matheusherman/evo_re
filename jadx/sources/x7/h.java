package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f21930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21931m = 0;

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        int i10 = this.f21931m;
        int i11 = 0;
        if (i10 == 0) {
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            while (i11 < this.f21887i.size()) {
                a.C0472a c0472a = this.f21887i.get(i11);
                if (2 > i11 || i11 > 7) {
                    c0472a.e(this.f21929k * f10);
                    c0472a.f(this.f21929k * f10);
                } else {
                    c0472a.e((-this.f21929k) * f10);
                    c0472a.f((-this.f21929k) * f10);
                }
                i11++;
            }
            return;
        }
        if (i10 != 1) {
            return;
        }
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        while (i11 < this.f21887i.size()) {
            a.C0472a c0472a2 = this.f21887i.get(i11);
            if (2 > i11 || i11 > 7) {
                float f11 = 1.0f - f10;
                c0472a2.e(this.f21929k * f11);
                c0472a2.f(this.f21929k * f11);
            } else {
                float f12 = 1.0f - f10;
                c0472a2.e((-this.f21929k) * f12);
                c0472a2.f((-this.f21929k) * f12);
            }
            i11++;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21931m + 1;
        this.f21931m = i10;
        if (i10 > 1) {
            this.f21931m = 0;
            for (a.C0472a c0472a : this.f21887i) {
                c0472a.f(0.0f);
                c0472a.e(0.0f);
            }
        }
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f21888j.setStyle(Paint.Style.FILL_AND_STROKE);
        super.y(canvas, this.f21930l, this.f21888j);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f21929k = d();
        this.f21930l = new Path();
        z(5.0f);
        A(this.f21929k);
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
