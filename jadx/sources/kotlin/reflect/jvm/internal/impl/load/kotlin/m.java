package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.b1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fa.d f13592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final fa.d f13593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> f13594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e f13596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s f13597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f13598h;

    public m(fa.d className, fa.d dVar, w9.l packageProto, y9.c nameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> sVar, boolean z10, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e abiStability, s sVar2) {
        String string;
        kotlin.jvm.internal.m.f(className, "className");
        kotlin.jvm.internal.m.f(packageProto, "packageProto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(abiStability, "abiStability");
        this.f13592b = className;
        this.f13593c = dVar;
        this.f13594d = sVar;
        this.f13595e = z10;
        this.f13596f = abiStability;
        this.f13597g = sVar2;
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.l, Integer> packageModuleName = z9.a.f23136m;
        kotlin.jvm.internal.m.e(packageModuleName, "packageModuleName");
        Integer num = (Integer) y9.e.a(packageProto, packageModuleName);
        this.f13598h = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public b1 a() {
        b1 NO_SOURCE_FILE = b1.f12738a;
        kotlin.jvm.internal.m.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final ba.b d() {
        return new ba.b(e().g(), h());
    }

    public fa.d e() {
        return this.f13592b;
    }

    public fa.d f() {
        return this.f13593c;
    }

    public final s g() {
        return this.f13597g;
    }

    public String toString() {
        return m.class.getSimpleName() + ": " + e();
    }

    public final ba.f h() {
        String strF = e().f();
        kotlin.jvm.internal.m.e(strF, "className.internalName");
        ba.f fVarL = ba.f.l(ua.n.K0(strF, '/', null, 2, null));
        kotlin.jvm.internal.m.e(fVarL, "identifier(className.int….substringAfterLast('/'))");
        return fVarL;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(s kotlinClass, w9.l packageProto, y9.c nameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> sVar, boolean z10, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e abiStability) {
        kotlin.jvm.internal.m.f(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.m.f(packageProto, "packageProto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(abiStability, "abiStability");
        fa.d dVarB = fa.d.b(kotlinClass.e());
        kotlin.jvm.internal.m.e(dVarB, "byClassId(kotlinClass.classId)");
        String strE = kotlinClass.g().e();
        fa.d dVarD = null;
        if (strE != null && strE.length() > 0) {
            dVarD = fa.d.d(strE);
        }
        this(dVarB, dVarD, packageProto, nameResolver, sVar, z10, abiStability, kotlinClass);
    }
}
