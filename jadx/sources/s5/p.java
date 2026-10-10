package s5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f18425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f18429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f18431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RectF f18433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f18434r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ValueAnimator f18435s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f18436t = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            p pVar = p.this;
            pVar.f18432p = pVar.h() * 0.4f * fFloatValue;
            p pVar2 = p.this;
            pVar2.f18434r = (pVar2.f18432p + 10.0f) * 0.9f;
        }
    }

    private void E() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.f18435s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.f18435s.setDuration(1333L);
        this.f18435s.setStartDelay(333L);
        this.f18435s.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    protected final float C(int i10) {
        return (float) Math.cos((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    protected final float G(int i10) {
        return (float) Math.sin((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    private Path D(int i10, int i11) {
        Path path = new Path();
        int i12 = 360 / i10;
        int i13 = i12 / 2;
        int i14 = i11 - 5;
        path.moveTo(g() + (this.f18428l * C(i14)), h() + (this.f18428l * G(i14)));
        for (int i15 = 0; i15 < i10; i15++) {
            int i16 = (i12 * i15) + i11;
            int i17 = i16 - 5;
            path.lineTo(g() + (this.f18428l * C(i17)), h() + (this.f18428l * G(i17)));
            int i18 = i16 + 5;
            path.quadTo(g() + (this.f18426j * C(i16)), h() + (this.f18426j * G(i16)), g() + (this.f18428l * C(i18)), h() + (this.f18428l * G(i18)));
            int i19 = i16 + i13;
            int i20 = i19 - 5;
            path.lineTo(g() + (this.f18427k * C(i20)), h() + (this.f18427k * G(i20)));
            float fG = g() + (this.f18429m * C(i19));
            float fH = h() + (this.f18429m * G(i19));
            int i21 = i19 + 5;
            path.quadTo(fG, fH, g() + (this.f18427k * C(i21)), h() + (this.f18427k * G(i21)));
        }
        path.close();
        return path;
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18430n = (int) (f10 * 360.0f);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        Paint paint = new Paint(1);
        this.f18425i = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18425i.setStrokeWidth(2.0f);
        this.f18425i.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f18425i.setDither(true);
        this.f18425i.setFilterBitmap(true);
        F(context);
        E();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
        this.f18435s.removeAllUpdateListeners();
        this.f18435s.removeAllListeners();
        this.f18435s.setRepeatCount(0);
        this.f18435s.setDuration(0L);
        this.f18435s.end();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.f18435s.setRepeatCount(-1);
        this.f18435s.setDuration(1333L);
        this.f18435s.setStartDelay(333L);
        this.f18435s.addUpdateListener(this.f18436t);
        this.f18435s.start();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18425i.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18425i.setColorFilter(colorFilter);
    }

    private void F(Context context) {
        float fD = d() - com.live.evo.widget.sloading.a.b(context, 5.0f);
        this.f18426j = fD;
        float f10 = fD * 0.9f;
        this.f18428l = f10;
        float f11 = f10 * 0.6f;
        this.f18427k = f11;
        this.f18429m = f11 * 0.9f;
        this.f18430n = 0;
        this.f18432p = 0.0f;
        this.f18431o = D(5, -18);
        this.f18434r = this.f18426j;
        this.f18433q = new RectF();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.f18432p);
        canvas.rotate(this.f18430n, g(), h());
        canvas.drawPath(this.f18431o, this.f18425i);
        canvas.restore();
        this.f18433q.set(g() - this.f18434r, e() - 20.0f, g() + this.f18434r, e() - 10.0f);
        canvas.drawOval(this.f18433q, this.f18425i);
    }
}
