package u7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: u7.f, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u000fR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b\u0019\u0010!\"\u0004\b\u0016\u0010\"¨\u0006#"}, d2 = {"Lu7/f;", "Lu7/a;", "", "name", "iconUrl", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "key", "channelNum", "content", "", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "g", "b", "e", "c", "f", "d", "I", "getKey", "Z", "()Z", "(Z)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LiveSearchListData implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String iconUrl;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String id;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int key;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String channelNum;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String content;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public LiveSearchListData(String name, String iconUrl, String id2, int i10, String channelNum, String content, boolean z10) {
        m.f(name, "name");
        m.f(iconUrl, "iconUrl");
        m.f(id2, "id");
        m.f(channelNum, "channelNum");
        m.f(content, "content");
        this.name = name;
        this.iconUrl = iconUrl;
        this.id = id2;
        this.key = i10;
        this.channelNum = channelNum;
        this.content = content;
        this.selected = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveSearchListData)) {
            return false;
        }
        LiveSearchListData liveSearchListData = (LiveSearchListData) other;
        return m.a(this.name, liveSearchListData.name) && m.a(this.iconUrl, liveSearchListData.iconUrl) && m.a(this.id, liveSearchListData.id) && this.key == liveSearchListData.key && m.a(this.channelNum, liveSearchListData.channelNum) && m.a(this.content, liveSearchListData.content) && this.selected == liveSearchListData.selected;
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
    public final String getChannelNum() {
        return this.channelNum;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.id.hashCode()) * 31) + this.key) * 31) + this.channelNum.hashCode()) * 31) + this.content.hashCode()) * 31) + androidx.paging.a.a(this.selected);
    }

    public String toString() {
        return "LiveSearchListData(name=" + this.name + ", iconUrl=" + this.iconUrl + ", id=" + this.id + ", key=" + this.key + ", channelNum=" + this.channelNum + ", content=" + this.content + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ LiveSearchListData(String str, String str2, String str3, int i10, String str4, String str5, boolean z10, int i11, kotlin.jvm.internal.g gVar) {
        this(str, str2, str3, i10, str4, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? true : z10);
    }
}
