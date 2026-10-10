package by.kirich1409.viewbindingdelegate;

import androidx.annotation.MainThread;
import androidx.p000lifecycle.DefaultLifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"by/kirich1409/viewbindingdelegate/LifecycleViewBindingProperty$ClearOnDestroyLifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lr8/z;", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStart", "onResume", "onPause", "onStop", "onDestroy", "com.github.kirich1409.ViewBindingPropertyDelegate.core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LifecycleViewBindingProperty$ClearOnDestroyLifecycleObserver implements DefaultLifecycleObserver {
    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        m.f(owner, "owner");
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    @MainThread
    public void onDestroy(LifecycleOwner owner) {
        m.f(owner, "owner");
        throw null;
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        m.f(owner, "owner");
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        m.f(owner, "owner");
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        m.f(owner, "owner");
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        m.f(owner, "owner");
    }
}
