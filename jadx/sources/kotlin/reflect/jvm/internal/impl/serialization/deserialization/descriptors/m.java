package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.c0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.z;
import kotlin.reflect.jvm.internal.impl.types.g0;
import w9.q;
import w9.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f14130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final s f14131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a f14132m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            return r.O0(m.this.f14130k.c().d().c(m.this.K0(), m.this.f14130k.g()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(kotlin.reflect.jvm.internal.impl.serialization.deserialization.m c10, s proto, int i10) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(proto, "proto");
        ka.n nVarH = c10.h();
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = c10.e();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        ba.f fVarB = w.b(c10.g(), proto.N());
        z zVar = z.f14212a;
        s.c cVarT = proto.T();
        kotlin.jvm.internal.m.e(cVarT, "proto.variance");
        super(nVarH, mVarE, gVarB, fVarB, zVar.d(cVarT), proto.O(), i10, a1.f12668a, d1.a.f12742a);
        this.f14130k = c10;
        this.f14131l = proto;
        this.f14132m = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a(c10.h(), new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    protected List<g0> H0() {
        List<q> listS = y9.f.s(this.f14131l, this.f14130k.j());
        if (listS.isEmpty()) {
            return r.e(ea.c.j(this).y());
        }
        List<q> list = listS;
        c0 c0VarI = this.f14130k.i();
        ArrayList arrayList = new ArrayList(r.w(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c0VarI.q((q) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a getAnnotations() {
        return this.f14132m;
    }

    public final s K0() {
        return this.f14131l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public Void G0(g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
