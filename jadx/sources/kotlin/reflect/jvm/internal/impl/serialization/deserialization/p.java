package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class p extends o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final y9.a f14182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f f14183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final y9.d f14184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final x f14185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private w9.m f14186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.h f14187m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<ba.b, a1> {
        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a1 invoke(ba.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar = p.this.f14183i;
            if (fVar != null) {
                return fVar;
            }
            a1 NO_SOURCE = a1.f12668a;
            kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
            return NO_SOURCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<Collection<? extends ba.f>> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<ba.f> invoke() {
            Collection<ba.b> collectionB = p.this.B0().b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionB) {
                ba.b bVar = (ba.b) obj;
                if (!bVar.l() && !i.f14140c.a().contains(bVar)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ba.b) it.next()).j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(ba.c fqName, ka.n storageManager, h0 module, w9.m proto, y9.a metadataVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar) {
        super(fqName, storageManager, module);
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        this.f14182h = metadataVersion;
        this.f14183i = fVar;
        w9.p pVarO = proto.O();
        kotlin.jvm.internal.m.e(pVarO, "proto.strings");
        w9.o oVarN = proto.N();
        kotlin.jvm.internal.m.e(oVarN, "proto.qualifiedNames");
        y9.d dVar = new y9.d(pVarO, oVarN);
        this.f14184j = dVar;
        this.f14185k = new x(proto, dVar, metadataVersion, new a());
        this.f14186l = proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.o
    public void H0(k components) {
        kotlin.jvm.internal.m.f(components, "components");
        w9.m mVar = this.f14186l;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f14186l = null;
        w9.l lVarL = mVar.L();
        kotlin.jvm.internal.m.e(lVarL, "proto.`package`");
        this.f14187m = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i(this, lVarL, this.f14184j, this.f14182h, this.f14183i, components, "scope of " + this, new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.o
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public x B0() {
        return this.f14185k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f14187m;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.m.v("_memberScope");
        return null;
    }
}
