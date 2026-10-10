package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class t extends p implements h, v, u9.q {
    public abstract Member Q();

    @Override // u9.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // u9.d
    public /* bridge */ /* synthetic */ u9.a j(ba.c cVar) {
        return j(cVar);
    }

    @Override // u9.d
    public boolean l() {
        return false;
    }

    @Override // u9.q
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public l N() {
        Class<?> declaringClass = Q().getDeclaringClass();
        kotlin.jvm.internal.m.e(declaringClass, "member.declaringClass");
        return new l(declaringClass);
    }

    protected final List<u9.b0> R(Type[] parameterTypes, Annotation[][] parameterAnnotations, boolean z10) throws IllegalAccessException, InvocationTargetException {
        String str;
        kotlin.jvm.internal.m.f(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.m.f(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List<String> listB = c.f13017a.b(Q());
        int size = listB != null ? listB.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            z zVarA = z.f13060a.a(parameterTypes[i10]);
            if (listB != null) {
                str = (String) kotlin.collections.r.j0(listB, i10 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i10 + '+' + size + " (name=" + getName() + " type=" + zVarA + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new b0(zVarA, parameterAnnotations[i10], str, z10 && i10 == kotlin.collections.j.R(parameterTypes)));
            i10++;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && kotlin.jvm.internal.m.a(Q(), ((t) obj).Q());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, u9.d
    public List<e> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<e> listB;
        AnnotatedElement annotatedElementT = t();
        return (annotatedElementT == null || (declaredAnnotations = annotatedElementT.getDeclaredAnnotations()) == null || (listB = i.b(declaredAnnotations)) == null) ? kotlin.collections.r.l() : listB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, u9.d
    public e j(ba.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.m.f(fqName, "fqName");
        AnnotatedElement annotatedElementT = t();
        if (annotatedElementT == null || (declaredAnnotations = annotatedElementT.getDeclaredAnnotations()) == null) {
            return null;
        }
        return i.a(declaredAnnotations, fqName);
    }

    public String toString() {
        return getClass().getName() + ": " + Q();
    }

    @Override // u9.s
    public boolean O() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v
    public int getModifiers() {
        return Q().getModifiers();
    }

    @Override // u9.t
    public ba.f getName() {
        ba.f fVarL;
        String name = Q().getName();
        if (name != null) {
            fVarL = ba.f.l(name);
        } else {
            fVarL = null;
        }
        if (fVarL == null) {
            return ba.h.f943b;
        }
        return fVarL;
    }

    @Override // u9.s
    public n1 getVisibility() {
        int modifiers = getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return m1.h.f12995c;
        }
        if (Modifier.isPrivate(modifiers)) {
            return m1.e.f12992c;
        }
        if (Modifier.isProtected(modifiers)) {
            if (Modifier.isStatic(modifiers)) {
                return o9.c.f16513c;
            }
            return o9.b.f16512c;
        }
        return o9.a.f16511c;
    }

    public int hashCode() {
        return Q().hashCode();
    }

    @Override // u9.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // u9.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    public AnnotatedElement t() {
        Member memberQ = Q();
        kotlin.jvm.internal.m.d(memberQ, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberQ;
    }
}
