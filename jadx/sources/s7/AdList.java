package s7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: renamed from: s7.b, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0017"}, d2 = {"Ls7/b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "Ls7/a;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "start_up", "channel_page", "c", "getPause", "pause", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AdList {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AdItem> start_up;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AdItem> channel_page;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AdItem> pause;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdList)) {
            return false;
        }
        AdList adList = (AdList) other;
        return m.a(this.start_up, adList.start_up) && m.a(this.channel_page, adList.channel_page) && m.a(this.pause, adList.pause);
    }

    public final List<AdItem> a() {
        return this.channel_page;
    }

    public final List<AdItem> b() {
        return this.start_up;
    }

    public int hashCode() {
        List<AdItem> list = this.start_up;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<AdItem> list2 = this.channel_page;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<AdItem> list3 = this.pause;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "AdList(start_up=" + this.start_up + ", channel_page=" + this.channel_page + ", pause=" + this.pause + ")";
    }
}
