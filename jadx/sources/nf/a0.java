package nf;

import java.io.Serializable;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a0 implements Serializable {
    private final int errCode;
    private final String errMsg;
    private final boolean isFromUI;
    private final Throwable throwable;
    private final UpgradeInfo upgradeInfo;

    public String a() {
        return this.errMsg;
    }

    public UpgradeInfo b() {
        return this.upgradeInfo;
    }

    public boolean c() {
        return this.isFromUI;
    }

    public a0(boolean z10, UpgradeInfo upgradeInfo, int i10, String str, Throwable th) {
        this.isFromUI = z10;
        this.upgradeInfo = upgradeInfo;
        this.errCode = i10;
        this.errMsg = str;
        this.throwable = th;
    }
}
