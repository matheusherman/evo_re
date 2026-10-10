package x1.f1.lb.user;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import org.apache.log4j.helpers.FileWatchdog;
import tf.AccountInfo;
import ua.n;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.k;
import x1.f1.lb.util.z;
import z1.b1.lb.m.extra.subscription.RechargeInfo;
import z1.b1.lb.m.extra.user.AccountSubscription;
import z1.b1.lb.m.extra.user.GuestLoginInfo;
import z1.b1.lb.m.extra.user.LoginInfo;
import z1.b1.lb.m.extra.user.RefreshInfo;
import z1.b1.lb.m.extra.user.RegisterInfo;
import z1.b1.lb.m.local.LocalSessionInfo;
import z1.b1.lb.m.ptv.user.PTVLoginInfo;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020#¢\u0006\u0004\b$\u0010%R\u001c\u0010)\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010(¨\u0006*"}, d2 = {"Lx1/f1/lb/user/g;", "", "<init>", "()V", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "data", "", "Lz1/b1/lb/m/extra/user/AccountSubscription;", "a", "(Lz1/b1/lb/m/ptv/user/PTVLoginInfo;)Ljava/util/List;", "Lx1/f1/lb/user/e;", "sessionWrapper", "Lz1/b1/lb/m/local/LocalSessionInfo;", "d", "(Lx1/f1/lb/user/e;)Lz1/b1/lb/m/local/LocalSessionInfo;", "Lz1/b1/lb/m/extra/user/GuestLoginInfo;", "f", "(Lz1/b1/lb/m/extra/user/GuestLoginInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "", "username", "passwordDigit", "Lz1/b1/lb/m/extra/user/LoginInfo;", "c", "(Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/extra/user/LoginInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "h", "(Lz1/b1/lb/m/extra/user/LoginInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "contact", "digitalCode", "passwordDigest", "Lz1/b1/lb/m/extra/user/RegisterInfo;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/extra/user/RegisterInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "Lz1/b1/lb/m/extra/user/RefreshInfo;", "g", "(Lz1/b1/lb/m/extra/user/RefreshInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "Lz1/b1/lb/m/extra/subscription/RechargeInfo;", "e", "(Lz1/b1/lb/m/extra/subscription/RechargeInfo;)Lz1/b1/lb/m/local/LocalSessionInfo;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    public final LocalSessionInfo d(e<PTVLoginInfo> sessionWrapper) {
        String loginName;
        boolean z10;
        m.f(sessionWrapper, "sessionWrapper");
        PTVLoginInfo pTVLoginInfoE = sessionWrapper.e();
        String callFrom = sessionWrapper.getCallFrom();
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            logger.debug("apiExtra from[{}] loginInfo[ {} ]", callFrom, pTVLoginInfoE);
        }
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfo = new LocalSessionInfo(fVar.p0());
        if (sessionWrapper.getIsRefreshAccessToken()) {
            Long accountId = pTVLoginInfoE.getAccountId();
            long accountId2 = localSessionInfo.getAccountId();
            if (accountId == null || accountId.longValue() != accountId2) {
                x1.f1.lb.bot.a.f20583a.l("[auth] refresh access token failure\n[" + localSessionInfo.getAccountId() + "] != [" + pTVLoginInfoE.getAccountId() + "]");
                return localSessionInfo;
            }
            String accessToken = pTVLoginInfoE.getAccessToken();
            if (accessToken == null || accessToken.length() == 0) {
                logger.error("get at[" + pTVLoginInfoE.getAccessToken() + "] from " + callFrom + " rf_at response", new Object[0]);
            } else {
                localSessionInfo.setAccessToken(pTVLoginInfoE.getAccessToken());
                Long accessTokenExpiresIn = pTVLoginInfoE.getAccessTokenExpiresIn();
                long jLongValue = accessTokenExpiresIn != null ? accessTokenExpiresIn.longValue() : 0L;
                Long accessTokenExpiresTS = localSessionInfo.getAccessTokenExpiresTS();
                if (jLongValue > (accessTokenExpiresTS != null ? accessTokenExpiresTS.longValue() : 0L)) {
                    localSessionInfo.setAccessTokenExpiresTS(pTVLoginInfoE.getAccessTokenExpiresIn());
                } else {
                    logger.warn("get at_exp_t[" + pTVLoginInfoE.getAccessTokenExpiresIn() + "] but no update from " + callFrom + " rf_at response", new Object[0]);
                }
            }
            String refreshToken = pTVLoginInfoE.getRefreshToken();
            if (refreshToken == null || refreshToken.length() == 0) {
                logger.error("get rt[" + pTVLoginInfoE.getRefreshToken() + "] from " + callFrom + " rf_at response", new Object[0]);
            } else {
                localSessionInfo.setRefreshToken(pTVLoginInfoE.getRefreshToken());
                Long refreshTokenExpiresIn = pTVLoginInfoE.getRefreshTokenExpiresIn();
                long jLongValue2 = refreshTokenExpiresIn != null ? refreshTokenExpiresIn.longValue() : 0L;
                Long refreshTokenExpiresTS = localSessionInfo.getRefreshTokenExpiresTS();
                if (jLongValue2 > (refreshTokenExpiresTS != null ? refreshTokenExpiresTS.longValue() : 0L)) {
                    localSessionInfo.setRefreshTokenExpiresTS(pTVLoginInfoE.getRefreshTokenExpiresIn());
                } else {
                    logger.warn("get rt_exp_t[" + pTVLoginInfoE.getRefreshTokenExpiresIn() + "] but no update from " + callFrom + " rf_at response", new Object[0]);
                }
            }
            String streamToken = pTVLoginInfoE.getStreamToken();
            if (streamToken == null || streamToken.length() == 0) {
                logger.error("get st[" + pTVLoginInfoE.getStreamToken() + "] from " + callFrom + " rf_at response", new Object[0]);
            } else if (m.a(localSessionInfo.getStreamToken(), pTVLoginInfoE.getStreamToken())) {
                logger.warn(" get st[" + pTVLoginInfoE.getStreamToken() + "] but no update from " + callFrom + " rf_at response", new Object[0]);
            } else {
                localSessionInfo.setStreamToken(pTVLoginInfoE.getStreamToken());
            }
            List<ServerResponse> streamServers = pTVLoginInfoE.getStreamServers();
            if (streamServers == null || streamServers.isEmpty()) {
                z10 = false;
                logger.warn("get ss[" + pTVLoginInfoE.getStreamServers() + "] from " + callFrom + " rf_at response", new Object[0]);
            } else {
                localSessionInfo.setStreamServers(pTVLoginInfoE.getStreamServers());
                z10 = false;
            }
            localSessionInfo.setLatestTokenUpdateTime(Long.valueOf(d1.d()));
            localSessionInfo.setTriedRefreshAccessTokenFailure(z10);
            fVar.y1(localSessionInfo);
            return localSessionInfo;
        }
        localSessionInfo.setLatestTokenUpdateTime(Long.valueOf(d1.d()));
        localSessionInfo.setLatestLoginResponseTime(Long.valueOf(d1.d()));
        long accountId3 = localSessionInfo.getAccountId();
        localSessionInfo.setAccountId(pTVLoginInfoE.getAccountId().longValue());
        Long accountId4 = pTVLoginInfoE.getAccountId();
        if (accountId4 != null && accountId4.longValue() == accountId3) {
            String accountName = localSessionInfo.getAccountName();
            if (accountName != null && accountName.length() != 0) {
                localSessionInfo.setAccountName(pTVLoginInfoE.getAccountName());
            }
            String passwordDigest = sessionWrapper.getPasswordDigest();
            if (passwordDigest != null && passwordDigest.length() != 0) {
                localSessionInfo.setPasswordDigest(sessionWrapper.getPasswordDigest());
            }
            String username = sessionWrapper.getUsername();
            if (username != null && username.length() != 0) {
                localSessionInfo.setUsername(sessionWrapper.getUsername());
                localSessionInfo.setLastUsername(sessionWrapper.getUsername());
            }
            String code = sessionWrapper.getCode();
            if (code != null && code.length() != 0) {
                localSessionInfo.setCode(sessionWrapper.getCode());
            }
            String email = pTVLoginInfoE.getEmail();
            if (email == null || email.length() == 0) {
                String loginName2 = pTVLoginInfoE.getLoginName();
                if (loginName2 != null && loginName2.length() != 0) {
                    localSessionInfo.setPhone(pTVLoginInfoE.getLoginName());
                }
            } else {
                localSessionInfo.setEmail(pTVLoginInfoE.getEmail());
            }
            localSessionInfo.setDigitalCode("");
            localSessionInfo.setPhoneNumber("");
        } else {
            localSessionInfo.setAccountName(pTVLoginInfoE.getAccountName());
            localSessionInfo.setPasswordDigest(sessionWrapper.getPasswordDigest());
            localSessionInfo.setUsername(sessionWrapper.getUsername());
            String username2 = sessionWrapper.getUsername();
            if (username2 != null && username2.length() != 0) {
                localSessionInfo.setLastUsername(sessionWrapper.getUsername());
            }
            localSessionInfo.setCode(sessionWrapper.getCode());
            localSessionInfo.setEmail(pTVLoginInfoE.getEmail());
            localSessionInfo.setDigitalCode("");
            localSessionInfo.setPhoneNumber("");
            String email2 = pTVLoginInfoE.getEmail();
            localSessionInfo.setPhone(((email2 != null && email2.length() != 0) || (loginName = pTVLoginInfoE.getLoginName()) == null || loginName.length() == 0) ? "" : pTVLoginInfoE.getLoginName());
        }
        String accountType = pTVLoginInfoE.getAccountType();
        if (accountType != null && accountType.length() != 0) {
            if (ac.g.c(pTVLoginInfoE.getAccountType(), "normal")) {
                localSessionInfo.setAccountType("normal");
            } else {
                localSessionInfo.setAccountType("guest");
            }
        }
        String streamToken2 = pTVLoginInfoE.getStreamToken();
        if (streamToken2 == null || streamToken2.length() == 0) {
            logger.error("get st[" + pTVLoginInfoE.getStreamToken() + " from " + callFrom + " response", new Object[0]);
        } else {
            localSessionInfo.setStreamToken(pTVLoginInfoE.getStreamToken());
        }
        String accessToken2 = pTVLoginInfoE.getAccessToken();
        if (accessToken2 == null || accessToken2.length() == 0) {
            logger.error("get at[" + pTVLoginInfoE.getAccessToken() + "] from " + callFrom + " rf_at response", new Object[0]);
        } else {
            localSessionInfo.setAccessToken(pTVLoginInfoE.getAccessToken());
            Long accessTokenExpiresIn2 = pTVLoginInfoE.getAccessTokenExpiresIn();
            long jLongValue3 = accessTokenExpiresIn2 != null ? accessTokenExpiresIn2.longValue() : 0L;
            Long accessTokenExpiresTS2 = localSessionInfo.getAccessTokenExpiresTS();
            if (jLongValue3 > (accessTokenExpiresTS2 != null ? accessTokenExpiresTS2.longValue() : 0L)) {
                localSessionInfo.setAccessTokenExpiresTS(pTVLoginInfoE.getAccessTokenExpiresIn());
            } else {
                logger.warn("get at_exp_t[" + pTVLoginInfoE.getAccessTokenExpiresIn() + "] but no update from " + callFrom + " rf_at response", new Object[0]);
            }
        }
        String refreshToken2 = pTVLoginInfoE.getRefreshToken();
        if (refreshToken2 == null || refreshToken2.length() == 0) {
            logger.error("get rt[" + pTVLoginInfoE.getRefreshToken() + "] from " + callFrom + " rf_at response", new Object[0]);
        } else {
            localSessionInfo.setRefreshToken(pTVLoginInfoE.getRefreshToken());
            Long refreshTokenExpiresIn2 = pTVLoginInfoE.getRefreshTokenExpiresIn();
            long jLongValue4 = refreshTokenExpiresIn2 != null ? refreshTokenExpiresIn2.longValue() : 0L;
            Long refreshTokenExpiresTS2 = localSessionInfo.getRefreshTokenExpiresTS();
            if (jLongValue4 > (refreshTokenExpiresTS2 != null ? refreshTokenExpiresTS2.longValue() : 0L)) {
                localSessionInfo.setRefreshTokenExpiresTS(pTVLoginInfoE.getRefreshTokenExpiresIn());
            } else {
                logger.warn("get rt_exp_t[" + pTVLoginInfoE.getRefreshTokenExpiresIn() + "] but no update from " + callFrom + " rf_at response", new Object[0]);
            }
        }
        localSessionInfo.setAccountSubscriptionList(a(pTVLoginInfoE));
        List<ServerResponse> streamServers2 = pTVLoginInfoE.getStreamServers();
        if (streamServers2 == null || streamServers2.isEmpty()) {
            logger.error("get ss[" + pTVLoginInfoE.getStreamServers() + "] from " + callFrom + " response", new Object[0]);
        } else {
            localSessionInfo.setStreamServers(pTVLoginInfoE.getStreamServers());
        }
        String memberShipUrl = pTVLoginInfoE.getMemberShipUrl();
        if (memberShipUrl != null && memberShipUrl.length() != 0) {
            localSessionInfo.setMemberShipUrl(pTVLoginInfoE.getMemberShipUrl());
        }
        localSessionInfo.setLogout(false);
        if (pTVLoginInfoE.getFreeTime() != null) {
            localSessionInfo.setFreeTimeMs(pTVLoginInfoE.getFreeTime().longValue() > 0 ? pTVLoginInfoE.getFreeTime().longValue() * FileWatchdog.DEFAULT_DELAY : 0L);
        }
        localSessionInfo.setTriedRefreshAccessTokenFailure(false);
        localSessionInfo.setTriedLoginByUsernameFailure(false);
        localSessionInfo.setLoginFailurePassword("");
        localSessionInfo.setLoginFailureUsername("");
        localSessionInfo.setPlanLeftDays(pTVLoginInfoE.getRemainingDays());
        fVar.y1(localSessionInfo);
        String strD0 = fVar.D0();
        String lastUsername = localSessionInfo.getLastUsername();
        if ((lastUsername == null || lastUsername.length() == 0) && strD0.length() > 0) {
            localSessionInfo.setLastUsername(strD0);
        }
        if (bVar.t()) {
            logger.debug("convert session to local [{}] -> [{}}", pTVLoginInfoE, localSessionInfo);
        }
        String strK = of.a.f16585a.k();
        String strC = z.f21470a.c();
        k kVar = k.f21398a;
        String strV = kVar.v();
        String strR = kVar.r();
        Long lValueOf = Long.valueOf(localSessionInfo.getAccountId());
        String accountType2 = localSessionInfo.getAccountType();
        String str = accountType2 == null ? "" : accountType2;
        String username3 = localSessionInfo.getUsername();
        if (username3 == null) {
            username3 = fVar.D0();
        }
        String str2 = username3;
        String email3 = localSessionInfo.getEmail();
        String str3 = email3 == null ? "" : email3;
        String phone = localSessionInfo.getPhone();
        String str4 = phone == null ? "" : phone;
        String code2 = localSessionInfo.getCode();
        String str5 = code2 == null ? "" : code2;
        String planName = pTVLoginInfoE.getPlanName();
        AccountInfo accountInfo = new AccountInfo(strK, strC, strV, strR, lValueOf, str, str2, str3, str4, str5, planName == null ? "" : planName, Long.valueOf(pTVLoginInfoE.getExpireTime()));
        String remainingDays = pTVLoginInfoE.getRemainingDays();
        if (remainingDays == null) {
            remainingDays = "0";
        }
        x1.f1.lb.metric.monitor.a.f20887a.p(accountInfo, remainingDays);
        return localSessionInfo;
    }

    static {
        g gVar = new g();
        f21276a = gVar;
        logger = q6.c.d(gVar.getClass());
    }

    public final LocalSessionInfo b(String contact, String digitalCode, String passwordDigest, RegisterInfo data) {
        String streamToken;
        m.f(contact, "contact");
        m.f(passwordDigest, "passwordDigest");
        m.f(data, "data");
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfoP0 = fVar.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setAccountId(data.getAccountId().longValue());
        localSessionInfoP0.setAccountName(data.getAccountName());
        localSessionInfoP0.setAccountType(data.getAccountType());
        localSessionInfoP0.setBusinessType(data.getBusinessType());
        localSessionInfoP0.setPasswordDigest(passwordDigest);
        localSessionInfoP0.setUsername(contact);
        if (digitalCode == null || digitalCode.length() == 0) {
            localSessionInfoP0.setEmail(contact);
        } else {
            localSessionInfoP0.setDigitalCode(digitalCode);
            if (n.O(contact, digitalCode, false, 2, null)) {
                localSessionInfoP0.setPhoneNumber(n.E(contact, digitalCode, "", false, 4, null));
                localSessionInfoP0.setPhone(contact);
            }
        }
        if (!m.a(localSessionInfoP0.getStreamToken(), data.getStreamToken()) && (streamToken = data.getStreamToken()) != null && streamToken.length() != 0) {
            localSessionInfoP0.setStreamToken(data.getStreamToken());
        }
        fVar.y1(localSessionInfoP0);
        return localSessionInfoP0;
    }

    public final LocalSessionInfo c(String username, String passwordDigit, LoginInfo data) {
        String phone;
        m.f(username, "username");
        m.f(passwordDigit, "passwordDigit");
        m.f(data, "data");
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            logger.debug("apiExtra loginInfo[ {} ]", data);
        }
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfoP0 = fVar.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setAccountId(data.getAccountId().longValue());
        localSessionInfoP0.setAccountName(data.getAccountName());
        localSessionInfoP0.setAccountType(data.getAccountType());
        localSessionInfoP0.setBusinessType(data.getBusinessType());
        localSessionInfoP0.setPasswordDigest(passwordDigit);
        localSessionInfoP0.setUsername(username);
        localSessionInfoP0.setStreamToken(data.getStreamToken());
        localSessionInfoP0.setAccessToken(data.getAccessToken());
        localSessionInfoP0.setRefreshToken(data.getRefreshToken());
        localSessionInfoP0.setAccessTokenExpiresTS(data.getAccessTokenExpiresIn());
        localSessionInfoP0.setRefreshTokenExpiresTS(data.getRefreshTokenExpiresIn());
        localSessionInfoP0.setAccountSubscriptionList(data.getAccountSubscriptionList());
        localSessionInfoP0.setStreamServers(data.getStreamServers());
        localSessionInfoP0.setCode(data.getCode());
        localSessionInfoP0.setEmail(data.getEmail());
        localSessionInfoP0.setDigitalCode(data.getDigitalCode());
        localSessionInfoP0.setHasPassword(data.getHasPassword());
        localSessionInfoP0.setLogout(false);
        String phone2 = data.getPhone();
        if (phone2 == null || phone2.length() == 0) {
            phone = "";
        } else {
            String digitalCode = data.getDigitalCode();
            phone = (digitalCode == null || digitalCode.length() == 0 || !ac.g.n(data.getPhone(), data.getDigitalCode())) ? data.getPhone() : ac.g.p(data.getPhone(), data.getDigitalCode().length());
        }
        localSessionInfoP0.setPhoneNumber(phone);
        String phoneNumber = localSessionInfoP0.getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() == 0) {
            username = "";
        } else {
            String phoneNumber2 = localSessionInfoP0.getPhoneNumber();
            m.e(phoneNumber2, "getPhoneNumber(...)");
            if (!n.v(username, phoneNumber2, false, 2, null)) {
                username = localSessionInfoP0.getDigitalCode() + localSessionInfoP0.getPhoneNumber();
            }
        }
        localSessionInfoP0.setPhone(username);
        if (data.getFreeTime() != null) {
            localSessionInfoP0.setFreeTimeMs(data.getFreeTime().longValue() > 0 ? FileWatchdog.DEFAULT_DELAY * data.getFreeTime().longValue() : 0L);
        }
        localSessionInfoP0.setLatestLoginResponseTime(Long.valueOf(d1.d()));
        if (bVar.t()) {
            logger.debug("convert session to local [{}] -> [{}}", data, localSessionInfoP0);
        }
        fVar.y1(localSessionInfoP0);
        return localSessionInfoP0;
    }

    public final LocalSessionInfo e(RechargeInfo data) {
        m.f(data, "data");
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfoP0 = fVar.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setAccountId(data.getAccountId());
        localSessionInfoP0.setAccountSubscriptionList(data.getAccountSubscriptionList());
        localSessionInfoP0.setLogout(false);
        localSessionInfoP0.setLatestLoginResponseTime(Long.valueOf(d1.d()));
        fVar.y1(localSessionInfoP0);
        return localSessionInfoP0;
    }

    public final LocalSessionInfo f(GuestLoginInfo data) {
        m.f(data, "data");
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            logger.debug("apiExtra loginInfo[ {} ]", data);
        }
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfoP0 = fVar.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setAccountId(data.getAccountId().longValue());
        localSessionInfoP0.setAccountName(data.getAccountName());
        localSessionInfoP0.setAccountType(data.getAccountType());
        localSessionInfoP0.setBusinessType(data.getBusinessType());
        localSessionInfoP0.setPasswordDigest("");
        localSessionInfoP0.setUsername("");
        localSessionInfoP0.setStreamToken(data.getStreamToken());
        localSessionInfoP0.setAccessToken(data.getAccessToken());
        localSessionInfoP0.setRefreshToken(data.getRefreshToken());
        localSessionInfoP0.setAccessTokenExpiresTS(data.getAccessTokenExpiresIn());
        localSessionInfoP0.setRefreshTokenExpiresTS(data.getRefreshTokenExpiresIn());
        localSessionInfoP0.setAccountSubscriptionList(data.getAccountSubscriptionList());
        localSessionInfoP0.setStreamServers(data.getStreamServers());
        localSessionInfoP0.setCode("");
        localSessionInfoP0.setEmail("");
        localSessionInfoP0.setDigitalCode("");
        localSessionInfoP0.setPhoneNumber("");
        localSessionInfoP0.setPhone("");
        localSessionInfoP0.setLogout(false);
        if (data.getFreeTime() != null) {
            localSessionInfoP0.setFreeTimeMs(data.getFreeTime().longValue() > 0 ? FileWatchdog.DEFAULT_DELAY * data.getFreeTime().longValue() : 0L);
        }
        localSessionInfoP0.setLatestLoginResponseTime(Long.valueOf(d1.d()));
        if (bVar.t()) {
            logger.debug("convert session to local [{}] -> [{}}", data, localSessionInfoP0);
        }
        fVar.y1(localSessionInfoP0);
        return localSessionInfoP0;
    }

    public final LocalSessionInfo g(RefreshInfo data) {
        m.f(data, "data");
        LocalSessionInfo localSessionInfoP0 = f.f21202a.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setRefreshToken(data.getRefreshToken());
        localSessionInfoP0.setAccessToken(data.getAccessToken());
        localSessionInfoP0.setRefreshTokenExpiresTS(data.getRefreshTokenExpiresIn());
        localSessionInfoP0.setAccessTokenExpiresTS(data.getAccessTokenExpiresIn());
        localSessionInfoP0.setStreamToken(data.getStreamToken());
        List<AccountSubscription> accountSubscriptionList = data.getAccountSubscriptionList();
        if (accountSubscriptionList != null && !accountSubscriptionList.isEmpty()) {
            localSessionInfoP0.setAccountSubscriptionList(data.getAccountSubscriptionList());
        }
        localSessionInfoP0.setAccountId(data.getAccountId().longValue());
        localSessionInfoP0.setBusinessType(data.getBusinessType());
        localSessionInfoP0.setLatestTokenUpdateTime(Long.valueOf(d1.d()));
        try {
            x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
            String streamToken = data.getStreamToken();
            m.e(streamToken, "getStreamToken(...)");
            aVar.p(streamToken);
            return localSessionInfoP0;
        } catch (Throwable th) {
            logger.warn("refresh stream token failure", th);
            return localSessionInfoP0;
        }
    }

    public final LocalSessionInfo h(LoginInfo data) {
        m.f(data, "data");
        f fVar = f.f21202a;
        LocalSessionInfo localSessionInfoP0 = fVar.p0();
        if (localSessionInfoP0 == null) {
            localSessionInfoP0 = new LocalSessionInfo();
        }
        localSessionInfoP0.setEmail(data.getEmail());
        localSessionInfoP0.setPhone(data.getPhone());
        localSessionInfoP0.setDigitalCode(data.getDigitalCode());
        localSessionInfoP0.setRandomName(data.getRandomName());
        localSessionInfoP0.setHasPassword(data.getHasPassword());
        localSessionInfoP0.setLogout(false);
        localSessionInfoP0.setLatestLoginResponseTime(Long.valueOf(d1.d()));
        fVar.y1(localSessionInfoP0);
        return localSessionInfoP0;
    }

    private g() {
    }

    private final List<AccountSubscription> a(PTVLoginInfo data) {
        List<AccountSubscription> accountSubscriptionList = data.getAccountSubscriptionList();
        if (accountSubscriptionList == null) {
            accountSubscriptionList = new ArrayList<>();
        }
        List<AccountSubscription> list = accountSubscriptionList;
        if (list.isEmpty()) {
            String planName = data.getPlanName();
            if ((planName != null && planName.length() != 0) || data.getExpireTime() > 0) {
                AccountSubscription accountSubscription = new AccountSubscription();
                accountSubscription.setProductName(data.getPlanName());
                accountSubscription.setExpireTs(data.getExpireTime());
                accountSubscriptionList = r.e(accountSubscription);
            }
            list = accountSubscriptionList;
        }
        return list;
    }
}
