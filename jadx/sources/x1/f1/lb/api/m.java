package x1.f1.lb.api;

import gf.o;
import kotlin.Metadata;
import z1.b1.lb.m.extra.ApiResponse;
import z1.b1.lb.m.extra.subscription.RechargeInfo;
import z1.b1.lb.m.extra.subscription.RechargeRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lx1/f1/lb/api/m;", "", "Lz1/b1/lb/m/extra/subscription/RechargeRequest;", "request", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/subscription/RechargeInfo;", "a", "(Lz1/b1/lb/m/extra/subscription/RechargeRequest;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface m {
    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @o("/api/v1/account/code/recharge")
    Object a(@gf.a RechargeRequest rechargeRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RechargeInfo>>> fVar);
}
