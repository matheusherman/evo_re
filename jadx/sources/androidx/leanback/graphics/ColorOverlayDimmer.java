package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class ColorOverlayDimmer {
    private final float mActiveLevel;
    private int mAlpha;
    private float mAlphaFloat;
    private final float mDimmedLevel;
    private final Paint mPaint;

    public static ColorOverlayDimmer createColorOverlayDimmer(int i10, float f10, float f11) {
        return new ColorOverlayDimmer(i10, f10, f11);
    }

    public static ColorOverlayDimmer createDefault(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        typedArrayObtainStyledAttributes.recycle();
        return new ColorOverlayDimmer(color, fraction, fraction2);
    }

    public int applyToColor(int i10) {
        float f10 = 1.0f - this.mAlphaFloat;
        return Color.argb(Color.alpha(i10), (int) (Color.red(i10) * f10), (int) (Color.green(i10) * f10), (int) (Color.blue(i10) * f10));
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getAlphaFloat() {
        return this.mAlphaFloat;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public boolean needsDraw() {
        return this.mAlpha != 0;
    }

    public void setActiveLevel(float f10) {
        float f11 = this.mDimmedLevel;
        float f12 = f11 + (f10 * (this.mActiveLevel - f11));
        this.mAlphaFloat = f12;
        int i10 = (int) (f12 * 255.0f);
        this.mAlpha = i10;
        this.mPaint.setAlpha(i10);
    }

    private ColorOverlayDimmer(int i10, float f10, float f11) {
        f10 = f10 > 1.0f ? 1.0f : f10;
        f10 = f10 < 0.0f ? 0.0f : f10;
        f11 = f11 > 1.0f ? 1.0f : f11;
        float f12 = f11 >= 0.0f ? f11 : 0.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.rgb(Color.red(i10), Color.green(i10), Color.blue(i10)));
        this.mActiveLevel = f10;
        this.mDimmedLevel = f12;
        setActiveLevel(1.0f);
    }

    public void drawColorOverlay(Canvas canvas, View view, boolean z10) {
        Canvas canvas2;
        canvas.save();
        float left = view.getLeft() + view.getTranslationX();
        float top = view.getTop() + view.getTranslationY();
        canvas.translate(left, top);
        canvas.concat(view.getMatrix());
        canvas.translate(-left, -top);
        if (z10) {
            canvas2 = canvas;
            canvas2.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), this.mPaint);
        } else {
            canvas2 = canvas;
            canvas2.drawRect(view.getLeft() + view.getPaddingLeft(), view.getTop() + view.getPaddingTop(), view.getRight() - view.getPaddingRight(), view.getBottom() - view.getPaddingBottom(), this.mPaint);
        }
        canvas2.restore();
    }
}
