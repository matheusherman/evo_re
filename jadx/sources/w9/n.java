package w9;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<n> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n f20263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<n> f20264b = new a();
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<q> contextReceiverType_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private q receiverType_;
    private int returnTypeId_;
    private q returnType_;
    private int setterFlags_;
    private u setterValueParameter_;
    private List<s> typeParameter_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<n> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public n b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new n(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<n, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20265d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20268g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20270i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<s> f20271j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private q f20272k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20273l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<q> f20274m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<Integer> f20275n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private u f20276o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f20277p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f20278q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private List<Integer> f20279r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20266e = 518;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20267f = 2054;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private q f20269h = q.X();

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            n nVar = null;
            try {
                try {
                    n nVarB = n.f20264b.b(eVar, gVar);
                    if (nVarB != null) {
                        m(nVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    n nVar2 = (n) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        nVar = nVar2;
                        if (nVar != null) {
                            m(nVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (nVar != null) {
                    m(nVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20265d & 256) != 256) {
                this.f20274m = new ArrayList(this.f20274m);
                this.f20265d |= 256;
            }
        }

        private void C() {
            if ((this.f20265d & 32) != 32) {
                this.f20271j = new ArrayList(this.f20271j);
                this.f20265d |= 32;
            }
        }

        private void D() {
            if ((this.f20265d & 8192) != 8192) {
                this.f20279r = new ArrayList(this.f20279r);
                this.f20265d |= 8192;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20265d & 512) != 512) {
                this.f20275n = new ArrayList(this.f20275n);
                this.f20265d |= 512;
            }
        }

        public b H(q qVar) {
            if ((this.f20265d & 64) != 64 || this.f20272k == q.X()) {
                this.f20272k = qVar;
            } else {
                this.f20272k = q.y0(this.f20272k).m(qVar).v();
            }
            this.f20265d |= 64;
            return this;
        }

        public b I(q qVar) {
            if ((this.f20265d & 8) != 8 || this.f20269h == q.X()) {
                this.f20269h = qVar;
            } else {
                this.f20269h = q.y0(this.f20269h).m(qVar).v();
            }
            this.f20265d |= 8;
            return this;
        }

        public b K(u uVar) {
            if ((this.f20265d & 1024) != 1024 || this.f20276o == u.H()) {
                this.f20276o = uVar;
            } else {
                this.f20276o = u.Y(this.f20276o).m(uVar).v();
            }
            this.f20265d |= 1024;
            return this;
        }

        public b L(int i10) {
            this.f20265d |= 1;
            this.f20266e = i10;
            return this;
        }

        public b N(int i10) {
            this.f20265d |= 2048;
            this.f20277p = i10;
            return this;
        }

        public b O(int i10) {
            this.f20265d |= 4;
            this.f20268g = i10;
            return this;
        }

        public b Q(int i10) {
            this.f20265d |= 2;
            this.f20267f = i10;
            return this;
        }

        public b R(int i10) {
            this.f20265d |= 128;
            this.f20273l = i10;
            return this;
        }

        public b T(int i10) {
            this.f20265d |= 16;
            this.f20270i = i10;
            return this;
        }

        public b U(int i10) {
            this.f20265d |= 4096;
            this.f20278q = i10;
            return this;
        }

        public n v() {
            n nVar = new n(this, (w9.a) null);
            int i10 = this.f20265d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            nVar.flags_ = this.f20266e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            nVar.oldFlags_ = this.f20267f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            nVar.name_ = this.f20268g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            nVar.returnType_ = this.f20269h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            nVar.returnTypeId_ = this.f20270i;
            if ((this.f20265d & 32) == 32) {
                this.f20271j = Collections.unmodifiableList(this.f20271j);
                this.f20265d &= -33;
            }
            nVar.typeParameter_ = this.f20271j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            nVar.receiverType_ = this.f20272k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            nVar.receiverTypeId_ = this.f20273l;
            if ((this.f20265d & 256) == 256) {
                this.f20274m = Collections.unmodifiableList(this.f20274m);
                this.f20265d &= -257;
            }
            nVar.contextReceiverType_ = this.f20274m;
            if ((this.f20265d & 512) == 512) {
                this.f20275n = Collections.unmodifiableList(this.f20275n);
                this.f20265d &= -513;
            }
            nVar.contextReceiverTypeId_ = this.f20275n;
            if ((i10 & 1024) == 1024) {
                i11 |= 128;
            }
            nVar.setterValueParameter_ = this.f20276o;
            if ((i10 & 2048) == 2048) {
                i11 |= 256;
            }
            nVar.getterFlags_ = this.f20277p;
            if ((i10 & 4096) == 4096) {
                i11 |= 512;
            }
            nVar.setterFlags_ = this.f20278q;
            if ((this.f20265d & 8192) == 8192) {
                this.f20279r = Collections.unmodifiableList(this.f20279r);
                this.f20265d &= -8193;
            }
            nVar.versionRequirement_ = this.f20279r;
            nVar.bitField0_ = i11;
            return nVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20271j = list;
            this.f20272k = q.X();
            this.f20274m = list;
            this.f20275n = list;
            this.f20276o = u.H();
            this.f20279r = list;
            E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b m(n nVar) {
            if (nVar == n.Y()) {
                return this;
            }
            if (nVar.o0()) {
                L(nVar.a0());
            }
            if (nVar.r0()) {
                Q(nVar.d0());
            }
            if (nVar.q0()) {
                O(nVar.c0());
            }
            if (nVar.u0()) {
                I(nVar.g0());
            }
            if (nVar.v0()) {
                T(nVar.h0());
            }
            if (!nVar.typeParameter_.isEmpty()) {
                if (this.f20271j.isEmpty()) {
                    this.f20271j = nVar.typeParameter_;
                    this.f20265d &= -33;
                } else {
                    C();
                    this.f20271j.addAll(nVar.typeParameter_);
                }
            }
            if (nVar.s0()) {
                H(nVar.e0());
            }
            if (nVar.t0()) {
                R(nVar.f0());
            }
            if (!nVar.contextReceiverType_.isEmpty()) {
                if (this.f20274m.isEmpty()) {
                    this.f20274m = nVar.contextReceiverType_;
                    this.f20265d &= -257;
                } else {
                    A();
                    this.f20274m.addAll(nVar.contextReceiverType_);
                }
            }
            if (!nVar.contextReceiverTypeId_.isEmpty()) {
                if (this.f20275n.isEmpty()) {
                    this.f20275n = nVar.contextReceiverTypeId_;
                    this.f20265d &= -513;
                } else {
                    z();
                    this.f20275n.addAll(nVar.contextReceiverTypeId_);
                }
            }
            if (nVar.x0()) {
                K(nVar.j0());
            }
            if (nVar.p0()) {
                N(nVar.b0());
            }
            if (nVar.w0()) {
                U(nVar.i0());
            }
            if (!nVar.versionRequirement_.isEmpty()) {
                if (this.f20279r.isEmpty()) {
                    this.f20279r = nVar.versionRequirement_;
                    this.f20265d &= -8193;
                } else {
                    D();
                    this.f20279r.addAll(nVar.versionRequirement_);
                }
            }
            s(nVar);
            n(l().f(nVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public n build() {
            n nVarV = v();
            if (nVarV.isInitialized()) {
                return nVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(nVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void E() {
        }
    }

    /* synthetic */ n(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        n nVar = new n(true);
        f20263a = nVar;
        nVar.y0();
    }

    /* synthetic */ n(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<n, ?>) cVar);
    }

    public static n Y() {
        return f20263a;
    }

    private void y0() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = q.X();
        this.returnTypeId_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.receiverType_ = q.X();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = list;
        this.contextReceiverTypeId_ = list;
        this.setterValueParameter_ = u.H();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = list;
    }

    public q U(int i10) {
        return this.contextReceiverType_.get(i10);
    }

    public int V() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> W() {
        return this.contextReceiverTypeId_;
    }

    public List<q> X() {
        return this.contextReceiverType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public n a() {
        return f20263a;
    }

    public int a0() {
        return this.flags_;
    }

    public int b0() {
        return this.getterFlags_;
    }

    public int c0() {
        return this.name_;
    }

    public int d0() {
        return this.oldFlags_;
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
        if ((this.bitField0_ & 128) == 128) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.flags_);
        }
        for (int i12 = 0; i12 < this.contextReceiverType_.size(); i12++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(12, this.contextReceiverType_.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.contextReceiverTypeId_.size(); i13++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.contextReceiverTypeId_.get(i13).intValue());
        }
        int iP2 = iO + iP;
        if (!W().isEmpty()) {
            iP2 = iP2 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iP;
        int iP3 = 0;
        for (int i14 = 0; i14 < this.versionRequirement_.size(); i14++) {
            iP3 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.versionRequirement_.get(i14).intValue());
        }
        int size = iP2 + iP3 + (n0().size() * 2) + s() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public q e0() {
        return this.receiverType_;
    }

    public int f0() {
        return this.receiverTypeId_;
    }

    public q g0() {
        return this.returnType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<n> h() {
        return f20264b;
    }

    public int h0() {
        return this.returnTypeId_;
    }

    public int i0() {
        return this.setterFlags_;
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
        if (!q0()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (u0() && !g0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < l0(); i10++) {
            if (!k0(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (s0() && !e0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < V(); i11++) {
            if (!U(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (x0() && !j0().isInitialized()) {
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

    public u j0() {
        return this.setterValueParameter_;
    }

    public s k0(int i10) {
        return this.typeParameter_.get(i10);
    }

    public int l0() {
        return this.typeParameter_.size();
    }

    public List<s> m0() {
        return this.typeParameter_;
    }

    public List<Integer> n0() {
        return this.versionRequirement_;
    }

    public boolean o0() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean p0() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean q0() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean r0() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean s0() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean t0() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean u0() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean v0() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean w0() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean x0() {
        return (this.bitField0_ & 128) == 128;
    }

    private n(kotlin.reflect.jvm.internal.impl.protobuf.i.c<n, ?> cVar) {
        super(cVar);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b A0(n nVar) {
        return z0().m(nVar);
    }

    public static b z0() {
        return b.y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return z0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return A0(this);
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
        if ((this.bitField0_ & 128) == 128) {
            fVar.d0(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            fVar.a0(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            fVar.a0(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.a0(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            fVar.a0(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(11, this.flags_);
        }
        for (int i11 = 0; i11 < this.contextReceiverType_.size(); i11++) {
            fVar.d0(12, this.contextReceiverType_.get(i11));
        }
        if (W().size() > 0) {
            fVar.o0(106);
            fVar.o0(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i12 = 0; i12 < this.contextReceiverTypeId_.size(); i12++) {
            fVar.b0(this.contextReceiverTypeId_.get(i12).intValue());
        }
        for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
            fVar.a0(31, this.versionRequirement_.get(i13).intValue());
        }
        aVarX.a(19000, fVar);
        fVar.i0(this.unknownFields);
    }

    private n(boolean z10) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private n(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        y0();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
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
                                u.b bVarA0 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.c() : null;
                                u uVar = (u) eVar.u(u.f20360b, gVar);
                                this.setterValueParameter_ = uVar;
                                if (bVarA0 != null) {
                                    bVarA0.m(uVar);
                                    this.setterValueParameter_ = bVarA0.v();
                                }
                                this.bitField0_ |= 128;
                                continue;
                            case 56:
                                this.bitField0_ |= 256;
                                this.getterFlags_ = eVar.s();
                                continue;
                            case 64:
                                this.bitField0_ |= 512;
                                this.setterFlags_ = eVar.s();
                                continue;
                            case 72:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = eVar.s();
                                continue;
                            case 80:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = eVar.s();
                                continue;
                            case 88:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                                continue;
                            case 98:
                                if ((i10 & 256) != 256) {
                                    this.contextReceiverType_ = new ArrayList();
                                    i10 |= 256;
                                }
                                this.contextReceiverType_.add((q) eVar.u(q.f20300b, gVar));
                                continue;
                            case 104:
                                if ((i10 & 512) != 512) {
                                    this.contextReceiverTypeId_ = new ArrayList();
                                    i10 |= 512;
                                }
                                this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                                continue;
                            case 106:
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
                            case 248:
                                if ((i10 & 8192) != 8192) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 8192;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                continue;
                            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                int iJ2 = eVar.j(eVar.A());
                                if ((i10 & 8192) != 8192 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 8192;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ2);
                                continue;
                            default:
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i10 & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((i10 & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((i10 & 8192) == 8192) {
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
        if ((i10 & 256) == 256) {
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        }
        if ((i10 & 512) == 512) {
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        }
        if ((i10 & 8192) == 8192) {
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
