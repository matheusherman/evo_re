package n6;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@ApiModel("通用API返回结构")
public class b<T> extends a {

    @ApiModelProperty(example = "1234567", value = "checksum")
    private String checkSum;

    @ApiModelProperty(example = "0", value = "响应状态码")
    private String code = "0";

    @ApiModelProperty("响应成功数据")
    private T data;

    @ApiModelProperty(example = "success", value = "响应错误说明")
    private String msg;

    @ApiModelProperty(example = "10", value = "响应时长")
    private long timeMs;

    public String c() {
        return this.checkSum;
    }

    public String d() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }
}
