package x1.f1.lb.media;

import java.lang.reflect.Type;
import kotlin.Metadata;
import r8.z;
import x1.f1.lb.media.model.SubscribeItem;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015¨\u0006\u0017"}, d2 = {"Lx1/f1/lb/media/k;", "", "<init>", "()V", "", "cacheDirectory", "", "appVersion", "", "maxSize", "Lr8/z;", "b", "(Ljava/lang/String;IJ)V", "key", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", "c", "(Ljava/lang/String;Lx1/f1/lb/media/model/SubscribeItem;Lv8/f;)Ljava/lang/Object;", "a", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lx1/f1/lb/cache/a;", "Lx1/f1/lb/cache/a;", "cache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f20860a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<SubscribeItem> cache;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/k$a", "Lf3/a;", "Lx1/f1/lb/media/model/SubscribeItem;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends f3.a<SubscribeItem> {
        a() {
        }
    }

    public final Object a(String str, v8.f<? super SubscribeItem> fVar) {
        x1.f1.lb.cache.a<SubscribeItem> aVar = cache;
        if (aVar != null) {
            return aVar.c(str, fVar);
        }
        return null;
    }

    public final void b(String cacheDirectory, int appVersion, long maxSize) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        Type typeD = new a().d();
        kotlin.jvm.internal.m.e(typeD, "getType(...)");
        cache = new x1.f1.lb.cache.a<>(cacheDirectory, typeD, appVersion, maxSize, 0, 16, null);
    }

    public final Object c(String str, SubscribeItem subscribeItem, v8.f<? super z> fVar) {
        x1.f1.lb.cache.a<SubscribeItem> aVar = cache;
        if (aVar == null) {
            return z.f17874a;
        }
        Object objF = aVar.f(str, subscribeItem, fVar);
        return objF == kotlin.coroutines.intrinsics.b.c() ? objF : z.f17874a;
    }

    private k() {
    }
}
