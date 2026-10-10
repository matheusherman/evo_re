package com.chad.library.adapter.base.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import g0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/chad/library/adapter/base/layoutmanager/QuickGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "oldAdapter", "newAdapter", "Lr8/z;", "onAdapterChanged", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/chad/library/adapter/base/layoutmanager/QuickGridLayoutManager$a;", "a", "Lcom/chad/library/adapter/base/layoutmanager/QuickGridLayoutManager$a;", "fullSpanSizeLookup", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QuickGridLayoutManager extends GridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a fullSpanSizeLookup;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.Adapter<?> adapter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/chad/library/adapter/base/layoutmanager/QuickGridLayoutManager$a;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "<init>", "(Lcom/chad/library/adapter/base/layoutmanager/QuickGridLayoutManager;)V", "", "position", "getSpanSize", "(I)I", "a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getOriginalSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "originalSpanSizeLookup", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private GridLayoutManager.SpanSizeLookup originalSpanSizeLookup;

        public a() {
        }

        public final void a(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.originalSpanSizeLookup = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            RecyclerView.Adapter adapter = QuickGridLayoutManager.this.adapter;
            if (adapter == null) {
                return 1;
            }
            if (!(adapter instanceof ConcatAdapter)) {
                if (!(adapter instanceof d)) {
                    GridLayoutManager.SpanSizeLookup spanSizeLookup = this.originalSpanSizeLookup;
                    if (spanSizeLookup != null) {
                        return spanSizeLookup.getSpanSize(position);
                    }
                    return 1;
                }
                if (((d) adapter).p(adapter.getItemViewType(position))) {
                    return QuickGridLayoutManager.this.getSpanCount();
                }
                GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.originalSpanSizeLookup;
                if (spanSizeLookup2 != null) {
                    return spanSizeLookup2.getSpanSize(position);
                }
                return 1;
            }
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = ((ConcatAdapter) adapter).getWrappedAdapterAndPosition(position);
            m.e(wrappedAdapterAndPosition, "adapter.getWrappedAdapterAndPosition(position)");
            RecyclerView.Adapter adapter2 = (RecyclerView.Adapter) wrappedAdapterAndPosition.first;
            if (!(adapter2 instanceof d)) {
                GridLayoutManager.SpanSizeLookup spanSizeLookup3 = this.originalSpanSizeLookup;
                if (spanSizeLookup3 == null) {
                    return 1;
                }
                Object obj = wrappedAdapterAndPosition.second;
                m.e(obj, "pair.second");
                return spanSizeLookup3.getSpanSize(((Number) obj).intValue());
            }
            Object obj2 = wrappedAdapterAndPosition.second;
            m.e(obj2, "pair.second");
            if (((d) adapter2).p(adapter2.getItemViewType(((Number) obj2).intValue()))) {
                return QuickGridLayoutManager.this.getSpanCount();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup4 = this.originalSpanSizeLookup;
            if (spanSizeLookup4 == null) {
                return 1;
            }
            Object obj3 = wrappedAdapterAndPosition.second;
            m.e(obj3, "pair.second");
            return spanSizeLookup4.getSpanSize(((Number) obj3).intValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        m.f(context, "context");
        a aVar = new a();
        this.fullSpanSizeLookup = aVar;
        aVar.a(getSpanSizeLookup());
        super.setSpanSizeLookup(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter<?> oldAdapter, RecyclerView.Adapter<?> newAdapter) {
        this.adapter = newAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.fullSpanSizeLookup.a(spanSizeLookup);
    }
}
