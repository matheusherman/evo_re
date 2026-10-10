package z;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import e0.j;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import l.i;
import l.t;
import x.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final t<?, ?, ?> f22591c = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap<j, t<?, ?, ?>> f22592a = new ArrayMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<j> f22593b = new AtomicReference<>();

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j andSet = this.f22593b.getAndSet(null);
        if (andSet == null) {
            andSet = new j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(@Nullable t<?, ?, ?> tVar) {
        return f22591c.equals(tVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable t<?, ?, ?> tVar) {
        synchronized (this.f22592a) {
            ArrayMap<j, t<?, ?, ?>> arrayMap = this.f22592a;
            j jVar = new j(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f22591c;
            }
            arrayMap.put(jVar, tVar);
        }
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        j jVarB = b(cls, cls2, cls3);
        synchronized (this.f22592a) {
            tVar = (t) this.f22592a.get(jVarB);
        }
        this.f22593b.set(jVarB);
        return tVar;
    }
}
