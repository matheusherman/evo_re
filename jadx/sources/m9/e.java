package m9;

import androidx.exifinterface.media.ExifInterface;
import ba.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.IndexedValue;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.util.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e extends g0 {
    public static final a E = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }

        public final e a(b functionClass, boolean z10) {
            m.f(functionClass, "functionClass");
            List<f1> listR = functionClass.r();
            e eVar = new e(functionClass, null, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, z10, null);
            x0 x0VarF0 = functionClass.F0();
            List<x0> listL = r.l();
            List<? extends f1> listL2 = r.l();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listR) {
                if (((f1) obj).j() != w1.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<IndexedValue> iterableU0 = r.U0(arrayList);
            ArrayList arrayList2 = new ArrayList(r.w(iterableU0, 10));
            for (IndexedValue indexedValue : iterableU0) {
                arrayList2.add(e.E.b(eVar, indexedValue.c(), (f1) indexedValue.d()));
            }
            eVar.N0(null, x0VarF0, listL, listL2, arrayList2, ((f1) r.s0(listR)).p(), e0.ABSTRACT, t.f13068e);
            eVar.V0(true);
            return eVar;
        }

        private final j1 b(e eVar, int i10, f1 f1Var) {
            String lowerCase;
            String strF = f1Var.getName().f();
            m.e(strF, "typeParameter.name.asString()");
            if (m.a(strF, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else if (m.a(strF, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strF.toLowerCase(Locale.ROOT);
                m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
            f fVarL = f.l(lowerCase);
            m.e(fVarL, "identifier(name)");
            o0 o0VarP = f1Var.p();
            m.e(o0VarP, "typeParameter.defaultType");
            a1 NO_SOURCE = a1.f12668a;
            m.e(NO_SOURCE, "NO_SOURCE");
            return new l0(eVar, null, i10, gVarB, fVarL, o0VarP, false, false, false, null, NO_SOURCE);
        }
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, e eVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10, g gVar) {
        this(mVar, eVar, aVar, z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean L() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    private e(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, e eVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        super(mVar, eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), q.f14446i, aVar, a1.f12668a);
        b1(true);
        d1(z10);
        U0(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    protected p H0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, a1 source) {
        m.f(newOwner, "newOwner");
        m.f(kind, "kind");
        m.f(annotations, "annotations");
        m.f(source, "source");
        return new e(newOwner, (e) yVar, kind, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    protected y I0(p.c configuration) {
        m.f(configuration, "configuration");
        e eVar = (e) super.I0(configuration);
        if (eVar == null) {
            return null;
        }
        List<j1> listF = eVar.f();
        m.e(listF, "substituted.valueParameters");
        List<j1> list = listF;
        if ((list instanceof Collection) && list.isEmpty()) {
            return eVar;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.g0 type = ((j1) it.next()).getType();
            m.e(type, "it.type");
            if (kotlin.reflect.jvm.internal.impl.builtins.g.d(type) != null) {
                List<j1> listF2 = eVar.f();
                m.e(listF2, "substituted.valueParameters");
                List<j1> list2 = listF2;
                ArrayList arrayList = new ArrayList(r.w(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.types.g0 type2 = ((j1) it2.next()).getType();
                    m.e(type2, "it.type");
                    arrayList.add(kotlin.reflect.jvm.internal.impl.builtins.g.d(type2));
                }
                return eVar.l1(arrayList);
            }
        }
        return eVar;
    }

    private final y l1(List<f> list) {
        f fVar;
        int size = f().size() - list.size();
        boolean z10 = true;
        if (size == 0) {
            List<j1> valueParameters = f();
            m.e(valueParameters, "valueParameters");
            List<r8.p> listW0 = r.W0(list, valueParameters);
            if ((listW0 instanceof Collection) && listW0.isEmpty()) {
                return this;
            }
            for (r8.p pVar : listW0) {
                if (!m.a((f) pVar.a(), ((j1) pVar.b()).getName())) {
                }
            }
            return this;
        }
        List<j1> valueParameters2 = f();
        m.e(valueParameters2, "valueParameters");
        List<j1> list2 = valueParameters2;
        ArrayList arrayList = new ArrayList(r.w(list2, 10));
        for (j1 j1Var : list2) {
            f name = j1Var.getName();
            m.e(name, "it.name");
            int index = j1Var.getIndex();
            int i10 = index - size;
            if (i10 >= 0 && (fVar = list.get(i10)) != null) {
                name = fVar;
            }
            arrayList.add(j1Var.B(this, name, index));
        }
        p.c cVarO0 = O0(p1.f14355b);
        List<f> list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((f) it.next()) == null) {
                }
            }
            z10 = false;
        }
        p.c cVarG = cVarO0.G(z10).b(arrayList).g(a());
        m.e(cVarG, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        y yVarI0 = super.I0(cVarG);
        m.c(yVarI0);
        return yVarI0;
    }
}
