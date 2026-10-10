package p9;

import java.lang.reflect.InvocationTargetException;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class f implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17440c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f17441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v9.a f17442b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final f a(Class<?> klass) throws InvocationTargetException {
            kotlin.jvm.internal.m.f(klass, "klass");
            v9.b bVar = new v9.b();
            c.f17438a.b(klass, bVar);
            v9.a aVarN = bVar.n();
            kotlin.jvm.internal.g gVar = null;
            if (aVarN == null) {
                return null;
            }
            return new f(klass, aVarN, gVar);
        }
    }

    public /* synthetic */ f(Class cls, v9.a aVar, kotlin.jvm.internal.g gVar) {
        this(cls, aVar);
    }

    private f(Class<?> cls, v9.a aVar) {
        this.f17441a = cls;
        this.f17442b = aVar;
    }

    public final Class<?> a() {
        return this.f17441a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s
    public ba.b e() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(this.f17441a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && kotlin.jvm.internal.m.a(this.f17441a, ((f) obj).f17441a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s
    public String f() {
        StringBuilder sb2 = new StringBuilder();
        String name = this.f17441a.getName();
        kotlin.jvm.internal.m.e(name, "klass.name");
        sb2.append(n.D(name, '.', '/', false, 4, null));
        sb2.append(".class");
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s
    public v9.a g() {
        return this.f17442b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s
    public void h(s.c visitor, byte[] bArr) throws InvocationTargetException {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        c.f17438a.b(this.f17441a, visitor);
    }

    public int hashCode() {
        return this.f17441a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s
    public void i(s.d visitor, byte[] bArr) throws InvocationTargetException {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        c.f17438a.i(this.f17441a, visitor);
    }

    public String toString() {
        return f.class.getName() + ": " + this.f17441a;
    }
}
