package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a0 extends p implements h, u9.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeVariable<?> f13006a;

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

    public a0(TypeVariable<?> typeVariable) {
        kotlin.jvm.internal.m.f(typeVariable, "typeVariable");
        this.f13006a = typeVariable;
    }

    @Override // u9.y
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public List<n> getUpperBounds() {
        Type[] bounds = this.f13006a.getBounds();
        kotlin.jvm.internal.m.e(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new n(type));
        }
        n nVar = (n) kotlin.collections.r.H0(arrayList);
        return kotlin.jvm.internal.m.a(nVar != null ? nVar.P() : null, Object.class) ? kotlin.collections.r.l() : arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a0) && kotlin.jvm.internal.m.a(this.f13006a, ((a0) obj).f13006a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, u9.d
    public List<e> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<e> listB;
        AnnotatedElement annotatedElementT = t();
        return (annotatedElementT == null || (declaredAnnotations = annotatedElementT.getDeclaredAnnotations()) == null || (listB = i.b(declaredAnnotations)) == null) ? kotlin.collections.r.l() : listB;
    }

    @Override // u9.t
    public ba.f getName() {
        ba.f fVarL = ba.f.l(this.f13006a.getName());
        kotlin.jvm.internal.m.e(fVarL, "identifier(typeVariable.name)");
        return fVarL;
    }

    public int hashCode() {
        return this.f13006a.hashCode();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    public AnnotatedElement t() {
        TypeVariable<?> typeVariable = this.f13006a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    public String toString() {
        return a0.class.getName() + ": " + this.f13006a;
    }
}
