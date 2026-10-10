package z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?>> f22601a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f22602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final l<T> f22603b;

        boolean a(@NonNull Class<?> cls) {
            return this.f22602a.isAssignableFrom(cls);
        }

        a(@NonNull Class<T> cls, @NonNull l<T> lVar) {
            this.f22602a = cls;
            this.f22603b = lVar;
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull l<Z> lVar) {
        this.f22601a.add(new a<>(cls, lVar));
    }

    @Nullable
    public synchronized <Z> l<Z> b(@NonNull Class<Z> cls) {
        int size = this.f22601a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f22601a.get(i10);
            if (aVar.a(cls)) {
                return (l<Z>) aVar.f22603b;
            }
        }
        return null;
    }
}
