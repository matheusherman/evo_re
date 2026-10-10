package s5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f18397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18400l;

    private void z(Canvas canvas) {
        for (int i10 = 0; i10 < 12; i10++) {
            int i11 = (int) ((30 * i10) + this.f18399k);
            float fG = g() + (this.f18398j * y(i11));
            float fH = h() + (this.f18398j * B(i11));
            this.f18397i.setAlpha((16 * i10) + 50);
            canvas.drawCircle(fG, fH, this.f18400l / 2.0f, this.f18397i);
        }
    }

    protected final float B(int i10) {
        return (float) Math.sin((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    protected final float y(int i10) {
        return (float) Math.cos((((double) i10) * 3.141592653589793d) / 180.0d);
    }

    private void A() {
        Paint paint = new Paint(1);
        this.f18397i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18397i.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f18397i.setDither(true);
        this.f18397i.setFilterBitmap(true);
        this.f18397i.setStrokeCap(Paint.Cap.ROUND);
        this.f18397i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18399k = f10 * 360.0f;
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18397i.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18397i.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18398j = d();
        A();
        this.f18400l = com.live.evo.widget.sloading.a.b(context, 5.0f);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        z(canvas);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
