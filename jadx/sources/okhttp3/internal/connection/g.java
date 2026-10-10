package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.f0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001)\u0018\u0000 /2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010#R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010-¨\u00060"}, d2 = {"Lokhttp3/internal/connection/g;", "", "Lkb/e;", "taskRunner", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lkb/e;IJLjava/util/concurrent/TimeUnit;)V", "Lokhttp3/internal/connection/f;", "connection", "now", "d", "(Lokhttp3/internal/connection/f;J)I", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/f0;", "routes", "", "requireMultiplexed", "a", "(Lokhttp3/a;Lokhttp3/internal/connection/e;Ljava/util/List;Z)Z", "Lr8/z;", "e", "(Lokhttp3/internal/connection/f;)V", "c", "(Lokhttp3/internal/connection/f;)Z", "b", "(J)J", "I", "J", "keepAliveDurationNs", "Lkb/d;", "Lkb/d;", "cleanupQueue", "okhttp3/internal/connection/g$b", "Lokhttp3/internal/connection/g$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "f", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxIdleConnections;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long keepAliveDurationNs;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final kb.d cleanupQueue;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b cleanupTask;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<f> connections;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/connection/g$b", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b extends kb.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // kb.a
        public long f() {
            return g.this.b(System.nanoTime());
        }
    }

    public g(kb.e taskRunner, int i10, long j10, TimeUnit timeUnit) {
        m.f(taskRunner, "taskRunner");
        m.f(timeUnit, "timeUnit");
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        this.cleanupQueue = taskRunner.i();
        this.cleanupTask = new b(hb.d.f10921i + " ConnectionPool");
        this.connections = new ConcurrentLinkedQueue<>();
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j10).toString());
    }

    private final int d(f connection, long now) {
        if (hb.d.f10920h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        List<Reference<e>> listO = connection.o();
        int i10 = 0;
        while (i10 < listO.size()) {
            Reference<e> reference = listO.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                m.d(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                ob.m.INSTANCE.g().l("A connection to " + connection.getRoute().getAddress().getUrl() + " was leaked. Did you forget to close a response body?", ((e.b) reference).getCallStackTrace());
                listO.remove(i10);
                connection.D(true);
                if (listO.isEmpty()) {
                    connection.C(now - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return listO.size();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0033 A[SYNTHETIC] */
    public final boolean a(okhttp3.a address, e call, List<f0> routes, boolean requireMultiplexed) {
        m.f(address, "address");
        m.f(call, "call");
        for (f connection : this.connections) {
            m.e(connection, "connection");
            synchronized (connection) {
                if (requireMultiplexed) {
                    try {
                        if (connection.w()) {
                            if (connection.u(address, routes)) {
                                call.d(connection);
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (connection.u(address, routes)) {
                    call.d(connection);
                    return true;
                }
                z zVar = z.f17874a;
            }
        }
        return false;
    }

    public final long b(long now) {
        int i10 = 0;
        long j10 = Long.MIN_VALUE;
        f fVar = null;
        int i11 = 0;
        for (f connection : this.connections) {
            m.e(connection, "connection");
            synchronized (connection) {
                if (d(connection, now) > 0) {
                    i11++;
                } else {
                    i10++;
                    long idleAtNs = now - connection.getIdleAtNs();
                    if (idleAtNs > j10) {
                        fVar = connection;
                        j10 = idleAtNs;
                    }
                    z zVar = z.f17874a;
                }
            }
        }
        long j11 = this.keepAliveDurationNs;
        if (j10 < j11 && i10 <= this.maxIdleConnections) {
            if (i10 > 0) {
                return j11 - j10;
            }
            if (i11 > 0) {
                return j11;
            }
            return -1L;
        }
        m.c(fVar);
        synchronized (fVar) {
            if (!fVar.o().isEmpty()) {
                return 0L;
            }
            if (fVar.getIdleAtNs() + j10 != now) {
                return 0L;
            }
            fVar.D(true);
            this.connections.remove(fVar);
            hb.d.n(fVar.E());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.a();
            }
            return 0L;
        }
    }

    public final boolean c(f connection) {
        m.f(connection, "connection");
        if (hb.d.f10920h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            kb.d.j(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.D(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.a();
        }
        return true;
    }

    public final void e(f connection) {
        m.f(connection, "connection");
        if (!hb.d.f10920h || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            kb.d.j(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }
}
