package com.live.evo.osd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@SuppressLint({"HandlerLeak"})
public class j extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f7103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearLayout f7104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7105f = "1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f7106g = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4097) {
                return;
            }
            j.this.d(8);
        }
    }

    @Override // com.live.evo.osd.g
    public int b() {
        return this.f7104e.getVisibility();
    }

    @Override // com.live.evo.osd.g
    public void d(int i10) {
        this.f7104e.setVisibility(i10);
        if (i10 == 8) {
            return;
        }
        this.f7106g.removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.f7106g.sendEmptyMessageDelayed(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 10000L);
    }

    public String e() {
        return this.f7102c.getText().toString();
    }

    public int f() {
        try {
            return Integer.valueOf(this.f7105f).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public j(Context context, View view) {
        this.f7101b = view;
        this.f7104e = (LinearLayout) view.findViewById(R$id.livenewa_ll_program_name_container);
        this.f7102c = (TextView) this.f7101b.findViewById(R$id.livenewa_tv_program_id);
        this.f7103d = (TextView) this.f7101b.findViewById(R$id.livenewa_tv_program_name);
        c(3);
        TextPaint paint = this.f7102c.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setFakeBoldText(false);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.f7102c);
            com.live.evo.util.t.c(this.f7103d);
        } else {
            com.live.evo.util.t.b(this.f7102c);
            com.live.evo.util.t.a(this.f7103d);
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7105f = str;
    }

    public void h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7105f = str;
        int i10 = Integer.parseInt(str);
        this.f7102c.setText((i10 + 1) + "");
        this.f7103d.setText(str2);
    }
}
