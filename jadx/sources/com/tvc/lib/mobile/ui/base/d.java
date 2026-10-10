package com.tvc.lib.mobile.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tvc.lib.R$color;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import x1.f1.lb.util.n0;
import z7.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0005J\r\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u000fH'¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\u0012H&¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/d;", "Landroidx/databinding/ViewDataBinding;", "DB", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "R", "()I", "Lr8/z;", "onActivityCreated", "(Landroid/os/Bundle;)V", "Z", "U", "onDestroy", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "y", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", ExifInterface.LATITUDE_SOUTH, "()Landroidx/fragment/app/FragmentActivity;", "X", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "b", "Landroidx/databinding/ViewDataBinding;", ExifInterface.GPS_DIRECTION_TRUE, "()Landroidx/databinding/ViewDataBinding;", "Y", "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "c", "Landroid/view/View;", "rootView", "Ly7/a;", "d", "Ly7/a;", "mLoadingViewDialog", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class d<DB extends ViewDataBinding> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public FragmentActivity mActivity;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public DB mDataBinding;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private y7.a mLoadingViewDialog;

    public abstract void V();

    @LayoutRes
    public abstract int W();

    public int R() {
        return R$color.white;
    }

    public final FragmentActivity S() {
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        m.v("mActivity");
        return null;
    }

    public final DB T() {
        DB db2 = this.mDataBinding;
        if (db2 != null) {
            return db2;
        }
        m.v("mDataBinding");
        return null;
    }

    public final void U() {
        y7.a aVar = this.mLoadingViewDialog;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void X(FragmentActivity fragmentActivity) {
        m.f(fragmentActivity, "<set-?>");
        this.mActivity = fragmentActivity;
    }

    public final void Y(DB db2) {
        m.f(db2, "<set-?>");
        this.mDataBinding = db2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        m.f(context, "context");
        super.onAttach(n0.r(context, null, 2, null));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.f(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, W(), container, false);
        m.d(viewDataBindingInflate, "null cannot be cast to non-null type DB of com.tvc.lib.mobile.ui.base.BaseDataBindFragment");
        Y(viewDataBindingInflate);
        X(requireActivity());
        this.rootView = T().getRoot();
        this.mLoadingViewDialog = j.f23105a.l(S(), R());
        return this.rootView;
    }

    public final void Z() {
        y7.a aVar;
        if (!S().isFinishing() && !S().isDestroyed() && (aVar = this.mLoadingViewDialog) != null) {
            aVar.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        V();
        y();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        U();
        this.mLoadingViewDialog = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            n0.r(context, null, 2, null);
        }
    }

    public void y() {
    }
}
