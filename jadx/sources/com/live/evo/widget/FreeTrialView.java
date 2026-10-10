package com.live.evo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.live.evo.R$color;
import com.live.evo.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FreeTrialView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f7440d;

    public FreeTrialView(Context context) {
        super(context);
    }

    public FreeTrialView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FreeTrialViewStyle, 0, 0);
        this.f7437a = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R$color.color_focused));
        this.f7438b = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R$color.normal_text_color));
        this.f7439c = (String) typedArrayObtainStyledAttributes.getText(1);
        this.f7440d = typedArrayObtainStyledAttributes.getDimension(3, 30.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        double d10 = height;
        path.moveTo(0.0f, (float) (d10 * 0.67d));
        path.lineTo(0.0f, height);
        path.lineTo(width, 0.0f);
        double d11 = width;
        path.lineTo((float) (0.67d * d11), 0.0f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f7437a);
        paint.setTextSize(this.f7440d);
        float fMeasureText = paint.measureText(this.f7439c);
        canvas.drawPath(path, paint);
        paint.setColor(this.f7438b);
        paint.setTypeface(com.live.evo.util.s.b());
        float f10 = (float) ((d11 * 0.845d) / 2.0d);
        float f11 = (float) ((0.845d * d10) / 2.0d);
        canvas.rotate(-((float) (((double) (((float) Math.atan2(d10, d11)) * 180.0f)) / 3.141592653589793d)), f10, f11);
        canvas.drawText(this.f7439c, f10 - (fMeasureText / 2.0f), f11 + (this.f7440d / 4.0f), paint);
    }
}
