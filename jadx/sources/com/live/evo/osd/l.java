package com.live.evo.osd;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.widget.LoadView;
import com.live.evo.widget.sloading.SLoadingView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoadView f7111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SLoadingView f7113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f7115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7118i;

    public l(Context context, View view, int i10, boolean z10) {
        this.f7117h = false;
        this.f7118i = false;
        this.f7114e = context.getString(i10);
        this.f7115f = (LinearLayout) view.findViewById(R$id.livenewa_ll_loading);
        this.f7112c = (TextView) view.findViewById(R$id.livenewa_tv_program_prompt);
        this.f7113d = (SLoadingView) view.findViewById(R$id.livenewa_slv);
        this.f7111b = (LoadView) view.findViewById(R$id.livenewa_lv_program_loadview);
        this.f7116g = z10;
        c(3);
        this.f7113d.setLoadingBuilder(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.f7112c);
        } else {
            com.live.evo.util.t.c(this.f7112c);
        }
    }

    public void f() {
        this.f7118i = false;
        this.f7112c.setVisibility(8);
        this.f7113d.setVisibility(8);
    }

    public void g() {
        this.f7117h = false;
        this.f7111b.setVisibility(8);
    }

    public void j() {
        this.f7118i = true;
        this.f7112c.setVisibility(0);
        this.f7112c.setText(this.f7114e);
        this.f7113d.setVisibility(0);
    }

    public void k() {
        this.f7117h = true;
        this.f7111b.setVisibility(0);
    }

    @Override // com.live.evo.osd.g
    public int b() {
        if (this.f7112c.getText().equals(this.f7114e)) {
            return this.f7112c.getVisibility();
        }
        return 8;
    }

    @Override // com.live.evo.osd.g
    public void d(int i10) {
        if (i10 == 0) {
            this.f7112c.setText(this.f7114e);
        } else if (!this.f7112c.getText().equals(this.f7114e)) {
            return;
        }
        this.f7112c.setVisibility(i10);
        if (this.f7116g) {
            this.f7115f.setVisibility(i10);
            this.f7113d.setVisibility(i10);
        } else {
            this.f7115f.setVisibility(8);
            this.f7113d.setVisibility(8);
        }
    }

    public boolean e() {
        return this.f7117h;
    }

    public void h(String str) {
        this.f7114e = str;
    }

    public void i(String str) {
        this.f7111b.setText(str);
    }

    public l(Context context, View view, int i10) {
        this(context, view, i10, false);
    }
}
