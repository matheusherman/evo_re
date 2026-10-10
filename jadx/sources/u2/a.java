package u2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.a f19316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19321h;

    /* JADX INFO: renamed from: u2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0369a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f19322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c.a f19323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f19325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f19326e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f19327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f19328g;

        /* synthetic */ b(d dVar, C0369a c0369a) {
            this(dVar);
        }

        b() {
        }

        @Override // u2.d.a
        public d a() {
            String str = "";
            if (this.f19323b == null) {
                str = " registrationStatus";
            }
            if (this.f19326e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f19327f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f19322a, this.f19323b, this.f19324c, this.f19325d, this.f19326e.longValue(), this.f19327f.longValue(), this.f19328g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.d.a
        public d.a b(@Nullable String str) {
            this.f19324c = str;
            return this;
        }

        @Override // u2.d.a
        public d.a d(String str) {
            this.f19322a = str;
            return this;
        }

        @Override // u2.d.a
        public d.a e(@Nullable String str) {
            this.f19328g = str;
            return this;
        }

        @Override // u2.d.a
        public d.a f(@Nullable String str) {
            this.f19325d = str;
            return this;
        }

        @Override // u2.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f19323b = aVar;
            return this;
        }

        private b(d dVar) {
            this.f19322a = dVar.d();
            this.f19323b = dVar.g();
            this.f19324c = dVar.b();
            this.f19325d = dVar.f();
            this.f19326e = Long.valueOf(dVar.c());
            this.f19327f = Long.valueOf(dVar.h());
            this.f19328g = dVar.e();
        }

        @Override // u2.d.a
        public d.a c(long j10) {
            this.f19326e = Long.valueOf(j10);
            return this;
        }

        @Override // u2.d.a
        public d.a h(long j10) {
            this.f19327f = Long.valueOf(j10);
            return this;
        }
    }

    /* synthetic */ a(String str, c.a aVar, String str2, String str3, long j10, long j11, String str4, C0369a c0369a) {
        this(str, aVar, str2, str3, j10, j11, str4);
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str4 = this.f19315b;
            if (str4 != null ? str4.equals(dVar.d()) : dVar.d() == null) {
                if (this.f19316c.equals(dVar.g()) && ((str = this.f19317d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f19318e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f19319f == dVar.c() && this.f19320g == dVar.h() && ((str3 = this.f19321h) != null ? str3.equals(dVar.e()) : dVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private a(@Nullable String str, c.a aVar, @Nullable String str2, @Nullable String str3, long j10, long j11, @Nullable String str4) {
        this.f19315b = str;
        this.f19316c = aVar;
        this.f19317d = str2;
        this.f19318e = str3;
        this.f19319f = j10;
        this.f19320g = j11;
        this.f19321h = str4;
    }

    @Override // u2.d
    @Nullable
    public String b() {
        return this.f19317d;
    }

    @Override // u2.d
    public long c() {
        return this.f19319f;
    }

    @Override // u2.d
    @Nullable
    public String d() {
        return this.f19315b;
    }

    @Override // u2.d
    @Nullable
    public String e() {
        return this.f19321h;
    }

    @Override // u2.d
    @Nullable
    public String f() {
        return this.f19318e;
    }

    @Override // u2.d
    @NonNull
    public c.a g() {
        return this.f19316c;
    }

    @Override // u2.d
    public long h() {
        return this.f19320g;
    }

    public int hashCode() {
        String str = this.f19315b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f19316c.hashCode()) * 1000003;
        String str2 = this.f19317d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19318e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f19319f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f19320g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f19321h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // u2.d
    public d.a n() {
        return new b(this, null);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f19315b + ", registrationStatus=" + this.f19316c + ", authToken=" + this.f19317d + ", refreshToken=" + this.f19318e + ", expiresInSecs=" + this.f19319f + ", tokenCreationEpochInSecs=" + this.f19320g + ", fisError=" + this.f19321h + "}";
    }
}
