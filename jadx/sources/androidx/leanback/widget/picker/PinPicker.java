package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class PinPicker extends Picker {
    private static final int DEFAULT_COLUMN_COUNT = 4;

    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }

    @SuppressLint({"CustomViewStyleable"})
    public PinPicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int[] iArr = R.styleable.lbPinPicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbPinPicker_columnCount, 4));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public String getPin() {
        StringBuilder sb2 = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i10 = 0; i10 < columnsCount; i10++) {
            sb2.append(Integer.toString(getColumnAt(i10).getCurrentValue()));
        }
        return sb2.toString();
    }

    public void setNumberOfColumns(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            PickerColumn pickerColumn = new PickerColumn();
            pickerColumn.setMinValue(0);
            pickerColumn.setMaxValue(9);
            pickerColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            arrayList.add(pickerColumn);
        }
        setColumns(arrayList);
    }

    @Override // androidx.leanback.widget.picker.Picker, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 1 && keyCode >= 7 && keyCode <= 16) {
            setColumnValue(getSelectedColumn(), keyCode - 7, false);
            performClick();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    public void resetPin() {
        int columnsCount = getColumnsCount();
        for (int i10 = 0; i10 < columnsCount; i10++) {
            setColumnValue(i10, 0, false);
        }
        setSelectedColumn(0);
    }
}
