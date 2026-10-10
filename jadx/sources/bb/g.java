package bb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f1040a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f1041b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1043b;

        /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            String str = this.f1042a;
            if (str == null && bVar.f1042a != null) {
                return false;
            }
            if (this.f1043b == null && bVar.f1043b != null) {
                return false;
            }
            if (str != null && !str.equals(bVar.f1042a)) {
                return false;
            }
            String str2 = this.f1043b;
            return str2 == null || str2.equals(bVar.f1043b);
        }

        private b(String str, String str2) {
            this.f1042a = str;
            this.f1043b = str2;
        }

        public String c() {
            return this.f1042a;
        }

        public String d() {
            return this.f1043b;
        }

        public int hashCode() {
            return (this.f1042a.hashCode() * 31) + this.f1043b.hashCode();
        }
    }

    public String c(String str) {
        if (str == null) {
            return null;
        }
        for (b bVar : this.f1040a) {
            if (bVar.f1043b.equals(str)) {
                return bVar.f1042a;
            }
        }
        return null;
    }

    public void a(eb.g gVar) {
        b bVar = new b(gVar.a(), gVar.b(), null);
        this.f1040a.add(bVar);
        this.f1041b.add(bVar);
    }

    public List<b> b() {
        if (this.f1041b.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f1041b);
        this.f1041b.clear();
        return arrayList;
    }

    public void d(eb.f fVar) {
        b bVar = new b(fVar.a(), fVar.b(), null);
        this.f1040a.remove(bVar);
        this.f1041b.remove(bVar);
    }
}
