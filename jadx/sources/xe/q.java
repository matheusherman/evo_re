package xe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f22267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o f22268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f22269c = true;

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f22267a == qVar.f22267a && this.f22268b.equals(qVar.f22268b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f22267a.hashCode() + this.f22268b.f22254f.hashCode();
    }

    q(Object obj, o oVar) {
        this.f22267a = obj;
        this.f22268b = oVar;
    }
}
