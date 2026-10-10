package z1.b1.lb.m.user;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class BaseRequest extends a {
    private String appId;
    private int appVer;
    private String did;
    private long requestTime;

    @Keep
    public String getAppId() {
        return this.appId;
    }

    @Keep
    public int getAppVer() {
        return this.appVer;
    }

    @Keep
    public String getDid() {
        return this.did;
    }

    @Keep
    public long getRequestTime() {
        return this.requestTime;
    }

    @Keep
    public void setAppId(String str) {
        this.appId = str;
    }

    @Keep
    public void setAppVer(int i10) {
        this.appVer = i10;
    }

    @Keep
    public void setDid(String str) {
        this.did = str;
    }

    @Keep
    public void setRequestTime(long j10) {
        this.requestTime = j10;
    }
}
