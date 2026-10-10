package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14006e = {c0.g(new w(c0.b(l.class), "functions", "getFunctions()Ljava/util/List;")), c0.g(new w(c0.b(l.class), "properties", "getProperties()Ljava/util/List;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f14007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i f14008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i f14009d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<List<? extends z0>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends z0> invoke() {
            return r.o(kotlin.reflect.jvm.internal.impl.resolve.d.g(l.this.f14007b), kotlin.reflect.jvm.internal.impl.resolve.d.h(l.this.f14007b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.a<List<? extends u0>> {
        b() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends u0> invoke() {
            return r.p(kotlin.reflect.jvm.internal.impl.resolve.d.f(l.this.f14007b));
        }
    }

    public l(ka.n storageManager, kotlin.reflect.jvm.internal.impl.descriptors.e containingClass) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(containingClass, "containingClass");
        this.f14007b = containingClass;
        containingClass.g();
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        this.f14008c = storageManager.c(new a());
        this.f14009d = storageManager.c(new b());
    }

    private final List<z0> l() {
        return (List) ka.m.a(this.f14008c, this, f14006e[0]);
    }

    private final List<u0> m() {
        return (List) ka.m.a(this.f14009d, this, f14006e[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        List<u0> listM = m();
        sa.f fVar = new sa.f();
        for (Object obj : listM) {
            if (kotlin.jvm.internal.m.a(((u0) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }

    public Void i(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.b> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return r.B0(l(), m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public sa.f<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        List<z0> listL = l();
        sa.f<z0> fVar = new sa.f<>();
        for (Object obj : listL) {
            if (kotlin.jvm.internal.m.a(((z0) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f fVar, r9.b bVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.h) i(fVar, bVar);
    }
}
