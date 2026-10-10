package com.live.evo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.live.evo.R$anim;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class f0 extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected a2 f5935e;

    private void U() {
        this.f5934d = true;
        this.f5932b = false;
        this.f5931a = null;
        this.f5933c = true;
    }

    protected abstract int R();

    protected abstract void S(Bundle bundle);

    protected abstract void V(View view);

    public void Y(a2 a2Var) {
        this.f5935e = a2Var;
    }

    protected void Z(View view) {
        if (view == null) {
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.arrow_shake));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        View view2 = this.f5931a;
        if (view2 == null) {
            this.f5931a = view;
        } else {
            view2.setVisibility(0);
        }
        View view3 = this.f5931a;
        if (view3 != null && view != null) {
            if (this.f5933c) {
                view = view3;
            }
            super.onViewCreated(view, bundle);
        }
        V(this.f5931a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        S(bundle);
        T();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        U();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (R() != 0) {
            return layoutInflater.inflate(R(), viewGroup, false);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        U();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (this.f5931a != null && isAdded() && getView() != null) {
            X(!z10);
        }
    }

    protected void T() {
    }

    public void W(boolean z10) {
    }

    public void X(boolean z10) {
    }
}
