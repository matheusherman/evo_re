package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<x> f12951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<x> f12952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<x> f12953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<x> f12954d;

    public w(List<x> allDependencies, Set<x> modulesWhoseInternalsAreVisible, List<x> directExpectedByDependencies, Set<x> allExpectedByDependencies) {
        kotlin.jvm.internal.m.f(allDependencies, "allDependencies");
        kotlin.jvm.internal.m.f(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.m.f(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.m.f(allExpectedByDependencies, "allExpectedByDependencies");
        this.f12951a = allDependencies;
        this.f12952b = modulesWhoseInternalsAreVisible;
        this.f12953c = directExpectedByDependencies;
        this.f12954d = allExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    public List<x> a() {
        return this.f12951a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    public Set<x> b() {
        return this.f12952b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.v
    public List<x> c() {
        return this.f12953c;
    }
}
