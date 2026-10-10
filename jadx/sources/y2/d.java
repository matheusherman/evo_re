package y2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f22315b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<f> f22316a = new HashSet();

    public static d a() {
        d dVar;
        d dVar2 = f22315b;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f22315b;
                if (dVar == null) {
                    dVar = new d();
                    f22315b = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    Set<f> b() {
        Set<f> setUnmodifiableSet;
        synchronized (this.f22316a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f22316a);
        }
        return setUnmodifiableSet;
    }

    d() {
    }
}
