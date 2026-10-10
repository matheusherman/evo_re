package nf;

import java.io.Serializable;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class z implements Serializable {
    private String apkFile;
    private boolean isManual;
    private UpgradeInfo upgradeInfo;

    public z(UpgradeInfo upgradeInfo, String str) {
        this.isManual = false;
        this.upgradeInfo = upgradeInfo;
        this.apkFile = str;
    }

    public String a() {
        return this.apkFile;
    }

    public UpgradeInfo b() {
        return this.upgradeInfo;
    }

    public boolean c() {
        return this.isManual;
    }

    public z(UpgradeInfo upgradeInfo, String str, boolean z10) {
        this.upgradeInfo = upgradeInfo;
        this.apkFile = str;
        this.isManual = z10;
    }
}
