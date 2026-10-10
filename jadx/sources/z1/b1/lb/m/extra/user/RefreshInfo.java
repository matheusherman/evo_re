package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RefreshInfo extends a {
    private String accessToken;
    private Long accessTokenExpiresIn;
    private Long accountId;
    private List<AccountSubscription> accountSubscriptionList;
    private String businessType;
    private String refreshToken;
    private Long refreshTokenExpiresIn;
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
    public List<AccountSubscription> getAccountSubscriptionList() {
        return this.accountSubscriptionList;
    }

    @Keep
    public String getBusinessType() {
        return this.businessType;
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
    public String getStreamToken() {
        return this.streamToken;
    }

    @Keep
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @Keep
    public void setAccessTokenExpiresIn(Long l10) {
        this.accessTokenExpiresIn = l10;
    }

    @Keep
    public void setAccountId(Long l10) {
        this.accountId = l10;
    }

    @Keep
    public void setAccountSubscriptionList(List<AccountSubscription> list) {
        this.accountSubscriptionList = list;
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
    public void setRefreshTokenExpiresIn(Long l10) {
        this.refreshTokenExpiresIn = l10;
    }

    @Keep
    public void setStreamToken(String str) {
        this.streamToken = str;
    }
}
