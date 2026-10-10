package w9;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<g> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f20200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<g> f20201b = new a();
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<g> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public g b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new g(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<g, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20203e;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            g gVar2 = null;
            try {
                try {
                    g gVarB = g.f20201b.b(eVar, gVar);
                    if (gVarB != null) {
                        m(gVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    g gVar3 = (g) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        gVar2 = gVar3;
                        if (gVar2 != null) {
                            m(gVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (gVar2 != null) {
                    m(gVar2);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        public b D(int i10) {
            this.f20202d |= 1;
            this.f20203e = i10;
            return this;
        }

        public g v() {
            g gVar = new g(this, (w9.a) null);
            int i10 = (this.f20202d & 1) != 1 ? 0 : 1;
            gVar.name_ = this.f20203e;
            gVar.bitField0_ = i10;
            return gVar;
        }

        private b() {
            z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b m(g gVar) {
            if (gVar == g.C()) {
                return this;
            }
            if (gVar.F()) {
                D(gVar.E());
            }
            s(gVar);
            n(l().f(gVar.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public g build() {
            g gVarV = v();
            if (gVarV.isInitialized()) {
                return gVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(gVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void z() {
        }
    }

    /* synthetic */ g(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void G() {
        this.name_ = 0;
    }

    static {
        g gVar = new g(true);
        f20200a = gVar;
        gVar.G();
    }

    /* synthetic */ g(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<g, ?>) cVar);
    }

    public static g C() {
        return f20200a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public g a() {
        return f20200a;
    }

    public int E() {
        return this.name_;
    }

    public boolean F() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = ((this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.name_) : 0) + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iO;
        return iO;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<g> h() {
        return f20201b;
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
        if (r()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    private g(kotlin.reflect.jvm.internal.impl.protobuf.i.c<g, ?> cVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b H() {
        return b.y();
    }

    public static b I(g gVar) {
        return H().m(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public b g() {
        return H();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b c() {
        return I(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.name_);
        }
        aVarX.a(200, fVar);
        fVar.i0(this.unknownFields);
    }

    private g(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private g(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        G();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK != 8) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            this.bitField0_ |= 1;
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
