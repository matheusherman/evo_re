package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\f\u0010\bR \u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0005\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/a1;", "", "<init>", "()V", "Lkotlinx/coroutines/i0;", "b", "Lkotlinx/coroutines/i0;", "a", "()Lkotlinx/coroutines/i0;", "getDefault$annotations", "Default", "c", "getUnconfined", "getUnconfined$annotations", "Unconfined", "d", "getIO$annotations", "IO", "Lkotlinx/coroutines/g2;", "()Lkotlinx/coroutines/g2;", "getMain$annotations", "Main", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f14580a = new a1();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final i0 Default = wa.c.f20429g;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final i0 Unconfined = u2.f14941a;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final i0 IO = wa.b.f20427b;

    public static final i0 a() {
        return Default;
    }

    public static final i0 b() {
        return IO;
    }

    public static final g2 c() {
        return kotlinx.coroutines.internal.u.dispatcher;
    }

    private a1() {
    }
}
