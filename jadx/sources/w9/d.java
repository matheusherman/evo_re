package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<d> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f20173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<d> f20174b = new a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private List<u> valueParameter_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<d> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public d b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new d(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<d, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20176e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<u> f20177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<Integer> f20178g;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            d dVar = null;
            try {
                try {
                    d dVarB = d.f20174b.b(eVar, gVar);
                    if (dVarB != null) {
                        m(dVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    d dVar2 = (d) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        if (dVar != null) {
                            m(dVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (dVar != null) {
                    m(dVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20175d & 4) != 4) {
                this.f20178g = new ArrayList(this.f20178g);
                this.f20175d |= 4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20175d & 2) != 2) {
                this.f20177f = new ArrayList(this.f20177f);
                this.f20175d |= 2;
            }
        }

        public b F(int i10) {
            this.f20175d |= 1;
            this.f20176e = i10;
            return this;
        }

        public d v() {
            d dVar = new d(this, (w9.a) null);
            int i10 = (this.f20175d & 1) != 1 ? 0 : 1;
            dVar.flags_ = this.f20176e;
            if ((this.f20175d & 2) == 2) {
                this.f20177f = Collections.unmodifiableList(this.f20177f);
                this.f20175d &= -3;
            }
            dVar.valueParameter_ = this.f20177f;
            if ((this.f20175d & 4) == 4) {
                this.f20178g = Collections.unmodifiableList(this.f20178g);
                this.f20175d &= -5;
            }
            dVar.versionRequirement_ = this.f20178g;
            dVar.bitField0_ = i10;
            return dVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20177f = list;
            this.f20178g = list;
            C();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b m(d dVar) {
            if (dVar == d.G()) {
                return this;
            }
            if (dVar.O()) {
                F(dVar.I());
            }
            if (!dVar.valueParameter_.isEmpty()) {
                if (this.f20177f.isEmpty()) {
                    this.f20177f = dVar.valueParameter_;
                    this.f20175d &= -3;
                } else {
                    z();
                    this.f20177f.addAll(dVar.valueParameter_);
                }
            }
            if (!dVar.versionRequirement_.isEmpty()) {
                if (this.f20178g.isEmpty()) {
                    this.f20178g = dVar.versionRequirement_;
                    this.f20175d &= -5;
                } else {
                    A();
                    this.f20178g.addAll(dVar.versionRequirement_);
                }
            }
            s(dVar);
            n(l().f(dVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public d build() {
            d dVarV = v();
            if (dVarV.isInitialized()) {
                return dVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(dVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void C() {
        }
    }

    /* synthetic */ d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void P() {
        this.flags_ = 6;
        List list = Collections.EMPTY_LIST;
        this.valueParameter_ = list;
        this.versionRequirement_ = list;
    }

    static {
        d dVar = new d(true);
        f20173a = dVar;
        dVar.P();
    }

    /* synthetic */ d(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<d, ?>) cVar);
    }

    public static d G() {
        return f20173a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public d a() {
        return f20173a;
    }

    public int I() {
        return this.flags_;
    }

    public u J(int i10) {
        return this.valueParameter_.get(i10);
    }

    public int K() {
        return this.valueParameter_.size();
    }

    public List<u> L() {
        return this.valueParameter_;
    }

    public List<Integer> N() {
        return this.versionRequirement_;
    }

    public boolean O() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.flags_) : 0;
        for (int i11 = 0; i11 < this.valueParameter_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.valueParameter_.get(i11));
        }
        int iP = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.versionRequirement_.get(i12).intValue());
        }
        int size = iO + iP + (N().size() * 2) + s() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<d> h() {
        return f20174b;
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
        for (int i10 = 0; i10 < K(); i10++) {
            if (!J(i10).isInitialized()) {
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

    private d(kotlin.reflect.jvm.internal.impl.protobuf.i.c<d, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b Q() {
        return b.y();
    }

    public static b R(d dVar) {
        return Q().m(dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public b g() {
        return Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public b c() {
        return R(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.flags_);
        }
        for (int i10 = 0; i10 < this.valueParameter_.size(); i10++) {
            fVar.d0(2, this.valueParameter_.get(i10));
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            fVar.a0(31, this.versionRequirement_.get(i11).intValue());
        }
        aVarX.a(19000, fVar);
        fVar.i0(this.unknownFields);
    }

    private d(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        P();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                            } else if (iK == 18) {
                                if ((i10 & 2) != 2) {
                                    this.valueParameter_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.valueParameter_.add((u) eVar.u(u.f20360b, gVar));
                            } else if (iK == 248) {
                                if ((i10 & 4) != 4) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 4;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            } else if (iK != 250) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 4) != 4 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                        throw e10.i(this);
                    }
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((i10 & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
        if ((i10 & 2) == 2) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if ((i10 & 4) == 4) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
