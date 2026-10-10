package s5;

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
    private float f18372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f18373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18374m = 0;

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        int i10 = this.f18374m;
        int i11 = 0;
        if (i10 == 0) {
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            while (i11 < this.f18330i.size()) {
                a.C0354a c0354a = this.f18330i.get(i11);
                if (2 > i11 || i11 > 7) {
                    c0354a.e(this.f18372k * f10);
                    c0354a.f(this.f18372k * f10);
                } else {
                    c0354a.e((-this.f18372k) * f10);
                    c0354a.f((-this.f18372k) * f10);
                }
                i11++;
            }
            return;
        }
        if (i10 != 1) {
            return;
        }
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        while (i11 < this.f18330i.size()) {
            a.C0354a c0354a2 = this.f18330i.get(i11);
            if (2 > i11 || i11 > 7) {
                float f11 = 1.0f - f10;
                c0354a2.e(this.f18372k * f11);
                c0354a2.f(this.f18372k * f11);
            } else {
                float f12 = 1.0f - f10;
                c0354a2.e((-this.f18372k) * f12);
                c0354a2.f((-this.f18372k) * f12);
            }
            i11++;
        }
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18374m + 1;
        this.f18374m = i10;
        if (i10 > 1) {
            this.f18374m = 0;
            for (a.C0354a c0354a : this.f18330i) {
                c0354a.f(0.0f);
                c0354a.e(0.0f);
            }
        }
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f18331j.setStyle(Paint.Style.FILL_AND_STROKE);
        super.y(canvas, this.f18373l, this.f18331j);
        canvas.restore();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18372k = d();
        this.f18373l = new Path();
        z(5.0f);
        A(this.f18372k);
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
