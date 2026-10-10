package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u0010R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lz1/b1/lb/m/sports/Sport;", "", "", "sportId", "", "slug", "name", "iconUrl", "", "Lz1/b1/lb/m/sports/Tournament;", "tournaments", "", "default", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Ljava/lang/String;", "d", "c", "b", "Ljava/util/List;", "f", "()Ljava/util/List;", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Sport {

    @Keep
    private final Boolean default;

    @Keep
    private final String iconUrl;

    @Keep
    private final String name;

    @Keep
    private final String slug;

    @Keep
    private final Integer sportId;

    @Keep
    private final List<Tournament> tournaments;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sport)) {
            return false;
        }
        Sport sport = (Sport) other;
        return m.a(this.sportId, sport.sportId) && m.a(this.slug, sport.slug) && m.a(this.name, sport.name) && m.a(this.iconUrl, sport.iconUrl) && m.a(this.tournaments, sport.tournaments) && m.a(this.default, sport.default);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getSportId() {
        return this.sportId;
    }

    public final List<Tournament> f() {
        return this.tournaments;
    }

    public int hashCode() {
        Integer num = this.sportId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.slug;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Tournament> list = this.tournaments;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.default;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "Sport(sportId=" + this.sportId + ", slug=" + this.slug + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", tournaments=" + this.tournaments + ", default=" + this.default + ")";
    }

    public Sport(Integer num, String str, String str2, String str3, List<Tournament> list, Boolean bool) {
        this.sportId = num;
        this.slug = str;
        this.name = str2;
        this.iconUrl = str3;
        this.tournaments = list;
        this.default = bool;
    }
}
