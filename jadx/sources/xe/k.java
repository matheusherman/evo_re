package xe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f22243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f22244b;

    synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            j jVar2 = this.f22244b;
            if (jVar2 != null) {
                jVar2.f22242c = jVar;
                this.f22244b = jVar;
            } else {
                if (this.f22243a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f22244b = jVar;
                this.f22243a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized j b() {
        j jVar;
        jVar = this.f22243a;
        if (jVar != null) {
            j jVar2 = jVar.f22242c;
            this.f22243a = jVar2;
            if (jVar2 == null) {
                this.f22244b = null;
            }
        }
        return jVar;
    }

    synchronized j c(int i10) {
        try {
            if (this.f22243a == null) {
                wait(i10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }

    k() {
    }
}
