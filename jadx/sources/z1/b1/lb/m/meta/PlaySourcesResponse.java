package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PlaySourcesResponse extends BasePageableResponse {
    private String metaId;
    private List<MetaPlaySourceResponse> playSources = new ArrayList();

    @Keep
    public String getMetaId() {
        return this.metaId;
    }

    @Keep
    public List<MetaPlaySourceResponse> getPlaySources() {
        return this.playSources;
    }

    @Keep
    public void setMetaId(String str) {
        this.metaId = str;
    }

    @Keep
    public void setPlaySources(List<MetaPlaySourceResponse> list) {
        this.playSources = list;
    }
}
