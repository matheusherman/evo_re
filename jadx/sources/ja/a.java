package ja;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import ua.n;
import w9.l;
import w9.q;
import w9.s;
import w9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends ia.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f11649r = new a();

    public final String q(ba.c fqName) {
        m.f(fqName, "fqName");
        return s(fqName) + ".kotlin_builtins";
    }

    public final String r(ba.c fqName) {
        m.f(fqName, "fqName");
        StringBuilder sb2 = new StringBuilder();
        String strB = fqName.b();
        m.e(strB, "fqName.asString()");
        sb2.append(n.D(strB, '.', '/', false, 4, null));
        sb2.append('/');
        sb2.append(q(fqName));
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private a() {
        g gVarD = g.d();
        x9.b.a(gVarD);
        m.e(gVarD, "newInstance().apply(Buil…f::registerAllExtensions)");
        i.f<l, Integer> packageFqName = x9.b.f22012a;
        m.e(packageFqName, "packageFqName");
        i.f<w9.d, List<w9.b>> constructorAnnotation = x9.b.f22014c;
        m.e(constructorAnnotation, "constructorAnnotation");
        i.f<w9.c, List<w9.b>> classAnnotation = x9.b.f22013b;
        m.e(classAnnotation, "classAnnotation");
        i.f<w9.i, List<w9.b>> functionAnnotation = x9.b.f22015d;
        m.e(functionAnnotation, "functionAnnotation");
        i.f<w9.n, List<w9.b>> propertyAnnotation = x9.b.f22016e;
        m.e(propertyAnnotation, "propertyAnnotation");
        i.f<w9.n, List<w9.b>> propertyGetterAnnotation = x9.b.f22017f;
        m.e(propertyGetterAnnotation, "propertyGetterAnnotation");
        i.f<w9.n, List<w9.b>> propertySetterAnnotation = x9.b.f22018g;
        m.e(propertySetterAnnotation, "propertySetterAnnotation");
        i.f<w9.g, List<w9.b>> enumEntryAnnotation = x9.b.f22020i;
        m.e(enumEntryAnnotation, "enumEntryAnnotation");
        i.f<w9.n, w9.b.C0384b.c> compileTimeValue = x9.b.f22019h;
        m.e(compileTimeValue, "compileTimeValue");
        i.f<u, List<w9.b>> parameterAnnotation = x9.b.f22021j;
        m.e(parameterAnnotation, "parameterAnnotation");
        i.f<q, List<w9.b>> typeAnnotation = x9.b.f22022k;
        m.e(typeAnnotation, "typeAnnotation");
        i.f<s, List<w9.b>> typeParameterAnnotation = x9.b.f22023l;
        m.e(typeParameterAnnotation, "typeParameterAnnotation");
        super(gVarD, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, null, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, null, null, null, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    private final String s(ba.c cVar) {
        if (cVar.d()) {
            return "default-package";
        }
        String strF = cVar.g().f();
        m.e(strF, "fqName.shortName().asString()");
        return strF;
    }
}
