package x1.f1.lb.api;

import gf.s;
import gf.t;
import kotlin.Metadata;
import z1.b1.lb.m.sports.DataVersion;
import z1.b1.lb.m.sports.Matches;
import z1.b1.lb.m.sports.Sports;
import z1.b1.lb.m.sports.Tournaments;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H§@¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\u0007J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lx1/f1/lb/api/j;", "", "", "lastVersion", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/DataVersion;", "c", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/sports/Sports;", "a", "(Lv8/f;)Ljava/lang/Object;", "sportId", "Lz1/b1/lb/m/sports/Tournaments;", "d", "tournamentId", "date", "Lz1/b1/lb/m/sports/Matches;", "b", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface j {
    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/sports/home")
    Object a(v8.f<? super com.skydoves.sandwich.a<Sports>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/tournaments/{tournamentId}/matches")
    Object b(@s("tournamentId") String str, @t("date") String str2, v8.f<? super com.skydoves.sandwich.a<Matches>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/data/version")
    Object c(@t("lastVersion") String str, v8.f<? super com.skydoves.sandwich.a<DataVersion>> fVar);

    @gf.k({"Content-Type: application/json;charset=UTF-8"})
    @gf.f("/api/v1/sports/{sportId}/tournaments")
    Object d(@s("sportId") String str, v8.f<? super com.skydoves.sandwich.a<Tournaments>> fVar);
}
