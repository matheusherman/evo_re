package z1.b1.lb.m.notice;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class NotificationResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<NotificationData> f22637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, Integer> f22638b;

    @Keep
    public List<NotificationData> getNotificationList() {
        return this.f22637a;
    }

    @Keep
    public Map<Integer, Integer> getNotificationState() {
        return this.f22638b;
    }

    @Keep
    public void setNotificationList(List<NotificationData> list) {
        this.f22637a = list;
    }

    @Keep
    public void setNotificationState(Map<Integer, Integer> map) {
        this.f22638b = map;
    }
}
