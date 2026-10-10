package com.live.evo_mobile.ui;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.ToastUtils;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u000f¨\u0006'"}, d2 = {"Lcom/live/evo_mobile/ui/RenewActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/k;", "<init>", "()V", "Lkotlin/Function0;", "Lr8/z;", "noUpdateCallback", "a0", "(Lc9/a;)V", "", "U", "()Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Z", "", "x", "()I", "v", "onResume", "onPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInRecharge", "Lx1/f1/lb/config/c;", "l", "Lx1/f1/lb/config/c;", "loading", "", "m", "isPaused", "", "n", "J", "lastExpiredTs", "o", "toSetAccountInfo", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenewActivity extends BaseDataBindActivity<z4.k> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isInRecharge = new AtomicBoolean(false);

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.config.c loading;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPaused;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long lastExpiredTs;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean toSetAccountInfo;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$doLoginByRechargeCode$1", f = "RenewActivity.kt", l = {164, 167}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $code;
        int label;
        final /* synthetic */ RenewActivity this$0;

        /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$doLoginByRechargeCode$1$1", f = "RenewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0128a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RenewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0128a(RenewActivity renewActivity, v8.f<? super C0128a> fVar) {
                super(3, fVar);
                this.this$0 = renewActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                C0128a c0128a = new C0128a(this.this$0, fVar);
                c0128a.L$0 = th;
                return c0128a.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.isInRecharge.set(false);
                    this.this$0.getLogger().error("recharge failure", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RenewActivity f7857a;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$doLoginByRechargeCode$1$2$1", f = "RenewActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0129a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ RenewActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0129a(RenewActivity renewActivity, r8.u<Boolean, Integer, String> uVar, v8.f<? super C0129a> fVar) {
                    super(2, fVar);
                    this.this$0 = renewActivity;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0129a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0129a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String str;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (!this.this$0.isPaused && !this.this$0.isFinishing() && !this.this$0.isDestroyed()) {
                            if (this.$it.d().booleanValue()) {
                                str = "";
                            } else {
                                String strF = this.$it.f();
                                str = ((Object) strF) + "(" + this.$it.e() + ")";
                            }
                            if (str.length() == 0) {
                                RenewActivity.b0(this.this$0, null, 1, null);
                                Editable text = this.this$0.t().f22822d.getText();
                                if (text != null) {
                                    text.clear();
                                }
                            } else {
                                Context origApplicationContext = StubApp.getOrigApplicationContext(this.this$0.getApplicationContext());
                                kotlin.jvm.internal.m.e(origApplicationContext, "getApplicationContext(...)");
                                com.tvc.lib.mobile.ext.h.g(str, origApplicationContext);
                            }
                            x1.f1.lb.config.c cVar = this.this$0.loading;
                            if (cVar != null) {
                                cVar.a();
                            }
                            return r8.z.f17874a;
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(RenewActivity renewActivity) {
                this.f7857a = renewActivity;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                this.f7857a.isInRecharge.set(false);
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new C0129a(this.f7857a, uVar, null), fVar);
                return objG == kotlin.coroutines.intrinsics.b.c() ? objG : r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, RenewActivity renewActivity, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$code = str;
            this.this$0 = renewActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$code, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
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
            String str = this.$code;
            this.label = 1;
            obj = aVar.B0(str, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0128a(this.this$0, null));
            b bVar = new b(this.this$0);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1", f = "RenewActivity.kt", l = {96, 104}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.a<r8.z> $noUpdateCallback;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1$1", f = "RenewActivity.kt", l = {100}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ RenewActivity this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1$1$1", f = "RenewActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0130a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ RenewActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0130a(RenewActivity renewActivity, v8.f<? super C0130a> fVar) {
                    super(2, fVar);
                    this.this$0 = renewActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0130a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0130a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        x1.f1.lb.config.c cVar = this.this$0.loading;
                        if (cVar != null) {
                            cVar.a();
                            return r8.z.f17874a;
                        }
                        return null;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RenewActivity renewActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = renewActivity;
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
                Throwable th;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        th = (Throwable) this.L$0;
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    Throwable th2 = (Throwable) this.L$0;
                    if (!this.this$0.isPaused && !this.this$0.isFinishing() && !this.this$0.isDestroyed()) {
                        kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                        C0130a c0130a = new C0130a(this.this$0, null);
                        this.L$0 = th2;
                        this.label = 1;
                        if (kotlinx.coroutines.h.g(g2VarC, c0130a, this) == objC) {
                            return objC;
                        }
                        th = th2;
                    } else {
                        return r8.z.f17874a;
                    }
                }
                this.this$0.getLogger().error("update session failure in login", th);
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0131b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RenewActivity f7858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c9.a<r8.z> f7859b;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1$2$1", f = "RenewActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ RenewActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(RenewActivity renewActivity, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = renewActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, fVar);
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
                            return r8.z.f17874a;
                        }
                        return null;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$b$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1$2$2", f = "RenewActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0132b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ long $expireTS;
                final /* synthetic */ c9.a<r8.z> $noUpdateCallback;
                int label;
                final /* synthetic */ RenewActivity this$0;

                /* JADX INFO: Access modifiers changed from: private */
                public static final r8.z c(RenewActivity renewActivity) {
                    renewActivity.toSetAccountInfo = false;
                    renewActivity.Z();
                    return r8.z.f17874a;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0132b(long j10, RenewActivity renewActivity, c9.a<r8.z> aVar, v8.f<? super C0132b> fVar) {
                    super(2, fVar);
                    this.$expireTS = j10;
                    this.this$0 = renewActivity;
                    this.$noUpdateCallback = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0132b(this.$expireTS, this.this$0, this.$noUpdateCallback, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0132b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.$expireTS > this.this$0.lastExpiredTs) {
                            this.this$0.lastExpiredTs = this.$expireTS;
                            this.this$0.toSetAccountInfo = true;
                            String string = StubApp.getOrigApplicationContext(this.this$0.getApplicationContext()).getString(2131952787);
                            kotlin.jvm.internal.m.e(string, "getString(...)");
                            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                            String str = aVar.Z() + "\n" + aVar.H();
                            final RenewActivity renewActivity = this.this$0;
                            v7.c cVar = new v7.c(str, new c9.a() { // from class: com.live.evo_mobile.ui.p1
                                @Override // c9.a
                                public final Object invoke() {
                                    return RenewActivity.b.C0131b.C0132b.c(renewActivity);
                                }
                            });
                            cVar.setTitle(string);
                            cVar.a0();
                            FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                            kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
                            cVar.X(supportFragmentManager);
                        } else {
                            c9.a<r8.z> aVar2 = this.$noUpdateCallback;
                            if (aVar2 != null) {
                                aVar2.invoke();
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.RenewActivity$b$b$c */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.RenewActivity$updateSession$1$2", f = "RenewActivity.kt", l = {108, 114}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class c extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0131b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                c(C0131b<? super T> c0131b, v8.f<? super c> fVar) {
                    super(fVar);
                    this.this$0 = c0131b;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            C0131b(RenewActivity renewActivity, c9.a<r8.z> aVar) {
                this.f7858a = renewActivity;
                this.f7859b = aVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
            
                if (kotlinx.coroutines.h.g(r13, r6, r0) == r1) goto L31;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                c cVar;
                C0131b<T> c0131b;
                if (fVar instanceof c) {
                    cVar = (c) fVar;
                    int i10 = cVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        cVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        cVar = new c(this, fVar);
                    }
                } else {
                    cVar = new c(this, fVar);
                }
                Object obj = cVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = cVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        uVar = (r8.u) cVar.L$1;
                        c0131b = (C0131b) cVar.L$0;
                        r8.r.b(obj);
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(obj);
                if (this.f7858a.isPaused || this.f7858a.isFinishing() || this.f7858a.isDestroyed()) {
                    return r8.z.f17874a;
                }
                kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                a aVar = new a(this.f7858a, null);
                cVar.L$0 = this;
                cVar.L$1 = uVar;
                cVar.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, aVar, cVar) != objC) {
                    c0131b = this;
                }
                return objC;
                if (!uVar.d().booleanValue()) {
                    return r8.z.f17874a;
                }
                long jI = t.v.c.i.a.f18646a.I();
                kotlinx.coroutines.g2 g2VarC2 = kotlinx.coroutines.a1.c();
                C0132b c0132b = new C0132b(jI, c0131b.f7858a, c0131b.f7859b, null);
                cVar.L$0 = null;
                cVar.L$1 = null;
                cVar.label = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(c9.a<r8.z> aVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$noUpdateCallback = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return RenewActivity.this.new b(this.$noUpdateCallback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
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
            this.label = 1;
            obj = aVar.M0(this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(RenewActivity.this, null));
            C0131b c0131b = new C0131b(RenewActivity.this, this.$noUpdateCallback);
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        setResult(1);
        finish();
    }

    private final String T() {
        return ua.n.E(ua.n.E(t.v.c.i.a.f18646a.N(), "http://", "", false, 4, null), "https://", "", false, 4, null);
    }

    private final String U() {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        return aVar.O() + "&c=" + (aVar.Z().length() == 0 ? "1" : "2#plan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(RenewActivity renewActivity, View view) {
        x1.f1.lb.config.c cVar = renewActivity.loading;
        if (cVar != null) {
            cVar.b();
        }
        renewActivity.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final RenewActivity renewActivity, View view) {
        x1.f1.lb.config.c cVar = renewActivity.loading;
        if (cVar != null) {
            cVar.b();
        }
        renewActivity.a0(new c9.a() { // from class: com.live.evo_mobile.ui.o1
            @Override // c9.a
            public final Object invoke() {
                return RenewActivity.X(this.f8163a);
            }
        });
    }

    private final void a0(c9.a<r8.z> noUpdateCallback) {
        if (this.isPaused || isFinishing() || isDestroyed()) {
            return;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(noUpdateCallback, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void b0(RenewActivity renewActivity, c9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        renewActivity.a0(aVar);
    }

    private final void S() {
        String strE;
        String string;
        Editable text = t().f22822d.getText();
        if (text == null || (string = text.toString()) == null || (strE = ua.n.E(string, "-", "", false, 4, null)) == null) {
            strE = "";
        }
        if (!new ua.l("\\d{16}").d(strE)) {
            ToastUtils.t(getString(2131952220), new Object[0]);
            x1.f1.lb.config.c cVar = this.loading;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        if (this.isInRecharge.compareAndSet(false, true)) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(kotlinx.coroutines.a2.b(null, 1, null))), null, null, new a(strE, this, null), 3, null);
            return;
        }
        x1.f1.lb.config.c cVar2 = this.loading;
        if (cVar2 != null) {
            cVar2.a();
        }
        ToastUtils.s(2131952208);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z X(RenewActivity renewActivity) {
        ToastUtils.t(renewActivity.getString(2131952594), new Object[0]);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(RenewActivity renewActivity, View view) {
        renewActivity.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isPaused = true;
        if (this.toSetAccountInfo) {
            this.toSetAccountInfo = false;
            Z();
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.isPaused) {
            this.isPaused = false;
            b0(this, null, 1, null);
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        Spanned spannedFromHtml;
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        this.loading = z7.j.k(z7.j.f23105a, R$id.loading_layout, R$color.color_focused, t().getRoot(), 0, 8, null);
        t().f22820b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RenewActivity.V(this.f7989a, view);
            }
        });
        t().f22821c.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RenewActivity.W(this.f8130a, view);
            }
        });
        t().f22819a.f22835a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RenewActivity.Y(this.f8154a, view);
            }
        });
        t().f22819a.f22836b.setText(StubApp.getOrigApplicationContext(getApplicationContext()).getString(2131952175));
        t().f22822d.requestFocus();
        if (x1.f1.lb.config.b.f20643a.f()) {
            String string = getString(2131952789, "<a href=\"" + U() + "\">" + T() + "</a>");
            kotlin.jvm.internal.m.e(string, "getString(...)");
            TextView textView = t().f22825g;
            if (Build.VERSION.SDK_INT >= 24) {
                spannedFromHtml = Html.fromHtml(string, 0);
            } else {
                spannedFromHtml = Html.fromHtml(string);
            }
            textView.setText(spannedFromHtml);
        } else {
            t().f22824f.setText(ua.n.E(t().f22824f.getText().toString(), "2.", "", false, 4, null));
        }
        t().f22825g.setMovementMethod(LinkMovementMethod.getInstance());
        this.lastExpiredTs = t.v.c.i.a.f18646a.I();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_renew;
    }
}
