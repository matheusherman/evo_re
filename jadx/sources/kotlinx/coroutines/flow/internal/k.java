package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/flow/internal/k;", "Lv8/j;", "", "e", "originalContext", "<init>", "(Ljava/lang/Throwable;Lv8/j;)V", "R", "initial", "Lkotlin/Function2;", "Lv8/j$b;", "operation", "fold", "(Ljava/lang/Object;Lc9/p;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lv8/j$c;", "key", "get", "(Lv8/j$c;)Lv8/j$b;", "minusKey", "(Lv8/j$c;)Lv8/j;", "context", "plus", "(Lv8/j;)Lv8/j;", "a", "Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class k implements v8.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Throwable e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ v8.j f14737b;

    @Override // v8.j
    public <R> R fold(R initial, c9.p<? super R, ? super v8.j.b, ? extends R> operation) {
        return (R) this.f14737b.fold(initial, operation);
    }

    @Override // v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> key) {
        return (E) this.f14737b.get(key);
    }

    @Override // v8.j
    public v8.j minusKey(v8.j.c<?> key) {
        return this.f14737b.minusKey(key);
    }

    @Override // v8.j
    public v8.j plus(v8.j context) {
        return this.f14737b.plus(context);
    }

    public k(Throwable th, v8.j jVar) {
        this.e = th;
        this.f14737b = jVar;
    }
}
