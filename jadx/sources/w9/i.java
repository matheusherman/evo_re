package w9;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class i extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<i> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f20219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<i> f20220b = new a();
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<q> contextReceiverType_;
    private e contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private q receiverType_;
    private int returnTypeId_;
    private q returnType_;
    private List<s> typeParameter_;
    private t typeTable_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private List<u> valueParameter_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<i> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public i b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new i(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<i, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20221d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20224g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20226i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<s> f20227j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private q f20228k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20229l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<q> f20230m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<Integer> f20231n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private List<u> f20232o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private t f20233p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private List<Integer> f20234q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private e f20235r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20222e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20223f = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private q f20225h = q.X();

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            i iVar = null;
            try {
                try {
                    i iVarB = i.f20220b.b(eVar, gVar);
                    if (iVarB != null) {
                        m(iVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    i iVar2 = (i) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        iVar = iVar2;
                        if (iVar != null) {
                            m(iVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (iVar != null) {
                    m(iVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20221d & 256) != 256) {
                this.f20230m = new ArrayList(this.f20230m);
                this.f20221d |= 256;
            }
        }

        private void C() {
            if ((this.f20221d & 32) != 32) {
                this.f20227j = new ArrayList(this.f20227j);
                this.f20221d |= 32;
            }
        }

        private void D() {
            if ((this.f20221d & 1024) != 1024) {
                this.f20232o = new ArrayList(this.f20232o);
                this.f20221d |= 1024;
            }
        }

        private void E() {
            if ((this.f20221d & 4096) != 4096) {
                this.f20234q = new ArrayList(this.f20234q);
                this.f20221d |= 4096;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20221d & 512) != 512) {
                this.f20231n = new ArrayList(this.f20231n);
                this.f20221d |= 512;
            }
        }

        public b G(e eVar) {
            if ((this.f20221d & 8192) != 8192 || this.f20235r == e.t()) {
                this.f20235r = eVar;
            } else {
                this.f20235r = e.y(this.f20235r).m(eVar).q();
            }
            this.f20221d |= 8192;
            return this;
        }

        public b K(q qVar) {
            if ((this.f20221d & 64) != 64 || this.f20228k == q.X()) {
                this.f20228k = qVar;
            } else {
                this.f20228k = q.y0(this.f20228k).m(qVar).v();
            }
            this.f20221d |= 64;
            return this;
        }

        public b L(q qVar) {
            if ((this.f20221d & 8) != 8 || this.f20225h == q.X()) {
                this.f20225h = qVar;
            } else {
                this.f20225h = q.y0(this.f20225h).m(qVar).v();
            }
            this.f20221d |= 8;
            return this;
        }

        public b N(t tVar) {
            if ((this.f20221d & 2048) != 2048 || this.f20233p == t.v()) {
                this.f20233p = tVar;
            } else {
                this.f20233p = t.D(this.f20233p).m(tVar).q();
            }
            this.f20221d |= 2048;
            return this;
        }

        public b O(int i10) {
            this.f20221d |= 1;
            this.f20222e = i10;
            return this;
        }

        public b Q(int i10) {
            this.f20221d |= 4;
            this.f20224g = i10;
            return this;
        }

        public b R(int i10) {
            this.f20221d |= 2;
            this.f20223f = i10;
            return this;
        }

        public b T(int i10) {
            this.f20221d |= 128;
            this.f20229l = i10;
            return this;
        }

        public b U(int i10) {
            this.f20221d |= 16;
            this.f20226i = i10;
            return this;
        }

        public i v() {
            i iVar = new i(this, (w9.a) null);
            int i10 = this.f20221d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            iVar.flags_ = this.f20222e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            iVar.oldFlags_ = this.f20223f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            iVar.name_ = this.f20224g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            iVar.returnType_ = this.f20225h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            iVar.returnTypeId_ = this.f20226i;
            if ((this.f20221d & 32) == 32) {
                this.f20227j = Collections.unmodifiableList(this.f20227j);
                this.f20221d &= -33;
            }
            iVar.typeParameter_ = this.f20227j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            iVar.receiverType_ = this.f20228k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            iVar.receiverTypeId_ = this.f20229l;
            if ((this.f20221d & 256) == 256) {
                this.f20230m = Collections.unmodifiableList(this.f20230m);
                this.f20221d &= -257;
            }
            iVar.contextReceiverType_ = this.f20230m;
            if ((this.f20221d & 512) == 512) {
                this.f20231n = Collections.unmodifiableList(this.f20231n);
                this.f20221d &= -513;
            }
            iVar.contextReceiverTypeId_ = this.f20231n;
            if ((this.f20221d & 1024) == 1024) {
                this.f20232o = Collections.unmodifiableList(this.f20232o);
                this.f20221d &= -1025;
            }
            iVar.valueParameter_ = this.f20232o;
            if ((i10 & 2048) == 2048) {
                i11 |= 128;
            }
            iVar.typeTable_ = this.f20233p;
            if ((this.f20221d & 4096) == 4096) {
                this.f20234q = Collections.unmodifiableList(this.f20234q);
                this.f20221d &= -4097;
            }
            iVar.versionRequirement_ = this.f20234q;
            if ((i10 & 8192) == 8192) {
                i11 |= 256;
            }
            iVar.contract_ = this.f20235r;
            iVar.bitField0_ = i11;
            return iVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20227j = list;
            this.f20228k = q.X();
            this.f20230m = list;
            this.f20231n = list;
            this.f20232o = list;
            this.f20233p = t.v();
            this.f20234q = list;
            this.f20235r = e.t();
            F();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public b m(i iVar) {
            if (iVar == i.a0()) {
                return this;
            }
            if (iVar.s0()) {
                O(iVar.c0());
            }
            if (iVar.u0()) {
                R(iVar.e0());
            }
            if (iVar.t0()) {
                Q(iVar.d0());
            }
            if (iVar.x0()) {
                L(iVar.h0());
            }
            if (iVar.y0()) {
                U(iVar.i0());
            }
            if (!iVar.typeParameter_.isEmpty()) {
                if (this.f20227j.isEmpty()) {
                    this.f20227j = iVar.typeParameter_;
                    this.f20221d &= -33;
                } else {
                    C();
                    this.f20227j.addAll(iVar.typeParameter_);
                }
            }
            if (iVar.v0()) {
                K(iVar.f0());
            }
            if (iVar.w0()) {
                T(iVar.g0());
            }
            if (!iVar.contextReceiverType_.isEmpty()) {
                if (this.f20230m.isEmpty()) {
                    this.f20230m = iVar.contextReceiverType_;
                    this.f20221d &= -257;
                } else {
                    A();
                    this.f20230m.addAll(iVar.contextReceiverType_);
                }
            }
            if (!iVar.contextReceiverTypeId_.isEmpty()) {
                if (this.f20231n.isEmpty()) {
                    this.f20231n = iVar.contextReceiverTypeId_;
                    this.f20221d &= -513;
                } else {
                    z();
                    this.f20231n.addAll(iVar.contextReceiverTypeId_);
                }
            }
            if (!iVar.valueParameter_.isEmpty()) {
                if (this.f20232o.isEmpty()) {
                    this.f20232o = iVar.valueParameter_;
                    this.f20221d &= -1025;
                } else {
                    D();
                    this.f20232o.addAll(iVar.valueParameter_);
                }
            }
            if (iVar.z0()) {
                N(iVar.m0());
            }
            if (!iVar.versionRequirement_.isEmpty()) {
                if (this.f20234q.isEmpty()) {
                    this.f20234q = iVar.versionRequirement_;
                    this.f20221d &= -4097;
                } else {
                    E();
                    this.f20234q.addAll(iVar.versionRequirement_);
                }
            }
            if (iVar.r0()) {
                G(iVar.Z());
            }
            s(iVar);
            n(l().f(iVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public i build() {
            i iVarV = v();
            if (iVarV.isInitialized()) {
                return iVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(iVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void F() {
        }
    }

    /* synthetic */ i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void A0() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = q.X();
        this.returnTypeId_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.receiverType_ = q.X();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = list;
        this.contextReceiverTypeId_ = list;
        this.valueParameter_ = list;
        this.typeTable_ = t.v();
        this.versionRequirement_ = list;
        this.contract_ = e.t();
    }

    static {
        i iVar = new i(true);
        f20219a = iVar;
        iVar.A0();
    }

    /* synthetic */ i(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<i, ?>) cVar);
    }

    public static i E0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f20220b.a(inputStream, gVar);
    }

    public static i a0() {
        return f20219a;
    }

    public q V(int i10) {
        return this.contextReceiverType_.get(i10);
    }

    public int W() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> X() {
        return this.contextReceiverTypeId_;
    }

    public List<q> Y() {
        return this.contextReceiverType_;
    }

    public e Z() {
        return this.contract_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public i a() {
        return f20219a;
    }

    public int c0() {
        return this.flags_;
    }

    public int d0() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 2) == 2 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.oldFlags_) : 0;
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.returnType_);
        }
        for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.typeParameter_.get(i11));
        }
        if ((this.bitField0_ & 32) == 32) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.receiverType_);
        }
        for (int i12 = 0; i12 < this.valueParameter_.size(); i12++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.valueParameter_.get(i12));
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.flags_);
        }
        for (int i13 = 0; i13 < this.contextReceiverType_.size(); i13++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(10, this.contextReceiverType_.get(i13));
        }
        int iP = 0;
        for (int i14 = 0; i14 < this.contextReceiverTypeId_.size(); i14++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.contextReceiverTypeId_.get(i14).intValue());
        }
        int iS = iO + iP;
        if (!X().isEmpty()) {
            iS = iS + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iP;
        if ((this.bitField0_ & 128) == 128) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.typeTable_);
        }
        int iP2 = 0;
        for (int i15 = 0; i15 < this.versionRequirement_.size(); i15++) {
            iP2 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.versionRequirement_.get(i15).intValue());
        }
        int size = iS + iP2 + (q0().size() * 2);
        if ((this.bitField0_ & 256) == 256) {
            size += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.contract_);
        }
        int iS2 = size + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS2;
        return iS2;
    }

    public int e0() {
        return this.oldFlags_;
    }

    public q f0() {
        return this.receiverType_;
    }

    public int g0() {
        return this.receiverTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<i> h() {
        return f20220b;
    }

    public q h0() {
        return this.returnType_;
    }

    public int i0() {
        return this.returnTypeId_;
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
        if (!t0()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (x0() && !h0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < k0(); i10++) {
            if (!j0(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (v0() && !f0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < W(); i11++) {
            if (!V(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < o0(); i12++) {
            if (!n0(i12).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (z0() && !m0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (r0() && !Z().isInitialized()) {
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

    public s j0(int i10) {
        return this.typeParameter_.get(i10);
    }

    public int k0() {
        return this.typeParameter_.size();
    }

    public List<s> l0() {
        return this.typeParameter_;
    }

    public t m0() {
        return this.typeTable_;
    }

    public u n0(int i10) {
        return this.valueParameter_.get(i10);
    }

    public int o0() {
        return this.valueParameter_.size();
    }

    public List<u> p0() {
        return this.valueParameter_;
    }

    public List<Integer> q0() {
        return this.versionRequirement_;
    }

    public boolean r0() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean s0() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean t0() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean u0() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean v0() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean w0() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean x0() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean y0() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean z0() {
        return (this.bitField0_ & 128) == 128;
    }

    private i(kotlin.reflect.jvm.internal.impl.protobuf.i.c<i, ?> cVar) {
        super(cVar);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b B0() {
        return b.y();
    }

    public static b C0(i iVar) {
        return B0().m(iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return C0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.a0(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.d0(3, this.returnType_);
        }
        for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
            fVar.d0(4, this.typeParameter_.get(i10));
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.d0(5, this.receiverType_);
        }
        for (int i11 = 0; i11 < this.valueParameter_.size(); i11++) {
            fVar.d0(6, this.valueParameter_.get(i11));
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.a0(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            fVar.a0(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(9, this.flags_);
        }
        for (int i12 = 0; i12 < this.contextReceiverType_.size(); i12++) {
            fVar.d0(10, this.contextReceiverType_.get(i12));
        }
        if (X().size() > 0) {
            fVar.o0(90);
            fVar.o0(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i13 = 0; i13 < this.contextReceiverTypeId_.size(); i13++) {
            fVar.b0(this.contextReceiverTypeId_.get(i13).intValue());
        }
        if ((this.bitField0_ & 128) == 128) {
            fVar.d0(30, this.typeTable_);
        }
        for (int i14 = 0; i14 < this.versionRequirement_.size(); i14++) {
            fVar.a0(31, this.versionRequirement_.get(i14).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            fVar.d0(32, this.contract_);
        }
        aVarX.a(19000, fVar);
        fVar.i0(this.unknownFields);
    }

    private i(boolean z10) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        A0();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    switch (iK) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = eVar.s();
                            continue;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = eVar.s();
                            continue;
                        case 26:
                            q.c cVarA0 = (this.bitField0_ & 8) == 8 ? this.returnType_.c() : null;
                            q qVar = (q) eVar.u(q.f20300b, gVar);
                            this.returnType_ = qVar;
                            if (cVarA0 != null) {
                                cVarA0.m(qVar);
                                this.returnType_ = cVarA0.v();
                            }
                            this.bitField0_ |= 8;
                            continue;
                        case 34:
                            if ((i10 & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i10 |= 32;
                            }
                            this.typeParameter_.add((s) eVar.u(s.f20341b, gVar));
                            continue;
                        case 42:
                            q.c cVarA1 = (this.bitField0_ & 32) == 32 ? this.receiverType_.c() : null;
                            q qVar2 = (q) eVar.u(q.f20300b, gVar);
                            this.receiverType_ = qVar2;
                            if (cVarA1 != null) {
                                cVarA1.m(qVar2);
                                this.receiverType_ = cVarA1.v();
                            }
                            this.bitField0_ |= 32;
                            continue;
                        case 50:
                            if ((i10 & 1024) != 1024) {
                                this.valueParameter_ = new ArrayList();
                                i10 |= 1024;
                            }
                            this.valueParameter_.add((u) eVar.u(u.f20360b, gVar));
                            continue;
                        case 56:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = eVar.s();
                            continue;
                        case 64:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = eVar.s();
                            continue;
                        case 72:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.s();
                            continue;
                        case 82:
                            if ((i10 & 256) != 256) {
                                this.contextReceiverType_ = new ArrayList();
                                i10 |= 256;
                            }
                            this.contextReceiverType_.add((q) eVar.u(q.f20300b, gVar));
                            continue;
                        case 88:
                            if ((i10 & 512) != 512) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i10 |= 512;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                            continue;
                        case 90:
                            int iJ = eVar.j(eVar.A());
                            if ((i10 & 512) != 512 && eVar.e() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i10 |= 512;
                            }
                            while (eVar.e() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ);
                            continue;
                        case 242:
                            t.b bVarF = (this.bitField0_ & 128) == 128 ? this.typeTable_.c() : null;
                            t tVar = (t) eVar.u(t.f20355b, gVar);
                            this.typeTable_ = tVar;
                            if (bVarF != null) {
                                bVarF.m(tVar);
                                this.typeTable_ = bVarF.q();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 248:
                            if ((i10 & 4096) != 4096) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 4096;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            continue;
                        case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                            int iJ2 = eVar.j(eVar.A());
                            if ((i10 & 4096) != 4096 && eVar.e() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 4096;
                            }
                            while (eVar.e() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ2);
                            continue;
                        case 258:
                            e.b bVarA = (this.bitField0_ & 256) == 256 ? this.contract_.c() : null;
                            e eVar2 = (e) eVar.u(e.f20180b, gVar);
                            this.contract_ = eVar2;
                            if (bVarA != null) {
                                bVarA.m(eVar2);
                                this.contract_ = bVarA.q();
                            }
                            this.bitField0_ |= 256;
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
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i10 & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((i10 & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((i10 & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((i10 & 4096) == 4096) {
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
        if ((i10 & 32) == 32) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i10 & 1024) == 1024) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if ((i10 & 256) == 256) {
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        }
        if ((i10 & 512) == 512) {
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        }
        if ((i10 & 4096) == 4096) {
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
