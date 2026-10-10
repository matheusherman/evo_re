package jf;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f11737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11738h = -1;

    @Override // jf.a
    protected void b(Canvas canvas, int i10, int i11) {
        this.f11737g.setAlpha(this.f11722a);
        ColorFilter colorFilterA = a();
        if (colorFilterA != null) {
            this.f11737g.setColorFilter(colorFilterA);
        }
        int intrinsicHeight = this.f11737g.getIntrinsicHeight();
        float f10 = i11 / intrinsicHeight;
        canvas.scale(f10, f10);
        float f11 = i10 / f10;
        int i12 = this.f11738h;
        if (i12 < 0) {
            int intrinsicWidth = this.f11737g.getIntrinsicWidth();
            int i13 = 0;
            while (i13 < f11) {
                int i14 = i13 + intrinsicWidth;
                this.f11737g.setBounds(i13, 0, i14, intrinsicHeight);
                this.f11737g.draw(canvas);
                i13 = i14;
            }
            return;
        }
        float f12 = f11 / i12;
        for (int i15 = 0; i15 < this.f11738h; i15++) {
            float f13 = (i15 + 0.5f) * f12;
            float intrinsicWidth2 = this.f11737g.getIntrinsicWidth() / 2.0f;
            this.f11737g.setBounds(Math.round(f13 - intrinsicWidth2), 0, Math.round(f13 + intrinsicWidth2), intrinsicHeight);
            this.f11737g.draw(canvas);
        }
    }

    public Drawable d() {
        return this.f11737g;
    }

    public void e(int i10) {
        this.f11738h = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f11737g = this.f11737g.mutate();
        return this;
    }

    public f(Drawable drawable) {
        this.f11737g = drawable;
    }
}
