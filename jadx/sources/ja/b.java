package ja;

import c9.l;
import i9.f;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import ka.n;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements kotlin.reflect.jvm.internal.impl.builtins.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f11650b = new d();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class a extends j implements l<String, InputStream> {
        a(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.c
        public final f getOwner() {
            return c0.b(d.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String p10) {
            m.f(p10, "p0");
            return ((d) this.receiver).a(p10);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.a
    public m0 a(n storageManager, h0 builtInsModule, Iterable<? extends n9.b> classDescriptorFactories, n9.c platformDependentDeclarationFilter, n9.a additionalClassPartsProvider, boolean z10) {
        m.f(storageManager, "storageManager");
        m.f(builtInsModule, "builtInsModule");
        m.f(classDescriptorFactories, "classDescriptorFactories");
        m.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        m.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        return b(storageManager, builtInsModule, k.C, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z10, new a(this.f11650b));
    }

    public final m0 b(n nVar, h0 h0Var, Set<ba.c> packageFqNames, Iterable<? extends n9.b> classDescriptorFactories, n9.c platformDependentDeclarationFilter, n9.a additionalClassPartsProvider, boolean z10, l<? super String, ? extends InputStream> loadResource) {
        n storageManager = nVar;
        h0 module = h0Var;
        m.f(storageManager, "storageManager");
        m.f(module, "module");
        m.f(packageFqNames, "packageFqNames");
        m.f(classDescriptorFactories, "classDescriptorFactories");
        m.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        m.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        m.f(loadResource, "loadResource");
        ArrayList arrayList = new ArrayList(r.w(packageFqNames, 10));
        for (ba.c cVar : packageFqNames) {
            String strR = ja.a.f11649r.r(cVar);
            InputStream inputStreamInvoke = loadResource.invoke(strR);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException("Resource not found in classpath: " + strR);
            }
            h0 h0Var2 = module;
            storageManager = nVar;
            module = h0Var2;
            arrayList.add(c.f11651o.a(cVar, nVar, h0Var2, inputStreamInvoke, z10));
        }
        n0 n0Var = new n0(arrayList);
        k0 k0Var = new k0(storageManager, module);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.a aVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.a.f14170a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.n nVar2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.n(n0Var);
        ja.a aVar2 = ja.a.f11649r;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.d dVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(module, k0Var, aVar2);
        u.a aVar3 = u.a.f14196a;
        q DO_NOTHING = q.f14188a;
        m.e(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.k(storageManager, h0Var, aVar, nVar2, dVar, n0Var, aVar3, DO_NOTHING, r9.c.a.f17875a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a.f14189a, classDescriptorFactories, k0Var, kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.f14146a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar2.e(), null, new ga.b(storageManager, r.l()), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).H0(kVar);
        }
        return n0Var;
    }
}
