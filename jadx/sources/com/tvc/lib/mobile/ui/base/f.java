package com.tvc.lib.mobile.ui.base;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH$¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR(\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010$¨\u0006&"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/f;", "Landroidx/fragment/app/Fragment;", ExifInterface.GPS_DIRECTION_TRUE, "D", "Landroidx/fragment/app/FragmentPagerAdapter;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "behavior", "<init>", "(Landroidx/fragment/app/FragmentManager;I)V", "Landroidx/fragment/app/FragmentActivity;", "activity", "(Landroidx/fragment/app/FragmentActivity;)V", "", "list", "Lr8/z;", "a", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "position", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "Landroid/view/ViewGroup;", "container", "", "object", "setPrimaryItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Ljava/util/List;", "getMFragments", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "mFragments", "Landroidx/fragment/app/Fragment;", "mCurrentFragment", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class f<T extends Fragment, D> extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<T> mFragments;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private T mCurrentFragment;

    public /* synthetic */ f(FragmentManager fragmentManager, int i10, int i11, kotlin.jvm.internal.g gVar) {
        this(fragmentManager, (i11 & 2) != 0 ? 0 : i10);
    }

    protected abstract void a(FragmentManager fm, List<T> list);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(FragmentManager fm, int i10) {
        super(fm);
        m.f(fm, "fm");
        ArrayList arrayList = new ArrayList();
        this.mFragments = arrayList;
        a(fm, arrayList);
    }

    protected final void b(List<T> list) {
        m.f(list, "<set-?>");
        this.mFragments = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public T getItem(int position) {
        return this.mFragments.get(position);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        m.f(container, "container");
        m.f(object, "object");
        if (!m.a(this.mCurrentFragment, object)) {
            this.mCurrentFragment = (T) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(FragmentActivity activity) {
        m.f(activity, "activity");
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        this(supportFragmentManager, 0, 2, null);
    }
}
