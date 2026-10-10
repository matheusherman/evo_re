package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n extends AbstractList<String> implements RandomAccess, o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f13695b = new n().c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Object> f13696a;

    public n() {
        this.f13696a = new ArrayList();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    private static d f(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        return obj instanceof String ? d.k((String) obj) : d.h((byte[]) obj);
    }

    private static String g(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof d ? ((d) obj).A() : j.b((byte[]) obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public List<?> R() {
        return Collections.unmodifiableList(this.f13696a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public d Z(int i10) {
        Object obj = this.f13696a.get(i10);
        d dVarF = f(obj);
        if (dVarF != obj) {
            this.f13696a.set(i10, dVarF);
        }
        return dVarF;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        if (collection instanceof o) {
            collection = ((o) collection).R();
        }
        boolean zAddAll = this.f13696a.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public o c0() {
        return new x(this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f13696a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        this.f13696a.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void e0(d dVar) {
        this.f13696a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f13696a.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String strA = dVar.A();
            if (dVar.r()) {
                this.f13696a.set(i10, strA);
            }
            return strA;
        }
        byte[] bArr = (byte[]) obj;
        String strB = j.b(bArr);
        if (j.a(bArr)) {
            this.f13696a.set(i10, strB);
        }
        return strB;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        Object objRemove = this.f13696a.remove(i10);
        ((AbstractList) this).modCount++;
        return g(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        return g(this.f13696a.set(i10, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13696a.size();
    }

    public n(o oVar) {
        this.f13696a = new ArrayList(oVar.size());
        addAll(oVar);
    }
}
