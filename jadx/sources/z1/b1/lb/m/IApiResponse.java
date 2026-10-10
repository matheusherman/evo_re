package z1.b1.lb.m;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface IApiResponse {
    @Keep
    int getErrCode();

    @Keep
    String getErrMsg();

    @Keep
    boolean isSuccess();
}
