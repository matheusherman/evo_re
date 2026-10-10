package w9;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class r extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<r> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r f20328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<r> f20329b = new a();
    private List<w9.b> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private q expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<s> typeParameter_;
    private int underlyingTypeId_;
    private q underlyingType_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<r> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public r b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new r(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<r, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20331e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20332f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<s> f20333g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private q f20334h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20335i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private q f20336j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20337k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<w9.b> f20338l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<Integer> f20339m;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            r rVar = null;
            try {
                try {
                    r rVarB = r.f20329b.b(eVar, gVar);
                    if (rVarB != null) {
                        m(rVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    r rVar2 = (r) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        rVar = rVar2;
                        if (rVar != null) {
                            m(rVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rVar != null) {
                    m(rVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20330d & 4) != 4) {
                this.f20333g = new ArrayList(this.f20333g);
                this.f20330d |= 4;
            }
        }

        private void C() {
            if ((this.f20330d & 256) != 256) {
                this.f20339m = new ArrayList(this.f20339m);
                this.f20330d |= 256;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20330d & 128) != 128) {
                this.f20338l = new ArrayList(this.f20338l);
                this.f20330d |= 128;
            }
        }

        public b E(q qVar) {
            if ((this.f20330d & 32) != 32 || this.f20336j == q.X()) {
                this.f20336j = qVar;
            } else {
                this.f20336j = q.y0(this.f20336j).m(qVar).v();
            }
            this.f20330d |= 32;
            return this;
        }

        public b H(q qVar) {
            if ((this.f20330d & 8) != 8 || this.f20334h == q.X()) {
                this.f20334h = qVar;
            } else {
                this.f20334h = q.y0(this.f20334h).m(qVar).v();
            }
            this.f20330d |= 8;
            return this;
        }

        public b I(int i10) {
            this.f20330d |= 64;
            this.f20337k = i10;
            return this;
        }

        public b K(int i10) {
            this.f20330d |= 1;
            this.f20331e = i10;
            return this;
        }

        public b L(int i10) {
            this.f20330d |= 2;
            this.f20332f = i10;
            return this;
        }

        public b N(int i10) {
            this.f20330d |= 16;
            this.f20335i = i10;
            return this;
        }

        public r v() {
            r rVar = new r(this, (w9.a) null);
            int i10 = this.f20330d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            rVar.flags_ = this.f20331e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            rVar.name_ = this.f20332f;
            if ((this.f20330d & 4) == 4) {
                this.f20333g = Collections.unmodifiableList(this.f20333g);
                this.f20330d &= -5;
            }
            rVar.typeParameter_ = this.f20333g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            rVar.underlyingType_ = this.f20334h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            rVar.underlyingTypeId_ = this.f20335i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            rVar.expandedType_ = this.f20336j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            rVar.expandedTypeId_ = this.f20337k;
            if ((this.f20330d & 128) == 128) {
                this.f20338l = Collections.unmodifiableList(this.f20338l);
                this.f20330d &= -129;
            }
            rVar.annotation_ = this.f20338l;
            if ((this.f20330d & 256) == 256) {
                this.f20339m = Collections.unmodifiableList(this.f20339m);
                this.f20330d &= -257;
            }
            rVar.versionRequirement_ = this.f20339m;
            rVar.bitField0_ = i11;
            return rVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20333g = list;
            this.f20334h = q.X();
            this.f20336j = q.X();
            this.f20338l = list;
            this.f20339m = list;
            D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b m(r rVar) {
            if (rVar == r.R()) {
                return this;
            }
            if (rVar.f0()) {
                K(rVar.V());
            }
            if (rVar.g0()) {
                L(rVar.W());
            }
            if (!rVar.typeParameter_.isEmpty()) {
                if (this.f20333g.isEmpty()) {
                    this.f20333g = rVar.typeParameter_;
                    this.f20330d &= -5;
                } else {
                    A();
                    this.f20333g.addAll(rVar.typeParameter_);
                }
            }
            if (rVar.h0()) {
                H(rVar.a0());
            }
            if (rVar.i0()) {
                N(rVar.b0());
            }
            if (rVar.d0()) {
                E(rVar.T());
            }
            if (rVar.e0()) {
                I(rVar.U());
            }
            if (!rVar.annotation_.isEmpty()) {
                if (this.f20338l.isEmpty()) {
                    this.f20338l = rVar.annotation_;
                    this.f20330d &= -129;
                } else {
                    z();
                    this.f20338l.addAll(rVar.annotation_);
                }
            }
            if (!rVar.versionRequirement_.isEmpty()) {
                if (this.f20339m.isEmpty()) {
                    this.f20339m = rVar.versionRequirement_;
                    this.f20330d &= -257;
                } else {
                    C();
                    this.f20339m.addAll(rVar.versionRequirement_);
                }
            }
            s(rVar);
            n(l().f(rVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public r build() {
            r rVarV = v();
            if (rVarV.isInitialized()) {
                return rVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(rVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void D() {
        }
    }

    /* synthetic */ r(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void j0() {
        this.flags_ = 6;
        this.name_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.underlyingType_ = q.X();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = q.X();
        this.expandedTypeId_ = 0;
        this.annotation_ = list;
        this.versionRequirement_ = list;
    }

    static {
        r rVar = new r(true);
        f20328a = rVar;
        rVar.j0();
    }

    /* synthetic */ r(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<r, ?>) cVar);
    }

    public static r R() {
        return f20328a;
    }

    public static r n0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f20329b.c(inputStream, gVar);
    }

    public w9.b O(int i10) {
        return this.annotation_.get(i10);
    }

    public int P() {
        return this.annotation_.size();
    }

    public List<w9.b> Q() {
        return this.annotation_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public r a() {
        return f20328a;
    }

    public q T() {
        return this.expandedType_;
    }

    public int U() {
        return this.expandedTypeId_;
    }

    public int V() {
        return this.flags_;
    }

    public int W() {
        return this.name_;
    }

    public s X(int i10) {
        return this.typeParameter_.get(i10);
    }

    public int Y() {
        return this.typeParameter_.size();
    }

    public List<s> Z() {
        return this.typeParameter_;
    }

    public q a0() {
        return this.underlyingType_;
    }

    public int b0() {
        return this.underlyingTypeId_;
    }

    public List<Integer> c0() {
        return this.versionRequirement_;
    }

    public boolean d0() {
        return (this.bitField0_ & 16) == 16;
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
        for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.typeParameter_.get(i11));
        }
        if ((this.bitField0_ & 4) == 4) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.expandedTypeId_);
        }
        for (int i12 = 0; i12 < this.annotation_.size(); i12++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.annotation_.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.versionRequirement_.get(i13).intValue());
        }
        int size = iO + iP + (c0().size() * 2) + s() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean e0() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean f0() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean g0() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<r> h() {
        return f20329b;
    }

    public boolean h0() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean i0() {
        return (this.bitField0_ & 8) == 8;
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
        if (!g0()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Y(); i10++) {
            if (!X(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (h0() && !a0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (d0() && !T().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < P(); i11++) {
            if (!O(i11).isInitialized()) {
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

    private r(kotlin.reflect.jvm.internal.impl.protobuf.i.c<r, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b k0() {
        return b.y();
    }

    public static b l0(r rVar) {
        return k0().m(rVar);
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
        for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
            fVar.d0(3, this.typeParameter_.get(i10));
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.d0(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.a0(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.d0(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.a0(7, this.expandedTypeId_);
        }
        for (int i11 = 0; i11 < this.annotation_.size(); i11++) {
            fVar.d0(8, this.annotation_.get(i11));
        }
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            fVar.a0(31, this.versionRequirement_.get(i12).intValue());
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return k0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return l0(this);
    }

    private r(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private r(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        q.c cVarC;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        j0();
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
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.s();
                            continue;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = eVar.s();
                            continue;
                        case 26:
                            if ((i10 & 4) != 4) {
                                this.typeParameter_ = new ArrayList();
                                i10 |= 4;
                            }
                            this.typeParameter_.add((s) eVar.u(s.f20341b, gVar));
                            continue;
                        case 34:
                            cVarC = (this.bitField0_ & 4) == 4 ? this.underlyingType_.c() : null;
                            q qVar = (q) eVar.u(q.f20300b, gVar);
                            this.underlyingType_ = qVar;
                            if (cVarC != null) {
                                cVarC.m(qVar);
                                this.underlyingType_ = cVarC.v();
                            }
                            this.bitField0_ |= 4;
                            continue;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = eVar.s();
                            continue;
                        case 50:
                            cVarC = (this.bitField0_ & 16) == 16 ? this.expandedType_.c() : null;
                            q qVar2 = (q) eVar.u(q.f20300b, gVar);
                            this.expandedType_ = qVar2;
                            if (cVarC != null) {
                                cVarC.m(qVar2);
                                this.expandedType_ = cVarC.v();
                            }
                            this.bitField0_ |= 16;
                            continue;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = eVar.s();
                            continue;
                        case 66:
                            if ((i10 & 128) != 128) {
                                this.annotation_ = new ArrayList();
                                i10 |= 128;
                            }
                            this.annotation_.add((w9.b) eVar.u(w9.b.f20101b, gVar));
                            continue;
                        case 248:
                            if ((i10 & 256) != 256) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 256;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            continue;
                        case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                            int iJ = eVar.j(eVar.A());
                            if ((i10 & 256) != 256 && eVar.e() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 256;
                            }
                            while (eVar.e() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ);
                            continue;
                        default:
                            if (!o(eVar, fVarJ, gVar, iK)) {
                                break;
                            }
                            break;
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i10 & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i10 & 256) == 256) {
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
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 4) == 4) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i10 & 128) == 128) {
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        }
        if ((i10 & 256) == 256) {
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
