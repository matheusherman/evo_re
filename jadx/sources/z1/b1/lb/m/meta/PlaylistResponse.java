package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PlaylistResponse extends BasePageableResponse {
    private String playlistId = "";
    private String playlistName = "";
    private int playlistType = 0;
    private String metaQueryExpression = "";
    private int showType = 0;
    private String desc = "";
    private String language = "en";
    private List<PlaylistResponse> subPlaylist = new ArrayList();
    private List<PlaylistMetaResponse> metaList = new ArrayList();
    private long createTime = d1.d();
    private String iconUrl = "";
    private ShowTypeCfg showTypeCfg = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PlaylistResponse playlistResponse = (PlaylistResponse) obj;
            if (this.playlistType == playlistResponse.playlistType && this.showType == playlistResponse.showType && Objects.equals(this.playlistId, playlistResponse.playlistId) && Objects.equals(this.playlistName, playlistResponse.playlistName) && Objects.equals(this.metaQueryExpression, playlistResponse.metaQueryExpression) && Objects.equals(this.desc, playlistResponse.desc) && Objects.equals(this.language, playlistResponse.language) && Objects.equals(this.subPlaylist, playlistResponse.subPlaylist) && Objects.equals(this.metaList, playlistResponse.metaList) && Objects.equals(this.iconUrl, playlistResponse.iconUrl) && Objects.equals(this.showTypeCfg, playlistResponse.showTypeCfg)) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public long getCreateTime() {
        return this.createTime;
    }

    @Keep
    public String getDesc() {
        return this.desc;
    }

    @Keep
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Keep
    public String getLanguage() {
        return this.language;
    }

    @Keep
    public List<PlaylistMetaResponse> getMetaList() {
        return this.metaList;
    }

    @Keep
    public String getMetaQueryExpression() {
        return this.metaQueryExpression;
    }

    @Keep
    public String getPlaylistId() {
        return this.playlistId;
    }

    @Keep
    public String getPlaylistName() {
        return this.playlistName;
    }

    @Keep
    public int getPlaylistType() {
        return this.playlistType;
    }

    @Keep
    public int getShowType() {
        return this.showType;
    }

    @Keep
    public ShowTypeCfg getShowTypeCfg() {
        return this.showTypeCfg;
    }

    @Keep
    public List<PlaylistResponse> getSubPlaylist() {
        return this.subPlaylist;
    }

    public int hashCode() {
        return Objects.hash(this.playlistId, this.playlistName, Integer.valueOf(this.playlistType), this.metaQueryExpression, Integer.valueOf(this.showType), this.desc, this.language, this.subPlaylist, this.metaList, this.iconUrl, this.showTypeCfg);
    }

    @Keep
    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    @Keep
    public void setDesc(String str) {
        this.desc = str;
    }

    @Keep
    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @Keep
    public void setLanguage(String str) {
        this.language = str;
    }

    @Keep
    public void setMetaList(List<PlaylistMetaResponse> list) {
        this.metaList = list;
    }

    @Keep
    public void setMetaQueryExpression(String str) {
        this.metaQueryExpression = str;
    }

    @Keep
    public void setPlaylistId(String str) {
        this.playlistId = str;
    }

    @Keep
    public void setPlaylistName(String str) {
        this.playlistName = str;
    }

    @Keep
    public void setPlaylistType(int i10) {
        this.playlistType = i10;
    }

    @Keep
    public void setShowType(int i10) {
        this.showType = i10;
    }

    @Keep
    public void setShowTypeCfg(ShowTypeCfg showTypeCfg) {
        this.showTypeCfg = showTypeCfg;
    }

    @Keep
    public void setSubPlaylist(List<PlaylistResponse> list) {
        this.subPlaylist = list;
    }
}
