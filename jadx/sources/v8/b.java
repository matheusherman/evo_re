package v8;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import v8.j.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0014"}, d2 = {"Lv8/b;", "Lv8/j$b;", "B", ExifInterface.LONGITUDE_EAST, "Lv8/j$c;", "baseKey", "Lkotlin/Function1;", "safeCast", "<init>", "(Lv8/j$c;Lc9/l;)V", "element", "b", "(Lv8/j$b;)Lv8/j$b;", "key", "", "a", "(Lv8/j$c;)Z", "Lc9/l;", "Lv8/j$c;", "topmostKey", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class b<B extends j.b, E extends B> implements j.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final l<j.b, E> safeCast;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final j.c<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [v8.j$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [c9.l<? super v8.j$b, ? extends E extends B>, c9.l<v8.j$b, E extends B>, java.lang.Object] */
    public b(j.c<B> baseKey, l<? super j.b, ? extends E> safeCast) {
        m.f(baseKey, "baseKey");
        m.f(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof b ? (j.c<B>) ((b) baseKey).topmostKey : baseKey;
    }

    public final boolean a(j.c<?> key) {
        m.f(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lv8/j$b;)TE; */
    public final j.b b(j.b element) {
        m.f(element, "element");
        return (j.b) this.safeCast.invoke(element);
    }
}
