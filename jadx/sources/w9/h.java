package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class h extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f20204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<h> f20205b = new a();
    private List<h> andArgument_;
    private int bitField0_;
    private c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<h> orArgument_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private int valueParameterReference_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<h> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public h b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new h(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<h, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f20209e = c.TRUE;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private q f20210f = q.X();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<h> f20212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<h> f20213i;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            h hVar = null;
            try {
                try {
                    h hVarB = h.f20205b.b(eVar, gVar);
                    if (hVarB != null) {
                        m(hVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    h hVar2 = (h) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        hVar = hVar2;
                        if (hVar != null) {
                            m(hVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                    m(hVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        private void u() {
            if ((this.f20206b & 32) != 32) {
                this.f20212h = new ArrayList(this.f20212h);
                this.f20206b |= 32;
            }
        }

        private void v() {
            if ((this.f20206b & 64) != 64) {
                this.f20213i = new ArrayList(this.f20213i);
                this.f20206b |= 64;
            }
        }

        public b A(q qVar) {
            if ((this.f20206b & 8) != 8 || this.f20210f == q.X()) {
                this.f20210f = qVar;
            } else {
                this.f20210f = q.y0(this.f20210f).m(qVar).v();
            }
            this.f20206b |= 8;
            return this;
        }

        public b D(int i10) {
            this.f20206b |= 1;
            this.f20207c = i10;
            return this;
        }

        public b E(int i10) {
            this.f20206b |= 16;
            this.f20211g = i10;
            return this;
        }

        public b F(int i10) {
            this.f20206b |= 2;
            this.f20208d = i10;
            return this;
        }

        public h q() {
            h hVar = new h(this, (w9.a) null);
            int i10 = this.f20206b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            hVar.flags_ = this.f20207c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            hVar.valueParameterReference_ = this.f20208d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            hVar.constantValue_ = this.f20209e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            hVar.isInstanceType_ = this.f20210f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            hVar.isInstanceTypeId_ = this.f20211g;
            if ((this.f20206b & 32) == 32) {
                this.f20212h = Collections.unmodifiableList(this.f20212h);
                this.f20206b &= -33;
            }
            hVar.andArgument_ = this.f20212h;
            if ((this.f20206b & 64) == 64) {
                this.f20213i = Collections.unmodifiableList(this.f20213i);
                this.f20206b &= -65;
            }
            hVar.orArgument_ = this.f20213i;
            hVar.bitField0_ = i11;
            return hVar;
        }

        private b() {
            List<h> list = Collections.EMPTY_LIST;
            this.f20212h = list;
            this.f20213i = list;
            x();
        }

        public b C(c cVar) {
            cVar.getClass();
            this.f20206b |= 4;
            this.f20209e = cVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public h build() {
            h hVarQ = q();
            if (hVarQ.isInitialized()) {
                return hVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(hVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public b m(h hVar) {
            if (hVar == h.E()) {
                return this;
            }
            if (hVar.N()) {
                D(hVar.F());
            }
            if (hVar.Q()) {
                F(hVar.K());
            }
            if (hVar.L()) {
                C(hVar.D());
            }
            if (hVar.O()) {
                A(hVar.G());
            }
            if (hVar.P()) {
                E(hVar.H());
            }
            if (!hVar.andArgument_.isEmpty()) {
                if (this.f20212h.isEmpty()) {
                    this.f20212h = hVar.andArgument_;
                    this.f20206b &= -33;
                } else {
                    u();
                    this.f20212h.addAll(hVar.andArgument_);
                }
            }
            if (!hVar.orArgument_.isEmpty()) {
                if (this.f20213i.isEmpty()) {
                    this.f20213i = hVar.orArgument_;
                    this.f20206b &= -65;
                } else {
                    v();
                    this.f20213i.addAll(hVar.orArgument_);
                }
            }
            n(l().f(hVar.unknownFields));
            return this;
        }

        private void x() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> f20217d = new a();
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
                return TRUE;
            }
            if (i10 == 1) {
                return FALSE;
            }
            if (i10 != 2) {
                return null;
            }
            return NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        c(int i10, int i11) {
            this.value = i11;
        }
    }

    /* synthetic */ h(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void R() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = c.TRUE;
        this.isInstanceType_ = q.X();
        this.isInstanceTypeId_ = 0;
        List<h> list = Collections.EMPTY_LIST;
        this.andArgument_ = list;
        this.orArgument_ = list;
    }

    static {
        h hVar = new h(true);
        f20204a = hVar;
        hVar.R();
    }

    /* synthetic */ h(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    public static h E() {
        return f20204a;
    }

    public h B(int i10) {
        return this.andArgument_.get(i10);
    }

    public int C() {
        return this.andArgument_.size();
    }

    public c D() {
        return this.constantValue_;
    }

    public int F() {
        return this.flags_;
    }

    public q G() {
        return this.isInstanceType_;
    }

    public int H() {
        return this.isInstanceTypeId_;
    }

    public h I(int i10) {
        return this.orArgument_.get(i10);
    }

    public int J() {
        return this.orArgument_.size();
    }

    public int K() {
        return this.valueParameterReference_;
    }

    public boolean L() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean N() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean O() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean P() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean Q() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.constantValue_.h());
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.isInstanceTypeId_);
        }
        for (int i11 = 0; i11 < this.andArgument_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.andArgument_.get(i11));
        }
        for (int i12 = 0; i12 < this.orArgument_.size(); i12++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(7, this.orArgument_.get(i12));
        }
        int size = iO + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<h> h() {
        return f20205b;
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
        if (O() && !G().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < C(); i10++) {
            if (!B(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < J(); i11++) {
            if (!I(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    private h(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b S() {
        return b.t();
    }

    public static b T(h hVar) {
        return S().m(hVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public b g() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b c() {
        return T(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.S(3, this.constantValue_.h());
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.d0(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.a0(5, this.isInstanceTypeId_);
        }
        for (int i10 = 0; i10 < this.andArgument_.size(); i10++) {
            fVar.d0(6, this.andArgument_.get(i10));
        }
        for (int i11 = 0; i11 < this.orArgument_.size(); i11++) {
            fVar.d0(7, this.orArgument_.get(i11));
        }
        fVar.i0(this.unknownFields);
    }

    private h(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private h(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        R();
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
                            this.flags_ = eVar.s();
                        } else if (iK == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = eVar.s();
                        } else if (iK == 24) {
                            int iN = eVar.n();
                            c cVarA = c.a(iN);
                            if (cVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = cVarA;
                            }
                        } else if (iK == 34) {
                            q.c cVarC = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.c() : null;
                            q qVar = (q) eVar.u(q.f20300b, gVar);
                            this.isInstanceType_ = qVar;
                            if (cVarC != null) {
                                cVarC.m(qVar);
                                this.isInstanceType_ = cVarC.v();
                            }
                            this.bitField0_ |= 8;
                        } else if (iK == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = eVar.s();
                        } else if (iK == 50) {
                            if ((i10 & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i10 |= 32;
                            }
                            this.andArgument_.add((h) eVar.u(f20205b, gVar));
                        } else if (iK != 58) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            if ((i10 & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i10 |= 64;
                            }
                            this.orArgument_.add((h) eVar.u(f20205b, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 32) == 32) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if ((i10 & 64) == 64) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
        if ((i10 & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i10 & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
