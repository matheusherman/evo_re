package w9;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<l> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l f20248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<l> f20249b = new a();
    private int bitField0_;
    private List<i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<n> property_;
    private List<r> typeAlias_;
    private t typeTable_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private w versionRequirementTable_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<l> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public l b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new l(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<l, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20250d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<i> f20251e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<n> f20252f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<r> f20253g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private t f20254h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private w f20255i;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            l lVar = null;
            try {
                try {
                    l lVarB = l.f20249b.b(eVar, gVar);
                    if (lVarB != null) {
                        m(lVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    l lVar2 = (l) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        lVar = lVar2;
                        if (lVar != null) {
                            m(lVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lVar != null) {
                    m(lVar);
                }
                throw th;
            }
        }

        private void A() {
            if ((this.f20250d & 2) != 2) {
                this.f20252f = new ArrayList(this.f20252f);
                this.f20250d |= 2;
            }
        }

        private void C() {
            if ((this.f20250d & 4) != 4) {
                this.f20253g = new ArrayList(this.f20253g);
                this.f20250d |= 4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20250d & 1) != 1) {
                this.f20251e = new ArrayList(this.f20251e);
                this.f20250d |= 1;
            }
        }

        public b G(t tVar) {
            if ((this.f20250d & 8) != 8 || this.f20254h == t.v()) {
                this.f20254h = tVar;
            } else {
                this.f20254h = t.D(this.f20254h).m(tVar).q();
            }
            this.f20250d |= 8;
            return this;
        }

        public b H(w wVar) {
            if ((this.f20250d & 16) != 16 || this.f20255i == w.t()) {
                this.f20255i = wVar;
            } else {
                this.f20255i = w.y(this.f20255i).m(wVar).q();
            }
            this.f20250d |= 16;
            return this;
        }

        public l v() {
            l lVar = new l(this, (w9.a) null);
            int i10 = this.f20250d;
            if ((i10 & 1) == 1) {
                this.f20251e = Collections.unmodifiableList(this.f20251e);
                this.f20250d &= -2;
            }
            lVar.function_ = this.f20251e;
            if ((this.f20250d & 2) == 2) {
                this.f20252f = Collections.unmodifiableList(this.f20252f);
                this.f20250d &= -3;
            }
            lVar.property_ = this.f20252f;
            if ((this.f20250d & 4) == 4) {
                this.f20253g = Collections.unmodifiableList(this.f20253g);
                this.f20250d &= -5;
            }
            lVar.typeAlias_ = this.f20253g;
            int i11 = (i10 & 8) != 8 ? 0 : 1;
            lVar.typeTable_ = this.f20254h;
            if ((i10 & 16) == 16) {
                i11 |= 2;
            }
            lVar.versionRequirementTable_ = this.f20255i;
            lVar.bitField0_ = i11;
            return lVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20251e = list;
            this.f20252f = list;
            this.f20253g = list;
            this.f20254h = t.v();
            this.f20255i = w.t();
            D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b m(l lVar) {
            if (lVar == l.J()) {
                return this;
            }
            if (!lVar.function_.isEmpty()) {
                if (this.f20251e.isEmpty()) {
                    this.f20251e = lVar.function_;
                    this.f20250d &= -2;
                } else {
                    z();
                    this.f20251e.addAll(lVar.function_);
                }
            }
            if (!lVar.property_.isEmpty()) {
                if (this.f20252f.isEmpty()) {
                    this.f20252f = lVar.property_;
                    this.f20250d &= -3;
                } else {
                    A();
                    this.f20252f.addAll(lVar.property_);
                }
            }
            if (!lVar.typeAlias_.isEmpty()) {
                if (this.f20253g.isEmpty()) {
                    this.f20253g = lVar.typeAlias_;
                    this.f20250d &= -5;
                } else {
                    C();
                    this.f20253g.addAll(lVar.typeAlias_);
                }
            }
            if (lVar.X()) {
                G(lVar.V());
            }
            if (lVar.Y()) {
                H(lVar.W());
            }
            s(lVar);
            n(l().f(lVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public l build() {
            l lVarV = v();
            if (lVarV.isInitialized()) {
                return lVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(lVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void D() {
        }
    }

    /* synthetic */ l(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        l lVar = new l(true);
        f20248a = lVar;
        lVar.Z();
    }

    /* synthetic */ l(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<l, ?>) cVar);
    }

    public static l J() {
        return f20248a;
    }

    private void Z() {
        List list = Collections.EMPTY_LIST;
        this.function_ = list;
        this.property_ = list;
        this.typeAlias_ = list;
        this.typeTable_ = t.v();
        this.versionRequirementTable_ = w.t();
    }

    public static l d0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f20249b.a(inputStream, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public l a() {
        return f20248a;
    }

    public i L(int i10) {
        return this.function_.get(i10);
    }

    public int N() {
        return this.function_.size();
    }

    public List<i> O() {
        return this.function_;
    }

    public n P(int i10) {
        return this.property_.get(i10);
    }

    public int Q() {
        return this.property_.size();
    }

    public List<n> R() {
        return this.property_;
    }

    public r S(int i10) {
        return this.typeAlias_.get(i10);
    }

    public int T() {
        return this.typeAlias_.size();
    }

    public List<r> U() {
        return this.typeAlias_;
    }

    public t V() {
        return this.typeTable_;
    }

    public w W() {
        return this.versionRequirementTable_;
    }

    public boolean X() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean Y() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.function_.size(); i11++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.function_.get(i11));
        }
        for (int i12 = 0; i12 < this.property_.size(); i12++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.property_.get(i12));
        }
        for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.typeAlias_.get(i13));
        }
        if ((this.bitField0_ & 1) == 1) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.versionRequirementTable_);
        }
        int iS2 = iS + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS2;
        return iS2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<l> h() {
        return f20249b;
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
        for (int i10 = 0; i10 < N(); i10++) {
            if (!L(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < Q(); i11++) {
            if (!P(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < T(); i12++) {
            if (!S(i12).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (X() && !V().isInitialized()) {
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

    private l(kotlin.reflect.jvm.internal.impl.protobuf.i.c<l, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b a0() {
        return b.y();
    }

    public static b b0(l lVar) {
        return a0().m(lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return a0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        for (int i10 = 0; i10 < this.function_.size(); i10++) {
            fVar.d0(3, this.function_.get(i10));
        }
        for (int i11 = 0; i11 < this.property_.size(); i11++) {
            fVar.d0(4, this.property_.get(i11));
        }
        for (int i12 = 0; i12 < this.typeAlias_.size(); i12++) {
            fVar.d0(5, this.typeAlias_.get(i12));
        }
        if ((this.bitField0_ & 1) == 1) {
            fVar.d0(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.d0(32, this.versionRequirementTable_);
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return b0(this);
    }

    private l(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private l(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        Z();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 26) {
                            if ((i10 & 1) != 1) {
                                this.function_ = new ArrayList();
                                i10 |= 1;
                            }
                            this.function_.add((i) eVar.u(i.f20220b, gVar));
                        } else if (iK == 34) {
                            if ((i10 & 2) != 2) {
                                this.property_ = new ArrayList();
                                i10 |= 2;
                            }
                            this.property_.add((n) eVar.u(n.f20264b, gVar));
                        } else if (iK != 42) {
                            if (iK == 242) {
                                t.b bVarF = (this.bitField0_ & 1) == 1 ? this.typeTable_.c() : null;
                                t tVar = (t) eVar.u(t.f20355b, gVar);
                                this.typeTable_ = tVar;
                                if (bVarF != null) {
                                    bVarF.m(tVar);
                                    this.typeTable_ = bVarF.q();
                                }
                                this.bitField0_ |= 1;
                            } else if (iK != 258) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                w.b bVarA = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.c() : null;
                                w wVar = (w) eVar.u(w.f20388b, gVar);
                                this.versionRequirementTable_ = wVar;
                                if (bVarA != null) {
                                    bVarA.m(wVar);
                                    this.versionRequirementTable_ = bVarA.q();
                                }
                                this.bitField0_ |= 2;
                            }
                        } else {
                            if ((i10 & 4) != 4) {
                                this.typeAlias_ = new ArrayList();
                                i10 |= 4;
                            }
                            this.typeAlias_.add((r) eVar.u(r.f20329b, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 1) == 1) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if ((i10 & 2) == 2) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if ((i10 & 4) == 4) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
        if ((i10 & 1) == 1) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i10 & 2) == 2) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i10 & 4) == 4) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
