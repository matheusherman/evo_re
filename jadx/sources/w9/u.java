package w9;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class u extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<u> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f20359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<u> f20360b = new a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private q type_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private int varargElementTypeId_;
    private q varargElementType_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<u> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public u b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new u(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<u, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20363f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20365h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20367j;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private q f20364g = q.X();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private q f20366i = q.X();

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            u uVar = null;
            try {
                try {
                    u uVarB = u.f20360b.b(eVar, gVar);
                    if (uVarB != null) {
                        m(uVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    u uVar2 = (u) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        uVar = uVar2;
                        if (uVar != null) {
                            m(uVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (uVar != null) {
                    m(uVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        public b D(q qVar) {
            if ((this.f20361d & 4) != 4 || this.f20364g == q.X()) {
                this.f20364g = qVar;
            } else {
                this.f20364g = q.y0(this.f20364g).m(qVar).v();
            }
            this.f20361d |= 4;
            return this;
        }

        public b E(q qVar) {
            if ((this.f20361d & 16) != 16 || this.f20366i == q.X()) {
                this.f20366i = qVar;
            } else {
                this.f20366i = q.y0(this.f20366i).m(qVar).v();
            }
            this.f20361d |= 16;
            return this;
        }

        public b F(int i10) {
            this.f20361d |= 1;
            this.f20362e = i10;
            return this;
        }

        public b G(int i10) {
            this.f20361d |= 2;
            this.f20363f = i10;
            return this;
        }

        public b H(int i10) {
            this.f20361d |= 8;
            this.f20365h = i10;
            return this;
        }

        public b I(int i10) {
            this.f20361d |= 32;
            this.f20367j = i10;
            return this;
        }

        public u v() {
            u uVar = new u(this, (w9.a) null);
            int i10 = this.f20361d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            uVar.flags_ = this.f20362e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            uVar.name_ = this.f20363f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            uVar.type_ = this.f20364g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            uVar.typeId_ = this.f20365h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            uVar.varargElementType_ = this.f20366i;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            uVar.varargElementTypeId_ = this.f20367j;
            uVar.bitField0_ = i11;
            return uVar;
        }

        private b() {
            z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b m(u uVar) {
            if (uVar == u.H()) {
                return this;
            }
            if (uVar.Q()) {
                F(uVar.J());
            }
            if (uVar.R()) {
                G(uVar.K());
            }
            if (uVar.S()) {
                D(uVar.L());
            }
            if (uVar.T()) {
                H(uVar.N());
            }
            if (uVar.U()) {
                E(uVar.O());
            }
            if (uVar.V()) {
                I(uVar.P());
            }
            s(uVar);
            n(l().f(uVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public u build() {
            u uVarV = v();
            if (uVarV.isInitialized()) {
                return uVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(uVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void z() {
        }
    }

    /* synthetic */ u(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void W() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = q.X();
        this.typeId_ = 0;
        this.varargElementType_ = q.X();
        this.varargElementTypeId_ = 0;
    }

    static {
        u uVar = new u(true);
        f20359a = uVar;
        uVar.W();
    }

    /* synthetic */ u(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<u, ?>) cVar);
    }

    public static u H() {
        return f20359a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public u a() {
        return f20359a;
    }

    public int J() {
        return this.flags_;
    }

    public int K() {
        return this.name_;
    }

    public q L() {
        return this.type_;
    }

    public int N() {
        return this.typeId_;
    }

    public q O() {
        return this.varargElementType_;
    }

    public int P() {
        return this.varargElementTypeId_;
    }

    public boolean Q() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean R() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean S() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean T() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean U() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean V() {
        return (this.bitField0_ & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.varargElementTypeId_);
        }
        int iS = iO + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS;
        return iS;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<u> h() {
        return f20360b;
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
        if (!R()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (S() && !L().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (U() && !O().isInitialized()) {
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

    private u(kotlin.reflect.jvm.internal.impl.protobuf.i.c<u, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b X() {
        return b.y();
    }

    public static b Y(u uVar) {
        return X().m(uVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b g() {
        return X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return Y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.d0(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.d0(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.a0(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.a0(6, this.varargElementTypeId_);
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    private u(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private u(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        q.c cVarC;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        W();
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
                            this.flags_ = eVar.s();
                        } else if (iK != 16) {
                            if (iK == 26) {
                                cVarC = (this.bitField0_ & 4) == 4 ? this.type_.c() : null;
                                q qVar = (q) eVar.u(q.f20300b, gVar);
                                this.type_ = qVar;
                                if (cVarC != null) {
                                    cVarC.m(qVar);
                                    this.type_ = cVarC.v();
                                }
                                this.bitField0_ |= 4;
                            } else if (iK == 34) {
                                cVarC = (this.bitField0_ & 16) == 16 ? this.varargElementType_.c() : null;
                                q qVar2 = (q) eVar.u(q.f20300b, gVar);
                                this.varargElementType_ = qVar2;
                                if (cVarC != null) {
                                    cVarC.m(qVar2);
                                    this.varargElementType_ = cVarC.v();
                                }
                                this.bitField0_ |= 16;
                            } else if (iK == 40) {
                                this.bitField0_ |= 8;
                                this.typeId_ = eVar.s();
                            } else if (iK != 48) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 32;
                                this.varargElementTypeId_ = eVar.s();
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.name_ = eVar.s();
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
