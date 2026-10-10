package androidx.leanback.widget;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class AbstractMediaListHeaderPresenter extends RowPresenter {
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private final Context mContext;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class ViewHolder extends RowPresenter.ViewHolder {
        private final TextView mHeaderView;

        public TextView getHeaderView() {
            return this.mHeaderView;
        }

        public ViewHolder(View view) {
            super(view);
            this.mHeaderView = (TextView) view.findViewById(androidx.leanback.R.id.mediaListHeader);
        }
    }

    public AbstractMediaListHeaderPresenter(Context context, int i10) {
        this.mBackgroundColor = 0;
        this.mContext = new ContextThemeWrapper(context.getApplicationContext(), i10);
        setHeaderPresenter(null);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    protected abstract void onBindMediaListHeaderViewHolder(ViewHolder viewHolder, Object obj);

    public void setBackgroundColor(int i10) {
        this.mBackgroundColorSet = true;
        this.mBackgroundColor = i10;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = this.mContext;
        if (context == null) {
            context = viewGroup.getContext();
        }
        View viewInflate = LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_media_list_header, viewGroup, false);
        viewInflate.setFocusable(false);
        viewInflate.setFocusableInTouchMode(false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        if (this.mBackgroundColorSet) {
            viewHolder.view.setBackgroundColor(this.mBackgroundColor);
        }
        return viewHolder;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        onBindMediaListHeaderViewHolder((ViewHolder) viewHolder, obj);
    }

    public AbstractMediaListHeaderPresenter() {
        this.mBackgroundColor = 0;
        this.mContext = null;
        setHeaderPresenter(null);
    }
}
