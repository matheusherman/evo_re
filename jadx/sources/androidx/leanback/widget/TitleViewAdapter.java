package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class TitleViewAdapter {
    public static final int BRANDING_VIEW_VISIBLE = 2;
    public static final int FULL_VIEW_VISIBLE = 6;
    public static final int SEARCH_VIEW_VISIBLE = 4;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface Provider {
        TitleViewAdapter getTitleViewAdapter();
    }

    public Drawable getBadgeDrawable() {
        return null;
    }

    public SearchOrbView.Colors getSearchAffordanceColors() {
        return null;
    }

    public abstract View getSearchAffordanceView();

    public CharSequence getTitle() {
        return null;
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        View searchAffordanceView = getSearchAffordanceView();
        if (searchAffordanceView != null) {
            searchAffordanceView.setOnClickListener(onClickListener);
        }
    }

    public void setAnimationEnabled(boolean z10) {
    }

    public void setBadgeDrawable(Drawable drawable) {
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void updateComponentsVisibility(int i10) {
    }
}
