package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AccountSubscription extends a {
    private long expireTs;
    private long productId;
    private String productName;

    @Keep
    public long getExpireTs() {
        return this.expireTs;
    }

    @Keep
    public long getProductId() {
        return this.productId;
    }

    @Keep
    public String getProductName() {
        return this.productName;
    }

    @Keep
    public void setExpireTs(long j10) {
        this.expireTs = j10;
    }

    @Keep
    public void setProductId(long j10) {
        this.productId = j10;
    }

    @Keep
    public void setProductName(String str) {
        this.productName = str;
    }
}
