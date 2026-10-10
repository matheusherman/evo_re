package z1.b1.lb.m.user;

import androidx.annotation.Keep;
import java.util.List;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LoginResponse extends a {
    private String checksum;
    private List<ServerResponse> metaServers;
    private List<ServerResponse> streamServers;
    private String token;
    private String uid;
    private List<ServerResponse> updateServers;

    @Keep
    public String getChecksum() {
        return this.checksum;
    }

    @Keep
    public List<ServerResponse> getMetaServers() {
        return this.metaServers;
    }

    @Keep
    public List<ServerResponse> getStreamServers() {
        return this.streamServers;
    }

    @Keep
    public String getToken() {
        return this.token;
    }

    @Keep
    public String getUid() {
        return this.uid;
    }

    @Keep
    public List<ServerResponse> getUpdateServers() {
        return this.updateServers;
    }

    @Keep
    public void setChecksum(String str) {
        this.checksum = str;
    }

    @Keep
    public void setMetaServers(List<ServerResponse> list) {
        this.metaServers = list;
    }

    @Keep
    public void setStreamServers(List<ServerResponse> list) {
        this.streamServers = list;
    }

    @Keep
    public void setToken(String str) {
        this.token = str;
    }

    @Keep
    public void setUid(String str) {
        this.uid = str;
    }

    @Keep
    public void setUpdateServers(List<ServerResponse> list) {
        this.updateServers = list;
    }
}
