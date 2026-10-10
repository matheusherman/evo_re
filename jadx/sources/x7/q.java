package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f21996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21997k = 0;

    private boolean y() {
        String str = this.f21996j;
        return (str == null || str.isEmpty()) ? false : true;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21995i.setAlpha(((int) (f10 * 155.0f)) + 100);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        Paint paint = new Paint(1);
        this.f21995i = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f21995i.setDither(true);
        this.f21995i.setFilterBitmap(true);
        this.f21995i.setTextSize(56.0f);
        this.f21995i.setStyle(Paint.Style.FILL);
        this.f21995i.setTextAlign(Paint.Align.LEFT);
        this.f21996j = "Zyao89";
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        if (y()) {
            int length = this.f21996j.toCharArray().length;
            float fMeasureText = this.f21995i.measureText(this.f21996j, 0, length);
            Paint paint = new Paint(this.f21995i);
            paint.setAlpha(100);
            float f10 = fMeasureText / 2.0f;
            canvas.drawText(this.f21996j, 0, length, g() - f10, h(), paint);
            canvas.drawText(this.f21996j, 0, this.f21997k, g() - f10, h(), this.f21995i);
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(333L);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21995i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21995i.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        if (y()) {
            int i10 = this.f21997k + 1;
            this.f21997k = i10;
            if (i10 > this.f21996j.toCharArray().length) {
                this.f21997k = 0;
            }
        }
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        float fMeasureText = this.f21995i.measureText(str);
        if (fMeasureText >= f()) {
            this.f21995i.setTextSize(f() / (fMeasureText / 56.0f));
        }
        this.f21996j = str;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }
}
