package k1;

import android.app.Dialog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class x0 extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Dialog f12090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ y0 f12091b;

    x0(y0 y0Var, Dialog dialog) {
        this.f12091b = y0Var;
        this.f12090a = dialog;
    }

    @Override // k1.f0
    public final void a() {
        this.f12091b.f12094b.o();
        if (this.f12090a.isShowing()) {
            this.f12090a.dismiss();
        }
    }
}
