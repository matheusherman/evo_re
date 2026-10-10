package tb;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0004¨\u0006\u001e"}, d2 = {"Ltb/j;", "Ltb/a0;", "delegate", "<init>", "(Ltb/a0;)V", "j", "(Ltb/a0;)Ltb/j;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "g", "(JLjava/util/concurrent/TimeUnit;)Ltb/a0;", "", "e", "()Z", "c", "()J", "deadlineNanoTime", "d", "(J)Ltb/a0;", "b", "()Ltb/a0;", "a", "Lr8/z;", "f", "()V", "Ltb/a0;", "i", "setDelegate", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class j extends a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a0 delegate;

    public j(a0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // tb.a0
    public a0 a() {
        return this.delegate.a();
    }

    @Override // tb.a0
    public a0 b() {
        return this.delegate.b();
    }

    @Override // tb.a0
    public long c() {
        return this.delegate.c();
    }

    @Override // tb.a0
    public a0 d(long deadlineNanoTime) {
        return this.delegate.d(deadlineNanoTime);
    }

    @Override // tb.a0
    /* JADX INFO: renamed from: e */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    @Override // tb.a0
    public void f() throws InterruptedIOException {
        this.delegate.f();
    }

    @Override // tb.a0
    public a0 g(long timeout, TimeUnit unit) {
        kotlin.jvm.internal.m.f(unit, "unit");
        return this.delegate.g(timeout, unit);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final a0 getDelegate() {
        return this.delegate;
    }

    public final j j(a0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }
}
