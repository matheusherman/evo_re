package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ChangePasswordRequest extends ApiRequestBasic {
    private String newPassword;
    private String oldPassword;

    @Keep
    public String getNewPassword() {
        return this.newPassword;
    }

    @Keep
    public String getOldPassword() {
        return this.oldPassword;
    }

    @Keep
    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    @Keep
    public void setOldPassword(String str) {
        this.oldPassword = str;
    }
}
