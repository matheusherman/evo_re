package x7;

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
public class p extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f21983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f21986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f21987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f21988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f21989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RectF f21990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f21991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ValueAnimator f21992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f21993t = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            p pVar = p.this;
            pVar.f21989p = pVar.h() * 0.4f * fFloatValue;
            p pVar2 = p.this;
            pVar2.f21991r = (pVar2.f21989p + 10.0f) * 0.9f;
        }
    }

    private void E() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.f21992s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.f21992s.setDuration(1333L);
        this.f21992s.setStartDelay(333L);
        this.f21992s.setInterpolator(new AccelerateDecelerateInterpolator());
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
        path.moveTo(g() + (this.f21985l * C(i14)), h() + (this.f21985l * G(i14)));
        for (int i15 = 0; i15 < i10; i15++) {
            int i16 = (i12 * i15) + i11;
            int i17 = i16 - 5;
            path.lineTo(g() + (this.f21985l * C(i17)), h() + (this.f21985l * G(i17)));
            int i18 = i16 + 5;
            path.quadTo(g() + (this.f21983j * C(i16)), h() + (this.f21983j * G(i16)), g() + (this.f21985l * C(i18)), h() + (this.f21985l * G(i18)));
            int i19 = i16 + i13;
            int i20 = i19 - 5;
            path.lineTo(g() + (this.f21984k * C(i20)), h() + (this.f21984k * G(i20)));
            float fG = g() + (this.f21986m * C(i19));
            float fH = h() + (this.f21986m * G(i19));
            int i21 = i19 + 5;
            path.quadTo(fG, fH, g() + (this.f21984k * C(i21)), h() + (this.f21984k * G(i21)));
        }
        path.close();
        return path;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21987n = (int) (f10 * 360.0f);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        Paint paint = new Paint(1);
        this.f21982i = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f21982i.setStrokeWidth(2.0f);
        this.f21982i.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f21982i.setDither(true);
        this.f21982i.setFilterBitmap(true);
        F(context);
        E();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
        this.f21992s.removeAllUpdateListeners();
        this.f21992s.removeAllListeners();
        this.f21992s.setRepeatCount(0);
        this.f21992s.setDuration(0L);
        this.f21992s.end();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.f21992s.setRepeatCount(-1);
        this.f21992s.setDuration(1333L);
        this.f21992s.setStartDelay(333L);
        this.f21992s.addUpdateListener(this.f21993t);
        this.f21992s.start();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21982i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21982i.setColorFilter(colorFilter);
    }

    private void F(Context context) {
        float fD = d() - com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 5.0f);
        this.f21983j = fD;
        float f10 = fD * 0.9f;
        this.f21985l = f10;
        float f11 = f10 * 0.6f;
        this.f21984k = f11;
        this.f21986m = f11 * 0.9f;
        this.f21987n = 0;
        this.f21989p = 0.0f;
        this.f21988o = D(5, -18);
        this.f21991r = this.f21983j;
        this.f21990q = new RectF();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.f21989p);
        canvas.rotate(this.f21987n, g(), h());
        canvas.drawPath(this.f21988o, this.f21982i);
        canvas.restore();
        this.f21990q.set(g() - this.f21991r, e() - 20.0f, g() + this.f21991r, e() - 10.0f);
        canvas.drawOval(this.f21990q, this.f21982i);
    }
}
