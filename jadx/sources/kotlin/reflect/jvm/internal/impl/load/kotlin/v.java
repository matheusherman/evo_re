package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13620b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13621a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final v a(String name, String desc) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(desc, "desc");
            return new v(name + '#' + desc, null);
        }

        public final v b(aa.d signature) {
            kotlin.jvm.internal.m.f(signature, "signature");
            if (signature instanceof aa.d.b) {
                return d(signature.c(), signature.b());
            }
            if (signature instanceof aa.d.a) {
                return a(signature.c(), signature.b());
            }
            throw new r8.n();
        }

        public final v c(y9.c nameResolver, z9.a.c signature) {
            kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.m.f(signature, "signature");
            return d(nameResolver.getString(signature.w()), nameResolver.getString(signature.v()));
        }

        public final v d(String name, String desc) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(desc, "desc");
            return new v(name + desc, null);
        }

        public final v e(v signature, int i10) {
            kotlin.jvm.internal.m.f(signature, "signature");
            return new v(signature.a() + '@' + i10, null);
        }
    }

    public /* synthetic */ v(String str, kotlin.jvm.internal.g gVar) {
        this(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && kotlin.jvm.internal.m.a(this.f13621a, ((v) obj).f13621a);
    }

    private v(String str) {
        this.f13621a = str;
    }

    public final String a() {
        return this.f13621a;
    }

    public int hashCode() {
        return this.f13621a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f13621a + ')';
    }
}
