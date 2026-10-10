package s5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f18442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f18445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f18446n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final q6.b f18441i = q6.c.d(r.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18447o = Color.parseColor("#999999");

    private void y(Canvas canvas) {
        float f10 = this.f18443k / 2.0f;
        float fH = h();
        float f11 = this.f18445m + this.f18443k;
        canvas.drawCircle(f11, fH, f10, this.f18442j);
        canvas.drawCircle((this.f18444l - f11) + (this.f18443k * 2.0f), fH, f10, this.f18446n);
    }

    private void z() {
        Paint paint = new Paint(1);
        this.f18442j = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f18442j.setColor(-1);
        this.f18442j.setDither(true);
        this.f18442j.setFilterBitmap(true);
        Paint paint2 = this.f18442j;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        Paint paint3 = this.f18442j;
        Paint.Join join = Paint.Join.ROUND;
        paint3.setStrokeJoin(join);
        Paint paint4 = new Paint(1);
        this.f18446n = paint4;
        paint4.setStyle(style);
        this.f18446n.setColor(this.f18447o);
        this.f18446n.setDither(true);
        this.f18446n.setFilterBitmap(true);
        this.f18446n.setStrokeCap(cap);
        this.f18446n.setStrokeJoin(join);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        if (f10 <= 0.5f) {
            this.f18445m = this.f18444l * f10 * 2.0f;
        } else {
            this.f18445m = this.f18444l * (1.0f - f10) * 2.0f;
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18447o = i10;
        z();
        this.f18444l = com.live.evo.widget.sloading.a.b(context, 36.0f);
        this.f18443k = com.live.evo.widget.sloading.a.b(context, 13.0f);
        this.f18441i.debug("color extra = " + context, new Object[0]);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18442j.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void s(int i10) {
        this.f18447o = i10;
        this.f18441i.debug("color extra = " + i10, new Object[0]);
        this.f18446n.setColor(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18442j.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        y(canvas);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
