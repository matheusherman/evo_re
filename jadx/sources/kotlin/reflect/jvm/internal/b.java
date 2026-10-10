package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function1;", "Ljava/lang/Class;", "compute", "Lkotlin/reflect/jvm/internal/a;", "a", "(Lc9/l;)Lkotlin/reflect/jvm/internal/a;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class b {
    static {
        Object objA;
        try {
            r8.q.Companion companion = r8.q.INSTANCE;
            objA = r8.q.a(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            r8.q.Companion companion2 = r8.q.INSTANCE;
            objA = r8.q.a(r8.r.a(th));
        }
        if (r8.q.f(objA)) {
            objA = Boolean.TRUE;
        }
        Object objA2 = r8.q.a(objA);
        Boolean bool = Boolean.FALSE;
        if (r8.q.e(objA2)) {
            objA2 = bool;
        }
        ((Boolean) objA2).getClass();
    }

    public static final <V> a<V> a(c9.l<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.m.f(compute, "compute");
        return new d(compute);
    }
}
