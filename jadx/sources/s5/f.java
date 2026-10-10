package s5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f18359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18361k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextPaint f18364n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18366p;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18362l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18363m = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f18365o = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18367q = false;

    private void y(Canvas canvas) {
        int i10 = 0;
        while (true) {
            int i11 = this.f18363m;
            if (i10 >= i11) {
                break;
            }
            int i12 = (360 / i11) * i10;
            float fCos = (((float) Math.cos((((double) (this.f18362l + i12)) * 3.141592653589793d) / 180.0d)) * this.f18360j) + g();
            float fSin = (((float) Math.sin((((double) (this.f18362l + i12)) * 3.141592653589793d) / 180.0d)) * this.f18360j) + h();
            i10++;
            this.f18359i.setAlpha((i10 * 255) / this.f18363m);
            canvas.drawCircle(fCos, fSin, this.f18361k, this.f18359i);
        }
        if (this.f18367q) {
            this.f18359i.setAlpha(255);
            this.f18359i.setTextSize(this.f18366p);
            this.f18359i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f18359i.getFontMetrics();
            float f10 = fontMetrics.bottom;
            canvas.drawText(this.f18365o, g(), h() + (((f10 - fontMetrics.top) / 2.0f) - f10), this.f18359i);
        }
    }

    private void z() {
        Paint paint = new Paint(1);
        this.f18359i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18359i.setColor(-1);
        this.f18359i.setDither(true);
        this.f18359i.setFilterBitmap(true);
        this.f18359i.setStrokeCap(Paint.Cap.ROUND);
        this.f18359i.setStrokeJoin(Paint.Join.ROUND);
        this.f18364n = new TextPaint();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18362l = (int) (f10 * 360.0f);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18359i.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18359i.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    public void u(String str) {
        this.f18365o = str;
    }

    @Override // com.live.evo.widget.sloading.a
    public void v(boolean z10) {
        this.f18367q = z10;
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        z();
        float fD = d();
        this.f18360j = fD;
        this.f18361k = com.live.evo.widget.sloading.a.b(context, fD / 10.0f);
        this.f18366p = com.live.evo.widget.sloading.a.b(context, this.f18360j / 4.0f);
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

    @Override // com.live.evo.widget.sloading.a
    protected void s(int i10) {
    }
}
