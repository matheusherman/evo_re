package androidx.collection.internal;

import androidx.exifinterface.media.ExifInterface;
import c9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Landroidx/collection/internal/Lock;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "synchronizedImpl", "(Lc9/a;)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Lock {
    public final <T> T synchronizedImpl(a<? extends T> block) {
        T tInvoke;
        m.f(block, "block");
        synchronized (this) {
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
