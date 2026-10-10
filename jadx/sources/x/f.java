package x;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f20527a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<Z> f20528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f20529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e<Z, R> f20530c;

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f20528a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f20529b);
        }

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f20528a = cls;
            this.f20529b = cls2;
            this.f20530c = eVar;
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f20527a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f20530c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f20527a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f20529b)) {
                arrayList.add(aVar.f20529b);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f20527a.add(new a<>(cls, cls2, eVar));
    }
}
