package com.live.evo.osd;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f7100c;

    @Override // com.live.evo.osd.g
    public int b() {
        return this.f7100c.getVisibility();
    }

    @Override // com.live.evo.osd.g
    public void d(int i10) {
        this.f7100c.setVisibility(i10);
    }

    public i(Context context, View view) {
        this.f7099b = view;
        this.f7100c = (LinearLayout) view.findViewById(R$id.livenewa_ll_osd_network_prompt);
        c(3);
    }
}
