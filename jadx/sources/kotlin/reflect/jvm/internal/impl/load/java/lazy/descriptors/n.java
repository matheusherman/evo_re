package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import u9.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final y f13373l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, y javaTypeParameter, int i10, kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration) {
        super(c10.e(), containingDeclaration, new kotlin.reflect.jvm.internal.impl.load.java.lazy.d(c10, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), w1.INVARIANT, false, i10, a1.f12668a, c10.a().v());
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(javaTypeParameter, "javaTypeParameter");
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        this.f13372k = c10;
        this.f13373l = javaTypeParameter;
    }

    private final List<g0> I0() {
        Collection<u9.j> upperBounds = this.f13373l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            o0 o0VarI = this.f13372k.d().l().i();
            kotlin.jvm.internal.m.e(o0VarI, "c.module.builtIns.anyType");
            o0 o0VarI2 = this.f13372k.d().l().I();
            kotlin.jvm.internal.m.e(o0VarI2, "c.module.builtIns.nullableAnyType");
            return r.e(h0.d(o0VarI, o0VarI2));
        }
        Collection<u9.j> collection = upperBounds;
        ArrayList arrayList = new ArrayList(r.w(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f13372k.g().o((u9.j) it.next(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, this, 3, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected List<g0> B0(List<? extends g0> bounds) {
        kotlin.jvm.internal.m.f(bounds, "bounds");
        return this.f13372k.a().r().i(this, bounds, this.f13372k);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected void G0(g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected List<g0> H0() {
        return I0();
    }
}
