package com.live.evo_mobile.ui;

import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.ToastUtils;
import com.hjq.toast.Toaster;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import org.apache.log4j.Priority;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020+0*j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020+`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001e¨\u00064"}, d2 = {"Lcom/live/evo_mobile/ui/AccountLinkActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/q;", "<init>", "()V", "Lr8/z;", "Y", "b0", "Z", "", "digitCode", "phoneNumber", "U", "(Ljava/lang/String;Ljava/lang/String;)V", "method", "", "X", "(Ljava/lang/String;)Z", NotificationCompat.CATEGORY_EMAIL, ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", "errorMsg", "a0", "R", ExifInterface.LATITUDE_SOUTH, "", "x", "()I", "v", "k", "Ljava/lang/String;", "password", "l", "m", "n", "Lx1/f1/lb/config/c;", "o", "Lx1/f1/lb/config/c;", "loading", "p", "I", "linkStep", "Ljava/util/HashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/collections/HashMap;", "q", "Ljava/util/HashMap;", "lastRequestCodeTime", "r", IjkMediaMeta.IJKM_KEY_TYPE, "s", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountLinkActivity extends BaseDataBindActivity<z4.q> {

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.config.c loading;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int linkStep;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String password = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String email = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String phoneNumber = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String digitCode = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, AtomicLong> lastRequestCodeTime = new HashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String type = NotificationCompat.CATEGORY_EMAIL;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$getCodeByEmail$1", f = "AccountLinkActivity.kt", l = {232, 237}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $email;
        int label;
        final /* synthetic */ AccountLinkActivity this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$getCodeByEmail$1$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AccountLinkActivity this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountLinkActivity$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$getCodeByEmail$1$1$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0123a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ AccountLinkActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0123a(AccountLinkActivity accountLinkActivity, v8.f<? super C0123a> fVar) {
                    super(2, fVar);
                    this.this$0 = accountLinkActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0123a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0123a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        x1.f1.lb.config.c cVar = this.this$0.loading;
                        if (cVar != null) {
                            cVar.a();
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AccountLinkActivity accountLinkActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = accountLinkActivity;
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
                    Throwable th = (Throwable) this.L$0;
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.c()), null, null, new C0123a(this.this$0, null), 3, null);
                    Toaster.showShort((CharSequence) th.getMessage());
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountLinkActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0124b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AccountLinkActivity f7816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f7817b;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.AccountLinkActivity$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$getCodeByEmail$1$2$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ String $email;
                final /* synthetic */ String $msg;
                int label;
                final /* synthetic */ AccountLinkActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(AccountLinkActivity accountLinkActivity, String str, String str2, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = accountLinkActivity;
                    this.$msg = str;
                    this.$email = str2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$msg, this.$email, fVar);
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
                        x1.f1.lb.config.c cVar = this.this$0.loading;
                        if (cVar != null) {
                            cVar.a();
                        }
                        this.this$0.a0(this.$msg, this.$email);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0124b(AccountLinkActivity accountLinkActivity, String str) {
                this.f7816a = accountLinkActivity;
                this.f7817b = str;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                String str;
                if (uVar.d().booleanValue()) {
                    str = "";
                } else {
                    String strF = uVar.f();
                    str = ((Object) strF) + "(" + uVar.e() + ")";
                }
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(this.f7816a, str, this.f7817b, null), fVar);
                if (objG == kotlin.coroutines.intrinsics.b.c()) {
                    return objG;
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, AccountLinkActivity accountLinkActivity, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$email = str;
            this.this$0 = accountLinkActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$email, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        
            if (r6.collect(r1, r5) == r0) goto L15;
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
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$email;
            this.label = 1;
            obj = aVar.s(str, "REGISTER", this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.this$0, null));
            C0124b c0124b = new C0124b(this.this$0, this.$email);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/AccountLinkActivity$c", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "p0", "Lr8/z;", "onClick", "(Landroid/view/View;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View p10) {
            AccountLinkActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$linkContact$1", f = "AccountLinkActivity.kt", l = {97, 102}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$linkContact$1$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AccountLinkActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AccountLinkActivity accountLinkActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = accountLinkActivity;
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
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.getLogger().error("link contact failure", th);
                    ToastUtils.t(th.getMessage(), new Object[0]);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AccountLinkActivity f7819a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$linkContact$1$2$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ AccountLinkActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(AccountLinkActivity accountLinkActivity, r8.u<Boolean, Integer, String> uVar, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = accountLinkActivity;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String str;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        x1.f1.lb.config.c cVar = this.this$0.loading;
                        if (cVar != null) {
                            cVar.a();
                        }
                        if (this.$it.d().booleanValue()) {
                            str = "";
                        } else {
                            String strF = this.$it.f();
                            str = ((Object) strF) + "(" + this.$it.e() + ")";
                        }
                        if (TextUtils.isEmpty(str)) {
                            this.this$0.linkStep++;
                            this.this$0.b0();
                        } else {
                            ToastUtils.t(str, new Object[0]);
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(AccountLinkActivity accountLinkActivity) {
                this.f7819a = accountLinkActivity;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(this.f7819a, uVar, null), fVar);
                if (objG == kotlin.coroutines.intrinsics.b.c()) {
                    return objG;
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return AccountLinkActivity.this.new d(this.$code, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        
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
            String str = AccountLinkActivity.this.email;
            String str2 = AccountLinkActivity.this.password;
            String str3 = this.$code;
            String str4 = AccountLinkActivity.this.digitCode;
            this.label = 1;
            dVar = this;
            obj = t.v.c.i.a.t0(aVar, str, str2, str3, str4, null, dVar, 16, null);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(AccountLinkActivity.this, null));
            b bVar = new b(AccountLinkActivity.this);
            dVar.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.AccountLinkActivity$setGetCodeResult$1", f = "AccountLinkActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $errorMsg;
        final /* synthetic */ String $method;
        int label;
        final /* synthetic */ AccountLinkActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, AccountLinkActivity accountLinkActivity, String str2, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$errorMsg = str;
            this.this$0 = accountLinkActivity;
            this.$method = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$errorMsg, this.this$0, this.$method, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                if (TextUtils.isEmpty(this.$errorMsg)) {
                    String string = StubApp.getOrigApplicationContext(this.this$0.getApplicationContext()).getString(2131952946);
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    String string2 = StubApp.getOrigApplicationContext(this.this$0.getApplicationContext()).getString(2131952947);
                    kotlin.jvm.internal.m.e(string2, "getString(...)");
                    ToastUtils.t(string + " " + this.$method + string2, new Object[0]);
                } else {
                    ToastUtils.t(this.$errorMsg, new Object[0]);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        StubApp.interface11(12835);
        INSTANCE = new Companion(null);
    }

    private final void T(String email) {
        if (email == null) {
            return;
        }
        x1.f1.lb.config.c cVar = this.loading;
        if (cVar != null) {
            cVar.b();
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(email, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AccountLinkActivity accountLinkActivity, View view) {
        int i10 = accountLinkActivity.linkStep;
        if (i10 == 0) {
            accountLinkActivity.finish();
        } else {
            accountLinkActivity.linkStep = i10 - 1;
            accountLinkActivity.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(AccountLinkActivity accountLinkActivity, View view) {
        int i10 = accountLinkActivity.linkStep;
        if (i10 == 0) {
            accountLinkActivity.R();
        } else if (i10 == 1) {
            accountLinkActivity.S();
        } else {
            if (i10 != 2) {
                return;
            }
            accountLinkActivity.Y();
        }
    }

    private final void Y() {
        x1.f1.lb.config.c cVar = this.loading;
        if (cVar != null) {
            cVar.b();
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(kotlinx.coroutines.a2.b(null, 1, null))), null, null, new d(String.valueOf(t().f22927b.f22910a.getText()), null), 3, null);
    }

    private final void Z() {
        if (X(this.type)) {
            return;
        }
        String str = this.type;
        if (kotlin.jvm.internal.m.a(str, "mobile")) {
            U(this.digitCode, this.phoneNumber);
        } else if (kotlin.jvm.internal.m.a(str, NotificationCompat.CATEGORY_EMAIL)) {
            T(this.email);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        int i10 = this.linkStep;
        if (i10 == 0) {
            t().f22928c.f22952a.setVisibility(0);
            t().f22928c.f22953b.setVisibility(0);
            t().f22928c.f22952a.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952920));
            t().f22928c.f22953b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952922));
            t().f22927b.f22910a.setVisibility(0);
            t().f22927b.f22912c.setVisibility(0);
            t().f22927b.f22911b.setVisibility(8);
            t().f22927b.f22913d.setVisibility(8);
            t().f22927b.f22912c.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131951983));
            t().f22927b.f22910a.requestFocus();
            t().f22927b.f22910a.setInputType(32);
            if (TextUtils.isEmpty(this.email)) {
                return;
            }
            t().f22927b.f22910a.setText(this.email);
            return;
        }
        if (i10 == 1) {
            t().f22928c.f22952a.setVisibility(0);
            t().f22928c.f22953b.setVisibility(0);
            t().f22928c.f22952a.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952920));
            t().f22928c.f22953b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952921));
            t().f22927b.f22910a.setVisibility(0);
            t().f22927b.f22912c.setVisibility(0);
            t().f22927b.f22911b.setVisibility(0);
            t().f22927b.f22913d.setVisibility(0);
            t().f22927b.f22912c.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952632));
            t().f22927b.f22913d.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952637));
            t().f22927b.f22910a.requestFocus();
            t().f22927b.f22910a.setInputType(16);
            t().f22927b.f22911b.setInputType(16);
            t().f22927b.f22910a.setText(this.password);
            t().f22927b.f22911b.setText(this.password);
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            ToastUtils.t(StubApp.getOrigApplicationContext(getApplicationContext()).getString(2131952936), new Object[0]);
            setResult(-1);
            finish();
            return;
        }
        Z();
        t().f22928c.f22952a.setVisibility(0);
        t().f22928c.f22953b.setVisibility(0);
        t().f22928c.f22952a.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952920));
        t().f22928c.f22953b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952922));
        t().f22927b.f22910a.setVisibility(0);
        t().f22927b.f22912c.setVisibility(0);
        t().f22927b.f22911b.setVisibility(8);
        t().f22927b.f22913d.setVisibility(8);
        t().f22927b.f22912c.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131951996));
        t().f22927b.f22910a.requestFocus();
        t().f22927b.f22910a.setInputType(2);
        t().f22927b.f22910a.setText("");
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        this.loading = z7.j.k(z7.j.f23105a, R$id.loading_layout, R$color.color_focused, t().getRoot(), 0, 8, null);
        if (getIntent().getStringExtra("linkType") != null) {
            String stringExtra = getIntent().getStringExtra("linkType");
            kotlin.jvm.internal.m.c(stringExtra);
            this.type = stringExtra;
        }
        if (kotlin.jvm.internal.m.a(this.type, NotificationCompat.CATEGORY_EMAIL)) {
            t().f22929d.f22836b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131951994));
        } else {
            t().f22929d.f22836b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getText(2131952687));
        }
        b0();
        t().f22928c.f22952a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLinkActivity.V(this.f7876a, view);
            }
        });
        t().f22929d.f22835a.setOnClickListener(new c());
        t().f22928c.f22953b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLinkActivity.W(this.f7880a, view);
            }
        });
    }

    private final void R() {
        String str;
        String str2;
        String strValueOf = String.valueOf(t().f22927b.f22910a.getText());
        this.email = strValueOf;
        if (TextUtils.isEmpty(strValueOf)) {
            ToastUtils.s(2131951980);
            return;
        }
        String str3 = this.email;
        if ((str3 == null || !ua.n.I(str3, "@", false, 2, null)) && (((str = this.email) == null || !ua.n.v(str, "@", false, 2, null)) && (str2 = this.email) != null && ua.n.O(str2, "@", false, 2, null))) {
            if (TextUtils.equals(this.email, t.v.c.i.a.f18646a.Z())) {
                ToastUtils.s(2131951989);
                return;
            }
            return;
        }
        ToastUtils.s(2131951984);
    }

    private final void S() {
        String strValueOf = String.valueOf(t().f22927b.f22910a.getText());
        this.password = strValueOf;
        if (strValueOf.length() == 0) {
            ToastUtils.s(2131952628);
        } else if (!kotlin.jvm.internal.m.a(this.password, String.valueOf(t().f22927b.f22911b.getText()))) {
            ToastUtils.s(2131953082);
        } else {
            this.linkStep++;
            b0();
        }
    }

    private final boolean X(String method) {
        Integer num;
        long jC = x1.f1.lb.util.d1.c();
        AtomicLong atomicLong = this.lastRequestCodeTime.get(method);
        if (atomicLong == null) {
            this.lastRequestCodeTime.put(method, new AtomicLong(jC));
            return false;
        }
        long j10 = ((((long) Priority.WARN_INT) + atomicLong.get()) - jC) / ((long) 1000);
        if (j10 > 1) {
            if (kotlin.jvm.internal.m.a(method, "mobile")) {
                num = 2131952688;
            } else if (kotlin.jvm.internal.m.a(method, NotificationCompat.CATEGORY_EMAIL)) {
                num = 2131951995;
            } else {
                num = null;
            }
            if (num != null) {
                kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                String string = StubApp.getOrigApplicationContext(getApplicationContext()).getString(num.intValue());
                kotlin.jvm.internal.m.e(string, "getString(...)");
                String str = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
                kotlin.jvm.internal.m.e(str, "format(...)");
                ToastUtils.r(str, new Object[0]);
            }
            return true;
        }
        atomicLong.set(jC);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(String errorMsg, String method) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.c()), null, null, new e(errorMsg, this, method, null), 3, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_settings_link;
    }

    private final void U(String digitCode, String phoneNumber) {
    }
}
