package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y9.c f14199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y9.a f14200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c9.l<ba.b, a1> f14201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<ba.b, w9.c> f14202d;

    /* JADX WARN: Multi-variable type inference failed */
    public x(w9.m proto, y9.c nameResolver, y9.a metadataVersion, c9.l<? super ba.b, ? extends a1> classSource) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(classSource, "classSource");
        this.f14199a = nameResolver;
        this.f14200b = metadataVersion;
        this.f14201c = classSource;
        List<w9.c> listI = proto.I();
        kotlin.jvm.internal.m.e(listI, "proto.class_List");
        List<w9.c> list = listI;
        LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(w.a(this.f14199a, ((w9.c) obj).E0()), obj);
        }
        this.f14202d = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.h
    public g a(ba.b classId) {
        kotlin.jvm.internal.m.f(classId, "classId");
        w9.c cVar = this.f14202d.get(classId);
        if (cVar == null) {
            return null;
        }
        return new g(this.f14199a, cVar, this.f14200b, this.f14201c.invoke(classId));
    }

    public final Collection<ba.b> b() {
        return this.f14202d.keySet();
    }
}
