package com.google.android.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(17)
public final class DummySurface extends Surface {
    @Override // android.view.Surface
    public void release() {
        super.release();
        throw null;
    }
}
