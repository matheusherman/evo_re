package z1.b1.lb.m.extra.subscription;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import z1.b1.lb.m.extra.ApiRequestBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RechargeRequest extends ApiRequestBasic {
    private String code;

    @Keep
    public String getCode() {
        return this.code;
    }

    @Keep
    public void setCode(String str) {
        this.code = str;
    }

    public RechargeRequest(@NonNull String str) {
        this.code = str;
    }
}
