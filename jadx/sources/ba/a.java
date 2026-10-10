package ba;

import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final C0031a f917e = new C0031a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f f918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c f919g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f923d;

    /* JADX INFO: renamed from: ba.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0031a {
        public /* synthetic */ C0031a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private C0031a() {
        }
    }

    public a(c packageName, c cVar, f callableName, c cVar2) {
        m.f(packageName, "packageName");
        m.f(callableName, "callableName");
        this.f920a = packageName;
        this.f921b = cVar;
        this.f922c = callableName;
        this.f923d = cVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.f920a, aVar.f920a) && m.a(this.f921b, aVar.f921b) && m.a(this.f922c, aVar.f922c) && m.a(this.f923d, aVar.f923d);
    }

    static {
        f fVar = h.f954m;
        f918f = fVar;
        c cVarK = c.k(fVar);
        m.e(cVarK, "topLevel(LOCAL_NAME)");
        f919g = cVarK;
    }

    public int hashCode() {
        int iHashCode = this.f920a.hashCode() * 31;
        c cVar = this.f921b;
        int iHashCode2 = (((iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f922c.hashCode()) * 31;
        c cVar2 = this.f923d;
        return iHashCode2 + (cVar2 != null ? cVar2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String strB = this.f920a.b();
        m.e(strB, "packageName.asString()");
        sb2.append(n.D(strB, '.', '/', false, 4, null));
        sb2.append("/");
        c cVar = this.f921b;
        if (cVar != null) {
            sb2.append(cVar);
            sb2.append(".");
        }
        sb2.append(this.f922c);
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public /* synthetic */ a(c cVar, c cVar2, f fVar, c cVar3, int i10, kotlin.jvm.internal.g gVar) {
        this(cVar, cVar2, fVar, (i10 & 8) != 0 ? null : cVar3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c packageName, f callableName) {
        this(packageName, null, callableName, null, 8, null);
        m.f(packageName, "packageName");
        m.f(callableName, "callableName");
    }
}
