package androidx.navigation.fragment;

import androidx.p000lifecycle.viewmodel.CreationExtras;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/fragment/FragmentNavigator$ClearEntryStateViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FragmentNavigator$attachClearViewModel$viewModel$1$1 extends o implements l<CreationExtras, FragmentNavigator.ClearEntryStateViewModel> {
    public static final FragmentNavigator$attachClearViewModel$viewModel$1$1 INSTANCE = new FragmentNavigator$attachClearViewModel$viewModel$1$1();

    FragmentNavigator$attachClearViewModel$viewModel$1$1() {
        super(1);
    }

    @Override // c9.l
    public final FragmentNavigator.ClearEntryStateViewModel invoke(CreationExtras initializer) {
        m.f(initializer, "$this$initializer");
        return new FragmentNavigator.ClearEntryStateViewModel();
    }
}
