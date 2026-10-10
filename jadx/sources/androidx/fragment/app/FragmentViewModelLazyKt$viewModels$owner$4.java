package androidx.fragment.app;

import androidx.p000lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
public final class FragmentViewModelLazyKt$viewModels$owner$4 extends kotlin.jvm.internal.o implements c9.a<ViewModelStoreOwner> {
    final /* synthetic */ c9.a<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c9.a
    public final ViewModelStoreOwner invoke() {
        return this.$ownerProducer.invoke();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$owner$4(c9.a<? extends ViewModelStoreOwner> aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }
}
