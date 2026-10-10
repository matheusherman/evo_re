package z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0482a<?>> f22587a = new ArrayList();

    /* JADX INFO: renamed from: z.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0482a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f22588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j.d<T> f22589b;

        boolean a(@NonNull Class<?> cls) {
            return this.f22588a.isAssignableFrom(cls);
        }

        C0482a(@NonNull Class<T> cls, @NonNull j.d<T> dVar) {
            this.f22588a = cls;
            this.f22589b = dVar;
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull j.d<T> dVar) {
        this.f22587a.add(new C0482a<>(cls, dVar));
    }

    @Nullable
    public synchronized <T> j.d<T> b(@NonNull Class<T> cls) {
        for (C0482a<?> c0482a : this.f22587a) {
            if (c0482a.a(cls)) {
                return (j.d<T>) c0482a.f22589b;
            }
        }
        return null;
    }
}
