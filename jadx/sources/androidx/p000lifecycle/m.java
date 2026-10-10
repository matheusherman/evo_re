package androidx.p000lifecycle;

import androidx.p000lifecycle.viewmodel.CreationExtras;
import androidx.p000lifecycle.viewmodel.ViewModelInitializer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final /* synthetic */ class m {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.INSTANCE;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class modelClass) {
        kotlin.jvm.internal.m.f(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class modelClass, CreationExtras extras) {
        kotlin.jvm.internal.m.f(modelClass, "modelClass");
        kotlin.jvm.internal.m.f(extras, "extras");
        return factory.create(modelClass);
    }

    public static ViewModelProvider.Factory c(ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.INSTANCE.from(viewModelInitializerArr);
    }
}
