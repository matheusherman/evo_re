package x1.f1.lb.widget.videoview;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\f\u0010\u000f¨\u0006\u0011"}, d2 = {"Lx1/f1/lb/widget/videoview/h;", "", "Lnf/r;", NotificationCompat.CATEGORY_EVENT, "", "subtitleMediaId", "subtitleCdnUrl", "<init>", "(Lnf/r;Ljava/lang/String;Ljava/lang/String;)V", "a", "Lnf/r;", "()Lnf/r;", "b", "Ljava/lang/String;", "getSubtitleMediaId", "()Ljava/lang/String;", "c", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final nf.r event;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String subtitleMediaId;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String subtitleCdnUrl;

    public h(nf.r event, String subtitleMediaId, String subtitleCdnUrl) {
        kotlin.jvm.internal.m.f(event, "event");
        kotlin.jvm.internal.m.f(subtitleMediaId, "subtitleMediaId");
        kotlin.jvm.internal.m.f(subtitleCdnUrl, "subtitleCdnUrl");
        this.event = event;
        this.subtitleMediaId = subtitleMediaId;
        this.subtitleCdnUrl = subtitleCdnUrl;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final nf.r getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSubtitleCdnUrl() {
        return this.subtitleCdnUrl;
    }
}
