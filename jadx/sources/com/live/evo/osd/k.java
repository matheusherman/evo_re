package com.live.evo.osd;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7110d;

    @Override // com.live.evo.osd.g
    public int b() {
        if (this.f7109c.getText().equals(this.f7110d)) {
            return this.f7109c.getVisibility();
        }
        return 8;
    }

    @Override // com.live.evo.osd.g
    public void d(int i10) {
        if (i10 == 0) {
            this.f7109c.setText(this.f7110d);
        } else if (!this.f7109c.getText().equals(this.f7110d)) {
            return;
        }
        this.f7109c.setVisibility(i10);
    }

    public k(Context context, View view, int i10) {
        this.f7110d = context.getString(i10);
        this.f7108b = view;
        this.f7109c = (TextView) view.findViewById(R$id.livenewa_tv_program_optimizing);
        c(3);
    }
}
