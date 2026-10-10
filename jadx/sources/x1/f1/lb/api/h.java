package x1.f1.lb.api;

import gf.o;
import gf.s;
import gf.t;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;
import z1.b1.lb.m.extra.user.LoginRequest;
import z1.b1.lb.m.extra.user.ResetPasswordRequest;
import z1.b1.lb.m.extra.user.VerificationCodeRequest;
import z1.b1.lb.m.ptv.ApiResponse;
import z1.b1.lb.m.ptv.referral.ReferralSummary;
import z1.b1.lb.m.ptv.subscription.ChargeCodeRechargeRequest;
import z1.b1.lb.m.ptv.user.PTVLoginInfo;
import z1.b1.lb.m.ptv.user.RegisterRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\bH§@¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\rH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004H§@¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0013\u0010\u0007J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H§@¢\u0006\u0004\b\u0014\u0010\u0011J&\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0016\u0010\u0007J&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0017H§@¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u001aH§@¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u001dH§@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00050\u0004H§@¢\u0006\u0004\b!\u0010\u0011J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00050\u0004H§@¢\u0006\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lx1/f1/lb/api/h;", "", "", "tenantId", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "f", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/ptv/user/RegisterRequest;", "request", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "g", "(Lz1/b1/lb/m/ptv/user/RegisterRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/LoginRequest;", "l", "(Lz1/b1/lb/m/extra/user/LoginRequest;Lv8/f;)Ljava/lang/Object;", "e", "(Lv8/f;)Ljava/lang/Object;", "token", "b", "a", "refreshToken", "d", "Lz1/b1/lb/m/extra/user/VerificationCodeRequest;", "j", "(Lz1/b1/lb/m/extra/user/VerificationCodeRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/ptv/subscription/ChargeCodeRechargeRequest;", "i", "(Lz1/b1/lb/m/ptv/subscription/ChargeCodeRechargeRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/ResetPasswordRequest;", "c", "(Lz1/b1/lb/m/extra/user/ResetPasswordRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "k", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "h", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface h {
    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/account/logout")
    Object a(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/account/loginByToken")
    Object b(@t("token") String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/reset-password")
    Object c(@gf.a ResetPasswordRequest resetPasswordRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/account/token/refresh")
    Object d(@t("refreshToken") String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/guest/login")
    Object e(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/info/{id}")
    Object f(@s(IjkMediaMeta.IJKM_KEY_TRACK_ID) String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/register")
    Object g(@gf.a RegisterRequest registerRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/referral/summary")
    Object h(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<ReferralSummary>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/recharge")
    Object i(@gf.a ChargeCodeRechargeRequest chargeCodeRechargeRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/captcha/send")
    Object j(@gf.a VerificationCodeRequest verificationCodeRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/upgrade/config")
    Object k(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<UpgradeInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/login")
    Object l(@gf.a LoginRequest loginRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar);
}
