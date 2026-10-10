package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f14190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f14191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f14192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final T f14193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ba.b f14195f;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.m.a(this.f14190a, sVar.f14190a) && kotlin.jvm.internal.m.a(this.f14191b, sVar.f14191b) && kotlin.jvm.internal.m.a(this.f14192c, sVar.f14192c) && kotlin.jvm.internal.m.a(this.f14193d, sVar.f14193d) && kotlin.jvm.internal.m.a(this.f14194e, sVar.f14194e) && kotlin.jvm.internal.m.a(this.f14195f, sVar.f14195f);
    }

    public s(T t10, T t11, T t12, T t13, String filePath, ba.b classId) {
        kotlin.jvm.internal.m.f(filePath, "filePath");
        kotlin.jvm.internal.m.f(classId, "classId");
        this.f14190a = t10;
        this.f14191b = t11;
        this.f14192c = t12;
        this.f14193d = t13;
        this.f14194e = filePath;
        this.f14195f = classId;
    }

    public int hashCode() {
        T t10 = this.f14190a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f14191b;
        int iHashCode2 = (iHashCode + (t11 == null ? 0 : t11.hashCode())) * 31;
        T t12 = this.f14192c;
        int iHashCode3 = (iHashCode2 + (t12 == null ? 0 : t12.hashCode())) * 31;
        T t13 = this.f14193d;
        return ((((iHashCode3 + (t13 != null ? t13.hashCode() : 0)) * 31) + this.f14194e.hashCode()) * 31) + this.f14195f.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f14190a + ", compilerVersion=" + this.f14191b + ", languageVersion=" + this.f14192c + ", expectedVersion=" + this.f14193d + ", filePath=" + this.f14194e + ", classId=" + this.f14195f + ')';
    }
}
