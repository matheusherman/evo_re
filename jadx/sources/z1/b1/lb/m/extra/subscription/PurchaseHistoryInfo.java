package z1.b1.lb.m.extra.subscription;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PurchaseHistoryInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22616e;

    @Keep
    public String getActualAmountPaid() {
        return this.f22614c;
    }

    @Keep
    public String getActualCurrencyPaid() {
        return this.f22613b;
    }

    @Keep
    public String getCreatedAt() {
        return this.f22616e;
    }

    @Keep
    public String getPaymentStatus() {
        return this.f22615d;
    }

    @Keep
    public String getSubscribedName() {
        return this.f22612a;
    }

    @Keep
    public void setActualAmountPaid(String str) {
        this.f22614c = str;
    }

    @Keep
    public void setActualCurrencyPaid(String str) {
        this.f22613b = str;
    }

    @Keep
    public void setCreatedAt(String str) {
        this.f22616e = str;
    }

    @Keep
    public void setPaymentStatus(String str) {
        this.f22615d = str;
    }

    @Keep
    public void setSubscribedName(String str) {
        this.f22612a = str;
    }
}
