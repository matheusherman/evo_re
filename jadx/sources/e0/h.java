package e0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class h<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<T, a<Y>> f9794a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9797d;

    @Nullable
    public synchronized Y g(@NonNull T t10) {
        a<Y> aVar;
        aVar = this.f9794a.get(t10);
        return aVar != null ? aVar.f9798a : null;
    }

    public synchronized long h() {
        return this.f9796c;
    }

    protected int i(@Nullable Y y10) {
        return 1;
    }

    @Nullable
    public synchronized Y k(@NonNull T t10, @Nullable Y y10) {
        int i10 = i(y10);
        long j10 = i10;
        if (j10 >= this.f9796c) {
            j(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f9797d += j10;
        }
        a<Y> aVarPut = this.f9794a.put(t10, y10 == null ? null : new a<>(y10, i10));
        if (aVarPut != null) {
            this.f9797d -= (long) aVarPut.f9799b;
            if (!aVarPut.f9798a.equals(y10)) {
                j(t10, aVarPut.f9798a);
            }
        }
        f();
        return aVarPut != null ? aVarPut.f9798a : null;
    }

    @Nullable
    public synchronized Y l(@NonNull T t10) {
        a<Y> aVarRemove = this.f9794a.remove(t10);
        if (aVarRemove == null) {
            return null;
        }
        this.f9797d -= (long) aVarRemove.f9799b;
        return aVarRemove.f9798a;
    }

    protected synchronized void m(long j10) {
        while (this.f9797d > j10) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f9794a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f9797d -= (long) value.f9799b;
            T key = next.getKey();
            it.remove();
            j(key, value.f9798a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Y f9798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f9799b;

        a(Y y10, int i10) {
            this.f9798a = y10;
            this.f9799b = i10;
        }
    }

    private void f() {
        m(this.f9796c);
    }

    public void b() {
        m(0L);
    }

    public h(long j10) {
        this.f9795b = j10;
        this.f9796c = j10;
    }

    protected void j(@NonNull T t10, @Nullable Y y10) {
    }
}
