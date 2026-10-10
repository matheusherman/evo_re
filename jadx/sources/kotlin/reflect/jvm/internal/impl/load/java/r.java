package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i f13417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<b> f13418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13419c;

    /* JADX WARN: Multi-variable type inference failed */
    public r(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i nullabilityQualifier, Collection<? extends b> qualifierApplicabilityTypes, boolean z10) {
        kotlin.jvm.internal.m.f(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.m.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f13417a = nullabilityQualifier;
        this.f13418b = qualifierApplicabilityTypes;
        this.f13419c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return kotlin.jvm.internal.m.a(this.f13417a, rVar.f13417a) && kotlin.jvm.internal.m.a(this.f13418b, rVar.f13418b) && this.f13419c == rVar.f13419c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r b(r rVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVar, Collection collection, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = rVar.f13417a;
        }
        if ((i10 & 2) != 0) {
            collection = rVar.f13418b;
        }
        if ((i10 & 4) != 0) {
            z10 = rVar.f13419c;
        }
        return rVar.a(iVar, collection, z10);
    }

    public final r a(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i nullabilityQualifier, Collection<? extends b> qualifierApplicabilityTypes, boolean z10) {
        kotlin.jvm.internal.m.f(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.m.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new r(nullabilityQualifier, qualifierApplicabilityTypes, z10);
    }

    public final boolean c() {
        return this.f13419c;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i d() {
        return this.f13417a;
    }

    public final Collection<b> e() {
        return this.f13418b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.f13417a.hashCode() * 31) + this.f13418b.hashCode()) * 31;
        boolean z10 = this.f13419c;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f13417a + ", qualifierApplicabilityTypes=" + this.f13418b + ", definitelyNotNull=" + this.f13419c + ')';
    }

    public /* synthetic */ r(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVar, Collection collection, boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this(iVar, collection, (i10 & 4) != 0 ? iVar.c() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NOT_NULL : z10);
    }
}
