package com.koushikdutta.async;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    InetSocketAddress f5020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f5021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SelectionKey f5022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f5023d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    u4.a f5025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f5026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    o4.e f5027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    o4.b f5028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    o4.a f5029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f5030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Exception f5031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private o4.a f5032m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l f5024e = new l();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5033n = false;

    /* JADX INFO: renamed from: com.koushikdutta.async.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class RunnableC0059a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f5034a;

        RunnableC0059a(l lVar) {
            this.f5034a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n(this.f5034a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.pause();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    @Override // com.koushikdutta.async.n
    public String h() {
        return null;
    }

    private void D() {
        if (this.f5024e.p()) {
            y.a(this, this.f5024e);
        }
    }

    private void o() {
        this.f5022c.cancel();
        try {
            this.f5021b.close();
        } catch (IOException unused) {
        }
    }

    private void v(int i10) throws IOException {
        if (!this.f5022c.isValid()) {
            throw new IOException(new CancelledKeyException());
        }
        if (i10 > 0) {
            SelectionKey selectionKey = this.f5022c;
            selectionKey.interestOps(selectionKey.interestOps() | 4);
        } else {
            SelectionKey selectionKey2 = this.f5022c;
            selectionKey2.interestOps(selectionKey2.interestOps() & (-5));
        }
    }

    void A(Exception exc) {
        if (this.f5030k) {
            return;
        }
        this.f5030k = true;
        o4.a aVar = this.f5032m;
        if (aVar != null) {
            aVar.c(exc);
        } else if (exc != null) {
            Log.e("NIO", "Unhandled exception", exc);
        }
    }

    void B(Exception exc) {
        if (this.f5024e.p()) {
            this.f5031l = exc;
        } else {
            A(exc);
        }
    }

    void C(f fVar, SelectionKey selectionKey) {
        this.f5023d = fVar;
        this.f5022c = selectionKey;
    }

    @Override // com.koushikdutta.async.h, com.koushikdutta.async.n, com.koushikdutta.async.p
    public f a() {
        return this.f5023d;
    }

    void c(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) {
        this.f5020a = inetSocketAddress;
        this.f5025f = new u4.a();
        this.f5021b = new w(socketChannel);
    }

    @Override // com.koushikdutta.async.n
    public void e(o4.b bVar) {
        this.f5028i = bVar;
    }

    @Override // com.koushikdutta.async.p
    public void end() {
        this.f5021b.c();
    }

    @Override // com.koushikdutta.async.n
    public void f() {
        if (this.f5023d.f() != Thread.currentThread()) {
            this.f5023d.r(new c());
            return;
        }
        if (this.f5033n) {
            this.f5033n = false;
            try {
                SelectionKey selectionKey = this.f5022c;
                selectionKey.interestOps(selectionKey.interestOps() | 1);
            } catch (Exception unused) {
            }
            D();
            if (w()) {
                return;
            }
            B(this.f5031l);
        }
    }

    @Override // com.koushikdutta.async.p
    public void i(o4.a aVar) {
        this.f5029j = aVar;
    }

    @Override // com.koushikdutta.async.n
    public void k(o4.a aVar) {
        this.f5032m = aVar;
    }

    @Override // com.koushikdutta.async.p
    public o4.e l() {
        return this.f5027h;
    }

    @Override // com.koushikdutta.async.p
    public void n(l lVar) {
        if (this.f5023d.f() != Thread.currentThread()) {
            this.f5023d.r(new RunnableC0059a(lVar));
            return;
        }
        if (this.f5021b.b()) {
            try {
                int iA = lVar.A();
                ByteBuffer[] byteBufferArrJ = lVar.j();
                this.f5021b.d(byteBufferArrJ);
                lVar.b(byteBufferArrJ);
                v(lVar.A());
                this.f5023d.m(iA - lVar.A());
            } catch (IOException e10) {
                o();
                B(e10);
                z(e10);
            }
        }
    }

    @Override // com.koushikdutta.async.p
    public void p(o4.e eVar) {
        this.f5027h = eVar;
    }

    @Override // com.koushikdutta.async.n
    public void pause() {
        if (this.f5023d.f() != Thread.currentThread()) {
            this.f5023d.r(new b());
        } else {
            if (this.f5033n) {
                return;
            }
            this.f5033n = true;
            try {
                SelectionKey selectionKey = this.f5022c;
                selectionKey.interestOps(selectionKey.interestOps() & (-2));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.koushikdutta.async.n
    public boolean t() {
        return this.f5033n;
    }

    @Override // com.koushikdutta.async.n
    public o4.b u() {
        return this.f5028i;
    }

    public boolean w() {
        return this.f5021b.b() && this.f5022c.isValid();
    }

    public void x() {
        if (!this.f5021b.a()) {
            SelectionKey selectionKey = this.f5022c;
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        o4.e eVar = this.f5027h;
        if (eVar != null) {
            eVar.a();
        }
    }

    protected void z(Exception exc) {
        if (this.f5026g) {
            return;
        }
        this.f5026g = true;
        o4.a aVar = this.f5029j;
        if (aVar != null) {
            aVar.c(exc);
            this.f5029j = null;
        }
    }

    a() {
    }

    @Override // com.koushikdutta.async.n
    public void close() {
        o();
        z(null);
    }

    int y() {
        long j10;
        int i10;
        D();
        boolean z10 = false;
        if (this.f5033n) {
            return 0;
        }
        ByteBuffer byteBufferA = this.f5025f.a();
        try {
            j10 = this.f5021b.read(byteBufferA);
        } catch (Exception e10) {
            o();
            B(e10);
            z(e10);
            j10 = -1;
        }
        if (j10 < 0) {
            o();
            z10 = true;
            i10 = 0;
        } else {
            i10 = (int) (((long) 0) + j10);
        }
        if (j10 > 0) {
            this.f5025f.c(j10);
            byteBufferA.flip();
            this.f5024e.a(byteBufferA);
            y.a(this, this.f5024e);
        } else {
            l.y(byteBufferA);
        }
        if (z10) {
            B(null);
            z(null);
        }
        return i10;
    }
}
