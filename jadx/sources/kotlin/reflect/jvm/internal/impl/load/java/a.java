package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.v0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final C0223a f13092c = new C0223a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, kotlin.reflect.jvm.internal.impl.load.java.b> f13093d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f13094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Object, TAnnotation> f13095b;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0223a {
        public /* synthetic */ C0223a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private C0223a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<TAnnotation, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13096a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation extractNullability) {
            kotlin.jvm.internal.m.f(extractNullability, "$this$extractNullability");
            return Boolean.FALSE;
        }
    }

    protected abstract Iterable<String> b(TAnnotation tannotation, boolean z10);

    protected abstract ba.c i(TAnnotation tannotation);

    protected abstract Object j(TAnnotation tannotation);

    protected abstract Iterable<TAnnotation> k(TAnnotation tannotation);

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (kotlin.reflect.jvm.internal.impl.load.java.b bVar : kotlin.reflect.jvm.internal.impl.load.java.b.values()) {
            String strF = bVar.f();
            if (linkedHashMap.get(strF) == null) {
                linkedHashMap.put(strF, bVar);
            }
        }
        f13093d = linkedHashMap;
    }

    public a(x javaTypeEnhancementState) {
        kotlin.jvm.internal.m.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f13094a = javaTypeEnhancementState;
        this.f13095b = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<kotlin.reflect.jvm.internal.impl.load.java.b> a(Set<? extends kotlin.reflect.jvm.internal.impl.load.java.b> set) {
        return set.contains(kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_USE) ? v0.k(v0.j(kotlin.collections.j.R0(kotlin.reflect.jvm.internal.impl.load.java.b.values()), kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_PARAMETER_BOUNDS), set) : set;
    }

    private final g0 q(TAnnotation tannotation) {
        Iterable<String> iterableB;
        String str;
        g0 g0Var = this.f13094a.d().c().get(i(tannotation));
        if (g0Var != null) {
            return g0Var;
        }
        TAnnotation tannotationH = h(tannotation, c.d());
        if (tannotationH == null || (iterableB = b(tannotationH, false)) == null || (str = (String) kotlin.collections.r.h0(iterableB)) == null) {
            return null;
        }
        g0 g0VarB = this.f13094a.d().b();
        if (g0VarB != null) {
            return g0VarB;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2137067054) {
            if (iHashCode != -1838656823) {
                if (iHashCode == 2656902 && str.equals("WARN")) {
                    return g0.WARN;
                }
            } else if (str.equals("STRICT")) {
                return g0.STRICT;
            }
        } else if (str.equals("IGNORE")) {
            return g0.IGNORE;
        }
        return null;
    }

    private final r r(TAnnotation tannotation) {
        r rVar;
        if (this.f13094a.b() || (rVar = c.a().get(i(tannotation))) == null) {
            return null;
        }
        g0 g0VarO = o(tannotation);
        if (g0VarO == g0.IGNORE) {
            g0VarO = null;
        }
        if (g0VarO == null) {
            return null;
        }
        return r.b(rVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b(rVar.d(), null, g0VarO.j(), 1, null), null, false, 6, null);
    }

    private final r8.p<TAnnotation, Set<kotlin.reflect.jvm.internal.impl.load.java.b>> t(TAnnotation tannotation) {
        TAnnotation tannotationH;
        TAnnotation next;
        if (this.f13094a.d().d() || (tannotationH = h(tannotation, c.e())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = k(tannotation).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (s(next) == null);
        if (next == null) {
            return null;
        }
        Iterable<String> iterableB = b(tannotationH, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = iterableB.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.b bVar = f13093d.get(it2.next());
            if (bVar != null) {
                linkedHashSet.add(bVar);
            }
        }
        return new r8.p<>(next, a(linkedHashSet));
    }

    public final y c(y yVar, Iterable<? extends TAnnotation> annotations) {
        EnumMap<kotlin.reflect.jvm.internal.impl.load.java.b, r> enumMapB;
        kotlin.jvm.internal.m.f(annotations, "annotations");
        if (!this.f13094a.b()) {
            ArrayList<r> arrayList = new ArrayList();
            Iterator<? extends TAnnotation> it = annotations.iterator();
            while (it.hasNext()) {
                r rVarD = d(it.next());
                if (rVarD != null) {
                    arrayList.add(rVarD);
                }
            }
            if (!arrayList.isEmpty()) {
                EnumMap enumMap = (yVar == null || (enumMapB = yVar.b()) == null) ? new EnumMap(kotlin.reflect.jvm.internal.impl.load.java.b.class) : new EnumMap((EnumMap) enumMapB);
                boolean z10 = false;
                for (r rVar : arrayList) {
                    Iterator<kotlin.reflect.jvm.internal.impl.load.java.b> it2 = rVar.e().iterator();
                    while (it2.hasNext()) {
                        enumMap.put(it2.next(), rVar);
                        z10 = true;
                    }
                }
                if (z10) {
                    return new y(enumMap);
                }
            }
        }
        return yVar;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f e(Iterable<? extends TAnnotation> annotations) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar;
        kotlin.jvm.internal.m.f(annotations, "annotations");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar2 = null;
        while (it.hasNext()) {
            ba.c cVarI = i(it.next());
            if (c0.p().contains(cVarI)) {
                fVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.READ_ONLY;
            } else if (c0.m().contains(cVarI)) {
                fVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.MUTABLE;
            } else {
                continue;
            }
            if (fVar2 != null && fVar2 != fVar) {
                return null;
            }
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i f(Iterable<? extends TAnnotation> annotations, c9.l<? super TAnnotation, Boolean> forceWarning) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(forceWarning, "forceWarning");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVar = null;
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVarG = g(it.next(), forceWarning);
            if (iVar != null) {
                if (iVarG != null && !kotlin.jvm.internal.m.a(iVarG, iVar) && (!iVarG.d() || iVar.d())) {
                    if (iVarG.d() || !iVar.d()) {
                        return null;
                    }
                }
            }
            iVar = iVarG;
        }
        return iVar;
    }

    public final boolean m(TAnnotation annotation) {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        TAnnotation tannotationH = h(annotation, kotlin.reflect.jvm.internal.impl.builtins.k.a.H);
        if (tannotationH == null) {
            return false;
        }
        Iterable<String> iterableB = b(tannotationH, false);
        if ((iterableB instanceof Collection) && ((Collection) iterableB).isEmpty()) {
            return false;
        }
        Iterator<String> it = iterableB.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(it.next(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.n.TYPE.name())) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation s(TAnnotation annotation) {
        TAnnotation tannotationS;
        kotlin.jvm.internal.m.f(annotation, "annotation");
        if (this.f13094a.d().d()) {
            return null;
        }
        if (kotlin.collections.r.a0(c.b(), i(annotation)) || l(annotation, c.f())) {
            return annotation;
        }
        if (!l(annotation, c.g())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.f13095b;
        Object objJ = j(annotation);
        TAnnotation tannotation = concurrentHashMap.get(objJ);
        if (tannotation != null) {
            return tannotation;
        }
        Iterator<TAnnotation> it = k(annotation).iterator();
        do {
            if (!it.hasNext()) {
                tannotationS = null;
                break;
            }
            tannotationS = s(it.next());
        } while (tannotationS == null);
        if (tannotationS == null) {
            return null;
        }
        TAnnotation tannotationPutIfAbsent = concurrentHashMap.putIfAbsent(objJ, tannotationS);
        return tannotationPutIfAbsent == null ? tannotationS : tannotationPutIfAbsent;
    }

    private final r d(TAnnotation tannotation) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVarG;
        r rVarR = r(tannotation);
        if (rVarR != null) {
            return rVarR;
        }
        r8.p<TAnnotation, Set<kotlin.reflect.jvm.internal.impl.load.java.b>> pVarT = t(tannotation);
        if (pVarT == null) {
            return null;
        }
        TAnnotation tannotationA = pVarT.a();
        Set<kotlin.reflect.jvm.internal.impl.load.java.b> setB = pVarT.b();
        g0 g0VarQ = q(tannotation);
        if (g0VarQ == null) {
            g0VarQ = p(tannotationA);
        }
        if (g0VarQ.i() || (iVarG = g(tannotationA, b.f13096a)) == null) {
            return null;
        }
        return new r(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b(iVarG, null, g0VarQ.j(), 1, null), setB, false, 4, null);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i g(TAnnotation tannotation, c9.l<? super TAnnotation, Boolean> lVar) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVarN;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i iVarN2 = n(tannotation, lVar.invoke(tannotation).booleanValue());
        if (iVarN2 != null) {
            return iVarN2;
        }
        TAnnotation tannotationS = s(tannotation);
        if (tannotationS == null) {
            return null;
        }
        g0 g0VarP = p(tannotation);
        if (g0VarP.i() || (iVarN = n(tannotationS, lVar.invoke(tannotationS).booleanValue())) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b(iVarN, null, g0VarP.j(), 1, null);
    }

    private final TAnnotation h(TAnnotation tannotation, ba.c cVar) {
        for (TAnnotation tannotation2 : k(tannotation)) {
            if (kotlin.jvm.internal.m.a(i(tannotation2), cVar)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean l(TAnnotation tannotation, ba.c cVar) {
        Iterable<TAnnotation> iterableK = k(tannotation);
        if ((iterableK instanceof Collection) && ((Collection) iterableK).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = iterableK.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(i(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
    
        if (r7.equals("ALWAYS") != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a6, code lost:
    
        if (r7.equals("NEVER") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
    
        if (r7.equals("MAYBE") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b2, code lost:
    
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i n(TAnnotation tannotation, boolean z10) {
        boolean zA;
        boolean zA2;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h hVar;
        ba.c cVarI = i(tannotation);
        if (cVarI == null) {
            return null;
        }
        g0 g0VarInvoke = this.f13094a.c().invoke(cVarI);
        if (g0VarInvoke.i()) {
            return null;
        }
        boolean z11 = false;
        if (c0.o().contains(cVarI)) {
            hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE;
        } else if (c0.n().contains(cVarI)) {
            hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NOT_NULL;
        } else {
            if (kotlin.jvm.internal.m.a(cVarI, c0.j())) {
                zA = true;
            } else {
                zA = kotlin.jvm.internal.m.a(cVarI, c0.g());
            }
            if (zA) {
                hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE;
            } else {
                if (kotlin.jvm.internal.m.a(cVarI, c0.k())) {
                    zA2 = true;
                } else {
                    zA2 = kotlin.jvm.internal.m.a(cVarI, c0.h());
                }
                if (zA2) {
                    hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.FORCE_FLEXIBILITY;
                } else if (kotlin.jvm.internal.m.a(cVarI, c0.f())) {
                    String str = (String) kotlin.collections.r.h0(b(tannotation, false));
                    if (str != null) {
                        switch (str.hashCode()) {
                            case 73135176:
                                break;
                            case 74175084:
                                break;
                            case 433141802:
                                if (str.equals("UNKNOWN")) {
                                    hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.FORCE_FLEXIBILITY;
                                    break;
                                }
                                return null;
                            case 1933739535:
                                break;
                            default:
                                return null;
                        }
                    } else {
                        hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NOT_NULL;
                    }
                } else if (kotlin.jvm.internal.m.a(cVarI, c0.d())) {
                    hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE;
                } else if (kotlin.jvm.internal.m.a(cVarI, c0.c()) || kotlin.jvm.internal.m.a(cVarI, c0.a())) {
                    hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NOT_NULL;
                } else {
                    if (!kotlin.jvm.internal.m.a(cVarI, c0.b())) {
                        return null;
                    }
                    hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE;
                }
            }
        }
        if (g0VarInvoke.j() || z10) {
            z11 = true;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(hVar, z11);
    }

    private final g0 o(TAnnotation tannotation) {
        ba.c cVarI = i(tannotation);
        if (cVarI != null && c.c().containsKey(cVarI)) {
            return this.f13094a.c().invoke(cVarI);
        }
        return p(tannotation);
    }

    private final g0 p(TAnnotation tannotation) {
        g0 g0VarQ = q(tannotation);
        if (g0VarQ != null) {
            return g0VarQ;
        }
        return this.f13094a.d().a();
    }
}
