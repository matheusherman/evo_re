package com.live.evo_mobile.ui.login;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$layout;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0007¢\u0006\u0004\b \u0010\u0004R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0014¨\u00063"}, d2 = {"Lcom/live/evo_mobile/ui/login/k0;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/k0;", "<init>", "()V", "", "tab", "Lr8/z;", "O0", "(Ljava/lang/Integer;)V", "W0", "X0", "V0", "(I)V", "P0", "R0", "M0", "N0", "", "str", "J", "(Ljava/lang/String;)V", "L0", ExifInterface.LONGITUDE_WEST, "()I", "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "T0", "U0", "y", "J0", "I0", "K0", "e", "I", "TAB_EMAIL", "f", "TAB_PHONE", "g", "currentTab", "", "h", "Z", "pwdShowForEmail", "i", "pwdShowForPhone", "", "j", "time", "k", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k0 extends com.tvc.lib.mobile.ui.base.d<z4.k0> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f8065l;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean pwdShowForEmail;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean pwdShowForPhone;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long time;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int TAB_PHONE = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int TAB_EMAIL;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int currentTab = this.TAB_EMAIL;

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.k0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lcom/live/evo_mobile/ui/login/k0$a;", "", "<init>", "()V", "", "isLoginFromStart", "Lcom/live/evo_mobile/ui/login/k0;", "a", "(Z)Lcom/live/evo_mobile/ui/login/k0;", "Z", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final k0 a(boolean isLoginFromStart) {
            k0.f8065l = isLoginFromStart;
            return new k0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/k0$b", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            k0.this.T().f22829d.f22707k.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !k0.this.T().f22829d.f22700d.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/k0$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            k0.this.T().f22829d.f22705i.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !k0.this.T().f22829d.f22703g.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/login/k0$d", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "p0", "Lr8/z;", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "onTabUnselected", "onTabReselected", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements TabLayout.OnTabSelectedListener {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab p10) {
            k0.this.O0(p10 != null ? Integer.valueOf(p10.getPosition()) : null);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab p10) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab p10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByEmail$1", f = "LoginAccountFragment.kt", l = {373}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $account;
        final /* synthetic */ String $password;
        int label;
        final /* synthetic */ k0 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByEmail$1$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ k0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k0 k0Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = k0Var;
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
                    this.this$0.L0(((Throwable) this.L$0).getMessage());
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k0 f8075a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByEmail$1$2$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ k0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, k0 k0Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = k0Var;
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
                            this.this$0.M0();
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.N0();
                            } else {
                                k0 k0Var = this.this$0;
                                String strF = this.$it.f();
                                k0Var.J(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(k0 k0Var) {
                this.f8075a = k0Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8075a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2, k0 k0Var, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$account = str;
            this.$password = str2;
            this.this$0 = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$account, this.$password, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.y0(this.$account, this.$password), new a(this.this$0, null));
                b bVar = new b(this.this$0);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByGuest$1", f = "LoginAccountFragment.kt", l = {324}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByGuest$1$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ k0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k0 k0Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = k0Var;
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
                    this.this$0.L0(((Throwable) this.L$0).getMessage());
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k0 f8076a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByGuest$1$2$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ k0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, k0 k0Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = k0Var;
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
                            this.this$0.M0();
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.N0();
                            } else {
                                k0 k0Var = this.this$0;
                                String strF = this.$it.f();
                                k0Var.J(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(k0 k0Var) {
                this.f8076a = k0Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8076a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return k0.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.z0(), new a(k0.this, null));
                b bVar = new b(k0.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByPhone$1", f = "LoginAccountFragment.kt", l = {TypedValues.CycleType.TYPE_WAVE_OFFSET, 426}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $contact;
        final /* synthetic */ com.live.evo_mobile.ui.login.c $countryCode;
        final /* synthetic */ String $password;
        int label;
        final /* synthetic */ k0 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByPhone$1$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ k0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k0 k0Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = k0Var;
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
                    this.this$0.L0(((Throwable) this.L$0).getMessage());
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k0 f8077a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.LoginAccountFragment$loginByPhone$1$2$1", f = "LoginAccountFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ k0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, k0 k0Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = k0Var;
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
                            this.this$0.M0();
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.N0();
                            } else {
                                k0 k0Var = this.this$0;
                                String strF = this.$it.f();
                                k0Var.J(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(k0 k0Var) {
                this.f8077a = k0Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8077a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, String str2, com.live.evo_mobile.ui.login.c cVar, k0 k0Var, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$contact = str;
            this.$password = str2;
            this.$countryCode = cVar;
            this.this$0 = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new g(this.$contact, this.$password, this.$countryCode, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L18;
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
            String str = this.$contact;
            String str2 = this.$password;
            String countryCode = this.$countryCode.getCountryCode();
            if (countryCode == null) {
                countryCode = "";
            }
            this.label = 1;
            obj = aVar.v0(str, str2, countryCode, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.this$0, null));
            b bVar = new b(this.this$0);
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(k0 k0Var, View view) {
        if (k0Var.pwdShowForEmail) {
            k0Var.T().f22829d.f22710n.setImageResource(R$drawable.pwd_invisible);
            k0Var.T().f22829d.f22700d.setInputType(129);
        } else {
            k0Var.T().f22829d.f22710n.setImageResource(R$drawable.pwd_visible);
            k0Var.T().f22829d.f22700d.setInputType(145);
        }
        k0Var.pwdShowForEmail = !k0Var.pwdShowForEmail;
        try {
            k0Var.T().f22829d.f22700d.setSelection(k0Var.T().f22829d.f22700d.getText().length());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(k0 k0Var, View view) {
        if (k0Var.pwdShowForPhone) {
            k0Var.T().f22829d.f22709m.setImageResource(R$drawable.pwd_invisible);
            k0Var.T().f22829d.f22703g.setInputType(129);
        } else {
            k0Var.T().f22829d.f22709m.setImageResource(R$drawable.pwd_visible);
            k0Var.T().f22829d.f22703g.setInputType(145);
        }
        k0Var.pwdShowForPhone = !k0Var.pwdShowForPhone;
        try {
            k0Var.T().f22829d.f22703g.setSelection(k0Var.T().f22829d.f22703g.getText().length());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(Integer tab) {
        int i10 = this.TAB_EMAIL;
        if (tab != null && tab.intValue() == i10) {
            W0();
        } else {
            X0();
        }
    }

    private final void P0() {
        String strI = t.v.c.i.a.f18646a.i();
        if (strI.length() <= 0) {
            T().f22829d.f22699c.requestFocus();
        } else {
            T().f22829d.f22699c.setText(strI);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.live.evo_mobile.ui.login.a0
                @Override // java.lang.Runnable
                public final void run() {
                    k0.Q0(this.f8007a);
                }
            });
        }
    }

    private final void R0() {
        String strI = t.v.c.i.a.f18646a.i();
        if (strI.length() > 0) {
            a.Companion companion = a.INSTANCE;
            if (companion.a().g(strI)) {
                T().f22829d.f22702f.setText(companion.a().d(strI));
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.live.evo_mobile.ui.login.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        k0.S0(this.f8125a);
                    }
                });
                return;
            }
        }
        T().f22829d.f22702f.requestFocus();
    }

    private final void W0() {
        this.currentTab = this.TAB_EMAIL;
        T().f22829d.f22698b.setVisibility(0);
        T().f22829d.f22714r.setVisibility(8);
        T().f22833h.setText(z7.p.b(2131951985));
    }

    private final void X0() {
        this.currentTab = this.TAB_PHONE;
        T().f22829d.f22698b.setVisibility(8);
        T().f22829d.f22714r.setVisibility(0);
        T().f22833h.setText(z7.p.b(2131952672));
    }

    public final void T0() {
        if (this.mDataBinding == 0) {
            this.currentTab = this.TAB_EMAIL;
        } else {
            V0(this.TAB_EMAIL);
            P0();
        }
    }

    public final void U0() {
        if (this.mDataBinding == 0) {
            this.currentTab = this.TAB_PHONE;
        } else {
            V0(this.TAB_PHONE);
            R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(k0 k0Var, View view, boolean z10) {
        k0Var.T().f22829d.f22715s.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    public static final void B0(k0 k0Var, View view, boolean z10) {
        int i10;
        ImageView imageView = k0Var.T().f22829d.f22707k;
        if (z10) {
            Editable text = k0Var.T().f22829d.f22700d.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        k0Var.T().f22829d.f22716t.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(k0 k0Var, View view) {
        k0Var.T().f22829d.f22700d.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(k0 k0Var, View view, boolean z10) {
        k0Var.T().f22829d.f22718v.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    public static final void F0(k0 k0Var, View view, boolean z10) {
        int i10;
        ImageView imageView = k0Var.T().f22829d.f22705i;
        if (z10) {
            Editable text = k0Var.T().f22829d.f22703g.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        k0Var.T().f22829d.f22719w.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(k0 k0Var, View view) {
        k0Var.T().f22829d.f22703g.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String str) {
        U();
        x1.f1.lb.util.g1.f21390a.c(z7.p.b(2131952336) + ": " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(String str) {
        U();
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952337);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        LoginTypeActivity loginTypeActivity;
        U();
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952343);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0() {
        U();
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952547);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(k0 k0Var) {
        k0Var.T().f22829d.f22700d.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(k0 k0Var) {
        k0Var.T().f22829d.f22703g.requestFocus();
    }

    private final void V0(int tab) {
        TabLayout tabLayout = T().f22829d.f22722z;
        kotlin.jvm.internal.m.e(tabLayout, "tabLayout");
        tabLayout.selectTab(tabLayout.getTabAt(tab));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(k0 k0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = k0Var.getActivity();
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
    public static final void w0(k0 k0Var, View view) {
        if (System.currentTimeMillis() - k0Var.time < 1000) {
            return;
        }
        k0Var.time = System.currentTimeMillis();
        if (k0Var.currentTab == k0Var.TAB_EMAIL) {
            k0Var.I0();
        } else {
            k0Var.K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(k0 k0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = k0Var.getActivity();
        String str = null;
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            String str2 = "";
            if (k0Var.currentTab == k0Var.TAB_EMAIL) {
                String string = k0Var.T().f22829d.f22699c.getText().toString();
                if (string.length() > 0) {
                    str = string;
                }
                if (str != null) {
                    str2 = str;
                }
                loginTypeActivity.e0(str2);
                return;
            }
            String strValueOf = String.valueOf(k0Var.T().f22829d.f22702f.getText());
            if (strValueOf.length() > 0) {
                str = strValueOf;
            }
            if (str == null) {
                str = "";
            }
            String phonePreCode = a.INSTANCE.a().c().get(k0Var.T().f22829d.f22721y.getSelectedItemPosition()).getPhonePreCode();
            if (phonePreCode != null) {
                str2 = phonePreCode;
            }
            loginTypeActivity.f0(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(k0 k0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = k0Var.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.toCreateAccount(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(k0 k0Var, View view) {
        if (System.currentTimeMillis() - k0Var.time < 1000) {
            return;
        }
        k0Var.time = System.currentTimeMillis();
        k0Var.J0();
    }

    public final void I0() {
        String string = ua.n.Q0(T().f22829d.f22699c.getText().toString()).toString();
        String string2 = ua.n.Q0(T().f22829d.f22700d.getText().toString()).toString();
        if (TextUtils.isEmpty(string)) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strB = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB, "getString(...)");
            g1Var.c(strB);
            T().f22829d.f22699c.requestFocus();
            return;
        }
        if (!a.INSTANCE.a().f(string)) {
            x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
            String strB2 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB2, "getString(...)");
            g1Var2.c(strB2);
            T().f22829d.f22699c.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
            String strB3 = z7.p.b(2131952752);
            kotlin.jvm.internal.m.e(strB3, "getString(...)");
            g1Var3.c(strB3);
            T().f22829d.f22700d.requestFocus();
            return;
        }
        int length = string2.length();
        if (6 <= length && length < 17) {
            Z();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new e(string, string2, this, null), 3, null);
            return;
        }
        x1.f1.lb.util.g1 g1Var4 = x1.f1.lb.util.g1.f21390a;
        String strB4 = z7.p.b(2131952758);
        kotlin.jvm.internal.m.e(strB4, "getString(...)");
        g1Var4.c(strB4);
        T().f22829d.f22700d.requestFocus();
    }

    public final void J0() {
        Z();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new f(null), 3, null);
    }

    public final void K0() {
        String string = ua.n.Q0(String.valueOf(T().f22829d.f22702f.getText())).toString();
        String string2 = ua.n.Q0(T().f22829d.f22703g.getText().toString()).toString();
        if (TextUtils.isEmpty(string)) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strB = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB, "getString(...)");
            g1Var.c(strB);
            T().f22829d.f22702f.requestFocus();
            return;
        }
        a.Companion companion = a.INSTANCE;
        com.live.evo_mobile.ui.login.c cVar = companion.a().c().get(T().f22829d.f22721y.getSelectedItemPosition());
        String str = cVar.getPhonePreCode() + string;
        if (!companion.a().g(str)) {
            x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
            String strB2 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB2, "getString(...)");
            g1Var2.c(strB2);
            T().f22829d.f22702f.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
            String strB3 = z7.p.b(2131952752);
            kotlin.jvm.internal.m.e(strB3, "getString(...)");
            g1Var3.c(strB3);
            T().f22829d.f22703g.requestFocus();
            return;
        }
        int length = string2.length();
        if (6 <= length && length < 17) {
            Z();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new g(str, string2, cVar, this, null), 3, null);
            return;
        }
        x1.f1.lb.util.g1 g1Var4 = x1.f1.lb.util.g1.f21390a;
        String strB4 = z7.p.b(2131952758);
        kotlin.jvm.internal.m.e(strB4, "getString(...)");
        g1Var4.c(strB4);
        T().f22829d.f22703g.requestFocus();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        T().f22831f.getPaint().setUnderlineText(true);
        T().f22829d.f22721y.setAdapter((SpinnerAdapter) new com.live.evo_mobile.ui.login.b(S(), a.INSTANCE.a().c()));
        TabLayout tabLayout = T().f22829d.f22722z;
        kotlin.jvm.internal.m.e(tabLayout, "tabLayout");
        tabLayout.removeAllTabs();
        tabLayout.setTabTextColors(getResources().getColor(R$color.text_color_normal), getResources().getColor(R$color.color_focused));
        tabLayout.setBackgroundColor(0);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R$color.color_focused));
        tabLayout.addTab(tabLayout.newTab().setText(2131951694));
        tabLayout.addTab(tabLayout.newTab().setText(2131951695));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        T().f22829d.f22711o.setVisibility(8);
        T().f22829d.f22712p.setVisibility(8);
        tabLayout.selectTab(tabLayout.getTabAt(this.currentTab));
        O0(Integer.valueOf(this.currentTab));
        if (this.currentTab == this.TAB_EMAIL) {
            P0();
        } else {
            R0();
        }
        if (f8065l) {
            T().f22828c.setVisibility(8);
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_login_account;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        T().f22829d.f22699c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.v
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                k0.A0(this.f8117a, view, z10);
            }
        });
        T().f22829d.f22700d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.e0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                k0.B0(this.f8027a, view, z10);
            }
        });
        T().f22829d.f22700d.addTextChangedListener(new b());
        T().f22829d.f22707k.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.C0(this.f8030a, view);
            }
        });
        T().f22829d.f22710n.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.D0(this.f8033a, view);
            }
        });
        T().f22829d.f22702f.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.h0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                k0.E0(this.f8058a, view, z10);
            }
        });
        T().f22829d.f22703g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.i0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                k0.F0(this.f8060a, view, z10);
            }
        });
        T().f22829d.f22703g.addTextChangedListener(new c());
        T().f22829d.f22705i.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.G0(this.f8062a, view);
            }
        });
        T().f22829d.f22709m.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.H0(this.f8119a, view);
            }
        });
        T().f22828c.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.v0(this.f8121a, view);
            }
        });
        T().f22826a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.w0(this.f8123a, view);
            }
        });
        T().f22831f.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.x0(this.f8014a, view);
            }
        });
        T().f22832g.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.y0(this.f8021a, view);
            }
        });
        T().f22827b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.z0(this.f8024a, view);
            }
        });
    }
}
