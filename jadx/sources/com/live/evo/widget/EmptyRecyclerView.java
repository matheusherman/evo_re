package com.live.evo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EmptyRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f7433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerView.AdapterDataObserver f7434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7435c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            EmptyRecyclerView.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            EmptyRecyclerView.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            EmptyRecyclerView.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
    }

    public EmptyRecyclerView(Context context) {
        super(context);
        this.f7434b = new a();
        this.f7435c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f7433a == null || getAdapter() == null) {
            return;
        }
        boolean z10 = getAdapter().getItemCount() == 0;
        this.f7433a.setVisibility(z10 ? 0 : 8);
        setVisibility(z10 ? 8 : 0);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        if (this.f7435c) {
            return super.canScrollVertically(i10);
        }
        return false;
    }

    public boolean getMCanVerticalScroll() {
        return this.f7435c;
    }

    public void setEmptyView(View view) {
        this.f7433a = view;
        b();
    }

    public void setMCanVerticalScroll(boolean z10) {
        this.f7435c = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f7434b);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f7434b);
        }
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7434b = new a();
        this.f7435c = true;
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7434b = new a();
        this.f7435c = true;
    }

    public void setRecyclerViewEmptyListener(b bVar) {
    }
}
