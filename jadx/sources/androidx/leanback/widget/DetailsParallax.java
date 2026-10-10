package androidx.leanback.widget;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class DetailsParallax extends RecyclerViewParallax {
    final Parallax.IntProperty mFrameBottom;
    final Parallax.IntProperty mFrameTop;

    public Parallax.IntProperty getOverviewRowBottom() {
        return this.mFrameBottom;
    }

    public Parallax.IntProperty getOverviewRowTop() {
        return this.mFrameTop;
    }

    public DetailsParallax() {
        RecyclerViewParallax.ChildPositionProperty childPositionPropertyAdapterPosition = addProperty("overviewRowTop").adapterPosition(0);
        int i10 = androidx.leanback.R.id.details_frame;
        this.mFrameTop = childPositionPropertyAdapterPosition.viewId(i10);
        this.mFrameBottom = addProperty("overviewRowBottom").adapterPosition(0).viewId(i10).fraction(1.0f);
    }
}
