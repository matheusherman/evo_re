package v8;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lv8/g;", "Lv8/j$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "continuation", "interceptContinuation", "(Lv8/f;)Lv8/f;", "Lr8/z;", "releaseInterceptedContinuation", "(Lv8/f;)V", "C1", "b", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface g extends j.b {

    /* JADX INFO: renamed from: C1, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f19723a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <E extends j.b> E a(g gVar, j.c<E> key) {
            m.f(key, "key");
            if (!(key instanceof b)) {
                if (g.INSTANCE != key) {
                    return null;
                }
                m.d(gVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return gVar;
            }
            b bVar = (b) key;
            if (bVar.a(gVar.getKey())) {
                E e10 = (E) bVar.b(gVar);
                if (androidx.view.k.a(e10)) {
                    return e10;
                }
            }
            return null;
        }

        public static j b(g gVar, j.c<?> key) {
            m.f(key, "key");
            if (!(key instanceof b)) {
                return g.INSTANCE == key ? k.f19724a : gVar;
            }
            b bVar = (b) key;
            return (!bVar.a(gVar.getKey()) || bVar.b(gVar) == null) ? gVar : k.f19724a;
        }
    }

    <T> f<T> interceptContinuation(f<? super T> continuation);

    void releaseInterceptedContinuation(f<?> continuation);

    /* JADX INFO: renamed from: v8.g$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lv8/g$b;", "Lv8/j$c;", "Lv8/g;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion implements j.c<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f19723a = new Companion();

        private Companion() {
        }
    }
}
