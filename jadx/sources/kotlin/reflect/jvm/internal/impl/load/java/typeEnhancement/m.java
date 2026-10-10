package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.IndexedValue;
import kotlin.collections.n0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.z;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, k> f13463a = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f13465b;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public final class C0235a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f13466a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<r8.p<String, q>> f13467b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private r8.p<String, q> f13468c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f13469d;

            public C0235a(a aVar, String functionName) {
                kotlin.jvm.internal.m.f(functionName, "functionName");
                this.f13469d = aVar;
                this.f13466a = functionName;
                this.f13467b = new ArrayList();
                this.f13468c = v.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final r8.p<String, k> a() {
                z zVar = z.f13623a;
                String strB = this.f13469d.b();
                String str = this.f13466a;
                List<r8.p<String, q>> list = this.f13467b;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((r8.p) it.next()).c());
                }
                String strK = zVar.k(strB, zVar.j(str, arrayList, this.f13468c.c()));
                q qVarD = this.f13468c.d();
                List<r8.p<String, q>> list2 = this.f13467b;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((q) ((r8.p) it2.next()).d());
                }
                return v.a(strK, new k(qVarD, arrayList2));
            }

            public final void b(String type, e... qualifiers) {
                q qVar;
                kotlin.jvm.internal.m.f(type, "type");
                kotlin.jvm.internal.m.f(qualifiers, "qualifiers");
                List<r8.p<String, q>> list = this.f13467b;
                if (qualifiers.length == 0) {
                    qVar = null;
                } else {
                    Iterable<IndexedValue> iterableS0 = kotlin.collections.j.S0(qualifiers);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(iterableS0, 10)), 16));
                    for (IndexedValue indexedValue : iterableS0) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                    }
                    qVar = new q(linkedHashMap);
                }
                list.add(v.a(type, qVar));
            }

            public final void c(fa.e type) {
                kotlin.jvm.internal.m.f(type, "type");
                String strJ = type.j();
                kotlin.jvm.internal.m.e(strJ, "type.desc");
                this.f13468c = v.a(strJ, null);
            }

            public final void d(String type, e... qualifiers) {
                kotlin.jvm.internal.m.f(type, "type");
                kotlin.jvm.internal.m.f(qualifiers, "qualifiers");
                Iterable<IndexedValue> iterableS0 = kotlin.collections.j.S0(qualifiers);
                LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(iterableS0, 10)), 16));
                for (IndexedValue indexedValue : iterableS0) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                }
                this.f13468c = v.a(type, new q(linkedHashMap));
            }
        }

        public a(m mVar, String className) {
            kotlin.jvm.internal.m.f(className, "className");
            this.f13465b = mVar;
            this.f13464a = className;
        }

        public final void a(String name, c9.l<? super C0235a, r8.z> block) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(block, "block");
            Map map = this.f13465b.f13463a;
            C0235a c0235a = new C0235a(this, name);
            block.invoke(c0235a);
            r8.p<String, k> pVarA = c0235a.a();
            map.put(pVarA.c(), pVarA.d());
        }

        public final String b() {
            return this.f13464a;
        }
    }

    public final Map<String, k> b() {
        return this.f13463a;
    }
}
