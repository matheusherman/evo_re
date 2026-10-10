package com.hjq.toast.style;

import android.content.Context;
import android.view.View;
import com.hjq.toast.config.IToastStyle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class LocationToastStyle implements IToastStyle<View> {
    private final int mGravity;
    private final float mHorizontalMargin;
    private final IToastStyle<?> mStyle;
    private final float mVerticalMargin;
    private final int mXOffset;
    private final int mYOffset;

    public LocationToastStyle(IToastStyle<?> iToastStyle, int i10) {
        this(iToastStyle, i10, 0, 0, 0.0f, 0.0f);
    }

    public LocationToastStyle(IToastStyle<?> iToastStyle, int i10, int i11, int i12, float f10, float f11) {
        this.mStyle = iToastStyle;
        this.mGravity = i10;
        this.mXOffset = i11;
        this.mYOffset = i12;
        this.mHorizontalMargin = f10;
        this.mVerticalMargin = f11;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public View createView(Context context) {
        return this.mStyle.createView(context);
    }

    @Override // com.hjq.toast.config.IToastStyle
    public int getGravity() {
        return this.mGravity;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public float getHorizontalMargin() {
        return this.mHorizontalMargin;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public float getVerticalMargin() {
        return this.mVerticalMargin;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public int getXOffset() {
        return this.mXOffset;
    }

    @Override // com.hjq.toast.config.IToastStyle
    public int getYOffset() {
        return this.mYOffset;
    }
}
