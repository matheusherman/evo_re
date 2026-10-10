package x1.f1.lb.media.model;

import androidx.annotation.Keep;
import androidx.collection.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u000eR\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001c\u0010\u000eR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lx1/f1/lb/media/model/SubscribeItem;", "", "", "sportId", "", "start", "stop", "title", "desc", "", "isAvailable", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "b", "J", "c", "()J", "d", "e", "a", "Z", "f", "()Z", "g", "(Z)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscribeItem {

    @Keep
    private final String desc;

    @Keep
    private boolean isAvailable;

    @Keep
    private final String sportId;

    @Keep
    private final long start;

    @Keep
    private final long stop;

    @Keep
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscribeItem)) {
            return false;
        }
        SubscribeItem subscribeItem = (SubscribeItem) other;
        return m.a(this.sportId, subscribeItem.sportId) && this.start == subscribeItem.start && this.stop == subscribeItem.stop && m.a(this.title, subscribeItem.title) && m.a(this.desc, subscribeItem.desc) && this.isAvailable == subscribeItem.isAvailable;
    }

    public SubscribeItem(String sportId, long j10, long j11, String title, String desc, boolean z10) {
        m.f(sportId, "sportId");
        m.f(title, "title");
        m.f(desc, "desc");
        this.sportId = sportId;
        this.start = j10;
        this.stop = j11;
        this.title = title;
        this.desc = desc;
        this.isAvailable = z10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSportId() {
        return this.sportId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getStop() {
        return this.stop;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getIsAvailable() {
        return this.isAvailable;
    }

    public final void g(boolean z10) {
        this.isAvailable = z10;
    }

    public int hashCode() {
        return (((((((((this.sportId.hashCode() * 31) + a.a(this.start)) * 31) + a.a(this.stop)) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + androidx.paging.a.a(this.isAvailable);
    }

    public String toString() {
        return "SubscribeItem(sportId=" + this.sportId + ", start=" + this.start + ", stop=" + this.stop + ", title=" + this.title + ", desc=" + this.desc + ", isAvailable=" + this.isAvailable + ")";
    }
}
