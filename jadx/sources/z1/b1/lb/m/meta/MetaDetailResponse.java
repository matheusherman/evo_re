package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MetaDetailResponse extends PlaylistMetaResponse {
    private List<String> casts;
    private List<String> directors;
    private List<String> genres;
    private String overview;
    private List<PlaylistMetaResponse> recommendations;
    private int runtime;
    private List<Integer> seasons = new ArrayList();
    private int type;

    @Keep
    public List<String> getCasts() {
        return this.casts;
    }

    @Keep
    public List<String> getDirectors() {
        return this.directors;
    }

    @Keep
    public List<String> getGenres() {
        return this.genres;
    }

    @Keep
    public String getOverview() {
        return this.overview;
    }

    @Keep
    public List<PlaylistMetaResponse> getRecommendations() {
        return this.recommendations;
    }

    @Keep
    public int getRuntime() {
        return this.runtime;
    }

    @Keep
    public List<Integer> getSeasons() {
        return this.seasons;
    }

    @Keep
    public int getType() {
        return this.type;
    }

    @Keep
    public void setCasts(List<String> list) {
        this.casts = list;
    }

    @Keep
    public void setDirectors(List<String> list) {
        this.directors = list;
    }

    @Keep
    public void setGenres(List<String> list) {
        this.genres = list;
    }

    @Keep
    public void setOverview(String str) {
        this.overview = str;
    }

    @Keep
    public void setRecommendations(List<PlaylistMetaResponse> list) {
        this.recommendations = list;
    }

    @Keep
    public void setRuntime(int i10) {
        this.runtime = i10;
    }

    @Keep
    public void setSeasons(List<Integer> list) {
        this.seasons = list;
    }

    @Keep
    public void setType(int i10) {
        this.type = i10;
    }
}
