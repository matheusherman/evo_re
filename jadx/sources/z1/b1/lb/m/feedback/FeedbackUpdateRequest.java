package z1.b1.lb.m.feedback;

import androidx.annotation.Keep;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class FeedbackUpdateRequest extends ApiRequestBasic {
    String channelId;
    String issueId;
    String reportInfo;

    @Keep
    public String getChannelId() {
        return this.channelId;
    }

    @Keep
    public String getIssueId() {
        return this.issueId;
    }

    @Keep
    public String getReportInfo() {
        return this.reportInfo;
    }

    @Keep
    public void setChannelId(String str) {
        this.channelId = str;
    }

    @Keep
    public void setIssueId(String str) {
        this.issueId = str;
    }

    @Keep
    public void setReportInfo(String str) {
        this.reportInfo = str;
    }
}
