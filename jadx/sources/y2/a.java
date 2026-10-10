package y2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22312b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f22311a.equals(fVar.b()) && this.f22312b.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // y2.f
    public String b() {
        return this.f22311a;
    }

    @Override // y2.f
    public String c() {
        return this.f22312b;
    }

    public int hashCode() {
        return ((this.f22311a.hashCode() ^ 1000003) * 1000003) ^ this.f22312b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f22311a + ", version=" + this.f22312b + "}";
    }

    a(String str, String str2) {
        if (str != null) {
            this.f22311a = str;
            if (str2 != null) {
                this.f22312b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }
}
