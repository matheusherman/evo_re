package tb;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, d2 = {"Ltb/i;", "Ltb/z;", "delegate", "<init>", "(Ltb/z;)V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "Ltb/a0;", "g", "()Ltb/a0;", "Lr8/z;", "close", "()V", "", "toString", "()Ljava/lang/String;", "a", "Ltb/z;", "()Ltb/z;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class i implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z delegate;

    public i(z delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // tb.z
    public long D(d sink, long byteCount) {
        kotlin.jvm.internal.m.f(sink, "sink");
        return this.delegate.D(sink, byteCount);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final z getDelegate() {
        return this.delegate;
    }

    @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // tb.z
    public a0 g() {
        return this.delegate.g();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
