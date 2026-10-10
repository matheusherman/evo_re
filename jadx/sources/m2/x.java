package m2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x<T> implements r2.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15583c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f15584a = f15583c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile r2.b<T> f15585b;

    @Override // r2.b
    public T get() {
        T t10;
        T t11 = (T) this.f15584a;
        Object obj = f15583c;
        if (t11 != obj) {
            return t11;
        }
        synchronized (this) {
            try {
                t10 = (T) this.f15584a;
                if (t10 == obj) {
                    t10 = this.f15585b.get();
                    this.f15584a = t10;
                    this.f15585b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    public x(r2.b<T> bVar) {
        this.f15585b = bVar;
    }
}
