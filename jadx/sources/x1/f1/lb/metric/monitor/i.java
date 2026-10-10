package x1.f1.lb.metric.monitor;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\r"}, d2 = {"Lx1/f1/lb/metric/monitor/i;", "", "<init>", "()V", "Ltf/g;", "a", "()Ltf/g;", "c", "Lvf/e;", "b", "()Lvf/e;", "Ltf/g;", "upgradeStat", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f20958a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static tf.g upgradeStat;

    public final tf.g a() {
        tf.g gVar = new tf.g();
        upgradeStat = gVar;
        return gVar;
    }

    public final vf.e b() {
        tf.g gVar = upgradeStat;
        if (gVar == null) {
            return null;
        }
        return new vf.e(gVar.c(), gVar.f() - gVar.c(), gVar.g(), gVar.a() - gVar.f(), gVar.b(), gVar.d(), gVar.e());
    }

    public final tf.g c() {
        return upgradeStat;
    }

    private i() {
    }
}
