package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<Lifecycle, com.bumptech.glide.l> f1410a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final q.b f1411b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Lifecycle f1412a;

        a(Lifecycle lifecycle) {
            this.f1412a = lifecycle;
        }

        @Override // com.bumptech.glide.manager.m
        public void d() {
            n.this.f1410a.remove(this.f1412a);
        }

        @Override // com.bumptech.glide.manager.m
        public void h() {
        }

        @Override // com.bumptech.glide.manager.m
        public void onStart() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FragmentManager f1414a;

        b(FragmentManager fragmentManager) {
            this.f1414a = fragmentManager;
        }

        @Override // com.bumptech.glide.manager.r
        @NonNull
        public Set<com.bumptech.glide.l> a() {
            HashSet hashSet = new HashSet();
            b(this.f1414a, hashSet);
            return hashSet;
        }

        private void b(FragmentManager fragmentManager, Set<com.bumptech.glide.l> set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = fragments.get(i10);
                b(fragment.getChildFragmentManager(), set);
                com.bumptech.glide.l lVarA = n.this.a(fragment.getLifecycle());
                if (lVarA != null) {
                    set.add(lVarA);
                }
            }
        }
    }

    n(@NonNull q.b bVar) {
        this.f1411b = bVar;
    }

    com.bumptech.glide.l a(Lifecycle lifecycle) {
        e0.l.b();
        return this.f1410a.get(lifecycle);
    }

    com.bumptech.glide.l b(Context context, com.bumptech.glide.c cVar, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z10) {
        e0.l.b();
        com.bumptech.glide.l lVarA = a(lifecycle);
        if (lVarA == null) {
            LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
            com.bumptech.glide.l lVarA2 = this.f1411b.a(cVar, lifecycleLifecycle, new b(fragmentManager), context);
            this.f1410a.put(lifecycle, lVarA2);
            lifecycleLifecycle.a(new a(lifecycle));
            if (z10) {
                lVarA2.onStart();
            }
            return lVarA2;
        }
        return lVarA;
    }
}
