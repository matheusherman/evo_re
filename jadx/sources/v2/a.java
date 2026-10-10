package v2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f19505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.b f19506e;

    /* JADX INFO: renamed from: v2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0371a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f19507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f f19510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.b f19511e;

        @Override // v2.d.a
        public d a() {
            return new a(this.f19507a, this.f19508b, this.f19509c, this.f19510d, this.f19511e, null);
        }

        @Override // v2.d.a
        public d.a b(f fVar) {
            this.f19510d = fVar;
            return this;
        }

        @Override // v2.d.a
        public d.a c(String str) {
            this.f19508b = str;
            return this;
        }

        @Override // v2.d.a
        public d.a d(String str) {
            this.f19509c = str;
            return this;
        }

        @Override // v2.d.a
        public d.a e(d.b bVar) {
            this.f19511e = bVar;
            return this;
        }

        @Override // v2.d.a
        public d.a f(String str) {
            this.f19507a = str;
            return this;
        }

        b() {
        }
    }

    /* synthetic */ a(String str, String str2, String str3, f fVar, d.b bVar, C0371a c0371a) {
        this(str, str2, str3, fVar, bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.f19502a;
            if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
                String str2 = this.f19503b;
                if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                    String str3 = this.f19504c;
                    if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                        f fVar = this.f19505d;
                        if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                            d.b bVar = this.f19506e;
                            if (bVar != null ? bVar.equals(dVar.e()) : dVar.e() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable f fVar, @Nullable d.b bVar) {
        this.f19502a = str;
        this.f19503b = str2;
        this.f19504c = str3;
        this.f19505d = fVar;
        this.f19506e = bVar;
    }

    @Override // v2.d
    @Nullable
    public f b() {
        return this.f19505d;
    }

    @Override // v2.d
    @Nullable
    public String c() {
        return this.f19503b;
    }

    @Override // v2.d
    @Nullable
    public String d() {
        return this.f19504c;
    }

    @Override // v2.d
    @Nullable
    public d.b e() {
        return this.f19506e;
    }

    @Override // v2.d
    @Nullable
    public String f() {
        return this.f19502a;
    }

    public int hashCode() {
        String str = this.f19502a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f19503b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19504c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f19505d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f19506e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f19502a + ", fid=" + this.f19503b + ", refreshToken=" + this.f19504c + ", authToken=" + this.f19505d + ", responseCode=" + this.f19506e + "}";
    }
}
