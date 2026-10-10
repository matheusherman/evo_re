package u7;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: renamed from: u7.c, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lu7/c;", "Lu7/a;", "Lz1/b1/lb/m/meta/EPGProgramme;", "", "hasCatchup", IjkMediaMeta.IJKM_KEY_SELECTED, "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "c", "()Z", "d", "(Z)V", "b", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EpgData extends EPGProgramme implements a {
    private boolean hasCatchup;
    private boolean selected;

    /* JADX WARN: Illegal instructions before constructor call */
    public EpgData() {
        boolean z10 = false;
        this(z10, z10, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpgData)) {
            return false;
        }
        EpgData epgData = (EpgData) other;
        return this.hasCatchup == epgData.hasCatchup && this.selected == epgData.selected;
    }

    public /* synthetic */ EpgData(boolean z10, boolean z11, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
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
    public final boolean getHasCatchup() {
        return this.hasCatchup;
    }

    public final void d(boolean z10) {
        this.hasCatchup = z10;
    }

    public int hashCode() {
        return (androidx.paging.a.a(this.hasCatchup) * 31) + androidx.paging.a.a(this.selected);
    }

    @Override // n6.a
    public String toString() {
        return "EpgData(hasCatchup=" + this.hasCatchup + ", selected=" + this.selected + ")";
    }

    public EpgData(boolean z10, boolean z11) {
        this.hasCatchup = z10;
        this.selected = z11;
    }
}
