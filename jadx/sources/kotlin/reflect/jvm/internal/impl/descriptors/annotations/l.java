package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f12698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c9.l<ba.c, Boolean> f12700c;

    /* JADX WARN: Multi-variable type inference failed */
    public l(g delegate, boolean z10, c9.l<? super ba.c, Boolean> fqNameFilter) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        kotlin.jvm.internal.m.f(fqNameFilter, "fqNameFilter");
        this.f12698a = delegate;
        this.f12699b = z10;
        this.f12700c = fqNameFilter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean F(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        if (this.f12700c.invoke(fqName).booleanValue()) {
            return this.f12698a.F(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        boolean z10;
        g gVar = this.f12698a;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                if (e(it.next())) {
                    z10 = true;
                    break;
                }
            }
        } else {
            z10 = false;
            break;
        }
        if (this.f12699b) {
            return !z10;
        }
        return z10;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.f12698a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (e(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public c j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        if (this.f12700c.invoke(fqName).booleanValue()) {
            return this.f12698a.j(fqName);
        }
        return null;
    }

    private final boolean e(c cVar) {
        ba.c cVarD = cVar.d();
        if (cVarD != null && this.f12700c.invoke(cVarD).booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(g delegate, c9.l<? super ba.c, Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        kotlin.jvm.internal.m.f(delegate, "delegate");
        kotlin.jvm.internal.m.f(fqNameFilter, "fqNameFilter");
    }
}
