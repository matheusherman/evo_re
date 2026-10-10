package androidx.collection.internal;

import androidx.exifinterface.media.ExifInterface;
import c9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/internal/Lock;", "Lkotlin/Function0;", "block", "synchronized", "(Landroidx/collection/internal/Lock;Lc9/a;)Ljava/lang/Object;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockExtKt {
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <T> T m26synchronized(Lock lock, a<? extends T> block) {
        T tInvoke;
        m.f(lock, "<this>");
        m.f(block, "block");
        synchronized (lock) {
            try {
                tInvoke = block.invoke();
                l.b(1);
            } finally {
                l.b(1);
                l.a(1);
            }
        }
        return tInvoke;
    }
}
