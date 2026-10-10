package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017¨\u0006\u001f"}, d2 = {"Lz1/b1/lb/m/sports/Sports;", "", "", "defaultSportId", "defaultTournamentId", "", "todayDate", "", "Lz1/b1/lb/m/sports/Sport;", "sports", "version", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "b", "Ljava/lang/String;", "d", "Ljava/util/List;", "c", "()Ljava/util/List;", "e", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Sports {

    @Keep
    private final Integer defaultSportId;

    @Keep
    private final Integer defaultTournamentId;

    @Keep
    private final List<Sport> sports;

    @Keep
    private final String todayDate;

    @Keep
    private final Integer version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sports)) {
            return false;
        }
        Sports sports = (Sports) other;
        return m.a(this.defaultSportId, sports.defaultSportId) && m.a(this.defaultTournamentId, sports.defaultTournamentId) && m.a(this.todayDate, sports.todayDate) && m.a(this.sports, sports.sports) && m.a(this.version, sports.version);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getDefaultSportId() {
        return this.defaultSportId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getDefaultTournamentId() {
        return this.defaultTournamentId;
    }

    public final List<Sport> c() {
        return this.sports;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getTodayDate() {
        return this.todayDate;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Integer num = this.defaultSportId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.defaultTournamentId;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.todayDate;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<Sport> list = this.sports;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.version;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "Sports(defaultSportId=" + this.defaultSportId + ", defaultTournamentId=" + this.defaultTournamentId + ", todayDate=" + this.todayDate + ", sports=" + this.sports + ", version=" + this.version + ")";
    }

    public Sports(Integer num, Integer num2, String str, List<Sport> list, Integer num3) {
        this.defaultSportId = num;
        this.defaultTournamentId = num2;
        this.todayDate = str;
        this.sports = list;
        this.version = num3;
    }
}
