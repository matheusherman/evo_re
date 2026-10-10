package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<g> f12696a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<g, c> {
        final /* synthetic */ ba.c $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ba.c cVar) {
            super(1);
            this.$fqName = cVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke(g it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.j(this.$fqName);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.l<g, ta.h<? extends c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12697a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ta.h<c> invoke(g it) {
            kotlin.jvm.internal.m.f(it, "it");
            return r.Z(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> delegates) {
        kotlin.jvm.internal.m.f(delegates, "delegates");
        this.f12696a = delegates;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean F(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        Iterator it = r.Z(this.f12696a).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).F(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        List<g> list = this.f12696a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return ta.k.D(r.Z(this.f12696a), b.f12697a).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public c j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return (c) ta.k.C(ta.k.K(r.Z(this.f12696a), new a(fqName)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(g... delegates) {
        this((List<? extends g>) kotlin.collections.j.E0(delegates));
        kotlin.jvm.internal.m.f(delegates, "delegates");
    }
}
