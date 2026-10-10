package w9;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<m> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final m f20256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<m> f20257b = new a();
    private int bitField0_;
    private List<c> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private l package_;
    private o qualifiedNames_;
    private p strings_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<m> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public m b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new m(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<m, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private p f20259e = p.t();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private o f20260f = o.t();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private l f20261g = l.J();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<c> f20262h = Collections.EMPTY_LIST;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            m mVar = null;
            try {
                try {
                    m mVarB = m.f20257b.b(eVar, gVar);
                    if (mVarB != null) {
                        m(mVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    m mVar2 = (m) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        mVar = mVar2;
                        if (mVar != null) {
                            m(mVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (mVar != null) {
                    m(mVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20258d & 8) != 8) {
                this.f20262h = new ArrayList(this.f20262h);
                this.f20258d |= 8;
            }
        }

        public b E(l lVar) {
            if ((this.f20258d & 4) != 4 || this.f20261g == l.J()) {
                this.f20261g = lVar;
            } else {
                this.f20261g = l.b0(this.f20261g).m(lVar).v();
            }
            this.f20258d |= 4;
            return this;
        }

        public b F(o oVar) {
            if ((this.f20258d & 2) != 2 || this.f20260f == o.t()) {
                this.f20260f = oVar;
            } else {
                this.f20260f = o.y(this.f20260f).m(oVar).q();
            }
            this.f20258d |= 2;
            return this;
        }

        public b G(p pVar) {
            if ((this.f20258d & 1) != 1 || this.f20259e == p.t()) {
                this.f20259e = pVar;
            } else {
                this.f20259e = p.y(this.f20259e).m(pVar).q();
            }
            this.f20258d |= 1;
            return this;
        }

        public m v() {
            m mVar = new m(this, (w9.a) null);
            int i10 = this.f20258d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            mVar.strings_ = this.f20259e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            mVar.qualifiedNames_ = this.f20260f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            mVar.package_ = this.f20261g;
            if ((this.f20258d & 8) == 8) {
                this.f20262h = Collections.unmodifiableList(this.f20262h);
                this.f20258d &= -9;
            }
            mVar.class__ = this.f20262h;
            mVar.bitField0_ = i11;
            return mVar;
        }

        private b() {
            A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b m(m mVar) {
            if (mVar == m.J()) {
                return this;
            }
            if (mVar.R()) {
                G(mVar.O());
            }
            if (mVar.Q()) {
                F(mVar.N());
            }
            if (mVar.P()) {
                E(mVar.L());
            }
            if (!mVar.class__.isEmpty()) {
                if (this.f20262h.isEmpty()) {
                    this.f20262h = mVar.class__;
                    this.f20258d &= -9;
                } else {
                    z();
                    this.f20262h.addAll(mVar.class__);
                }
            }
            s(mVar);
            n(l().f(mVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public m build() {
            m mVarV = v();
            if (mVarV.isInitialized()) {
                return mVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(mVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void A() {
        }
    }

    /* synthetic */ m(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        m mVar = new m(true);
        f20256a = mVar;
        mVar.S();
    }

    /* synthetic */ m(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<m, ?>) cVar);
    }

    public static m J() {
        return f20256a;
    }

    public static m W(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f20257b.a(inputStream, gVar);
    }

    public c G(int i10) {
        return this.class__.get(i10);
    }

    public int H() {
        return this.class__.size();
    }

    public List<c> I() {
        return this.class__;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public m a() {
        return f20256a;
    }

    public l L() {
        return this.package_;
    }

    public o N() {
        return this.qualifiedNames_;
    }

    public p O() {
        return this.strings_;
    }

    public boolean P() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean Q() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean R() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iS = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.strings_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.package_);
        }
        for (int i11 = 0; i11 < this.class__.size(); i11++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.class__.get(i11));
        }
        int iS2 = iS + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS2;
        return iS2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<m> h() {
        return f20257b;
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
        if (Q() && !N().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (P() && !L().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < H(); i10++) {
            if (!G(i10).isInitialized()) {
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

    private m(kotlin.reflect.jvm.internal.impl.protobuf.i.c<m, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    private void S() {
        this.strings_ = p.t();
        this.qualifiedNames_ = o.t();
        this.package_ = l.J();
        this.class__ = Collections.EMPTY_LIST;
    }

    public static b T() {
        return b.y();
    }

    public static b U(m mVar) {
        return T().m(mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b g() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public b c() {
        return U(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.d0(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.d0(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.d0(3, this.package_);
        }
        for (int i10 = 0; i10 < this.class__.size(); i10++) {
            fVar.d0(4, this.class__.get(i10));
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    private m(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        S();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                p.b bVarC = (this.bitField0_ & 1) == 1 ? this.strings_.c() : null;
                                p pVar = (p) eVar.u(p.f20296b, gVar);
                                this.strings_ = pVar;
                                if (bVarC != null) {
                                    bVarC.m(pVar);
                                    this.strings_ = bVarC.q();
                                }
                                this.bitField0_ |= 1;
                            } else if (iK == 18) {
                                o.b bVarC2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.c() : null;
                                o oVar = (o) eVar.u(o.f20281b, gVar);
                                this.qualifiedNames_ = oVar;
                                if (bVarC2 != null) {
                                    bVarC2.m(oVar);
                                    this.qualifiedNames_ = bVarC2.q();
                                }
                                this.bitField0_ |= 2;
                            } else if (iK == 26) {
                                l.b bVarC3 = (this.bitField0_ & 4) == 4 ? this.package_.c() : null;
                                l lVar = (l) eVar.u(l.f20249b, gVar);
                                this.package_ = lVar;
                                if (bVarC3 != null) {
                                    bVarC3.m(lVar);
                                    this.package_ = bVarC3.v();
                                }
                                this.bitField0_ |= 4;
                            } else if (iK != 34) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if ((c10 & '\b') != 8) {
                                    this.class__ = new ArrayList();
                                    c10 = '\b';
                                }
                                this.class__.add((c) eVar.u(c.f20140b, gVar));
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
                if ((c10 & '\b') == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
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
        if ((c10 & '\b') == 8) {
            this.class__ = Collections.unmodifiableList(this.class__);
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
