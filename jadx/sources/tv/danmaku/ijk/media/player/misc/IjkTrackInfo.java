package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb2 = new StringBuilder(128);
        int i10 = this.mTrackType;
        if (i10 == 1) {
            sb2.append("VIDEO");
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getCodecShortNameInline());
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getBitrateInline());
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getResolutionInline());
        } else if (i10 == 2) {
            sb2.append("AUDIO");
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getCodecShortNameInline());
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getBitrateInline());
            sb2.append(", ");
            sb2.append(this.mStreamMeta.getSampleRateInline());
        } else if (i10 == 3) {
            sb2.append("TIMEDTEXT");
            sb2.append(", ");
            sb2.append(this.mStreamMeta.mLanguage);
        } else if (i10 != 4) {
            sb2.append("UNKNOWN");
        } else {
            sb2.append("SUBTITLE");
        }
        return sb2.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        return (ijkStreamMeta == null || TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i10) {
        this.mTrackType = i10;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }
}
