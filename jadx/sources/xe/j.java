package xe;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<j> f22239d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f22240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    q f22241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j f22242c;

    static void b(j jVar) {
        jVar.f22240a = null;
        jVar.f22241b = null;
        jVar.f22242c = null;
        List<j> list = f22239d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static j a(q qVar, Object obj) {
        List<j> list = f22239d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new j(obj, qVar);
                }
                j jVarRemove = list.remove(size - 1);
                jVarRemove.f22240a = obj;
                jVarRemove.f22241b = qVar;
                jVarRemove.f22242c = null;
                return jVarRemove;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j(Object obj, q qVar) {
        this.f22240a = obj;
        this.f22241b = qVar;
    }
}
