package tb;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;

/* JADX INFO: renamed from: tb.r, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltb/r;", "Ltb/x;", "Ljava/io/OutputStream;", "out", "Ltb/a0;", "timeout", "<init>", "(Ljava/io/OutputStream;Ltb/a0;)V", "Ltb/d;", "source", "", "byteCount", "Lr8/z;", "N", "(Ltb/d;J)V", "flush", "()V", "close", "g", "()Ltb/a0;", "", "toString", "()Ljava/lang/String;", "a", "Ljava/io/OutputStream;", "b", "Ltb/a0;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class sink implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final OutputStream out;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a0 timeout;

    public sink(OutputStream out, a0 timeout) {
        kotlin.jvm.internal.m.f(out, "out");
        kotlin.jvm.internal.m.f(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // tb.x
    public void N(d source, long byteCount) throws IOException {
        kotlin.jvm.internal.m.f(source, "source");
        b.b(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            this.timeout.f();
            u uVar = source.head;
            kotlin.jvm.internal.m.c(uVar);
            int iMin = (int) Math.min(byteCount, uVar.limit - uVar.pos);
            this.out.write(uVar.data, uVar.pos, iMin);
            uVar.pos += iMin;
            long j10 = iMin;
            byteCount -= j10;
            source.z(source.getSize() - j10);
            if (uVar.pos == uVar.limit) {
                source.head = uVar.b();
                v.b(uVar);
            }
        }
    }

    @Override // tb.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // tb.x, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // tb.x
    /* JADX INFO: renamed from: g, reason: from getter */
    public a0 getTimeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }
}
