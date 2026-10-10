package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.p000lifecycle.ViewModel;
import androidx.p000lifecycle.ViewModelProvider;
import androidx.p000lifecycle.viewmodel.CreationExtras;
import i9.d;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import org.apache.log4j.net.SyslogAppender;
import r8.i;
import r8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aW\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\r\u001aC\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0010\u001aU\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014²\u0006\u0018\u0010\u0013\u001a\u00020\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0013\u001a\u00020\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0013\u001a\u00020\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0013\u001a\u00020\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "", "navGraphId", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lr8/i;", "navGraphViewModels", "(Landroidx/fragment/app/Fragment;ILc9/a;)Lr8/i;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extrasProducer", "(Landroidx/fragment/app/Fragment;ILc9/a;Lc9/a;)Lr8/i;", "", "navGraphRoute", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lc9/a;)Lr8/i;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lc9/a;Lc9/a;)Lr8/i;", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "navigation-fragment_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavGraphViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass1 extends o implements c9.a<CreationExtras> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m79navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass2 extends o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m79navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass3 extends o implements c9.a<CreationExtras> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ c9.a<CreationExtras> $extrasProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(c9.a<? extends CreationExtras> aVar, i<NavBackStackEntry> iVar) {
            super(0);
            this.$extrasProducer = aVar;
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            c9.a<CreationExtras> aVar = this.$extrasProducer;
            return (aVar == null || (creationExtrasInvoke = aVar.invoke()) == null) ? NavGraphViewModelLazyKt.m80navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras() : creationExtrasInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass4 extends o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m80navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass5 extends o implements c9.a<CreationExtras> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m81navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass6 extends o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m81navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass7 extends o implements c9.a<CreationExtras> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ c9.a<CreationExtras> $extrasProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(c9.a<? extends CreationExtras> aVar, i<NavBackStackEntry> iVar) {
            super(0);
            this.$extrasProducer = aVar;
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            c9.a<CreationExtras> aVar = this.$extrasProducer;
            return (aVar == null || (creationExtrasInvoke = aVar.invoke()) == null) ? NavGraphViewModelLazyKt.m82navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras() : creationExtrasInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass8 extends o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(i<NavBackStackEntry> iVar) {
            super(0);
            this.$backStackEntry$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m82navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> i<VM> navGraphViewModels(Fragment fragment, @IdRes int i10, c9.a<? extends ViewModelProvider.Factory> aVar) {
        m.f(fragment, "<this>");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i10));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(iVarA);
        if (aVar == null) {
            aVar = new AnonymousClass2(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, anonymousClass1, aVar);
    }

    public static /* synthetic */ i navGraphViewModels$default(Fragment fragment, int i10, c9.a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = null;
        }
        m.f(fragment, "<this>");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i10));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(iVarA);
        if (aVar == null) {
            aVar = new AnonymousClass2(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, anonymousClass1, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-0, reason: not valid java name */
    public static final NavBackStackEntry m79navGraphViewModels$lambda0(i<NavBackStackEntry> iVar) {
        return iVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-1, reason: not valid java name */
    public static final NavBackStackEntry m80navGraphViewModels$lambda1(i<NavBackStackEntry> iVar) {
        return iVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-2, reason: not valid java name */
    public static final NavBackStackEntry m81navGraphViewModels$lambda2(i<NavBackStackEntry> iVar) {
        return iVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-3, reason: not valid java name */
    public static final NavBackStackEntry m82navGraphViewModels$lambda3(i<NavBackStackEntry> iVar) {
        return iVar.getValue();
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> i<VM> navGraphViewModels(Fragment fragment, @IdRes int i10, c9.a<? extends CreationExtras> aVar, c9.a<? extends ViewModelProvider.Factory> aVar2) {
        m.f(fragment, "<this>");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i10));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(aVar, iVarA);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass4(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, anonymousClass3, aVar2);
    }

    public static /* synthetic */ i navGraphViewModels$default(Fragment fragment, int i10, c9.a aVar, c9.a aVar2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = null;
        }
        if ((i11 & 4) != 0) {
            aVar2 = null;
        }
        m.f(fragment, "<this>");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i10));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(aVar, iVarA);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass4(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, anonymousClass3, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> i<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, c9.a<? extends ViewModelProvider.Factory> aVar) {
        m.f(fragment, "<this>");
        m.f(navGraphRoute, "navGraphRoute");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(iVarA);
        if (aVar == null) {
            aVar = new AnonymousClass6(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, anonymousClass5, aVar);
    }

    public static /* synthetic */ i navGraphViewModels$default(Fragment fragment, String navGraphRoute, c9.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        m.f(fragment, "<this>");
        m.f(navGraphRoute, "navGraphRoute");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(iVarA);
        if (aVar == null) {
            aVar = new AnonymousClass6(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, anonymousClass5, aVar);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> i<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, c9.a<? extends CreationExtras> aVar, c9.a<? extends ViewModelProvider.Factory> aVar2) {
        m.f(fragment, "<this>");
        m.f(navGraphRoute, "navGraphRoute");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, iVarA);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, anonymousClass7, aVar2);
    }

    public static /* synthetic */ i navGraphViewModels$default(Fragment fragment, String navGraphRoute, c9.a aVar, c9.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        m.f(fragment, "<this>");
        m.f(navGraphRoute, "navGraphRoute");
        i iVarA = j.a(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(iVarA);
        m.j(4, "VM");
        d dVarB = c0.b(ViewModel.class);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, iVarA);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(iVarA);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, dVarB, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, anonymousClass7, aVar2);
    }
}
