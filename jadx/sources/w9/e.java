package w9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f20179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<e> f20180b = new a();
    private List<f> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<e> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public e b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new e(eVar, gVar, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.b<e, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<f> f20182c = Collections.EMPTY_LIST;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            e eVar2 = null;
            try {
                try {
                    e eVarB = e.f20180b.b(eVar, gVar);
                    if (eVarB != null) {
                        m(eVarB);
                    }
                    return this;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    e eVar3 = (e) e10.a();
                    try {
                        throw e10;
                    } catch (Throwable th) {
                        th = th;
                        eVar2 = eVar3;
                        if (eVar2 != null) {
                            m(eVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar2 != null) {
                    m(eVar2);
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b t() {
            return new b();
        }

        private void u() {
            if ((this.f20181b & 1) != 1) {
                this.f20182c = new ArrayList(this.f20182c);
                this.f20181b |= 1;
            }
        }

        public e q() {
            e eVar = new e(this, (w9.a) null);
            if ((this.f20181b & 1) == 1) {
                this.f20182c = Collections.unmodifiableList(this.f20182c);
                this.f20181b &= -2;
            }
            eVar.effect_ = this.f20182c;
            return eVar;
        }

        private b() {
            v();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public e build() {
            e eVarQ = q();
            if (eVarQ.isInitialized()) {
                return eVarQ;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(eVarQ);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b k() {
            return t().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b m(e eVar) {
            if (eVar == e.t()) {
                return this;
            }
            if (!eVar.effect_.isEmpty()) {
                if (this.f20182c.isEmpty()) {
                    this.f20182c = eVar.effect_;
                    this.f20181b &= -2;
                } else {
                    u();
                    this.f20182c.addAll(eVar.effect_);
                }
            }
            n(l().f(eVar.unknownFields));
            return this;
        }

        private void v() {
        }
    }

    /* synthetic */ e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    static {
        e eVar = new e(true);
        f20179a = eVar;
        eVar.w();
    }

    /* synthetic */ e(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar, w9.a aVar) {
        this(bVar);
    }

    public static e t() {
        return f20179a;
    }

    private void w() {
        this.effect_ = Collections.EMPTY_LIST;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iS = 0;
        for (int i11 = 0; i11 < this.effect_.size(); i11++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.effect_.get(i11));
        }
        int size = iS + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<e> h() {
        return f20180b;
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

    public f u(int i10) {
        return this.effect_.get(i10);
    }

    public int v() {
        return this.effect_.size();
    }

    private e(kotlin.reflect.jvm.internal.impl.protobuf.i.b bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.l();
    }

    public static b x() {
        return b.t();
    }

    public static b y(e eVar) {
        return x().m(eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b c() {
        return y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        for (int i10 = 0; i10 < this.effect_.size(); i10++) {
            fVar.d0(1, this.effect_.get(i10));
        }
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b g() {
        return x();
    }

    private e(boolean z10) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    private e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
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
                                    this.effect_ = new ArrayList();
                                    z11 = true;
                                }
                                this.effect_.add((f) eVar.u(f.f20184b, gVar));
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
                    this.effect_ = Collections.unmodifiableList(this.effect_);
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
            this.effect_ = Collections.unmodifiableList(this.effect_);
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
