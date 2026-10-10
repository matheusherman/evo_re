package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class m implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14340a;

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.h d();

    protected abstract boolean i(kotlin.reflect.jvm.internal.impl.descriptors.h hVar);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1) || obj.hashCode() != hashCode()) {
            return false;
        }
        g1 g1Var = (g1) obj;
        if (g1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = d();
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD2 = g1Var.d();
        if (hVarD2 != null && h(hVarD) && h(hVarD2)) {
            return i(hVarD2);
        }
        return false;
    }

    protected final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.h first, kotlin.reflect.jvm.internal.impl.descriptors.h second) {
        kotlin.jvm.internal.m.f(first, "first");
        kotlin.jvm.internal.m.f(second, "second");
        if (!kotlin.jvm.internal.m.a(first.getName(), second.getName())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = first.b();
        for (kotlin.reflect.jvm.internal.impl.descriptors.m mVarB2 = second.b(); mVarB != null && mVarB2 != null; mVarB2 = mVarB2.b()) {
            if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.h0) {
                return mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.h0;
            }
            if (mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.h0) {
                return false;
            }
            if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) {
                return (mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) && kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.l0) mVarB).d(), ((kotlin.reflect.jvm.internal.impl.descriptors.l0) mVarB2).d());
            }
            if ((mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) || !kotlin.jvm.internal.m.a(mVarB.getName(), mVarB2.getName())) {
                return false;
            }
            mVarB = mVarB.b();
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f14340a;
        if (i10 != 0) {
            return i10;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = d();
        int iHashCode = h(hVarD) ? kotlin.reflect.jvm.internal.impl.resolve.e.m(hVarD).hashCode() : System.identityHashCode(this);
        this.f14340a = iHashCode;
        return iHashCode;
    }

    private final boolean h(kotlin.reflect.jvm.internal.impl.descriptors.h hVar) {
        if (!la.k.m(hVar) && !kotlin.reflect.jvm.internal.impl.resolve.e.E(hVar)) {
            return true;
        }
        return false;
    }
}
