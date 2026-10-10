package z1.b1.lb.m.extra.subscription;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class QuerySubscriptionListInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22618b;

    @Keep
    public String getExpireTs() {
        return this.f22618b;
    }

    @Keep
    public String getProductId() {
        return this.f22617a;
    }

    @Keep
    public void setExpireTs(String str) {
        this.f22618b = str;
    }

    @Keep
    public void setProductId(String str) {
        this.f22617a = str;
    }
}
