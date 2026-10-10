package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.p000lifecycle.OnLifecycleEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class LifecycleLifecycle implements l, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Set<m> f1403a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Lifecycle f1404b;

    @Override // com.bumptech.glide.manager.l
    public void a(@NonNull m mVar) {
        this.f1403a.add(mVar);
        if (this.f1404b.getState() == Lifecycle.State.DESTROYED) {
            mVar.d();
        } else if (this.f1404b.getState().isAtLeast(Lifecycle.State.STARTED)) {
            mVar.onStart();
        } else {
            mVar.h();
        }
    }

    @Override // com.bumptech.glide.manager.l
    public void b(@NonNull m mVar) {
        this.f1403a.remove(mVar);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = e0.l.j(this.f1403a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).d();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = e0.l.j(this.f1403a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = e0.l.j(this.f1403a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).h();
        }
    }

    LifecycleLifecycle(Lifecycle lifecycle) {
        this.f1404b = lifecycle;
        lifecycle.addObserver(this);
    }
}
