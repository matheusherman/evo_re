package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class GuestLoginInfo extends a {
    private String accessToken;
    private Long accessTokenExpiresIn;
    private Long accountId;
    private String accountName;
    private List<AccountSubscription> accountSubscriptionList;
    private String accountType;
    private String businessType;
    private Long freeTime;
    private String refreshToken;
    private Long refreshTokenExpiresIn;
    private List<ServerResponse> streamServers;
    private String streamToken;

    @Keep
    public String getAccessToken() {
        return this.accessToken;
    }

    @Keep
    public Long getAccessTokenExpiresIn() {
        return this.accessTokenExpiresIn;
    }

    @Keep
    public Long getAccountId() {
        return this.accountId;
    }

    @Keep
    public String getAccountName() {
        return this.accountName;
    }

    @Keep
    public List<AccountSubscription> getAccountSubscriptionList() {
        return this.accountSubscriptionList;
    }

    @Keep
    public String getAccountType() {
        return this.accountType;
    }

    @Keep
    public String getBusinessType() {
        return this.businessType;
    }

    @Keep
    public Long getFreeTime() {
        return this.freeTime;
    }

    @Keep
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Keep
    public Long getRefreshTokenExpiresIn() {
        return this.refreshTokenExpiresIn;
    }

    @Keep
    public List<ServerResponse> getStreamServers() {
        return this.streamServers;
    }

    @Keep
    public String getStreamToken() {
        return this.streamToken;
    }

    @Keep
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @Keep
    public void setAccountName(String str) {
        this.accountName = str;
    }

    @Keep
    public void setAccountSubscriptionList(List<AccountSubscription> list) {
        this.accountSubscriptionList = list;
    }

    @Keep
    public void setAccountType(String str) {
        this.accountType = str;
    }

    @Keep
    public void setBusinessType(String str) {
        this.businessType = str;
    }

    @Keep
    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    @Keep
    public void setStreamServers(List<ServerResponse> list) {
        this.streamServers = list;
    }

    @Keep
    public void setStreamToken(String str) {
        this.streamToken = str;
    }

    @Keep
    public void setAccessTokenExpiresIn(long j10) {
        this.accessTokenExpiresIn = Long.valueOf(j10);
    }

    @Keep
    public void setAccountId(long j10) {
        this.accountId = Long.valueOf(j10);
    }

    @Keep
    public void setFreeTime(long j10) {
        this.freeTime = Long.valueOf(j10);
    }

    @Keep
    public void setRefreshTokenExpiresIn(long j10) {
        this.refreshTokenExpiresIn = Long.valueOf(j10);
    }
}
