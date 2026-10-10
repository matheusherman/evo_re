package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13899a = new h();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<h0, g0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.builtins.i $componentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.builtins.i iVar) {
            super(1);
            this.$componentType = iVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(h0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            o0 o0VarO = it.l().O(this.$componentType);
            kotlin.jvm.internal.m.e(o0VarO, "it.builtIns.getPrimitive…KotlinType(componentType)");
            return o0VarO;
        }
    }

    private final b a(List<?> list, h0 h0Var, kotlin.reflect.jvm.internal.impl.builtins.i iVar) {
        List listO0 = kotlin.collections.r.O0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            g gVarD = d(this, it.next(), null, 2, null);
            if (gVarD != null) {
                arrayList.add(gVarD);
            }
        }
        if (h0Var == null) {
            return new b(arrayList, new a(iVar));
        }
        o0 o0VarO = h0Var.l().O(iVar);
        kotlin.jvm.internal.m.e(o0VarO, "module.builtIns.getPrimi…KotlinType(componentType)");
        return new w(arrayList, o0VarO);
    }

    public static /* synthetic */ g d(h hVar, Object obj, h0 h0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            h0Var = null;
        }
        return hVar.c(obj, h0Var);
    }

    public final b b(List<? extends g<?>> value, g0 type) {
        kotlin.jvm.internal.m.f(value, "value");
        kotlin.jvm.internal.m.f(type, "type");
        return new w(value, type);
    }

    public final g<?> c(Object obj, h0 h0Var) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(kotlin.collections.j.y0((byte[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.BYTE);
        }
        if (obj instanceof short[]) {
            return a(kotlin.collections.j.F0((short[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.SHORT);
        }
        if (obj instanceof int[]) {
            return a(kotlin.collections.j.C0((int[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.INT);
        }
        if (obj instanceof long[]) {
            return a(kotlin.collections.j.D0((long[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.LONG);
        }
        if (obj instanceof char[]) {
            return a(kotlin.collections.j.z0((char[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.CHAR);
        }
        if (obj instanceof float[]) {
            return a(kotlin.collections.j.B0((float[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(kotlin.collections.j.A0((double[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(kotlin.collections.j.G0((boolean[]) obj), h0Var, kotlin.reflect.jvm.internal.impl.builtins.i.BOOLEAN);
        }
        if (obj == null) {
            return new s();
        }
        return null;
    }

    private h() {
    }
}
