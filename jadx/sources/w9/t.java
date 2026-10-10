package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class t extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final t f20354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<t> f20355b = new a();
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<q> type_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<t> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public t b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new t(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<t, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<q> f20357c = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20358d = -1;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            t tVar = null;
            try {
                try {
                    t tVarB = t.f20355b.b(eVar, gVar);
                    if (tVarB != null) {
                        m(tVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    t tVar2 = (t) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        tVar = tVar2;
                        if (tVar != null) {
                            m(tVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (tVar != null) {
                    m(tVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        private void u() {
            if ((this.f20356b & 1) != 1) {
                this.f20357c = new ArrayList(this.f20357c);
                this.f20356b |= 1;
            }
        }

        public t q() {
            t tVar = new t(this, (w9.a) null);
            int i10 = this.f20356b;
            if ((i10 & 1) == 1) {
                this.f20357c = Collections.unmodifiableList(this.f20357c);
                this.f20356b &= -2;
            }
            tVar.type_ = this.f20357c;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            tVar.firstNullable_ = this.f20358d;
            tVar.bitField0_ = i11;
            return tVar;
        }

        public b z(int i10) {
            this.f20356b |= 2;
            this.f20358d = i10;
            return this;
        }

        private b() {
            v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public t build() {
            t tVarQ = q();
            if (tVarQ.isInitialized()) {
                return tVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(tVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b m(t tVar) {
            if (tVar == t.v()) {
                return this;
            }
            if (!tVar.type_.isEmpty()) {
                if (this.f20357c.isEmpty()) {
                    this.f20357c = tVar.type_;
                    this.f20356b &= -2;
                } else {
                    u();
                    this.f20357c.addAll(tVar.type_);
                }
            }
            if (tVar.A()) {
                z(tVar.w());
            }
            n(l().f(tVar.unknownFields));
            return this;
        }

        private void v() {
        }
    }

    /* synthetic */ t(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        t tVar = new t(true);
        f20354a = tVar;
        tVar.B();
    }

    /* synthetic */ t(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    private void B() {
        this.type_ = Collections.EMPTY_LIST;
        this.firstNullable_ = -1;
    }

    public static t v() {
        return f20354a;
    }

    public boolean A() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = 0;
        for (int i11 = 0; i11 < this.type_.size(); i11++) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.type_.get(i11));
        }
        if ((this.bitField0_ & 1) == 1) {
            iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.firstNullable_);
        }
        int size = iO + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<t> h() {
        return f20355b;
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
        for (int i10 = 0; i10 < y(); i10++) {
            if (!x(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public int w() {
        return this.firstNullable_;
    }

    public q x(int i10) {
        return this.type_.get(i10);
    }

    public int y() {
        return this.type_.size();
    }

    public List<q> z() {
        return this.type_;
    }

    private t(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b C() {
        return b.t();
    }

    public static b D(t tVar) {
        return C().m(tVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public b g() {
        return C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public b c() {
        return D(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        for (int i10 = 0; i10 < this.type_.size(); i10++) {
            fVar.d0(1, this.type_.get(i10));
        }
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(2, this.firstNullable_);
        }
        fVar.i0(this.unknownFields);
    }

    private t(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private t(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        B();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 10) {
                            if (!z11) {
                                this.type_ = new ArrayList();
                                z11 = true;
                            }
                            this.type_.add((q) eVar.u(q.f20300b, gVar));
                        } else if (iK != 16) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.firstNullable_ = eVar.s();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.type_ = Collections.unmodifiableList(this.type_);
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
        if (z11) {
            this.type_ = Collections.unmodifiableList(this.type_);
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
