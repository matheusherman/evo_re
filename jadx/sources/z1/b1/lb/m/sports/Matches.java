package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lz1/b1/lb/m/sports/Matches;", "", "", "tournamentId", "", "date", "", "Lz1/b1/lb/m/sports/Match;", "matches", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Ljava/lang/String;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Matches {

    @Keep
    private final String date;

    @Keep
    private final List<Match> matches;

    @Keep
    private final Integer tournamentId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Matches)) {
            return false;
        }
        Matches matches = (Matches) other;
        return m.a(this.tournamentId, matches.tournamentId) && m.a(this.date, matches.date) && m.a(this.matches, matches.matches);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final List<Match> b() {
        return this.matches;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Integer getTournamentId() {
        return this.tournamentId;
    }

    public int hashCode() {
        Integer num = this.tournamentId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.date;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Match> list = this.matches;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Matches(tournamentId=" + this.tournamentId + ", date=" + this.date + ", matches=" + this.matches + ")";
    }

    public Matches(Integer num, String str, List<Match> list) {
        this.tournamentId = num;
        this.date = str;
        this.matches = list;
    }
}
