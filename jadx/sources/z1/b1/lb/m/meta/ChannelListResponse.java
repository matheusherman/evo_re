package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ChannelListResponse extends BasePageableResponse {
    private ChannelEPGIndexResponse channelEPGIndexResponse;
    private String playerArgs;
    private String tenantId;
    private List<ChannelStreamResponse> channelStreams = new ArrayList();
    private List<String> categorySorts = new ArrayList();

    @Keep
    public List<String> getCategorySorts() {
        return this.categorySorts;
    }

    @Keep
    public ChannelEPGIndexResponse getChannelEPGIndexResponse() {
        return this.channelEPGIndexResponse;
    }

    @Keep
    public List<ChannelStreamResponse> getChannelStreams() {
        return this.channelStreams;
    }

    @Keep
    public String getPlayerArgs() {
        return this.playerArgs;
    }

    @Keep
    public String getTenantId() {
        return this.tenantId;
    }

    @Keep
    public void setCategorySorts(List<String> list) {
        this.categorySorts = list;
    }

    @Keep
    public void setChannelEPGIndexResponse(ChannelEPGIndexResponse channelEPGIndexResponse) {
        this.channelEPGIndexResponse = channelEPGIndexResponse;
    }

    @Keep
    public void setChannelStreams(List<ChannelStreamResponse> list) {
        this.channelStreams = list;
    }

    @Keep
    public void setPlayerArgs(String str) {
        this.playerArgs = str;
    }

    @Keep
    public void setTenantId(String str) {
        this.tenantId = str;
    }
}
