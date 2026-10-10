package x7;

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
public class f extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f21917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21918k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextPaint f21921n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f21923p;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f21919l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21920m = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f21922o = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f21924q = false;

    private void y(Canvas canvas) {
        int i10 = 0;
        while (true) {
            int i11 = this.f21920m;
            if (i10 >= i11) {
                break;
            }
            int i12 = (360 / i11) * i10;
            float fCos = (((float) Math.cos((((double) (this.f21919l + i12)) * 3.141592653589793d) / 180.0d)) * this.f21917j) + g();
            float fSin = (((float) Math.sin((((double) (this.f21919l + i12)) * 3.141592653589793d) / 180.0d)) * this.f21917j) + h();
            i10++;
            this.f21916i.setAlpha((i10 * 255) / this.f21920m);
            canvas.drawCircle(fCos, fSin, this.f21918k, this.f21916i);
        }
        if (this.f21924q) {
            this.f21916i.setAlpha(255);
            this.f21916i.setTextSize(this.f21923p);
            this.f21916i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f21916i.getFontMetrics();
            float f10 = fontMetrics.bottom;
            canvas.drawText(this.f21922o, g(), h() + (((f10 - fontMetrics.top) / 2.0f) - f10), this.f21916i);
        }
    }

    private void z() {
        Paint paint = new Paint(1);
        this.f21916i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21916i.setColor(-1);
        this.f21916i.setDither(true);
        this.f21916i.setFilterBitmap(true);
        this.f21916i.setStrokeCap(Paint.Cap.ROUND);
        this.f21916i.setStrokeJoin(Paint.Join.ROUND);
        this.f21921n = new TextPaint();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21919l = (int) (f10 * 360.0f);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21916i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21916i.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    public void u(String str) {
        this.f21922o = str;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    public void v(boolean z10) {
        this.f21924q = z10;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        z();
        float fD = d();
        this.f21917j = fD;
        this.f21918k = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, fD / 10.0f);
        this.f21923p = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, this.f21917j / 4.0f);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        y(canvas);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void s(int i10) {
    }
}
