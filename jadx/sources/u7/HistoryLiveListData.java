package u7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: u7.e, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d\"\u0004\b\u0014\u0010\u001e¨\u0006\u001f"}, d2 = {"Lu7/e;", "Lu7/a;", "", "name", "iconUrl", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "key", "", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "f", "b", "c", "d", "I", "e", "Z", "()Z", "(Z)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HistoryLiveListData implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String iconUrl;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String id;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int key;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public HistoryLiveListData(String name, String iconUrl, String id2, int i10, boolean z10) {
        m.f(name, "name");
        m.f(iconUrl, "iconUrl");
        m.f(id2, "id");
        this.name = name;
        this.iconUrl = iconUrl;
        this.id = id2;
        this.key = i10;
        this.selected = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryLiveListData)) {
            return false;
        }
        HistoryLiveListData historyLiveListData = (HistoryLiveListData) other;
        return m.a(this.name, historyLiveListData.name) && m.a(this.iconUrl, historyLiveListData.iconUrl) && m.a(this.id, historyLiveListData.id) && this.key == historyLiveListData.key && this.selected == historyLiveListData.selected;
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
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.id.hashCode()) * 31) + this.key) * 31) + androidx.paging.a.a(this.selected);
    }

    public String toString() {
        return "HistoryLiveListData(name=" + this.name + ", iconUrl=" + this.iconUrl + ", id=" + this.id + ", key=" + this.key + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ HistoryLiveListData(String str, String str2, String str3, int i10, boolean z10, int i11, kotlin.jvm.internal.g gVar) {
        this(str, str2, str3, i10, (i11 & 16) != 0 ? false : z10);
    }
}
