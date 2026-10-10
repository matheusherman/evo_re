package z1.b1.lb.m.extra;

import androidx.annotation.Keep;
import n6.a;
import z1.b1.lb.m.IApiResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ApiResponseBasic extends a implements IApiResponse {
    private int errCode;
    private String errMsg;

    @Override // z1.b1.lb.m.IApiResponse
    @Keep
    public int getErrCode() {
        return this.errCode;
    }

    @Override // z1.b1.lb.m.IApiResponse
    @Keep
    public String getErrMsg() {
        return this.errCode + ":" + this.errMsg;
    }

    @Override // z1.b1.lb.m.IApiResponse
    public boolean isSuccess() {
        int i10 = this.errCode;
        return i10 == 0 || i10 == 10100035;
    }

    @Keep
    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    @Keep
    public void setErrMsg(String str) {
        this.errMsg = str;
    }
}
