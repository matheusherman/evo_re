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
public class k extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f18393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18396l;

    private void z(Canvas canvas) {
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = (int) ((36 * i10) + this.f18395k);
            float fG = g() + (this.f18394j * y(i11));
            float fH = h() + (this.f18394j * B(i11));
            this.f18393i.setAlpha(25 * i10);
            canvas.drawCircle(fG, fH, (i10 + this.f18396l) / 2.0f, this.f18393i);
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
        this.f18393i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18393i.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f18393i.setDither(true);
        this.f18393i.setFilterBitmap(true);
        this.f18393i.setStrokeCap(Paint.Cap.ROUND);
        this.f18393i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f18395k = f10 * 360.0f;
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18393i.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18393i.setColorFilter(colorFilter);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18394j = d();
        A();
        this.f18396l = com.live.evo.widget.sloading.a.b(context, 2.0f);
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
