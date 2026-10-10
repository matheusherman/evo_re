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
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18401i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Paint f18403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f18404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Path f18405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private PathMeasure f18406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f18407o;

    private void A() {
        float f10 = this.f18402j * 0.4f;
        Path path = new Path();
        this.f18404l = path;
        path.addArc(new RectF(g() - this.f18402j, h() - this.f18402j, g() + this.f18402j, h() + this.f18402j), 45.0f, 359.9f);
        this.f18406n.setPath(this.f18404l, false);
        float[] fArr = new float[2];
        this.f18406n.getPosTan(0.0f, fArr, null);
        Path path2 = new Path();
        this.f18405m = path2;
        path2.addArc(new RectF(g() - f10, h() - f10, g() + f10, h() + f10), 45.0f, 359.9f);
        this.f18405m.lineTo(fArr[0], fArr[1]);
    }

    private void B() {
        this.f18407o.reset();
        this.f18407o.lineTo(0.0f, 0.0f);
    }

    private void y() {
        Paint paint = new Paint(1);
        this.f18403k = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18403k.setStrokeWidth(15.0f);
        this.f18403k.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f18403k.setDither(true);
        this.f18403k.setFilterBitmap(true);
        this.f18403k.setStrokeCap(Paint.Cap.ROUND);
        this.f18403k.setStrokeJoin(Paint.Join.ROUND);
    }

    private void z() {
        this.f18407o = new Path();
        this.f18406n = new PathMeasure();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        int i10 = this.f18401i;
        if (i10 == 0 || i10 == 1) {
            B();
            this.f18406n.setPath(this.f18404l, false);
            float length = this.f18406n.getLength() * f10;
            this.f18406n.getSegment((float) (((double) length) - ((0.5d - Math.abs(((double) f10) - 0.5d)) * 200.0d)), length, this.f18407o, true);
            return;
        }
        if (i10 == 2) {
            B();
            this.f18406n.setPath(this.f18404l, false);
            this.f18406n.getSegment(0.0f, this.f18406n.getLength() * f10, this.f18407o, true);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f18406n.setPath(this.f18405m, false);
        float length2 = this.f18406n.getLength();
        this.f18406n.getSegment((1.0f - f10) * length2, length2, this.f18407o, true);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        canvas.drawPath(this.f18407o, this.f18403k);
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18401i + 1;
        this.f18401i = i10;
        if (i10 > 3) {
            this.f18401i = 0;
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setInterpolator(new DecelerateInterpolator());
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18403k.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18403k.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18402j = d();
        y();
        z();
        A();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }
}
