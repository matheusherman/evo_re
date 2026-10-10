package e2;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class o implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f9838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9839b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f9840c;

    public o(@NonNull Executor executor, @NonNull b bVar) {
        this.f9838a = executor;
        this.f9840c = bVar;
    }

    @Override // e2.v
    public final void a(@NonNull g gVar) {
        if (gVar.i()) {
            synchronized (this.f9839b) {
                try {
                    if (this.f9840c == null) {
                        return;
                    }
                    this.f9838a.execute(new n(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
