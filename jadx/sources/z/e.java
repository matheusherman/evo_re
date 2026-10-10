package z;

import androidx.annotation.NonNull;
import j.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f22596a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f22597b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f22598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f22599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final k<T, R> f22600c;

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f22598a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f22599b);
        }

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, k<T, R> kVar) {
            this.f22598a = cls;
            this.f22599b = cls2;
            this.f22600c = kVar;
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> arrayList;
        try {
            if (!this.f22596a.contains(str)) {
                this.f22596a.add(str);
            }
            arrayList = this.f22597b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f22597b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull k<T, R> kVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, kVar));
    }

    @NonNull
    public synchronized <T, R> List<k<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f22596a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f22597b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f22600c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f22596a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f22597b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f22599b)) {
                        arrayList.add(aVar.f22599b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(@NonNull List<String> list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f22596a);
            this.f22596a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f22596a.add(it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f22596a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
