package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f13450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13451b;

    public i(h qualifier, boolean z10) {
        kotlin.jvm.internal.m.f(qualifier, "qualifier");
        this.f13450a = qualifier;
        this.f13451b = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f13450a == iVar.f13450a && this.f13451b == iVar.f13451b;
    }

    public static /* synthetic */ i b(i iVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = iVar.f13450a;
        }
        if ((i10 & 2) != 0) {
            z10 = iVar.f13451b;
        }
        return iVar.a(hVar, z10);
    }

    public final i a(h qualifier, boolean z10) {
        kotlin.jvm.internal.m.f(qualifier, "qualifier");
        return new i(qualifier, z10);
    }

    public final h c() {
        return this.f13450a;
    }

    public final boolean d() {
        return this.f13451b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f13450a.hashCode() * 31;
        boolean z10 = this.f13451b;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f13450a + ", isForWarningOnly=" + this.f13451b + ')';
    }

    public /* synthetic */ i(h hVar, boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this(hVar, (i10 & 2) != 0 ? false : z10);
    }
}
