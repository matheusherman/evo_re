package org.eclipse.paho.android.service;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class e implements ve.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ve.a f17109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f17110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile ve.f f17111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f17112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ve.f f17113e;

    void a() {
        synchronized (this.f17112d) {
            try {
                this.f17110b = true;
                this.f17112d.notifyAll();
                ve.a aVar = this.f17109a;
                if (aVar != null) {
                    aVar.a(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void b(Throwable th) {
        synchronized (this.f17112d) {
            try {
                this.f17110b = true;
                if (th instanceof ve.f) {
                    this.f17113e = (ve.f) th;
                } else {
                    this.f17113e = new ve.f(th);
                }
                this.f17112d.notifyAll();
                if (th instanceof ve.f) {
                    this.f17111c = (ve.f) th;
                }
                ve.a aVar = this.f17109a;
                if (aVar != null) {
                    aVar.b(this, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
