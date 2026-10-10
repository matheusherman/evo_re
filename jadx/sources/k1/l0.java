package k1;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o0 f12043a;

    l0(o0 o0Var) {
        this.f12043a = o0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12043a.f12062g.b(new ConnectionResult(4));
    }
}
