package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/f1;", "Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "g", "Ljava/lang/Thread;", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class g extends f1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Thread thread;

    @Override // kotlinx.coroutines.g1
    /* JADX INFO: renamed from: S, reason: from getter */
    protected Thread getThread() {
        return this.thread;
    }

    public g(Thread thread) {
        this.thread = thread;
    }
}
