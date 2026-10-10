package e2;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f9848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9849b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f9850c;

    public s(@NonNull Executor executor, @NonNull d dVar) {
        this.f9848a = executor;
        this.f9850c = dVar;
    }

    @Override // e2.v
    public final void a(@NonNull g gVar) {
        if (!gVar.k() && !gVar.i()) {
            synchronized (this.f9849b) {
                try {
                    if (this.f9850c == null) {
                        return;
                    }
                    this.f9848a.execute(new r(this, gVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
