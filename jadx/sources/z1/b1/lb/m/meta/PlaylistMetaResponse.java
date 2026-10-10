package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.Objects;
import n6.a;
import x1.f1.lb.util.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PlaylistMetaResponse extends a {
    private Double popularity;
    private Double voteAverage;
    private String metaId = "";
    private String language = "en";
    private int videoType = 0;
    private String title = "";
    private String poster = "";
    private String backdrop = "";
    private String releaseDate = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PlaylistMetaResponse playlistMetaResponse = (PlaylistMetaResponse) obj;
            if (this.videoType == playlistMetaResponse.videoType && Objects.equals(this.metaId, playlistMetaResponse.metaId) && Objects.equals(this.language, playlistMetaResponse.language) && Objects.equals(this.title, playlistMetaResponse.title) && Objects.equals(this.poster, playlistMetaResponse.poster) && Objects.equals(this.backdrop, playlistMetaResponse.backdrop) && Objects.equals(this.releaseDate, playlistMetaResponse.releaseDate) && Objects.equals(this.voteAverage, playlistMetaResponse.voteAverage) && Objects.equals(this.popularity, playlistMetaResponse.popularity)) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public String getBackdrop() {
        return l0.f21409a.a(this.backdrop);
    }

    @Keep
    public String getLanguage() {
        return this.language;
    }

    @Keep
    public String getMetaId() {
        return this.metaId;
    }

    @Keep
    public Double getPopularity() {
        return this.popularity;
    }

    @Keep
    public String getPoster() {
        return l0.f21409a.a(this.poster);
    }

    @Keep
    public String getReleaseDate() {
        return this.releaseDate;
    }

    @Keep
    public String getTitle() {
        return this.title;
    }

    @Keep
    public int getVideoType() {
        return this.videoType;
    }

    @Keep
    public Double getVoteAverage() {
        return this.voteAverage;
    }

    public int hashCode() {
        return Objects.hash(this.metaId, this.language, Integer.valueOf(this.videoType), this.title, this.poster, this.backdrop, this.releaseDate, this.voteAverage, this.popularity);
    }

    @Keep
    public void setBackdrop(String str) {
        this.backdrop = str;
    }

    @Keep
    public void setLanguage(String str) {
        this.language = str;
    }

    @Keep
    public void setMetaId(String str) {
        this.metaId = str;
    }

    @Keep
    public void setPopularity(Double d10) {
        this.popularity = d10;
    }

    @Keep
    public void setPoster(String str) {
        this.poster = str;
    }

    @Keep
    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    @Keep
    public void setTitle(String str) {
        this.title = str;
    }

    @Keep
    public void setVideoType(int i10) {
        this.videoType = i10;
    }

    @Keep
    public void setVoteAverage(Double d10) {
        this.voteAverage = d10;
    }

    public PlaylistMetaResponse() {
        Double dValueOf = Double.valueOf(0.0d);
        this.voteAverage = dValueOf;
        this.popularity = dValueOf;
    }
}
