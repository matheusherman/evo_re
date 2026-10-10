package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RectangleIndicator extends BaseIndicator {
    RectF rectF;

    public RectangleIndicator(Context context) {
        this(context, null);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.rectF = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int normalColor;
        int normalWidth;
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            float indicatorSpace = 0.0f;
            for (int i10 = 0; i10 < indicatorSize; i10++) {
                Paint paint = this.mPaint;
                if (this.config.getCurrentPosition() == i10) {
                    normalColor = this.config.getSelectedColor();
                } else {
                    normalColor = this.config.getNormalColor();
                }
                paint.setColor(normalColor);
                if (this.config.getCurrentPosition() == i10) {
                    normalWidth = this.config.getSelectedWidth();
                } else {
                    normalWidth = this.config.getNormalWidth();
                }
                this.rectF.set(indicatorSpace, 0.0f, normalWidth + indicatorSpace, this.config.getHeight());
                indicatorSpace += normalWidth + this.config.getIndicatorSpace();
                canvas.drawRoundRect(this.rectF, this.config.getRadius(), this.config.getRadius(), this.mPaint);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        int i12 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i12) + (this.config.getNormalWidth() * i12) + this.config.getSelectedWidth(), this.config.getHeight());
    }
}
