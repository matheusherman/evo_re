package e2;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9856a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue f9857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9858c;

    public final void a(@NonNull v vVar) {
        synchronized (this.f9856a) {
            try {
                if (this.f9857b == null) {
                    this.f9857b = new ArrayDeque();
                }
                this.f9857b.add(vVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(@NonNull g gVar) {
        v vVar;
        synchronized (this.f9856a) {
            if (this.f9857b != null && !this.f9858c) {
                this.f9858c = true;
                while (true) {
                    synchronized (this.f9856a) {
                        try {
                            vVar = (v) this.f9857b.poll();
                            if (vVar == null) {
                                this.f9858c = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    vVar.a(gVar);
                }
            }
        }
    }

    w() {
    }
}
