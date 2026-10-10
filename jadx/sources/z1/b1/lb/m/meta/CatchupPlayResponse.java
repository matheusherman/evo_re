package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CatchupPlayResponse extends a {
    private String playUrl;
    private String token;
    private long validTime;

    @Keep
    public String getPlayUrl() {
        return this.playUrl;
    }

    @Keep
    public String getToken() {
        return this.token;
    }

    @Keep
    public long getValidTime() {
        return this.validTime;
    }

    @Keep
    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    @Keep
    public void setToken(String str) {
        this.token = str;
    }

    @Keep
    public void setValidTime(long j10) {
        this.validTime = j10;
    }
}
