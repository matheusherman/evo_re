package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class VerificationCodeRequest extends ApiRequestBasic {
    private String contact;
    private String digitalCode;
    private String emailType;

    @Keep
    public String getContact() {
        return this.contact;
    }

    @Keep
    public String getDigitalCode() {
        return this.digitalCode;
    }

    @Keep
    public String getEmailType() {
        return this.emailType;
    }

    @Keep
    public void setContact(String str) {
        this.contact = str;
    }

    @Keep
    public void setDigitalCode(String str) {
        this.digitalCode = str;
    }

    @Keep
    public void setEmailType(String str) {
        this.emailType = str;
    }

    public VerificationCodeRequest(String str, String str2, String str3) {
        this.contact = str;
        this.digitalCode = str2;
        this.emailType = str3;
    }
}
