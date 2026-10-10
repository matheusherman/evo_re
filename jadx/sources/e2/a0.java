package e2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Callable f9832b;

    a0(z zVar, Callable callable) {
        this.f9831a = zVar;
        this.f9832b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f9831a.m(this.f9832b.call());
        } catch (Exception e10) {
            this.f9831a.l(e10);
        } catch (Throwable th) {
            this.f9831a.l(new RuntimeException(th));
        }
    }
}
