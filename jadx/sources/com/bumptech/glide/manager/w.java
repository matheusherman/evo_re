package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class w extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f1464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f1465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<w> f1466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private w f1467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.l f1468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f1469f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a implements r {
        a() {
        }

        @Override // com.bumptech.glide.manager.r
        @NonNull
        public Set<com.bumptech.glide.l> a() {
            Set<w> setS = w.this.S();
            HashSet hashSet = new HashSet(setS.size());
            for (w wVar : setS) {
                if (wVar.V() != null) {
                    hashSet.add(wVar.V());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + w.this + "}";
        }
    }

    public w() {
        this(new com.bumptech.glide.manager.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public w(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f1465b = new a();
        this.f1466c = new HashSet();
        this.f1464a = aVar;
    }

    private void R(w wVar) {
        this.f1466c.add(wVar);
    }

    private void Z(w wVar) {
        this.f1466c.remove(wVar);
    }

    private void b0() {
        w wVar = this.f1467d;
        if (wVar != null) {
            wVar.Z(this);
            this.f1467d = null;
        }
    }

    @NonNull
    Set<w> S() {
        w wVar = this.f1467d;
        if (wVar == null) {
            return Collections.EMPTY_SET;
        }
        if (equals(wVar)) {
            return Collections.unmodifiableSet(this.f1466c);
        }
        HashSet hashSet = new HashSet();
        for (w wVar2 : this.f1467d.S()) {
            if (X(wVar2.U())) {
                hashSet.add(wVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a T() {
        return this.f1464a;
    }

    @Nullable
    public com.bumptech.glide.l V() {
        return this.f1468e;
    }

    void a0(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerW;
        this.f1469f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerW = W(fragment)) == null) {
            return;
        }
        Y(fragment.getContext(), fragmentManagerW);
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + U() + "}";
    }

    @Nullable
    private Fragment U() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f1469f;
    }

    @Nullable
    private static FragmentManager W(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean X(@NonNull Fragment fragment) {
        Fragment fragmentU = U();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment.equals(fragmentU)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void Y(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        b0();
        w wVarK = com.bumptech.glide.c.c(context).k().k(fragmentManager);
        this.f1467d = wVarK;
        if (!equals(wVarK)) {
            this.f1467d.R(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerW = W(this);
        if (fragmentManagerW == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                Y(getContext(), fragmentManagerW);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1464a.c();
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1469f = null;
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1464a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1464a.e();
    }
}
