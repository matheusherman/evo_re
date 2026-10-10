package com.live.evo.catchup.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.e;
import com.live.evo.util.o0;
import com.live.evo.util.t;
import com.live.evo.util.v;
import java.io.File;
import java.util.regex.Pattern;
import x4.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a extends com.live.evo.widget.ijkmedia.b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private SeekBar K;
    private Context L;
    private ImageButton M;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f5634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f5635w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f5636x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f5637y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f5638z;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = context;
    }

    public ImageButton getPauseButton() {
        return this.M;
    }

    public a(Context context) {
        super(context);
        this.L = context;
    }

    private void B() {
        if (e.b().a()) {
            t.c(this.f5635w);
            t.c(this.f5636x);
            t.b(this.A);
            t.b(this.B);
            t.b(this.C);
            t.b(this.f5637y);
            t.b(this.D);
            t.b(this.f5638z);
            t.c(this.E);
            t.c(this.F);
            t.c(this.G);
            t.c(this.H);
            t.c(this.I);
            t.b(this.J);
            return;
        }
        t.b(this.f5635w);
        t.c(this.f5636x);
        t.c(this.A);
        t.c(this.B);
        t.b(this.C);
        t.b(this.f5637y);
        t.b(this.D);
        t.b(this.f5638z);
        t.c(this.E);
        t.c(this.F);
        t.c(this.G);
        t.c(this.H);
        t.c(this.I);
        t.b(this.J);
    }

    @SuppressLint({"SetTextI18n"})
    public void C(c cVar) {
        v.d(getContext(), cVar.i(), this.f5634v);
        String.valueOf(cVar.d() + 1);
        this.f5636x.setText(cVar.c());
        this.f5637y.setText(cVar.f());
        this.f5638z.setText(cVar.j());
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected int getLayoutId() {
        return R$layout.live_catch_up_media_controller;
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected Drawable getPauseIconDrawable() {
        return getContext().getResources().getDrawable(R$drawable.play_pause_none);
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected int getPauseIconId() {
        return R$drawable.play_pause_none;
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected Drawable getPlayIconDrawable() {
        Drawable drawableCreateFromPath;
        String strS = o0.p().s();
        if (!TextUtils.isEmpty(strS) && new File(strS).exists()) {
            drawableCreateFromPath = Drawable.createFromPath(strS);
        } else {
            drawableCreateFromPath = null;
        }
        if (drawableCreateFromPath == null) {
            return getContext().getResources().getDrawable(R$drawable.play_icon);
        }
        return drawableCreateFromPath;
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected int getPlayIconId() {
        return R$drawable.play_icon;
    }

    @Override // com.live.evo.widget.ijkmedia.b
    protected void u(View view) {
        super.u(view);
        this.f5634v = (ImageView) view.findViewById(R$id.channel_logo);
        this.f5635w = (TextView) view.findViewById(R$id.channel_programpos);
        this.f5636x = (TextView) view.findViewById(R$id.channel_name);
        this.f5637y = (TextView) view.findViewById(R$id.current_program);
        this.f5638z = (TextView) view.findViewById(R$id.next_program);
        this.A = (TextView) view.findViewById(R$id.mediacontroller_time_current);
        this.B = (TextView) view.findViewById(R$id.mediacontroller_time_total);
        this.K = (SeekBar) view.findViewById(R$id.mediacontroller_seekbar);
        this.C = (TextView) view.findViewById(R$id.catchup_current);
        this.D = (TextView) view.findViewById(R$id.catchup_next);
        this.E = (TextView) view.findViewById(R$id.catchup_rewind);
        this.F = (TextView) view.findViewById(R$id.catchup_pause);
        this.G = (TextView) view.findViewById(R$id.catchup_forward);
        this.H = (TextView) view.findViewById(R$id.catchup_info);
        this.I = (TextView) view.findViewById(R$id.catchup_back);
        this.J = (TextView) view.findViewById(R$id.catchup_sessionid);
        this.M = (ImageButton) view.findViewById(R$id.mediacontroller_play_pause);
        String strT = o0.p().t();
        if (!TextUtils.isEmpty(strT)) {
            String strReplace = strT.replace(",", "");
            if (Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strReplace)) {
                this.K.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor(strReplace)), 19, 1));
                this.K.setBackgroundColor(this.L.getResources().getColor(R$color.progressbar_playback_background));
            }
        }
        String strU = o0.p().u();
        if (!TextUtils.isEmpty(strU) && !TextUtils.isEmpty(strU) && Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strU)) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.K.getThumb();
            gradientDrawable.setColor(Color.parseColor(strU));
            this.K.setThumb(gradientDrawable);
        }
        B();
    }
}
