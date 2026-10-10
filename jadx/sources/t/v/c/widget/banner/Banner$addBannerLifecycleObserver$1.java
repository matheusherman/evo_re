package t.v.c.widget.banner;

import androidx.p000lifecycle.DefaultLifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.p000lifecycle.c;
import androidx.recyclerview.widget.RecyclerView;
import hf.a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"t/v/c/widget/banner/Banner$addBannerLifecycleObserver$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lr8/z;", "onStart", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "onDestroy", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Banner$addBannerLifecycleObserver$1 implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Banner<Object, a<Object, ? extends RecyclerView.ViewHolder>> f18794a;

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        m.f(owner, "owner");
        c.b(this, owner);
        this.f18794a.t();
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        m.f(owner, "owner");
        c.e(this, owner);
        this.f18794a.J();
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        m.f(owner, "owner");
        c.f(this, owner);
        this.f18794a.K();
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        c.a(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        c.c(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        c.d(this, lifecycleOwner);
    }
}
