package z1.b1.lb.m.ptv.referral;

import androidx.annotation.Keep;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ReferralSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f22643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f22644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f22645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f22646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22647h;

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            ReferralSummary referralSummary = (ReferralSummary) obj;
            if (Double.compare(this.f22643d, referralSummary.f22643d) == 0 && Double.compare(this.f22644e, referralSummary.f22644e) == 0 && Double.compare(this.f22645f, referralSummary.f22645f) == 0 && Double.compare(this.f22646g, referralSummary.f22646g) == 0 && this.f22647h == referralSummary.f22647h && Objects.equals(this.f22640a, referralSummary.f22640a) && Objects.equals(this.f22641b, referralSummary.f22641b) && Objects.equals(this.f22642c, referralSummary.f22642c)) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public boolean getActivityEnabled() {
        return this.f22647h;
    }

    @Keep
    public double getAvailableBalance() {
        return this.f22643d;
    }

    @Keep
    public double getFrozenBalance() {
        return this.f22645f;
    }

    @Keep
    public String getInvitationCode() {
        return this.f22640a;
    }

    @Keep
    public String getInvitationLink() {
        return this.f22641b;
    }

    @Keep
    public String getInvitationQrCodeUrl() {
        return this.f22642c;
    }

    @Keep
    public double getPendingBalance() {
        return this.f22644e;
    }

    @Keep
    public double getWithdrawMinAmount() {
        return this.f22646g;
    }

    public int hashCode() {
        return Objects.hash(this.f22640a, this.f22641b, this.f22642c, Double.valueOf(this.f22643d), Double.valueOf(this.f22644e), Double.valueOf(this.f22645f), Double.valueOf(this.f22646g), Boolean.valueOf(this.f22647h));
    }

    @Keep
    public void setActivityEnabled(boolean z10) {
        this.f22647h = z10;
    }

    @Keep
    public void setAvailableBalance(double d10) {
        this.f22643d = d10;
    }

    @Keep
    public void setFrozenBalance(double d10) {
        this.f22645f = d10;
    }

    @Keep
    public void setInvitationCode(String str) {
        this.f22640a = str;
    }

    @Keep
    public void setInvitationLink(String str) {
        this.f22641b = str;
    }

    @Keep
    public void setInvitationQrCodeUrl(String str) {
        this.f22642c = str;
    }

    @Keep
    public void setPendingBalance(double d10) {
        this.f22644e = d10;
    }

    @Keep
    public void setWithdrawMinAmount(double d10) {
        this.f22646g = d10;
    }
}
