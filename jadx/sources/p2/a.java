package p2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f17247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f17248b;

    public T a() {
        return this.f17248b;
    }

    public Class<T> b() {
        return this.f17247a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f17247a, this.f17248b);
    }
}
