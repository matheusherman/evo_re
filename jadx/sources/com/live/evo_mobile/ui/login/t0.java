package com.live.evo_mobile.ui.login;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/live/evo_mobile/ui/login/t0;", "Lcom/tvc/lib/mobile/ui/base/f;", "Landroidx/fragment/app/Fragment;", "Lu7/a;", "Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "", "fragments", "Lr8/z;", "c", "(Ljava/util/List;)V", "Landroidx/fragment/app/FragmentManager;", "fm", "list", "a", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t0 extends com.tvc.lib.mobile.ui.base.f<Fragment, u7.a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(FragmentActivity activity) {
        super(activity);
        kotlin.jvm.internal.m.f(activity, "activity");
    }

    @Override // com.tvc.lib.mobile.ui.base.f
    protected void a(FragmentManager fm, List<Fragment> list) {
        kotlin.jvm.internal.m.f(fm, "fm");
        kotlin.jvm.internal.m.f(list, "list");
    }

    public final void c(List<Fragment> fragments) {
        kotlin.jvm.internal.m.f(fragments, "fragments");
        b(fragments);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        kotlin.jvm.internal.m.f(container, "container");
        Object objInstantiateItem = super.instantiateItem(container, position);
        kotlin.jvm.internal.m.d(objInstantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment fragment = (Fragment) objInstantiateItem;
        String tag = fragment.getTag();
        if (kotlin.jvm.internal.m.a(fragment, getItem(position))) {
            return fragment;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragment.getParentFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.remove(fragment);
        Fragment item = getItem(position);
        fragmentTransactionBeginTransaction.add(container.getId(), item, tag);
        fragmentTransactionBeginTransaction.attach(item);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        return item;
    }
}
