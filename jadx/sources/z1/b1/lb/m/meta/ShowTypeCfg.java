package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ShowTypeCfg extends a {
    private String category;
    private String streamId;
    private String videoType;
    private boolean filter = false;
    private String genres = "";
    private boolean showListOnly = false;
    private boolean hideTitle = false;

    @Keep
    public String getCategory() {
        return this.category;
    }

    @Keep
    public String getGenres() {
        return this.genres;
    }

    @Keep
    public String getStreamId() {
        return this.streamId;
    }

    @Keep
    public String getVideoType() {
        return this.videoType;
    }

    @Keep
    public boolean isFilter() {
        return this.filter;
    }

    @Keep
    public boolean isHideTitle() {
        return this.hideTitle;
    }

    @Keep
    public boolean isShowListOnly() {
        return this.showListOnly;
    }

    @Keep
    public void setCategory(String str) {
        this.category = str;
    }

    @Keep
    public void setFilter(boolean z10) {
        this.filter = z10;
    }

    @Keep
    public void setGenres(String str) {
        this.genres = str;
    }

    @Keep
    public void setHideTitle(boolean z10) {
        this.hideTitle = z10;
    }

    @Keep
    public void setShowListOnly(boolean z10) {
        this.showListOnly = z10;
    }

    @Keep
    public void setStreamId(String str) {
        this.streamId = str;
    }

    @Keep
    public void setVideoType(String str) {
        this.videoType = str;
    }
}
