package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/lang/Class;", "Lp9/k;", "a", "(Ljava/lang/Class;)Lp9/k;", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/o0;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/ConcurrentMap;", "moduleByClassLoader", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<o0, WeakReference<p9.k>> f12427a = new ConcurrentHashMap();

    public static final p9.k a(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        ClassLoader classLoaderE = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.e(cls);
        o0 o0Var = new o0(classLoaderE);
        ConcurrentMap<o0, WeakReference<p9.k>> concurrentMap = f12427a;
        WeakReference<p9.k> weakReference = concurrentMap.get(o0Var);
        if (weakReference != null) {
            p9.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(o0Var, weakReference);
        }
        p9.k kVarA = p9.k.f17447c.a(classLoaderE);
        while (true) {
            try {
                ConcurrentMap<o0, WeakReference<p9.k>> concurrentMap2 = f12427a;
                WeakReference<p9.k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(o0Var, new WeakReference<>(kVarA));
                if (weakReferencePutIfAbsent == null) {
                    o0Var.a(null);
                    return kVarA;
                }
                p9.k kVar2 = weakReferencePutIfAbsent.get();
                if (kVar2 != null) {
                    o0Var.a(null);
                    return kVar2;
                }
                concurrentMap2.remove(o0Var, weakReferencePutIfAbsent);
            } catch (Throwable th) {
                o0Var.a(null);
                throw th;
            }
        }
    }
}
