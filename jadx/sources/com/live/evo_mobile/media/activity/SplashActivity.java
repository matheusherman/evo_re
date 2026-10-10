package com.live.evo_mobile.media.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import c9.p;
import c9.q;
import com.live.evo.R$id;
import com.live.evo.R$string;
import com.live.evo.util.s0;
import com.live.evo_mobile.ui.MainViewActivity;
import com.live.evo_mobile.ui.login.LoginTypeActivity;
import com.stub.StubApp;
import com.tvc.lib.mobile.activity.BaseActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v0;
import nf.s;
import org.greenrobot.eventbus.ThreadMode;
import r8.r;
import r8.u;
import r8.z;
import s7.AdItem;
import t.v.c.widget.ImageView;
import t.v.c.widget.TextView;
import u5.i;
import x1.f1.lb.util.g1;
import x1.f1.lb.util.n0;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J%\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0014¢\u0006\u0004\b)\u0010\u0003J\u0019\u0010+\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b+\u0010,R\u001f\u00101\u001a\n -*\u0004\u0018\u00010\u00110\u00118\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u001bR\u0018\u00104\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/live/evo_mobile/media/activity/SplashActivity;", "Lcom/tvc/lib/mobile/activity/BaseActivity;", "<init>", "()V", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "L", "", "Ls7/a;", "adsItems", "Lt/v/c/widget/ImageView;", "adImageView", "F", "(Ljava/util/List;Lt/v/c/widget/ImageView;)V", "O", "N", "(Lv8/f;)Ljava/lang/Object;", "", NotificationCompat.CATEGORY_MESSAGE, "Q", "(Ljava/lang/String;)V", "P", "Landroid/content/Context;", "context", "M", "(Landroid/content/Context;Lv8/f;)Ljava/lang/Object;", "J", "()Ljava/lang/String;", "K", "", "txtResId", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/Integer;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lnf/i;", NotificationCompat.CATEGORY_EVENT, "onEvent", "(Lnf/i;)V", "onDestroy", "Lnf/s;", "OnEvent", "(Lnf/s;)V", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "getTAG", "TAG", "e", "Lnf/s;", "lastEvent", "Lt/v/c/widget/TextView;", "f", "Lt/v/c/widget/TextView;", "countdownView", "Lx1/f1/lb/config/c;", "g", "Lx1/f1/lb/config/c;", "iLoading", "h", "I", "adIndex", "", "i", "Z", "isAdComplete", "Lv7/c;", "j", "Lv7/c;", "getRetryDialog", "()Lv7/c;", "setRetryDialog", "(Lv7/c;)V", "retryDialog", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
public final class SplashActivity extends BaseActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private s lastEvent;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView countdownView;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.config.c iLoading;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int adIndex;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private v7.c retryDialog;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = SplashActivity.class.getSimpleName();

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAdComplete = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$hideLoading$2", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        a(v8.f<? super a> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                x1.f1.lb.config.c cVar = SplashActivity.this.iLoading;
                if (cVar != null) {
                    cVar.a();
                    return z.f17874a;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$initAd$1", f = "SplashActivity.kt", l = {159, 195}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$initAd$1$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ SplashActivity this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.media.activity.SplashActivity$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/media/activity/SplashActivity$b$a$a", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class C0120a implements w0.a<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ SplashActivity f7795a;

                /* JADX INFO: renamed from: com.live.evo_mobile.media.activity.SplashActivity$b$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$initAd$1$1$1$onValue$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
                static final class C0121a extends l implements p<l0, v8.f<? super z>, Object> {
                    final /* synthetic */ String $value;
                    int label;
                    final /* synthetic */ SplashActivity this$0;

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void c(ImageView imageView, SplashActivity splashActivity, View view) {
                        imageView.setClickable(false);
                        splashActivity.isAdComplete = true;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0121a(String str, SplashActivity splashActivity, v8.f<? super C0121a> fVar) {
                        super(2, fVar);
                        this.$value = str;
                        this.this$0 = splashActivity;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                        return new C0121a(this.$value, this.this$0, fVar);
                    }

                    @Override // c9.p
                    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                        return ((C0121a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        List<AdItem> listL;
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r.b(obj);
                            if (this.$value.length() == 0) {
                                this.this$0.O();
                                return z.f17874a;
                            }
                            try {
                                listL = z7.a.INSTANCE.b(this.$value);
                            } catch (Exception e10) {
                                this.this$0.getLogger().error("Error getting startup ad: " + e10.getMessage(), e10);
                                listL = kotlin.collections.r.l();
                            }
                            if (!listL.isEmpty()) {
                                final ImageView imageView = (ImageView) this.this$0.findViewById(R$id.adImageView);
                                TextView textView = this.this$0.countdownView;
                                if (textView == null) {
                                    m.v("countdownView");
                                    textView = null;
                                }
                                textView.setVisibility(0);
                                this.this$0.isAdComplete = false;
                                SplashActivity splashActivity = this.this$0;
                                m.c(imageView);
                                splashActivity.F(listL, imageView);
                                final SplashActivity splashActivity2 = this.this$0;
                                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.media.activity.f
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        SplashActivity.b.a.C0120a.C0121a.c(imageView, splashActivity2, view);
                                    }
                                });
                            }
                            this.this$0.O();
                            return z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                C0120a(SplashActivity splashActivity) {
                    this.f7795a = splashActivity;
                }

                @Override // x1.f1.lb.util.w0.a
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(String value) {
                    m.f(value, "value");
                    j.d(m0.a(a1.c()), null, null, new C0121a(value, this.f7795a, null), 3, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SplashActivity splashActivity, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = splashActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    w0.p(w0.f21452a, "startup_ad_list", new C0120a(this.this$0), null, 4, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo_mobile.media.activity.SplashActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$initAd$1$2", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0122b extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ SplashActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0122b(SplashActivity splashActivity, v8.f<? super C0122b> fVar) {
                super(2, fVar);
                this.this$0 = splashActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0122b(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0122b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.this$0.O();
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(v8.f<? super b> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new b(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        
            if (kotlinx.coroutines.h.g(r9, r1, r8) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        
            if (kotlinx.coroutines.h.g(r9, r1, r8) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
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
                    return z.f17874a;
                }
                r.b(obj);
                g2 g2VarC = a1.c();
                a aVar = new a(SplashActivity.this, null);
                this.label = 1;
            } catch (Exception e10) {
                SplashActivity.this.getLogger().error("Error initializing ad: " + e10.getMessage(), e10);
                g2 g2VarC2 = a1.c();
                C0122b c0122b = new C0122b(SplashActivity.this, null);
                this.label = 2;
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity", f = "SplashActivity.kt", l = {265, 267, 277}, m = "launchMainActivity")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplashActivity.this.N(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$launchMainActivity$2", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        d(v8.f<? super d> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new d(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) MainViewActivity.class));
                SplashActivity.this.finish();
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$loginFlow$1", f = "SplashActivity.kt", l = {241}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$loginFlow$1$1", f = "SplashActivity.kt", l = {238}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SplashActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SplashActivity splashActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = splashActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
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
                    SplashActivity splashActivity = this.this$0;
                    this.L$0 = th2;
                    this.label = 1;
                    if (splashActivity.K(this) == objC) {
                        return objC;
                    }
                    th = th2;
                }
                this.this$0.getLogger().error("loginFlow error", th);
                SplashActivity splashActivity2 = this.this$0;
                String message = th.getMessage();
                if (message == null) {
                    message = this.this$0.getString(2131953089);
                    m.e(message, "getString(...)");
                }
                splashActivity2.P(message);
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SplashActivity f7796a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$loginFlow$1$2", f = "SplashActivity.kt", l = {242, 245, 248}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(b<? super T> bVar, v8.f<? super a> fVar) {
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

            b(SplashActivity splashActivity) {
                this.f7796a = splashActivity;
            }

            /* JADX WARN: Code duplicated, block: B:27:0x0074  */
            /* JADX WARN: Code duplicated, block: B:45:0x0091 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:25:0x006b->B:47:?, LOOP_END, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
            
                if (r8.N(r0) == r1) goto L32;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                a aVar;
                b<T> bVar;
                b<T> bVar2;
                if (fVar instanceof a) {
                    aVar = (a) fVar;
                    int i10 = aVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        aVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(this, fVar);
                    }
                } else {
                    aVar = new a(this, fVar);
                }
                Object obj = aVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = aVar.label;
                if (i11 == 0) {
                    r.b(obj);
                    SplashActivity splashActivity = this.f7796a;
                    aVar.L$0 = this;
                    aVar.L$1 = uVar;
                    aVar.label = 1;
                    if (splashActivity.K(aVar) != objC) {
                        bVar = this;
                    }
                    return objC;
                }
                if (i11 == 1) {
                    uVar = (u) aVar.L$1;
                    bVar = (b) aVar.L$0;
                    r.b(obj);
                } else if (i11 == 2) {
                    bVar2 = (b) aVar.L$0;
                    r.b(obj);
                    while (!bVar2.f7796a.isAdComplete) {
                        aVar.L$0 = bVar2;
                        aVar.L$1 = null;
                        aVar.label = 2;
                        if (v0.a(200L, aVar) == objC) {
                            return objC;
                        }
                    }
                    SplashActivity splashActivity2 = bVar2.f7796a;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.label = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r.b(obj);
                }
                return z.f17874a;
                if (!uVar.d().booleanValue()) {
                    Integer numE = uVar.e();
                    if (numE != null && numE.intValue() == -3) {
                        SplashActivity splashActivity3 = bVar.f7796a;
                        String string = splashActivity3.getString(2131952547);
                        m.e(string, "getString(...)");
                        splashActivity3.Q(string);
                    } else {
                        bVar.f7796a.V();
                        bVar.f7796a.getLogger().error("loginFlow error:{}", uVar);
                    }
                    return z.f17874a;
                }
                bVar2 = bVar;
                while (!bVar2.f7796a.isAdComplete) {
                    aVar.L$0 = bVar2;
                    aVar.L$1 = null;
                    aVar.label = 2;
                    if (v0.a(200L, aVar) == objC) {
                        return objC;
                    }
                }
                SplashActivity splashActivity4 = bVar2.f7796a;
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 3;
            }
        }

        e(v8.f<? super e> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new e(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(kotlinx.coroutines.flow.h.y(t.v.c.i.a.f18646a.x0(), a1.b()), new a(SplashActivity.this, null));
                b bVar = new b(SplashActivity.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$onCreate$1", f = "SplashActivity.kt", l = {104, 105}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$onCreate$1$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ SplashActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SplashActivity splashActivity, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = splashActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    TextView textView = (TextView) this.this$0.findViewById(R$id.versionTextView);
                    if (z7.b.f23095a.b(false)) {
                        textView.setText(this.this$0.getString(R$string.version) + ": " + this.this$0.J());
                        this.this$0.L();
                    } else {
                        textView.setText(this.this$0.getText(2131952911));
                    }
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        
            if (kotlinx.coroutines.h.g(r6, r1, r5) == r0) goto L15;
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
                x1.f1.lb.util.a1.f21305a.f("SplashActivity onCreate end");
                return z.f17874a;
            }
            r.b(obj);
            Context origApplicationContext = StubApp.getOrigApplicationContext(SplashActivity.this.getApplicationContext());
            m.e(origApplicationContext, "getApplicationContext(...)");
            n0.r(origApplicationContext, null, 2, null);
            SplashActivity splashActivity = SplashActivity.this;
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(splashActivity.getApplicationContext());
            this.label = 1;
            if (splashActivity.M(origApplicationContext2, this) != objC) {
            }
            return objC;
            g2 g2VarC = a1.c();
            a aVar = new a(SplashActivity.this, null);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/media/activity/SplashActivity$g", "Lv7/c$a;", "Lr8/z;", "onCancel", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements v7.c.a {
        g() {
        }

        @Override // v7.c.a
        public void onCancel() {
            SplashActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$showLogin$1", f = "SplashActivity.kt", l = {144}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.media.activity.SplashActivity$showLogin$1$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ SplashActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SplashActivity splashActivity, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = splashActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    Intent intent = new Intent(this.this$0, (Class<?>) LoginTypeActivity.class);
                    intent.putExtra("loginFrom", 0);
                    this.this$0.startActivity(intent);
                    this.this$0.finish();
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        h(v8.f<? super h> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return SplashActivity.this.new h(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                g2 g2VarC = a1.c();
                a aVar = new a(SplashActivity.this, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    static {
        StubApp.interface11(12814);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        T(this, null, 1, null);
        j.d(m0.a(a1.b()), null, null, new e(null), 3, null);
    }

    @Override // com.tvc.lib.mobile.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final List<AdItem> adsItems, final ImageView adImageView) {
        if (this.isAdComplete) {
            return;
        }
        if (this.adIndex >= adsItems.size()) {
            this.isAdComplete = true;
            return;
        }
        try {
            int i10 = this.adIndex;
            this.adIndex = i10 + 1;
            AdItem adItem = adsItems.get(i10);
            com.bumptech.glide.c.u(this).u(adItem.getSource()).E0(adImageView);
            com.tvc.lib.mobile.ext.a.d(this, 2131102158, null, 2, null);
            com.tvc.lib.mobile.ext.a.a(this, adItem.getDuration(), new c9.l() { // from class: com.live.evo_mobile.media.activity.c
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return SplashActivity.G((l0) obj);
                }
            }, new c9.l() { // from class: com.live.evo_mobile.media.activity.d
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return SplashActivity.H(this.f7801a, ((Integer) obj).intValue());
                }
            }, new c9.a() { // from class: com.live.evo_mobile.media.activity.e
                @Override // c9.a
                public final Object invoke() {
                    return SplashActivity.I(this.f7802a, adsItems, adImageView);
                }
            });
        } catch (Exception e10) {
            getLogger().error("Error loading ad image: " + e10.getMessage(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z G(l0 it) {
        m.f(it, "it");
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z H(SplashActivity splashActivity, int i10) {
        if (i10 > 0) {
            TextView textView = splashActivity.countdownView;
            if (textView == null) {
                m.v("countdownView");
                textView = null;
            }
            textView.setText(splashActivity.getString(2131951938, Integer.valueOf(i10)));
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M(Context context, v8.f<? super z> fVar) {
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[LOOP:0: B:21:0x0063->B:38:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        if (kotlinx.coroutines.h.g(r10, r3, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object N(v8.f<? super z> fVar) {
        c cVar;
        SplashActivity splashActivity;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(fVar);
            }
        } else {
            cVar = new c(fVar);
        }
        Object obj = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        if (i11 == 0) {
            r.b(obj);
            if (t.v.c.i.a.o(t.v.c.i.a.f18646a, null, null, 3, null).isEmpty()) {
                S(kotlin.coroutines.jvm.internal.b.b(2131952318));
                splashActivity = this;
                while (t.v.c.i.a.o(t.v.c.i.a.f18646a, null, null, 3, null).isEmpty()) {
                    cVar.L$0 = splashActivity;
                    cVar.label = 1;
                    if (v0.a(500L, cVar) == objC) {
                        return objC;
                    }
                }
                cVar.L$0 = splashActivity;
                cVar.label = 2;
                if (splashActivity.K(cVar) != objC) {
                }
                return objC;
            }
            splashActivity = this;
            s0.f7342a.Q();
            t.v.c.i.a.f18646a.I0();
            i.INSTANCE.b(false);
            g2 g2VarC = a1.c();
            d dVar = splashActivity.new d(null);
            cVar.L$0 = null;
            cVar.label = 3;
        } else {
            if (i11 == 1) {
                splashActivity = (SplashActivity) cVar.L$0;
                r.b(obj);
                while (t.v.c.i.a.o(t.v.c.i.a.f18646a, null, null, 3, null).isEmpty()) {
                    cVar.L$0 = splashActivity;
                    cVar.label = 1;
                    if (v0.a(500L, cVar) == objC) {
                        return objC;
                    }
                }
                cVar.L$0 = splashActivity;
                cVar.label = 2;
                if (splashActivity.K(cVar) != objC) {
                    s0.f7342a.Q();
                    t.v.c.i.a.f18646a.I0();
                    i.INSTANCE.b(false);
                    g2 g2VarC2 = a1.c();
                    d dVar2 = splashActivity.new d(null);
                    cVar.L$0 = null;
                    cVar.label = 3;
                }
                return objC;
            }
            if (i11 == 2) {
                splashActivity = (SplashActivity) cVar.L$0;
                r.b(obj);
                s0.f7342a.Q();
                t.v.c.i.a.f18646a.I0();
                i.INSTANCE.b(false);
                g2 g2VarC3 = a1.c();
                d dVar3 = splashActivity.new d(null);
                cVar.L$0 = null;
                cVar.label = 3;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(String msg) {
        g1.f21390a.c(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String msg) {
        if (this.retryDialog != null) {
            return;
        }
        v7.c cVar = new v7.c(msg, new c9.a() { // from class: com.live.evo_mobile.media.activity.a
            @Override // c9.a
            public final Object invoke() {
                return SplashActivity.R(this.f7798a);
            }
        });
        this.retryDialog = cVar;
        v7.c.h0(cVar, new g(), false, 2, null);
        v7.c cVar2 = this.retryDialog;
        if (cVar2 != null) {
            String string = getString(2131951817);
            m.e(string, "getString(...)");
            cVar2.e0(string);
        }
        v7.c cVar3 = this.retryDialog;
        if (cVar3 != null) {
            String string2 = getString(2131952019);
            m.e(string2, "getString(...)");
            cVar3.d0(string2);
        }
        v7.c cVar4 = this.retryDialog;
        if (cVar4 != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            m.e(supportFragmentManager, "getSupportFragmentManager(...)");
            cVar4.X(supportFragmentManager);
        }
    }

    private final void S(Integer txtResId) {
        if (txtResId != null) {
            final int iIntValue = txtResId.intValue();
            runOnUiThread(new Runnable() { // from class: com.live.evo_mobile.media.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity.U(this.f7799a, iIntValue);
                }
            });
        }
        x1.f1.lb.config.c cVar = this.iLoading;
        if (cVar != null) {
            cVar.b();
        }
    }

    static /* synthetic */ void T(SplashActivity splashActivity, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        splashActivity.S(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(SplashActivity splashActivity, int i10) {
        x1.f1.lb.config.c cVar = splashActivity.iLoading;
        if (cVar != null) {
            String string = splashActivity.getString(i10);
            m.e(string, "getString(...)");
            cVar.c(string);
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(s event) {
        this.lastEvent = event;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.i event) {
        x1.f1.lb.util.a1.f21305a.f("MainActivity is Ready");
        s sVar = this.lastEvent;
        if (sVar != null) {
            xe.c.c().o(sVar);
        }
        xe.c.c().s(event);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z I(SplashActivity splashActivity, List list, ImageView imageView) {
        splashActivity.F(list, imageView);
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J() {
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return "N/A";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object K(v8.f<? super z> fVar) {
        return kotlinx.coroutines.h.g(a1.c(), new a(null), fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        j.d(m0.a(a1.b()), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z R(SplashActivity splashActivity) {
        splashActivity.O();
        splashActivity.retryDialog = null;
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        j.d(m0.a(a1.b()), null, null, new h(null), 3, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        xe.c.c().u(this);
    }
}
