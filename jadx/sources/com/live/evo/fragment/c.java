package com.live.evo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jessyan.autosize.internal.CustomAdapt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends Fragment implements CustomAdapt, View.OnAttachStateChangeListener, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5889a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5890b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Fragment f5891c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5892d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<z1> f5893e = new ArrayList();

    public boolean U() {
        return true;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 0.0f;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return false;
    }

    private void R(z1 z1Var) {
        this.f5893e.add(z1Var);
    }

    private void S(boolean z10) {
        if (z10 == this.f5890b) {
            return;
        }
        boolean zX = X();
        boolean z11 = false;
        boolean z12 = isAdded() && !isHidden();
        boolean userVisibleHint = getUserVisibleHint();
        if (zX && z12 && userVisibleHint) {
            z11 = true;
        }
        if (z11 != this.f5890b) {
            this.f5890b = z11;
            W(z11);
        }
    }

    private boolean X() {
        Fragment fragment = this.f5891c;
        if (fragment instanceof c) {
            return ((c) fragment).T();
        }
        return fragment instanceof b ? ((b) fragment).S() : this.f5889a;
    }

    private void Z(z1 z1Var) {
        this.f5893e.remove(z1Var);
    }

    protected boolean T() {
        return this.f5890b;
    }

    protected void V(boolean z10) {
        this.f5889a = z10;
        S(z10);
    }

    protected void W(boolean z10) {
        Iterator<z1> it = this.f5893e.iterator();
        while (it.hasNext()) {
            it.next().O(z10);
        }
        if (z10) {
            this.f5892d = x1.f1.lb.util.d1.c();
        } else {
            if (!U() || this.f5892d <= 0) {
                return;
            }
            Y(false);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Y(this.f5890b);
        S(true);
    }

    @Override // com.live.evo.fragment.z1
    public void O(boolean z10) {
        Y(z10);
        S(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        this.f5891c = parentFragment;
        if (parentFragment instanceof c) {
            ((c) parentFragment).R(this);
        } else if (parentFragment instanceof b) {
            ((b) parentFragment).R(this);
        }
        Y(this.f5890b);
        S(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Fragment fragment = this.f5891c;
        if (fragment instanceof c) {
            ((c) fragment).Z(this);
        } else if (fragment instanceof b) {
            ((b) fragment).T(this);
        }
        Y(this.f5890b);
        S(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        Y(!z10);
        S(!z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Y(this.f5890b);
        V(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y(this.f5890b);
        V(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        Y(this.f5890b);
        S(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        Y(z10);
        S(z10);
    }

    private void Y(boolean z10) {
    }
}
