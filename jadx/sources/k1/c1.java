package k1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f11992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f11993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d1 f11994c;

    c1(d1 d1Var, g gVar, String str) {
        this.f11992a = gVar;
        this.f11993b = str;
        this.f11994c = d1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        d1 d1Var = this.f11994c;
        if (d1Var.f12002b > 0) {
            g gVar = this.f11992a;
            if (d1Var.f12003c != null) {
                bundle = d1Var.f12003c.getBundle(this.f11993b);
            } else {
                bundle = null;
            }
            gVar.f(bundle);
        }
        if (this.f11994c.f12002b >= 2) {
            this.f11992a.j();
        }
        if (this.f11994c.f12002b >= 3) {
            this.f11992a.h();
        }
        if (this.f11994c.f12002b >= 4) {
            this.f11992a.k();
        }
        if (this.f11994c.f12002b >= 5) {
            this.f11992a.g();
        }
    }
}
