package z1.b1.lb.m.ptv;

import ac.g;
import androidx.annotation.Keep;
import n6.a;
import nf.u;
import x1.f1.lb.user.f;
import xe.c;
import z1.b1.lb.m.IApiResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ApiResponseBasic extends a implements IApiResponse {
    private String errCode;
    private String errMessage;
    private long serverTime;
    private boolean success;

    public String c() {
        return this.errCode;
    }

    @Keep
    public String getErrMessage() {
        return this.errMessage;
    }

    @Override // z1.b1.lb.m.IApiResponse
    public String getErrMsg() {
        return this.errMessage;
    }

    @Keep
    public long getServerTime() {
        return this.serverTime;
    }

    @Override // z1.b1.lb.m.IApiResponse
    @Keep
    public boolean isSuccess() {
        return this.success;
    }

    @Keep
    public void setErrCode(String str) {
        this.errCode = str;
    }

    @Keep
    public void setErrMessage(String str) {
        this.errMessage = str;
    }

    @Keep
    public void setServerTime(long j10) {
        this.serverTime = j10;
    }

    @Keep
    public void setSuccess(boolean z10) {
        this.success = z10;
    }

    @Override // z1.b1.lb.m.IApiResponse
    public int getErrCode() {
        if (isSuccess()) {
            return 0;
        }
        if (g.d(this.errCode, "B_USER_usernameRepeat")) {
            return 10100033;
        }
        if (g.d(this.errCode, "B_USER_undefined")) {
            return 10100002;
        }
        if (g.d(this.errCode, "B_USER_cardUnavailable")) {
            return 10100011;
        }
        if (g.d(this.errCode, "B_USER_passwordError")) {
            return 10100027;
        }
        if (g.d(this.errCode, "B_USER_incorrectVerificationCode")) {
            return 10100030;
        }
        if (g.d(this.errCode, "B_USER_emailAlreadyBound") || g.d(this.errCode, "B_USER_mobileAlreadyBound")) {
            return 10100033;
        }
        if (g.d(this.errCode, "B_USER_countryCodeEmpty")) {
            return 10100005;
        }
        if (g.d(this.errCode, "B_CHARGE_codeUndefined")) {
            return 10100007;
        }
        if (g.d(this.errCode, "B_CHARGE_codeUnavailable")) {
            return 10100011;
        }
        if (!g.d(this.errCode, "401") && !g.d(this.errCode, "500")) {
            if (g.d(this.errCode, "B_USER_alreadyBind")) {
                return -8;
            }
            return -1;
        }
        if (!f.f21202a.P0()) {
            c.c().l(new u(-9, "api"));
        }
        return -9;
    }
}
