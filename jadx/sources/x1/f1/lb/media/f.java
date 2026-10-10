package x1.f1.lb.media;

import java.lang.reflect.Type;
import kotlin.Metadata;
import z1.b1.lb.m.meta.PlaylistResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lx1/f1/lb/media/f;", "", "<init>", "()V", "", "cacheDirectory", "", "appVersion", "", "maxSize", "Lr8/z;", "a", "(Ljava/lang/String;IJ)V", "Lx1/f1/lb/cache/a;", "Lz1/b1/lb/m/meta/PlaylistResponse;", "b", "Lx1/f1/lb/cache/a;", "cache", "c", "checksumCache", "Lkotlinx/coroutines/sync/a;", "d", "Lkotlinx/coroutines/sync/a;", "mutex", "e", "Ljava/lang/String;", "lang", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<PlaylistResponse> cache;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<String> checksumCache;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20840a = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final kotlinx.coroutines.sync.a mutex = kotlinx.coroutines.sync.c.b(false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String lang = "pt";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/f$a", "Lf3/a;", "Lz1/b1/lb/m/meta/PlaylistResponse;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends f3.a<PlaylistResponse> {
        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/f$b", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends f3.a<String> {
        b() {
        }
    }

    public final void a(String cacheDirectory, int appVersion, long maxSize) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        lang = of.a.f16585a.l();
        Type typeD = new a().d();
        kotlin.jvm.internal.m.e(typeD, "getType(...)");
        cache = new x1.f1.lb.cache.a<>(cacheDirectory, typeD, appVersion, maxSize, 0, 16, null);
        Type typeD2 = new b().d();
        kotlin.jvm.internal.m.e(typeD2, "getType(...)");
        checksumCache = new x1.f1.lb.cache.a<>(cacheDirectory, typeD2, appVersion, maxSize, 0, 16, null);
    }

    private f() {
    }
}
