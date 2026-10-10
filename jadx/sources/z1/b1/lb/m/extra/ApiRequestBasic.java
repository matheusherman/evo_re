package z1.b1.lb.m.extra;

import androidx.annotation.Keep;
import java.util.Map;
import n6.a;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ApiRequestBasic extends a {
    private final int appId;
    private final long appVersion;
    private final int brandId;
    private final Map<String, String> deviceInfo;
    private final String did;
    private final String distributionChannel;
    private final String lang;
    private final String mac;
    private final String reqTs;
    private final String sn;
    private final int tenantId;

    @Keep
    public int getAppId() {
        return this.appId;
    }

    @Keep
    public long getAppVersion() {
        return this.appVersion;
    }

    @Keep
    public int getBrandId() {
        return this.brandId;
    }

    @Keep
    public Map<String, String> getDeviceInfo() {
        return this.deviceInfo;
    }

    @Keep
    public String getDid() {
        return this.did;
    }

    @Keep
    public String getDistributionChannel() {
        return this.distributionChannel;
    }

    @Keep
    public String getLang() {
        return this.lang;
    }

    @Keep
    public String getMac() {
        return this.mac;
    }

    @Keep
    public String getReqTs() {
        return this.reqTs;
    }

    @Keep
    public String getSn() {
        return this.sn;
    }

    @Keep
    public int getTenantId() {
        return this.tenantId;
    }

    public ApiRequestBasic() {
        of.a aVar = of.a.f16585a;
        this.appId = aVar.a();
        this.appVersion = aVar.i();
        this.distributionChannel = aVar.f();
        this.brandId = aVar.d();
        this.tenantId = aVar.h();
        this.lang = aVar.l();
        this.mac = aVar.e();
        this.did = aVar.k();
        this.sn = aVar.j();
        this.reqTs = Long.toString(d1.d());
        this.deviceInfo = z.f21470a.i();
    }
}
