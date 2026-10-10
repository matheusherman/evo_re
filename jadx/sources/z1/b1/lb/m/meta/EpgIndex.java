package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class EpgIndex extends a {
    private String channelId;
    private String checksum;
    private String date;
    private String file;

    @Keep
    public String getChannelId() {
        return this.channelId;
    }

    @Keep
    public String getChecksum() {
        return this.checksum;
    }

    @Keep
    public String getDate() {
        return this.date;
    }

    @Keep
    public String getFile() {
        return this.file;
    }

    @Keep
    public void setChannelId(String str) {
        this.channelId = str;
    }

    @Keep
    public void setChecksum(String str) {
        this.checksum = str;
    }

    @Keep
    public void setDate(String str) {
        this.date = str;
    }

    @Keep
    public void setFile(String str) {
        this.file = str;
    }
}
