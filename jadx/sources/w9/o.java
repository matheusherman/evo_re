package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class o extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o f20280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<o> f20281b = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<c> qualifiedName_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<o> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public o b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new o(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<o, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<c> f20283c = Collections.EMPTY_LIST;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            o oVar = null;
            try {
                try {
                    o oVarB = o.f20281b.b(eVar, gVar);
                    if (oVarB != null) {
                        m(oVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    o oVar2 = (o) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        oVar = oVar2;
                        if (oVar != null) {
                            m(oVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (oVar != null) {
                    m(oVar);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        private void u() {
            if ((this.f20282b & 1) != 1) {
                this.f20283c = new ArrayList(this.f20283c);
                this.f20282b |= 1;
            }
        }

        public o q() {
            o oVar = new o(this, (w9.a) null);
            if ((this.f20282b & 1) == 1) {
                this.f20283c = Collections.unmodifiableList(this.f20283c);
                this.f20282b &= -2;
            }
            oVar.qualifiedName_ = this.f20283c;
            return oVar;
        }

        private b() {
            v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public o build() {
            o oVarQ = q();
            if (oVarQ.isInitialized()) {
                return oVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(oVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b m(o oVar) {
            if (oVar == o.t()) {
                return this;
            }
            if (!oVar.qualifiedName_.isEmpty()) {
                if (this.f20283c.isEmpty()) {
                    this.f20283c = oVar.qualifiedName_;
                    this.f20282b &= -2;
                } else {
                    u();
                    this.f20283c.addAll(oVar.qualifiedName_);
                }
            }
            n(l().f(oVar.unknownFields));
            return this;
        }

        private void v() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f20284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f20285b = new a();
        private int bitField0_;
        private EnumC0389c kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                return new c(eVar, gVar, null);
            }

            a() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<c, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f20286b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f20288d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f20287c = -1;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private EnumC0389c f20289e = EnumC0389c.PACKAGE;

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarB = c.f20285b.b(eVar, gVar);
                        if (cVarB != null) {
                            m(cVarB);
                        }
                        return this;
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                        c cVar2 = (c) e10.a();
                        try {
                            throw e10;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                m(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                        m(cVar);
                    }
                    throw th;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b t() {
                return new b();
            }

            public b A(int i10) {
                this.f20286b |= 2;
                this.f20288d = i10;
                return this;
            }

            public c q() {
                c cVar = new c(this, (w9.a) null);
                int i10 = this.f20286b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.parentQualifiedName_ = this.f20287c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.shortName_ = this.f20288d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                cVar.kind_ = this.f20289e;
                cVar.bitField0_ = i11;
                return cVar;
            }

            public b z(int i10) {
                this.f20286b |= 1;
                this.f20287c = i10;
                return this;
            }

            private b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public c build() {
                c cVarQ = q();
                if (cVarQ.isInitialized()) {
                    return cVarQ;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(cVarQ);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b k() {
                return t().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public b m(c cVar) {
                if (cVar == c.v()) {
                    return this;
                }
                if (cVar.A()) {
                    z(cVar.x());
                }
                if (cVar.B()) {
                    A(cVar.y());
                }
                if (cVar.z()) {
                    y(cVar.w());
                }
                n(l().f(cVar.unknownFields));
                return this;
            }

            public b y(EnumC0389c enumC0389c) {
                enumC0389c.getClass();
                this.f20286b |= 4;
                this.f20289e = enumC0389c;
                return this;
            }

            private void u() {
            }
        }

        /* JADX INFO: renamed from: w9.o$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public enum EnumC0389c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);


            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0389c> f20293d = new a();
            private final int value;

            /* JADX INFO: renamed from: w9.o$c$c$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0389c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0389c a(int i10) {
                    return EnumC0389c.a(i10);
                }
            }

            public static EnumC0389c a(int i10) {
                if (i10 == 0) {
                    return CLASS;
                }
                if (i10 == 1) {
                    return PACKAGE;
                }
                if (i10 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
            public final int h() {
                return this.value;
            }

            EnumC0389c(int i10, int i11) {
                this.value = i11;
            }
        }

        /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
            this(eVar, gVar);
        }

        private void C() {
            this.parentQualifiedName_ = -1;
            this.shortName_ = 0;
            this.kind_ = EnumC0389c.PACKAGE;
        }

        static {
            c cVar = new c(true);
            f20284a = cVar;
            cVar.C();
        }

        /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
            this(bVar);
        }

        public static c v() {
            return f20284a;
        }

        public boolean A() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean B() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.parentQualifiedName_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.kind_.h());
            }
            int size = iO + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<c> h() {
            return f20285b;
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
            if (B()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public EnumC0389c w() {
            return this.kind_;
        }

        public int x() {
            return this.parentQualifiedName_;
        }

        public int y() {
            return this.shortName_;
        }

        public boolean z() {
            return (this.bitField0_ & 4) == 4;
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static b D() {
            return b.t();
        }

        public static b E(c cVar) {
            return D().m(cVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b g() {
            return D();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b c() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.S(3, this.kind_.h());
            }
            fVar.i0(this.unknownFields);
        }

        private c(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            C();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = eVar.s();
                                } else if (iK == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = eVar.s();
                                } else if (iK != 24) {
                                    if (!o(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    int iN = eVar.n();
                                    EnumC0389c enumC0389cA = EnumC0389c.a(iN);
                                    if (enumC0389cA == null) {
                                        fVarJ.o0(iK);
                                        fVarJ.o0(iN);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = enumC0389cA;
                                    }
                                }
                            }
                            z10 = true;
                        } catch (IOException e10) {
                            throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                        throw e11.i(this);
                    }
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

    /* synthetic */ o(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        o oVar = new o(true);
        f20280a = oVar;
        oVar.w();
    }

    /* synthetic */ o(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    public static o t() {
        return f20280a;
    }

    private void w() {
        this.qualifiedName_ = Collections.EMPTY_LIST;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.qualifiedName_.size(); i11++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.qualifiedName_.get(i11));
        }
        int size = iS + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<o> h() {
        return f20281b;
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
        for (int i10 = 0; i10 < v(); i10++) {
            if (!u(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public c u(int i10) {
        return this.qualifiedName_.get(i10);
    }

    public int v() {
        return this.qualifiedName_.size();
    }

    private o(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b x() {
        return b.t();
    }

    public static b y(o oVar) {
        return x().m(oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b c() {
        return y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        for (int i10 = 0; i10 < this.qualifiedName_.size(); i10++) {
            fVar.d0(1, this.qualifiedName_.get(i10));
        }
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b g() {
        return x();
    }

    private o(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private o(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        w();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarJ = kotlin.reflect.jvm.internal.impl.protobuf.f.J(bVarU, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if (!z11) {
                                    this.qualifiedName_ = new ArrayList();
                                    z11 = true;
                                }
                                this.qualifiedName_.add((c) eVar.u(c.f20285b, gVar));
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
                if (z11) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
        if (z11) {
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
