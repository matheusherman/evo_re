package com.live.evo.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c0 extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Fragment> f5894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f5895b;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f5894a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i10) {
        return this.f5894a.get(i10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i10) {
        return this.f5895b.get(i10);
    }

    public c0(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        super(fragmentManager);
        this.f5894a = list;
        this.f5895b = list2;
    }
}
