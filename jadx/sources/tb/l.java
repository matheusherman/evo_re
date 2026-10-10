package tb;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Ltb/l;", "Ltb/z;", "Ltb/f;", "source", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Ltb/f;Ljava/util/zip/Inflater;)V", "Lr8/z;", "c", "()V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "a", "", "b", "()Z", "Ltb/a0;", "g", "()Ltb/a0;", "close", "Ltb/f;", "Ljava/util/zip/Inflater;", "", "I", "bufferBytesHeldByInflater", "d", "Z", "closed", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class l implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f source;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Inflater inflater;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int bufferBytesHeldByInflater;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean closed;

    public l(f source, Inflater inflater) {
        kotlin.jvm.internal.m.f(source, "source");
        kotlin.jvm.internal.m.f(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    private final void c() {
        int i10 = this.bufferBytesHeldByInflater;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // tb.z
    public long D(d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.m.f(sink, "sink");
        do {
            long jA = a(sink, byteCount);
            if (jA > 0) {
                return jA;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.L());
        throw new EOFException("source exhausted prematurely");
    }

    public final long a(d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.m.f(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (byteCount == 0) {
            return 0L;
        }
        try {
            u uVarF = sink.F(1);
            int iMin = (int) Math.min(byteCount, 8192 - uVarF.limit);
            b();
            int iInflate = this.inflater.inflate(uVarF.data, uVarF.limit, iMin);
            c();
            if (iInflate > 0) {
                uVarF.limit += iInflate;
                long j10 = iInflate;
                sink.z(sink.getSize() + j10);
                return j10;
            }
            if (uVarF.pos == uVarF.limit) {
                sink.head = uVarF.b();
                v.b(uVarF);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    public final boolean b() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.L()) {
            return true;
        }
        u uVar = this.source.getBufferField().head;
        kotlin.jvm.internal.m.c(uVar);
        int i10 = uVar.limit;
        int i11 = uVar.pos;
        int i12 = i10 - i11;
        this.bufferBytesHeldByInflater = i12;
        this.inflater.setInput(uVar.data, i11, i12);
        return false;
    }

    @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // tb.z
    /* JADX INFO: renamed from: g */
    public a0 getTimeout() {
        return this.source.getTimeout();
    }
}
