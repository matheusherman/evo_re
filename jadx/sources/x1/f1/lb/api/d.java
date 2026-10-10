package x1.f1.lb.api;

import gf.o;
import kotlin.Metadata;
import z1.b1.lb.m.extra.ApiRequestBasic;
import z1.b1.lb.m.extra.ApiResponse;
import z1.b1.lb.m.extra.ApiResponseBasic;
import z1.b1.lb.m.extra.user.GuestLoginInfo;
import z1.b1.lb.m.extra.user.GuestLoginRequest;
import z1.b1.lb.m.extra.user.LinkRequest;
import z1.b1.lb.m.extra.user.LoginInfo;
import z1.b1.lb.m.extra.user.LoginRequest;
import z1.b1.lb.m.extra.user.QueryMetaInfo;
import z1.b1.lb.m.extra.user.QueryPropertiesInfo;
import z1.b1.lb.m.extra.user.RefreshInfo;
import z1.b1.lb.m.extra.user.RefreshTokenRequest;
import z1.b1.lb.m.extra.user.RegisterInfo;
import z1.b1.lb.m.extra.user.RegisterRequest;
import z1.b1.lb.m.extra.user.ResetPasswordRequest;
import z1.b1.lb.m.extra.user.VerificationCodeRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH§@¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\rH§@¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0015H§@¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0019H§@¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001dH§@¢\u0006\u0004\b\u001f\u0010 J&\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020!H§@¢\u0006\u0004\b#\u0010$J&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020%H§@¢\u0006\u0004\b&\u0010'J&\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020(H§@¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lx1/f1/lb/api/d;", "", "Lz1/b1/lb/m/extra/ApiRequestBasic;", "request", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/QueryMetaInfo;", "k", "(Lz1/b1/lb/m/extra/ApiRequestBasic;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/GuestLoginRequest;", "Lz1/b1/lb/m/extra/user/GuestLoginInfo;", "d", "(Lz1/b1/lb/m/extra/user/GuestLoginRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/LoginRequest;", "Lz1/b1/lb/m/extra/user/LoginInfo;", "f", "(Lz1/b1/lb/m/extra/user/LoginRequest;Lv8/f;)Ljava/lang/Object;", "Leg/b;", "Lz1/b1/lb/m/extra/user/QueryPropertiesInfo;", "e", "(Leg/b;Lv8/f;)Ljava/lang/Object;", "Leg/a;", "Lz1/b1/lb/m/extra/ApiResponseBasic;", "j", "(Leg/a;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/RefreshTokenRequest;", "Lz1/b1/lb/m/extra/user/RefreshInfo;", "i", "(Lz1/b1/lb/m/extra/user/RefreshTokenRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/VerificationCodeRequest;", "", "g", "(Lz1/b1/lb/m/extra/user/VerificationCodeRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/RegisterRequest;", "Lz1/b1/lb/m/extra/user/RegisterInfo;", "l", "(Lz1/b1/lb/m/extra/user/RegisterRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/ResetPasswordRequest;", "c", "(Lz1/b1/lb/m/extra/user/ResetPasswordRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/LinkRequest;", "h", "(Lz1/b1/lb/m/extra/user/LinkRequest;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface d {
    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/reset-password")
    Object c(@gf.a ResetPasswordRequest resetPasswordRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/guest/login")
    Object d(@gf.a GuestLoginRequest guestLoginRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<GuestLoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/app/property/query")
    Object e(@gf.a eg.b bVar, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryPropertiesInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/login")
    Object f(@gf.a LoginRequest loginRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/captcha/send")
    Object g(@gf.a VerificationCodeRequest verificationCodeRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/contact/link")
    Object h(@gf.a LinkRequest linkRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/token/refresh")
    Object i(@gf.a RefreshTokenRequest refreshTokenRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RefreshInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/logout")
    Object j(@gf.a eg.a aVar, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponseBasic>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/meta/info/query")
    Object k(@gf.a ApiRequestBasic apiRequestBasic, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryMetaInfo>>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/register")
    Object l(@gf.a RegisterRequest registerRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RegisterInfo>>> fVar);
}
