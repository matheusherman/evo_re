package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class s extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<s> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s f20340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<s> f20341b = new a();
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<q> upperBound_;
    private c variance_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<s> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public s b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new s(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<s, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f20345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private c f20346h = c.INV;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<q> f20347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<Integer> f20348j;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            s sVar = null;
            try {
                try {
                    s sVarB = s.f20341b.b(eVar, gVar);
                    if (sVarB != null) {
                        m(sVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    s sVar2 = (s) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        sVar = sVar2;
                        if (sVar != null) {
                            m(sVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (sVar != null) {
                    m(sVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20342d & 16) != 16) {
                this.f20347i = new ArrayList(this.f20347i);
                this.f20342d |= 16;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20342d & 32) != 32) {
                this.f20348j = new ArrayList(this.f20348j);
                this.f20342d |= 32;
            }
        }

        public b F(int i10) {
            this.f20342d |= 1;
            this.f20343e = i10;
            return this;
        }

        public b G(int i10) {
            this.f20342d |= 2;
            this.f20344f = i10;
            return this;
        }

        public b H(boolean z10) {
            this.f20342d |= 4;
            this.f20345g = z10;
            return this;
        }

        public s v() {
            s sVar = new s(this, (w9.a) null);
            int i10 = this.f20342d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            sVar.id_ = this.f20343e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            sVar.name_ = this.f20344f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            sVar.reified_ = this.f20345g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            sVar.variance_ = this.f20346h;
            if ((this.f20342d & 16) == 16) {
                this.f20347i = Collections.unmodifiableList(this.f20347i);
                this.f20342d &= -17;
            }
            sVar.upperBound_ = this.f20347i;
            if ((this.f20342d & 32) == 32) {
                this.f20348j = Collections.unmodifiableList(this.f20348j);
                this.f20342d &= -33;
            }
            sVar.upperBoundId_ = this.f20348j;
            sVar.bitField0_ = i11;
            return sVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20347i = list;
            this.f20348j = list;
            C();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b m(s sVar) {
            if (sVar == s.J()) {
                return this;
            }
            if (sVar.U()) {
                F(sVar.L());
            }
            if (sVar.V()) {
                G(sVar.N());
            }
            if (sVar.W()) {
                H(sVar.O());
            }
            if (sVar.X()) {
                I(sVar.T());
            }
            if (!sVar.upperBound_.isEmpty()) {
                if (this.f20347i.isEmpty()) {
                    this.f20347i = sVar.upperBound_;
                    this.f20342d &= -17;
                } else {
                    A();
                    this.f20347i.addAll(sVar.upperBound_);
                }
            }
            if (!sVar.upperBoundId_.isEmpty()) {
                if (this.f20348j.isEmpty()) {
                    this.f20348j = sVar.upperBoundId_;
                    this.f20342d &= -33;
                } else {
                    z();
                    this.f20348j.addAll(sVar.upperBoundId_);
                }
            }
            s(sVar);
            n(l().f(sVar.unknownFields));
            return this;
        }

        public b I(c cVar) {
            cVar.getClass();
            this.f20342d |= 8;
            this.f20346h = cVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public s build() {
            s sVarV = v();
            if (sVarV.isInitialized()) {
                return sVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(sVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void C() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> f20352d = new a();
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
            if (i10 != 2) {
                return null;
            }
            return INV;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        c(int i10, int i11) {
            this.value = i11;
        }
    }

    /* synthetic */ s(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void Y() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = c.INV;
        List list = Collections.EMPTY_LIST;
        this.upperBound_ = list;
        this.upperBoundId_ = list;
    }

    static {
        s sVar = new s(true);
        f20340a = sVar;
        sVar.Y();
    }

    /* synthetic */ s(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<s, ?>) cVar);
    }

    public static s J() {
        return f20340a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public s a() {
        return f20340a;
    }

    public int L() {
        return this.id_;
    }

    public int N() {
        return this.name_;
    }

    public boolean O() {
        return this.reified_;
    }

    public q P(int i10) {
        return this.upperBound_.get(i10);
    }

    public int Q() {
        return this.upperBound_.size();
    }

    public List<Integer> R() {
        return this.upperBoundId_;
    }

    public List<q> S() {
        return this.upperBound_;
    }

    public c T() {
        return this.variance_;
    }

    public boolean U() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean V() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean W() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean X() {
        return (this.bitField0_ & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.id_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.a(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.h(4, this.variance_.h());
        }
        for (int i11 = 0; i11 < this.upperBound_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.upperBound_.get(i11));
        }
        int iP = 0;
        for (int i12 = 0; i12 < this.upperBoundId_.size(); i12++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.upperBoundId_.get(i12).intValue());
        }
        int iP2 = iO + iP;
        if (!R().isEmpty()) {
            iP2 = iP2 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP);
        }
        this.upperBoundIdMemoizedSerializedSize = iP;
        int iS = iP2 + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS;
        return iS;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<s> h() {
        return f20341b;
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
        if (!U()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (!V()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Q(); i10++) {
            if (!P(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (r()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    private s(kotlin.reflect.jvm.internal.impl.protobuf.i.c<s, ?> cVar) {
        super(cVar);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b Z() {
        return b.y();
    }

    public static b a0(s sVar) {
        return Z().m(sVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return Z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return a0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.L(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.S(4, this.variance_.h());
        }
        for (int i10 = 0; i10 < this.upperBound_.size(); i10++) {
            fVar.d0(5, this.upperBound_.get(i10));
        }
        if (R().size() > 0) {
            fVar.o0(50);
            fVar.o0(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i11 = 0; i11 < this.upperBoundId_.size(); i11++) {
            fVar.b0(this.upperBoundId_.get(i11).intValue());
        }
        aVarX.a(1000, fVar);
        fVar.i0(this.unknownFields);
    }

    private s(boolean z10) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private s(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        Y();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = eVar.s();
                        } else if (iK == 16) {
                            this.bitField0_ |= 2;
                            this.name_ = eVar.s();
                        } else if (iK == 24) {
                            this.bitField0_ |= 4;
                            this.reified_ = eVar.k();
                        } else if (iK == 32) {
                            int iN = eVar.n();
                            c cVarA = c.a(iN);
                            if (cVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN);
                            } else {
                                this.bitField0_ |= 8;
                                this.variance_ = cVarA;
                            }
                        } else if (iK == 42) {
                            if ((i10 & 16) != 16) {
                                this.upperBound_ = new ArrayList();
                                i10 |= 16;
                            }
                            this.upperBound_.add((q) eVar.u(q.f20300b, gVar));
                        } else if (iK == 48) {
                            if ((i10 & 32) != 32) {
                                this.upperBoundId_ = new ArrayList();
                                i10 |= 32;
                            }
                            this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                        } else if (iK != 50) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            int iJ = eVar.j(eVar.A());
                            if ((i10 & 32) != 32 && eVar.e() > 0) {
                                this.upperBoundId_ = new ArrayList();
                                i10 |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ);
                        }
                    }
                    z10 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((i10 & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
        if ((i10 & 16) == 16) {
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if ((i10 & 32) == 32) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
