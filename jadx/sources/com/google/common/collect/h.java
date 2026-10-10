package com.google.common.collect;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h {
    static StringBuilder a(int i10) {
        g.b(i10, "size");
        return new StringBuilder((int) Math.min(((long) i10) * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
    }
}
