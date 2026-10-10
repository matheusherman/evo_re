package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<K, V> implements Iterable<V>, d9.a {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class AbstractC0272a<K, V, T extends V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i9.d<? extends K> f14400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14401b;

        public AbstractC0272a(i9.d<? extends K> key, int i10) {
            kotlin.jvm.internal.m.f(key, "key");
            this.f14400a = key;
            this.f14401b = i10;
        }

        protected final T a(a<K, V> thisRef) {
            kotlin.jvm.internal.m.f(thisRef, "thisRef");
            return thisRef.e().get(this.f14401b);
        }
    }

    protected abstract c<V> e();

    protected abstract s<K, V> f();

    public final boolean isEmpty() {
        if (e().e() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return e().iterator();
    }
}
