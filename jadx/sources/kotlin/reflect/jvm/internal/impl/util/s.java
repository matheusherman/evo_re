package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class s<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f14473a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f14474b = new AtomicInteger(0);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<String, Integer> {
        final /* synthetic */ s<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(s<K, V> sVar) {
            super(1);
            this.this$0 = sVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(String it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Integer.valueOf(((s) this.this$0).f14474b.getAndIncrement());
        }
    }

    public abstract int b(ConcurrentHashMap<String, Integer> concurrentHashMap, String str, c9.l<? super String, Integer> lVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> n<K, V, T> c(i9.d<KK> kClass) {
        kotlin.jvm.internal.m.f(kClass, "kClass");
        return new n<>(kClass, d(kClass));
    }

    public final <T extends K> int d(i9.d<T> kClass) {
        kotlin.jvm.internal.m.f(kClass, "kClass");
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f14473a;
        String strB = kClass.b();
        kotlin.jvm.internal.m.c(strB);
        return b(concurrentHashMap, strB, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<Integer> e() {
        Collection<Integer> collectionValues = this.f14473a.values();
        kotlin.jvm.internal.m.e(collectionValues, "idPerType.values");
        return collectionValues;
    }
}
