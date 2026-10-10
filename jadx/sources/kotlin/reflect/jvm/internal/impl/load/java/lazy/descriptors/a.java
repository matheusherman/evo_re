package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.jvm.internal.o;
import u9.p;
import u9.q;
import u9.r;
import u9.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u9.g f13273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<q, Boolean> f13274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c9.l<r, Boolean> f13275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<ba.f, List<r>> f13276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<ba.f, u9.n> f13277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<ba.f, w> f13278f;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0228a extends o implements c9.l<r, Boolean> {
        C0228a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(r m10) {
            kotlin.jvm.internal.m.f(m10, "m");
            return Boolean.valueOf(((Boolean) a.this.f13274b.invoke(m10)).booleanValue() && !p.c(m10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(u9.g jClass, c9.l<? super q, Boolean> memberFilter) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        kotlin.jvm.internal.m.f(memberFilter, "memberFilter");
        this.f13273a = jClass;
        this.f13274b = memberFilter;
        C0228a c0228a = new C0228a();
        this.f13275c = c0228a;
        ta.h hVarY = ta.k.y(kotlin.collections.r.Z(jClass.K()), c0228a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : hVarY) {
            ba.f name = ((r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f13276d = linkedHashMap;
        ta.h hVarY2 = ta.k.y(kotlin.collections.r.Z(this.f13273a.A()), this.f13274b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : hVarY2) {
            linkedHashMap2.put(((u9.n) obj2).getName(), obj2);
        }
        this.f13277e = linkedHashMap2;
        Collection<w> collectionI = this.f13273a.i();
        c9.l<q, Boolean> lVar = this.f13274b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionI) {
            if (lVar.invoke((q) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((w) obj4).getName(), obj4);
        }
        this.f13278f = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public Set<ba.f> a() {
        ta.h hVarY = ta.k.y(kotlin.collections.r.Z(this.f13273a.K()), this.f13275c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarY.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public Collection<r> b(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        List<r> list = this.f13276d.get(name);
        return list != null ? list : kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public w c(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return this.f13278f.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public u9.n d(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return this.f13277e.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public Set<ba.f> e() {
        return this.f13278f.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    public Set<ba.f> f() {
        ta.h hVarY = ta.k.y(kotlin.collections.r.Z(this.f13273a.A()), this.f13274b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarY.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((u9.n) it.next()).getName());
        }
        return linkedHashSet;
    }
}
