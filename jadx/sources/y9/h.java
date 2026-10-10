package y9;

import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import w9.v;
import w9.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22527b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f22528c = new h(r.l());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<v> f22529a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final h a(w table) {
            m.f(table, "table");
            if (table.u() == 0) {
                return b();
            }
            List<v> listV = table.v();
            m.e(listV, "table.requirementList");
            return new h(listV, null);
        }

        public final h b() {
            return h.f22528c;
        }
    }

    public /* synthetic */ h(List list, kotlin.jvm.internal.g gVar) {
        this(list);
    }

    private h(List<v> list) {
        this.f22529a = list;
    }
}
