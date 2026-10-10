package u7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: u7.d, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b\"\u0004\b\u0013\u0010\u001c¨\u0006\u001d"}, d2 = {"Lu7/d;", "Lu7/a;", "", "date", "", "timestamp", "", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(Ljava/lang/String;JZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "J", "d", "()J", "Z", "()Z", "(Z)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EpgDateData implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String date;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timestamp;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpgDateData)) {
            return false;
        }
        EpgDateData epgDateData = (EpgDateData) other;
        return m.a(this.date, epgDateData.date) && this.timestamp == epgDateData.timestamp && this.selected == epgDateData.selected;
    }

    public EpgDateData(String date, long j10, boolean z10) {
        m.f(date, "date");
        this.date = date;
        this.timestamp = j10;
        this.selected = z10;
    }

    @Override // u7.a
    public void a(boolean z10) {
        this.selected = z10;
    }

    @Override // u7.a
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + androidx.collection.a.a(this.timestamp)) * 31) + androidx.paging.a.a(this.selected);
    }

    public String toString() {
        return "EpgDateData(date=" + this.date + ", timestamp=" + this.timestamp + ", selected=" + this.selected + ")";
    }
}
