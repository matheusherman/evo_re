package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lz1/b1/lb/m/sports/DataVersion;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "changed", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "version", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "updatedAtEpochMs", "Ljava/lang/Long;", "getUpdatedAtEpochMs", "()Ljava/lang/Long;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DataVersion {

    @Keep
    private final Boolean changed;

    @Keep
    private final Long updatedAtEpochMs;

    @Keep
    private final Integer version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataVersion)) {
            return false;
        }
        DataVersion dataVersion = (DataVersion) other;
        return m.a(this.changed, dataVersion.changed) && m.a(this.version, dataVersion.version) && m.a(this.updatedAtEpochMs, dataVersion.updatedAtEpochMs);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getChanged() {
        return this.changed;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Boolean bool = this.changed;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.version;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.updatedAtEpochMs;
        return iHashCode2 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        return "DataVersion(changed=" + this.changed + ", version=" + this.version + ", updatedAtEpochMs=" + this.updatedAtEpochMs + ")";
    }
}
