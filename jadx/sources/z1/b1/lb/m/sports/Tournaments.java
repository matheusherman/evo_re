package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lz1/b1/lb/m/sports/Tournaments;", "", "", "sportId", "", "Lz1/b1/lb/m/sports/Tournament;", "tournaments", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getSportId", "()Ljava/lang/Integer;", "Ljava/util/List;", "a", "()Ljava/util/List;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Tournaments {

    @Keep
    private final Integer sportId;

    @Keep
    private final List<Tournament> tournaments;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tournaments)) {
            return false;
        }
        Tournaments tournaments = (Tournaments) other;
        return m.a(this.sportId, tournaments.sportId) && m.a(this.tournaments, tournaments.tournaments);
    }

    public final List<Tournament> a() {
        return this.tournaments;
    }

    public int hashCode() {
        Integer num = this.sportId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<Tournament> list = this.tournaments;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Tournaments(sportId=" + this.sportId + ", tournaments=" + this.tournaments + ")";
    }

    public Tournaments(Integer num, List<Tournament> list) {
        this.sportId = num;
        this.tournaments = list;
    }
}
