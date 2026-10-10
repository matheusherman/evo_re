package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class VerticalGridView extends BaseGridView {
    public VerticalGridView(Context context) {
        this(context, null);
    }

    void setColumnWidth(TypedArray typedArray) {
        int i10 = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i10) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i10, 0));
        }
    }

    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setNumColumns(int i10) {
        this.mLayoutManager.setNumRows(i10);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLayoutManager.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    @SuppressLint({"CustomViewStyleable"})
    protected void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        int[] iArr = R.styleable.lbVerticalGridView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        setColumnWidth(typedArrayObtainStyledAttributes);
        setNumColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setColumnWidth(int i10) {
        this.mLayoutManager.setRowHeight(i10);
        requestLayout();
    }
}
