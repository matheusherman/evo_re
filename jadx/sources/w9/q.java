package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class q extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<q> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q f20299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<q> f20300b = new a();
    private int abbreviatedTypeId_;
    private q abbreviatedType_;
    private List<b> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private q flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private q outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<q> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public q b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new q(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f20301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f20302b = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c projection_;
        private int typeId_;
        private q type_;
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

        /* JADX INFO: renamed from: w9.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0390b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<b, C0390b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f20303b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private c f20304c = c.INV;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private q f20305d = q.X();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f20306e;

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public C0390b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarB = b.f20302b.b(eVar, gVar);
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
            public static C0390b t() {
                return new C0390b();
            }

            public C0390b A(int i10) {
                this.f20303b |= 4;
                this.f20306e = i10;
                return this;
            }

            public b q() {
                b bVar = new b(this, (w9.a) null);
                int i10 = this.f20303b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.projection_ = this.f20304c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.type_ = this.f20305d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                bVar.typeId_ = this.f20306e;
                bVar.bitField0_ = i11;
                return bVar;
            }

            public C0390b y(q qVar) {
                if ((this.f20303b & 2) != 2 || this.f20305d == q.X()) {
                    this.f20305d = qVar;
                } else {
                    this.f20305d = q.y0(this.f20305d).m(qVar).v();
                }
                this.f20303b |= 2;
                return this;
            }

            private C0390b() {
                u();
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
            public C0390b k() {
                return t().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public C0390b m(b bVar) {
                if (bVar == b.v()) {
                    return this;
                }
                if (bVar.z()) {
                    z(bVar.w());
                }
                if (bVar.A()) {
                    y(bVar.x());
                }
                if (bVar.B()) {
                    A(bVar.y());
                }
                n(l().f(bVar.unknownFields));
                return this;
            }

            public C0390b z(c cVar) {
                cVar.getClass();
                this.f20303b |= 1;
                this.f20304c = cVar;
                return this;
            }

            private void u() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public enum c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> f20311e = new a();
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
                    return IN;
                }
                if (i10 == 1) {
                    return OUT;
                }
                if (i10 == 2) {
                    return INV;
                }
                if (i10 != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
            public final int h() {
                return this.value;
            }

            c(int i10, int i11) {
                this.value = i11;
            }
        }

        /* synthetic */ b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
            this(eVar, gVar);
        }

        static {
            b bVar = new b(true);
            f20301a = bVar;
            bVar.C();
        }

        /* synthetic */ b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
            this(bVar);
        }

        private void C() {
            this.projection_ = c.INV;
            this.type_ = q.X();
            this.typeId_ = 0;
        }

        public static b v() {
            return f20301a;
        }

        public boolean A() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean B() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iH = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.projection_.h()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iH += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iH += kotlin.reflect.jvm.internal.impl.protobuf.f.o(3, this.typeId_);
            }
            int size = iH + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<b> h() {
            return f20302b;
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
            if (!A() || x().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public c w() {
            return this.projection_;
        }

        public q x() {
            return this.type_;
        }

        public int y() {
            return this.typeId_;
        }

        public boolean z() {
            return (this.bitField0_ & 1) == 1;
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static C0390b D() {
            return C0390b.t();
        }

        public static C0390b E(b bVar) {
            return D().m(bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public C0390b g() {
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0390b c() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.S(1, this.projection_.h());
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.a0(3, this.typeId_);
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
            C();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    int iN = eVar.n();
                                    c cVarA = c.a(iN);
                                    if (cVarA == null) {
                                        fVarJ.o0(iK);
                                        fVarJ.o0(iN);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.projection_ = cVarA;
                                    }
                                } else if (iK == 18) {
                                    c cVarC = (this.bitField0_ & 2) == 2 ? this.type_.c() : null;
                                    q qVar = (q) eVar.u(q.f20300b, gVar);
                                    this.type_ = qVar;
                                    if (cVarC != null) {
                                        cVarC.m(qVar);
                                        this.type_ = cVarC.v();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (iK != 24) {
                                    if (!o(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = eVar.s();
                                }
                            }
                            z10 = true;
                        } catch (IOException e10) {
                            throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                        throw e11.i(this);
                    }
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
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<q, c> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20313d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f20315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20316g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20318i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20319j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20320k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20321l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f20322m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f20324o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f20326q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f20327r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<b> f20314e = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private q f20317h = q.X();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private q f20323n = q.X();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private q f20325p = q.X();

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            q qVar = null;
            try {
                try {
                    q qVarB = q.f20300b.b(eVar, gVar);
                    if (qVarB != null) {
                        m(qVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    q qVar2 = (q) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        qVar = qVar2;
                        if (qVar != null) {
                            m(qVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (qVar != null) {
                    m(qVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c y() {
            return new c();
        }

        private void z() {
            if ((this.f20313d & 1) != 1) {
                this.f20314e = new ArrayList(this.f20314e);
                this.f20313d |= 1;
            }
        }

        public c C(q qVar) {
            if ((this.f20313d & 2048) != 2048 || this.f20325p == q.X()) {
                this.f20325p = qVar;
            } else {
                this.f20325p = q.y0(this.f20325p).m(qVar).v();
            }
            this.f20313d |= 2048;
            return this;
        }

        public c D(q qVar) {
            if ((this.f20313d & 8) != 8 || this.f20317h == q.X()) {
                this.f20317h = qVar;
            } else {
                this.f20317h = q.y0(this.f20317h).m(qVar).v();
            }
            this.f20313d |= 8;
            return this;
        }

        public c G(q qVar) {
            if ((this.f20313d & 512) != 512 || this.f20323n == q.X()) {
                this.f20323n = qVar;
            } else {
                this.f20323n = q.y0(this.f20323n).m(qVar).v();
            }
            this.f20313d |= 512;
            return this;
        }

        public c H(int i10) {
            this.f20313d |= 4096;
            this.f20326q = i10;
            return this;
        }

        public c I(int i10) {
            this.f20313d |= 32;
            this.f20319j = i10;
            return this;
        }

        public c K(int i10) {
            this.f20313d |= 8192;
            this.f20327r = i10;
            return this;
        }

        public c L(int i10) {
            this.f20313d |= 4;
            this.f20316g = i10;
            return this;
        }

        public c N(int i10) {
            this.f20313d |= 16;
            this.f20318i = i10;
            return this;
        }

        public c O(boolean z10) {
            this.f20313d |= 2;
            this.f20315f = z10;
            return this;
        }

        public c Q(int i10) {
            this.f20313d |= 1024;
            this.f20324o = i10;
            return this;
        }

        public c R(int i10) {
            this.f20313d |= 256;
            this.f20322m = i10;
            return this;
        }

        public c T(int i10) {
            this.f20313d |= 64;
            this.f20320k = i10;
            return this;
        }

        public c U(int i10) {
            this.f20313d |= 128;
            this.f20321l = i10;
            return this;
        }

        public q v() {
            q qVar = new q(this, (w9.a) null);
            int i10 = this.f20313d;
            if ((i10 & 1) == 1) {
                this.f20314e = Collections.unmodifiableList(this.f20314e);
                this.f20313d &= -2;
            }
            qVar.argument_ = this.f20314e;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            qVar.nullable_ = this.f20315f;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            qVar.flexibleTypeCapabilitiesId_ = this.f20316g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            qVar.flexibleUpperBound_ = this.f20317h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            qVar.flexibleUpperBoundId_ = this.f20318i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            qVar.className_ = this.f20319j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            qVar.typeParameter_ = this.f20320k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            qVar.typeParameterName_ = this.f20321l;
            if ((i10 & 256) == 256) {
                i11 |= 128;
            }
            qVar.typeAliasName_ = this.f20322m;
            if ((i10 & 512) == 512) {
                i11 |= 256;
            }
            qVar.outerType_ = this.f20323n;
            if ((i10 & 1024) == 1024) {
                i11 |= 512;
            }
            qVar.outerTypeId_ = this.f20324o;
            if ((i10 & 2048) == 2048) {
                i11 |= 1024;
            }
            qVar.abbreviatedType_ = this.f20325p;
            if ((i10 & 4096) == 4096) {
                i11 |= 2048;
            }
            qVar.abbreviatedTypeId_ = this.f20326q;
            if ((i10 & 8192) == 8192) {
                i11 |= 4096;
            }
            qVar.flags_ = this.f20327r;
            qVar.bitField0_ = i11;
            return qVar;
        }

        private c() {
            A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c m(q qVar) {
            if (qVar == q.X()) {
                return this;
            }
            if (!qVar.argument_.isEmpty()) {
                if (this.f20314e.isEmpty()) {
                    this.f20314e = qVar.argument_;
                    this.f20313d &= -2;
                } else {
                    z();
                    this.f20314e.addAll(qVar.argument_);
                }
            }
            if (qVar.q0()) {
                O(qVar.d0());
            }
            if (qVar.n0()) {
                L(qVar.a0());
            }
            if (qVar.o0()) {
                D(qVar.b0());
            }
            if (qVar.p0()) {
                N(qVar.c0());
            }
            if (qVar.l0()) {
                I(qVar.W());
            }
            if (qVar.u0()) {
                T(qVar.h0());
            }
            if (qVar.v0()) {
                U(qVar.i0());
            }
            if (qVar.t0()) {
                R(qVar.g0());
            }
            if (qVar.r0()) {
                G(qVar.e0());
            }
            if (qVar.s0()) {
                Q(qVar.f0());
            }
            if (qVar.j0()) {
                C(qVar.R());
            }
            if (qVar.k0()) {
                H(qVar.S());
            }
            if (qVar.m0()) {
                K(qVar.Z());
            }
            s(qVar);
            n(l().f(qVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public q build() {
            q qVarV = v();
            if (qVarV.isInitialized()) {
                return qVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(qVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public c k() {
            return y().m(v());
        }

        private void A() {
        }
    }

    /* synthetic */ q(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        q qVar = new q(true);
        f20299a = qVar;
        qVar.w0();
    }

    /* synthetic */ q(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<q, ?>) cVar);
    }

    public static q X() {
        return f20299a;
    }

    private void w0() {
        this.argument_ = Collections.EMPTY_LIST;
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = X();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = X();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = X();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public q R() {
        return this.abbreviatedType_;
    }

    public int S() {
        return this.abbreviatedTypeId_;
    }

    public b T(int i10) {
        return this.argument_.get(i10);
    }

    public int U() {
        return this.argument_.size();
    }

    public List<b> V() {
        return this.argument_;
    }

    public int W() {
        return this.className_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public q a() {
        return f20299a;
    }

    public int Z() {
        return this.flags_;
    }

    public int a0() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public q b0() {
        return this.flexibleUpperBound_;
    }

    public int c0() {
        return this.flexibleUpperBoundId_;
    }

    public boolean d0() {
        return this.nullable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 4096) == 4096 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.flags_) : 0;
        for (int i11 = 0; i11 < this.argument_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.argument_.get(i11));
        }
        if ((this.bitField0_ & 1) == 1) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.a(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(14, this.abbreviatedTypeId_);
        }
        int iS = iO + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS;
        return iS;
    }

    public q e0() {
        return this.outerType_;
    }

    public int f0() {
        return this.outerTypeId_;
    }

    public int g0() {
        return this.typeAliasName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<q> h() {
        return f20300b;
    }

    public int h0() {
        return this.typeParameter_;
    }

    public int i0() {
        return this.typeParameterName_;
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
        for (int i10 = 0; i10 < U(); i10++) {
            if (!T(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (o0() && !b0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (r0() && !e0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (j0() && !R().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (r()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    public boolean j0() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean k0() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean l0() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean m0() {
        return (this.bitField0_ & 4096) == 4096;
    }

    public boolean n0() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean o0() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean p0() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean q0() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean r0() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean s0() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean t0() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean u0() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean v0() {
        return (this.bitField0_ & 64) == 64;
    }

    private q(kotlin.reflect.jvm.internal.impl.protobuf.i.c<q, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static c x0() {
        return c.y();
    }

    public static c y0(q qVar) {
        return x0().m(qVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public c c() {
        return y0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 4096) == 4096) {
            fVar.a0(1, this.flags_);
        }
        for (int i10 = 0; i10 < this.argument_.size(); i10++) {
            fVar.d0(2, this.argument_.get(i10));
        }
        if ((this.bitField0_ & 1) == 1) {
            fVar.L(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.d0(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.a0(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.a0(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.a0(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            fVar.a0(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            fVar.d0(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            fVar.a0(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            fVar.a0(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            fVar.d0(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            fVar.a0(14, this.abbreviatedTypeId_);
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public c g() {
        return x0();
    }

    private q(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private q(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        c cVarC;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        w0();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = eVar.s();
                                continue;
                            case 18:
                                if (!z11) {
                                    this.argument_ = new ArrayList();
                                    z11 = true;
                                }
                                this.argument_.add((b) eVar.u(b.f20302b, gVar));
                                continue;
                            case 24:
                                this.bitField0_ |= 1;
                                this.nullable_ = eVar.k();
                                continue;
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = eVar.s();
                                continue;
                            case 42:
                                cVarC = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.c() : null;
                                q qVar = (q) eVar.u(f20300b, gVar);
                                this.flexibleUpperBound_ = qVar;
                                if (cVarC != null) {
                                    cVarC.m(qVar);
                                    this.flexibleUpperBound_ = cVarC.v();
                                }
                                this.bitField0_ |= 4;
                                continue;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = eVar.s();
                                continue;
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = eVar.s();
                                continue;
                            case 64:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = eVar.s();
                                continue;
                            case 72:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = eVar.s();
                                continue;
                            case 82:
                                cVarC = (this.bitField0_ & 256) == 256 ? this.outerType_.c() : null;
                                q qVar2 = (q) eVar.u(f20300b, gVar);
                                this.outerType_ = qVar2;
                                if (cVarC != null) {
                                    cVarC.m(qVar2);
                                    this.outerType_ = cVarC.v();
                                }
                                this.bitField0_ |= 256;
                                continue;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = eVar.s();
                                continue;
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = eVar.s();
                                continue;
                            case 106:
                                cVarC = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.c() : null;
                                q qVar3 = (q) eVar.u(f20300b, gVar);
                                this.abbreviatedType_ = qVar3;
                                if (cVarC != null) {
                                    cVarC.m(qVar3);
                                    this.abbreviatedType_ = cVarC.v();
                                }
                                this.bitField0_ |= 1024;
                                continue;
                            case 112:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = eVar.s();
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
                if (z11) {
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
        }
        if (z11) {
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
