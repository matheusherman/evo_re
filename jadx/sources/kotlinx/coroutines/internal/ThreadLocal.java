package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.r2;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.k0, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0016\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0015*\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/k0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/r2;", "value", "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "Lv8/j;", "context", "t", "(Lv8/j;)Ljava/lang/Object;", "oldState", "Lr8/z;", "f", "(Lv8/j;Ljava/lang/Object;)V", "Lv8/j$c;", "key", "minusKey", "(Lv8/j$c;)Lv8/j;", "Lv8/j$b;", ExifInterface.LONGITUDE_EAST, "get", "(Lv8/j$c;)Lv8/j$b;", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/Object;", "b", "Ljava/lang/ThreadLocal;", "c", "Lv8/j$c;", "getKey", "()Lv8/j$c;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadLocal<T> implements r2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final T value;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final java.lang.ThreadLocal<T> threadLocal;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final v8.j.c<?> key;

    @Override // kotlinx.coroutines.r2
    public void f(v8.j context, T oldState) {
        this.threadLocal.set(oldState);
    }

    @Override // v8.j.b
    public v8.j.c<?> getKey() {
        return this.key;
    }

    @Override // kotlinx.coroutines.r2
    public T t(v8.j context) {
        T t10 = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return t10;
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    public ThreadLocal(T t10, java.lang.ThreadLocal<T> threadLocal) {
        this.value = t10;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // v8.j
    public <R> R fold(R r10, c9.p<? super R, ? super v8.j.b, ? extends R> pVar) {
        return (R) r2.a.a(this, r10, pVar);
    }

    @Override // v8.j.b, v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> key) {
        if (kotlin.jvm.internal.m.a(getKey(), key)) {
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
            return this;
        }
        return null;
    }

    @Override // v8.j
    public v8.j minusKey(v8.j.c<?> key) {
        if (kotlin.jvm.internal.m.a(getKey(), key)) {
            return v8.k.f19724a;
        }
        return this;
    }

    @Override // v8.j
    public v8.j plus(v8.j jVar) {
        return r2.a.b(this, jVar);
    }
}
