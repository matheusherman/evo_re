package androidx.leanback.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class LeanbackTabLayout extends TabLayout {
    final AdapterDataSetObserver mAdapterDataSetObserver;
    ViewPager mViewPager;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class AdapterDataSetObserver extends DataSetObserver {
        final LeanbackTabLayout mLeanbackTabLayout;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.mLeanbackTabLayout.updatePageTabs();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.mLeanbackTabLayout.updatePageTabs();
        }

        AdapterDataSetObserver(LeanbackTabLayout leanbackTabLayout) {
            this.mLeanbackTabLayout = leanbackTabLayout;
        }
    }

    public LeanbackTabLayout(@NonNull Context context) {
        super(context);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }

    void updatePageTabs() {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = linearLayout.getChildAt(i10);
            childAt.setFocusable(true);
            childAt.setOnFocusChangeListener(new TabFocusChangeListener(this, this.mViewPager));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(@NonNull @SuppressLint({"ConcreteCollection"}) ArrayList<View> arrayList, int i10, int i11) {
        ViewPager viewPager;
        ViewPager viewPager2 = this.mViewPager;
        boolean z10 = viewPager2 != null && viewPager2.hasFocus();
        boolean zHasFocus = hasFocus();
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        if ((i10 == 130 || i10 == 33) && linearLayout != null && linearLayout.getChildCount() > 0 && (viewPager = this.mViewPager) != null) {
            View childAt = linearLayout.getChildAt(viewPager.getCurrentItem());
            if (childAt != null) {
                arrayList.add(childAt);
                return;
            }
            return;
        }
        if ((i10 == 66 || i10 == 17) && !zHasFocus && z10) {
            return;
        }
        super.addFocusables(arrayList, i10, i11);
    }

    public LeanbackTabLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        updatePageTabs();
    }

    @Override // com.google.android.material.tabs.TabLayout
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.mViewPager.getAdapter().unregisterDataSetObserver(this.mAdapterDataSetObserver);
        }
        this.mViewPager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mViewPager.getAdapter().registerDataSetObserver(this.mAdapterDataSetObserver);
        }
    }

    public LeanbackTabLayout(@NonNull Context context, @NonNull AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }
}
