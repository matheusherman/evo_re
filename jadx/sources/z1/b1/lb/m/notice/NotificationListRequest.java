package z1.b1.lb.m.notice;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class NotificationListRequest extends ApiRequestBasic {
    String accountId;
    String username;

    @Keep
    public String getAccountId() {
        return this.accountId;
    }

    @Keep
    public String getUsername() {
        return this.username;
    }

    @Keep
    public void setAccountId(String str) {
        this.accountId = str;
    }

    @Keep
    public void setUsername(String str) {
        this.username = str;
    }
}
