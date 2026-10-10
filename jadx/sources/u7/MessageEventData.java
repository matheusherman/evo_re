package u7;

import androidx.core.app.NotificationCompat;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: renamed from: u7.h, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017¨\u0006\u0019"}, d2 = {"Lu7/h;", "", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "d", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MessageEventData {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Object data;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEventData)) {
            return false;
        }
        MessageEventData messageEventData = (MessageEventData) other;
        return this.code == messageEventData.code && m.a(this.msg, messageEventData.msg) && m.a(this.data, messageEventData.data);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int i10 = this.code * 31;
        String str = this.msg;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.data;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "MessageEventData(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public MessageEventData(int i10, String str, Object obj) {
        this.code = i10;
        this.msg = str;
        this.data = obj;
    }
}
