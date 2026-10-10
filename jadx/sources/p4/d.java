package p4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements p4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p4.a f17329d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p4.a f17330e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f17331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f17332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p4.a f17333c;

    @Override // p4.a
    public boolean cancel() {
        synchronized (this) {
            try {
                if (this.f17331a) {
                    return false;
                }
                if (this.f17332b) {
                    return true;
                }
                this.f17332b = true;
                p4.a aVar = this.f17333c;
                this.f17333c = null;
                if (aVar != null) {
                    aVar.cancel();
                }
                a();
                b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f17332b) {
                    return false;
                }
                if (this.f17331a) {
                    return false;
                }
                this.f17331a = true;
                this.f17333c = null;
                c();
                b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(p4.a aVar) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f17333c = aVar;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p4.a
    public boolean isCancelled() {
        boolean z10;
        p4.a aVar;
        synchronized (this) {
            try {
                z10 = this.f17332b || ((aVar = this.f17333c) != null && aVar.isCancelled());
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends d {
        a() {
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b extends d {
        b() {
            cancel();
        }
    }

    public boolean isDone() {
        return this.f17331a;
    }

    protected void a() {
    }

    protected void b() {
    }

    protected void c() {
    }
}
