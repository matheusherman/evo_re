package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import ka.n;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.o;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12564f = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n storageManager, q finder, h0 moduleDescriptor, k0 notFoundClasses, n9.a additionalClassPartsProvider, n9.c platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.serialization.deserialization.l deserializationConfiguration, kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, ga.a samConversionResolver) {
        super(storageManager, finder, moduleDescriptor);
        m.f(storageManager, "storageManager");
        m.f(finder, "finder");
        m.f(moduleDescriptor, "moduleDescriptor");
        m.f(notFoundClasses, "notFoundClasses");
        m.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        m.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        m.f(deserializationConfiguration, "deserializationConfiguration");
        m.f(kotlinTypeChecker, "kotlinTypeChecker");
        m.f(samConversionResolver, "samConversionResolver");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.n nVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.n(this);
        ja.a aVar = ja.a.f11649r;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.d dVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(moduleDescriptor, notFoundClasses, aVar);
        u.a aVar2 = u.a.f14196a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.q DO_NOTHING = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.f14188a;
        m.e(DO_NOTHING, "DO_NOTHING");
        i(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.k(storageManager, moduleDescriptor, deserializationConfiguration, nVar, dVar, this, aVar2, DO_NOTHING, r9.c.a.f17875a, r.a.f14189a, kotlin.collections.r.o(new m9.a(storageManager, moduleDescriptor), new e(storageManager, moduleDescriptor, null, 4, null)), notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.f14146a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.e(), kotlinTypeChecker, samConversionResolver, null, null, 786432, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.a
    protected o d(ba.c fqName) {
        m.f(fqName, "fqName");
        InputStream inputStreamA = f().a(fqName);
        if (inputStreamA != null) {
            return ja.c.f11651o.a(fqName, h(), g(), inputStreamA, false);
        }
        return null;
    }
}
