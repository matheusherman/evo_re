package com.live.evo_mobile.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.live.evo_mobile.ui.login.LoginTypeActivity;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/live/evo_mobile/ui/AccountManageActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/o;", "<init>", "()V", "Lr8/z;", ExifInterface.LATITUDE_SOUTH, "R", "L", "", "x", "()I", "v", "onResume", ExifInterface.GPS_DIRECTION_TRUE, "M", "onDestroy", "Ljava/util/Timer;", "k", "Ljava/util/Timer;", "timer", "Ly7/a;", "l", "Ly7/a;", "mLoadingViewDialog", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "m", "Landroidx/activity/result/ActivityResultLauncher;", "jumpForResult", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountManageActivity extends BaseDataBindActivity<z4.o> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Timer timer;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private y7.a mLoadingViewDialog;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ActivityResultLauncher<Intent> jumpForResult;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountManageActivity$initView$3$1", f = "AccountManageActivity.kt", l = {76}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ AtomicBoolean $isInLogout;
        final /* synthetic */ String $logoutFailureMsg;
        final /* synthetic */ String $logoutSuccessMsg;
        int label;

        /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountManageActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountManageActivity$initView$3$1$1", f = "AccountManageActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0125a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ AtomicBoolean $isInLogout;
            final /* synthetic */ String $logoutFailureMsg;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AccountManageActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0125a(AccountManageActivity accountManageActivity, String str, AtomicBoolean atomicBoolean, v8.f<? super C0125a> fVar) {
                super(3, fVar);
                this.this$0 = accountManageActivity;
                this.$logoutFailureMsg = str;
                this.$isInLogout = atomicBoolean;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                C0125a c0125a = new C0125a(this.this$0, this.$logoutFailureMsg, this.$isInLogout, fVar);
                c0125a.L$0 = th;
                return c0125a.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.getLogger().error("logout failure", (Throwable) this.L$0);
                    x1.f1.lb.util.g1.f21390a.e(this.$logoutFailureMsg);
                    this.$isInLogout.set(false);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f7823a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f7824b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AccountManageActivity f7825c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f7826d;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountManageActivity$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountManageActivity$initView$3$1$2$1", f = "AccountManageActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0126a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ AccountManageActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0126a(AccountManageActivity accountManageActivity, v8.f<? super C0126a> fVar) {
                    super(2, fVar);
                    this.this$0 = accountManageActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0126a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0126a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.M();
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountManageActivity$a$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountManageActivity$initView$3$1$2", f = "AccountManageActivity.kt", l = {77}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0127b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0127b(b<? super T> bVar, v8.f<? super C0127b> fVar) {
                    super(fVar);
                    this.this$0 = bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            b(AtomicBoolean atomicBoolean, String str, AccountManageActivity accountManageActivity, String str2) {
                this.f7823a = atomicBoolean;
                this.f7824b = str;
                this.f7825c = accountManageActivity;
                this.f7826d = str2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                C0127b c0127b;
                b<T> bVar;
                if (fVar instanceof C0127b) {
                    c0127b = (C0127b) fVar;
                    int i10 = c0127b.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0127b.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0127b = new C0127b(this, fVar);
                    }
                } else {
                    c0127b = new C0127b(this, fVar);
                }
                Object obj = c0127b.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0127b.label;
                if (i11 == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                    C0126a c0126a = new C0126a(this.f7825c, null);
                    c0127b.L$0 = this;
                    c0127b.L$1 = uVar;
                    c0127b.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0126a, c0127b) == objC) {
                        return objC;
                    }
                    bVar = this;
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    uVar = (r8.u) c0127b.L$1;
                    bVar = (b) c0127b.L$0;
                    r8.r.b(obj);
                }
                bVar.f7823a.set(false);
                if (uVar.d().booleanValue()) {
                    x1.f1.lb.util.g1.f21390a.e(bVar.f7824b);
                    bVar.f7825c.finish();
                } else {
                    x1.f1.lb.util.g1.f21390a.e(bVar.f7826d);
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AtomicBoolean atomicBoolean, String str2, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$logoutFailureMsg = str;
            this.$isInLogout = atomicBoolean;
            this.$logoutSuccessMsg = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return AccountManageActivity.this.new a(this.$logoutFailureMsg, this.$isInLogout, this.$logoutSuccessMsg, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.A0("um"), new C0125a(AccountManageActivity.this, this.$logoutFailureMsg, this.$isInLogout, null));
                b bVar = new b(this.$isInLogout, this.$logoutSuccessMsg, AccountManageActivity.this, this.$logoutFailureMsg);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AtomicBoolean atomicBoolean, AccountManageActivity accountManageActivity, View view) {
        if (atomicBoolean.compareAndSet(false, true)) {
            String string = accountManageActivity.getString(2131952349);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            String string2 = accountManageActivity.getString(2131952350);
            kotlin.jvm.internal.m.e(string2, "getString(...)");
            accountManageActivity.T();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, accountManageActivity.new a(string, atomicBoolean, string2, null), 3, null);
        }
    }

    private final void L() {
        Timer timer = this.timer;
        if (timer == null) {
            return;
        }
        if (timer != null) {
            timer.purge();
        }
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.timer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(AccountManageActivity accountManageActivity, View view) {
        Intent intent = new Intent(accountManageActivity, (Class<?>) LoginTypeActivity.class);
        intent.putExtra("loginFrom", 1);
        accountManageActivity.startActivity(intent);
    }

    public final void M() {
        y7.a aVar = this.mLoadingViewDialog;
        if (aVar != null) {
            aVar.d();
        }
    }

    public AccountManageActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.live.evo_mobile.ui.d
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AccountManageActivity.Q(this.f7886a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.m.e(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.jumpForResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AccountManageActivity accountManageActivity, View view) {
        accountManageActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AccountManageActivity accountManageActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            accountManageActivity.R();
        }
    }

    private final void R() {
        L();
    }

    private final void S() {
        t().f22900c.f22874a.setVisibility(8);
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (TextUtils.isEmpty(aVar.F())) {
            t().f22900c.f22875b.setVisibility(8);
        } else {
            t().f22900c.f22875b.setVisibility(0);
            t().f22900c.f22878e.setText(aVar.F());
            t().f22900c.f22875b.setOnClickListener(null);
            t().f22900c.f22881h.setVisibility(4);
        }
        if (TextUtils.isEmpty(aVar.Q())) {
            t().f22900c.f22876c.setVisibility(8);
            return;
        }
        t().f22900c.f22876c.setVisibility(0);
        t().f22900c.f22879f.setText(aVar.Q());
        t().f22900c.f22876c.setOnClickListener(null);
        t().f22900c.f22882i.setVisibility(4);
    }

    public final void T() {
        y7.a aVar;
        if (!s().isFinishing() && !com.tvc.lib.mobile.ext.e.a(s()) && (aVar = this.mLoadingViewDialog) != null) {
            aVar.h();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        L();
        super.onDestroy();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        S();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        t().f22899b.f22836b.setText(getText(2131951662));
        t().f22900c.f22883j.setText(getText(2131951665));
        t().f22900c.f22884k.setText(getText(2131951666));
        t().f22900c.f22885l.setText(getText(2131951667));
        t().f22899b.f22835a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageActivity.N(this.f7925a, view);
            }
        });
        t().f22898a.f22953b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageActivity.O(this.f7930a, view);
            }
        });
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        t().f22898a.f22954c.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageActivity.P(atomicBoolean, this, view);
            }
        });
        this.mLoadingViewDialog = z7.j.f23105a.l(s(), R$color.color_focused);
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_settings_detail;
    }
}
