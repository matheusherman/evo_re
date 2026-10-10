package l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15048a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f15049b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f15050c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f15051d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f15052e = new e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends j {
        @Override // l.j
        public boolean a() {
            return true;
        }

        @Override // l.j
        public boolean b() {
            return true;
        }

        @Override // l.j
        public boolean c(j.a aVar) {
            return aVar == j.a.REMOTE;
        }

        @Override // l.j
        public boolean d(boolean z10, j.a aVar, j.c cVar) {
            return (aVar == j.a.RESOURCE_DISK_CACHE || aVar == j.a.MEMORY_CACHE) ? false : true;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends j {
        @Override // l.j
        public boolean a() {
            return true;
        }

        @Override // l.j
        public boolean b() {
            return false;
        }

        @Override // l.j
        public boolean d(boolean z10, j.a aVar, j.c cVar) {
            return false;
        }

        @Override // l.j
        public boolean c(j.a aVar) {
            return (aVar == j.a.DATA_DISK_CACHE || aVar == j.a.MEMORY_CACHE) ? false : true;
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends j {
        @Override // l.j
        public boolean a() {
            return false;
        }

        @Override // l.j
        public boolean b() {
            return true;
        }

        @Override // l.j
        public boolean c(j.a aVar) {
            return false;
        }

        @Override // l.j
        public boolean d(boolean z10, j.a aVar, j.c cVar) {
            return (aVar == j.a.RESOURCE_DISK_CACHE || aVar == j.a.MEMORY_CACHE) ? false : true;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends j {
        @Override // l.j
        public boolean a() {
            return true;
        }

        @Override // l.j
        public boolean b() {
            return true;
        }

        @Override // l.j
        public boolean c(j.a aVar) {
            return aVar == j.a.REMOTE;
        }

        @Override // l.j
        public boolean d(boolean z10, j.a aVar, j.c cVar) {
            return ((z10 && aVar == j.a.DATA_DISK_CACHE) || aVar == j.a.LOCAL) && cVar == j.c.TRANSFORMED;
        }

        e() {
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(j.a aVar);

    public abstract boolean d(boolean z10, j.a aVar, j.c cVar);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends j {
        @Override // l.j
        public boolean a() {
            return false;
        }

        @Override // l.j
        public boolean b() {
            return false;
        }

        @Override // l.j
        public boolean c(j.a aVar) {
            return false;
        }

        @Override // l.j
        public boolean d(boolean z10, j.a aVar, j.c cVar) {
            return false;
        }

        b() {
        }
    }
}
