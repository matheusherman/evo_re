package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0005*\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0019\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u0010*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "descriptor", "", "isDefault", "b", "(Lkotlin/reflect/jvm/internal/calls/e;Lkotlin/reflect/jvm/internal/impl/descriptors/b;Z)Lkotlin/reflect/jvm/internal/calls/e;", "g", "(Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Z", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "f", "(Ljava/lang/Class;Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Ljava/lang/reflect/Method;", "d", "Lkotlin/reflect/jvm/internal/impl/types/g0;", "i", "(Lkotlin/reflect/jvm/internal/impl/types/g0;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/m;", "h", "(Lkotlin/reflect/jvm/internal/impl/descriptors/m;)Ljava/lang/Class;", "", "a", "(Ljava/lang/Object;Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Ljava/lang/Object;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "expectedReceiverType", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class i {
    public static final Object a(Object obj, kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        g0 g0VarE;
        Class<?> clsI;
        Method methodF;
        m.f(descriptor, "descriptor");
        return (((descriptor instanceof u0) && kotlin.reflect.jvm.internal.impl.resolve.g.e((k1) descriptor)) || (g0VarE = e(descriptor)) == null || (clsI = i(g0VarE)) == null || (methodF = f(clsI, descriptor)) == null) ? obj : methodF.invoke(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> e<M> b(e<? extends M> eVar, kotlin.reflect.jvm.internal.impl.descriptors.b descriptor, boolean z10) {
        g0 returnType;
        m.f(eVar, "<this>");
        m.f(descriptor, "descriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.g.a(descriptor)) {
            List<j1> listF = descriptor.f();
            m.e(listF, "descriptor.valueParameters");
            List<j1> list = listF;
            if ((list instanceof Collection) && list.isEmpty()) {
                returnType = descriptor.getReturnType();
                return returnType != null ? eVar : eVar;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                g0 type = ((j1) it.next()).getType();
                m.e(type, "it.type");
                if (kotlin.reflect.jvm.internal.impl.resolve.g.c(type)) {
                }
            }
            returnType = descriptor.getReturnType();
            if ((returnType != null || !kotlin.reflect.jvm.internal.impl.resolve.g.c(returnType)) && ((eVar instanceof d) || !g(descriptor))) {
            }
        }
        return new h(descriptor, eVar, z10);
    }

    public static /* synthetic */ e c(e eVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b(eVar, bVar, z10);
    }

    public static final Method d(Class<?> cls, kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        m.f(cls, "<this>");
        m.f(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, descriptor).getReturnType());
            m.e(declaredMethod, "{\n        getDeclaredMet…riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new f0("No box method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final Method f(Class<?> cls, kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        m.f(cls, "<this>");
        m.f(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            m.e(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new f0("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final Class<?> h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (!(mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) || !kotlin.reflect.jvm.internal.impl.resolve.g.b(mVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVar;
        Class<?> clsP = n0.p(eVar);
        if (clsP != null) {
            return clsP;
        }
        throw new f0("Class object for the class " + eVar.getName() + " cannot be found (classId=" + ea.c.k((kotlin.reflect.jvm.internal.impl.descriptors.h) mVar) + ')');
    }

    public static final Class<?> i(g0 g0Var) {
        g0 g0VarG;
        m.f(g0Var, "<this>");
        Class<?> clsH = h(g0Var.J0().d());
        if (clsH == null) {
            return null;
        }
        if (s1.l(g0Var) && ((g0VarG = kotlin.reflect.jvm.internal.impl.resolve.g.g(g0Var)) == null || s1.l(g0VarG) || kotlin.reflect.jvm.internal.impl.builtins.h.s0(g0VarG))) {
            return null;
        }
        return clsH;
    }

    private static final g0 e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
        x0 x0VarI0 = bVar.i0();
        x0 x0VarB0 = bVar.b0();
        if (x0VarI0 != null) {
            return x0VarI0.getType();
        }
        if (x0VarB0 == null) {
            return null;
        }
        if (bVar instanceof l) {
            return x0VarB0.getType();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = bVar.b();
        if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            return null;
        }
        return eVar.p();
    }

    private static final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        g0 g0VarE = e(bVar);
        if (g0VarE == null || !kotlin.reflect.jvm.internal.impl.resolve.g.c(g0VarE)) {
            return false;
        }
        return true;
    }
}
