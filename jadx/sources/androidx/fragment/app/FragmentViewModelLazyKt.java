package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.p000lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p000lifecycle.ViewModel;
import androidx.p000lifecycle.ViewModelLazy;
import androidx.p000lifecycle.ViewModelProvider;
import androidx.p000lifecycle.ViewModelStore;
import androidx.p000lifecycle.ViewModelStoreOwner;
import androidx.p000lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aK\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\r\u001a;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aM\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001aQ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aa\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018²\u0006\u0018\u0010\u0017\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002²\u0006\u0018\u0010\u0017\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownerProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lr8/i;", "viewModels", "(Landroidx/fragment/app/Fragment;Lc9/a;Lc9/a;)Lr8/i;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extrasProducer", "(Landroidx/fragment/app/Fragment;Lc9/a;Lc9/a;Lc9/a;)Lr8/i;", "activityViewModels", "(Landroidx/fragment/app/Fragment;Lc9/a;)Lr8/i;", "Li9/d;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "createViewModelLazy", "(Landroidx/fragment/app/Fragment;Li9/d;Lc9/a;Lc9/a;)Lr8/i;", "(Landroidx/fragment/app/Fragment;Li9/d;Lc9/a;Lc9/a;Lc9/a;)Lr8/i;", "owner", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements c9.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            kotlin.jvm.internal.m.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass2 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.m.e(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass3 extends kotlin.jvm.internal.o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.m.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass4 extends kotlin.jvm.internal.o implements c9.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            kotlin.jvm.internal.m.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass5 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ c9.a<CreationExtras> $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(c9.a<? extends CreationExtras> aVar, Fragment fragment) {
            super(0);
            this.$extrasProducer = aVar;
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            c9.a<CreationExtras> aVar = this.$extrasProducer;
            if (aVar != null && (creationExtrasInvoke = aVar.invoke()) != null) {
                return creationExtrasInvoke;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.m.e(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass6 extends kotlin.jvm.internal.o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.m.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C05121 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05121(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.m.e(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C05132 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.m.e(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05132(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05141 extends kotlin.jvm.internal.o implements c9.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final Fragment invoke() {
            return this.$this_viewModels;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05141(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05152 extends kotlin.jvm.internal.o implements c9.a<ViewModelStore> {
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05152(r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m37viewModels$lambda0(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05163 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05163(r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras;
            ViewModelStoreOwner viewModelStoreOwnerM37viewModels$lambda0 = FragmentViewModelLazyKt.m37viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM37viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM37viewModels$lambda0 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras()) == null) ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05174 extends kotlin.jvm.internal.o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05174(Fragment fragment, r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM37viewModels$lambda0 = FragmentViewModelLazyKt.m37viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM37viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM37viewModels$lambda0 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.m.e(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05185 extends kotlin.jvm.internal.o implements c9.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final Fragment invoke() {
            return this.$this_viewModels;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05185(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class C05196 extends kotlin.jvm.internal.o implements c9.a<ViewModelStore> {
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05196(r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m38viewModels$lambda1(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass7 extends kotlin.jvm.internal.o implements c9.a<CreationExtras> {
        final /* synthetic */ c9.a<CreationExtras> $extrasProducer;
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(c9.a<? extends CreationExtras> aVar, r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$extrasProducer = aVar;
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            c9.a<CreationExtras> aVar = this.$extrasProducer;
            if (aVar != null && (creationExtrasInvoke = aVar.invoke()) != null) {
                return creationExtrasInvoke;
            }
            ViewModelStoreOwner viewModelStoreOwnerM38viewModels$lambda1 = FragmentViewModelLazyKt.m38viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM38viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM38viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
    public static final class AnonymousClass8 extends kotlin.jvm.internal.o implements c9.a<ViewModelProvider.Factory> {
        final /* synthetic */ r8.i<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Fragment fragment, r8.i<? extends ViewModelStoreOwner> iVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = iVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM38viewModels$lambda1 = FragmentViewModelLazyKt.m38viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM38viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM38viewModels$lambda1 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.m.e(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> r8.i<VM> activityViewModels(Fragment fragment, c9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (aVar == null) {
            aVar = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, dVarB, anonymousClass1, anonymousClass2, aVar);
    }

    public static /* synthetic */ r8.i activityViewModels$default(Fragment fragment, c9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (aVar == null) {
            aVar = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, dVarB, anonymousClass1, anonymousClass2, aVar);
    }

    @MainThread
    public static final /* synthetic */ r8.i createViewModelLazy(Fragment fragment, i9.d viewModelClass, c9.a storeProducer, c9.a aVar) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.m.f(storeProducer, "storeProducer");
        return createViewModelLazy(fragment, viewModelClass, storeProducer, new C05121(fragment), aVar);
    }

    public static /* synthetic */ r8.i createViewModelLazy$default(Fragment fragment, i9.d dVar, c9.a aVar, c9.a aVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, dVar, aVar, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> r8.i<VM> viewModels(Fragment fragment, c9.a<? extends ViewModelStoreOwner> ownerProducer, c9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(ownerProducer, "ownerProducer");
        r8.i iVarB = r8.j.b(r8.m.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        C05152 c05152 = new C05152(iVarB);
        C05163 c05163 = new C05163(iVarB);
        if (aVar == null) {
            aVar = new C05174(fragment, iVarB);
        }
        return createViewModelLazy(fragment, dVarB, c05152, c05163, aVar);
    }

    public static /* synthetic */ r8.i viewModels$default(Fragment fragment, c9.a ownerProducer, c9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new C05141(fragment);
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(ownerProducer, "ownerProducer");
        r8.i iVarB = r8.j.b(r8.m.NONE, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        C05152 c05152 = new C05152(iVarB);
        C05163 c05163 = new C05163(iVarB);
        if (aVar == null) {
            aVar = new C05174(fragment, iVarB);
        }
        return createViewModelLazy(fragment, dVarB, c05152, c05163, aVar);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> r8.i<VM> activityViewModels(Fragment fragment, c9.a<? extends CreationExtras> aVar, c9.a<? extends ViewModelProvider.Factory> aVar2) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, dVarB, anonymousClass4, anonymousClass5, aVar2);
    }

    @MainThread
    public static final <VM extends ViewModel> r8.i<VM> createViewModelLazy(Fragment fragment, i9.d<VM> viewModelClass, c9.a<? extends ViewModelStore> storeProducer, c9.a<? extends CreationExtras> extrasProducer, c9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.m.f(storeProducer, "storeProducer");
        kotlin.jvm.internal.m.f(extrasProducer, "extrasProducer");
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar, extrasProducer);
    }

    public static /* synthetic */ r8.i createViewModelLazy$default(Fragment fragment, i9.d dVar, c9.a aVar, c9.a aVar2, c9.a aVar3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = new C05132(fragment);
        }
        if ((i10 & 8) != 0) {
            aVar3 = null;
        }
        return createViewModelLazy(fragment, dVar, aVar, aVar2, aVar3);
    }

    public static /* synthetic */ r8.i activityViewModels$default(Fragment fragment, c9.a aVar, c9.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, dVarB, anonymousClass4, anonymousClass5, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> r8.i<VM> viewModels(Fragment fragment, c9.a<? extends ViewModelStoreOwner> ownerProducer, c9.a<? extends CreationExtras> aVar, c9.a<? extends ViewModelProvider.Factory> aVar2) {
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(ownerProducer, "ownerProducer");
        r8.i iVarB = r8.j.b(r8.m.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        C05196 c05196 = new C05196(iVarB);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, iVarB);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(fragment, iVarB);
        }
        return createViewModelLazy(fragment, dVarB, c05196, anonymousClass7, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: viewModels$lambda-0, reason: not valid java name */
    public static final ViewModelStoreOwner m37viewModels$lambda0(r8.i<? extends ViewModelStoreOwner> iVar) {
        return iVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: viewModels$lambda-1, reason: not valid java name */
    public static final ViewModelStoreOwner m38viewModels$lambda1(r8.i<? extends ViewModelStoreOwner> iVar) {
        return iVar.getValue();
    }

    public static /* synthetic */ r8.i viewModels$default(Fragment fragment, c9.a ownerProducer, c9.a aVar, c9.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new C05185(fragment);
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.m.f(fragment, "<this>");
        kotlin.jvm.internal.m.f(ownerProducer, "ownerProducer");
        r8.i iVarB = r8.j.b(r8.m.NONE, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.m.j(4, "VM");
        i9.d dVarB = c0.b(ViewModel.class);
        C05196 c05196 = new C05196(iVarB);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, iVarB);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(fragment, iVarB);
        }
        return createViewModelLazy(fragment, dVarB, c05196, anonymousClass7, aVar2);
    }
}
