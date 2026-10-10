package x7;

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
public class l extends com.tvc.lib.mobile.ui.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f21954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f21955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f21956k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21957l;

    private void z(Canvas canvas) {
        for (int i10 = 0; i10 < 12; i10++) {
            int i11 = (int) ((30 * i10) + this.f21956k);
            float fG = g() + (this.f21955j * y(i11));
            float fH = h() + (this.f21955j * B(i11));
            this.f21954i.setAlpha((16 * i10) + 50);
            canvas.drawCircle(fG, fH, this.f21957l / 2.0f, this.f21954i);
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
        this.f21954i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21954i.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f21954i.setDither(true);
        this.f21954i.setFilterBitmap(true);
        this.f21954i.setStrokeCap(Paint.Cap.ROUND);
        this.f21954i.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.f21956k = f10 * 360.0f;
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void q(int i10) {
        this.f21954i.setAlpha(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f21954i.setColorFilter(colorFilter);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f21955j = d();
        A();
        this.f21957l = com.tvc.lib.mobile.ui.widget.sloading.a.b(context, 5.0f);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        z(canvas);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
    }
}
