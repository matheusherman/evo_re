package k9;

import aa.e;
import c9.p;
import i9.f;
import i9.g;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import kotlin.reflect.jvm.internal.n0;
import kotlin.reflect.jvm.internal.o;
import w9.i;
import w9.t;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"R", "Lr8/c;", "Li9/g;", "a", "(Lr8/c;)Li9/g;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class a extends j implements p<v, i, z0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12176a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.jvm.internal.c
        public final f getOwner() {
            return c0.b(v.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // c9.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final z0 invoke(v p10, i p11) {
            m.f(p10, "p0");
            m.f(p11, "p1");
            return p10.j(p11);
        }
    }

    public static final <R> g<R> a(r8.c<? extends R> cVar) {
        m.f(cVar, "<this>");
        Metadata metadata = (Metadata) cVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null) {
            return null;
        }
        r8.p<aa.f, i> pVarJ = aa.i.j(strArrD1, metadata.d2());
        aa.f fVarA = pVarJ.a();
        i iVarB = pVarJ.b();
        e eVar = new e(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = cVar.getClass();
        t tVarM0 = iVarB.m0();
        m.e(tVarM0, "proto.typeTable");
        return new o(kotlin.reflect.jvm.internal.f.f12426d, (z0) n0.h(cls, iVarB, fVarA, new y9.g(tVarM0), eVar, a.f12176a));
    }
}
