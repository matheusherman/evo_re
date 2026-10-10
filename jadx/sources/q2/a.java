package q2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f17617b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f17616a.equals(rVar.c()) && this.f17617b.equals(rVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // q2.r
    public List<String> b() {
        return this.f17617b;
    }

    @Override // q2.r
    public String c() {
        return this.f17616a;
    }

    public int hashCode() {
        return ((this.f17616a.hashCode() ^ 1000003) * 1000003) ^ this.f17617b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f17616a + ", usedDates=" + this.f17617b + "}";
    }

    a(String str, List<String> list) {
        if (str != null) {
            this.f17616a = str;
            if (list != null) {
                this.f17617b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }
}
