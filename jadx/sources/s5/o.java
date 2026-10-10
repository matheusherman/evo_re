package s5;

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
public class o extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f18414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RectF f18417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RectF f18418n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f18421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Path f18422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private PathMeasure f18423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Path f18424t;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18413i = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18419o = 255;

    private void A() {
        Path path = new Path();
        this.f18422r = path;
        float f10 = this.f18415k;
        float f11 = f10 * 0.3f;
        float f12 = f10 * 0.3f * 0.5f;
        path.moveTo(g() - (this.f18415k * 0.8f), h());
        this.f18422r.lineTo(g() - f11, h());
        this.f18422r.lineTo(g() - f12, h() + f12);
        this.f18422r.lineTo(g() + f12, h() - f12);
        this.f18422r.lineTo(g() + f11, h());
        this.f18422r.lineTo(g() + (this.f18415k * 0.8f), h());
    }

    private void B() {
        this.f18424t.reset();
        this.f18424t.lineTo(0.0f, 0.0f);
    }

    private void y(float f10) {
        Paint paint = new Paint(1);
        this.f18414j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18414j.setStrokeWidth(f10);
        this.f18414j.setColor(-1);
        this.f18414j.setDither(true);
        this.f18414j.setFilterBitmap(true);
        this.f18414j.setStrokeCap(Paint.Cap.ROUND);
        this.f18414j.setStrokeJoin(Paint.Join.ROUND);
    }

    private void z() {
        this.f18424t = new Path();
        this.f18423s = new PathMeasure();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18420p = f10 * 360.0f;
        this.f18421q = (1.0f - f10) * 360.0f;
        int i10 = this.f18413i;
        if (i10 == 0) {
            B();
            this.f18423s.setPath(this.f18422r, false);
            this.f18423s.getSegment(0.0f, this.f18423s.getLength() * f10, this.f18424t, true);
            return;
        }
        if (i10 != 1) {
            return;
        }
        B();
        this.f18423s.setPath(this.f18422r, false);
        float length = this.f18423s.getLength();
        this.f18423s.getSegment(this.f18423s.getLength() * f10, length, this.f18424t, true);
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18413i + 1;
        this.f18413i = i10;
        if (i10 > 1) {
            this.f18413i = 0;
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18419o = i10;
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18414j.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        float fD = d() * 1.0f;
        this.f18415k = fD;
        float f10 = fD * 0.7f;
        this.f18416l = f10;
        y(f10 * 0.4f);
        this.f18420p = 0.0f;
        RectF rectF = new RectF();
        this.f18417m = rectF;
        rectF.set(g() - this.f18415k, h() - this.f18415k, g() + this.f18415k, h() + this.f18415k);
        RectF rectF2 = new RectF();
        this.f18418n = rectF2;
        rectF2.set(g() - this.f18416l, h() - this.f18416l, g() + this.f18416l, h() + this.f18416l);
        z();
        A();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.save();
        this.f18414j.setStrokeWidth(this.f18415k * 0.05f);
        this.f18414j.setAlpha((int) (this.f18419o * 0.6f));
        canvas.drawCircle(g(), h(), this.f18415k, this.f18414j);
        canvas.drawCircle(g(), h(), this.f18416l, this.f18414j);
        canvas.restore();
        canvas.save();
        this.f18414j.setStrokeWidth(this.f18415k * 0.1f);
        this.f18414j.setAlpha(this.f18419o);
        canvas.rotate(this.f18420p, g(), h());
        canvas.drawArc(this.f18417m, 0.0f, 120.0f, false, this.f18414j);
        canvas.drawArc(this.f18417m, 180.0f, 120.0f, false, this.f18414j);
        canvas.restore();
        canvas.save();
        this.f18414j.setAlpha((int) (this.f18419o * 0.6f));
        canvas.drawPath(this.f18424t, this.f18414j);
        canvas.restore();
        canvas.save();
        this.f18414j.setStrokeWidth(this.f18415k * 0.1f);
        this.f18414j.setAlpha(this.f18419o);
        canvas.rotate(this.f18421q, g(), h());
        canvas.drawArc(this.f18418n, 60.0f, 60.0f, false, this.f18414j);
        canvas.drawArc(this.f18418n, 180.0f, 180.0f, false, this.f18414j);
        canvas.restore();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
