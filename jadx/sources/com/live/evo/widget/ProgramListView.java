package com.live.evo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ProgramListView extends ListView {
    public ProgramListView(Context context) {
        super(context);
    }

    public ProgramListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgramListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        int top;
        int selectedItemPosition = getSelectedItemPosition();
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            View childAt = getChildAt(selectedItemPosition - getFirstVisiblePosition());
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            setSelectionFromTop(selectedItemPosition, top);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
    }
}
