package j2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f11542c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f11540a == mVar.c() && this.f11541b == mVar.b() && this.f11542c == mVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // j2.m
    public long b() {
        return this.f11541b;
    }

    @Override // j2.m
    public long c() {
        return this.f11540a;
    }

    @Override // j2.m
    public long d() {
        return this.f11542c;
    }

    public int hashCode() {
        long j10 = this.f11540a;
        long j11 = this.f11541b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f11542c;
        return ((int) (j12 ^ (j12 >>> 32))) ^ i10;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f11540a + ", elapsedRealtime=" + this.f11541b + ", uptimeMillis=" + this.f11542c + "}";
    }

    a(long j10, long j11, long j12) {
        this.f11540a = j10;
        this.f11541b = j11;
        this.f11542c = j12;
    }
}
