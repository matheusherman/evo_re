package kotlin.reflect.jvm.internal.impl.load.java.components;

import c9.l;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13172a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, EnumSet<n>> f13173b = n0.l(v.a("PACKAGE", EnumSet.noneOf(n.class)), v.a("TYPE", EnumSet.of(n.CLASS, n.FILE)), v.a("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), v.a("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), v.a("FIELD", EnumSet.of(n.FIELD)), v.a("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), v.a("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), v.a("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), v.a("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), v.a("TYPE_USE", EnumSet.of(n.TYPE)));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, m> f13174c = n0.l(v.a("RUNTIME", m.RUNTIME), v.a("CLASS", m.BINARY), v.a("SOURCE", m.SOURCE));

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements l<h0, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13175a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(h0 module) {
            kotlin.jvm.internal.m.f(module, "module");
            j1 j1VarB = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(c.f13167a.d(), module.l().o(k.a.H));
            g0 type = j1VarB != null ? j1VarB.getType() : null;
            return type == null ? la.k.d(la.j.f15298d2, new String[0]) : type;
        }
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(u9.b bVar) {
        u9.m mVar = bVar instanceof u9.m ? (u9.m) bVar : null;
        if (mVar != null) {
            Map<String, m> map = f13174c;
            ba.f fVarD = mVar.d();
            m mVar2 = map.get(fVarD != null ? fVarD.f() : null);
            if (mVar2 != null) {
                ba.b bVarM = ba.b.m(k.a.K);
                kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.F…ames.annotationRetention)");
                ba.f fVarL = ba.f.l(mVar2.name());
                kotlin.jvm.internal.m.e(fVarL, "identifier(retention.name)");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(bVarM, fVarL);
            }
        }
        return null;
    }

    public final Set<n> b(String str) {
        EnumSet<n> enumSet = f13173b.get(str);
        return enumSet != null ? enumSet : v0.e();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> c(List<? extends u9.b> arguments) {
        kotlin.jvm.internal.m.f(arguments, "arguments");
        ArrayList<u9.m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof u9.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<n> arrayList2 = new ArrayList();
        for (u9.m mVar : arrayList) {
            d dVar = f13172a;
            ba.f fVarD = mVar.d();
            r.C(arrayList2, dVar.b(fVarD != null ? fVarD.f() : null));
        }
        ArrayList arrayList3 = new ArrayList(r.w(arrayList2, 10));
        for (n nVar : arrayList2) {
            ba.b bVarM = ba.b.m(k.a.J);
            kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.annotationTarget)");
            ba.f fVarL = ba.f.l(nVar.name());
            kotlin.jvm.internal.m.e(fVarL, "identifier(kotlinTarget.name)");
            arrayList3.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.j(bVarM, fVarL));
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b(arrayList3, a.f13175a);
    }

    private d() {
    }
}
