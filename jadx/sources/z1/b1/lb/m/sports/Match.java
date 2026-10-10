package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b%\u0010$R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b(\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b)\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b*\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b+\u0010\u001bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b,\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b-\u0010\u001bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b1\u00100R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00105\u001a\u0004\b8\u00107R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b9\u0010$R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b:\u0010$¨\u0006;"}, d2 = {"Lz1/b1/lb/m/sports/Match;", "", "", "matchId", "tournamentId", "", NotificationCompat.CATEGORY_STATUS, "title", "subtitle", "description", "venue", "city", "countryCode", "Lz1/b1/lb/m/sports/Team;", "homeTeam", "awayTeam", "", "Lz1/b1/lb/m/sports/Channel;", "channels", "", "startAt", "endAt", "homeScore", "awayScore", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/sports/Team;Lz1/b1/lb/m/sports/Team;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "j", "Ljava/lang/String;", "getStatus", "getTitle", "getSubtitle", "d", "getVenue", "getCity", "getCountryCode", "Lz1/b1/lb/m/sports/Team;", "g", "()Lz1/b1/lb/m/sports/Team;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "Ljava/lang/Long;", "i", "()Ljava/lang/Long;", "e", "f", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Match {

    @Keep
    private final Integer awayScore;

    @Keep
    private final Team awayTeam;

    @Keep
    private final List<Channel> channels;

    @Keep
    private final String city;

    @Keep
    private final String countryCode;

    @Keep
    private final String description;

    @Keep
    private final Long endAt;

    @Keep
    private final Integer homeScore;

    @Keep
    private final Team homeTeam;

    @Keep
    private final Integer matchId;

    @Keep
    private final Long startAt;

    @Keep
    private final String status;

    @Keep
    private final String subtitle;

    @Keep
    private final String title;

    @Keep
    private final Integer tournamentId;

    @Keep
    private final String venue;

    public Match(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, Team team, Team team2, List<Channel> list, Long l10, Long l11, Integer num3, Integer num4) {
        this.matchId = num;
        this.tournamentId = num2;
        this.status = str;
        this.title = str2;
        this.subtitle = str3;
        this.description = str4;
        this.venue = str5;
        this.city = str6;
        this.countryCode = str7;
        this.homeTeam = team;
        this.awayTeam = team2;
        this.channels = list;
        this.startAt = l10;
        this.endAt = l11;
        this.homeScore = num3;
        this.awayScore = num4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Match)) {
            return false;
        }
        Match match = (Match) other;
        return m.a(this.matchId, match.matchId) && m.a(this.tournamentId, match.tournamentId) && m.a(this.status, match.status) && m.a(this.title, match.title) && m.a(this.subtitle, match.subtitle) && m.a(this.description, match.description) && m.a(this.venue, match.venue) && m.a(this.city, match.city) && m.a(this.countryCode, match.countryCode) && m.a(this.homeTeam, match.homeTeam) && m.a(this.awayTeam, match.awayTeam) && m.a(this.channels, match.channels) && m.a(this.startAt, match.startAt) && m.a(this.endAt, match.endAt) && m.a(this.homeScore, match.homeScore) && m.a(this.awayScore, match.awayScore);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getAwayScore() {
        return this.awayScore;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Team getAwayTeam() {
        return this.awayTeam;
    }

    public final List<Channel> c() {
        return this.channels;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Long getEndAt() {
        return this.endAt;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Integer getHomeScore() {
        return this.homeScore;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Team getHomeTeam() {
        return this.homeTeam;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final Integer getMatchId() {
        return this.matchId;
    }

    public int hashCode() {
        Integer num = this.matchId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.tournamentId;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.status;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.venue;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.city;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.countryCode;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Team team = this.homeTeam;
        int iHashCode10 = (iHashCode9 + (team == null ? 0 : team.hashCode())) * 31;
        Team team2 = this.awayTeam;
        int iHashCode11 = (iHashCode10 + (team2 == null ? 0 : team2.hashCode())) * 31;
        List<Channel> list = this.channels;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        Long l10 = this.startAt;
        int iHashCode13 = (iHashCode12 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.endAt;
        int iHashCode14 = (iHashCode13 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num3 = this.homeScore;
        int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.awayScore;
        return iHashCode15 + (num4 != null ? num4.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Long getStartAt() {
        return this.startAt;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final Integer getTournamentId() {
        return this.tournamentId;
    }

    public String toString() {
        return "Match(matchId=" + this.matchId + ", tournamentId=" + this.tournamentId + ", status=" + this.status + ", title=" + this.title + ", subtitle=" + this.subtitle + ", description=" + this.description + ", venue=" + this.venue + ", city=" + this.city + ", countryCode=" + this.countryCode + ", homeTeam=" + this.homeTeam + ", awayTeam=" + this.awayTeam + ", channels=" + this.channels + ", startAt=" + this.startAt + ", endAt=" + this.endAt + ", homeScore=" + this.homeScore + ", awayScore=" + this.awayScore + ")";
    }
}
