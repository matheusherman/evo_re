package com.tvc.lib.mobile.ui.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.Lifecycle;
import c9.p;
import c9.q;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pengrad.telegrambot.request.ContentTypes;
import com.taobao.sophix.PatchStatus;
import com.tvc.lib.R$string;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import nf.a0;
import r8.r;
import r8.z;
import ua.n;
import x1.f1.lb.util.g1;
import x1.f1.lb.util.j0;
import x1.f1.lb.util.n0;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 i*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001,B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000eJ)\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001a\u0010\u0006J/\u0010\u001e\u001a\u00020\u000b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000fH'¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000bH&¢\u0006\u0004\b0\u0010\u0006J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103R\u001a\u00108\u001a\u0002048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u00105\u001a\u0004\b6\u00107R\"\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010F\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010L\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010-\"\u0004\bJ\u0010KR\u001a\u0010R\u001a\u00020M8\u0014X\u0094\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR$\u0010\\\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010&\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010X\u001a\u0004\b^\u0010&\"\u0004\b_\u0010[R$\u0010h\u001a\u0004\u0018\u00010a8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006j"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Landroidx/databinding/ViewDataBinding;", "DB", "Landroidx/appcompat/app/AppCompatActivity;", "Lx1/f1/lb/util/j0$a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/os/PersistableBundle;", "persistentState", "Lr8/z;", "onCreate", "(Landroid/os/Bundle;Landroid/os/PersistableBundle;)V", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "onResume", "Lkotlin/Function2;", "Lnf/a0;", "onProgress", "l", "(Lc9/p;)V", "", "packageNames", "message", "F", "(Ljava/lang/String;Ljava/lang/String;)V", "y", "()Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "a", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "x", "()I", "v", "", "w", "()Z", "Lq6/b;", "Lq6/b;", "r", "()Lq6/b;", "logger", "b", "Landroidx/appcompat/app/AppCompatActivity;", "s", "()Landroidx/appcompat/app/AppCompatActivity;", "C", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mActivity", "c", "Landroidx/databinding/ViewDataBinding;", "t", "()Landroidx/databinding/ViewDataBinding;", "D", "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "d", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "firebaseAnalytics", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "p", "()Landroid/os/Handler;", "handler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInChecking", "g", "Ljava/lang/String;", "n", "z", "(Ljava/lang/String;)V", "apkFile", "h", "q", "B", "latestNewVersion", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "i", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "u", "()Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", ExifInterface.LONGITUDE_EAST, "(Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;)V", "upgradeInfo", "j", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseDataBindActivity<DB extends ViewDataBinding> extends AppCompatActivity implements j0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public AppCompatActivity mActivity;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public DB mDataBinding;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public FirebaseAnalytics firebaseAnalytics;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isInChecking;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String apkFile;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String latestNewVersion;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private UpgradeInfo upgradeInfo;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseDataBindActivity$checkUpgrade$1", f = "BaseDataBindActivity.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<Integer, a0, z> $onProgress;
        int label;
        final /* synthetic */ BaseDataBindActivity<DB> this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseDataBindActivity$checkUpgrade$1$2", f = "BaseDataBindActivity.kt", l = {130}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements q<kotlinx.coroutines.flow.g<? super UpgradeInfo>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BaseDataBindActivity<DB> this$0;

            /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.BaseDataBindActivity$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseDataBindActivity$checkUpgrade$1$2$1", f = "BaseDataBindActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0161a extends l implements p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ BaseDataBindActivity<DB> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0161a(BaseDataBindActivity<DB> baseDataBindActivity, Throwable th, v8.f<? super C0161a> fVar) {
                    super(2, fVar);
                    this.this$0 = baseDataBindActivity;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0161a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0161a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        g1.f21390a.c(this.this$0.getString(R$string.request_failure) + ":" + this.$it.getMessage());
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BaseDataBindActivity<DB> baseDataBindActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = baseDataBindActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Throwable th;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        th = (Throwable) this.L$0;
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    Throwable th2 = (Throwable) this.L$0;
                    g2 g2VarC = a1.c();
                    C0161a c0161a = new C0161a(this.this$0, th2, null);
                    this.L$0 = th2;
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0161a, this) == objC) {
                        return objC;
                    }
                    th = th2;
                }
                this.this$0.getLogger().error("check upgrade failure", th);
                return z.f17874a;
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.BaseDataBindActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0162b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseDataBindActivity<DB> f9212a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p<Integer, a0, z> f9213b;

            /* JADX WARN: Multi-variable type inference failed */
            C0162b(BaseDataBindActivity<DB> baseDataBindActivity, p<? super Integer, ? super a0, z> pVar) {
                this.f9212a = baseDataBindActivity;
                this.f9213b = pVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(UpgradeInfo upgradeInfo, v8.f<? super z> fVar) {
                this.f9212a.E(upgradeInfo);
                ((BaseDataBindActivity) this.f9212a).isInChecking.set(false);
                if ((upgradeInfo != null ? upgradeInfo.getUpgradeStatus() : 0) == 0) {
                    g1 g1Var = g1.f21390a;
                    String string = this.f9212a.getString(R$string.no_version_update);
                    m.e(string, "getString(...)");
                    g1Var.c(string);
                } else if (this.f9213b == null) {
                    g1 g1Var2 = g1.f21390a;
                    String string2 = this.f9212a.getString(R$string.update_msg);
                    m.e(string2, "getString(...)");
                    g1Var2.c(string2);
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(BaseDataBindActivity<DB> baseDataBindActivity, p<? super Integer, ? super a0, z> pVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.this$0 = baseDataBindActivity;
            this.$onProgress = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.this$0, this.$onProgress, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final z f(final BaseDataBindActivity baseDataBindActivity, final p pVar, final String str, final Integer num, final String str2, final a0 a0Var) {
            baseDataBindActivity.getHandler().post(new Runnable() { // from class: com.tvc.lib.mobile.ui.base.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseDataBindActivity.b.g(baseDataBindActivity, str, pVar, num, a0Var, str2);
                }
            });
            return z.f17874a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(BaseDataBindActivity baseDataBindActivity, String str, p pVar, Integer num, a0 a0Var, String str2) {
            if (!m.a(baseDataBindActivity.getLatestNewVersion(), str) && !TextUtils.isEmpty(str)) {
                baseDataBindActivity.B(str);
                if (pVar == null) {
                    g1 g1Var = g1.f21390a;
                    g0 g0Var = g0.f12340a;
                    String str3 = String.format("%s:%s", Arrays.copyOf(new Object[]{baseDataBindActivity.getString(R$string.version), str}, 2));
                    m.e(str3, "format(...)");
                    g1Var.c(str3);
                }
            }
            if (pVar != null) {
                pVar.invoke(num, a0Var);
            }
            if (!TextUtils.isEmpty(str2)) {
                baseDataBindActivity.z(str2);
                UpgradeInfo upgradeInfo = baseDataBindActivity.getUpgradeInfo();
                if (upgradeInfo != null) {
                    xe.c.c().o(new nf.z(upgradeInfo, str2, false));
                }
            }
            if (a0Var != null && pVar == null) {
                g1 g1Var2 = g1.f21390a;
                String strA = a0Var.a();
                m.e(strA, "getErrMsg(...)");
                g1Var2.c(strA);
            }
            baseDataBindActivity.isInChecking.set(false);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                Lifecycle lifecycle = this.this$0.getLifecycle();
                final BaseDataBindActivity<DB> baseDataBindActivity = this.this$0;
                final p<Integer, a0, z> pVar = this.$onProgress;
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.c(lifecycle, new c9.r() { // from class: com.tvc.lib.mobile.ui.base.b
                    @Override // c9.r
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return BaseDataBindActivity.b.f(baseDataBindActivity, pVar, (String) obj2, (Integer) obj3, (String) obj4, (a0) obj5);
                    }
                }), new a(this.this$0, null));
                C0162b c0162b = new C0162b(this.this$0, this.$onProgress);
                this.label = 1;
                if (fVarF.collect(c0162b, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase != null ? n0.r(newBase, null, 2, null) : null);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public abstract void v();

    public boolean w() {
        return true;
    }

    @LayoutRes
    public abstract int x();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(BaseDataBindActivity baseDataBindActivity, p pVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkUpgrade");
        }
        if ((i10 & 1) != 0) {
            pVar = null;
        }
        baseDataBindActivity.l(pVar);
    }

    public final void A(FirebaseAnalytics firebaseAnalytics) {
        m.f(firebaseAnalytics, "<set-?>");
        this.firebaseAnalytics = firebaseAnalytics;
    }

    public final void B(String str) {
        m.f(str, "<set-?>");
        this.latestNewVersion = str;
    }

    public final void C(AppCompatActivity appCompatActivity) {
        m.f(appCompatActivity, "<set-?>");
        this.mActivity = appCompatActivity;
    }

    public final void D(DB db2) {
        m.f(db2, "<set-?>");
        this.mDataBinding = db2;
    }

    protected final void E(UpgradeInfo upgradeInfo) {
        this.upgradeInfo = upgradeInfo;
    }

    public final void F(String packageNames, String message) {
        m.f(packageNames, "packageNames");
        m.f(message, "message");
        if (packageNames.length() == 0) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(ContentTypes.DOC_MIME_TYPE);
            intent.putExtra("android.intent.extra.TEXT", message);
            this.logger.a("share via more", new Object[0]);
            startActivity(Intent.createChooser(intent, getString(R$string.share_via)));
            return;
        }
        for (String str : n.z0(packageNames, new String[]{","}, false, 0, 6, null)) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType(ContentTypes.DOC_MIME_TYPE);
            intent2.setPackage(str);
            intent2.putExtra("android.intent.extra.TEXT", message);
            try {
                startActivity(intent2);
                this.logger.a("share via " + str, new Object[0]);
                return;
            } catch (ActivityNotFoundException e10) {
                this.logger.error("share via " + str, e10);
            }
        }
        g1 g1Var = g1.f21390a;
        String string = getString(R$string.app_not_installed);
        m.e(string, "getString(...)");
        g1Var.e(string);
    }

    public final void l(p<? super Integer, ? super a0, z> onProgress) {
        if (this.isInChecking.compareAndSet(false, true)) {
            j.d(m0.a(a1.b()), null, null, new b(this, onProgress, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    protected final String getApkFile() {
        return this.apkFile;
    }

    public final FirebaseAnalytics o() {
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        if (firebaseAnalytics != null) {
            return firebaseAnalytics;
        }
        m.v("firebaseAnalytics");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1) {
            x1.f1.lb.heartbeat.f.f20678a.G0();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        m.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context baseContext = getBaseContext();
        m.e(baseContext, "getBaseContext(...)");
        n0.r(baseContext, null, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C(this);
        D(DataBindingUtil.setContentView(this, x()));
        t().setLifecycleOwner(this);
        if (w()) {
            setRequestedOrientation(1);
        }
        v();
        A(FirebaseAnalytics.getInstance(this));
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    protected Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final String getLatestNewVersion() {
        return this.latestNewVersion;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    protected final q6.b getLogger() {
        return this.logger;
    }

    public final AppCompatActivity s() {
        AppCompatActivity appCompatActivity = this.mActivity;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        m.v("mActivity");
        return null;
    }

    public final DB t() {
        DB db2 = this.mDataBinding;
        if (db2 != null) {
            return db2;
        }
        m.v("mDataBinding");
        return null;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    protected final UpgradeInfo getUpgradeInfo() {
        return this.upgradeInfo;
    }

    public final String y() {
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    protected final void z(String str) {
        this.apkFile = str;
    }

    public BaseDataBindActivity() {
        q6.b bVarD = q6.c.d(getClass());
        m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.handler = new Handler(Looper.getMainLooper());
        this.isInChecking = new AtomicBoolean(false);
        this.apkFile = "";
        this.latestNewVersion = "";
    }

    @Override // x1.f1.lb.util.j0.a
    public FirebaseAnalytics a() {
        return o();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        m.e(baseContext, "getBaseContext(...)");
        n0.r(baseContext, null, 2, null);
        super.onResume();
    }
}
