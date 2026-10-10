package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.f f12683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.f f12684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ba.f f12685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.f f12686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ba.f f12687e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<h0, g0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.builtins.h $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
            super(1);
            this.$this_createDeprecatedAnnotation = hVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(h0 module) {
            kotlin.jvm.internal.m.f(module, "module");
            o0 o0VarL = module.l().l(w1.INVARIANT, this.$this_createDeprecatedAnnotation.W());
            kotlin.jvm.internal.m.e(o0VarL, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            return o0VarL;
        }
    }

    static {
        ba.f fVarL = ba.f.l("message");
        kotlin.jvm.internal.m.e(fVarL, "identifier(\"message\")");
        f12683a = fVarL;
        ba.f fVarL2 = ba.f.l("replaceWith");
        kotlin.jvm.internal.m.e(fVarL2, "identifier(\"replaceWith\")");
        f12684b = fVarL2;
        ba.f fVarL3 = ba.f.l("level");
        kotlin.jvm.internal.m.e(fVarL3, "identifier(\"level\")");
        f12685c = fVarL3;
        ba.f fVarL4 = ba.f.l("expression");
        kotlin.jvm.internal.m.e(fVarL4, "identifier(\"expression\")");
        f12686d = fVarL4;
        ba.f fVarL5 = ba.f.l("imports");
        kotlin.jvm.internal.m.e(fVarL5, "identifier(\"imports\")");
        f12687e = fVarL5;
    }

    public static final c a(kotlin.reflect.jvm.internal.impl.builtins.h hVar, String message, String replaceWith, String level) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(message, "message");
        kotlin.jvm.internal.m.f(replaceWith, "replaceWith");
        kotlin.jvm.internal.m.f(level, "level");
        j jVar = new j(hVar, kotlin.reflect.jvm.internal.impl.builtins.k.a.B, n0.l(v.a(f12686d, new kotlin.reflect.jvm.internal.impl.resolve.constants.v(replaceWith)), v.a(f12687e, new kotlin.reflect.jvm.internal.impl.resolve.constants.b(r.l(), new a(hVar)))));
        ba.c cVar = kotlin.reflect.jvm.internal.impl.builtins.k.a.f12646y;
        p pVarA = v.a(f12683a, new kotlin.reflect.jvm.internal.impl.resolve.constants.v(message));
        p pVarA2 = v.a(f12684b, new kotlin.reflect.jvm.internal.impl.resolve.constants.a(jVar));
        ba.f fVar = f12685c;
        ba.b bVarM = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.A);
        kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.deprecationLevel)");
        ba.f fVarL = ba.f.l(level);
        kotlin.jvm.internal.m.e(fVarL, "identifier(level)");
        return new j(hVar, cVar, n0.l(pVarA, pVarA2, v.a(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.j(bVarM, fVarL))));
    }

    public static /* synthetic */ c b(kotlin.reflect.jvm.internal.impl.builtins.h hVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
