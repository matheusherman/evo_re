package androidx.navigation;

import androidx.p000lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import org.apache.log4j.net.SyslogAppender;
import r8.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 extends o implements c9.a<ViewModelStore> {
    final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(i<NavBackStackEntry> iVar) {
        super(0);
        this.$backStackEntry$delegate = iVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c9.a
    public final ViewModelStore invoke() {
        return NavGraphViewModelLazyKt.m81navGraphViewModels$lambda2(this.$backStackEntry$delegate).getViewModelStore();
    }
}
