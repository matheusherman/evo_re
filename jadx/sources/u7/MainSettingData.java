package u7;

import androidx.annotation.DrawableRes;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: u7.g, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\rR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d¨\u0006\u001e"}, d2 = {"Lu7/g;", "", "", "icon", "", "content", "Lkotlin/Function0;", "tipMsg", "", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(ILjava/lang/String;Lc9/a;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "c", "Lc9/a;", "getTipMsg", "()Lc9/a;", "d", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MainSettingData {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int icon;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String content;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final c9.a<String> tipMsg;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Boolean selected;

    public MainSettingData(@DrawableRes int i10, String content, c9.a<String> aVar, Boolean bool) {
        m.f(content, "content");
        this.icon = i10;
        this.content = content;
        this.tipMsg = aVar;
        this.selected = bool;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainSettingData)) {
            return false;
        }
        MainSettingData mainSettingData = (MainSettingData) other;
        return this.icon == mainSettingData.icon && m.a(this.content, mainSettingData.content) && m.a(this.tipMsg, mainSettingData.tipMsg) && m.a(this.selected, mainSettingData.selected);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    public int hashCode() {
        int iHashCode = ((this.icon * 31) + this.content.hashCode()) * 31;
        c9.a<String> aVar = this.tipMsg;
        int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        Boolean bool = this.selected;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MainSettingData(icon=" + this.icon + ", content=" + this.content + ", tipMsg=" + this.tipMsg + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ MainSettingData(int i10, String str, c9.a aVar, Boolean bool, int i11, kotlin.jvm.internal.g gVar) {
        this(i10, str, (i11 & 4) != 0 ? null : aVar, (i11 & 8) != 0 ? null : bool);
    }
}
