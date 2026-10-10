package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class GuestLoginRequest extends ApiRequestBasic {
    private Long accountId;
    private String accountName;

    @Keep
    public long getAccountId() {
        return this.accountId.longValue();
    }

    @Keep
    public String getAccountName() {
        return this.accountName;
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
    public GuestLoginRequest(Long l10, String str) {
        this.accountId = l10;
        this.accountName = str;
    }
}
