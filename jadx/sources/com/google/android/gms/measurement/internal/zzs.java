package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.ef;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzs extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6 f4348a;

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.f4348a.l().M().a("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.f4348a.l().M().a("App receiver called with null action");
            return;
        }
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final s6 s6Var = this.f4348a;
            if (ef.a() && s6Var.B().K(null, g0.W0)) {
                s6Var.l().L().a("App receiver notified triggers are available");
                s6Var.a().E(new Runnable() { // from class: com.google.android.gms.measurement.internal.yc
                    @Override // java.lang.Runnable
                    public final void run() {
                        s6 s6Var2 = s6Var;
                        if (!s6Var2.P().W0()) {
                            s6Var2.l().M().a("registerTrigger called but app not eligible");
                            return;
                        }
                        s6Var2.J().I0();
                        final z7 z7VarJ = s6Var2.J();
                        Objects.requireNonNull(z7VarJ);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.xc
                            @Override // java.lang.Runnable
                            public final void run() {
                                z7VarJ.K0();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        if (!action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
            this.f4348a.l().M().a("App receiver called with unknown action");
        } else if (this.f4348a.B().K(null, g0.R0)) {
            this.f4348a.l().L().a("[sgtm] App Receiver notified batches are available");
            this.f4348a.a().E(new Runnable() { // from class: b2.v1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f732a.f4348a.L().D(com.google.android.gms.measurement.internal.g0.D.a(null).longValue());
                }
            });
        }
    }

    public zzs(s6 s6Var) {
        this.f4348a = s6Var;
    }
}
