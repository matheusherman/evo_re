package w9;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<c> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f20139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f20140b = new a();
    private int bitField0_;
    private int companionObjectName_;
    private List<d> constructor_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<q> contextReceiverType_;
    private List<g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<i> function_;
    private int inlineClassUnderlyingPropertyName_;
    private int inlineClassUnderlyingTypeId_;
    private q inlineClassUnderlyingType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingName_;
    private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingTypeId_;
    private List<q> multiFieldValueClassUnderlyingType_;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<q> supertype_;
    private List<r> typeAlias_;
    private List<s> typeParameter_;
    private t typeTable_;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
    private w versionRequirementTable_;
    private List<Integer> versionRequirement_;

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
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i.c<c, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {
        private List<Integer> A;
        private w B;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20142e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20143f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20144g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<s> f20145h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<q> f20146i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<Integer> f20147j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<Integer> f20148k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<q> f20149l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<Integer> f20150m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<d> f20151n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private List<i> f20152o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private List<n> f20153p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private List<r> f20154q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private List<g> f20155r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private List<Integer> f20156s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f20157t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private q f20158u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f20159v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private List<Integer> f20160w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private List<q> f20161x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private List<Integer> f20162y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private t f20163z;

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
            c cVar = null;
            try {
                try {
                    c cVarB = c.f20140b.b(eVar, gVar);
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public b m(c cVar) {
            if (cVar == c.y0()) {
                return this;
            }
            if (cVar.l1()) {
                c0(cVar.D0());
            }
            if (cVar.m1()) {
                d0(cVar.E0());
            }
            if (cVar.k1()) {
                b0(cVar.q0());
            }
            if (!cVar.typeParameter_.isEmpty()) {
                if (this.f20145h.isEmpty()) {
                    this.f20145h = cVar.typeParameter_;
                    this.f20141d &= -9;
                } else {
                    R();
                    this.f20145h.addAll(cVar.typeParameter_);
                }
            }
            if (!cVar.supertype_.isEmpty()) {
                if (this.f20146i.isEmpty()) {
                    this.f20146i = cVar.supertype_;
                    this.f20141d &= -17;
                } else {
                    O();
                    this.f20146i.addAll(cVar.supertype_);
                }
            }
            if (!cVar.supertypeId_.isEmpty()) {
                if (this.f20147j.isEmpty()) {
                    this.f20147j = cVar.supertypeId_;
                    this.f20141d &= -33;
                } else {
                    N();
                    this.f20147j.addAll(cVar.supertypeId_);
                }
            }
            if (!cVar.nestedClassName_.isEmpty()) {
                if (this.f20148k.isEmpty()) {
                    this.f20148k = cVar.nestedClassName_;
                    this.f20141d &= -65;
                } else {
                    I();
                    this.f20148k.addAll(cVar.nestedClassName_);
                }
            }
            if (!cVar.contextReceiverType_.isEmpty()) {
                if (this.f20149l.isEmpty()) {
                    this.f20149l = cVar.contextReceiverType_;
                    this.f20141d &= -129;
                } else {
                    C();
                    this.f20149l.addAll(cVar.contextReceiverType_);
                }
            }
            if (!cVar.contextReceiverTypeId_.isEmpty()) {
                if (this.f20150m.isEmpty()) {
                    this.f20150m = cVar.contextReceiverTypeId_;
                    this.f20141d &= -257;
                } else {
                    A();
                    this.f20150m.addAll(cVar.contextReceiverTypeId_);
                }
            }
            if (!cVar.constructor_.isEmpty()) {
                if (this.f20151n.isEmpty()) {
                    this.f20151n = cVar.constructor_;
                    this.f20141d &= -513;
                } else {
                    z();
                    this.f20151n.addAll(cVar.constructor_);
                }
            }
            if (!cVar.function_.isEmpty()) {
                if (this.f20152o.isEmpty()) {
                    this.f20152o = cVar.function_;
                    this.f20141d &= -1025;
                } else {
                    E();
                    this.f20152o.addAll(cVar.function_);
                }
            }
            if (!cVar.property_.isEmpty()) {
                if (this.f20153p.isEmpty()) {
                    this.f20153p = cVar.property_;
                    this.f20141d &= -2049;
                } else {
                    K();
                    this.f20153p.addAll(cVar.property_);
                }
            }
            if (!cVar.typeAlias_.isEmpty()) {
                if (this.f20154q.isEmpty()) {
                    this.f20154q = cVar.typeAlias_;
                    this.f20141d &= -4097;
                } else {
                    Q();
                    this.f20154q.addAll(cVar.typeAlias_);
                }
            }
            if (!cVar.enumEntry_.isEmpty()) {
                if (this.f20155r.isEmpty()) {
                    this.f20155r = cVar.enumEntry_;
                    this.f20141d &= -8193;
                } else {
                    D();
                    this.f20155r.addAll(cVar.enumEntry_);
                }
            }
            if (!cVar.sealedSubclassFqName_.isEmpty()) {
                if (this.f20156s.isEmpty()) {
                    this.f20156s = cVar.sealedSubclassFqName_;
                    this.f20141d &= -16385;
                } else {
                    L();
                    this.f20156s.addAll(cVar.sealedSubclassFqName_);
                }
            }
            if (cVar.n1()) {
                e0(cVar.I0());
            }
            if (cVar.o1()) {
                Y(cVar.J0());
            }
            if (cVar.p1()) {
                f0(cVar.K0());
            }
            if (!cVar.multiFieldValueClassUnderlyingName_.isEmpty()) {
                if (this.f20160w.isEmpty()) {
                    this.f20160w = cVar.multiFieldValueClassUnderlyingName_;
                    this.f20141d &= -262145;
                } else {
                    F();
                    this.f20160w.addAll(cVar.multiFieldValueClassUnderlyingName_);
                }
            }
            if (!cVar.multiFieldValueClassUnderlyingType_.isEmpty()) {
                if (this.f20161x.isEmpty()) {
                    this.f20161x = cVar.multiFieldValueClassUnderlyingType_;
                    this.f20141d &= -524289;
                } else {
                    H();
                    this.f20161x.addAll(cVar.multiFieldValueClassUnderlyingType_);
                }
            }
            if (!cVar.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                if (this.f20162y.isEmpty()) {
                    this.f20162y = cVar.multiFieldValueClassUnderlyingTypeId_;
                    this.f20141d &= -1048577;
                } else {
                    G();
                    this.f20162y.addAll(cVar.multiFieldValueClassUnderlyingTypeId_);
                }
            }
            if (cVar.q1()) {
                Z(cVar.h1());
            }
            if (!cVar.versionRequirement_.isEmpty()) {
                if (this.A.isEmpty()) {
                    this.A = cVar.versionRequirement_;
                    this.f20141d &= -4194305;
                } else {
                    T();
                    this.A.addAll(cVar.versionRequirement_);
                }
            }
            if (cVar.r1()) {
                a0(cVar.j1());
            }
            s(cVar);
            n(l().f(cVar.unknownFields));
            return this;
        }

        private void A() {
            if ((this.f20141d & 256) != 256) {
                this.f20150m = new ArrayList(this.f20150m);
                this.f20141d |= 256;
            }
        }

        private void C() {
            if ((this.f20141d & 128) != 128) {
                this.f20149l = new ArrayList(this.f20149l);
                this.f20141d |= 128;
            }
        }

        private void D() {
            if ((this.f20141d & 8192) != 8192) {
                this.f20155r = new ArrayList(this.f20155r);
                this.f20141d |= 8192;
            }
        }

        private void E() {
            if ((this.f20141d & 1024) != 1024) {
                this.f20152o = new ArrayList(this.f20152o);
                this.f20141d |= 1024;
            }
        }

        private void F() {
            if ((this.f20141d & 262144) != 262144) {
                this.f20160w = new ArrayList(this.f20160w);
                this.f20141d |= 262144;
            }
        }

        private void G() {
            if ((this.f20141d & 1048576) != 1048576) {
                this.f20162y = new ArrayList(this.f20162y);
                this.f20141d |= 1048576;
            }
        }

        private void H() {
            if ((this.f20141d & 524288) != 524288) {
                this.f20161x = new ArrayList(this.f20161x);
                this.f20141d |= 524288;
            }
        }

        private void I() {
            if ((this.f20141d & 64) != 64) {
                this.f20148k = new ArrayList(this.f20148k);
                this.f20141d |= 64;
            }
        }

        private void K() {
            if ((this.f20141d & 2048) != 2048) {
                this.f20153p = new ArrayList(this.f20153p);
                this.f20141d |= 2048;
            }
        }

        private void L() {
            if ((this.f20141d & 16384) != 16384) {
                this.f20156s = new ArrayList(this.f20156s);
                this.f20141d |= 16384;
            }
        }

        private void N() {
            if ((this.f20141d & 32) != 32) {
                this.f20147j = new ArrayList(this.f20147j);
                this.f20141d |= 32;
            }
        }

        private void O() {
            if ((this.f20141d & 16) != 16) {
                this.f20146i = new ArrayList(this.f20146i);
                this.f20141d |= 16;
            }
        }

        private void Q() {
            if ((this.f20141d & 4096) != 4096) {
                this.f20154q = new ArrayList(this.f20154q);
                this.f20141d |= 4096;
            }
        }

        private void R() {
            if ((this.f20141d & 8) != 8) {
                this.f20145h = new ArrayList(this.f20145h);
                this.f20141d |= 8;
            }
        }

        private void T() {
            if ((this.f20141d & 4194304) != 4194304) {
                this.A = new ArrayList(this.A);
                this.f20141d |= 4194304;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b y() {
            return new b();
        }

        private void z() {
            if ((this.f20141d & 512) != 512) {
                this.f20151n = new ArrayList(this.f20151n);
                this.f20141d |= 512;
            }
        }

        public b Y(q qVar) {
            if ((this.f20141d & 65536) != 65536 || this.f20158u == q.X()) {
                this.f20158u = qVar;
            } else {
                this.f20158u = q.y0(this.f20158u).m(qVar).v();
            }
            this.f20141d |= 65536;
            return this;
        }

        public b Z(t tVar) {
            if ((this.f20141d & 2097152) != 2097152 || this.f20163z == t.v()) {
                this.f20163z = tVar;
            } else {
                this.f20163z = t.D(this.f20163z).m(tVar).q();
            }
            this.f20141d |= 2097152;
            return this;
        }

        public b a0(w wVar) {
            if ((this.f20141d & 8388608) != 8388608 || this.B == w.t()) {
                this.B = wVar;
            } else {
                this.B = w.y(this.B).m(wVar).q();
            }
            this.f20141d |= 8388608;
            return this;
        }

        public b b0(int i10) {
            this.f20141d |= 4;
            this.f20144g = i10;
            return this;
        }

        public b c0(int i10) {
            this.f20141d |= 1;
            this.f20142e = i10;
            return this;
        }

        public b d0(int i10) {
            this.f20141d |= 2;
            this.f20143f = i10;
            return this;
        }

        public b e0(int i10) {
            this.f20141d |= 32768;
            this.f20157t = i10;
            return this;
        }

        public b f0(int i10) {
            this.f20141d |= 131072;
            this.f20159v = i10;
            return this;
        }

        public c v() {
            c cVar = new c(this, (w9.a) null);
            int i10 = this.f20141d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            cVar.flags_ = this.f20142e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            cVar.fqName_ = this.f20143f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            cVar.companionObjectName_ = this.f20144g;
            if ((this.f20141d & 8) == 8) {
                this.f20145h = Collections.unmodifiableList(this.f20145h);
                this.f20141d &= -9;
            }
            cVar.typeParameter_ = this.f20145h;
            if ((this.f20141d & 16) == 16) {
                this.f20146i = Collections.unmodifiableList(this.f20146i);
                this.f20141d &= -17;
            }
            cVar.supertype_ = this.f20146i;
            if ((this.f20141d & 32) == 32) {
                this.f20147j = Collections.unmodifiableList(this.f20147j);
                this.f20141d &= -33;
            }
            cVar.supertypeId_ = this.f20147j;
            if ((this.f20141d & 64) == 64) {
                this.f20148k = Collections.unmodifiableList(this.f20148k);
                this.f20141d &= -65;
            }
            cVar.nestedClassName_ = this.f20148k;
            if ((this.f20141d & 128) == 128) {
                this.f20149l = Collections.unmodifiableList(this.f20149l);
                this.f20141d &= -129;
            }
            cVar.contextReceiverType_ = this.f20149l;
            if ((this.f20141d & 256) == 256) {
                this.f20150m = Collections.unmodifiableList(this.f20150m);
                this.f20141d &= -257;
            }
            cVar.contextReceiverTypeId_ = this.f20150m;
            if ((this.f20141d & 512) == 512) {
                this.f20151n = Collections.unmodifiableList(this.f20151n);
                this.f20141d &= -513;
            }
            cVar.constructor_ = this.f20151n;
            if ((this.f20141d & 1024) == 1024) {
                this.f20152o = Collections.unmodifiableList(this.f20152o);
                this.f20141d &= -1025;
            }
            cVar.function_ = this.f20152o;
            if ((this.f20141d & 2048) == 2048) {
                this.f20153p = Collections.unmodifiableList(this.f20153p);
                this.f20141d &= -2049;
            }
            cVar.property_ = this.f20153p;
            if ((this.f20141d & 4096) == 4096) {
                this.f20154q = Collections.unmodifiableList(this.f20154q);
                this.f20141d &= -4097;
            }
            cVar.typeAlias_ = this.f20154q;
            if ((this.f20141d & 8192) == 8192) {
                this.f20155r = Collections.unmodifiableList(this.f20155r);
                this.f20141d &= -8193;
            }
            cVar.enumEntry_ = this.f20155r;
            if ((this.f20141d & 16384) == 16384) {
                this.f20156s = Collections.unmodifiableList(this.f20156s);
                this.f20141d &= -16385;
            }
            cVar.sealedSubclassFqName_ = this.f20156s;
            if ((i10 & 32768) == 32768) {
                i11 |= 8;
            }
            cVar.inlineClassUnderlyingPropertyName_ = this.f20157t;
            if ((i10 & 65536) == 65536) {
                i11 |= 16;
            }
            cVar.inlineClassUnderlyingType_ = this.f20158u;
            if ((i10 & 131072) == 131072) {
                i11 |= 32;
            }
            cVar.inlineClassUnderlyingTypeId_ = this.f20159v;
            if ((this.f20141d & 262144) == 262144) {
                this.f20160w = Collections.unmodifiableList(this.f20160w);
                this.f20141d &= -262145;
            }
            cVar.multiFieldValueClassUnderlyingName_ = this.f20160w;
            if ((this.f20141d & 524288) == 524288) {
                this.f20161x = Collections.unmodifiableList(this.f20161x);
                this.f20141d &= -524289;
            }
            cVar.multiFieldValueClassUnderlyingType_ = this.f20161x;
            if ((this.f20141d & 1048576) == 1048576) {
                this.f20162y = Collections.unmodifiableList(this.f20162y);
                this.f20141d &= -1048577;
            }
            cVar.multiFieldValueClassUnderlyingTypeId_ = this.f20162y;
            if ((i10 & 2097152) == 2097152) {
                i11 |= 64;
            }
            cVar.typeTable_ = this.f20163z;
            if ((this.f20141d & 4194304) == 4194304) {
                this.A = Collections.unmodifiableList(this.A);
                this.f20141d &= -4194305;
            }
            cVar.versionRequirement_ = this.A;
            if ((i10 & 8388608) == 8388608) {
                i11 |= 128;
            }
            cVar.versionRequirementTable_ = this.B;
            cVar.bitField0_ = i11;
            return cVar;
        }

        private b() {
            List list = Collections.EMPTY_LIST;
            this.f20145h = list;
            this.f20146i = list;
            this.f20147j = list;
            this.f20148k = list;
            this.f20149l = list;
            this.f20150m = list;
            this.f20151n = list;
            this.f20152o = list;
            this.f20153p = list;
            this.f20154q = list;
            this.f20155r = list;
            this.f20156s = list;
            this.f20158u = q.X();
            this.f20160w = list;
            this.f20161x = list;
            this.f20162y = list;
            this.f20163z = t.v();
            this.A = list;
            this.B = w.t();
            U();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public c build() {
            c cVarV = v();
            if (cVarV.isInitialized()) {
                return cVarV;
            }
            throw kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a.j(cVarV);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b k() {
            return y().m(v());
        }

        private void U() {
        }
    }

    /* JADX INFO: renamed from: w9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum EnumC0388c implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0388c> f20171h = new a();
        private final int value;

        /* JADX INFO: renamed from: w9.c$c$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements kotlin.reflect.jvm.internal.impl.protobuf.j.b<EnumC0388c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public EnumC0388c a(int i10) {
                return EnumC0388c.a(i10);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int h() {
            return this.value;
        }

        EnumC0388c(int i10, int i11) {
            this.value = i11;
        }

        public static EnumC0388c a(int i10) {
            switch (i10) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }
    }

    /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, w9.a aVar) {
        this(eVar, gVar);
    }

    private void s1() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.supertype_ = list;
        this.supertypeId_ = list;
        this.nestedClassName_ = list;
        this.contextReceiverType_ = list;
        this.contextReceiverTypeId_ = list;
        this.constructor_ = list;
        this.function_ = list;
        this.property_ = list;
        this.typeAlias_ = list;
        this.enumEntry_ = list;
        this.sealedSubclassFqName_ = list;
        this.inlineClassUnderlyingPropertyName_ = 0;
        this.inlineClassUnderlyingType_ = q.X();
        this.inlineClassUnderlyingTypeId_ = 0;
        this.multiFieldValueClassUnderlyingName_ = list;
        this.multiFieldValueClassUnderlyingType_ = list;
        this.multiFieldValueClassUnderlyingTypeId_ = list;
        this.typeTable_ = t.v();
        this.versionRequirement_ = list;
        this.versionRequirementTable_ = w.t();
    }

    static {
        c cVar = new c(true);
        f20139a = cVar;
        cVar.s1();
    }

    /* synthetic */ c(kotlin.reflect.jvm.internal.impl.protobuf.i.c cVar, w9.a aVar) {
        this((kotlin.reflect.jvm.internal.impl.protobuf.i.c<c, ?>) cVar);
    }

    public static c w1(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f20140b.a(inputStream, gVar);
    }

    public static c y0() {
        return f20139a;
    }

    public g A0(int i10) {
        return this.enumEntry_.get(i10);
    }

    public int B0() {
        return this.enumEntry_.size();
    }

    public List<g> C0() {
        return this.enumEntry_;
    }

    public int D0() {
        return this.flags_;
    }

    public int E0() {
        return this.fqName_;
    }

    public i F0(int i10) {
        return this.function_.get(i10);
    }

    public int G0() {
        return this.function_.size();
    }

    public List<i> H0() {
        return this.function_;
    }

    public int I0() {
        return this.inlineClassUnderlyingPropertyName_;
    }

    public q J0() {
        return this.inlineClassUnderlyingType_;
    }

    public int K0() {
        return this.inlineClassUnderlyingTypeId_;
    }

    public int L0() {
        return this.multiFieldValueClassUnderlyingName_.size();
    }

    public List<Integer> M0() {
        return this.multiFieldValueClassUnderlyingName_;
    }

    public q N0(int i10) {
        return this.multiFieldValueClassUnderlyingType_.get(i10);
    }

    public int O0() {
        return this.multiFieldValueClassUnderlyingType_.size();
    }

    public int P0() {
        return this.multiFieldValueClassUnderlyingTypeId_.size();
    }

    public List<Integer> Q0() {
        return this.multiFieldValueClassUnderlyingTypeId_;
    }

    public List<q> R0() {
        return this.multiFieldValueClassUnderlyingType_;
    }

    public List<Integer> S0() {
        return this.nestedClassName_;
    }

    public n T0(int i10) {
        return this.property_.get(i10);
    }

    public int U0() {
        return this.property_.size();
    }

    public List<n> V0() {
        return this.property_;
    }

    public List<Integer> W0() {
        return this.sealedSubclassFqName_;
    }

    public q X0(int i10) {
        return this.supertype_.get(i10);
    }

    public int Y0() {
        return this.supertype_.size();
    }

    public List<Integer> Z0() {
        return this.supertypeId_;
    }

    public List<q> a1() {
        return this.supertype_;
    }

    public r b1(int i10) {
        return this.typeAlias_.get(i10);
    }

    public int c1() {
        return this.typeAlias_.size();
    }

    public List<r> d1() {
        return this.typeAlias_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int e() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.bitField0_ & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.flags_) : 0;
        int iP = 0;
        for (int i11 = 0; i11 < this.supertypeId_.size(); i11++) {
            iP += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.supertypeId_.get(i11).intValue());
        }
        int iS = iO + iP;
        if (!Z0().isEmpty()) {
            iS = iS + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP);
        }
        this.supertypeIdMemoizedSerializedSize = iP;
        if ((this.bitField0_ & 2) == 2) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.o(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.companionObjectName_);
        }
        for (int i12 = 0; i12 < this.typeParameter_.size(); i12++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.typeParameter_.get(i12));
        }
        for (int i13 = 0; i13 < this.supertype_.size(); i13++) {
            iS += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.supertype_.get(i13));
        }
        int iP2 = 0;
        for (int i14 = 0; i14 < this.nestedClassName_.size(); i14++) {
            iP2 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.nestedClassName_.get(i14).intValue());
        }
        int iS2 = iS + iP2;
        if (!S0().isEmpty()) {
            iS2 = iS2 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP2);
        }
        this.nestedClassNameMemoizedSerializedSize = iP2;
        for (int i15 = 0; i15 < this.constructor_.size(); i15++) {
            iS2 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.constructor_.get(i15));
        }
        for (int i16 = 0; i16 < this.function_.size(); i16++) {
            iS2 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(9, this.function_.get(i16));
        }
        for (int i17 = 0; i17 < this.property_.size(); i17++) {
            iS2 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(10, this.property_.get(i17));
        }
        for (int i18 = 0; i18 < this.typeAlias_.size(); i18++) {
            iS2 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(11, this.typeAlias_.get(i18));
        }
        for (int i19 = 0; i19 < this.enumEntry_.size(); i19++) {
            iS2 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(13, this.enumEntry_.get(i19));
        }
        int iP3 = 0;
        for (int i20 = 0; i20 < this.sealedSubclassFqName_.size(); i20++) {
            iP3 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.sealedSubclassFqName_.get(i20).intValue());
        }
        int iS3 = iS2 + iP3;
        if (!W0().isEmpty()) {
            iS3 = iS3 + 2 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP3);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = iP3;
        if ((this.bitField0_ & 8) == 8) {
            iS3 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(17, this.inlineClassUnderlyingPropertyName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iS3 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(18, this.inlineClassUnderlyingType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iS3 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(19, this.inlineClassUnderlyingTypeId_);
        }
        for (int i21 = 0; i21 < this.contextReceiverType_.size(); i21++) {
            iS3 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(20, this.contextReceiverType_.get(i21));
        }
        int iP4 = 0;
        for (int i22 = 0; i22 < this.contextReceiverTypeId_.size(); i22++) {
            iP4 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.contextReceiverTypeId_.get(i22).intValue());
        }
        int iP5 = iS3 + iP4;
        if (!w0().isEmpty()) {
            iP5 = iP5 + 2 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP4);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iP4;
        int iP6 = 0;
        for (int i23 = 0; i23 < this.multiFieldValueClassUnderlyingName_.size(); i23++) {
            iP6 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.multiFieldValueClassUnderlyingName_.get(i23).intValue());
        }
        int iS4 = iP5 + iP6;
        if (!M0().isEmpty()) {
            iS4 = iS4 + 2 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP6);
        }
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = iP6;
        for (int i24 = 0; i24 < this.multiFieldValueClassUnderlyingType_.size(); i24++) {
            iS4 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(23, this.multiFieldValueClassUnderlyingType_.get(i24));
        }
        int iP7 = 0;
        for (int i25 = 0; i25 < this.multiFieldValueClassUnderlyingTypeId_.size(); i25++) {
            iP7 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.multiFieldValueClassUnderlyingTypeId_.get(i25).intValue());
        }
        int iS5 = iS4 + iP7;
        if (!Q0().isEmpty()) {
            iS5 = iS5 + 2 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(iP7);
        }
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = iP7;
        if ((this.bitField0_ & 64) == 64) {
            iS5 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.typeTable_);
        }
        int iP8 = 0;
        for (int i26 = 0; i26 < this.versionRequirement_.size(); i26++) {
            iP8 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.versionRequirement_.get(i26).intValue());
        }
        int size = iS5 + iP8 + (i1().size() * 2);
        if ((this.bitField0_ & 128) == 128) {
            size += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.versionRequirementTable_);
        }
        int iS6 = size + s() + this.unknownFields.size();
        this.memoizedSerializedSize = iS6;
        return iS6;
    }

    public s e1(int i10) {
        return this.typeParameter_.get(i10);
    }

    public int f1() {
        return this.typeParameter_.size();
    }

    public List<s> g1() {
        return this.typeParameter_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<c> h() {
        return f20140b;
    }

    public t h1() {
        return this.typeTable_;
    }

    public List<Integer> i1() {
        return this.versionRequirement_;
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
        if (!m1()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < f1(); i10++) {
            if (!e1(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < Y0(); i11++) {
            if (!X0(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < v0(); i12++) {
            if (!u0(i12).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < s0(); i13++) {
            if (!r0(i13).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < G0(); i14++) {
            if (!F0(i14).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < U0(); i15++) {
            if (!T0(i15).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < c1(); i16++) {
            if (!b1(i16).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i17 = 0; i17 < B0(); i17++) {
            if (!A0(i17).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (o1() && !J0().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i18 = 0; i18 < O0(); i18++) {
            if (!N0(i18).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (q1() && !h1().isInitialized()) {
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

    public w j1() {
        return this.versionRequirementTable_;
    }

    public boolean k1() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean l1() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean m1() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean n1() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean o1() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean p1() {
        return (this.bitField0_ & 32) == 32;
    }

    public int q0() {
        return this.companionObjectName_;
    }

    public boolean q1() {
        return (this.bitField0_ & 64) == 64;
    }

    public d r0(int i10) {
        return this.constructor_.get(i10);
    }

    public boolean r1() {
        return (this.bitField0_ & 128) == 128;
    }

    public int s0() {
        return this.constructor_.size();
    }

    public List<d> t0() {
        return this.constructor_;
    }

    public q u0(int i10) {
        return this.contextReceiverType_.get(i10);
    }

    public int v0() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> w0() {
        return this.contextReceiverTypeId_;
    }

    public List<q> x0() {
        return this.contextReceiverType_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public c a() {
        return f20139a;
    }

    private c(kotlin.reflect.jvm.internal.impl.protobuf.i.c<c, ?> cVar) {
        super(cVar);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.l();
    }

    public static b t1() {
        return b.y();
    }

    public static b u1(c cVar) {
        return t1().m(cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void d(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
        e();
        kotlin.reflect.jvm.internal.impl.protobuf.i.d<MessageType>.a aVarX = x();
        if ((this.bitField0_ & 1) == 1) {
            fVar.a0(1, this.flags_);
        }
        if (Z0().size() > 0) {
            fVar.o0(18);
            fVar.o0(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.supertypeId_.size(); i10++) {
            fVar.b0(this.supertypeId_.get(i10).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            fVar.a0(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            fVar.a0(4, this.companionObjectName_);
        }
        for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
            fVar.d0(5, this.typeParameter_.get(i11));
        }
        for (int i12 = 0; i12 < this.supertype_.size(); i12++) {
            fVar.d0(6, this.supertype_.get(i12));
        }
        if (S0().size() > 0) {
            fVar.o0(58);
            fVar.o0(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i13 = 0; i13 < this.nestedClassName_.size(); i13++) {
            fVar.b0(this.nestedClassName_.get(i13).intValue());
        }
        for (int i14 = 0; i14 < this.constructor_.size(); i14++) {
            fVar.d0(8, this.constructor_.get(i14));
        }
        for (int i15 = 0; i15 < this.function_.size(); i15++) {
            fVar.d0(9, this.function_.get(i15));
        }
        for (int i16 = 0; i16 < this.property_.size(); i16++) {
            fVar.d0(10, this.property_.get(i16));
        }
        for (int i17 = 0; i17 < this.typeAlias_.size(); i17++) {
            fVar.d0(11, this.typeAlias_.get(i17));
        }
        for (int i18 = 0; i18 < this.enumEntry_.size(); i18++) {
            fVar.d0(13, this.enumEntry_.get(i18));
        }
        if (W0().size() > 0) {
            fVar.o0(130);
            fVar.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i19 = 0; i19 < this.sealedSubclassFqName_.size(); i19++) {
            fVar.b0(this.sealedSubclassFqName_.get(i19).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            fVar.a0(17, this.inlineClassUnderlyingPropertyName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            fVar.d0(18, this.inlineClassUnderlyingType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            fVar.a0(19, this.inlineClassUnderlyingTypeId_);
        }
        for (int i20 = 0; i20 < this.contextReceiverType_.size(); i20++) {
            fVar.d0(20, this.contextReceiverType_.get(i20));
        }
        if (w0().size() > 0) {
            fVar.o0(170);
            fVar.o0(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i21 = 0; i21 < this.contextReceiverTypeId_.size(); i21++) {
            fVar.b0(this.contextReceiverTypeId_.get(i21).intValue());
        }
        if (M0().size() > 0) {
            fVar.o0(178);
            fVar.o0(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        }
        for (int i22 = 0; i22 < this.multiFieldValueClassUnderlyingName_.size(); i22++) {
            fVar.b0(this.multiFieldValueClassUnderlyingName_.get(i22).intValue());
        }
        for (int i23 = 0; i23 < this.multiFieldValueClassUnderlyingType_.size(); i23++) {
            fVar.d0(23, this.multiFieldValueClassUnderlyingType_.get(i23));
        }
        if (Q0().size() > 0) {
            fVar.o0(194);
            fVar.o0(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        }
        for (int i24 = 0; i24 < this.multiFieldValueClassUnderlyingTypeId_.size(); i24++) {
            fVar.b0(this.multiFieldValueClassUnderlyingTypeId_.get(i24).intValue());
        }
        if ((this.bitField0_ & 64) == 64) {
            fVar.d0(30, this.typeTable_);
        }
        for (int i25 = 0; i25 < this.versionRequirement_.size(); i25++) {
            fVar.a0(31, this.versionRequirement_.get(i25).intValue());
        }
        if ((this.bitField0_ & 128) == 128) {
            fVar.d0(32, this.versionRequirementTable_);
        }
        aVarX.a(19000, fVar);
        fVar.i0(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public b g() {
        return t1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: x1, reason: merged with bridge method [inline-methods] */
    public b c() {
        return u1(this);
    }

    private c(boolean z10) {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) throws Throwable {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        s1();
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
                            z10 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.s();
                            break;
                        case 16:
                            if ((i10 & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i10 |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 18:
                            int iJ = eVar.j(eVar.A());
                            if ((i10 & 32) != 32 && eVar.e() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i10 |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.supertypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = eVar.s();
                            break;
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = eVar.s();
                            break;
                        case 42:
                            if ((i10 & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i10 |= 8;
                            }
                            this.typeParameter_.add((s) eVar.u(s.f20341b, gVar));
                            break;
                        case 50:
                            if ((i10 & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i10 |= 16;
                            }
                            this.supertype_.add((q) eVar.u(q.f20300b, gVar));
                            break;
                        case 56:
                            if ((i10 & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i10 |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 58:
                            int iJ2 = eVar.j(eVar.A());
                            if ((i10 & 64) != 64 && eVar.e() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i10 |= 64;
                            }
                            while (eVar.e() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ2);
                            break;
                        case 66:
                            if ((i10 & 512) != 512) {
                                this.constructor_ = new ArrayList();
                                i10 |= 512;
                            }
                            this.constructor_.add((d) eVar.u(d.f20174b, gVar));
                            break;
                        case 74:
                            if ((i10 & 1024) != 1024) {
                                this.function_ = new ArrayList();
                                i10 |= 1024;
                            }
                            this.function_.add((i) eVar.u(i.f20220b, gVar));
                            break;
                        case 82:
                            if ((i10 & 2048) != 2048) {
                                this.property_ = new ArrayList();
                                i10 |= 2048;
                            }
                            this.property_.add((n) eVar.u(n.f20264b, gVar));
                            break;
                        case 90:
                            if ((i10 & 4096) != 4096) {
                                this.typeAlias_ = new ArrayList();
                                i10 |= 4096;
                            }
                            this.typeAlias_.add((r) eVar.u(r.f20329b, gVar));
                            break;
                        case 106:
                            if ((i10 & 8192) != 8192) {
                                this.enumEntry_ = new ArrayList();
                                i10 |= 8192;
                            }
                            this.enumEntry_.add((g) eVar.u(g.f20201b, gVar));
                            break;
                        case 128:
                            if ((i10 & 16384) != 16384) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i10 |= 16384;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 130:
                            int iJ3 = eVar.j(eVar.A());
                            if ((i10 & 16384) != 16384 && eVar.e() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i10 |= 16384;
                            }
                            while (eVar.e() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ3);
                            break;
                        case 136:
                            this.bitField0_ |= 8;
                            this.inlineClassUnderlyingPropertyName_ = eVar.s();
                            break;
                        case 146:
                            q.c cVarA0 = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.c() : null;
                            q qVar = (q) eVar.u(q.f20300b, gVar);
                            this.inlineClassUnderlyingType_ = qVar;
                            if (cVarA0 != 0) {
                                cVarA0.m(qVar);
                                this.inlineClassUnderlyingType_ = cVarA0.v();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case SyslogAppender.LOG_LOCAL3 /* 152 */:
                            this.bitField0_ |= 32;
                            this.inlineClassUnderlyingTypeId_ = eVar.s();
                            break;
                        case 162:
                            if ((i10 & 128) != 128) {
                                this.contextReceiverType_ = new ArrayList();
                                i10 |= 128;
                            }
                            this.contextReceiverType_.add((q) eVar.u(q.f20300b, gVar));
                            break;
                        case SyslogAppender.LOG_LOCAL5 /* 168 */:
                            if ((i10 & 256) != 256) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i10 |= 256;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 170:
                            int iJ4 = eVar.j(eVar.A());
                            if ((i10 & 256) != 256 && eVar.e() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i10 |= 256;
                            }
                            while (eVar.e() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ4);
                            break;
                        case SyslogAppender.LOG_LOCAL6 /* 176 */:
                            if ((i10 & 262144) != 262144) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                i10 |= 262144;
                            }
                            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 178:
                            int iJ5 = eVar.j(eVar.A());
                            if ((i10 & 262144) != 262144 && eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                i10 |= 262144;
                            }
                            while (eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ5);
                            break;
                        case 186:
                            if ((i10 & 524288) != 524288) {
                                this.multiFieldValueClassUnderlyingType_ = new ArrayList();
                                i10 |= 524288;
                            }
                            this.multiFieldValueClassUnderlyingType_.add((q) eVar.u(q.f20300b, gVar));
                            break;
                        case RsaOaep.DerParser.PRIVATE /* 192 */:
                            if ((i10 & 1048576) != 1048576) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                i10 |= 1048576;
                            }
                            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(eVar.s()));
                            break;
                        case 194:
                            int iJ6 = eVar.j(eVar.A());
                            if ((i10 & 1048576) != 1048576 && eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                i10 |= 1048576;
                            }
                            while (eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ6);
                            break;
                        case 242:
                            t.b bVarF = (this.bitField0_ & 64) == 64 ? this.typeTable_.c() : null;
                            t tVar = (t) eVar.u(t.f20355b, gVar);
                            this.typeTable_ = tVar;
                            if (bVarF != 0) {
                                bVarF.m(tVar);
                                this.typeTable_ = bVarF.q();
                            }
                            this.bitField0_ |= 64;
                            break;
                        case 248:
                            if ((i10 & 4194304) != 4194304) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 4194304;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            break;
                        case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                            int iJ7 = eVar.j(eVar.A());
                            if ((i10 & 4194304) != 4194304 && eVar.e() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i10 |= 4194304;
                            }
                            while (eVar.e() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(iJ7);
                            break;
                        case 258:
                            try {
                                w.b bVarA = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.c() : null;
                                w wVar = (w) eVar.u(w.f20388b, gVar);
                                this.versionRequirementTable_ = wVar;
                                if (bVarA != 0) {
                                    bVarA.m(wVar);
                                    this.versionRequirementTable_ = bVarA.q();
                                }
                                this.bitField0_ |= 128;
                            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                                e = e10;
                                throw e.i(this);
                            } catch (IOException e11) {
                                e = e11;
                                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e.getMessage()).i(this);
                            } catch (Throwable th) {
                                th = th;
                                if ((i10 & 32) == 32) {
                                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                                }
                                if ((i10 & 8) == 8) {
                                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                                }
                                if ((i10 & 16) == 16) {
                                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                                }
                                if ((i10 & 64) == 64) {
                                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                                }
                                if ((i10 & 512) == 512) {
                                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                                }
                                if ((i10 & 1024) == 1024) {
                                    this.function_ = Collections.unmodifiableList(this.function_);
                                }
                                if ((i10 & 2048) == 2048) {
                                    this.property_ = Collections.unmodifiableList(this.property_);
                                }
                                if ((i10 & 4096) == 4096) {
                                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                                }
                                if ((i10 & 8192) == 8192) {
                                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                                }
                                if ((i10 & 16384) == 16384) {
                                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                                }
                                if ((i10 & 128) == 128) {
                                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                                }
                                if ((i10 & 256) == 256) {
                                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                                }
                                if ((i10 & 262144) == 262144) {
                                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                                }
                                if ((i10 & 524288) == 524288) {
                                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                                }
                                if ((i10 & 1048576) == 1048576) {
                                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                                }
                                if ((i10 & 4194304) == 4194304) {
                                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                                }
                                try {
                                    fVarJ.I();
                                    break;
                                } catch (IOException unused) {
                                } finally {
                                    this.unknownFields = bVarU.f();
                                }
                                l();
                                throw th;
                            }
                            break;
                        default:
                            if (!o(eVar, fVarJ, gVar, iK)) {
                                z10 = true;
                            }
                            break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            }
        }
        if ((i10 & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if ((i10 & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i10 & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if ((i10 & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if ((i10 & 512) == 512) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if ((i10 & 1024) == 1024) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i10 & 2048) == 2048) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i10 & 4096) == 4096) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if ((i10 & 8192) == 8192) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if ((i10 & 16384) == 16384) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if ((i10 & 128) == 128) {
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        }
        if ((i10 & 256) == 256) {
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        }
        if ((i10 & 262144) == 262144) {
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        }
        if ((i10 & 524288) == 524288) {
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        }
        if ((i10 & 1048576) == 1048576) {
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        }
        if ((i10 & 4194304) == 4194304) {
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
