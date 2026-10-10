package ziyi.kit.keyboard;

import androidx.p000lifecycle.DefaultLifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyLifecycleObserver implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23349a;

    public int a() {
        return this.f23349a;
    }

    public void b(int i10) {
        this.f23349a = i10;
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

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.f(this, lifecycleOwner);
    }
}
