package z1.b1.lb.m.local;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;
import z1.b1.lb.m.extra.user.AccountSubscription;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LocalSessionInfo extends a {
    private String accessToken;
    private Long accessTokenExpiresTS;
    private long accountId;
    private String accountName;
    private List<AccountSubscription> accountSubscriptionList;
    private String accountType;
    private String businessType;
    private String code;
    private String digitalCode;
    private String email;
    private long freeTimeMs;
    private Boolean hasPassword;
    private boolean isKickedOut;
    private boolean isLoginByUsernameFailure;
    private boolean isLogout;
    private boolean isRefreshAccessTokenFailure;
    private String kickedOutBy;
    private int kickedOutReason;
    private String lastUsername;
    private Long latestLocalLoadTime;
    private Long latestLoginResponseTime;
    private Long latestTokenUpdateTime;
    private String loginFailurePassword;
    private String loginFailureUsername;
    private String memberShipUrl;
    private String passwordDigest;
    private String phone;
    private String phoneNumber;
    private String planLeftDays;
    private String randomName;
    private String refreshToken;
    private Long refreshTokenExpiresTS;
    private List<ServerResponse> streamServers;
    private String streamToken;
    private String username;

    public LocalSessionInfo() {
        this.isRefreshAccessTokenFailure = false;
        this.isLoginByUsernameFailure = false;
        this.loginFailureUsername = "";
        this.loginFailurePassword = "";
        this.planLeftDays = "";
        this.isLogout = false;
        this.isKickedOut = false;
        this.kickedOutReason = 0;
        this.kickedOutBy = "";
    }

    @Keep
    public String getAccessToken() {
        return this.accessToken;
    }

    @Keep
    public Long getAccessTokenExpiresTS() {
        return this.accessTokenExpiresTS;
    }

    @Keep
    public long getAccountId() {
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

    @Keep
    public String getDigitalCode() {
        return this.digitalCode;
    }

    @Keep
    public String getEmail() {
        return this.email;
    }

    @Keep
    public long getFreeTimeMs() {
        return this.freeTimeMs;
    }

    @Keep
    public Boolean getHasPassword() {
        return this.hasPassword;
    }

    @Keep
    public String getKickedOutBy() {
        return this.kickedOutBy;
    }

    @Keep
    public int getKickedOutReason() {
        return this.kickedOutReason;
    }

    @Keep
    public String getLastUsername() {
        return this.lastUsername;
    }

    @Keep
    public Long getLatestLocalLoadTime() {
        return this.latestLocalLoadTime;
    }

    @Keep
    public Long getLatestLoginResponseTime() {
        return this.latestLoginResponseTime;
    }

    @Keep
    public Long getLatestTokenUpdateTime() {
        return this.latestTokenUpdateTime;
    }

    @Keep
    public String getLoginFailurePassword() {
        return this.loginFailurePassword;
    }

    @Keep
    public String getLoginFailureUsername() {
        return this.loginFailureUsername;
    }

    @Keep
    public String getMemberShipUrl() {
        return this.memberShipUrl;
    }

    @Keep
    public String getPasswordDigest() {
        return this.passwordDigest;
    }

    @Keep
    public String getPhone() {
        return this.phone;
    }

    @Keep
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Keep
    public String getPlanLeftDays() {
        return this.planLeftDays;
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
    public Long getRefreshTokenExpiresTS() {
        return this.refreshTokenExpiresTS;
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
    public String getUsername() {
        return this.username;
    }

    @Keep
    public boolean isKickedOut() {
        return this.isKickedOut;
    }

    @Keep
    public boolean isLoginByUsernameFailure() {
        return this.isLoginByUsernameFailure;
    }

    @Keep
    public boolean isLogout() {
        return this.isLogout;
    }

    @Keep
    public boolean isRefreshAccessTokenFailure() {
        return this.isRefreshAccessTokenFailure;
    }

    @Keep
    public boolean isTriedLoginByUsernameFailure() {
        return this.isLoginByUsernameFailure;
    }

    @Keep
    public boolean isTriedRefreshAccessTokenFailure() {
        return this.isRefreshAccessTokenFailure;
    }

    @Keep
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @Keep
    public void setAccessTokenExpiresTS(Long l10) {
        this.accessTokenExpiresTS = l10;
    }

    @Keep
    public void setAccountId(long j10) {
        this.accountId = j10;
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
    public void setDigitalCode(String str) {
        this.digitalCode = str;
    }

    @Keep
    public void setEmail(String str) {
        this.email = str;
    }

    @Keep
    public void setFreeTimeMs(long j10) {
        this.freeTimeMs = j10;
    }

    @Keep
    public void setHasPassword(Boolean bool) {
        this.hasPassword = bool;
    }

    @Keep
    public void setKickedOut(boolean z10) {
        this.isKickedOut = z10;
    }

    @Keep
    public void setKickedOutBy(String str) {
        this.kickedOutBy = str;
    }

    @Keep
    public void setKickedOutReason(int i10) {
        this.kickedOutReason = i10;
    }

    @Keep
    public void setLastUsername(String str) {
        this.lastUsername = str;
    }

    @Keep
    public void setLatestLocalLoadTime(Long l10) {
        this.latestLocalLoadTime = l10;
    }

    @Keep
    public void setLatestLoginResponseTime(Long l10) {
        this.latestLoginResponseTime = l10;
    }

    @Keep
    public void setLatestTokenUpdateTime(Long l10) {
        this.latestTokenUpdateTime = l10;
    }

    @Keep
    public void setLoginByUsernameFailure(boolean z10) {
        this.isLoginByUsernameFailure = z10;
    }

    @Keep
    public void setLoginFailurePassword(String str) {
        this.loginFailurePassword = str;
    }

    @Keep
    public void setLoginFailureUsername(String str) {
        this.loginFailureUsername = str;
    }

    @Keep
    public void setLogout(boolean z10) {
        this.isLogout = z10;
    }

    @Keep
    public void setMemberShipUrl(String str) {
        this.memberShipUrl = str;
    }

    @Keep
    public void setPasswordDigest(String str) {
        this.passwordDigest = str;
    }

    @Keep
    public void setPhone(String str) {
        this.phone = str;
    }

    @Keep
    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @Keep
    public void setPlanLeftDays(String str) {
        this.planLeftDays = str;
    }

    @Keep
    public void setRandomName(String str) {
        this.randomName = str;
    }

    @Keep
    public void setRefreshAccessTokenFailure(boolean z10) {
        this.isRefreshAccessTokenFailure = z10;
    }

    @Keep
    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    @Keep
    public void setRefreshTokenExpiresTS(Long l10) {
        this.refreshTokenExpiresTS = l10;
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
    public void setTriedLoginByUsernameFailure(boolean z10) {
        this.isLoginByUsernameFailure = z10;
    }

    @Keep
    public void setTriedRefreshAccessTokenFailure(boolean z10) {
        this.isRefreshAccessTokenFailure = z10;
    }

    @Keep
    public void setUsername(String str) {
        this.username = str;
    }

    public LocalSessionInfo(LocalSessionInfo localSessionInfo) {
        this.isRefreshAccessTokenFailure = false;
        this.isLoginByUsernameFailure = false;
        this.loginFailureUsername = "";
        this.loginFailurePassword = "";
        this.planLeftDays = "";
        this.isLogout = false;
        this.isKickedOut = false;
        this.kickedOutReason = 0;
        this.kickedOutBy = "";
        if (localSessionInfo == null) {
            return;
        }
        this.accountId = localSessionInfo.accountId;
        this.accountName = localSessionInfo.accountName;
        this.accountType = localSessionInfo.accountType;
        this.businessType = localSessionInfo.businessType;
        this.username = localSessionInfo.username;
        this.lastUsername = localSessionInfo.lastUsername;
        this.phoneNumber = localSessionInfo.phoneNumber;
        this.digitalCode = localSessionInfo.digitalCode;
        this.phone = localSessionInfo.phone;
        this.email = localSessionInfo.email;
        this.code = localSessionInfo.code;
        this.passwordDigest = localSessionInfo.passwordDigest;
        this.randomName = localSessionInfo.randomName;
        this.freeTimeMs = localSessionInfo.freeTimeMs;
        this.accessToken = localSessionInfo.accessToken;
        this.streamToken = localSessionInfo.streamToken;
        this.refreshToken = localSessionInfo.refreshToken;
        this.streamServers = localSessionInfo.streamServers;
        this.accountSubscriptionList = localSessionInfo.accountSubscriptionList;
        this.accessTokenExpiresTS = localSessionInfo.accessTokenExpiresTS;
        this.refreshTokenExpiresTS = localSessionInfo.refreshTokenExpiresTS;
        this.isRefreshAccessTokenFailure = localSessionInfo.isRefreshAccessTokenFailure;
        this.isLoginByUsernameFailure = localSessionInfo.isLoginByUsernameFailure;
        this.loginFailureUsername = localSessionInfo.loginFailureUsername;
        this.loginFailurePassword = localSessionInfo.loginFailurePassword;
        this.memberShipUrl = localSessionInfo.memberShipUrl;
        this.hasPassword = localSessionInfo.hasPassword;
        this.isLogout = localSessionInfo.isLogout;
        this.isKickedOut = localSessionInfo.isKickedOut;
        this.kickedOutReason = localSessionInfo.kickedOutReason;
        this.latestLoginResponseTime = localSessionInfo.latestLoginResponseTime;
        this.latestLocalLoadTime = localSessionInfo.latestLocalLoadTime;
        this.latestTokenUpdateTime = localSessionInfo.latestTokenUpdateTime;
        this.kickedOutBy = localSessionInfo.kickedOutBy;
        this.planLeftDays = localSessionInfo.planLeftDays;
    }
}
