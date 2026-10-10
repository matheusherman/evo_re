package com.live.evo.catchup.LargeEpg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.live.evo.R$color;
import com.live.evo.R$dimen;
import com.live.evo.l;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import i5.h;
import i5.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EpgView extends a {
    private long A;
    private long B;
    private long C;
    private long D;
    private int E;
    private List<Integer> F;
    private Rect G;
    private Rect H;
    private Rect I;
    private Paint J;
    private Canvas K;
    private boolean L;
    private Rect M;
    private List<String> N;
    private Map<String, i> O;
    private Map<String, h> P;
    private Map<String, List<h>> Q;
    private Point R;
    private int S;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f5613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f5614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f5615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f5616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f5617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f5618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5625y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5626z;

    public EpgView(Context context) {
        this(context, null);
    }

    private long c(int i10) {
        return (((long) i10) * this.A) + this.B;
    }

    public EpgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int d(long j10) {
        return (int) (((j10 - this.B) / this.A) + ((long) this.E));
    }

    private int getFirstVisibleCategoryPosition() {
        return Math.max(this.N.indexOf(this.f5632f) - (this.R.y / (this.f5614n + this.f5611k)), 0);
    }

    private int getLastVisibleCategoryPosition() {
        return Math.min(this.N.indexOf(this.f5632f) + ((getHeight() - (this.R.y + (this.f5614n + this.f5611k))) / (this.f5614n + this.f5611k)), (((getHeight() - this.f5617q) - this.f5618r) / (this.f5614n + this.f5611k)) - 1);
    }

    void e() {
        this.R = new Point(getScrollX(), getScrollY());
        this.f5608h = l.n().g("epg_cache_size", 20);
        this.N = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        s0 s0Var = s0.f7342a;
        this.O = s0Var.t();
        this.P = s0Var.u();
        this.Q = s0Var.C();
        this.f5609i = getResources().getDimensionPixelSize(R$dimen.epg_view_category_width);
        this.f5610j = getResources().getDimensionPixelSize(R$dimen.epg_view_channel_width);
        this.f5611k = getResources().getDimensionPixelOffset(R$dimen.epg_view_space_width);
        this.f5613m = getResources().getDimension(R$dimen.epg_view_normal_text_size);
        this.f5614n = getResources().getDimensionPixelSize(R$dimen.epg_view_channel_height);
        this.f5615o = getResources().getDimensionPixelSize(R$dimen.epg_view_channel_img_width);
        this.f5616p = getResources().getDimensionPixelSize(R$dimen.epg_view_channel_img_height);
        this.f5617q = getResources().getDimensionPixelSize(R$dimen.epg_view_timebar_height);
        this.f5618r = getResources().getDimensionPixelSize(R$dimen.epg_view_date_height);
        this.f5624x = getResources().getDimensionPixelSize(R$dimen.epg_view_category_padding);
        this.f5625y = getResources().getDimensionPixelSize(R$dimen.epg_view_channel_padding);
        this.f5626z = getResources().getDimensionPixelSize(R$dimen.epg_view_epg_padding);
        this.f5619s = getResources().getColor(R$color.epg_view_epg_default_background_color);
        this.f5620t = getResources().getColor(R$color.epg_view_epg_playing_background_color);
        this.f5621u = getResources().getColor(R$color.epg_view_time_line_color);
        this.f5622v = getResources().getColor(R$color.epg_view_cursor_color);
        this.f5623w = getResources().getColor(R$color.epg_view_text_color);
        this.f5612l = getResources().getColor(R$color.epg_view_space_color);
        this.E = this.f5609i + this.f5610j + (this.f5611k * 2);
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.M = new Rect();
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.K = canvas;
    }

    public void setInitData(boolean z10) {
        this.L = z10;
    }

    public EpgView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5608h = 20;
        this.f5609i = 170;
        this.f5610j = 60;
        this.f5611k = 1;
        this.f5613m = 18.0f;
        this.f5614n = 60;
        this.f5615o = 90;
        this.f5616p = 45;
        this.f5617q = 30;
        this.f5618r = 60;
        this.F = new ArrayList();
        this.L = true;
        this.S = 0;
        e();
    }

    private long a() {
        return 18000000 / (getResources().getDisplayMetrics().widthPixels - this.E);
    }

    private long b() {
        return q1.f(q1.h(), -7);
    }

    private void f() {
        this.A = a();
        this.B = b();
        this.C = c(0);
        this.D = c(getWidth());
    }

    private int getFirstVisibleChannelPosition() {
        int scrollY = getScrollY();
        int i10 = this.f5614n;
        int i11 = ((scrollY - i10) - this.f5617q) - this.f5618r;
        int i12 = this.f5611k;
        int i13 = (i11 - (i12 * 2)) / (i10 + i12);
        if (i13 < 0) {
            return 0;
        }
        return i13;
    }

    private int getLastVisibleChannelPosition() {
        getScrollY();
        throw null;
    }

    private int getXPositionStart() {
        return d(u1.b().a()) - ((getWidth() - this.E) / 2);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
