package tb;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Ltb/c;", "Ltb/a0;", "<init>", "()V", "", "now", "y", "(J)J", "Lr8/z;", "v", "", "w", "()Z", "B", "Ltb/x;", "sink", "z", "(Ltb/x;)Ltb/x;", "Ltb/z;", "source", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ltb/z;)Ltb/z;", "Ljava/io/IOException;", "cause", "p", "(Ljava/io/IOException;)Ljava/io/IOException;", "x", "f", "Z", "inQueue", "g", "Ltb/c;", "next", "h", "J", "timeoutAt", "i", "a", "b", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class c extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ReentrantLock f19028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Condition f19029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f19030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f19031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static c f19032n;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean inQueue;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private c next;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long timeoutAt;

    /* JADX INFO: renamed from: tb.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ltb/c$a;", "", "<init>", "()V", "Ltb/c;", "node", "", "timeoutNanos", "", "hasDeadline", "Lr8/z;", "g", "(Ltb/c;JZ)V", "d", "(Ltb/c;)Z", "c", "()Ltb/c;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "f", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "e", "()Ljava/util/concurrent/locks/Condition;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Ltb/c;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(c node) {
            ReentrantLock reentrantLockF = c.INSTANCE.f();
            reentrantLockF.lock();
            try {
                if (!node.inQueue) {
                    return false;
                }
                node.inQueue = false;
                for (c cVar = c.f19032n; cVar != null; cVar = cVar.next) {
                    if (cVar.next == node) {
                        cVar.next = node.next;
                        node.next = null;
                        return false;
                    }
                }
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(c node, long timeoutNanos, boolean hasDeadline) {
            ReentrantLock reentrantLockF = c.INSTANCE.f();
            reentrantLockF.lock();
            try {
                if (node.inQueue) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                node.inQueue = true;
                if (c.f19032n == null) {
                    c.f19032n = new c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (timeoutNanos != 0 && hasDeadline) {
                    node.timeoutAt = Math.min(timeoutNanos, node.c() - jNanoTime) + jNanoTime;
                } else if (timeoutNanos != 0) {
                    node.timeoutAt = timeoutNanos + jNanoTime;
                } else {
                    if (!hasDeadline) {
                        throw new AssertionError();
                    }
                    node.timeoutAt = node.c();
                }
                long jY = node.y(jNanoTime);
                c cVar = c.f19032n;
                kotlin.jvm.internal.m.c(cVar);
                while (cVar.next != null) {
                    c cVar2 = cVar.next;
                    kotlin.jvm.internal.m.c(cVar2);
                    if (jY < cVar2.y(jNanoTime)) {
                        break;
                    }
                    cVar = cVar.next;
                    kotlin.jvm.internal.m.c(cVar);
                }
                node.next = cVar.next;
                cVar.next = node;
                if (cVar == c.f19032n) {
                    c.INSTANCE.e().signal();
                }
                r8.z zVar = r8.z.f17874a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public final c c() throws InterruptedException {
            c cVar = c.f19032n;
            kotlin.jvm.internal.m.c(cVar);
            c cVar2 = cVar.next;
            if (cVar2 != null) {
                long jY = cVar2.y(System.nanoTime());
                if (jY <= 0) {
                    c cVar3 = c.f19032n;
                    kotlin.jvm.internal.m.c(cVar3);
                    cVar3.next = cVar2.next;
                    cVar2.next = null;
                    return cVar2;
                }
                e().await(jY, TimeUnit.NANOSECONDS);
                return null;
            }
            long jNanoTime = System.nanoTime();
            e().await(c.f19030l, TimeUnit.MILLISECONDS);
            c cVar4 = c.f19032n;
            kotlin.jvm.internal.m.c(cVar4);
            if (cVar4.next == null && System.nanoTime() - jNanoTime >= c.f19031m) {
                return c.f19032n;
            }
            return null;
        }

        public final Condition e() {
            return c.f19029k;
        }

        public final ReentrantLock f() {
            return c.f19028j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltb/c$b;", "Ljava/lang/Thread;", "<init>", "()V", "Lr8/z;", "run", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Companion companion = c.INSTANCE;
                    ReentrantLock reentrantLockF = companion.f();
                    reentrantLockF.lock();
                    try {
                        c cVarC = companion.c();
                        if (cVarC == c.f19032n) {
                            c.f19032n = null;
                            reentrantLockF.unlock();
                            return;
                        } else {
                            r8.z zVar = r8.z.f17874a;
                            reentrantLockF.unlock();
                            if (cVarC != null) {
                                cVarC.B();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLockF.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: tb.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"tb/c$c", "Ltb/x;", "Ltb/d;", "source", "", "byteCount", "Lr8/z;", "N", "(Ltb/d;J)V", "flush", "()V", "close", "Ltb/c;", "a", "()Ltb/c;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class C0367c implements x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f19037b;

        C0367c(x xVar) {
            this.f19037b = xVar;
        }

        @Override // tb.x
        public void N(tb.d source, long byteCount) throws IOException {
            kotlin.jvm.internal.m.f(source, "source");
            tb.b.b(source.getSize(), 0L, byteCount);
            while (true) {
                long j10 = 0;
                if (byteCount <= 0) {
                    return;
                }
                u uVar = source.head;
                kotlin.jvm.internal.m.c(uVar);
                while (j10 < 65536) {
                    j10 += (long) (uVar.limit - uVar.pos);
                    if (j10 >= byteCount) {
                        j10 = byteCount;
                        break;
                    } else {
                        uVar = uVar.next;
                        kotlin.jvm.internal.m.c(uVar);
                    }
                }
                c cVar = c.this;
                x xVar = this.f19037b;
                cVar.v();
                try {
                    try {
                        xVar.N(source, j10);
                        r8.z zVar = r8.z.f17874a;
                        if (cVar.w()) {
                            throw cVar.p(null);
                        }
                        byteCount -= j10;
                    } catch (IOException e10) {
                        if (!cVar.w()) {
                            throw e10;
                        }
                        throw cVar.p(e10);
                    }
                } catch (Throwable th) {
                    cVar.w();
                    throw th;
                }
            }
        }

        @Override // tb.x
        /* JADX INFO: renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c g() {
            return c.this;
        }

        @Override // tb.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            x xVar = this.f19037b;
            cVar.v();
            try {
                try {
                    xVar.close();
                    r8.z zVar = r8.z.f17874a;
                    if (cVar.w()) {
                        throw cVar.p(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.w()) {
                        throw e10;
                    }
                    throw cVar.p(e10);
                }
            } catch (Throwable th) {
                cVar.w();
                throw th;
            }
        }

        @Override // tb.x, java.io.Flushable
        public void flush() throws IOException {
            c cVar = c.this;
            x xVar = this.f19037b;
            cVar.v();
            try {
                try {
                    xVar.flush();
                    r8.z zVar = r8.z.f17874a;
                    if (cVar.w()) {
                        throw cVar.p(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.w()) {
                        throw e10;
                    }
                    throw cVar.p(e10);
                }
            } catch (Throwable th) {
                cVar.w();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f19037b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"tb/c$d", "Ltb/z;", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "Lr8/z;", "close", "()V", "Ltb/c;", "a", "()Ltb/c;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d implements z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f19039b;

        d(z zVar) {
            this.f19039b = zVar;
        }

        @Override // tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            kotlin.jvm.internal.m.f(sink, "sink");
            c cVar = c.this;
            z zVar = this.f19039b;
            cVar.v();
            try {
                try {
                    long jD = zVar.D(sink, byteCount);
                    if (cVar.w()) {
                        throw cVar.p(null);
                    }
                    return jD;
                } catch (IOException e10) {
                    if (cVar.w()) {
                        throw cVar.p(e10);
                    }
                    throw e10;
                }
            } catch (Throwable th) {
                cVar.w();
                throw th;
            }
        }

        @Override // tb.z
        /* JADX INFO: renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c g() {
            return c.this;
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            z zVar = this.f19039b;
            cVar.v();
            try {
                try {
                    zVar.close();
                    r8.z zVar2 = r8.z.f17874a;
                    if (cVar.w()) {
                        throw cVar.p(null);
                    }
                } catch (IOException e10) {
                    if (!cVar.w()) {
                        throw e10;
                    }
                    throw cVar.p(e10);
                }
            } catch (Throwable th) {
                cVar.w();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f19039b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f19028j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.m.e(conditionNewCondition, "newCondition(...)");
        f19029k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f19030l = millis;
        f19031m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y(long now) {
        return this.timeoutAt - now;
    }

    public final z A(z source) {
        kotlin.jvm.internal.m.f(source, "source");
        return new d(source);
    }

    public final boolean w() {
        return INSTANCE.d(this);
    }

    protected IOException x(IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final x z(x sink) {
        kotlin.jvm.internal.m.f(sink, "sink");
        return new C0367c(sink);
    }

    public final IOException p(IOException cause) {
        return x(cause);
    }

    public final void v() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            INSTANCE.g(this, timeoutNanos, hasDeadline);
        }
    }

    protected void B() {
    }
}
