package com.live.evo_mobile.ui.login;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/live/evo_mobile/ui/login/s0;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/q0;", "<init>", "()V", "", ExifInterface.LONGITUDE_WEST, "()I", "R", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "y", "e", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s0 extends com.tvc.lib.mobile.ui.base.d<z4.q0> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.s0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/login/s0$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/login/s0;", "a", "()Lcom/live/evo_mobile/ui/login/s0;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final s0 a() {
            return new s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(s0 s0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = s0Var.getActivity();
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
    public static final void g0(s0 s0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = s0Var.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(s0 s0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = s0Var.getActivity();
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
    public static final void i0(s0 s0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = s0Var.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.toScanLogin(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(s0 s0Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = s0Var.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.b0();
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        LoginTypeActivity loginTypeActivity;
        T().f22938i.setText("");
        T().f22931b.setVisibility(8);
        FragmentActivity activity = getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null && loginTypeActivity.T()) {
            T().f22932c.setVisibility(8);
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_login_type;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        T().f22932c.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.f0(this.f8083a, view);
            }
        });
        T().f22934e.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g0(this.f8085a, view);
            }
        });
        T().f22937h.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.h0(this.f8087a, view);
            }
        });
        T().f22931b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.i0(this.f8089a, view);
            }
        });
        T().f22933d.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.j0(this.f8091a, view);
            }
        });
    }
}
