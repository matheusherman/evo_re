package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.collections.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g0 f13503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f13504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<ba.c, g0> f13505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r8.i f13506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13507e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<String[]> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            z zVar = z.this;
            List listC = kotlin.collections.r.c();
            listC.add(zVar.a().f());
            g0 g0VarB = zVar.b();
            if (g0VarB != null) {
                listC.add("under-migration:" + g0VarB.f());
            }
            for (Map.Entry<ba.c, g0> entry : zVar.c().entrySet()) {
                listC.add('@' + entry.getKey() + ':' + entry.getValue().f());
            }
            return (String[]) kotlin.collections.r.a(listC).toArray(new String[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(g0 globalLevel, g0 g0Var, Map<ba.c, ? extends g0> userDefinedLevelForSpecificAnnotation) {
        kotlin.jvm.internal.m.f(globalLevel, "globalLevel");
        kotlin.jvm.internal.m.f(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f13503a = globalLevel;
        this.f13504b = g0Var;
        this.f13505c = userDefinedLevelForSpecificAnnotation;
        this.f13506d = r8.j.a(new a());
        g0 g0Var2 = g0.IGNORE;
        this.f13507e = globalLevel == g0Var2 && g0Var == g0Var2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f13503a == zVar.f13503a && this.f13504b == zVar.f13504b && kotlin.jvm.internal.m.a(this.f13505c, zVar.f13505c);
    }

    public final g0 a() {
        return this.f13503a;
    }

    public final g0 b() {
        return this.f13504b;
    }

    public final Map<ba.c, g0> c() {
        return this.f13505c;
    }

    public final boolean d() {
        return this.f13507e;
    }

    public int hashCode() {
        int iHashCode = this.f13503a.hashCode() * 31;
        g0 g0Var = this.f13504b;
        return ((iHashCode + (g0Var == null ? 0 : g0Var.hashCode())) * 31) + this.f13505c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f13503a + ", migrationLevel=" + this.f13504b + ", userDefinedLevelForSpecificAnnotation=" + this.f13505c + ')';
    }

    public /* synthetic */ z(g0 g0Var, g0 g0Var2, Map map, int i10, kotlin.jvm.internal.g gVar) {
        this(g0Var, (i10 & 2) != 0 ? null : g0Var2, (i10 & 4) != 0 ? n0.i() : map);
    }
}
