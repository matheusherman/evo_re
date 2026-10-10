package z1.b1.lb.m.user;

import androidx.annotation.Keep;
import java.util.Objects;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ServerResponse extends a {
    private String serverAddress;
    private String serverId;

    @Keep
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ServerResponse serverResponse = (ServerResponse) obj;
            if (Objects.equals(this.serverId, serverResponse.serverId) && Objects.equals(this.serverAddress, serverResponse.serverAddress)) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public String getServerAddress() {
        return this.serverAddress;
    }

    @Keep
    public String getServerId() {
        return this.serverId;
    }

    @Keep
    public int hashCode() {
        return Objects.hash(this.serverId, this.serverAddress);
    }

    @Keep
    public void setServerAddress(String str) {
        this.serverAddress = str;
    }

    @Keep
    public void setServerId(String str) {
        this.serverId = str;
    }
}
