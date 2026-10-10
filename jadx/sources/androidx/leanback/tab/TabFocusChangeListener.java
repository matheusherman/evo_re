package androidx.leanback.tab;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class TabFocusChangeListener implements View.OnFocusChangeListener {
    LeanbackTabLayout mLeanbackTabLayout;
    ViewPager mViewPager;

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        ViewPager viewPager;
        if (z10) {
            LinearLayout linearLayout = (LinearLayout) this.mLeanbackTabLayout.getChildAt(0);
            for (int i10 = 0; i10 < linearLayout.getChildCount(); i10++) {
                if (view == linearLayout.getChildAt(i10) && (viewPager = this.mViewPager) != null) {
                    viewPager.setCurrentItem(i10, true);
                }
            }
        }
    }

    TabFocusChangeListener(LeanbackTabLayout leanbackTabLayout, ViewPager viewPager) {
        this.mLeanbackTabLayout = leanbackTabLayout;
        this.mViewPager = viewPager;
    }
}
