package com.live.load;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import c9.p;
import com.live.evo.MyApplication;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$string;
import com.live.evo.activity.LiveLoadActivity;
import com.live.evo_mobile.media.activity.SplashActivity;
import com.stub.StubApp;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.l0;
import me.jessyan.autosize.AutoSizeCompat;
import r8.r;
import r8.z;
import x1.f1.lb.util.k;
import x1.f1.lb.util.w0;
import z4.h;
import z7.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%¨\u0006("}, d2 = {"Lcom/live/load/InitActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lr8/z;", "t", "", "appType", "y", "(Ljava/lang/String;)V", "x", "z", "Landroid/content/Context;", "context", "w", "(Landroid/content/Context;Lv8/f;)Ljava/lang/Object;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "Lz4/h;", "a", "Lz4/h;", "binding", "Ljava/util/concurrent/CountDownLatch;", "b", "Ljava/util/concurrent/CountDownLatch;", "latch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isBgSet", "d", "Ljava/lang/String;", "appTypeKey", "e", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private h binding;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CountDownLatch latch = new CountDownLatch(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isBgSet = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String appTypeKey = "init_activity_app_type";

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String appType = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.live.load.InitActivity$onCreate$1", f = "InitActivity.kt", l = {56, 61}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: renamed from: com.live.load.InitActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "com.live.load.InitActivity$onCreate$1$1$1", f = "InitActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0147a extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ String $it;
            int label;
            final /* synthetic */ InitActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0147a(InitActivity initActivity, String str, v8.f<? super C0147a> fVar) {
                super(2, fVar);
                this.this$0 = initActivity;
                this.$it = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0147a(this.this$0, this.$it, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0147a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.this$0.y(this.$it);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(v8.f<? super a> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return InitActivity.this.new a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
        
            if (kotlinx.coroutines.h.g(r3, r4, r6) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                }
                InitActivity.this.z();
                return z.f17874a;
            }
            r.b(obj);
            InitActivity initActivity = InitActivity.this;
            Context origApplicationContext = StubApp.getOrigApplicationContext(initActivity.getApplicationContext());
            this.label = 1;
            if (initActivity.w(origApplicationContext, this) != objC) {
            }
            return objC;
            if (InitActivity.this.appType.length() == 0) {
                String strR = k.f21398a.r();
                InitActivity initActivity2 = InitActivity.this;
                w0.f21452a.t(initActivity2.appTypeKey, strR);
                g2 g2VarC = a1.c();
                C0147a c0147a = new C0147a(initActivity2, strR, null);
                this.label = 2;
            }
            InitActivity.this.z();
            return z.f17874a;
        }
    }

    static {
        StubApp.interface11(13161);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(boolean z10, final InitActivity initActivity) {
        initActivity.startActivity(new Intent(initActivity, (Class<?>) (z10 ? LiveLoadActivity.class : SplashActivity.class)));
        h hVar = initActivity.binding;
        if (hVar == null) {
            m.v("binding");
            hVar = null;
        }
        hVar.getRoot().postDelayed(new Runnable() { // from class: com.live.load.d
            @Override // java.lang.Runnable
            public final void run() {
                InitActivity.B(this.f8229a);
            }
        }, 500L);
    }

    private final void t() {
        w0.f21452a.n(this.appTypeKey, new w0.a() { // from class: com.live.load.a
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                InitActivity.u(this.f8224a, (String) obj);
            }
        }, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final InitActivity initActivity, final String value) {
        m.f(value, "value");
        if (value.length() > 0) {
            initActivity.appType = value;
            initActivity.runOnUiThread(new Runnable() { // from class: com.live.load.c
                @Override // java.lang.Runnable
                public final void run() {
                    InitActivity.v(this.f8227a, value);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object w(Context context, v8.f<? super z> fVar) {
        MyApplication.f5174d = context;
        String string = getString(2131951852);
        m.e(string, "getString(...)");
        String string2 = getString(2131951853);
        m.e(string2, "getString(...)");
        String string3 = getString(2131951854);
        m.e(string3, "getString(...)");
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        Context appContext = MyApplication.f5174d;
        m.e(appContext, "appContext");
        Boolean IS_DEBUG = y4.a.f22397a;
        m.e(IS_DEBUG, "IS_DEBUG");
        Object objB0 = aVar.b0(appContext, "prod_", "com.live.evo", IS_DEBUG.booleanValue(), "https://user.aleatorio.website:2053", "http://user.aleatorio.website:2052", "http://user.aleatorio.website:2052", "http://user.aleatorio.website:2052", "https://user.aleatorio.website:2053", "http://user.aleatorio.website:20528", "https://emetrics.aleatorio.website:2083", "https://meta.aleatorio.website:2096", "ulog.aleatorio.website:51000", "https://image.aleatorio.website", "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2", "        -----BEGIN PUBLIC KEY-----\n        MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlpjMh6Qf9uYlo0Yq7xai\n        ANvpM5gmE3WRN9y0pubPzKeMt6yJBcd3KyaWy8fDppeEAX8vEAFEalCDAIN/2Gsu\n        8GsrJRu6cipnLM3MfcY/pQDt63rlpQUCF3LZu8tmit8kns2Jvt+SV+I78vPToG2/\n        qKliDVquv5krf54MbjJeR4/7r8odi0TOaDstAo6616DR6xHKcwW1UF5DE20hMTGi\n        Bp4k+vpzCO+RcHzLfWqR/8aROa3NCYQ/4Z2EbNo8yVtattzyCLVAZ4Z82kD+iC6Q\n        gHH8U63BgjrKQUGrs3KvVZruUFNYgTp8tx8AUy2H2Zagkn0aUIWO+/iM+0xgtyJo\n        RwIDAQAB\n        -----END PUBLIC KEY-----\n", "https://sports.aleatorio.website:2053", string3, string2, string, fVar);
        return objB0 == kotlin.coroutines.intrinsics.b.c() ? objB0 : z.f17874a;
    }

    private final void x() {
        x1.f1.lb.config.c cVarK = j.k(j.f23105a, R$id.loading_layout, 2131102208, getWindow().getDecorView().getRootView(), 0, 8, null);
        String string = getString(R$string.init_env);
        m.e(string, "getString(...)");
        cVarK.c(string);
        cVarK.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String appType) {
        if (m.a(appType, "stb")) {
            if (this.isBgSet.compareAndSet(false, true)) {
                com.tvc.lib.mobile.ext.a.d(this, R$drawable.load_bg, null, 2, null);
            }
        } else if (m.a(appType, "mobile") && this.isBgSet.compareAndSet(false, true)) {
            com.tvc.lib.mobile.ext.a.d(this, R$drawable.load_bg_mb, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        this.latch.countDown();
        if (this.latch.getCount() > 0) {
            return;
        }
        final boolean zA = m.a(of.a.f16585a.c(), "stb");
        runOnUiThread(new Runnable() { // from class: com.live.load.b
            @Override // java.lang.Runnable
            public final void run() {
                InitActivity.A(zA, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(InitActivity initActivity) {
        if (!initActivity.isFinishing()) {
            initActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(InitActivity initActivity, String str) {
        initActivity.y(str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        if (m.a(Looper.myLooper(), Looper.getMainLooper())) {
            AutoSizeCompat.autoConvertDensityOfGlobal(resources);
        }
        m.c(resources);
        return resources;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        z();
    }
}
