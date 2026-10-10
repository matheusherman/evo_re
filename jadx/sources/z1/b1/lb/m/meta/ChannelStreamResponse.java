package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.Objects;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ChannelStreamResponse extends a {
    private boolean catchup;
    private String catchupCdnAddress;
    private String catchupRoute;
    private String catchupStreamId;
    private String categories;
    private int displaySeq;
    private String epgId;
    private String iconUrl;
    private int key;
    private String liveCdnAddress;
    private String playerArgs;
    private String route;
    private String streamId;
    private String streamName;
    private int type;

    @Keep
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.key == ((ChannelStreamResponse) obj).key;
    }

    public boolean c() {
        int i10 = this.type;
        return i10 == 1 || i10 == 3;
    }

    @Keep
    public String getCatchupCdnAddress() {
        return this.catchupCdnAddress;
    }

    @Keep
    public String getCatchupRoute() {
        return this.catchupRoute;
    }

    @Keep
    public String getCatchupStreamId() {
        return this.catchupStreamId;
    }

    @Keep
    public String getCategories() {
        return this.categories;
    }

    @Keep
    public int getDisplaySeq() {
        return this.displaySeq;
    }

    @Keep
    public String getEpgId() {
        return this.epgId;
    }

    @Keep
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Keep
    public int getKey() {
        return this.key;
    }

    @Keep
    public String getLiveCdnAddress() {
        return this.liveCdnAddress;
    }

    @Keep
    public String getPlayerArgs() {
        return this.playerArgs;
    }

    @Keep
    public String getRoute() {
        return this.route;
    }

    @Keep
    public String getStreamId() {
        return this.streamId;
    }

    @Keep
    public String getStreamName() {
        return this.streamName;
    }

    @Keep
    public int getType() {
        return this.type;
    }

    @Keep
    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.key));
    }

    @Keep
    public boolean isCatchup() {
        return this.catchup;
    }

    @Keep
    public void setCatchup(boolean z10) {
        this.catchup = z10;
    }

    @Keep
    public void setCatchupCdnAddress(String str) {
        this.catchupCdnAddress = str;
    }

    @Keep
    public void setCatchupRoute(String str) {
        this.catchupRoute = str;
    }

    @Keep
    public void setCatchupStreamId(String str) {
        this.catchupStreamId = str;
    }

    @Keep
    public void setCategories(String str) {
        this.categories = str;
    }

    @Keep
    public void setDisplaySeq(int i10) {
        this.displaySeq = i10;
    }

    @Keep
    public void setEpgId(String str) {
        this.epgId = str;
    }

    @Keep
    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @Keep
    public void setKey(int i10) {
        this.key = i10;
    }

    @Keep
    public void setLiveCdnAddress(String str) {
        this.liveCdnAddress = str;
    }

    @Keep
    public void setPlayerArgs(String str) {
        this.playerArgs = str;
    }

    @Keep
    public void setRoute(String str) {
        this.route = str;
    }

    @Keep
    public void setStreamId(String str) {
        this.streamId = str;
    }

    @Keep
    public void setStreamName(String str) {
        this.streamName = str;
    }

    @Keep
    public void setType(int i10) {
        this.type = i10;
    }
}
