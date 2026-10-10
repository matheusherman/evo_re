package z1.b1.lb.m.extra.subscription;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;
import z1.b1.lb.m.extra.user.AccountSubscription;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RechargeInfo extends a {
    private long accountId;
    private List<AccountSubscription> accountSubscriptionList;

    @Keep
    public long getAccountId() {
        return this.accountId;
    }

    @Keep
    public List<AccountSubscription> getAccountSubscriptionList() {
        return this.accountSubscriptionList;
    }

    @Keep
    public void setAccountId(long j10) {
        this.accountId = j10;
    }

    @Keep
    public void setAccountSubscriptionList(List<AccountSubscription> list) {
        this.accountSubscriptionList = list;
    }
}
