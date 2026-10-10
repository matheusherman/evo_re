package androidx.navigation.fragment;

import androidx.navigation.NavBackStackEntry;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleEventObserver;
import androidx.p000lifecycle.LifecycleOwner;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FragmentNavigator$fragmentViewObserver$1 extends o implements l<NavBackStackEntry, LifecycleEventObserver> {
    final /* synthetic */ FragmentNavigator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FragmentNavigator$fragmentViewObserver$1(FragmentNavigator fragmentNavigator) {
        super(1);
        this.this$0 = fragmentNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(FragmentNavigator this$0, NavBackStackEntry entry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(this$0, "this$0");
        m.f(entry, "$entry");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && this$0.getState().getBackStack().getValue().contains(entry)) {
            this$0.getState().markTransitionComplete(entry);
        }
        if (event != Lifecycle.Event.ON_DESTROY || this$0.getState().getBackStack().getValue().contains(entry)) {
            return;
        }
        this$0.getState().markTransitionComplete(entry);
    }

    @Override // c9.l
    public final LifecycleEventObserver invoke(final NavBackStackEntry entry) {
        m.f(entry, "entry");
        final FragmentNavigator fragmentNavigator = this.this$0;
        return new LifecycleEventObserver() { // from class: androidx.navigation.fragment.d
            @Override // androidx.p000lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FragmentNavigator$fragmentViewObserver$1.invoke$lambda$0(fragmentNavigator, entry, lifecycleOwner, event);
            }
        };
    }
}
