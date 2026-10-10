package x1.f1.lb.ad;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: x1.f1.lb.ad.a, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019¨\u0006\u001a"}, d2 = {"Lx1/f1/lb/ad/a;", "", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "isVideo", "Ljava/io/File;", "file", "<init>", "(IZLjava/io/File;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Z", "c", "()Z", "Ljava/io/File;", "()Ljava/io/File;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isVideo;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final File file;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdItem)) {
            return false;
        }
        AdItem adItem = (AdItem) other;
        return this.id == adItem.id && this.isVideo == adItem.isVideo && m.a(this.file, adItem.file);
    }

    public AdItem(int i10, boolean z10, File file) {
        m.f(file, "file");
        this.id = i10;
        this.isVideo = z10;
        this.file = file;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public int hashCode() {
        return (((this.id * 31) + androidx.paging.a.a(this.isVideo)) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "AdItem(id=" + this.id + ", isVideo=" + this.isVideo + ", file=" + this.file + ")";
    }
}
