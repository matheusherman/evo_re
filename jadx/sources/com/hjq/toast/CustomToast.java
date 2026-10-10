package com.hjq.toast;

import android.view.View;
import android.widget.TextView;
import com.hjq.toast.config.IToast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class CustomToast implements IToast {
    private int mDuration;
    private int mGravity;
    private float mHorizontalMargin;
    private TextView mMessageView;
    private float mVerticalMargin;
    private View mView;
    private int mXOffset;
    private int mYOffset;
    private int mAnimations = android.R.style.Animation.Toast;
    private int mShortDuration = 2000;
    private int mLongDuration = 3500;

    @Override // com.hjq.toast.config.IToast
    public void setText(int i10) {
        View view = this.mView;
        if (view == null) {
            return;
        }
        setText(view.getResources().getString(i10));
    }

    public int getAnimationsId() {
        return this.mAnimations;
    }

    @Override // com.hjq.toast.config.IToast
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.hjq.toast.config.IToast
    public int getGravity() {
        return this.mGravity;
    }

    @Override // com.hjq.toast.config.IToast
    public float getHorizontalMargin() {
        return this.mHorizontalMargin;
    }

    public int getLongDuration() {
        return this.mLongDuration;
    }

    public int getShortDuration() {
        return this.mShortDuration;
    }

    @Override // com.hjq.toast.config.IToast
    public float getVerticalMargin() {
        return this.mVerticalMargin;
    }

    @Override // com.hjq.toast.config.IToast
    public View getView() {
        return this.mView;
    }

    @Override // com.hjq.toast.config.IToast
    public int getXOffset() {
        return this.mXOffset;
    }

    @Override // com.hjq.toast.config.IToast
    public int getYOffset() {
        return this.mYOffset;
    }

    public void setAnimationsId(int i10) {
        this.mAnimations = i10;
    }

    @Override // com.hjq.toast.config.IToast
    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    @Override // com.hjq.toast.config.IToast
    public void setGravity(int i10, int i11, int i12) {
        this.mGravity = i10;
        this.mXOffset = i11;
        this.mYOffset = i12;
    }

    public void setLongDuration(int i10) {
        this.mLongDuration = i10;
    }

    @Override // com.hjq.toast.config.IToast
    public void setMargin(float f10, float f11) {
        this.mHorizontalMargin = f10;
        this.mVerticalMargin = f11;
    }

    public void setShortDuration(int i10) {
        this.mShortDuration = i10;
    }

    @Override // com.hjq.toast.config.IToast
    public void setView(View view) {
        this.mView = view;
        if (view == null) {
            this.mMessageView = null;
        } else {
            this.mMessageView = findMessageView(view);
        }
    }

    @Override // com.hjq.toast.config.IToast
    public /* synthetic */ TextView findMessageView(View view) {
        return l4.a.a(this, view);
    }

    @Override // com.hjq.toast.config.IToast
    public void setText(CharSequence charSequence) {
        TextView textView = this.mMessageView;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }
}
