package com.tvc.lib.mobile.media;

import androidx.p000lifecycle.DefaultLifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import nf.d;
import q6.b;
import t.v.c.i.a;
import xe.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/tvc/lib/mobile/media/AppLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lr8/z;", "onStart", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "Lq6/b;", "a", "Lq6/b;", "logger", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLifecycleObserver implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b logger;

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        m.f(owner, "owner");
        this.logger.a("AppLifecycle on start", new Object[0]);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        m.f(owner, "owner");
        this.logger.a("AppLifecycle on onStop", new Object[0]);
        a aVar = a.f18646a;
        if (aVar.e0()) {
            aVar.I0();
            c.c().o(new d(true, "", "enter family"));
        }
    }

    public AppLifecycleObserver() {
        b bVarD = q6.c.d(AppLifecycleObserver.class);
        m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.d(this, lifecycleOwner);
    }
}
