package com.hjq.toast.style;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hjq.toast.config.IToastStyle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class CustomToastStyle implements IToastStyle<View> {
    private final int mGravity;
    private final float mHorizontalMargin;
    private final int mLayoutId;
    private final float mVerticalMargin;
    private final int mXOffset;
    private final int mYOffset;

    public CustomToastStyle(int i10) {
        this(i10, 17);
    }

    public CustomToastStyle(int i10, int i11) {
        this(i10, i11, 0, 0);
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

    public CustomToastStyle(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, 0.0f, 0.0f);
    }

    @Override // com.hjq.toast.config.IToastStyle
    public View createView(Context context) {
        return LayoutInflater.from(context).inflate(this.mLayoutId, (ViewGroup) null);
    }

    public CustomToastStyle(int i10, int i11, int i12, int i13, float f10, float f11) {
        this.mLayoutId = i10;
        this.mGravity = i11;
        this.mXOffset = i12;
        this.mYOffset = i13;
        this.mHorizontalMargin = f10;
        this.mVerticalMargin = f11;
    }
}
