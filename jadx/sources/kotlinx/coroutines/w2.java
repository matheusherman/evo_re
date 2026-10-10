package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/w2;", "Lv8/j$b;", "Lv8/j$c;", "<init>", "()V", "getKey", "()Lv8/j$c;", "key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class w2 implements v8.j.b, v8.j.c<w2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2 f14945a = new w2();

    private w2() {
    }

    @Override // v8.j
    public <R> R fold(R r10, c9.p<? super R, ? super v8.j.b, ? extends R> pVar) {
        return (R) v8.j.b.a.a(this, r10, pVar);
    }

    @Override // v8.j.b, v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> cVar) {
        return (E) v8.j.b.a.b(this, cVar);
    }

    @Override // v8.j
    public v8.j minusKey(v8.j.c<?> cVar) {
        return v8.j.b.a.c(this, cVar);
    }

    @Override // v8.j
    public v8.j plus(v8.j jVar) {
        return v8.j.b.a.d(this, jVar);
    }

    @Override // v8.j.b
    public v8.j.c<?> getKey() {
        return this;
    }
}
