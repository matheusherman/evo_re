package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f13744a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f13745b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f13746c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f13747d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f13749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f13750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f13751d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f13752e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f13753f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f13754g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f13755h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f13756i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f13757j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f13758k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f13759l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f13760m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f13761n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f13762o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f13763p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f13764q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f13765r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final /* synthetic */ b[] f13766s;
        private final c javaType;
        private final int wireType;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static enum a extends b {
            a(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.z.b
            public boolean i() {
                return false;
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.z$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static enum C0246b extends b {
            C0246b(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.z.b
            public boolean i() {
                return false;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static enum c extends b {
            c(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.z.b
            public boolean i() {
                return false;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static enum d extends b {
            d(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.z.b
            public boolean i() {
                return false;
            }
        }

        public boolean i() {
            return true;
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f13748a = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f13749b = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f13750c = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f13751d = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f13752e = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f13753f = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f13754g = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f13755h = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f13756i = aVar;
            c cVar3 = c.MESSAGE;
            C0246b c0246b = new C0246b("GROUP", 9, cVar3, 3);
            f13757j = c0246b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f13758k = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f13759l = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f13760m = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f13761n = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f13762o = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f13763p = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f13764q = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f13765r = bVar14;
            f13766s = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0246b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        private b(String str, int i10, c cVar, int i11) {
            super(str, i10);
            this.javaType = cVar;
            this.wireType = i11;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f13766s.clone();
        }

        public c a() {
            return this.javaType;
        }

        public int f() {
            return this.wireType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(d.f13632a),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        c(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public static int a(int i10) {
        return i10 >>> 3;
    }

    static int b(int i10) {
        return i10 & 7;
    }

    static int c(int i10, int i11) {
        return (i10 << 3) | i11;
    }
}
