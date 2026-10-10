package androidx.privacysandbox.ads.adservices.java.appsetid;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1", f = "AppSetIdManagerFutures.kt", l = {49}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "<anonymous>", "(Lkotlinx/coroutines/l0;)Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;"}, k = 3, mv = {1, 8, 0})
final class AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1 extends l implements p<l0, v8.f<? super AppSetId>, Object> {
    int label;
    final /* synthetic */ AppSetIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(AppSetIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, v8.f<? super AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1> fVar) {
        super(2, fVar);
        this.this$0 = api33Ext4JavaImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> fVar) {
        return new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this.this$0, fVar);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super AppSetId> fVar) {
        return ((AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        r.b(obj);
        AppSetIdManager appSetIdManager = this.this$0.mAppSetIdManager;
        this.label = 1;
        Object appSetId = appSetIdManager.getAppSetId(this);
        if (appSetId == objC) {
            return objC;
        }
        return appSetId;
    }
}
