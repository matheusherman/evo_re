package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends p implements u9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Annotation f13030a;

    @Override // u9.a
    public boolean g() {
        return false;
    }

    @Override // u9.a
    public boolean s() {
        return false;
    }

    public e(Annotation annotation) {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        this.f13030a = annotation;
    }

    public final Annotation P() {
        return this.f13030a;
    }

    @Override // u9.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public l w() {
        return new l(b9.a.b(b9.a.a(this.f13030a)));
    }

    @Override // u9.a
    public ba.b e() {
        return d.a(b9.a.b(b9.a.a(this.f13030a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.f13030a == ((e) obj).f13030a;
    }

    @Override // u9.a
    public Collection<u9.b> getArguments() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = b9.a.b(b9.a.a(this.f13030a)).getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            f.a aVar = f.f13031b;
            Object objInvoke = method.invoke(this.f13030a, null);
            kotlin.jvm.internal.m.e(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(objInvoke, ba.f.l(method.getName())));
        }
        return arrayList;
    }

    public int hashCode() {
        return System.identityHashCode(this.f13030a);
    }

    public String toString() {
        return e.class.getName() + ": " + this.f13030a;
    }
}
