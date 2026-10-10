package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@SuppressLint({"AppCompatCustomView"})
class ResizingTextView extends TextView {
    public static final int TRIGGER_MAX_LINES = 1;
    private float mDefaultLineSpacingExtra;
    private int mDefaultPaddingBottom;
    private int mDefaultPaddingTop;
    private int mDefaultTextSize;
    private boolean mDefaultsInitialized;
    private boolean mIsResized;
    private boolean mMaintainLineSpacing;
    private int mResizedPaddingAdjustmentBottom;
    private int mResizedPaddingAdjustmentTop;
    private int mResizedTextSize;
    private int mTriggerConditions;

    @SuppressLint({"CustomViewStyleable"})
    public ResizingTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mIsResized = false;
        this.mDefaultsInitialized = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbResizingTextView, i10, i11);
        try {
            this.mTriggerConditions = typedArrayObtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbResizingTextView_resizeTrigger, 1);
            this.mResizedTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.leanback.R.styleable.lbResizingTextView_resizedTextSize, -1);
            this.mMaintainLineSpacing = typedArrayObtainStyledAttributes.getBoolean(androidx.leanback.R.styleable.lbResizingTextView_maintainLineSpacing, false);
            this.mResizedPaddingAdjustmentTop = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentTop, 0);
            this.mResizedPaddingAdjustmentBottom = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentBottom, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void resizeParamsChanged() {
        if (this.mIsResized) {
            requestLayout();
        }
    }

    public boolean getMaintainLineSpacing() {
        return this.mMaintainLineSpacing;
    }

    public int getResizedPaddingAdjustmentBottom() {
        return this.mResizedPaddingAdjustmentBottom;
    }

    public int getResizedPaddingAdjustmentTop() {
        return this.mResizedPaddingAdjustmentTop;
    }

    public int getResizedTextSize() {
        return this.mResizedTextSize;
    }

    public int getTriggerConditions() {
        return this.mTriggerConditions;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0053  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3 A[PHI: r2
      0x00d3: PHI (r2v7 boolean) = (r2v2 boolean), (r2v9 boolean) binds: [B:43:0x00d0, B:28:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11 = true;
        if (!this.mDefaultsInitialized) {
            this.mDefaultTextSize = (int) getTextSize();
            this.mDefaultLineSpacingExtra = getLineSpacingExtra();
            this.mDefaultPaddingTop = getPaddingTop();
            this.mDefaultPaddingBottom = getPaddingBottom();
            this.mDefaultsInitialized = true;
        }
        boolean z12 = false;
        setTextSize(0, this.mDefaultTextSize);
        setLineSpacing(this.mDefaultLineSpacingExtra, getLineSpacingMultiplier());
        setPaddingTopAndBottom(this.mDefaultPaddingTop, this.mDefaultPaddingBottom);
        super.onMeasure(i10, i11);
        Layout layout = getLayout();
        if (layout == null || (this.mTriggerConditions & 1) <= 0) {
            z10 = false;
        } else {
            int lineCount = layout.getLineCount();
            int maxLines = getMaxLines();
            if (maxLines <= 1 || lineCount != maxLines) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        int textSize = (int) getTextSize();
        if (z10) {
            int i13 = this.mResizedTextSize;
            if (i13 != -1 && textSize != i13) {
                setTextSize(0, i13);
                z12 = true;
            }
            float f10 = (this.mDefaultLineSpacingExtra + this.mDefaultTextSize) - this.mResizedTextSize;
            if (this.mMaintainLineSpacing && getLineSpacingExtra() != f10) {
                setLineSpacing(f10, getLineSpacingMultiplier());
                z12 = true;
            }
            int i14 = this.mDefaultPaddingTop + this.mResizedPaddingAdjustmentTop;
            int i15 = this.mDefaultPaddingBottom + this.mResizedPaddingAdjustmentBottom;
            if (getPaddingTop() == i14 && getPaddingBottom() == i15) {
                z11 = z12;
            } else {
                setPaddingTopAndBottom(i14, i15);
            }
        } else {
            if (this.mResizedTextSize != -1 && textSize != (i12 = this.mDefaultTextSize)) {
                setTextSize(0, i12);
                z12 = true;
            }
            if (this.mMaintainLineSpacing) {
                float lineSpacingExtra = getLineSpacingExtra();
                float f11 = this.mDefaultLineSpacingExtra;
                if (lineSpacingExtra != f11) {
                    setLineSpacing(f11, getLineSpacingMultiplier());
                    z12 = true;
                }
            }
            if (getPaddingTop() == this.mDefaultPaddingTop && getPaddingBottom() == this.mDefaultPaddingBottom) {
                z11 = z12;
            } else {
                setPaddingTopAndBottom(this.mDefaultPaddingTop, this.mDefaultPaddingBottom);
            }
        }
        this.mIsResized = z10;
        if (z11) {
            super.onMeasure(i10, i11);
        }
    }

    public void setMaintainLineSpacing(boolean z10) {
        if (this.mMaintainLineSpacing != z10) {
            this.mMaintainLineSpacing = z10;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentBottom(int i10) {
        if (this.mResizedPaddingAdjustmentBottom != i10) {
            this.mResizedPaddingAdjustmentBottom = i10;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentTop(int i10) {
        if (this.mResizedPaddingAdjustmentTop != i10) {
            this.mResizedPaddingAdjustmentTop = i10;
            resizeParamsChanged();
        }
    }

    public void setResizedTextSize(int i10) {
        if (this.mResizedTextSize != i10) {
            this.mResizedTextSize = i10;
            resizeParamsChanged();
        }
    }

    public void setTriggerConditions(int i10) {
        if (this.mTriggerConditions != i10) {
            this.mTriggerConditions = i10;
            requestLayout();
        }
    }

    private void setPaddingTopAndBottom(int i10, int i11) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i10, getPaddingEnd(), i11);
        } else {
            setPadding(getPaddingLeft(), i10, getPaddingRight(), i11);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public ResizingTextView(Context context) {
        this(context, null);
    }
}
