package s5;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.view.ViewCompat;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class a extends com.live.evo.widget.sloading.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final LinkedList<C0354a> f18330i = new LinkedList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Paint f18331j;

    /* JADX INFO: renamed from: s5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class C0354a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f18332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f18333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f18334c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f18335d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f18336e = true;

        void a(Canvas canvas, float f10, Paint paint) {
            if (this.f18336e) {
                canvas.drawCircle(b(), c(), f10, paint);
            }
        }

        float b() {
            return this.f18332a + this.f18334c;
        }

        float c() {
            return this.f18333b + this.f18335d;
        }

        public void d(boolean z10) {
            this.f18336e = z10;
        }

        void e(float f10) {
            this.f18334c = f10;
        }

        void f(float f10) {
            this.f18335d = f10;
        }

        C0354a(float f10, float f11) {
            this.f18332a = f10;
            this.f18333b = f11;
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void q(int i10) {
        this.f18331j.setAlpha(i10);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void t(ColorFilter colorFilter) {
        this.f18331j.setColorFilter(colorFilter);
    }

    protected void z(float f10) {
        Paint paint = new Paint(1);
        this.f18331j = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18331j.setStrokeWidth(f10);
        this.f18331j.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f18331j.setDither(true);
        this.f18331j.setAntiAlias(true);
        this.f18331j.setFilterBitmap(true);
        this.f18331j.setStrokeCap(Paint.Cap.ROUND);
        this.f18331j.setStrokeJoin(Paint.Join.ROUND);
    }

    a() {
    }

    protected final void A(float f10) {
        float fG = g();
        float fH = h();
        float f11 = fG - f10;
        this.f18330i.add(new C0354a(f11, fH));
        float f12 = 0.55191505f * f10;
        float f13 = fH + f12;
        this.f18330i.add(new C0354a(f11, f13));
        float f14 = fG - f12;
        float f15 = fH + f10;
        this.f18330i.add(new C0354a(f14, f15));
        this.f18330i.add(new C0354a(fG, f15));
        float f16 = fG + f12;
        this.f18330i.add(new C0354a(f16, f15));
        float f17 = fG + f10;
        this.f18330i.add(new C0354a(f17, f13));
        this.f18330i.add(new C0354a(f17, fH));
        float f18 = fH - f12;
        this.f18330i.add(new C0354a(f17, f18));
        float f19 = fH - f10;
        this.f18330i.add(new C0354a(f16, f19));
        this.f18330i.add(new C0354a(fG, f19));
        this.f18330i.add(new C0354a(f14, f19));
        this.f18330i.add(new C0354a(f11, f18));
    }

    protected final void y(Canvas canvas, Path path, Paint paint) {
        path.reset();
        path.moveTo(this.f18330i.get(0).b(), this.f18330i.get(0).c());
        path.cubicTo(this.f18330i.get(1).b(), this.f18330i.get(1).c(), this.f18330i.get(2).b(), this.f18330i.get(2).c(), this.f18330i.get(3).b(), this.f18330i.get(3).c());
        path.cubicTo(this.f18330i.get(4).b(), this.f18330i.get(4).c(), this.f18330i.get(5).b(), this.f18330i.get(5).c(), this.f18330i.get(6).b(), this.f18330i.get(6).c());
        path.cubicTo(this.f18330i.get(7).b(), this.f18330i.get(7).c(), this.f18330i.get(8).b(), this.f18330i.get(8).c(), this.f18330i.get(9).b(), this.f18330i.get(9).c());
        path.cubicTo(this.f18330i.get(10).b(), this.f18330i.get(10).c(), this.f18330i.get(11).b(), this.f18330i.get(11).c(), this.f18330i.get(0).b(), this.f18330i.get(0).c());
        canvas.drawPath(path, paint);
    }
}
