package com.koushikdutta.async;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static f f5042g = new f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ExecutorService f5043h = k("AsyncServer-worker-");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<InetAddress> f5044i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ExecutorService f5045j = k("AsyncServer-resolver-");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ThreadLocal<f> f5046k = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f5047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f5048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f5049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    PriorityQueue<h> f5051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Thread f5052f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InetAddress f5053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o4.c f5055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f5056d;

        /* JADX INFO: renamed from: com.koushikdutta.async.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0060a implements com.koushikdutta.async.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ServerSocketChannel f5058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ v f5059b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SelectionKey f5060c;

            C0060a(ServerSocketChannel serverSocketChannel, v vVar, SelectionKey selectionKey) {
                this.f5058a = serverSocketChannel;
                this.f5059b = vVar;
                this.f5060c = selectionKey;
            }

            @Override // com.koushikdutta.async.g
            public void stop() {
                u4.e.a(this.f5059b);
                try {
                    this.f5060c.cancel();
                } catch (Exception unused) {
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.koushikdutta.async.f$a$a, com.koushikdutta.async.g] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            v vVar;
            IOException e10;
            ServerSocketChannel serverSocketChannelOpen;
            try {
                serverSocketChannelOpen = ServerSocketChannel.open();
                try {
                    vVar = new v(serverSocketChannelOpen);
                    try {
                        serverSocketChannelOpen.socket().bind(this.f5053a == null ? new InetSocketAddress(this.f5054b) : new InetSocketAddress(this.f5053a, this.f5054b));
                        SelectionKey selectionKeyF = vVar.f(f.this.f5047a.a());
                        selectionKeyF.attach(this.f5055c);
                        o4.c cVar = this.f5055c;
                        g gVar = this.f5056d;
                        ?? c0060a = new C0060a(serverSocketChannelOpen, vVar, selectionKeyF);
                        gVar.f5069a = c0060a;
                        cVar.v(c0060a);
                    } catch (IOException e11) {
                        e10 = e11;
                        Log.e("NIO", "wtf", e10);
                        u4.e.a(vVar, serverSocketChannelOpen);
                        this.f5055c.c(e10);
                    }
                } catch (IOException e12) {
                    vVar = null;
                    e10 = e12;
                }
            } catch (IOException e13) {
                vVar = null;
                e10 = e13;
                serverSocketChannelOpen = null;
            }
        }

        a(InetAddress inetAddress, int i10, o4.c cVar, g gVar) {
            this.f5053a = inetAddress;
            this.f5054b = i10;
            this.f5055c = cVar;
            this.f5056d = gVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements Comparator<InetAddress> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
            boolean z10 = inetAddress instanceof Inet4Address;
            if (z10 && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                return 0;
            }
            return (z10 && (inetAddress2 instanceof Inet6Address)) ? -1 : 1;
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f5062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PriorityQueue f5063b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, u uVar, PriorityQueue priorityQueue) {
            super(str);
            this.f5062a = uVar;
            this.f5063b = priorityQueue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                f.f5046k.set(f.this);
                f.q(f.this, this.f5062a, this.f5063b);
            } finally {
                f.f5046k.remove();
            }
        }
    }

    /* JADX INFO: renamed from: com.koushikdutta.async.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class ThreadFactoryC0061f implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f5066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f5067b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5068c;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f5066a, runnable, this.f5068c + this.f5067b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

        ThreadFactoryC0061f(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f5066a = threadGroup;
            this.f5068c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        T f5069a;

        private g() {
        }

        /* synthetic */ g(com.koushikdutta.async.e eVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class h implements p4.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f5070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f5071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5073d;

        @Override // p4.a
        public boolean cancel() {
            boolean zRemove;
            synchronized (this.f5070a) {
                zRemove = this.f5070a.f5051e.remove(this);
                this.f5073d = zRemove;
            }
            return zRemove;
        }

        @Override // p4.a
        public boolean isCancelled() {
            return this.f5073d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5071b.run();
        }

        public h(f fVar, Runnable runnable, long j10) {
            this.f5070a = fVar;
            this.f5071b = runnable;
            this.f5072c = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class i implements Comparator<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static i f5074a = new i();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            long j10 = hVar.f5072c;
            long j11 = hVar2.f5072c;
            if (j10 == j11) {
                return 0;
            }
            return j10 > j11 ? 1 : -1;
        }

        private i() {
        }
    }

    public f() {
        this(null);
    }

    private void p() {
        synchronized (this) {
            try {
                u uVar = this.f5047a;
                if (uVar != null) {
                    PriorityQueue<h> priorityQueue = this.f5051e;
                    try {
                        s(this, uVar, priorityQueue);
                        return;
                    } catch (d e10) {
                        Log.i("NIO", "Selector closed", e10);
                        try {
                            uVar.a().close();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
                try {
                    u uVar2 = new u(SelectorProvider.provider().openSelector());
                    this.f5047a = uVar2;
                    c cVar = new c(this.f5048b, uVar2, this.f5051e);
                    this.f5052f = cVar;
                    cVar.start();
                } catch (IOException e11) {
                    throw new RuntimeException("unable to create selector?", e11);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(f fVar, u uVar, PriorityQueue<h> priorityQueue) {
        while (true) {
            try {
                s(fVar, uVar, priorityQueue);
            } catch (d e10) {
                if (!(e10.getCause() instanceof ClosedSelectorException)) {
                    Log.i("NIO", "Selector exception, shutting down", e10);
                }
                u4.e.a(uVar);
            }
            synchronized (fVar) {
                try {
                    if (!uVar.isOpen() || (uVar.b().size() <= 0 && priorityQueue.size() <= 0)) {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        t(uVar);
        if (fVar.f5047a == uVar) {
            fVar.f5051e = new PriorityQueue<>(1, i.f5074a);
            fVar.f5047a = null;
            fVar.f5052f = null;
        }
    }

    public p4.a o(Runnable runnable, long j10) {
        synchronized (this) {
            try {
                if (this.f5049c) {
                    return p4.d.f17330e;
                }
                long jMin = 0;
                if (j10 > 0) {
                    jMin = SystemClock.elapsedRealtime() + j10;
                } else if (j10 == 0) {
                    int i10 = this.f5050d;
                    this.f5050d = i10 + 1;
                    jMin = i10;
                } else if (this.f5051e.size() > 0) {
                    jMin = Math.min(0L, this.f5051e.peek().f5072c - 1);
                }
                PriorityQueue<h> priorityQueue = this.f5051e;
                h hVar = new h(this, runnable, jMin);
                priorityQueue.add(hVar);
                if (this.f5047a == null) {
                    p();
                }
                if (!h()) {
                    v(this.f5047a);
                }
                return hVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class d extends IOException {
        public d(Exception exc) {
            super(exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class e extends p4.j<com.koushikdutta.async.a> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        SocketChannel f5065k;

        @Override // p4.d
        protected void a() {
            super.a();
            try {
                SocketChannel socketChannel = this.f5065k;
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public f(String str) {
        this.f5050d = 0;
        this.f5051e = new PriorityQueue<>(1, i.f5074a);
        this.f5048b = str == null ? "AsyncServer" : str;
    }

    public static f g() {
        return f5042g;
    }

    private static ExecutorService k(String str) {
        return new ThreadPoolExecutor(0, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0061f(str));
    }

    private static void v(final u uVar) {
        f5043h.execute(new Runnable() { // from class: com.koushikdutta.async.d
            @Override // java.lang.Runnable
            public final void run() {
                uVar.k();
            }
        });
    }

    public Thread f() {
        return this.f5052f;
    }

    public boolean h() {
        return this.f5052f == Thread.currentThread();
    }

    public com.koushikdutta.async.g i(InetAddress inetAddress, int i10, o4.c cVar) {
        g gVar = new g(null);
        r(new a(inetAddress, i10, cVar, gVar));
        return (com.koushikdutta.async.g) gVar.f5069a;
    }

    public p4.a n(Runnable runnable) {
        return o(runnable, 0L);
    }

    public static /* synthetic */ void b(Runnable runnable, Semaphore semaphore) {
        runnable.run();
        semaphore.release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [o4.c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.koushikdutta.async.a, com.koushikdutta.async.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.koushikdutta.async.a, java.lang.Object] */
    private static void s(f fVar, u uVar, PriorityQueue<h> priorityQueue) throws d {
        boolean z10;
        ?? r10;
        long j10 = j(fVar, priorityQueue);
        try {
            synchronized (fVar) {
                try {
                    if (uVar.f() == 0) {
                        if (uVar.b().size() == 0 && j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                            return;
                        } else {
                            z10 = true;
                        }
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                            uVar.c();
                        } else {
                            uVar.d(j10);
                        }
                    }
                    Set<SelectionKey> setI = uVar.i();
                    for (SelectionKey selectionKey : setI) {
                        try {
                            SocketChannel socketChannel = null;
                            ?? Register = 0;
                            if (selectionKey.isAcceptable()) {
                                try {
                                    SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey.channel()).accept();
                                    if (socketChannelAccept != null) {
                                        try {
                                            socketChannelAccept.configureBlocking(false);
                                            Register = socketChannelAccept.register(uVar.a(), 1);
                                            ?? r11 = (o4.c) selectionKey.attachment();
                                            ?? aVar = new com.koushikdutta.async.a();
                                            aVar.c(socketChannelAccept, (InetSocketAddress) socketChannelAccept.socket().getRemoteSocketAddress());
                                            aVar.C(fVar, Register);
                                            Register.attach(aVar);
                                            r11.o(aVar);
                                        } catch (IOException unused) {
                                            r10 = Register;
                                            socketChannel = socketChannelAccept;
                                            u4.e.a(socketChannel);
                                            if (r10 != 0) {
                                                r10.cancel();
                                            }
                                        }
                                    }
                                } catch (IOException unused2) {
                                    r10 = 0;
                                }
                            } else if (selectionKey.isReadable()) {
                                fVar.l(((com.koushikdutta.async.a) selectionKey.attachment()).y());
                            } else if (selectionKey.isWritable()) {
                                ((com.koushikdutta.async.a) selectionKey.attachment()).x();
                            } else if (selectionKey.isConnectable()) {
                                e eVar = (e) selectionKey.attachment();
                                SocketChannel socketChannel2 = (SocketChannel) selectionKey.channel();
                                selectionKey.interestOps(1);
                                try {
                                    socketChannel2.finishConnect();
                                    ?? aVar2 = new com.koushikdutta.async.a();
                                    aVar2.C(fVar, selectionKey);
                                    aVar2.c(socketChannel2, (InetSocketAddress) socketChannel2.socket().getRemoteSocketAddress());
                                    selectionKey.attach(aVar2);
                                    if (eVar.w(aVar2)) {
                                        throw null;
                                    }
                                } catch (IOException e10) {
                                    selectionKey.cancel();
                                    u4.e.a(socketChannel2);
                                    if (eVar.u(e10)) {
                                        throw null;
                                    }
                                }
                            } else {
                                Log.i("NIO", "wtf");
                                throw new RuntimeException("Unknown key state.");
                            }
                        } catch (CancelledKeyException unused3) {
                        }
                    }
                    setI.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e11) {
            throw new d(e11);
        }
    }

    private static void t(u uVar) {
        u(uVar);
        u4.e.a(uVar);
    }

    private static void u(u uVar) {
        try {
            for (SelectionKey selectionKey : uVar.b()) {
                u4.e.a(selectionKey.channel());
                try {
                    selectionKey.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void r(final Runnable runnable) {
        if (Thread.currentThread() == this.f5052f) {
            n(runnable);
            j(this, this.f5051e);
            return;
        }
        synchronized (this) {
            try {
                if (this.f5049c) {
                    return;
                }
                final Semaphore semaphore = new Semaphore(0);
                n(new Runnable() { // from class: com.koushikdutta.async.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.b(runnable, semaphore);
                    }
                });
                try {
                    semaphore.acquire();
                } catch (InterruptedException e10) {
                    Log.e("NIO", "run", e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long j(f fVar, PriorityQueue<h> priorityQueue) {
        h hVar;
        long j10 = LocationRequestCompat.PASSIVE_INTERVAL;
        while (true) {
            synchronized (fVar) {
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    hVar = null;
                    if (priorityQueue.size() > 0) {
                        h hVarRemove = priorityQueue.remove();
                        long j11 = hVarRemove.f5072c;
                        if (j11 <= jElapsedRealtime) {
                            hVar = hVarRemove;
                        } else {
                            priorityQueue.add(hVarRemove);
                            j10 = j11 - jElapsedRealtime;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (hVar == null) {
                fVar.f5050d = 0;
                return j10;
            }
            hVar.run();
        }
    }

    protected void l(int i10) {
    }

    protected void m(int i10) {
    }
}
