package m9;

import ba.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import ua.n;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f15686b = new c("Function", 0, k.f12593v, "Function", false, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f15687c = new c("SuspendFunction", 1, k.f12585n, "SuspendFunction", true, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f15688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f15689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ c[] f15690f;
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    private final ba.c packageFqName;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: m9.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0303a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f15691a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f15692b;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0303a)) {
                    return false;
                }
                C0303a c0303a = (C0303a) obj;
                return this.f15691a == c0303a.f15691a && this.f15692b == c0303a.f15692b;
            }

            public C0303a(c kind, int i10) {
                m.f(kind, "kind");
                this.f15691a = kind;
                this.f15692b = i10;
            }

            public final c a() {
                return this.f15691a;
            }

            public final int b() {
                return this.f15692b;
            }

            public final c c() {
                return this.f15691a;
            }

            public int hashCode() {
                return (this.f15691a.hashCode() * 31) + this.f15692b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.f15691a + ", arity=" + this.f15692b + ')';
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }

        public final c a(ba.c packageFqName, String className) {
            m.f(packageFqName, "packageFqName");
            m.f(className, "className");
            for (c cVar : c.values()) {
                if (m.a(cVar.i(), packageFqName) && n.I(className, cVar.f(), false, 2, null)) {
                    return cVar;
                }
            }
            return null;
        }

        public final c b(String className, ba.c packageFqName) {
            m.f(className, "className");
            m.f(packageFqName, "packageFqName");
            C0303a c0303aC = c(className, packageFqName);
            if (c0303aC != null) {
                return c0303aC.c();
            }
            return null;
        }

        public final C0303a c(String className, ba.c packageFqName) {
            m.f(className, "className");
            m.f(packageFqName, "packageFqName");
            c cVarA = a(packageFqName, className);
            if (cVarA == null) {
                return null;
            }
            String strSubstring = className.substring(cVarA.f().length());
            m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            Integer numD = d(strSubstring);
            if (numD != null) {
                return new C0303a(cVarA, numD.intValue());
            }
            return null;
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                int iCharAt = str.charAt(i11) - '0';
                if (iCharAt < 0 || iCharAt >= 10) {
                    return null;
                }
                i10 = (i10 * 10) + iCharAt;
            }
            return Integer.valueOf(i10);
        }
    }

    private static final /* synthetic */ c[] a() {
        return new c[]{f15686b, f15687c, f15688d, f15689e};
    }

    static {
        ba.c cVar = k.f12590s;
        f15688d = new c("KFunction", 2, cVar, "KFunction", false, true);
        f15689e = new c("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        f15690f = a();
        f15685a = new a(null);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f15690f.clone();
    }

    public final String f() {
        return this.classNamePrefix;
    }

    public final ba.c i() {
        return this.packageFqName;
    }

    public final f j(int i10) {
        f fVarL = f.l(this.classNamePrefix + i10);
        m.e(fVarL, "identifier(\"$classNamePrefix$arity\")");
        return fVarL;
    }

    private c(String str, int i10, ba.c cVar, String str2, boolean z10, boolean z11) {
        super(str, i10);
        this.packageFqName = cVar;
        this.classNamePrefix = str2;
        this.isSuspendType = z10;
        this.isReflectType = z11;
    }
}
