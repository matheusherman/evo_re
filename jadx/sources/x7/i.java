package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f21933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f21936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f21937n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f21938o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f21939p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Path f21940q;

    protected final float B(int i10) {
        return (float) Math.sin((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    protected final float y(int i10) {
        return (float) Math.cos((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    private void A() {
        Paint paint = new Paint(1);
        this.f21932i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21932i.setStrokeWidth(2.0f);
        this.f21932i.setColor(-1);
        this.f21932i.setDither(true);
        this.f21932i.setFilterBitmap(true);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        int i10 = this.f21939p;
        if (i10 == 0) {
            this.f21935l = d() * f10;
            this.f21938o = (int) (f10 * 360.0f);
        } else if (i10 == 1) {
            this.f21938o = (int) ((1.0f - f10) * 360.0f);
        } else {
            if (i10 != 2) {
                return;
            }
            this.f21935l = d() * (1.0f - f10);
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21939p + 1;
        this.f21939p = i10;
        if (i10 > 2) {
            this.f21939p = 0;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setInterpolator(new DecelerateInterpolator());
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21932i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21932i.setColorFilter(colorFilter);
    }

    private void z(Path path, int i10, int i11) {
        path.reset();
        int i12 = 360 / i10;
        int i13 = i12 / 2;
        int i14 = i11 - 5;
        path.moveTo(g() + (this.f21935l * y(i14)), h() + (this.f21935l * B(i14)));
        for (int i15 = 0; i15 < i10; i15++) {
            int i16 = (i12 * i15) + i11;
            int i17 = i16 - 5;
            path.lineTo(g() + (this.f21935l * y(i17)), h() + (this.f21935l * B(i17)));
            int i18 = i16 + 5;
            path.quadTo(g() + (this.f21933j * y(i16)), h() + (this.f21933j * B(i16)), g() + (this.f21935l * y(i18)), h() + (this.f21935l * B(i18)));
            int i19 = i16 + i13;
            int i20 = i19 - 5;
            path.lineTo(g() + (this.f21934k * y(i20)), h() + (this.f21934k * B(i20)));
            float fG = g() + (this.f21936m * y(i19));
            float fH = h() + (this.f21936m * B(i19));
            int i21 = i19 + 5;
            path.quadTo(fG, fH, g() + (this.f21934k * y(i21)), h() + (this.f21934k * B(i21)));
        }
        path.close();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        A();
        float fD = d();
        this.f21933j = fD;
        this.f21935l = 0.9f * fD;
        this.f21934k = 0.7f * fD;
        this.f21936m = fD * 0.3f;
        this.f21937n = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 3.0f);
        this.f21938o = 0;
        this.f21940q = new Path();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.f21938o, g(), h());
        z(this.f21940q, 5, -18);
        this.f21940q.addCircle(g(), h(), this.f21937n, Path.Direction.CW);
        this.f21940q.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(this.f21940q, this.f21932i);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }
}
