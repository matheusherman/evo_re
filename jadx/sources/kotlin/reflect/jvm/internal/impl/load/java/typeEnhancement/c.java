package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.c f13429a;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return false;
    }

    public c(ba.c fqNameToMatch) {
        kotlin.jvm.internal.m.f(fqNameToMatch, "fqNameToMatch");
        this.f13429a = fqNameToMatch;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        if (kotlin.jvm.internal.m.a(fqName, this.f13429a)) {
            return b.f13428a;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean F(ba.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.b(this, cVar);
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return kotlin.collections.r.l().iterator();
    }
}
