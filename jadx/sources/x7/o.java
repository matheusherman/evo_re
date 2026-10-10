package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f21971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RectF f21974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RectF f21975n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f21977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f21978q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Path f21979r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private PathMeasure f21980s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Path f21981t;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21970i = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f21976o = 255;

    private void A() {
        Path path = new Path();
        this.f21979r = path;
        float f10 = this.f21972k;
        float f11 = f10 * 0.3f;
        float f12 = f10 * 0.3f * 0.5f;
        path.moveTo(g() - (this.f21972k * 0.8f), h());
        this.f21979r.lineTo(g() - f11, h());
        this.f21979r.lineTo(g() - f12, h() + f12);
        this.f21979r.lineTo(g() + f12, h() - f12);
        this.f21979r.lineTo(g() + f11, h());
        this.f21979r.lineTo(g() + (this.f21972k * 0.8f), h());
    }

    private void B() {
        this.f21981t.reset();
        this.f21981t.lineTo(0.0f, 0.0f);
    }

    private void y(float f10) {
        Paint paint = new Paint(1);
        this.f21971j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f21971j.setStrokeWidth(f10);
        this.f21971j.setColor(-1);
        this.f21971j.setDither(true);
        this.f21971j.setFilterBitmap(true);
        this.f21971j.setStrokeCap(Paint.Cap.ROUND);
        this.f21971j.setStrokeJoin(Paint.Join.ROUND);
    }

    private void z() {
        this.f21981t = new Path();
        this.f21980s = new PathMeasure();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21977p = f10 * 360.0f;
        this.f21978q = (1.0f - f10) * 360.0f;
        int i10 = this.f21970i;
        if (i10 == 0) {
            B();
            this.f21980s.setPath(this.f21979r, false);
            this.f21980s.getSegment(0.0f, this.f21980s.getLength() * f10, this.f21981t, true);
            return;
        }
        if (i10 != 1) {
            return;
        }
        B();
        this.f21980s.setPath(this.f21979r, false);
        float length = this.f21980s.getLength();
        this.f21980s.getSegment(this.f21980s.getLength() * f10, length, this.f21981t, true);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21970i + 1;
        this.f21970i = i10;
        if (i10 > 1) {
            this.f21970i = 0;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21976o = i10;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21971j.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d() * 1.0f;
        this.f21972k = fD;
        float f10 = fD * 0.7f;
        this.f21973l = f10;
        y(f10 * 0.4f);
        this.f21977p = 0.0f;
        RectF rectF = new RectF();
        this.f21974m = rectF;
        rectF.set(g() - this.f21972k, h() - this.f21972k, g() + this.f21972k, h() + this.f21972k);
        RectF rectF2 = new RectF();
        this.f21975n = rectF2;
        rectF2.set(g() - this.f21973l, h() - this.f21973l, g() + this.f21973l, h() + this.f21973l);
        z();
        A();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        this.f21971j.setStrokeWidth(this.f21972k * 0.05f);
        this.f21971j.setAlpha((int) (this.f21976o * 0.6f));
        canvas.drawCircle(g(), h(), this.f21972k, this.f21971j);
        canvas.drawCircle(g(), h(), this.f21973l, this.f21971j);
        canvas.restore();
        canvas.save();
        this.f21971j.setStrokeWidth(this.f21972k * 0.1f);
        this.f21971j.setAlpha(this.f21976o);
        canvas.rotate(this.f21977p, g(), h());
        canvas.drawArc(this.f21974m, 0.0f, 120.0f, false, this.f21971j);
        canvas.drawArc(this.f21974m, 180.0f, 120.0f, false, this.f21971j);
        canvas.restore();
        canvas.save();
        this.f21971j.setAlpha((int) (this.f21976o * 0.6f));
        canvas.drawPath(this.f21981t, this.f21971j);
        canvas.restore();
        canvas.save();
        this.f21971j.setStrokeWidth(this.f21972k * 0.1f);
        this.f21971j.setAlpha(this.f21976o);
        canvas.rotate(this.f21978q, g(), h());
        canvas.drawArc(this.f21975n, 60.0f, 60.0f, false, this.f21971j);
        canvas.drawArc(this.f21975n, 180.0f, 180.0f, false, this.f21971j);
        canvas.restore();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
