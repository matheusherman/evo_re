package z1.b1.lb.m.meta;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CatchupPlayRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f22628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f22629e;

    @Keep
    public String getCatchupRoute() {
        return this.f22626b;
    }

    @Keep
    public String getCatchupStreamId() {
        return this.f22627c;
    }

    @Keep
    public long getEndTimestamp() {
        return this.f22629e;
    }

    @Keep
    public long getStartTimestamp() {
        return this.f22628d;
    }

    @Keep
    public String getStreamId() {
        return this.f22625a;
    }

    @Keep
    public void setCatchupRoute(String str) {
        this.f22626b = str;
    }

    @Keep
    public void setCatchupStreamId(String str) {
        this.f22627c = str;
    }

    @Keep
    public void setEndTimestamp(long j10) {
        this.f22629e = j10;
    }

    @Keep
    public void setStartTimestamp(long j10) {
        this.f22628d = j10;
    }

    @Keep
    public void setStreamId(String str) {
        this.f22625a = str;
    }
}
