package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/g1;", "Lkotlinx/coroutines/e1;", "<init>", "()V", "Lr8/z;", "Z", "", "now", "Lkotlinx/coroutines/f1$b;", "delayedTask", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(JLkotlinx/coroutines/f1$b;)V", "Ljava/lang/Thread;", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Thread;", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class g1 extends e1 {
    /* JADX INFO: renamed from: S */
    protected abstract Thread getThread();

    protected void V(long now, f1.b delayedTask) {
        q0.f14902g.o0(now, delayedTask);
    }

    protected final void Z() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            c.a();
            LockSupport.unpark(thread);
        }
    }
}
