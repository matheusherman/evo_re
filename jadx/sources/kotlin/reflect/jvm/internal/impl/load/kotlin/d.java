package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.load.kotlin.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f13553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k0 f13554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.e f13555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private aa.e f13556f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private abstract class a implements s.a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0239a implements s.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final /* synthetic */ s.a f13558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ s.a f13559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f13560c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ba.f f13561d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f13562e;

            C0239a(s.a aVar, a aVar2, ba.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                this.f13559b = aVar;
                this.f13560c = aVar2;
                this.f13561d = fVar;
                this.f13562e = arrayList;
                this.f13558a = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public void a() {
                this.f13559b.a();
                this.f13560c.h(this.f13561d, new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) kotlin.collections.r.F0(this.f13562e)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public s.b b(ba.f fVar) {
                return this.f13558a.b(fVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public void c(ba.f fVar, ba.b enumClassId, ba.f enumEntryName) {
                kotlin.jvm.internal.m.f(enumClassId, "enumClassId");
                kotlin.jvm.internal.m.f(enumEntryName, "enumEntryName");
                this.f13558a.c(fVar, enumClassId, enumEntryName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public void d(ba.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.m.f(value, "value");
                this.f13558a.d(fVar, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public s.a e(ba.f fVar, ba.b classId) {
                kotlin.jvm.internal.m.f(classId, "classId");
                return this.f13558a.e(fVar, classId);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
            public void f(ba.f fVar, Object obj) {
                this.f13558a.f(fVar, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b implements s.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f13563a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f13564b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ba.f f13565c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f13566d;

            /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            public static final class C0240a implements s.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final /* synthetic */ s.a f13567a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ s.a f13568b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ b f13569c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f13570d;

                C0240a(s.a aVar, b bVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                    this.f13568b = aVar;
                    this.f13569c = bVar;
                    this.f13570d = arrayList;
                    this.f13567a = aVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public void a() {
                    this.f13568b.a();
                    this.f13569c.f13563a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) kotlin.collections.r.F0(this.f13570d)));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public s.b b(ba.f fVar) {
                    return this.f13567a.b(fVar);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public void c(ba.f fVar, ba.b enumClassId, ba.f enumEntryName) {
                    kotlin.jvm.internal.m.f(enumClassId, "enumClassId");
                    kotlin.jvm.internal.m.f(enumEntryName, "enumEntryName");
                    this.f13567a.c(fVar, enumClassId, enumEntryName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public void d(ba.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                    kotlin.jvm.internal.m.f(value, "value");
                    this.f13567a.d(fVar, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public s.a e(ba.f fVar, ba.b classId) {
                    kotlin.jvm.internal.m.f(classId, "classId");
                    return this.f13567a.e(fVar, classId);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
                public void f(ba.f fVar, Object obj) {
                    this.f13567a.f(fVar, obj);
                }
            }

            b(d dVar, ba.f fVar, a aVar) {
                this.f13564b = dVar;
                this.f13565c = fVar;
                this.f13566d = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
            public void a() {
                this.f13566d.g(this.f13565c, this.f13563a);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
            public void b(Object obj) {
                this.f13563a.add(this.f13564b.J(this.f13565c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
            public void c(ba.b enumClassId, ba.f enumEntryName) {
                kotlin.jvm.internal.m.f(enumClassId, "enumClassId");
                kotlin.jvm.internal.m.f(enumEntryName, "enumEntryName");
                this.f13563a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.j(enumClassId, enumEntryName));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
            public s.a d(ba.b classId) {
                kotlin.jvm.internal.m.f(classId, "classId");
                ArrayList arrayList = new ArrayList();
                d dVar = this.f13564b;
                a1 NO_SOURCE = a1.f12668a;
                kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
                s.a aVarW = dVar.w(classId, NO_SOURCE, arrayList);
                kotlin.jvm.internal.m.c(aVarW);
                return new C0240a(aVarW, this, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
            public void e(kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.m.f(value, "value");
                this.f13563a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.q(value));
            }
        }

        public abstract void g(ba.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arrayList);

        public abstract void h(ba.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar);

        public a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.b b(ba.f fVar) {
            return new b(d.this, fVar, this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void c(ba.f fVar, ba.b enumClassId, ba.f enumEntryName) {
            kotlin.jvm.internal.m.f(enumClassId, "enumClassId");
            kotlin.jvm.internal.m.f(enumEntryName, "enumEntryName");
            h(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.j(enumClassId, enumEntryName));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void d(ba.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
            kotlin.jvm.internal.m.f(value, "value");
            h(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.q(value));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.a e(ba.f fVar, ba.b classId) {
            kotlin.jvm.internal.m.f(classId, "classId");
            ArrayList arrayList = new ArrayList();
            d dVar = d.this;
            a1 NO_SOURCE = a1.f12668a;
            kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
            s.a aVarW = dVar.w(classId, NO_SOURCE, arrayList);
            kotlin.jvm.internal.m.c(aVarW);
            return new C0239a(aVarW, this, fVar, arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void f(ba.f fVar, Object obj) {
            h(fVar, d.this.J(fVar, obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f13571b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f13573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ba.b f13574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f13575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a1 f13576g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ba.b bVar, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list, a1 a1Var) {
            super();
            this.f13573d = eVar;
            this.f13574e = bVar;
            this.f13575f = list;
            this.f13576g = a1Var;
            this.f13571b = new HashMap<>();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void a() {
            if (d.this.D(this.f13574e, this.f13571b) || d.this.v(this.f13574e)) {
                return;
            }
            this.f13575f.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(this.f13573d.p(), this.f13571b, this.f13576g));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d.a
        public void g(ba.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> elements) {
            kotlin.jvm.internal.m.f(elements, "elements");
            if (fVar == null) {
                return;
            }
            j1 j1VarB = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, this.f13573d);
            if (j1VarB != null) {
                HashMap<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map = this.f13571b;
                kotlin.reflect.jvm.internal.impl.resolve.constants.h hVar = kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a;
                List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> listC = sa.a.c(elements);
                g0 type = j1VarB.getType();
                kotlin.jvm.internal.m.e(type, "parameter.type");
                map.put(fVar, hVar.b(listC, type));
                return;
            }
            if (d.this.v(this.f13574e) && kotlin.jvm.internal.m.a(fVar.f(), "value")) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : elements) {
                    if (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
                        arrayList.add(obj);
                    }
                }
                List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list = this.f13575f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add(((kotlin.reflect.jvm.internal.impl.resolve.constants.a) it.next()).b());
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d.a
        public void h(ba.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> value) {
            kotlin.jvm.internal.m.f(value, "value");
            if (fVar != null) {
                this.f13571b.put(fVar, value);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h0 module, k0 notFoundClasses, ka.n storageManager, q kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        this.f13553c = module;
        this.f13554d = notFoundClasses;
        this.f13555e = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.e(module, notFoundClasses);
        this.f13556f = aa.e.f177i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> J(ba.f fVar, Object obj) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVarC = kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a.c(obj, this.f13553c);
        if (gVarC != null) {
            return gVarC;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.k.f13902b.a("Unsupported annotation argument: " + fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e M(ba.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.c(this.f13553c, bVar, this.f13554d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> F(String desc, Object initializer) {
        kotlin.jvm.internal.m.f(desc, "desc");
        kotlin.jvm.internal.m.f(initializer, "initializer");
        if (ua.n.O("ZBCS", desc, false, 2, null)) {
            int iIntValue = ((Integer) initializer).intValue();
            int iHashCode = desc.hashCode();
            if (iHashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 67) {
                if (desc.equals("C")) {
                    initializer = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 83) {
                if (desc.equals(ExifInterface.LATITUDE_SOUTH)) {
                    initializer = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 90 && desc.equals("Z")) {
                initializer = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(desc);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a.c(initializer, this.f13553c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c z(w9.b proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        return this.f13555e.a(proto, nameResolver);
    }

    public void N(aa.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<set-?>");
        this.f13556f = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> H(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> constant) {
        kotlin.jvm.internal.m.f(constant, "constant");
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.d) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.x(((kotlin.reflect.jvm.internal.impl.resolve.constants.d) constant).b().byteValue());
        }
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.u) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.a0(((kotlin.reflect.jvm.internal.impl.resolve.constants.u) constant).b().shortValue());
        }
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.m) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.y(((kotlin.reflect.jvm.internal.impl.resolve.constants.m) constant).b().intValue());
        }
        return constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.r ? new kotlin.reflect.jvm.internal.impl.resolve.constants.z(((kotlin.reflect.jvm.internal.impl.resolve.constants.r) constant).b().longValue()) : constant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.b
    public aa.e t() {
        return this.f13556f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.b
    protected s.a w(ba.b annotationClassId, a1 source, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> result) {
        kotlin.jvm.internal.m.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.m.f(source, "source");
        kotlin.jvm.internal.m.f(result, "result");
        return new b(M(annotationClassId), annotationClassId, result, source);
    }
}
