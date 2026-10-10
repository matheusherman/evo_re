package com.tvc.lib.mobile.ui.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9490d;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.f9487a;
        int childCount = recyclerView.getChildCount();
        if (recyclerView.getChildLayoutPosition(view) != childCount) {
            rect.right = this.f9489c;
        }
        if (recyclerView.getChildLayoutPosition(view) != childCount) {
            rect.bottom = this.f9490d;
        }
        rect.top = this.f9488b;
    }

    public q(int i10, int i11, int i12, int i13) {
        this.f9487a = i10;
        this.f9488b = i11;
        this.f9489c = i12;
        this.f9490d = i13;
    }
}
