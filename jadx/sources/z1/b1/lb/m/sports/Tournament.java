package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lz1/b1/lb/m/sports/Tournament;", "", "", "tournamentId", "", "name", "seasonCode", "", "Lz1/b1/lb/m/sports/Match;", "matchList", "", "default", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Ljava/lang/String;", "c", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Tournament {

    @Keep
    private final Boolean default;

    @Keep
    private final List<Match> matchList;

    @Keep
    private final String name;

    @Keep
    private final String seasonCode;

    @Keep
    private final Integer tournamentId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tournament)) {
            return false;
        }
        Tournament tournament = (Tournament) other;
        return m.a(this.tournamentId, tournament.tournamentId) && m.a(this.name, tournament.name) && m.a(this.seasonCode, tournament.seasonCode) && m.a(this.matchList, tournament.matchList) && m.a(this.default, tournament.default);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getDefault() {
        return this.default;
    }

    public final List<Match> b() {
        return this.matchList;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getSeasonCode() {
        return this.seasonCode;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getTournamentId() {
        return this.tournamentId;
    }

    public int hashCode() {
        Integer num = this.tournamentId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.seasonCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Match> list = this.matchList;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.default;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "Tournament(tournamentId=" + this.tournamentId + ", name=" + this.name + ", seasonCode=" + this.seasonCode + ", matchList=" + this.matchList + ", default=" + this.default + ")";
    }

    public Tournament(Integer num, String str, String str2, List<Match> list, Boolean bool) {
        this.tournamentId = num;
        this.name = str;
        this.seasonCode = str2;
        this.matchList = list;
        this.default = bool;
    }
}
