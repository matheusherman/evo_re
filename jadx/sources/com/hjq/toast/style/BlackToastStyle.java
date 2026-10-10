package com.hjq.toast.style;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hjq.toast.config.IToastStyle;
import l4.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class BlackToastStyle implements IToastStyle<View> {
    @Override // com.hjq.toast.config.IToastStyle
    public View createView(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setGravity(getTextGravity(context));
        textView.setTextColor(getTextColor(context));
        textView.setTextSize(0, getTextSize(context));
        int horizontalPadding = getHorizontalPadding(context);
        int verticalPadding = getVerticalPadding(context);
        textView.setPaddingRelative(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setBackground(getBackgroundDrawable(context));
        textView.setZ(getTranslationZ(context));
        return textView;
    }

    protected Drawable getBackgroundDrawable(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1291845632);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    protected int getTextGravity(Context context) {
        return 17;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public /* synthetic */ int getGravity() {
        return b.a(this);
    }

    @Override // com.hjq.toast.config.IToastStyle
    public /* synthetic */ float getHorizontalMargin() {
        return b.b(this);
    }

    protected int getHorizontalPadding(Context context) {
        return (int) TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
    }

    protected int getTextColor(Context context) {
        return -285212673;
    }

    protected float getTextSize(Context context) {
        return TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
    }

    protected float getTranslationZ(Context context) {
        return TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
    }

    @Override // com.hjq.toast.config.IToastStyle
    public /* synthetic */ float getVerticalMargin() {
        return b.c(this);
    }

    protected int getVerticalPadding(Context context) {
        return (int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics());
    }

    @Override // com.hjq.toast.config.IToastStyle
    public /* synthetic */ int getXOffset() {
        return b.d(this);
    }

    @Override // com.hjq.toast.config.IToastStyle
    public /* synthetic */ int getYOffset() {
        return b.e(this);
    }
}
