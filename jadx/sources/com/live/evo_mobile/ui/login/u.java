package com.live.evo_mobile.ui.login;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$layout;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.g2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003CD\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010#J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0004R\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00108\u001a\u000605R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010<\u001a\u000609R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>¨\u0006E"}, d2 = {"Lcom/live/evo_mobile/ui/login/u;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/a0;", "<init>", "()V", "", "index", "Lr8/z;", "W0", "(Ljava/lang/Integer;)V", "tab", "Y0", "(I)V", "a1", "Z0", "c1", "d1", "", "message", "g1", "(Ljava/lang/String;)V", "C0", "()Ljava/lang/String;", "D0", "c", "str", "X0", "V0", "", "time", "e1", "(J)V", "f1", "b1", ExifInterface.LONGITUDE_WEST, "()I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "y", "R", "onDestroy", "e", "I", "TAB_EMAIL", "f", "TAB_PHONE", "", "g", "Z", "pwdShowForEmail", "h", "pwdShowForPhone", "i", "J", "Lcom/live/evo_mobile/ui/login/u$b;", "j", "Lcom/live/evo_mobile/ui/login/u$b;", "timer", "Lcom/live/evo_mobile/ui/login/u$c;", "k", "Lcom/live/evo_mobile/ui/login/u$c;", "phoneTimer", "l", "Ljava/lang/String;", "emailVerificationCode", "m", "phoneVerificationCode", "n", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u extends com.tvc.lib.mobile.ui.base.d<z4.a0> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int TAB_EMAIL;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean pwdShowForEmail;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean pwdShowForPhone;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long time;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int TAB_PHONE = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private b timer = new b(120000, 1000);

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private c phoneTimer = new c(120000, 1000);

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String emailVerificationCode = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String phoneVerificationCode = "";

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.u$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/login/u$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/login/u;", "a", "()Lcom/live/evo_mobile/ui/login/u;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final u a() {
            return new u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/live/evo_mobile/ui/login/u$b;", "Landroid/os/CountDownTimer;", "", "millisInFuture", "countDownInterval", "<init>", "(Lcom/live/evo_mobile/ui/login/u;JJ)V", "millisUntilFinished", "Lr8/z;", "onTick", "(J)V", "onFinish", "()V", "", "a", "Z", "()Z", "b", "(Z)V", "finished", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                this.finished = true;
                if (u.this.T().f22675c.f22722z.getSelectedTabPosition() != u.this.TAB_EMAIL) {
                    return;
                }
                u.this.T().f22683k.setText(z7.p.b(2131952907));
                u.this.T().f22683k.setClickable(true);
            } catch (Exception unused) {
            }
        }

        public b(long j10, long j11) {
            super(j10, j11);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void b(boolean z10) {
            this.finished = z10;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            u.this.e1(millisUntilFinished);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/live/evo_mobile/ui/login/u$c;", "Landroid/os/CountDownTimer;", "", "millisInFuture", "countDownInterval", "<init>", "(Lcom/live/evo_mobile/ui/login/u;JJ)V", "millisUntilFinished", "Lr8/z;", "onTick", "(J)V", "onFinish", "()V", "", "a", "Z", "()Z", "b", "(Z)V", "finished", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                this.finished = true;
                if (u.this.T().f22675c.f22722z.getSelectedTabPosition() != u.this.TAB_PHONE) {
                    return;
                }
                u.this.T().f22683k.setText(z7.p.b(2131952907));
                u.this.T().f22683k.setClickable(true);
            } catch (Exception unused) {
            }
        }

        public c(long j10, long j11) {
            super(j10, j11);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void b(boolean z10) {
            this.finished = z10;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            u.this.f1(millisUntilFinished);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$createAccount$1", f = "CreateAccountFragment.kt", l = {TypedValues.PositionType.TYPE_SIZE_PERCENT, 509}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $account;
        final /* synthetic */ String $pwd;
        final /* synthetic */ String $verifyCode;
        int label;
        final /* synthetic */ u this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$createAccount$1$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ u this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.u$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$createAccount$1$1$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0137a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ u this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0137a(u uVar, Throwable th, v8.f<? super C0137a> fVar) {
                    super(2, fVar);
                    this.this$0 = uVar;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0137a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0137a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        u uVar = this.this$0;
                        String message = this.$it.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        uVar.X0(message);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(u uVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = uVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0137a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f8109a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$createAccount$1$2$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ u this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, u uVar2, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = uVar2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$it, this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.$it.d().booleanValue()) {
                            this.this$0.c();
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.V0();
                            } else {
                                u uVar = this.this$0;
                                String strF = this.$it.f();
                                uVar.X0(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(u uVar) {
                this.f8109a = uVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8109a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, String str3, u uVar, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$account = str;
            this.$pwd = str2;
            this.$verifyCode = str3;
            this.this$0 = uVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new d(this.$account, this.$pwd, this.$verifyCode, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (r13.collect(r1, r12) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            d dVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    dVar = this;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$account;
            String str2 = this.$pwd;
            String str3 = this.$verifyCode;
            this.label = 1;
            dVar = this;
            obj = t.v.c.i.a.t0(aVar, str, str2, str3, "", null, dVar, 16, null);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(dVar.this$0, null));
            b bVar = new b(dVar.this$0);
            dVar.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/u$e", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            u.this.T().f22675c.f22707k.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !u.this.T().f22675c.f22700d.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/u$f", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            u.this.T().f22675c.f22708l.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !u.this.T().f22675c.f22701e.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/u$g", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            u.this.T().f22675c.f22705i.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !u.this.T().f22675c.f22703g.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/u$h", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            u.this.T().f22675c.f22706j.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !u.this.T().f22675c.f22704h.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/login/u$i", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "p0", "Lr8/z;", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "onTabUnselected", "onTabReselected", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements TabLayout.OnTabSelectedListener {
        i() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab p10) {
            u.this.W0(p10 != null ? Integer.valueOf(p10.getPosition()) : null);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab p10) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab p10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1", f = "CreateAccountFragment.kt", l = {366, 370, 378}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $account;
        final /* synthetic */ int $index;
        int label;
        final /* synthetic */ u this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ u this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.u$j$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1$1$1", f = "CreateAccountFragment.kt", l = {374}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0138a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ u this$0;

                /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.u$j$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1$1$1$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
                static final class C0139a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                    int label;
                    final /* synthetic */ u this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0139a(u uVar, v8.f<? super C0139a> fVar) {
                        super(2, fVar);
                        this.this$0 = uVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                        return new C0139a(this.this$0, fVar);
                    }

                    @Override // c9.p
                    public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                        return ((C0139a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r8.r.b(obj);
                            u uVar = this.this$0;
                            uVar.b1(uVar.T().f22675c.f22722z.getSelectedTabPosition());
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0138a(u uVar, Throwable th, v8.f<? super C0138a> fVar) {
                    super(2, fVar);
                    this.this$0 = uVar;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0138a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0138a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                        this.this$0.g1(this.$it.getMessage());
                        g2 g2VarC = kotlinx.coroutines.a1.c();
                        C0139a c0139a = new C0139a(this.this$0, null);
                        this.label = 1;
                        if (kotlinx.coroutines.h.g(g2VarC, c0139a, this) == objC) {
                            return objC;
                        }
                    }
                    return r8.z.f17874a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(u uVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = uVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0138a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f8115a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1$2$1", f = "CreateAccountFragment.kt", l = {388}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ u this$0;

                /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.u$j$b$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.CreateAccountFragment$sendVerifyCode$1$2$1$1", f = "CreateAccountFragment.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
                static final class C0140a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                    int label;
                    final /* synthetic */ u this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0140a(u uVar, v8.f<? super C0140a> fVar) {
                        super(2, fVar);
                        this.this$0 = uVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                        return new C0140a(this.this$0, fVar);
                    }

                    @Override // c9.p
                    public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                        return ((C0140a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r8.r.b(obj);
                            u uVar = this.this$0;
                            uVar.b1(uVar.T().f22675c.f22722z.getSelectedTabPosition());
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, u uVar2, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = uVar2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$it, this.this$0, fVar);
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
                        if (this.$it.d().booleanValue()) {
                            this.this$0.d1();
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.V0();
                            } else {
                                u uVar = this.this$0;
                                String strF = this.$it.f();
                                uVar.g1(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                            g2 g2VarC = kotlinx.coroutines.a1.c();
                            C0140a c0140a = new C0140a(this.this$0, null);
                            this.label = 1;
                            if (kotlinx.coroutines.h.g(g2VarC, c0140a, this) == objC) {
                                return objC;
                            }
                        }
                    }
                    return r8.z.f17874a;
                }
            }

            b(u uVar) {
                this.f8115a = uVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8115a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(int i10, u uVar, String str, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$index = i10;
            this.this$0 = uVar;
            this.$account = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new j(this.$index, this.this$0, this.$account, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            if (r7 == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
        
            if (r7 == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.f fVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r8.r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r8.r.b(obj);
                        fVar = (kotlinx.coroutines.flow.f) obj;
                    }
                } else {
                    r8.r.b(obj);
                    fVar = (kotlinx.coroutines.flow.f) obj;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            if (this.$index == this.this$0.TAB_EMAIL) {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String str = this.$account;
                this.label = 1;
                obj = aVar.s(str, "REGISTER", this);
            } else {
                com.live.evo_mobile.ui.login.c cVar = com.live.evo_mobile.ui.login.a.INSTANCE.a().c().get(this.this$0.T().f22675c.f22721y.getSelectedItemPosition());
                t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
                String phonePreCode = cVar.getPhonePreCode();
                if (phonePreCode == null) {
                    phonePreCode = "";
                }
                String str2 = this.$account;
                this.label = 2;
                obj = aVar2.t(phonePreCode, str2, "REGISTER", this);
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(fVar, new a(this.this$0, null));
            b bVar = new b(this.this$0);
            this.label = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(Integer index) {
        if (index != null && index.intValue() == 0) {
            T().f22675c.f22698b.setVisibility(0);
            T().f22675c.f22714r.setVisibility(8);
            T().f22682j.setText(Html.fromHtml(z7.p.b(2131951987)));
            if (this.timer.getFinished()) {
                T().f22683k.setText(z7.p.b(2131952907));
                T().f22683k.setClickable(true);
            } else {
                T().f22683k.setClickable(false);
            }
            this.phoneVerificationCode = T().f22673a.getText().toString();
            T().f22673a.setText(this.emailVerificationCode);
            return;
        }
        T().f22675c.f22698b.setVisibility(8);
        T().f22675c.f22714r.setVisibility(0);
        T().f22682j.setText(Html.fromHtml(z7.p.b(2131952673)));
        if (this.phoneTimer.getFinished()) {
            T().f22683k.setText(z7.p.b(2131952907));
            T().f22683k.setClickable(true);
        } else {
            T().f22683k.setClickable(false);
        }
        this.emailVerificationCode = T().f22673a.getText().toString();
        T().f22673a.setText(this.phoneVerificationCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(u uVar, View view) {
        uVar.pwdShowForPhone = !uVar.pwdShowForPhone;
        uVar.T().f22675c.f22709m.setImageResource(uVar.pwdShowForPhone ? R$drawable.pwd_visible : R$drawable.pwd_invisible);
        int i10 = uVar.pwdShowForPhone ? 145 : 129;
        uVar.T().f22675c.f22703g.setInputType(i10);
        uVar.T().f22675c.f22704h.setInputType(i10);
        try {
            uVar.T().f22675c.f22703g.setSelection(uVar.T().f22675c.f22703g.getText().length());
            uVar.T().f22675c.f22704h.setSelection(uVar.T().f22675c.f22704h.getText().length());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(u uVar, View view) {
        uVar.pwdShowForEmail = !uVar.pwdShowForEmail;
        uVar.T().f22675c.f22710n.setImageResource(uVar.pwdShowForEmail ? R$drawable.pwd_visible : R$drawable.pwd_invisible);
        int i10 = uVar.pwdShowForEmail ? 145 : 129;
        uVar.T().f22675c.f22700d.setInputType(i10);
        uVar.T().f22675c.f22701e.setInputType(i10);
        try {
            uVar.T().f22675c.f22700d.setSelection(uVar.T().f22675c.f22700d.getText().length());
            uVar.T().f22675c.f22701e.setSelection(uVar.T().f22675c.f22701e.getText().length());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(u uVar, View view, boolean z10) {
        if (z10) {
            Editable text = uVar.T().f22675c.f22703g.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                uVar.T().f22675c.f22705i.setVisibility(0);
            }
        } else {
            uVar.T().f22675c.f22705i.setVisibility(8);
        }
        uVar.T().f22675c.f22719w.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(u uVar, View view, boolean z10) {
        if (z10) {
            Editable text = uVar.T().f22675c.f22704h.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                uVar.T().f22675c.f22706j.setVisibility(0);
            }
        } else {
            uVar.T().f22675c.f22706j.setVisibility(8);
        }
        uVar.T().f22675c.f22720x.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(u uVar, View view, boolean z10) {
        if (z10) {
            Editable text = uVar.T().f22675c.f22700d.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                uVar.T().f22675c.f22707k.setVisibility(0);
            }
        } else {
            uVar.T().f22675c.f22707k.setVisibility(8);
        }
        uVar.T().f22675c.f22716t.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(u uVar, View view, boolean z10) {
        if (z10) {
            Editable text = uVar.T().f22675c.f22701e.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                uVar.T().f22675c.f22708l.setVisibility(0);
            }
        } else {
            uVar.T().f22675c.f22708l.setVisibility(8);
        }
        uVar.T().f22675c.f22717u.setSelected(z10);
    }

    private final void Y0(int tab) {
        if (tab == this.TAB_EMAIL) {
            T().f22675c.f22699c.requestFocus();
        } else {
            T().f22675c.f22702f.requestFocus();
        }
    }

    private final void Z0(int tab) {
        if (tab == this.TAB_EMAIL) {
            T().f22675c.f22701e.requestFocus();
        } else {
            T().f22675c.f22703g.requestFocus();
        }
    }

    private final void a1(int tab) {
        if (tab == this.TAB_EMAIL) {
            T().f22675c.f22700d.requestFocus();
        } else {
            T().f22675c.f22703g.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(int tab) {
        if (tab == this.TAB_EMAIL) {
            this.timer.cancel();
            this.timer.onFinish();
        } else {
            this.phoneTimer.cancel();
            this.phoneTimer.onFinish();
        }
    }

    private final String C0() {
        String string;
        String string2;
        int selectedTabPosition = T().f22675c.f22722z.getSelectedTabPosition();
        if (selectedTabPosition == this.TAB_EMAIL) {
            string = T().f22675c.f22700d.getText().toString();
        } else {
            string = T().f22675c.f22703g.getText().toString();
        }
        if (TextUtils.isEmpty(string)) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strB = z7.p.b(2131952756);
            kotlin.jvm.internal.m.e(strB, "getString(...)");
            g1Var.c(strB);
            a1(selectedTabPosition);
            return "";
        }
        int length = string.length();
        if (6 <= length && length < 17) {
            if (selectedTabPosition == this.TAB_EMAIL) {
                string2 = T().f22675c.f22701e.getText().toString();
            } else {
                string2 = T().f22675c.f22704h.getText().toString();
            }
            if (kotlin.jvm.internal.m.a(string2, "")) {
                x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                String strB2 = z7.p.b(2131952754);
                kotlin.jvm.internal.m.e(strB2, "getString(...)");
                g1Var2.c(strB2);
                Z0(selectedTabPosition);
                return "";
            }
            if (!kotlin.jvm.internal.m.a(string, string2)) {
                x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
                String strB3 = z7.p.b(2131952755);
                kotlin.jvm.internal.m.e(strB3, "getString(...)");
                g1Var3.c(strB3);
                Z0(selectedTabPosition);
                return "";
            }
            return string;
        }
        x1.f1.lb.util.g1 g1Var4 = x1.f1.lb.util.g1.f21390a;
        String strB4 = z7.p.b(2131952758);
        kotlin.jvm.internal.m.e(strB4, "getString(...)");
        g1Var4.c(strB4);
        a1(selectedTabPosition);
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x008b  */
    /* JADX WARN: Code duplicated, block: B:14:0x009e  */
    /* JADX WARN: Code duplicated, block: B:16:0x00a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:19:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:20:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:22:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:28:0x0108  */
    private final void D0() {
        String str;
        String string;
        String strC0;
        boolean zG;
        String string2;
        int selectedTabPosition = T().f22675c.f22722z.getSelectedTabPosition();
        if (selectedTabPosition == this.TAB_EMAIL) {
            string = ua.n.Q0(T().f22675c.f22699c.getText().toString()).toString();
        } else {
            com.live.evo_mobile.ui.login.c cVar = a.INSTANCE.a().c().get(T().f22675c.f22721y.getSelectedItemPosition());
            String string3 = ua.n.Q0(String.valueOf(T().f22675c.f22702f.getText())).toString();
            str = "";
            if (!kotlin.jvm.internal.m.a(string3, "")) {
                string = cVar.getPhonePreCode() + string3;
            }
            if (TextUtils.isEmpty(str)) {
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                String strB = z7.p.b(2131951652);
                kotlin.jvm.internal.m.e(strB, "getString(...)");
                g1Var.c(strB);
                Y0(selectedTabPosition);
                return;
            }
            strC0 = C0();
            if (strC0.length() == 0) {
                return;
            }
            if (selectedTabPosition == this.TAB_EMAIL) {
                zG = a.INSTANCE.a().f(str);
            } else {
                zG = a.INSTANCE.a().g(str);
            }
            if (!zG) {
                x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                String strB2 = z7.p.b(2131953141);
                kotlin.jvm.internal.m.e(strB2, "getString(...)");
                g1Var2.c(strB2);
                Y0(selectedTabPosition);
                return;
            }
            string2 = T().f22673a.getText().toString();
            if (TextUtils.isEmpty(string2)) {
                x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
                String strB3 = z7.p.b(2131953166);
                kotlin.jvm.internal.m.e(strB3, "getString(...)");
                g1Var3.c(strB3);
                T().f22673a.requestFocus();
                return;
            }
            Z();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new d(str, strC0, string2, this, null), 3, null);
        }
        str = string;
        if (TextUtils.isEmpty(str)) {
            x1.f1.lb.util.g1 g1Var4 = x1.f1.lb.util.g1.f21390a;
            String strB4 = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB4, "getString(...)");
            g1Var4.c(strB4);
            Y0(selectedTabPosition);
            return;
        }
        strC0 = C0();
        if (strC0.length() == 0) {
            return;
        }
        if (selectedTabPosition == this.TAB_EMAIL) {
            zG = a.INSTANCE.a().f(str);
        } else {
            zG = a.INSTANCE.a().g(str);
        }
        if (!zG) {
            x1.f1.lb.util.g1 g1Var5 = x1.f1.lb.util.g1.f21390a;
            String strB5 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB5, "getString(...)");
            g1Var5.c(strB5);
            Y0(selectedTabPosition);
            return;
        }
        string2 = T().f22673a.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            x1.f1.lb.util.g1 g1Var6 = x1.f1.lb.util.g1.f21390a;
            String strB6 = z7.p.b(2131953166);
            kotlin.jvm.internal.m.e(strB6, "getString(...)");
            g1Var6.c(strB6);
            T().f22673a.requestFocus();
            return;
        }
        Z();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new d(str, strC0, string2, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(u uVar, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = uVar.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(u uVar, View view, boolean z10) {
        uVar.T().f22675c.f22718v.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(u uVar, View view) {
        uVar.T().f22675c.f22701e.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(u uVar, View view, boolean z10) {
        uVar.T().f22679g.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(u uVar, View view) {
        uVar.c1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(u uVar, View view) {
        if (System.currentTimeMillis() - uVar.time < 1000) {
            return;
        }
        uVar.time = System.currentTimeMillis();
        uVar.D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(u uVar, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = uVar.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(u uVar, View view) {
        uVar.T().f22675c.f22703g.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(u uVar, View view) {
        uVar.T().f22675c.f22704h.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(u uVar, View view, boolean z10) {
        uVar.T().f22675c.f22715s.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(u uVar, View view) {
        uVar.T().f22675c.f22700d.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        U();
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952547);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(String str) {
        U();
        x1.f1.lb.util.g1.f21390a.c(z7.p.b(2131952960) + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        LoginTypeActivity loginTypeActivity;
        U();
        FragmentActivity activity = getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.Y();
        }
    }

    private final void c1() {
        String string;
        boolean zG;
        boolean z10;
        int selectedTabPosition = T().f22675c.f22722z.getSelectedTabPosition();
        if (selectedTabPosition == this.TAB_EMAIL) {
            string = ua.n.Q0(T().f22675c.f22699c.getText().toString()).toString();
        } else {
            string = ua.n.Q0(String.valueOf(T().f22675c.f22702f.getText())).toString();
        }
        if (TextUtils.isEmpty(string)) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strB = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB, "getString(...)");
            g1Var.c(strB);
            Y0(selectedTabPosition);
            return;
        }
        if (selectedTabPosition == this.TAB_EMAIL) {
            zG = a.INSTANCE.a().f(string);
        } else {
            a.Companion companion = a.INSTANCE;
            com.live.evo_mobile.ui.login.c cVar = companion.a().c().get(T().f22675c.f22721y.getSelectedItemPosition());
            zG = companion.a().g(cVar.getPhonePreCode() + string);
        }
        if (!zG) {
            x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
            String strB2 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB2, "getString(...)");
            g1Var2.c(strB2);
            Y0(selectedTabPosition);
            return;
        }
        if (C0().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return;
        }
        Z();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new j(selectedTabPosition, this, string, null), 3, null);
        if (selectedTabPosition == this.TAB_EMAIL) {
            this.timer.cancel();
            b bVar = new b(120000L, 1000L);
            this.timer = bVar;
            bVar.start();
        } else {
            this.phoneTimer.cancel();
            c cVar2 = new c(120000L, 1000L);
            this.phoneTimer = cVar2;
            cVar2.start();
        }
        T().f22683k.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(long time) {
        try {
            if (T().f22675c.f22722z.getSelectedTabPosition() == this.TAB_EMAIL) {
                T().f22683k.setText(z7.p.b(2131952906) + TimeUnit.MILLISECONDS.toSeconds(time) + "s)");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(long time) {
        try {
            if (T().f22675c.f22722z.getSelectedTabPosition() == this.TAB_PHONE) {
                T().f22683k.setText(z7.p.b(2131952906) + TimeUnit.MILLISECONDS.toSeconds(time) + "s)");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(String message) {
        U();
        x1.f1.lb.util.g1.f21390a.c(z7.p.b(2131953168) + " " + message);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        T().f22675c.f22721y.setAdapter((SpinnerAdapter) new com.live.evo_mobile.ui.login.b(S(), a.INSTANCE.a().c()));
        TabLayout tabLayout = T().f22675c.f22722z;
        kotlin.jvm.internal.m.e(tabLayout, "tabLayout");
        tabLayout.removeAllTabs();
        tabLayout.setTabTextColors(getResources().getColor(R$color.text_color_normal), getResources().getColor(R$color.color_focused));
        tabLayout.setBackgroundColor(0);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R$color.color_focused));
        tabLayout.addTab(tabLayout.newTab().setText(2131951694));
        tabLayout.addTab(tabLayout.newTab().setText(2131951695));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new i());
        this.timer.b(true);
        this.phoneTimer.b(true);
        W0(Integer.valueOf(this.TAB_EMAIL));
        T().f22675c.f22711o.setVisibility(8);
        T().f22675c.f22712p.setVisibility(8);
        T().f22681i.setText(Html.fromHtml(z7.p.b(2131951739)));
        T().f22682j.setText(Html.fromHtml(z7.p.b(2131951987)));
        T().f22675c.f22717u.setVisibility(0);
        T().f22675c.f22720x.setVisibility(0);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_create_account;
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.timer.cancel();
        this.phoneTimer.cancel();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        T().f22674b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.E0(this.f8023a, view);
            }
        });
        T().f22675c.f22702f.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.s
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.F0(this.f8092a, view, z10);
            }
        });
        T().f22675c.f22703g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.t
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.N0(this.f8094a, view, z10);
            }
        });
        T().f22675c.f22704h.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.O0(this.f8026a, view, z10);
            }
        });
        T().f22675c.f22703g.addTextChangedListener(new g());
        T().f22675c.f22704h.addTextChangedListener(new h());
        T().f22675c.f22705i.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.P0(this.f8029a, view);
            }
        });
        T().f22675c.f22706j.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.Q0(this.f8032a, view);
            }
        });
        T().f22675c.f22699c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.h
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.R0(this.f8057a, view, z10);
            }
        });
        T().f22675c.f22700d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.i
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.S0(this.f8059a, view, z10);
            }
        });
        T().f22675c.f22701e.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.T0(this.f8061a, view, z10);
            }
        });
        T().f22675c.f22700d.addTextChangedListener(new e());
        T().f22675c.f22701e.addTextChangedListener(new f());
        T().f22675c.f22707k.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.U0(this.f8063a, view);
            }
        });
        T().f22675c.f22708l.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.G0(this.f8078a, view);
            }
        });
        T().f22675c.f22709m.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.H0(this.f8080a, view);
            }
        });
        T().f22675c.f22710n.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.I0(this.f8082a, view);
            }
        });
        T().f22679g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.o
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                u.J0(this.f8084a, view, z10);
            }
        });
        T().f22683k.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.K0(this.f8086a, view);
            }
        });
        T().f22677e.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.L0(this.f8088a, view);
            }
        });
        T().f22680h.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.M0(this.f8090a, view);
            }
        });
    }
}
