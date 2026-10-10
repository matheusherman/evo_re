package z1.b1.lb.m.feedback;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "", "", "code", "message", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "a", "getMessage", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FeedbackUploadResponse {

    @Keep
    private final String code;

    @Keep
    private final Object data;

    @Keep
    private final String message;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackUploadResponse)) {
            return false;
        }
        FeedbackUploadResponse feedbackUploadResponse = (FeedbackUploadResponse) other;
        return m.a(this.code, feedbackUploadResponse.code) && m.a(this.message, feedbackUploadResponse.message) && m.a(this.data, feedbackUploadResponse.data);
    }

    public FeedbackUploadResponse(String code, String str, Object obj) {
        m.f(code, "code");
        this.code = code;
        this.message = str;
        this.data = obj;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.data;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "FeedbackUploadResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }
}
