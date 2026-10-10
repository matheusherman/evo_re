package com.tvc.lib.mobile.ext;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a9\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0011\u001a\u00020\n*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "Landroidx/fragment/app/Fragment;", "fragments", "", "limit", "Lr8/z;", "b", "(Landroidx/viewpager2/widget/ViewPager2;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Ljava/util/List;I)V", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "", "titles", "d", "(Landroidx/viewpager2/widget/ViewPager2;Lcom/google/android/material/tabs/TabLayout;Ljava/util/List;)V", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class l {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/tvc/lib/mobile/ext/l$a", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends FragmentStateAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Fragment> f9200a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FragmentManager fragmentManager, Lifecycle lifecycle, List<Fragment> list) {
            super(fragmentManager, lifecycle);
            this.f9200a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            return this.f9200a.get(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f9200a.size();
        }
    }

    public static final void b(ViewPager2 viewPager2, FragmentManager fm, Lifecycle lifecycle, List<Fragment> fragments, int i10) {
        m.f(viewPager2, "<this>");
        m.f(fm, "fm");
        m.f(lifecycle, "lifecycle");
        m.f(fragments, "fragments");
        viewPager2.setAdapter(new a(fm, lifecycle, fragments));
        viewPager2.setSaveEnabled(false);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setOffscreenPageLimit(i10);
    }

    public static /* synthetic */ void c(ViewPager2 viewPager2, FragmentManager fragmentManager, Lifecycle lifecycle, List list, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        b(viewPager2, fragmentManager, lifecycle, list, i10);
    }

    public static final void d(ViewPager2 viewPager2, TabLayout tabLayout, final List<String> titles) {
        m.f(viewPager2, "<this>");
        m.f(titles, "titles");
        if (tabLayout == null) {
            return;
        }
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.tvc.lib.mobile.ext.k
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i10) {
                l.e(titles, tab, i10);
            }
        });
        if (tabLayoutMediator.isAttached()) {
            return;
        }
        tabLayoutMediator.attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List list, TabLayout.Tab tab, int i10) {
        m.f(tab, "tab");
        tab.setText((CharSequence) list.get(i10));
    }
}
