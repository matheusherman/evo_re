package z1.b1.lb.m.ptv.user;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RegisterRequest extends ApiRequestBasic {
    private String accountId;
    private String invitationCode;
    private String password;
    private String token;
    private String username;
    private String verificationCode;

    @Keep
    public String getAccountId() {
        return this.accountId;
    }

    @Keep
    public String getInvitationCode() {
        return this.invitationCode;
    }

    @Keep
    public String getPassword() {
        return this.password;
    }

    @Keep
    public String getToken() {
        return this.token;
    }

    @Keep
    public String getUsername() {
        return this.username;
    }

    @Keep
    public String getVerificationCode() {
        return this.verificationCode;
    }

    @Keep
    public void setAccountId(String str) {
        this.accountId = str;
    }

    @Keep
    public void setInvitationCode(String str) {
        this.invitationCode = str;
    }

    @Keep
    public void setPassword(String str) {
        this.password = str;
    }

    @Keep
    public void setToken(String str) {
        this.token = str;
    }

    @Keep
    public void setUsername(String str) {
        this.username = str;
    }

    @Keep
    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    @Override // n6.a
    @NonNull
    public String toString() {
        return "RegisterRequest{accountId='" + this.accountId + "', token='" + this.token + "', username='" + this.username + "', password='" + this.password + "', verificationCode='" + this.verificationCode + "', invitationCode='" + this.invitationCode + "'}";
    }

    public RegisterRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        this.username = str3;
        this.password = str4;
        this.verificationCode = str5;
        this.invitationCode = str6;
    }
}
