package z1.b1.lb.m.ptv.user;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.user.GuestLoginInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PTVLoginInfo extends GuestLoginInfo {
    private String planName = "";
    private long expireTime = 0;
    private String memberShipUrl = "";
    private String email = "";
    private String loginName = "";
    private String loginType = "0";
    private String remainingDays = "";

    @Keep
    public String getEmail() {
        return this.email;
    }

    @Keep
    public long getExpireTime() {
        return this.expireTime;
    }

    @Keep
    public String getLoginName() {
        return this.loginName;
    }

    @Keep
    public String getLoginType() {
        return this.loginType;
    }

    @Keep
    public String getMemberShipUrl() {
        return this.memberShipUrl;
    }

    @Keep
    public String getPlanName() {
        return this.planName;
    }

    @Keep
    public String getRemainingDays() {
        return this.remainingDays;
    }

    @Keep
    public void setEmail(String str) {
        this.email = str;
    }

    @Keep
    public void setExpireTime(long j10) {
        this.expireTime = j10;
    }

    @Keep
    public void setLoginName(String str) {
        this.loginName = str;
    }

    @Keep
    public void setLoginType(String str) {
        this.loginType = str;
    }

    @Keep
    public void setMemberShipUrl(String str) {
        this.memberShipUrl = str;
    }

    @Keep
    public void setPlanName(String str) {
        this.planName = str;
    }

    @Keep
    public void setRemainingDays(String str) {
        this.remainingDays = str;
    }
}
