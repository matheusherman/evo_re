package v8;

import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lv8/a;", "Lv8/j$b;", "Lv8/j$c;", "key", "<init>", "(Lv8/j$c;)V", "Lv8/j$c;", "getKey", "()Lv8/j$c;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class a implements j.b {
    private final j.c<?> key;

    public a(j.c<?> key) {
        m.f(key, "key");
        this.key = key;
    }

    @Override // v8.j.b
    public j.c<?> getKey() {
        return this.key;
    }

    @Override // v8.j
    public <R> R fold(R r10, p<? super R, ? super j.b, ? extends R> pVar) {
        return (R) j.b.a.a(this, r10, pVar);
    }

    @Override // v8.j.b, v8.j
    public <E extends j.b> E get(j.c<E> cVar) {
        return (E) j.b.a.b(this, cVar);
    }

    @Override // v8.j
    public j minusKey(j.c<?> cVar) {
        return j.b.a.c(this, cVar);
    }

    @Override // v8.j
    public j plus(j jVar) {
        return j.b.a.d(this, jVar);
    }
}
