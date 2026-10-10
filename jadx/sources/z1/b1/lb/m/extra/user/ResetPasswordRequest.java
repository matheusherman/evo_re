package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ResetPasswordRequest extends ApiRequestBasic {
    private String captchaCode;
    private String digitalCode;
    private String newPassword;
    private String username;

    @Keep
    public String getCaptchaCode() {
        return this.captchaCode;
    }

    @Keep
    public String getNewPassword() {
        return this.newPassword;
    }

    @Keep
    public String getUsername() {
        return this.username;
    }

    @Keep
    public void setCaptchaCode(String str) {
        this.captchaCode = str;
    }

    @Keep
    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    @Keep
    public void setUsername(String str) {
        this.username = str;
    }

    public ResetPasswordRequest(String str, String str2, String str3, String str4) {
        this.digitalCode = str2;
        this.username = str;
        this.newPassword = str3;
        this.captchaCode = str4;
    }
}
