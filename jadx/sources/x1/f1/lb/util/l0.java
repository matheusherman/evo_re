package x1.f1.lb.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lx1/f1/lb/util/l0;", "", "<init>", "()V", "", "path", "a", "(Ljava/lang/String;)Ljava/lang/String;", "", "b", "()Ljava/util/List;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f21409a = new l0();

    public final String a(String path) {
        String string;
        if (path == null || (string = ua.n.Q0(path).toString()) == null) {
            string = "";
        }
        List<String> listB = b();
        if (listB.isEmpty()) {
            return string;
        }
        if (ua.n.I(string, "/", false, 2, null)) {
            return ((Object) listB.get(0)) + string;
        }
        return ((Object) listB.get(0)) + "/" + string;
    }

    public final List<String> b() {
        List<String> listE = x1.f1.lb.host.b.f20720a.e("IMG_SERVERS");
        return listE == null ? new ArrayList() : listE;
    }

    private l0() {
    }
}
