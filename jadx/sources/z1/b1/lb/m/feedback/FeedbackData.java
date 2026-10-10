package z1.b1.lb.m.feedback;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class FeedbackData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f22622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f22623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f22624c;

    @Keep
    public String getIssueDesc() {
        return this.f22623b;
    }

    @Keep
    public String getIssueId() {
        return this.f22622a;
    }

    @Keep
    public String getSeq() {
        return this.f22624c;
    }

    @Keep
    public void setIssueDesc(String str) {
        this.f22623b = str;
    }

    @Keep
    public void setIssueId(String str) {
        this.f22622a = str;
    }

    @Keep
    public void setSeq(String str) {
        this.f22624c = str;
    }
}
