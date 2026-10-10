package u7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: renamed from: u7.i, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0018\u0010\u001f\"\u0004\b\u0015\u0010 ¨\u0006!"}, d2 = {"Lu7/i;", "Lu7/a;", "", "column", "videoTitle", "epgContent", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/meta/ChannelStreamResponse;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getColumn", "b", "e", "c", "d", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "()Lz1/b1/lb/m/meta/ChannelStreamResponse;", "Z", "()Z", "(Z)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StoryListData implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String column;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String videoTitle;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String epgContent;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ChannelStreamResponse response;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoryListData)) {
            return false;
        }
        StoryListData storyListData = (StoryListData) other;
        return m.a(this.column, storyListData.column) && m.a(this.videoTitle, storyListData.videoTitle) && m.a(this.epgContent, storyListData.epgContent) && m.a(this.response, storyListData.response) && this.selected == storyListData.selected;
    }

    public StoryListData(String column, String videoTitle, String epgContent, ChannelStreamResponse response, boolean z10) {
        m.f(column, "column");
        m.f(videoTitle, "videoTitle");
        m.f(epgContent, "epgContent");
        m.f(response, "response");
        this.column = column;
        this.videoTitle = videoTitle;
        this.epgContent = epgContent;
        this.response = response;
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
    public final String getEpgContent() {
        return this.epgContent;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final ChannelStreamResponse getResponse() {
        return this.response;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    public int hashCode() {
        return (((((((this.column.hashCode() * 31) + this.videoTitle.hashCode()) * 31) + this.epgContent.hashCode()) * 31) + this.response.hashCode()) * 31) + androidx.paging.a.a(this.selected);
    }

    public String toString() {
        return "StoryListData(column=" + this.column + ", videoTitle=" + this.videoTitle + ", epgContent=" + this.epgContent + ", response=" + this.response + ", selected=" + this.selected + ")";
    }
}
