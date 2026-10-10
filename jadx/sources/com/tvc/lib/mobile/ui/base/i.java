package com.tvc.lib.mobile.ui.base;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/i;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "space", "<init>", "(I)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Lr8/z;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "a", "I", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int space;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        m.f(outRect, "outRect");
        m.f(view, "view");
        m.f(parent, "parent");
        m.f(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        m.c(adapter);
        int itemCount = adapter.getItemCount() - 1;
        if (ViewCompat.getLayoutDirection(parent) == 1) {
            if (parent.getChildLayoutPosition(view) == itemCount) {
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.space;
                return;
            }
        }
        if (parent.getChildLayoutPosition(view) == itemCount) {
            outRect.right = 0;
        } else {
            outRect.right = this.space;
        }
    }

    public i(int i10) {
        this.space = i10;
    }
}
