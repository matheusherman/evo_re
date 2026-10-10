package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.h;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.o;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0097@¢\u0006\u0004\b\r\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "Landroid/adservices/appsetid/AppSetIdManager;", "mAppSetIdManager", "<init>", "(Landroid/adservices/appsetid/AppSetIdManager;)V", "Landroid/adservices/appsetid/AppSetId;", "getAppSetIdAsyncInternal", "(Lv8/f;)Ljava/lang/Object;", "response", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "convertResponse", "(Landroid/adservices/appsetid/AppSetId;)Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "getAppSetId", "Landroid/adservices/appsetid/AppSetIdManager;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    private final android.adservices.appsetid.AppSetIdManager mAppSetIdManager;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {38}, m = "getAppSetId$suspendImpl")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(v8.f<? super AnonymousClass1> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSetIdManagerImplCommon.getAppSetId$suspendImpl(AppSetIdManagerImplCommon.this, this);
        }
    }

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        m.f(mAppSetIdManager, "mAppSetIdManager");
        this.mAppSetIdManager = mAppSetIdManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @DoNotInline
    static /* synthetic */ Object getAppSetId$suspendImpl(AppSetIdManagerImplCommon appSetIdManagerImplCommon, v8.f<? super AppSetId> fVar) {
        AnonymousClass1 anonymousClass1;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = appSetIdManagerImplCommon.new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = appSetIdManagerImplCommon.new AnonymousClass1(fVar);
        }
        Object appSetIdAsyncInternal = anonymousClass1.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            r.b(appSetIdAsyncInternal);
            anonymousClass1.L$0 = appSetIdManagerImplCommon;
            anonymousClass1.label = 1;
            appSetIdAsyncInternal = appSetIdManagerImplCommon.getAppSetIdAsyncInternal(anonymousClass1);
            if (appSetIdAsyncInternal == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            appSetIdManagerImplCommon = (AppSetIdManagerImplCommon) anonymousClass1.L$0;
            r.b(appSetIdAsyncInternal);
        }
        return appSetIdManagerImplCommon.convertResponse(e.a(appSetIdAsyncInternal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(v8.f<? super android.adservices.appsetid.AppSetId> fVar) {
        o oVar = new o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        this.mAppSetIdManager.getAppSetId(new h(), OutcomeReceiverKt.asOutcomeReceiver(oVar));
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    private final AppSetId convertResponse(android.adservices.appsetid.AppSetId response) {
        if (response.getScope() == 1) {
            String id2 = response.getId();
            m.e(id2, "response.id");
            return new AppSetId(id2, 1);
        }
        String id3 = response.getId();
        m.e(id3, "response.id");
        return new AppSetId(id3, 2);
    }

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    @DoNotInline
    public Object getAppSetId(v8.f<? super AppSetId> fVar) {
        return getAppSetId$suspendImpl(this, fVar);
    }
}
