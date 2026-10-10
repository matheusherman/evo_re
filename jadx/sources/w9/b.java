package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f20100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f20101b = new a();
    private List<C0384b> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new b(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: renamed from: w9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0384b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0384b f20102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<C0384b> f20103b = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private c value_;

        /* JADX INFO: renamed from: w9.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<C0384b> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public C0384b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                return new C0384b(eVar, gVar, null);
            }

            a() {
            }
        }

        /* JADX INFO: renamed from: w9.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0385b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<C0384b, C0385b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f20104b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f20105c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private c f20106d = c.K();

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public C0385b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
                C0384b c0384b = null;
                try {
                    try {
                        C0384b c0384bB = C0384b.f20103b.b(eVar, gVar);
                        if (c0384bB != null) {
                            m(c0384bB);
                        }
                        return this;
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                        C0384b c0384b2 = (C0384b) e10.a();
                        try {
                            throw e10;
                        } catch (Throwable th) {
                            th = th;
                            c0384b = c0384b2;
                            if (c0384b != null) {
                                m(c0384b);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0384b != null) {
                        m(c0384b);
                    }
                    throw th;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0385b t() {
                return new C0385b();
            }

            public C0384b q() {
                C0384b c0384b = new C0384b(this, (w9.a) null);
                int i10 = this.f20104b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                c0384b.nameId_ = this.f20105c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                c0384b.value_ = this.f20106d;
                c0384b.bitField0_ = i11;
                return c0384b;
            }

            public C0385b y(c cVar) {
                if ((this.f20104b & 2) != 2 || this.f20106d == c.K()) {
                    this.f20106d = cVar;
                } else {
                    this.f20106d = c.f0(this.f20106d).m(cVar).q();
                }
                this.f20104b |= 2;
                return this;
            }

            public C0385b z(int i10) {
                this.f20104b |= 1;
                this.f20105c = i10;
                return this;
            }

            private C0385b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public C0384b build() {
                C0384b c0384bQ = q();
                if (c0384bQ.isInitialized()) {
                    return c0384bQ;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(c0384bQ);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public C0385b k() {
                return t().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public C0385b m(C0384b c0384b) {
                if (c0384b == C0384b.u()) {
                    return this;
                }
                if (c0384b.x()) {
                    z(c0384b.v());
                }
                if (c0384b.y()) {
                    y(c0384b.w());
                }
                n(l().f(c0384b.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        /* JADX INFO: renamed from: w9.b$b$c */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final c f20107a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f20108b = new a();
            private b annotation_;
            private int arrayDimensionCount_;
            private List<c> arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private EnumC0387c type_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* JADX INFO: renamed from: w9.b$b$c$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                    return new c(eVar, gVar, null);
                }

                a() {
                }
            }

            /* JADX INFO: renamed from: w9.b$b$c$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            public static final class C0386b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<c, C0386b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private int f20109b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private long f20111d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private float f20112e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private double f20113f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private int f20114g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private int f20115h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private int f20116i;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                private int f20119l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                private int f20120m;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private EnumC0387c f20110c = EnumC0387c.BYTE;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private b f20117j = b.y();

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private List<c> f20118k = Collections.EMPTY_LIST;

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
                /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
                public C0386b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c cVarB = c.f20108b.b(eVar, gVar);
                            if (cVarB != null) {
                                m(cVarB);
                            }
                            return this;
                        } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                            c cVar2 = (c) e10.a();
                            try {
                                throw e10;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                if (cVar != null) {
                                    m(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cVar != null) {
                            m(cVar);
                        }
                        throw th;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static C0386b t() {
                    return new C0386b();
                }

                private void u() {
                    if ((this.f20109b & 256) != 256) {
                        this.f20118k = new ArrayList(this.f20118k);
                        this.f20109b |= 256;
                    }
                }

                public C0386b A(int i10) {
                    this.f20109b |= 512;
                    this.f20119l = i10;
                    return this;
                }

                public C0386b C(int i10) {
                    this.f20109b |= 32;
                    this.f20115h = i10;
                    return this;
                }

                public C0386b D(double d10) {
                    this.f20109b |= 8;
                    this.f20113f = d10;
                    return this;
                }

                public C0386b E(int i10) {
                    this.f20109b |= 64;
                    this.f20116i = i10;
                    return this;
                }

                public C0386b F(int i10) {
                    this.f20109b |= 1024;
                    this.f20120m = i10;
                    return this;
                }

                public C0386b G(float f10) {
                    this.f20109b |= 4;
                    this.f20112e = f10;
                    return this;
                }

                public C0386b H(long j10) {
                    this.f20109b |= 2;
                    this.f20111d = j10;
                    return this;
                }

                public C0386b I(int i10) {
                    this.f20109b |= 16;
                    this.f20114g = i10;
                    return this;
                }

                public c q() {
                    c cVar = new c(this, (w9.a) null);
                    int i10 = this.f20109b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.type_ = this.f20110c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.intValue_ = this.f20111d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.floatValue_ = this.f20112e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.doubleValue_ = this.f20113f;
                    if ((i10 & 16) == 16) {
                        i11 |= 16;
                    }
                    cVar.stringValue_ = this.f20114g;
                    if ((i10 & 32) == 32) {
                        i11 |= 32;
                    }
                    cVar.classId_ = this.f20115h;
                    if ((i10 & 64) == 64) {
                        i11 |= 64;
                    }
                    cVar.enumValueId_ = this.f20116i;
                    if ((i10 & 128) == 128) {
                        i11 |= 128;
                    }
                    cVar.annotation_ = this.f20117j;
                    if ((this.f20109b & 256) == 256) {
                        this.f20118k = Collections.unmodifiableList(this.f20118k);
                        this.f20109b &= -257;
                    }
                    cVar.arrayElement_ = this.f20118k;
                    if ((i10 & 512) == 512) {
                        i11 |= 256;
                    }
                    cVar.arrayDimensionCount_ = this.f20119l;
                    if ((i10 & 1024) == 1024) {
                        i11 |= 512;
                    }
                    cVar.flags_ = this.f20120m;
                    cVar.bitField0_ = i11;
                    return cVar;
                }

                public C0386b x(b bVar) {
                    if ((this.f20109b & 128) != 128 || this.f20117j == b.y()) {
                        this.f20117j = bVar;
                    } else {
                        this.f20117j = b.D(this.f20117j).m(bVar).q();
                    }
                    this.f20109b |= 128;
                    return this;
                }

                private C0386b() {
                    v();
                }

                public C0386b K(EnumC0387c enumC0387c) {
                    enumC0387c.getClass();
                    this.f20109b |= 1;
                    this.f20110c = enumC0387c;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
                /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c cVarQ = q();
                    if (cVarQ.isInitialized()) {
                        return cVarQ;
                    }
                    throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(cVarQ);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
                public C0386b k() {
                    return t().m(q());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public C0386b m(c cVar) {
                    if (cVar == c.K()) {
                        return this;
                    }
                    if (cVar.c0()) {
                        K(cVar.S());
                    }
                    if (cVar.a0()) {
                        H(cVar.Q());
                    }
                    if (cVar.Z()) {
                        G(cVar.P());
                    }
                    if (cVar.W()) {
                        D(cVar.L());
                    }
                    if (cVar.b0()) {
                        I(cVar.R());
                    }
                    if (cVar.V()) {
                        C(cVar.J());
                    }
                    if (cVar.X()) {
                        E(cVar.N());
                    }
                    if (cVar.T()) {
                        x(cVar.E());
                    }
                    if (!cVar.arrayElement_.isEmpty()) {
                        if (this.f20118k.isEmpty()) {
                            this.f20118k = cVar.arrayElement_;
                            this.f20109b &= -257;
                        } else {
                            u();
                            this.f20118k.addAll(cVar.arrayElement_);
                        }
                    }
                    if (cVar.U()) {
                        A(cVar.F());
                    }
                    if (cVar.Y()) {
                        F(cVar.O());
                    }
                    n(l().f(cVar.unknownFields));
                    return this;
                }

                private void v() {
                }
            }

            /* JADX INFO: renamed from: w9.b$b$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            public enum EnumC0387c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);


                /* JADX INFO: renamed from: n, reason: collision with root package name */
                private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0387c> f20134n = new a();
                private final int value;

                /* JADX INFO: renamed from: w9.b$b$c$c$a */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0387c> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0387c a(int i10) {
                        return EnumC0387c.a(i10);
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
                public final int h() {
                    return this.value;
                }

                EnumC0387c(int i10, int i11) {
                    this.value = i11;
                }

                public static EnumC0387c a(int i10) {
                    switch (i10) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
                this(eVar, gVar);
            }

            static {
                c cVar = new c(true);
                f20107a = cVar;
                cVar.d0();
            }

            /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
                this(bVar);
            }

            public static c K() {
                return f20107a;
            }

            private void d0() {
                this.type_ = EnumC0387c.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = b.y();
                this.arrayElement_ = Collections.EMPTY_LIST;
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            public b E() {
                return this.annotation_;
            }

            public int F() {
                return this.arrayDimensionCount_;
            }

            public c G(int i10) {
                return this.arrayElement_.get(i10);
            }

            public int H() {
                return this.arrayElement_.size();
            }

            public List<c> I() {
                return this.arrayElement_;
            }

            public int J() {
                return this.classId_;
            }

            public double L() {
                return this.doubleValue_;
            }

            public int N() {
                return this.enumValueId_;
            }

            public int O() {
                return this.flags_;
            }

            public float P() {
                return this.floatValue_;
            }

            public long Q() {
                return this.intValue_;
            }

            public int R() {
                return this.stringValue_;
            }

            public EnumC0387c S() {
                return this.type_;
            }

            public boolean T() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean U() {
                return (this.bitField0_ & 256) == 256;
            }

            public boolean V() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean W() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean X() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean Y() {
                return (this.bitField0_ & 512) == 512;
            }

            public boolean Z() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean a0() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean b0() {
                return (this.bitField0_ & 16) == 16;
            }

            public boolean c0() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public int e() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iH = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.type_.h()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.A(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.l(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.f(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.annotation_);
                }
                for (int i11 = 0; i11 < this.arrayElement_.size(); i11++) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.s(9, this.arrayElement_.get(i11));
                }
                if ((this.bitField0_ & 512) == 512) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.arrayDimensionCount_);
                }
                int size = iH + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
            public kotlin.reflect.jvm.internal.impl.protobuf.s<c> h() {
                return f20108b;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
            public final boolean isInitialized() {
                byte b10 = this.memoizedIsInitialized;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (T() && !E().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i10 = 0; i10 < H(); i10++) {
                    if (!G(i10).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            private c(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.l();
            }

            public static C0386b e0() {
                return C0386b.t();
            }

            public static C0386b f0(c cVar) {
                return e0().m(cVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
                e();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.S(1, this.type_.h());
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.t0(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    fVar.W(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    fVar.Q(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    fVar.a0(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    fVar.a0(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    fVar.a0(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    fVar.d0(8, this.annotation_);
                }
                for (int i10 = 0; i10 < this.arrayElement_.size(); i10++) {
                    fVar.d0(9, this.arrayElement_.get(i10));
                }
                if ((this.bitField0_ & 512) == 512) {
                    fVar.a0(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    fVar.a0(11, this.arrayDimensionCount_);
                }
                fVar.i0(this.unknownFields);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
            public C0386b g() {
                return e0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
            public C0386b c() {
                return f0(this);
            }

            private c(boolean z10) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
            }

            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                d0();
                kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
                boolean z10 = false;
                char c10 = 0;
                while (!z10) {
                    try {
                        try {
                            try {
                                int iK = eVar.K();
                                switch (iK) {
                                    case 0:
                                        break;
                                    case 8:
                                        int iN = eVar.n();
                                        EnumC0387c enumC0387cA = EnumC0387c.a(iN);
                                        if (enumC0387cA == null) {
                                            fVarJ.o0(iK);
                                            fVarJ.o0(iN);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.type_ = enumC0387cA;
                                            continue;
                                        }
                                        break;
                                    case 16:
                                        this.bitField0_ |= 2;
                                        this.intValue_ = eVar.H();
                                        continue;
                                    case 29:
                                        this.bitField0_ |= 4;
                                        this.floatValue_ = eVar.q();
                                        continue;
                                    case 33:
                                        this.bitField0_ |= 8;
                                        this.doubleValue_ = eVar.m();
                                        continue;
                                    case 40:
                                        this.bitField0_ |= 16;
                                        this.stringValue_ = eVar.s();
                                        continue;
                                    case 48:
                                        this.bitField0_ |= 32;
                                        this.classId_ = eVar.s();
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 64;
                                        this.enumValueId_ = eVar.s();
                                        continue;
                                    case 66:
                                        c cVarC = (this.bitField0_ & 128) == 128 ? this.annotation_.c() : null;
                                        b bVar = (b) eVar.u(b.f20101b, gVar);
                                        this.annotation_ = bVar;
                                        if (cVarC != null) {
                                            cVarC.m(bVar);
                                            this.annotation_ = cVarC.q();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case 74:
                                        if ((c10 & 256) != 256) {
                                            this.arrayElement_ = new ArrayList();
                                            c10 = 256;
                                        }
                                        this.arrayElement_.add((c) eVar.u(f20108b, gVar));
                                        continue;
                                    case 80:
                                        this.bitField0_ |= 512;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 88:
                                        this.bitField0_ |= 256;
                                        this.arrayDimensionCount_ = eVar.s();
                                        continue;
                                    default:
                                        if (!o(eVar, fVarJ, gVar, iK)) {
                                            break;
                                        }
                                        break;
                                }
                                z10 = true;
                            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                                throw e10.i(this);
                            }
                        } catch (IOException e11) {
                            throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                        }
                    } catch (Throwable th) {
                        if ((c10 & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        }
                        try {
                            fVarJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.unknownFields = bVarU.f();
                        }
                        l();
                        throw th;
                    }
                }
                if ((c10 & 256) == 256) {
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                }
                try {
                    fVarJ.I();
                } catch (IOException unused2) {
                } finally {
                    this.unknownFields = bVarU.f();
                }
                l();
            }
        }

        /* synthetic */ C0384b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
            this(eVar, gVar);
        }

        private void z() {
            this.nameId_ = 0;
            this.value_ = c.K();
        }

        static {
            C0384b c0384b = new C0384b(true);
            f20102a = c0384b;
            c0384b.z();
        }

        /* synthetic */ C0384b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
            this(bVar);
        }

        public static C0384b u() {
            return f20102a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.nameId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.value_);
            }
            int size = iO + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<C0384b> h() {
            return f20103b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!x()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!y()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (w().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public int v() {
            return this.nameId_;
        }

        public c w() {
            return this.value_;
        }

        public boolean x() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean y() {
            return (this.bitField0_ & 2) == 2;
        }

        private C0384b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static C0385b A() {
            return C0385b.t();
        }

        public static C0385b B(C0384b c0384b) {
            return A().m(c0384b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public C0385b g() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0385b c() {
            return B(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(2, this.value_);
            }
            fVar.i0(this.unknownFields);
        }

        private C0384b(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private C0384b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            z();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = eVar.s();
                            } else if (iK != 18) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                c.C0386b c0386bC = (this.bitField0_ & 2) == 2 ? this.value_.c() : null;
                                c cVar = (c) eVar.u(c.f20108b, gVar);
                                this.value_ = cVar;
                                if (c0386bC != null) {
                                    c0386bC.m(cVar);
                                    this.value_ = c0386bC.q();
                                }
                                this.bitField0_ |= 2;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            fVarJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.unknownFields = bVarU.f();
                        }
                        l();
                        throw th;
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            }
            try {
                fVarJ.I();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarU.f();
            }
            l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<b, c> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<C0384b> f20138d = Collections.EMPTY_LIST;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public c i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            b bVar = null;
            try {
                try {
                    b bVarB = b.f20101b.b(eVar, gVar);
                    if (bVarB != null) {
                        m(bVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    b bVar2 = (b) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (bVar != null) {
                            m(bVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bVar != null) {
                    m(bVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c t() {
            return new c();
        }

        private void u() {
            if ((this.f20136b & 2) != 2) {
                this.f20138d = new ArrayList(this.f20138d);
                this.f20136b |= 2;
            }
        }

        public b q() {
            b bVar = new b(this, (w9.a) null);
            int i10 = (this.f20136b & 1) != 1 ? 0 : 1;
            bVar.id_ = this.f20137c;
            if ((this.f20136b & 2) == 2) {
                this.f20138d = Collections.unmodifiableList(this.f20138d);
                this.f20136b &= -3;
            }
            bVar.argument_ = this.f20138d;
            bVar.bitField0_ = i10;
            return bVar;
        }

        public c z(int i10) {
            this.f20136b |= 1;
            this.f20137c = i10;
            return this;
        }

        private c() {
            v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public b build() {
            b bVarQ = q();
            if (bVarQ.isInitialized()) {
                return bVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(bVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public c k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public c m(b bVar) {
            if (bVar == b.y()) {
                return this;
            }
            if (bVar.A()) {
                z(bVar.z());
            }
            if (!bVar.argument_.isEmpty()) {
                if (this.f20138d.isEmpty()) {
                    this.f20138d = bVar.argument_;
                    this.f20136b &= -3;
                } else {
                    u();
                    this.f20138d.addAll(bVar.argument_);
                }
            }
            n(l().f(bVar.unknownFields));
            return this;
        }

        private void v() {
        }
    }

    /* synthetic */ b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void B() {
        this.id_ = 0;
        this.argument_ = Collections.EMPTY_LIST;
    }

    static {
        b bVar = new b(true);
        f20100a = bVar;
        bVar.B();
    }

    /* synthetic */ b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    public static b y() {
        return f20100a;
    }

    public boolean A() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.id_) : 0;
        for (int i11 = 0; i11 < this.argument_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.argument_.get(i11));
        }
        int size = iO + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<b> h() {
        return f20101b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean isInitialized() {
        byte b10 = this.memoizedIsInitialized;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!A()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < w(); i10++) {
            if (!v(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public C0384b v(int i10) {
        return this.argument_.get(i10);
    }

    public int w() {
        return this.argument_.size();
    }

    public List<C0384b> x() {
        return this.argument_;
    }

    public int z() {
        return this.id_;
    }

    private b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static c C() {
        return c.t();
    }

    public static c D(b bVar) {
        return C().m(bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c g() {
        return C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public c c() {
        return D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.id_);
        }
        for (int i10 = 0; i10 < this.argument_.size(); i10++) {
            fVar.d0(2, this.argument_.get(i10));
        }
        fVar.i0(this.unknownFields);
    }

    private b(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        B();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = eVar.s();
                        } else if (iK != 18) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            if ((c10 & 2) != 2) {
                                this.argument_ = new ArrayList();
                                c10 = 2;
                            }
                            this.argument_.add((C0384b) eVar.u(C0384b.f20103b, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        fVarJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarU.f();
                    }
                    l();
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
        if ((c10 & 2) == 2) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
        }
        try {
            fVarJ.I();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarU.f();
        }
        l();
    }
}
