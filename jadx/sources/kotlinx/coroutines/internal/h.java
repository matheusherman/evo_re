package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lv8/j;", "context", "", "exception", "Lr8/z;", "a", "(Lv8/j;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class h {
    public static final void a(v8.j jVar, Throwable th) {
        Iterator<kotlinx.coroutines.j0> it = g.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().v(jVar, th);
            } catch (Throwable th2) {
                g.b(kotlinx.coroutines.k0.b(th, th2));
            }
        }
        try {
            r8.a.a(th, new i(jVar));
        } catch (Throwable unused) {
        }
        g.b(th);
    }
}
