package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class i extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<MessageType extends i, BuilderType extends b> extends kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0243a<BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d f13668a = kotlin.reflect.jvm.internal.impl.protobuf.d.f13632a;

        public abstract BuilderType m(MessageType messagetype);

        @Override // 
        public BuilderType k() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.d l() {
            return this.f13668a;
        }

        public final BuilderType n(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f13668a = dVar;
            return this;
        }

        protected b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h<e> f13669b = h.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13670c;

        /* JADX INFO: Access modifiers changed from: private */
        public h<e> p() {
            this.f13669b.q();
            this.f13670c = false;
            return this.f13669b;
        }

        private void q() {
            if (this.f13670c) {
                return;
            }
            this.f13669b = this.f13669b.clone();
            this.f13670c = true;
        }

        protected c() {
        }

        protected final void s(MessageType messagetype) {
            q();
            this.f13669b.r(((d) messagetype).extensions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class d<MessageType extends d<MessageType>> extends i implements r {
        private final h<e> extensions;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        protected class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<e, Object>> f13671a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f13672b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f13673c;

            /* synthetic */ a(d dVar, boolean z10, a aVar) {
                this(z10);
            }

            private a(boolean z10) {
                Iterator<Map.Entry<e, Object>> itP = d.this.extensions.p();
                this.f13671a = itP;
                if (itP.hasNext()) {
                    this.f13672b = itP.next();
                }
                this.f13673c = z10;
            }

            public void a(int i10, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                while (true) {
                    Map.Entry<e, Object> entry = this.f13672b;
                    if (entry == null || entry.getKey().h() >= i10) {
                        return;
                    }
                    e key = this.f13672b.getKey();
                    if (this.f13673c && key.L() == z.c.MESSAGE && !key.E()) {
                        fVar.f0(key.h(), (q) this.f13672b.getValue());
                    } else {
                        h.z(key, this.f13672b.getValue(), fVar);
                    }
                    if (this.f13671a.hasNext()) {
                        this.f13672b = this.f13671a.next();
                    } else {
                        this.f13672b = null;
                    }
                }
            }
        }

        protected d() {
            this.extensions = h.t();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i
        protected void l() {
            this.extensions.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i
        protected boolean o(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, g gVar, int i10) {
            return i.p(this.extensions, a(), eVar, fVar, gVar, i10);
        }

        protected boolean r() {
            return this.extensions.n();
        }

        protected int s() {
            return this.extensions.k();
        }

        protected d<MessageType>.a x() {
            return new a(this, false, null);
        }

        protected d(c<MessageType, ?> cVar) {
            this.extensions = cVar.p();
        }

        private void y(f<MessageType, ?> fVar) {
            if (fVar.b() == a()) {
            } else {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type t(f<MessageType, Type> fVar) {
            y(fVar);
            Object objH = this.extensions.h(fVar.f13683d);
            if (objH == null) {
                return fVar.f13681b;
            }
            return (Type) fVar.a(objH);
        }

        public final <Type> Type u(f<MessageType, List<Type>> fVar, int i10) {
            y(fVar);
            return (Type) fVar.e(this.extensions.i(fVar.f13683d, i10));
        }

        public final <Type> int v(f<MessageType, List<Type>> fVar) {
            y(fVar);
            return this.extensions.j(fVar.f13683d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean w(f<MessageType, Type> fVar) {
            y(fVar);
            return this.extensions.m(fVar.f13683d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e implements h.b<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final j.b<?> f13675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f13676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final z.b f13677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f13678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f13679e;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public q.a D(q.a aVar, q qVar) {
            return ((b) aVar).m((i) qVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public boolean E() {
            return this.f13678d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public z.b H() {
            return this.f13677c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public z.c L() {
            return this.f13677c.a();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public boolean N() {
            return this.f13679e;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f13676b - eVar.f13676b;
        }

        public j.b<?> f() {
            return this.f13675a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public int h() {
            return this.f13676b;
        }

        e(j.b<?> bVar, int i10, z.b bVar2, boolean z10, boolean z11) {
            this.f13675a = bVar;
            this.f13676b = i10;
            this.f13677c = bVar2;
            this.f13678d = z10;
            this.f13679e = z11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class f<ContainingType extends q, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ContainingType f13680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Type f13681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final q f13682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final e f13683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Class f13684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Method f13685f;

        Object a(Object obj) {
            if (!this.f13683d.E()) {
                return e(obj);
            }
            if (this.f13683d.L() != z.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.f13680a;
        }

        public q c() {
            return this.f13682c;
        }

        public int d() {
            return this.f13683d.h();
        }

        Object e(Object obj) {
            return this.f13683d.L() == z.c.ENUM ? i.k(this.f13685f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f13683d.L() == z.c.ENUM ? Integer.valueOf(((j.a) obj).h()) : obj;
        }

        f(ContainingType containingtype, Type type, q qVar, e eVar, Class cls) {
            if (containingtype != null) {
                if (eVar.H() == z.b.f13758k && qVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f13680a = containingtype;
                this.f13681b = type;
                this.f13682c = qVar;
                this.f13683d = eVar;
                this.f13684e = cls;
                if (j.a.class.isAssignableFrom(cls)) {
                    this.f13685f = i.j(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.f13685f = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    protected i() {
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> m(ContainingType containingtype, q qVar, j.b<?> bVar, int i10, z.b bVar2, boolean z10, Class cls) {
        return new f<>(containingtype, Collections.EMPTY_LIST, qVar, new e(bVar, i10, bVar2, true, z10), cls);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> n(ContainingType containingtype, Type type, q qVar, j.b<?> bVar, int i10, z.b bVar2, Class cls) {
        return new f<>(containingtype, type, qVar, new e(bVar, i10, bVar2, false, false), cls);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13667a;

        static {
            int[] iArr = new int[z.c.values().length];
            f13667a = iArr;
            try {
                iArr[z.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13667a[z.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected i(b bVar) {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public s<? extends q> h() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static Method j(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb2.append("Generated message class \"");
            sb2.append(name);
            sb2.append("\" missing method \"");
            sb2.append(strValueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    static Object k(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:4:0x0010  */
    public static <MessageType extends q> boolean p(h<e> hVar, MessageType messagetype, kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, g gVar, int i10) throws k {
        boolean z10;
        boolean z11;
        q.a aVarG;
        Object objBuild;
        q qVar;
        int iB = z.b(i10);
        f fVarB = gVar.b(messagetype, z.a(i10));
        if (fVarB == null) {
            z10 = true;
            z11 = false;
        } else if (iB == h.l(fVarB.f13683d.H(), false)) {
            z10 = false;
            z11 = false;
        } else {
            e eVar2 = fVarB.f13683d;
            if (!eVar2.f13678d || !eVar2.f13677c.i() || iB != h.l(fVarB.f13683d.H(), true)) {
                z10 = true;
                z11 = false;
            } else {
                z10 = false;
                z11 = true;
            }
        }
        if (z10) {
            return eVar.P(i10, fVar);
        }
        if (z11) {
            int iJ = eVar.j(eVar.A());
            if (fVarB.f13683d.H() == z.b.f13761n) {
                while (eVar.e() > 0) {
                    j.a aVarA = fVarB.f13683d.f().a(eVar.n());
                    if (aVarA == null) {
                        return true;
                    }
                    hVar.a(fVarB.f13683d, fVarB.f(aVarA));
                }
            } else {
                while (eVar.e() > 0) {
                    hVar.a(fVarB.f13683d, h.u(eVar, fVarB.f13683d.H(), false));
                }
            }
            eVar.i(iJ);
        } else {
            int i11 = a.f13667a[fVarB.f13683d.L().ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    objBuild = h.u(eVar, fVarB.f13683d.H(), false);
                } else {
                    int iN = eVar.n();
                    j.a aVarA2 = fVarB.f13683d.f().a(iN);
                    if (aVarA2 == null) {
                        fVar.o0(i10);
                        fVar.y0(iN);
                        return true;
                    }
                    objBuild = aVarA2;
                }
            } else {
                if (!fVarB.f13683d.E() && (qVar = (q) hVar.h(fVarB.f13683d)) != null) {
                    aVarG = qVar.c();
                } else {
                    aVarG = null;
                }
                if (aVarG == null) {
                    aVarG = fVarB.c().g();
                }
                if (fVarB.f13683d.H() == z.b.f13757j) {
                    eVar.r(fVarB.d(), aVarG, gVar);
                } else {
                    eVar.v(aVarG, gVar);
                }
                objBuild = aVarG.build();
            }
            if (fVarB.f13683d.E()) {
                hVar.a(fVarB.f13683d, fVarB.f(objBuild));
            } else {
                hVar.v(fVarB.f13683d, fVarB.f(objBuild));
            }
        }
        return true;
    }

    protected boolean o(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, g gVar, int i10) {
        return eVar.P(i10, fVar);
    }

    protected void l() {
    }
}
