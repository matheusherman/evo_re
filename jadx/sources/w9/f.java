package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class f extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f20183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<f> f20184b = new a();
    private int bitField0_;
    private h conclusionOfConditionalEffect_;
    private List<h> effectConstructorArgument_;
    private c effectType_;
    private d kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<f> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public f b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new f(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<f, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c f20186c = c.RETURNS_CONSTANT;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<h> f20187d = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private h f20188e = h.E();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f20189f = d.AT_MOST_ONCE;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            f fVar = null;
            try {
                try {
                    f fVarB = f.f20184b.b(eVar, gVar);
                    if (fVarB != null) {
                        m(fVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    f fVar2 = (f) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        fVar = fVar2;
                        if (fVar != null) {
                            m(fVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fVar != null) {
                    m(fVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        private void u() {
            if ((this.f20185b & 2) != 2) {
                this.f20187d = new ArrayList(this.f20187d);
                this.f20185b |= 2;
            }
        }

        public f q() {
            f fVar = new f(this, (w9.a) null);
            int i10 = this.f20185b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            fVar.effectType_ = this.f20186c;
            if ((this.f20185b & 2) == 2) {
                this.f20187d = Collections.unmodifiableList(this.f20187d);
                this.f20185b &= -3;
            }
            fVar.effectConstructorArgument_ = this.f20187d;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            fVar.conclusionOfConditionalEffect_ = this.f20188e;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            fVar.kind_ = this.f20189f;
            fVar.bitField0_ = i11;
            return fVar;
        }

        public b x(h hVar) {
            if ((this.f20185b & 4) != 4 || this.f20188e == h.E()) {
                this.f20188e = hVar;
            } else {
                this.f20188e = h.T(this.f20188e).m(hVar).q();
            }
            this.f20185b |= 4;
            return this;
        }

        private b() {
            v();
        }

        public b A(c cVar) {
            cVar.getClass();
            this.f20185b |= 1;
            this.f20186c = cVar;
            return this;
        }

        public b C(d dVar) {
            dVar.getClass();
            this.f20185b |= 8;
            this.f20189f = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public f build() {
            f fVarQ = q();
            if (fVarQ.isInitialized()) {
                return fVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(fVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public b m(f fVar) {
            if (fVar == f.y()) {
                return this;
            }
            if (fVar.E()) {
                A(fVar.B());
            }
            if (!fVar.effectConstructorArgument_.isEmpty()) {
                if (this.f20187d.isEmpty()) {
                    this.f20187d = fVar.effectConstructorArgument_;
                    this.f20185b &= -3;
                } else {
                    u();
                    this.f20187d.addAll(fVar.effectConstructorArgument_);
                }
            }
            if (fVar.D()) {
                x(fVar.x());
            }
            if (fVar.F()) {
                C(fVar.C());
            }
            n(l().f(fVar.unknownFields));
            return this;
        }

        private void v() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<c> f20193d = new a();
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
                return RETURNS_CONSTANT;
            }
            if (i10 == 1) {
                return CALLS;
            }
            if (i10 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        c(int i10, int i11) {
            this.value = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum d implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<d> f20198d = new a();
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.a(i10);
            }
        }

        public static d a(int i10) {
            if (i10 == 0) {
                return AT_MOST_ONCE;
            }
            if (i10 == 1) {
                return EXACTLY_ONCE;
            }
            if (i10 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        d(int i10, int i11) {
            this.value = i11;
        }
    }

    /* synthetic */ f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        f fVar = new f(true);
        f20183a = fVar;
        fVar.G();
    }

    /* synthetic */ f(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    private void G() {
        this.effectType_ = c.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.EMPTY_LIST;
        this.conclusionOfConditionalEffect_ = h.E();
        this.kind_ = d.AT_MOST_ONCE;
    }

    public static f y() {
        return f20183a;
    }

    public int A() {
        return this.effectConstructorArgument_.size();
    }

    public c B() {
        return this.effectType_;
    }

    public d C() {
        return this.kind_;
    }

    public boolean D() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean E() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean F() {
        return (this.bitField0_ & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iH = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.effectType_.h()) : 0;
        for (int i11 = 0; i11 < this.effectConstructorArgument_.size(); i11++) {
            iH += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.effectConstructorArgument_.get(i11));
        }
        if ((this.bitField0_ & 2) == 2) {
            iH += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iH += kotlin.reflect.jvm.internal.impl.protobuf.f.h(4, this.kind_.h());
        }
        int size = iH + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<f> h() {
        return f20184b;
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
        for (int i10 = 0; i10 < A(); i10++) {
            if (!z(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (!D() || x().isInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    public h x() {
        return this.conclusionOfConditionalEffect_;
    }

    public h z(int i10) {
        return this.effectConstructorArgument_.get(i10);
    }

    private f(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b H() {
        return b.t();
    }

    public static b I(f fVar) {
        return H().m(fVar);
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
        if ((this.bitField0_ & 1) == 1) {
            fVar.S(1, this.effectType_.h());
        }
        for (int i10 = 0; i10 < this.effectConstructorArgument_.size(); i10++) {
            fVar.d0(2, this.effectConstructorArgument_.get(i10));
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.d0(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.S(4, this.kind_.h());
        }
        fVar.i0(this.unknownFields);
    }

    private f(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        G();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            int iN = eVar.n();
                            c cVarA = c.a(iN);
                            if (cVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = cVarA;
                            }
                        } else if (iK == 18) {
                            if ((c10 & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                c10 = 2;
                            }
                            this.effectConstructorArgument_.add((h) eVar.u(h.f20205b, gVar));
                        } else if (iK == 26) {
                            h.b bVarC = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.c() : null;
                            h hVar = (h) eVar.u(h.f20205b, gVar);
                            this.conclusionOfConditionalEffect_ = hVar;
                            if (bVarC != null) {
                                bVarC.m(hVar);
                                this.conclusionOfConditionalEffect_ = bVarC.q();
                            }
                            this.bitField0_ |= 2;
                        } else if (iK != 32) {
                            if (!o(eVar, fVarJ, gVar, iK)) {
                            }
                        } else {
                            int iN2 = eVar.n();
                            d dVarA = d.a(iN2);
                            if (dVarA == null) {
                                fVarJ.o0(iK);
                                fVarJ.o0(iN2);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = dVarA;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
        if ((c10 & 2) == 2) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
