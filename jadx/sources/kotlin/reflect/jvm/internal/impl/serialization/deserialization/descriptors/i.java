package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import w9.r;
import w9.t;
import w9.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l0 f14116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f14117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ba.c f14118i;

    public i(l0 packageDescriptor, w9.l proto, y9.c nameResolver, y9.a metadataVersion, f fVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.k components, String debugName, c9.a<? extends Collection<ba.f>> classNames) {
        kotlin.jvm.internal.m.f(packageDescriptor, "packageDescriptor");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(components, "components");
        kotlin.jvm.internal.m.f(debugName, "debugName");
        kotlin.jvm.internal.m.f(classNames, "classNames");
        t tVarV = proto.V();
        kotlin.jvm.internal.m.e(tVarV, "proto.typeTable");
        y9.g gVar = new y9.g(tVarV);
        y9.h.a aVar = y9.h.f22527b;
        w wVarW = proto.W();
        kotlin.jvm.internal.m.e(wVarW, "proto.versionRequirementTable");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVarA = components.a(packageDescriptor, nameResolver, gVar, aVar.a(wVarW), metadataVersion, fVar);
        List<w9.i> listO = proto.O();
        kotlin.jvm.internal.m.e(listO, "proto.functionList");
        List<w9.n> listR = proto.R();
        kotlin.jvm.internal.m.e(listR, "proto.propertyList");
        List<r> listU = proto.U();
        kotlin.jvm.internal.m.e(listU, "proto.typeAliasList");
        super(mVarA, listO, listR, listU, classNames);
        this.f14116g = packageDescriptor;
        this.f14117h = debugName;
        this.f14118i = packageDescriptor.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        z(name, location);
        return super.e(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected void i(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> result, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected ba.b m(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return new ba.b(this.f14118i, name);
    }

    public String toString() {
        return this.f14117h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected boolean w(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        if (super.w(name)) {
            return true;
        }
        Iterable<n9.b> iterableK = p().c().k();
        if ((iterableK instanceof Collection) && ((Collection) iterableK).isEmpty()) {
            return false;
        }
        Iterator<n9.b> it = iterableK.iterator();
        while (it.hasNext()) {
            if (it.next().c(this.f14118i, name)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionJ = j(kindFilter, nameFilter, r9.d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<n9.b> iterableK = p().c().k();
        ArrayList arrayList = new ArrayList();
        Iterator<n9.b> it = iterableK.iterator();
        while (it.hasNext()) {
            kotlin.collections.r.C(arrayList, it.next().a(this.f14118i));
        }
        return kotlin.collections.r.B0(collectionJ, arrayList);
    }

    public void z(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        q9.a.b(p().c().o(), location, this.f14116g, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected Set<ba.f> s() {
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected Set<ba.f> t() {
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
    protected Set<ba.f> u() {
        return v0.e();
    }
}
