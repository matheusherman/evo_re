package z9;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;
import kotlin.reflect.jvm.internal.impl.protobuf.k;
import kotlin.reflect.jvm.internal.impl.protobuf.r;
import kotlin.reflect.jvm.internal.impl.protobuf.z;
import w9.l;
import w9.n;
import w9.q;
import w9.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i.f<w9.d, c> f23124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i.f<w9.i, c> f23125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i.f<w9.i, Integer> f23126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i.f<n, d> f23127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i.f<n, Integer> f23128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i.f<q, List<w9.b>> f23129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i.f<q, Boolean> f23130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i.f<s, List<w9.b>> f23131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i.f<w9.c, Integer> f23132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i.f<w9.c, List<n>> f23133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i.f<w9.c, Integer> f23134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i.f<w9.c, Integer> f23135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i.f<l, Integer> f23136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i.f<l, List<n>> f23137n;

    /* JADX INFO: renamed from: z9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0485a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends i implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f23138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f23139b = new C0486a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* JADX INFO: renamed from: z9.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class C0486a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new b(eVar, gVar, null);
            }

            C0486a() {
            }
        }

        /* JADX INFO: renamed from: z9.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0487b extends i.b<b, C0487b> implements r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f23140b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f23141c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f23142d;

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public C0487b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarB = b.f23139b.b(eVar, gVar);
                        if (bVarB != null) {
                            m(bVarB);
                        }
                        return this;
                    } catch (k e10) {
                        b bVar2 = (b) e10.a();
                        try {
                            throw e10;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                m(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        m(bVar);
                    }
                    throw th;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0487b t() {
                return new C0487b();
            }

            public b q() {
                b bVar = new b(this, (C0485a) null);
                int i10 = this.f23140b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.name_ = this.f23141c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.desc_ = this.f23142d;
                bVar.bitField0_ = i11;
                return bVar;
            }

            public C0487b y(int i10) {
                this.f23140b |= 2;
                this.f23142d = i10;
                return this;
            }

            public C0487b z(int i10) {
                this.f23140b |= 1;
                this.f23141c = i10;
                return this;
            }

            private C0487b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public b build() {
                b bVarQ = q();
                if (bVarQ.isInitialized()) {
                    return bVarQ;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(bVarQ);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public C0487b k() {
                return t().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public C0487b m(b bVar) {
                if (bVar == b.u()) {
                    return this;
                }
                if (bVar.y()) {
                    z(bVar.w());
                }
                if (bVar.x()) {
                    y(bVar.v());
                }
                n(l().f(bVar.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        /* synthetic */ b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar, C0485a c0485a) {
            this(eVar, gVar);
        }

        private void z() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        static {
            b bVar = new b(true);
            f23138a = bVar;
            bVar.z();
        }

        /* synthetic */ b(i.b bVar, C0485a c0485a) {
            this(bVar);
        }

        public static b u() {
            return f23138a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? f.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += f.o(2, this.desc_);
            }
            int size = iO + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<b> h() {
            return f23139b;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public int v() {
            return this.desc_;
        }

        public int w() {
            return this.name_;
        }

        public boolean x() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean y() {
            return (this.bitField0_ & 1) == 1;
        }

        private b(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static C0487b A() {
            return C0487b.t();
        }

        public static C0487b B(b bVar) {
            return A().m(bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public C0487b g() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0487b c() {
            return B(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.desc_);
            }
            fVar.i0(this.unknownFields);
        }

        private b(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            z();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            f fVarJ = f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (iK != 16) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
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
                } catch (k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).i(this);
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

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends i implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f23143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f23144b = new C0488a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* JADX INFO: renamed from: z9.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class C0488a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new c(eVar, gVar, null);
            }

            C0488a() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends i.b<c, b> implements r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f23145b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f23146c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f23147d;

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarB = c.f23144b.b(eVar, gVar);
                        if (cVarB != null) {
                            m(cVarB);
                        }
                        return this;
                    } catch (k e10) {
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

            public c q() {
                c cVar = new c(this, (C0485a) null);
                int i10 = this.f23145b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.name_ = this.f23146c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.desc_ = this.f23147d;
                cVar.bitField0_ = i11;
                return cVar;
            }

            public b y(int i10) {
                this.f23145b |= 2;
                this.f23147d = i10;
                return this;
            }

            public b z(int i10) {
                this.f23145b |= 1;
                this.f23146c = i10;
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
                if (cVar == c.u()) {
                    return this;
                }
                if (cVar.y()) {
                    z(cVar.w());
                }
                if (cVar.x()) {
                    y(cVar.v());
                }
                n(l().f(cVar.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar, C0485a c0485a) {
            this(eVar, gVar);
        }

        private void z() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        static {
            c cVar = new c(true);
            f23143a = cVar;
            cVar.z();
        }

        /* synthetic */ c(i.b bVar, C0485a c0485a) {
            this(bVar);
        }

        public static c u() {
            return f23143a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? f.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += f.o(2, this.desc_);
            }
            int size = iO + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<c> h() {
            return f23144b;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public int v() {
            return this.desc_;
        }

        public int w() {
            return this.name_;
        }

        public boolean x() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean y() {
            return (this.bitField0_ & 1) == 1;
        }

        private c(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static b A() {
            return b.t();
        }

        public static b B(c cVar) {
            return A().m(cVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b g() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b c() {
            return B(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.desc_);
            }
            fVar.i0(this.unknownFields);
        }

        private c(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            z();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            f fVarJ = f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (iK != 16) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
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
                } catch (k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).i(this);
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

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d extends i implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f23148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<d> f23149b = new C0489a();
        private int bitField0_;
        private c delegateMethod_;
        private b field_;
        private c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c setter_;
        private c syntheticMethod_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* JADX INFO: renamed from: z9.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class C0489a extends kotlin.reflect.jvm.internal.impl.protobuf.b<d> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public d b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new d(eVar, gVar, null);
            }

            C0489a() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends i.b<d, b> implements r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f23150b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private b f23151c = b.u();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private c f23152d = c.u();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private c f23153e = c.u();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private c f23154f = c.u();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private c f23155g = c.u();

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d dVarB = d.f23149b.b(eVar, gVar);
                        if (dVarB != null) {
                            m(dVarB);
                        }
                        return this;
                    } catch (k e10) {
                        d dVar2 = (d) e10.a();
                        try {
                            throw e10;
                        } catch (Throwable th) {
                            th = th;
                            dVar = dVar2;
                            if (dVar != null) {
                                m(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dVar != null) {
                        m(dVar);
                    }
                    throw th;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b t() {
                return new b();
            }

            public b A(c cVar) {
                if ((this.f23150b & 4) != 4 || this.f23153e == c.u()) {
                    this.f23153e = cVar;
                } else {
                    this.f23153e = c.B(this.f23153e).m(cVar).q();
                }
                this.f23150b |= 4;
                return this;
            }

            public b C(c cVar) {
                if ((this.f23150b & 8) != 8 || this.f23154f == c.u()) {
                    this.f23154f = cVar;
                } else {
                    this.f23154f = c.B(this.f23154f).m(cVar).q();
                }
                this.f23150b |= 8;
                return this;
            }

            public b D(c cVar) {
                if ((this.f23150b & 2) != 2 || this.f23152d == c.u()) {
                    this.f23152d = cVar;
                } else {
                    this.f23152d = c.B(this.f23152d).m(cVar).q();
                }
                this.f23150b |= 2;
                return this;
            }

            public d q() {
                d dVar = new d(this, (C0485a) null);
                int i10 = this.f23150b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                dVar.field_ = this.f23151c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                dVar.syntheticMethod_ = this.f23152d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                dVar.getter_ = this.f23153e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                dVar.setter_ = this.f23154f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                dVar.delegateMethod_ = this.f23155g;
                dVar.bitField0_ = i11;
                return dVar;
            }

            public b v(c cVar) {
                if ((this.f23150b & 16) != 16 || this.f23155g == c.u()) {
                    this.f23155g = cVar;
                } else {
                    this.f23155g = c.B(this.f23155g).m(cVar).q();
                }
                this.f23150b |= 16;
                return this;
            }

            public b x(b bVar) {
                if ((this.f23150b & 1) != 1 || this.f23151c == b.u()) {
                    this.f23151c = bVar;
                } else {
                    this.f23151c = b.B(this.f23151c).m(bVar).q();
                }
                this.f23150b |= 1;
                return this;
            }

            private b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public d build() {
                d dVarQ = q();
                if (dVarQ.isInitialized()) {
                    return dVarQ;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(dVarQ);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b k() {
                return t().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public b m(d dVar) {
                if (dVar == d.x()) {
                    return this;
                }
                if (dVar.E()) {
                    x(dVar.z());
                }
                if (dVar.H()) {
                    D(dVar.C());
                }
                if (dVar.F()) {
                    A(dVar.A());
                }
                if (dVar.G()) {
                    C(dVar.B());
                }
                if (dVar.D()) {
                    v(dVar.y());
                }
                n(l().f(dVar.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        /* synthetic */ d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar, C0485a c0485a) {
            this(eVar, gVar);
        }

        static {
            d dVar = new d(true);
            f23148a = dVar;
            dVar.I();
        }

        /* synthetic */ d(i.b bVar, C0485a c0485a) {
            this(bVar);
        }

        public static d x() {
            return f23148a;
        }

        public c A() {
            return this.getter_;
        }

        public c B() {
            return this.setter_;
        }

        public c C() {
            return this.syntheticMethod_;
        }

        public boolean D() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean E() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean F() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean G() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean H() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = (this.bitField0_ & 1) == 1 ? f.s(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iS += f.s(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iS += f.s(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iS += f.s(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iS += f.s(5, this.delegateMethod_);
            }
            int size = iS + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<d> h() {
            return f23149b;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public c y() {
            return this.delegateMethod_;
        }

        public b z() {
            return this.field_;
        }

        private d(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        private void I() {
            this.field_ = b.u();
            this.syntheticMethod_ = c.u();
            this.getter_ = c.u();
            this.setter_ = c.u();
            this.delegateMethod_ = c.u();
        }

        public static b J() {
            return b.t();
        }

        public static b K(d dVar) {
            return J().m(dVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public b g() {
            return J();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public b c() {
            return K(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(f fVar) throws IOException {
            e();
            if ((this.bitField0_ & 1) == 1) {
                fVar.d0(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.d0(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.d0(5, this.delegateMethod_);
            }
            fVar.i0(this.unknownFields);
        }

        private d(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            I();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            f fVarJ = f.J(bVarU, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 10) {
                                    b.C0487b c0487bC = (this.bitField0_ & 1) == 1 ? this.field_.c() : null;
                                    b bVar = (b) eVar.u(b.f23139b, gVar);
                                    this.field_ = bVar;
                                    if (c0487bC != null) {
                                        c0487bC.m(bVar);
                                        this.field_ = c0487bC.q();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (iK == 18) {
                                    c.b bVarC = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.c() : null;
                                    c cVar = (c) eVar.u(c.f23144b, gVar);
                                    this.syntheticMethod_ = cVar;
                                    if (bVarC != null) {
                                        bVarC.m(cVar);
                                        this.syntheticMethod_ = bVarC.q();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (iK == 26) {
                                    c.b bVarC2 = (this.bitField0_ & 4) == 4 ? this.getter_.c() : null;
                                    c cVar2 = (c) eVar.u(c.f23144b, gVar);
                                    this.getter_ = cVar2;
                                    if (bVarC2 != null) {
                                        bVarC2.m(cVar2);
                                        this.getter_ = bVarC2.q();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (iK == 34) {
                                    c.b bVarC3 = (this.bitField0_ & 8) == 8 ? this.setter_.c() : null;
                                    c cVar3 = (c) eVar.u(c.f23144b, gVar);
                                    this.setter_ = cVar3;
                                    if (bVarC3 != null) {
                                        bVarC3.m(cVar3);
                                        this.setter_ = bVarC3.q();
                                    }
                                    this.bitField0_ |= 8;
                                } else if (iK != 42) {
                                    if (!o(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    c.b bVarC4 = (this.bitField0_ & 16) == 16 ? this.delegateMethod_.c() : null;
                                    c cVar4 = (c) eVar.u(c.f23144b, gVar);
                                    this.delegateMethod_ = cVar4;
                                    if (bVarC4 != null) {
                                        bVarC4.m(cVar4);
                                        this.delegateMethod_ = bVarC4.q();
                                    }
                                    this.bitField0_ |= 16;
                                }
                            }
                            z10 = true;
                        } catch (IOException e10) {
                            throw new k(e10.getMessage()).i(this);
                        }
                    } catch (k e11) {
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

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class e extends i implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f23156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<e> f23157b = new C0490a();
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> record_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* JADX INFO: renamed from: z9.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class C0490a extends kotlin.reflect.jvm.internal.impl.protobuf.b<e> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public e b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new e(eVar, gVar, null);
            }

            C0490a() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends i.b<e, b> implements r {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f23158b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private List<c> f23159c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private List<Integer> f23160d;

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
            /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) throws Throwable {
                e eVar2 = null;
                try {
                    try {
                        e eVarB = e.f23157b.b(eVar, gVar);
                        if (eVarB != null) {
                            m(eVarB);
                        }
                        return this;
                    } catch (k e10) {
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
                if ((this.f23158b & 2) != 2) {
                    this.f23160d = new ArrayList(this.f23160d);
                    this.f23158b |= 2;
                }
            }

            private void v() {
                if ((this.f23158b & 1) != 1) {
                    this.f23159c = new ArrayList(this.f23159c);
                    this.f23158b |= 1;
                }
            }

            public e q() {
                e eVar = new e(this, (C0485a) null);
                if ((this.f23158b & 1) == 1) {
                    this.f23159c = Collections.unmodifiableList(this.f23159c);
                    this.f23158b &= -2;
                }
                eVar.record_ = this.f23159c;
                if ((this.f23158b & 2) == 2) {
                    this.f23160d = Collections.unmodifiableList(this.f23160d);
                    this.f23158b &= -3;
                }
                eVar.localName_ = this.f23160d;
                return eVar;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f23159c = list;
                this.f23160d = list;
                x();
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
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public b m(e eVar) {
                if (eVar == e.v()) {
                    return this;
                }
                if (!eVar.record_.isEmpty()) {
                    if (this.f23159c.isEmpty()) {
                        this.f23159c = eVar.record_;
                        this.f23158b &= -2;
                    } else {
                        v();
                        this.f23159c.addAll(eVar.record_);
                    }
                }
                if (!eVar.localName_.isEmpty()) {
                    if (this.f23160d.isEmpty()) {
                        this.f23160d = eVar.localName_;
                        this.f23158b &= -3;
                    } else {
                        u();
                        this.f23160d.addAll(eVar.localName_);
                    }
                }
                n(l().f(eVar.unknownFields));
                return this;
            }

            private void x() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class c extends i implements r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final c f23161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f23162b = new C0491a();
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private EnumC0492c operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* JADX INFO: renamed from: z9.a$e$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            static class C0491a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                    return new c(eVar, gVar, null);
                }

                C0491a() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            public static final class b extends i.b<c, b> implements r {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private int f23163b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private int f23165d;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private List<Integer> f23168g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private List<Integer> f23169h;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private int f23164c = 1;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private Object f23166e = "";

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private EnumC0492c f23167f = EnumC0492c.NONE;

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
                /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
                public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c cVarB = c.f23162b.b(eVar, gVar);
                            if (cVarB != null) {
                                m(cVarB);
                            }
                            return this;
                        } catch (k e10) {
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

                private void u() {
                    if ((this.f23163b & 32) != 32) {
                        this.f23169h = new ArrayList(this.f23169h);
                        this.f23163b |= 32;
                    }
                }

                private void v() {
                    if ((this.f23163b & 16) != 16) {
                        this.f23168g = new ArrayList(this.f23168g);
                        this.f23163b |= 16;
                    }
                }

                public b C(int i10) {
                    this.f23163b |= 2;
                    this.f23165d = i10;
                    return this;
                }

                public b D(int i10) {
                    this.f23163b |= 1;
                    this.f23164c = i10;
                    return this;
                }

                public c q() {
                    c cVar = new c(this, (C0485a) null);
                    int i10 = this.f23163b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.range_ = this.f23164c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.predefinedIndex_ = this.f23165d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.string_ = this.f23166e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.operation_ = this.f23167f;
                    if ((this.f23163b & 16) == 16) {
                        this.f23168g = Collections.unmodifiableList(this.f23168g);
                        this.f23163b &= -17;
                    }
                    cVar.substringIndex_ = this.f23168g;
                    if ((this.f23163b & 32) == 32) {
                        this.f23169h = Collections.unmodifiableList(this.f23169h);
                        this.f23163b &= -33;
                    }
                    cVar.replaceChar_ = this.f23169h;
                    cVar.bitField0_ = i11;
                    return cVar;
                }

                private b() {
                    List<Integer> list = Collections.EMPTY_LIST;
                    this.f23168g = list;
                    this.f23169h = list;
                    x();
                }

                public b A(EnumC0492c enumC0492c) {
                    enumC0492c.getClass();
                    this.f23163b |= 8;
                    this.f23167f = enumC0492c;
                    return this;
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
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public b m(c cVar) {
                    if (cVar == c.B()) {
                        return this;
                    }
                    if (cVar.O()) {
                        D(cVar.E());
                    }
                    if (cVar.N()) {
                        C(cVar.D());
                    }
                    if (cVar.P()) {
                        this.f23163b |= 4;
                        this.f23166e = cVar.string_;
                    }
                    if (cVar.L()) {
                        A(cVar.C());
                    }
                    if (!cVar.substringIndex_.isEmpty()) {
                        if (this.f23168g.isEmpty()) {
                            this.f23168g = cVar.substringIndex_;
                            this.f23163b &= -17;
                        } else {
                            v();
                            this.f23168g.addAll(cVar.substringIndex_);
                        }
                    }
                    if (!cVar.replaceChar_.isEmpty()) {
                        if (this.f23169h.isEmpty()) {
                            this.f23169h = cVar.replaceChar_;
                            this.f23163b &= -33;
                        } else {
                            u();
                            this.f23169h.addAll(cVar.replaceChar_);
                        }
                    }
                    n(l().f(cVar.unknownFields));
                    return this;
                }

                private void x() {
                }
            }

            /* JADX INFO: renamed from: z9.a$e$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            public enum EnumC0492c implements j.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);


                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private static j.b<EnumC0492c> f23173d = new C0493a();
                private final int value;

                /* JADX INFO: renamed from: z9.a$e$c$c$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                static class C0493a implements j.b<EnumC0492c> {
                    C0493a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0492c a(int i10) {
                        return EnumC0492c.a(i10);
                    }
                }

                public static EnumC0492c a(int i10) {
                    if (i10 == 0) {
                        return NONE;
                    }
                    if (i10 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
                public final int h() {
                    return this.value;
                }

                EnumC0492c(int i10, int i11) {
                    this.value = i11;
                }
            }

            /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar, C0485a c0485a) {
                this(eVar, gVar);
            }

            private void Q() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = EnumC0492c.NONE;
                List<Integer> list = Collections.EMPTY_LIST;
                this.substringIndex_ = list;
                this.replaceChar_ = list;
            }

            static {
                c cVar = new c(true);
                f23161a = cVar;
                cVar.Q();
            }

            /* synthetic */ c(i.b bVar, C0485a c0485a) {
                this(bVar);
            }

            public static c B() {
                return f23161a;
            }

            public EnumC0492c C() {
                return this.operation_;
            }

            public int D() {
                return this.predefinedIndex_;
            }

            public int E() {
                return this.range_;
            }

            public int F() {
                return this.replaceChar_.size();
            }

            public List<Integer> G() {
                return this.replaceChar_;
            }

            public String H() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String strA = dVar.A();
                if (dVar.r()) {
                    this.string_ = strA;
                }
                return strA;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d I() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVarK = kotlin.reflect.jvm.internal.impl.protobuf.d.k((String) obj);
                this.string_ = dVarK;
                return dVarK;
            }

            public int J() {
                return this.substringIndex_.size();
            }

            public List<Integer> K() {
                return this.substringIndex_;
            }

            public boolean L() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean N() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean O() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean P() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public int e() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.bitField0_ & 1) == 1 ? f.o(1, this.range_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iO += f.o(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iO += f.h(3, this.operation_.h());
                }
                int iP = 0;
                for (int i11 = 0; i11 < this.substringIndex_.size(); i11++) {
                    iP += f.p(this.substringIndex_.get(i11).intValue());
                }
                int iP2 = iO + iP;
                if (!K().isEmpty()) {
                    iP2 = iP2 + 1 + f.p(iP);
                }
                this.substringIndexMemoizedSerializedSize = iP;
                int iP3 = 0;
                for (int i12 = 0; i12 < this.replaceChar_.size(); i12++) {
                    iP3 += f.p(this.replaceChar_.get(i12).intValue());
                }
                int iD = iP2 + iP3;
                if (!G().isEmpty()) {
                    iD = iD + 1 + f.p(iP3);
                }
                this.replaceCharMemoizedSerializedSize = iP3;
                if ((this.bitField0_ & 4) == 4) {
                    iD += f.d(6, I());
                }
                int size = iD + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
            public kotlin.reflect.jvm.internal.impl.protobuf.s<c> h() {
                return f23162b;
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
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            private c(i.b bVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.l();
            }

            public static b R() {
                return b.t();
            }

            public static b S(c cVar) {
                return R().m(cVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
            public b g() {
                return R();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public b c() {
                return S(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public void d(f fVar) throws IOException {
                e();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.a0(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.a0(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    fVar.S(3, this.operation_.h());
                }
                if (K().size() > 0) {
                    fVar.o0(34);
                    fVar.o0(this.substringIndexMemoizedSerializedSize);
                }
                for (int i10 = 0; i10 < this.substringIndex_.size(); i10++) {
                    fVar.b0(this.substringIndex_.get(i10).intValue());
                }
                if (G().size() > 0) {
                    fVar.o0(42);
                    fVar.o0(this.replaceCharMemoizedSerializedSize);
                }
                for (int i11 = 0; i11 < this.replaceChar_.size(); i11++) {
                    fVar.b0(this.replaceChar_.get(i11).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    fVar.O(6, I());
                }
                fVar.i0(this.unknownFields);
            }

            private c(boolean z10) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
            }

            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                Q();
                kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                f fVarJ = f.J(bVarU, 1);
                boolean z10 = false;
                int i10 = 0;
                while (!z10) {
                    try {
                        try {
                            try {
                                int iK = eVar.K();
                                if (iK != 0) {
                                    if (iK == 8) {
                                        this.bitField0_ |= 1;
                                        this.range_ = eVar.s();
                                    } else if (iK == 16) {
                                        this.bitField0_ |= 2;
                                        this.predefinedIndex_ = eVar.s();
                                    } else if (iK == 24) {
                                        int iN = eVar.n();
                                        EnumC0492c enumC0492cA = EnumC0492c.a(iN);
                                        if (enumC0492cA == null) {
                                            fVarJ.o0(iK);
                                            fVarJ.o0(iN);
                                        } else {
                                            this.bitField0_ |= 8;
                                            this.operation_ = enumC0492cA;
                                        }
                                    } else if (iK == 32) {
                                        if ((i10 & 16) != 16) {
                                            this.substringIndex_ = new ArrayList();
                                            i10 |= 16;
                                        }
                                        this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                    } else if (iK == 34) {
                                        int iJ = eVar.j(eVar.A());
                                        if ((i10 & 16) != 16 && eVar.e() > 0) {
                                            this.substringIndex_ = new ArrayList();
                                            i10 |= 16;
                                        }
                                        while (eVar.e() > 0) {
                                            this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(iJ);
                                    } else if (iK == 40) {
                                        if ((i10 & 32) != 32) {
                                            this.replaceChar_ = new ArrayList();
                                            i10 |= 32;
                                        }
                                        this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                    } else if (iK == 42) {
                                        int iJ2 = eVar.j(eVar.A());
                                        if ((i10 & 32) != 32 && eVar.e() > 0) {
                                            this.replaceChar_ = new ArrayList();
                                            i10 |= 32;
                                        }
                                        while (eVar.e() > 0) {
                                            this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(iJ2);
                                    } else if (iK != 50) {
                                        if (!o(eVar, fVarJ, gVar, iK)) {
                                        }
                                    } else {
                                        kotlin.reflect.jvm.internal.impl.protobuf.d dVarL = eVar.l();
                                        this.bitField0_ |= 4;
                                        this.string_ = dVarL;
                                    }
                                }
                                z10 = true;
                            } catch (IOException e10) {
                                throw new k(e10.getMessage()).i(this);
                            }
                        } catch (k e11) {
                            throw e11.i(this);
                        }
                    } catch (Throwable th) {
                        if ((i10 & 16) == 16) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if ((i10 & 32) == 32) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
                if ((i10 & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i10 & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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

        /* synthetic */ e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar, C0485a c0485a) {
            this(eVar, gVar);
        }

        static {
            e eVar = new e(true);
            f23156a = eVar;
            eVar.y();
        }

        /* synthetic */ e(i.b bVar, C0485a c0485a) {
            this(bVar);
        }

        public static e C(InputStream inputStream, g gVar) {
            return f23157b.c(inputStream, gVar);
        }

        public static e v() {
            return f23156a;
        }

        private void y() {
            List list = Collections.EMPTY_LIST;
            this.record_ = list;
            this.localName_ = list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int e() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.record_.size(); i11++) {
                iS += f.s(1, this.record_.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.localName_.size(); i12++) {
                iP += f.p(this.localName_.get(i12).intValue());
            }
            int iP2 = iS + iP;
            if (!w().isEmpty()) {
                iP2 = iP2 + 1 + f.p(iP);
            }
            this.localNameMemoizedSerializedSize = iP;
            int size = iP2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<e> h() {
            return f23157b;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public List<Integer> w() {
            return this.localName_;
        }

        public List<c> x() {
            return this.record_;
        }

        private e(i.b bVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.l();
        }

        public static b A(e eVar) {
            return z().m(eVar);
        }

        public static b z() {
            return b.t();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b g() {
            return z();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b c() {
            return A(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void d(f fVar) throws IOException {
            e();
            for (int i10 = 0; i10 < this.record_.size(); i10++) {
                fVar.d0(1, this.record_.get(i10));
            }
            if (w().size() > 0) {
                fVar.o0(42);
                fVar.o0(this.localNameMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.localName_.size(); i11++) {
                fVar.b0(this.localName_.get(i11).intValue());
            }
            fVar.i0(this.unknownFields);
        }

        private e(boolean z10) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
        }

        private e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            y();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarU = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            f fVarJ = f.J(bVarU, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                if ((i10 & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.record_.add((c) eVar.u(c.f23162b, gVar));
                            } else if (iK == 40) {
                                if ((i10 & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.localName_.add(Integer.valueOf(eVar.s()));
                            } else if (iK != 42) {
                                if (!o(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 2) != 2 && eVar.e() > 0) {
                                    this.localName_ = new ArrayList();
                                    i10 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.localName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if ((i10 & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i10 & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
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
            if ((i10 & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i10 & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
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

    public static void a(g gVar) {
        gVar.a(f23124a);
        gVar.a(f23125b);
        gVar.a(f23126c);
        gVar.a(f23127d);
        gVar.a(f23128e);
        gVar.a(f23129f);
        gVar.a(f23130g);
        gVar.a(f23131h);
        gVar.a(f23132i);
        gVar.a(f23133j);
        gVar.a(f23134k);
        gVar.a(f23135l);
        gVar.a(f23136m);
        gVar.a(f23137n);
    }

    static {
        w9.d dVarG = w9.d.G();
        c cVarU = c.u();
        c cVarU2 = c.u();
        z.b bVar = z.b.f13758k;
        f23124a = i.n(dVarG, cVarU, cVarU2, null, 100, bVar, c.class);
        f23125b = i.n(w9.i.a0(), c.u(), c.u(), null, 100, bVar, c.class);
        w9.i iVarA0 = w9.i.a0();
        z.b bVar2 = z.b.f13752e;
        f23126c = i.n(iVarA0, 0, null, null, 101, bVar2, Integer.class);
        f23127d = i.n(n.Y(), d.x(), d.x(), null, 100, bVar, d.class);
        f23128e = i.n(n.Y(), 0, null, null, 101, bVar2, Integer.class);
        f23129f = i.m(q.X(), w9.b.y(), null, 100, bVar, false, w9.b.class);
        f23130g = i.n(q.X(), Boolean.FALSE, null, null, 101, z.b.f13755h, Boolean.class);
        f23131h = i.m(s.J(), w9.b.y(), null, 100, bVar, false, w9.b.class);
        f23132i = i.n(w9.c.y0(), 0, null, null, 101, bVar2, Integer.class);
        f23133j = i.m(w9.c.y0(), n.Y(), null, 102, bVar, false, n.class);
        f23134k = i.n(w9.c.y0(), 0, null, null, 103, bVar2, Integer.class);
        f23135l = i.n(w9.c.y0(), 0, null, null, 104, bVar2, Integer.class);
        f23136m = i.n(l.J(), 0, null, null, 101, bVar2, Integer.class);
        f23137n = i.m(l.J(), n.Y(), null, 102, bVar, false, n.class);
    }
}
