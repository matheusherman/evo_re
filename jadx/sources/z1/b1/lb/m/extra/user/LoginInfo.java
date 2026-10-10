package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LoginInfo extends a {
    private String accessToken;
    private Long accessTokenExpiresIn;
    private Long accountId;
    private String accountName;
    private List<AccountSubscription> accountSubscriptionList;
    private String accountType;
    private String businessType;
    private String code;
    private String digitalCode;
    private String email;
    private Long freeTime;
    private Boolean hasPassword;
    private String phone;
    private String randomName;
    private String refreshToken;
    private Long refreshTokenExpiresIn;

    @Keep
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
    public String getCode() {
        return this.code;
    }

    public String getDigitalCode() {
        return this.digitalCode;
    }

    @Keep
    public String getEmail() {
        return this.email;
    }

    @Keep
    public Long getFreeTime() {
        return this.freeTime;
    }

    @Keep
    public Boolean getHasPassword() {
        return this.hasPassword;
    }

    @Keep
    public String getPhone() {
        return this.phone;
    }

    @Keep
    public String getRandomName() {
        return this.randomName;
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
    public void setAccessTokenExpiresIn(Long l10) {
        this.accessTokenExpiresIn = l10;
    }

    @Keep
    public void setAccountId(Long l10) {
        this.accountId = l10;
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
    public void setCode(String str) {
        this.code = str;
    }

    @Keep
    public void setEmail(String str) {
        this.email = str;
    }

    @Keep
    public void setFreeTime(Long l10) {
        this.freeTime = l10;
    }

    @Keep
    public void setHasPassword(Boolean bool) {
        this.hasPassword = bool;
    }

    @Keep
    public void setPhone(String str) {
        this.phone = str;
    }

    @Keep
    public void setRandomName(String str) {
        this.randomName = str;
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
    public void setStreamServers(List<ServerResponse> list) {
        this.streamServers = list;
    }

    @Keep
    public void setStreamToken(String str) {
        this.streamToken = str;
    }
}
