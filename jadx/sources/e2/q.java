package e2;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class q implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f9843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9844b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9845c;

    @Override // e2.v
    public final void a(@NonNull g gVar) {
        synchronized (this.f9844b) {
            try {
                if (this.f9845c == null) {
                    return;
                }
                this.f9843a.execute(new p(this, gVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public q(@NonNull Executor executor, @NonNull c cVar) {
        this.f9843a = executor;
        this.f9845c = cVar;
    }
}
