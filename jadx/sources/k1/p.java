package k1;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f12063a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f12064b = Collections.synchronizedMap(new WeakHashMap());

    public final void d() {
        f(false, e.f12004p);
    }

    private final void f(boolean z10, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f12063a) {
            map = new HashMap(this.f12063a);
        }
        synchronized (this.f12064b) {
            map2 = new HashMap(this.f12064b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((e2.h) entry2.getKey()).d(new com.google.android.gms.common.api.b(status));
            }
        }
    }

    final void c(int i10, @Nullable String str) {
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        f(true, new Status(20, sb2.toString()));
    }

    final boolean e() {
        return (this.f12063a.isEmpty() && this.f12064b.isEmpty()) ? false : true;
    }

    final void b(e2.h hVar, boolean z10) {
        this.f12064b.put(hVar, Boolean.valueOf(z10));
        hVar.a().b(new o(this, hVar));
    }
}
