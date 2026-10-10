package z1.b1.lb.m.extra.user;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class QueryMetaInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f22619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoginInfo f22620b;

    @Keep
    public LoginInfo getLoginInfo() {
        return this.f22620b;
    }

    @Keep
    public Map getProperties() {
        return this.f22619a;
    }

    @Keep
    public void setLoginInfo(LoginInfo loginInfo) {
        this.f22620b = loginInfo;
    }

    @Keep
    public void setProperties(Map map) {
        this.f22619a = map;
    }
}
