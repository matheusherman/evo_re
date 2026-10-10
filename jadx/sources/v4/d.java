package v4;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.activity.LiveLoadActivity;
import com.live.evo.util.r;
import com.live.evo.util.w;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.List;
import t.v.c.widget.videoview.VideoView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import x1.f1.lb.widget.videoview.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static d f19622p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f19623a = q6.c.d(v4.b.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i5.b> f19624b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19625c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19626d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19627e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19628f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19629g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f19630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f19631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageButton f19632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f19633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f19634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImageView f19635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private VideoView f19636n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LiveLoadActivity f19637o;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f19635m.getVisibility() != 8) {
                d.this.f19635m.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements IMediaPlayer.OnErrorListener {
        b() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x007e  */
        /* JADX WARN: Code duplicated, block: B:7:0x006a  */
        /* JADX WARN: Code duplicated, block: B:9:0x0072  */
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
            d dVar;
            d.this.f19623a.error("mVideoView error = " + i10 + "---" + i11, new Object[0]);
            v4.b bVarO = v4.b.o();
            d dVar2 = d.this;
            r.a(bVarO.n(dVar2.p(dVar2.f19629g)));
            d.this.f19627e = false;
            d.this.f19635m.setVisibility(8);
            d.this.v();
            if (!d.this.f19628f) {
                d dVar3 = d.this;
                if (!dVar3.q(dVar3.f19629g)) {
                    d.this.C();
                } else if (!d.this.f19628f) {
                    dVar = d.this;
                    if (dVar.q(dVar.f19629g)) {
                        v4.b.o().D();
                        d.this.t();
                        d.this.G();
                        d.this.f19628f = true;
                        d.this.f19637o.W0();
                    }
                }
            } else if (!d.this.f19628f) {
                dVar = d.this;
                if (dVar.q(dVar.f19629g)) {
                    v4.b.o().D();
                    d.this.t();
                    d.this.G();
                    d.this.f19628f = true;
                    d.this.f19637o.W0();
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements IMediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            d.this.f19623a.debug("mVideoView onCompletion", new Object[0]);
            d.this.f19627e = false;
            if (!d.this.f19628f) {
                d dVar = d.this;
                if (dVar.q(dVar.f19629g)) {
                    v4.b.o().D();
                    d.this.t();
                    d.this.G();
                    d.this.v();
                    d.this.f19628f = true;
                    d.this.f19637o.W0();
                    return;
                }
            }
            if (d.this.f19628f) {
                return;
            }
            d dVar2 = d.this;
            dVar2.q(dVar2.f19629g);
        }
    }

    /* JADX INFO: renamed from: v4.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0375d implements v4.b.g {
        C0375d() {
        }

        @Override // v4.b.g
        public void a() {
            d dVar = d.this;
            if (dVar.q(dVar.f19629g)) {
                d.this.o();
                return;
            }
            v4.b bVarO = v4.b.o();
            d dVar2 = d.this;
            if (bVarO.w(dVar2.p(dVar2.f19629g))) {
                d.this.u();
                d.this.C();
                return;
            }
            v4.b bVarO2 = v4.b.o();
            d dVar3 = d.this;
            if (bVarO2.x(dVar3.p(dVar3.f19629g)) && d.this.f19636n != null && d.this.f19636n.getVideoViewHandler().K1()) {
                d.this.v();
                d.this.C();
            } else {
                d.this.u();
                d.this.v();
                d.this.C();
            }
        }

        @Override // v4.b.g
        public void onFinish() {
            d.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        E(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f19627e = false;
        VideoView videoView = this.f19636n;
        if (videoView != null && videoView.getVideoViewHandler().K1()) {
            this.f19636n.getVideoViewHandler().N2(true);
        }
        F(false);
        G();
    }

    private void A(i5.b bVar) {
        if (bVar == null || this.f19629g >= this.f19624b.size()) {
            o();
            return;
        }
        this.f19631i.setVisibility(0);
        if (v4.b.o().y()) {
            LinearLayout linearLayout = this.f19630h;
            if (linearLayout != null && linearLayout.getVisibility() != 0) {
                this.f19630h.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.f19630h;
            if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                this.f19630h.setVisibility(8);
            }
        }
        v4.b.o().D();
        long jR = r();
        this.f19623a.a("getDisplayTime = " + jR, new Object[0]);
        if (jR == 0) {
            o();
        } else {
            v4.b.o().C(this.f19631i, this.f19633k, jR, bVar, new C0375d());
        }
    }

    private void B(i5.b bVar, boolean z10) {
        this.f19634l.setBackground(x1.f(R$drawable.icon_transport));
        this.f19626d = z10;
        E(true);
        F(false);
        this.f19632j.setImageDrawable(v4.b.o().m(bVar));
        A(bVar);
    }

    private void D(i5.b bVar, boolean z10) {
        this.f19626d = z10;
        E(false);
        F(true);
        w();
        G();
    }

    private void E(boolean z10) {
        if (!z10) {
            this.f19632j.setVisibility(8);
        } else {
            this.f19632j.requestFocus();
            this.f19632j.setVisibility(0);
        }
    }

    private void F(boolean z10) {
        if (!z10) {
            this.f19636n.setVisibility(8);
            this.f19635m.setVisibility(8);
        } else {
            this.f19636n.setVisibility(0);
            this.f19635m.setVisibility(0);
            this.f19635m.setBackground(x1.f(R$drawable.load_bg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f19634l.setBackground(x1.f(R$drawable.load_bg));
    }

    private int r() {
        List<i5.b> list = this.f19624b;
        int iF = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int iD = this.f19624b.get(0).d();
        for (i5.b bVar : this.f19624b) {
            if (v4.b.o().w(bVar)) {
                iF = (int) (((long) iF) + CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            } else if (v4.b.o().x(bVar)) {
                iF += bVar.f() * 1000;
            }
        }
        return iD > iF ? iF : iD;
    }

    public static d s(LiveLoadActivity liveLoadActivity) {
        if (f19622p == null) {
            f19622p = new d(liveLoadActivity);
        }
        return f19622p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        LinearLayout linearLayout = this.f19631i;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.f19631i.setVisibility(8);
    }

    private void w() {
        z0 videoViewHandler = this.f19636n.getVideoViewHandler();
        videoViewHandler.w2(new IMediaPlayer.OnInfoListener() { // from class: v4.c
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return this.f19621a.x(iMediaPlayer, i10, i11, str);
            }
        });
        videoViewHandler.v2(new b());
        videoViewHandler.u2(new c());
        videoViewHandler.E2(v4.b.o().n(p(this.f19629g)));
        this.f19636n.requestFocus();
        videoViewHandler.H2();
        this.f19627e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        this.f19623a.debug("mVideoView = setOnInfoListener", new Object[0]);
        A(p(this.f19629g));
        if (this.f19635m.getVisibility() == 8) {
            return true;
        }
        this.f19637o.getMHandler().postDelayed(new a(), 0L);
        return true;
    }

    public void C() {
        this.f19629g++;
        v4.b.o().B(p(this.f19629g));
        z();
    }

    public i5.b p(int i10) {
        i5.b bVar = (this.f19624b.size() <= 0 || i10 < 0 || i10 >= this.f19624b.size()) ? null : this.f19624b.get(i10);
        if (bVar != null) {
            this.f19623a.a("findNextAd = " + w.a().w(bVar), new Object[0]);
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    public boolean q(int i10) {
        boolean z10;
        if (this.f19624b.size() > 0 && i10 >= 0 && i10 < this.f19624b.size()) {
            z10 = i10 == this.f19624b.size() - 1;
        }
        this.f19623a.a("findNextAdIsEnd = " + z10, new Object[0]);
        return z10;
    }

    public void y() {
        if (this.f19637o == null) {
            return;
        }
        o();
    }

    public void z() {
        LiveLoadActivity liveLoadActivity = this.f19637o;
        if (liveLoadActivity == null) {
            return;
        }
        liveLoadActivity.getMHandler();
        i5.b bVarP = p(this.f19629g);
        if (!q(this.f19629g)) {
            if (v4.b.o().w(bVarP)) {
                B(bVarP, false);
                return;
            }
            if (v4.b.o().x(bVarP)) {
                D(bVarP, false);
                return;
            }
            E(false);
            F(false);
            t();
            this.f19637o.W0();
            return;
        }
        if (v4.b.o().w(bVarP)) {
            B(bVarP, true);
            return;
        }
        if (v4.b.o().x(bVarP)) {
            D(bVarP, true);
            return;
        }
        E(false);
        F(false);
        t();
        this.f19628f = true;
        this.f19637o.W0();
    }

    public d(LiveLoadActivity liveLoadActivity) {
        this.f19637o = liveLoadActivity;
        if (liveLoadActivity == null) {
            return;
        }
        if (this.f19634l == null) {
            this.f19634l = liveLoadActivity.findViewById(R$id.root);
        }
        if (this.f19636n == null) {
            this.f19636n = (VideoView) this.f19637o.findViewById(R$id.loada_video_view);
        }
        if (this.f19635m == null) {
            this.f19635m = (ImageView) this.f19637o.findViewById(R$id.loada_iv_video_curtain);
        }
        if (this.f19631i == null) {
            this.f19631i = (LinearLayout) this.f19637o.findViewById(R$id.loada_ad_canskip);
        }
        if (this.f19632j == null) {
            this.f19632j = (ImageButton) this.f19637o.findViewById(R$id.loada_iv_ad);
        }
        if (this.f19633k == null) {
            this.f19633k = (TextView) this.f19637o.findViewById(R$id.loada_ad_system_tv);
        }
        if (this.f19630h == null) {
            this.f19630h = (LinearLayout) this.f19637o.findViewById(R$id.loada_ad_canskip_ll);
        }
        this.f19624b.clear();
        this.f19624b.addAll(v4.b.o().l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        v4.b.o().D();
        t();
        G();
        u();
        v();
        this.f19637o.W0();
        this.f19628f = true;
    }
}
