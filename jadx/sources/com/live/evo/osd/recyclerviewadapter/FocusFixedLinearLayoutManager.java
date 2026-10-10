package com.live.evo.osd.recyclerviewadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FocusFixedLinearLayoutManager extends LinearLayoutManager {
    public FocusFixedLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public FocusFixedLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View view, int i10) {
        int position = getPosition(getFocusedChild());
        int itemCount = getItemCount();
        int iFindLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i10 != 33) {
            if (i10 == 130) {
                position++;
            }
        } else {
            position--;
        }
        if (position >= 0 && position <= itemCount) {
            if (position > iFindLastVisibleItemPosition) {
                scrollToPosition(position);
            }
            return super.onInterceptFocusSearch(view, i10);
        }
        return view;
    }
}
