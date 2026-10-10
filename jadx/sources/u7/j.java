package u7;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lu7/j;", "Lu7/a;", "", IjkMediaMeta.IJKM_KEY_SELECTED, "Lqf/a;", "data", "<init>", "(ZLqf/a;)V", "a", "Z", "b", "()Z", "(Z)V", "Lqf/a;", "c", "()Lqf/a;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final qf.a data;

    public j(boolean z10, qf.a data) {
        m.f(data, "data");
        this.selected = z10;
        this.data = data;
    }

    @Override // u7.a
    public void a(boolean z10) {
        this.selected = z10;
    }

    @Override // u7.a
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final qf.a getData() {
        return this.data;
    }
}
