package z1.b1.lb.m.extra.upgrade;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class UpgradeInfo extends a {
    private String checksum;
    private int delayTime;
    private String digestAlgorithm;
    private int forceUpgrade;
    private String message;
    private long size;
    private int upgradeStatus;
    private String url;
    private String versionName;

    @Keep
    public String getChecksum() {
        return this.checksum;
    }

    @Keep
    public int getDelayTime() {
        return this.delayTime;
    }

    @Keep
    public String getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    @Keep
    public int getForceUpgrade() {
        return this.forceUpgrade;
    }

    @Keep
    public String getMessage() {
        return this.message;
    }

    @Keep
    public long getSize() {
        return this.size;
    }

    @Keep
    public int getUpgradeStatus() {
        return this.upgradeStatus;
    }

    @Keep
    public String getUrl() {
        return this.url;
    }

    @Keep
    public String getVersionName() {
        return this.versionName;
    }

    @Keep
    public void setChecksum(String str) {
        this.checksum = str;
    }

    @Keep
    public void setDelayTime(int i10) {
        this.delayTime = i10;
    }

    @Keep
    public void setDigestAlgorithm(String str) {
        this.digestAlgorithm = str;
    }

    @Keep
    public void setForceUpgrade(int i10) {
        this.forceUpgrade = i10;
    }

    @Keep
    public void setMessage(String str) {
        this.message = str;
    }

    @Keep
    public void setSize(long j10) {
        this.size = j10;
    }

    @Keep
    public void setUpgradeStatus(int i10) {
        this.upgradeStatus = i10;
    }

    @Keep
    public void setUrl(String str) {
        this.url = str;
    }

    @Keep
    public void setVersionName(String str) {
        this.versionName = str;
    }
}
