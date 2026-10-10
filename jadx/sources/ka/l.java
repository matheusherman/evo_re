package ka;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f12209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f12210b = Thread.currentThread();

    public boolean b() {
        return this.f12210b == Thread.currentThread();
    }

    l(T t10) {
        this.f12209a = t10;
    }

    public T a() {
        if (b()) {
            return this.f12209a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }
}
