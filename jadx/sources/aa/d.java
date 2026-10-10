package aa;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f173b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f172a, aVar.f172a) && m.a(this.f173b, aVar.f173b);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name, String desc) {
            super(null);
            m.f(name, "name");
            m.f(desc, "desc");
            this.f172a = name;
            this.f173b = desc;
        }

        @Override // aa.d
        public String a() {
            return c() + ':' + b();
        }

        @Override // aa.d
        public String b() {
            return this.f173b;
        }

        @Override // aa.d
        public String c() {
            return this.f172a;
        }

        public final String d() {
            return this.f172a;
        }

        public final String e() {
            return this.f173b;
        }

        public int hashCode() {
            return (this.f172a.hashCode() * 31) + this.f173b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f175b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(this.f174a, bVar.f174a) && m.a(this.f175b, bVar.f175b);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name, String desc) {
            super(null);
            m.f(name, "name");
            m.f(desc, "desc");
            this.f174a = name;
            this.f175b = desc;
        }

        @Override // aa.d
        public String a() {
            return c() + b();
        }

        @Override // aa.d
        public String b() {
            return this.f175b;
        }

        @Override // aa.d
        public String c() {
            return this.f174a;
        }

        public int hashCode() {
            return (this.f174a.hashCode() * 31) + this.f175b.hashCode();
        }
    }

    public /* synthetic */ d(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    private d() {
    }

    public final String toString() {
        return a();
    }
}
