package w9;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class v extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v f20368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<v> f20369b = new a();
    private int bitField0_;
    private int errorCode_;
    private c level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private int versionFull_;
    private d versionKind_;
    private int version_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<v> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public v b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new v(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<v, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20372d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20375g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f20373e = c.ERROR;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d f20376h = d.LANGUAGE_VERSION;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            v vVar = null;
            try {
                try {
                    v vVarB = v.f20369b.b(eVar, gVar);
                    if (vVarB != null) {
                        m(vVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    v vVar2 = (v) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        vVar = vVar2;
                        if (vVar != null) {
                            m(vVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (vVar != null) {
                    m(vVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        public b A(int i10) {
            this.f20370b |= 16;
            this.f20375g = i10;
            return this;
        }

        public b C(int i10) {
            this.f20370b |= 1;
            this.f20371c = i10;
            return this;
        }

        public b D(int i10) {
            this.f20370b |= 2;
            this.f20372d = i10;
            return this;
        }

        public v q() {
            v vVar = new v(this, (w9.a) null);
            int i10 = this.f20370b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            vVar.version_ = this.f20371c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            vVar.versionFull_ = this.f20372d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            vVar.level_ = this.f20373e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            vVar.errorCode_ = this.f20374f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            vVar.message_ = this.f20375g;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            vVar.versionKind_ = this.f20376h;
            vVar.bitField0_ = i11;
            return vVar;
        }

        public b y(int i10) {
            this.f20370b |= 8;
            this.f20374f = i10;
            return this;
        }

        private b() {
            u();
        }

        public b E(d dVar) {
            dVar.getClass();
            this.f20370b |= 32;
            this.f20376h = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public v build() {
            v vVarQ = q();
            if (vVarQ.isInitialized()) {
                return vVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(vVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b m(v vVar) {
            if (vVar == v.y()) {
                return this;
            }
            if (vVar.I()) {
                C(vVar.C());
            }
            if (vVar.J()) {
                D(vVar.D());
            }
            if (vVar.G()) {
                z(vVar.A());
            }
            if (vVar.F()) {
                y(vVar.z());
            }
            if (vVar.H()) {
                A(vVar.B());
            }
            if (vVar.K()) {
                E(vVar.E());
            }
            n(l().f(vVar.unknownFields));
            return this;
        }

        public b z(c cVar) {
            cVar.getClass();
            this.f20370b |= 4;
            this.f20373e = cVar;
            return this;
        }

        private void u() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> f20380d = new a();
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.a(i10);
            }
        }

        public static c a(int i10) {
            if (i10 == 0) {
                return WARNING;
            }
            if (i10 == 1) {
                return ERROR;
            }
            if (i10 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        c(int i10, int i11) {
            this.value = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum d implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<d> f20385d = new a();
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.a(i10);
            }
        }

        public static d a(int i10) {
            if (i10 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i10 == 1) {
                return COMPILER_VERSION;
            }
            if (i10 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        d(int i10, int i11) {
            this.value = i11;
        }
    }

    /* synthetic */ v(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void L() {
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = c.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = d.LANGUAGE_VERSION;
    }

    static {
        v vVar = new v(true);
        f20368a = vVar;
        vVar.L();
    }

    /* synthetic */ v(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    public static v y() {
        return f20368a;
    }

    public c A() {
        return this.level_;
    }

    public int B() {
        return this.message_;
    }

    public int C() {
        return this.version_;
    }

    public int D() {
        return this.versionFull_;
    }

    public d E() {
        return this.versionKind_;
    }

    public boolean F() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean G() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean H() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean I() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean J() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean K() {
        return (this.bitField0_ & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.version_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.level_.h());
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.h(6, this.versionKind_.h());
        }
        int size = iO + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<v> h() {
        return f20369b;
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public int z() {
        return this.errorCode_;
    }

    private v(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b N() {
        return b.t();
    }

    public static b O(v vVar) {
        return N().m(vVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public b g() {
        return N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b c() {
        return O(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.S(3, this.level_.h());
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.a0(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.a0(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.S(6, this.versionKind_.h());
        }
        fVar.i0(this.unknownFields);
    }

    private v(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private v(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        L();
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
                            this.version_ = eVar.s();
                        } else if (iK == 16) {
                            this.bitField0_ |= 2;
                            this.versionFull_ = eVar.s();
                        } else if (iK == 24) {
                            int iN = eVar.n();
                            c cVarA = c.a(iN);
                            if (cVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN);
                            } else {
                                this.bitField0_ |= 4;
                                this.level_ = cVarA;
                            }
                        } else if (iK == 32) {
                            this.bitField0_ |= 8;
                            this.errorCode_ = eVar.s();
                        } else if (iK == 40) {
                            this.bitField0_ |= 16;
                            this.message_ = eVar.s();
                        } else if (iK != 48) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            int iN2 = eVar.n();
                            d dVarA = d.a(iN2);
                            if (dVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN2);
                            } else {
                                this.bitField0_ |= 32;
                                this.versionKind_ = dVarA;
                            }
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
