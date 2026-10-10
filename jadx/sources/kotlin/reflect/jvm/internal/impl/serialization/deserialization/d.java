package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d implements c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ia.a f14045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f14046b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14047a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14047a = iArr;
        }
    }

    public d(h0 module, k0 notFoundClasses, ia.a protocol) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(protocol, "protocol");
        this.f14045a = protocol;
        this.f14046b = new e(module, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> a(w9.q proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        List listL = (List) proto.t(this.f14045a.o());
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b(y.a container) {
        kotlin.jvm.internal.m.f(container, "container");
        List listL = (List) container.f().t(this.f14045a.a());
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> c(w9.s proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        List listL = (List) proto.t(this.f14045a.p());
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> e(y container, kotlin.reflect.jvm.internal.impl.protobuf.q proto, b kind) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(kind, "kind");
        List listL = null;
        if (proto instanceof w9.i) {
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.i, List<w9.b>> fVarG = this.f14045a.g();
            if (fVarG != null) {
                listL = (List) ((w9.i) proto).t(fVarG);
            }
        } else {
            if (!(proto instanceof w9.n)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = a.f14047a[kind.ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, List<w9.b>> fVarL = this.f14045a.l();
            if (fVarL != null) {
                listL = (List) ((w9.n) proto).t(fVarL);
            }
        }
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f(y container, w9.n proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, List<w9.b>> fVarJ = this.f14045a.j();
        List listL = fVarJ != null ? (List) proto.t(fVarJ) : null;
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> g(y container, w9.g proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        List listL = (List) proto.t(this.f14045a.d());
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> h(y container, kotlin.reflect.jvm.internal.impl.protobuf.q callableProto, b kind, int i10, w9.u proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(callableProto, "callableProto");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(proto, "proto");
        List listL = (List) proto.t(this.f14045a.h());
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> i(y container, kotlin.reflect.jvm.internal.impl.protobuf.q proto, b kind) {
        List listL;
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(kind, "kind");
        if (proto instanceof w9.d) {
            listL = (List) ((w9.d) proto).t(this.f14045a.c());
        } else if (proto instanceof w9.i) {
            listL = (List) ((w9.i) proto).t(this.f14045a.f());
        } else {
            if (!(proto instanceof w9.n)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = a.f14047a[kind.ordinal()];
            if (i10 == 1) {
                listL = (List) ((w9.n) proto).t(this.f14045a.i());
            } else if (i10 == 2) {
                listL = (List) ((w9.n) proto).t(this.f14045a.m());
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                listL = (List) ((w9.n) proto).t(this.f14045a.n());
            }
        }
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> k(y container, w9.n proto) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, List<w9.b>> fVarK = this.f14045a.k();
        List listL = fVarK != null ? (List) proto.t(fVarK) : null;
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        List list = listL;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14046b.a((w9.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.c
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> d(y container, w9.n proto, g0 expectedType) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(expectedType, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.c
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> j(y container, w9.n proto, g0 expectedType) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(expectedType, "expectedType");
        w9.b.C0384b.c cVar = (w9.b.C0384b.c) y9.e.a(proto, this.f14045a.b());
        if (cVar == null) {
            return null;
        }
        return this.f14046b.f(expectedType, cVar, container.b());
    }
}
