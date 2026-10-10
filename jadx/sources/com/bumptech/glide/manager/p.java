package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public class p extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f1416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f1417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<p> f1418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.l f1419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private p f1420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f1421f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a implements r {
        a() {
        }

        @Override // com.bumptech.glide.manager.r
        @NonNull
        public Set<com.bumptech.glide.l> a() {
            Set<p> setB = p.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (p pVar : setB) {
                if (pVar.e() != null) {
                    hashSet.add(pVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + p.this + "}";
        }
    }

    public p() {
        this(new com.bumptech.glide.manager.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    p(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f1417b = new a();
        this.f1418c = new HashSet();
        this.f1416a = aVar;
    }

    private void a(p pVar) {
        this.f1418c.add(pVar);
    }

    private void i(p pVar) {
        this.f1418c.remove(pVar);
    }

    private void l() {
        p pVar = this.f1420e;
        if (pVar != null) {
            pVar.i(this);
            this.f1420e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<p> b() {
        if (equals(this.f1420e)) {
            return Collections.unmodifiableSet(this.f1418c);
        }
        if (this.f1420e == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        for (p pVar : this.f1420e.b()) {
            if (g(pVar.getParentFragment())) {
                hashSet.add(pVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a c() {
        return this.f1416a;
    }

    @Nullable
    public com.bumptech.glide.l e() {
        return this.f1419d;
    }

    @NonNull
    public r f() {
        return this.f1417b;
    }

    void j(@Nullable Fragment fragment) {
        this.f1421f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable com.bumptech.glide.l lVar) {
        this.f1419d = lVar;
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f1421f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 != null) {
                if (parentFragment2.equals(parentFragment)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        p pVarI = com.bumptech.glide.c.c(activity).k().i(activity);
        this.f1420e = pVarI;
        if (!equals(pVarI)) {
            this.f1420e.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1416a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1416a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1416a.e();
    }
}
