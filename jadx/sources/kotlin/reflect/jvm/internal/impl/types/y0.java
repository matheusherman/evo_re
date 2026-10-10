package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f14394e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y0 f14395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e1 f14396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<k1> f14397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.f1, k1> f14398d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final y0 a(y0 y0Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 typeAliasDescriptor, List<? extends k1> arguments) {
            kotlin.jvm.internal.m.f(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.m.f(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = typeAliasDescriptor.h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list = parameters;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.f1) it.next()).a());
            }
            return new y0(y0Var, typeAliasDescriptor, arguments, kotlin.collections.n0.q(kotlin.collections.r.W0(arrayList, arguments)), null);
        }
    }

    public /* synthetic */ y0(y0 y0Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, List list, Map map, kotlin.jvm.internal.g gVar) {
        this(y0Var, e1Var, list, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private y0(y0 y0Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, List<? extends k1> list, Map<kotlin.reflect.jvm.internal.impl.descriptors.f1, ? extends k1> map) {
        this.f14395a = y0Var;
        this.f14396b = e1Var;
        this.f14397c = list;
        this.f14398d = map;
    }

    public final List<k1> a() {
        return this.f14397c;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e1 b() {
        return this.f14396b;
    }

    public final k1 c(g1 constructor) {
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = constructor.d();
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
            return this.f14398d.get(hVarD);
        }
        return null;
    }

    public final boolean d(kotlin.reflect.jvm.internal.impl.descriptors.e1 descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        if (kotlin.jvm.internal.m.a(this.f14396b, descriptor)) {
            return true;
        }
        y0 y0Var = this.f14395a;
        return y0Var != null ? y0Var.d(descriptor) : false;
    }
}
