package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ka.n;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e implements n9.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ba.f f12529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ba.b f12530h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f12531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<h0, m> f12532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i f12533c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12527e = {c0.g(new w(c0.b(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12526d = new b(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ba.c f12528f = kotlin.reflect.jvm.internal.impl.builtins.k.f12593v;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<h0, kotlin.reflect.jvm.internal.impl.builtins.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12534a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.builtins.b invoke(h0 module) {
            kotlin.jvm.internal.m.f(module, "module");
            List<l0> listD = module.U(e.f12528f).D();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.b) {
                    arrayList.add(obj);
                }
            }
            return (kotlin.reflect.jvm.internal.impl.builtins.b) r.g0(arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final ba.b a() {
            return e.f12530h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.impl.h> {
        final /* synthetic */ n $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.impl.h invoke() {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.h((m) e.this.f12532b.invoke(e.this.f12531a), e.f12529g, e0.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE, r.e(e.this.f12531a.l().i()), a1.f12668a, false, this.$storageManager);
            hVar.G0(new kotlin.reflect.jvm.internal.impl.builtins.jvm.a(this.$storageManager, hVar), v0.e(), null);
            return hVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(n storageManager, h0 moduleDescriptor, c9.l<? super h0, ? extends m> computeContainingDeclaration) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.f(computeContainingDeclaration, "computeContainingDeclaration");
        this.f12531a = moduleDescriptor;
        this.f12532b = computeContainingDeclaration;
        this.f12533c = storageManager.c(new c(storageManager));
    }

    static {
        ba.d dVar = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12604d;
        ba.f fVarI = dVar.i();
        kotlin.jvm.internal.m.e(fVarI, "cloneable.shortName()");
        f12529g = fVarI;
        ba.b bVarM = ba.b.m(dVar.l());
        kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f12530h = bVarM;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.h i() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.h) ka.m.a(this.f12533c, this, f12527e[0]);
    }

    @Override // n9.b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> a(ba.c packageFqName) {
        kotlin.jvm.internal.m.f(packageFqName, "packageFqName");
        return kotlin.jvm.internal.m.a(packageFqName, f12528f) ? v0.d(i()) : v0.e();
    }

    @Override // n9.b
    public kotlin.reflect.jvm.internal.impl.descriptors.e b(ba.b classId) {
        kotlin.jvm.internal.m.f(classId, "classId");
        if (kotlin.jvm.internal.m.a(classId, f12530h)) {
            return i();
        }
        return null;
    }

    @Override // n9.b
    public boolean c(ba.c packageFqName, ba.f name) {
        kotlin.jvm.internal.m.f(packageFqName, "packageFqName");
        kotlin.jvm.internal.m.f(name, "name");
        return kotlin.jvm.internal.m.a(name, f12529g) && kotlin.jvm.internal.m.a(packageFqName, f12528f);
    }

    public /* synthetic */ e(n nVar, h0 h0Var, c9.l lVar, int i10, kotlin.jvm.internal.g gVar) {
        this(nVar, h0Var, (i10 & 4) != 0 ? a.f12534a : lVar);
    }
}
