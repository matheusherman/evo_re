package s7;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: renamed from: s7.a, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Ls7/a;", "", "", "source", "mediaType", "sha", "", TypedValues.TransitionType.S_DURATION, "", "expireTs", "displayOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "getMediaType", "getSha", "d", "I", "e", "J", "()J", "f", "getDisplayOrder", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String source;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mediaType;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String sha;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int duration;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long expireTs;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int displayOrder;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdItem)) {
            return false;
        }
        AdItem adItem = (AdItem) other;
        return m.a(this.source, adItem.source) && m.a(this.mediaType, adItem.mediaType) && m.a(this.sha, adItem.sha) && this.duration == adItem.duration && this.expireTs == adItem.expireTs && this.displayOrder == adItem.displayOrder;
    }

    public AdItem(String str, String mediaType, String sha, int i10, long j10, int i11) {
        m.f(mediaType, "mediaType");
        m.f(sha, "sha");
        this.source = str;
        this.mediaType = mediaType;
        this.sha = sha;
        this.duration = i10;
        this.expireTs = j10;
        this.displayOrder = i11;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getExpireTs() {
        return this.expireTs;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.source;
        return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + this.sha.hashCode()) * 31) + this.duration) * 31) + androidx.collection.a.a(this.expireTs)) * 31) + this.displayOrder;
    }

    public String toString() {
        return "AdItem(source=" + this.source + ", mediaType=" + this.mediaType + ", sha=" + this.sha + ", duration=" + this.duration + ", expireTs=" + this.expireTs + ", displayOrder=" + this.displayOrder + ")";
    }
}
