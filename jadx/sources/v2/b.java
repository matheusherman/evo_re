package v2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.b f19514c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: v2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0372b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f19515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f19516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f.b f19517c;

        @Override // v2.f.a
        public f a() {
            String str = "";
            if (this.f19516b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f19515a, this.f19516b.longValue(), this.f19517c, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.f.a
        public f.a b(f.b bVar) {
            this.f19517c = bVar;
            return this;
        }

        @Override // v2.f.a
        public f.a c(String str) {
            this.f19515a = str;
            return this;
        }

        C0372b() {
        }

        @Override // v2.f.a
        public f.a d(long j10) {
            this.f19516b = Long.valueOf(j10);
            return this;
        }
    }

    /* synthetic */ b(String str, long j10, f.b bVar, a aVar) {
        this(str, j10, bVar);
    }

    public boolean equals(Object obj) {
        f.b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String str = this.f19512a;
            if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
                if (this.f19513b == fVar.d() && ((bVar = this.f19514c) != null ? bVar.equals(fVar.b()) : fVar.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private b(@Nullable String str, long j10, @Nullable f.b bVar) {
        this.f19512a = str;
        this.f19513b = j10;
        this.f19514c = bVar;
    }

    @Override // v2.f
    @Nullable
    public f.b b() {
        return this.f19514c;
    }

    @Override // v2.f
    @Nullable
    public String c() {
        return this.f19512a;
    }

    @Override // v2.f
    @NonNull
    public long d() {
        return this.f19513b;
    }

    public int hashCode() {
        String str = this.f19512a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f19513b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        f.b bVar = this.f19514c;
        return i10 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f19512a + ", tokenExpirationTimestamp=" + this.f19513b + ", responseCode=" + this.f19514c + "}";
    }
}
