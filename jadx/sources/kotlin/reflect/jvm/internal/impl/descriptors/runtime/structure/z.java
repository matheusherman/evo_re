package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class z implements u9.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13060a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final z a(Type type) {
            kotlin.jvm.internal.m.f(type, "type");
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new x(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) {
                return new k(type);
            }
            return type instanceof WildcardType ? new c0((WildcardType) type) : new n(type);
        }
    }

    protected abstract Type P();

    public boolean equals(Object obj) {
        return (obj instanceof z) && kotlin.jvm.internal.m.a(P(), ((z) obj).P());
    }

    @Override // u9.d
    public u9.a j(ba.c fqName) {
        Object obj;
        Object next;
        ba.b bVarE;
        kotlin.jvm.internal.m.f(fqName, "fqName");
        Iterator<T> it = getAnnotations().iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                bVarE = ((u9.a) next).e();
            }
            return (u9.a) obj;
        } while (!kotlin.jvm.internal.m.a(bVarE != null ? bVarE.b() : null, fqName));
        obj = next;
        return (u9.a) obj;
    }

    public String toString() {
        return getClass().getName() + ": " + P();
    }

    public int hashCode() {
        return P().hashCode();
    }
}
