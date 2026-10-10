package com.live.evo.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.live.evo.MyApplication;
import com.live.evo.R$drawable;
import com.live.evo.R$raw;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static o0 f7303n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7304a = q6.c.d(o0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7305b = MyApplication.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f7314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f7315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f7316m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        this.f7306c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(String str) {
        this.f7307d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(String str) {
        this.f7308e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(String str) {
        this.f7309f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(String str) {
        this.f7310g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(String str) {
        this.f7312i = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(String str) {
        this.f7313j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        this.f7314k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(String str) {
        this.f7315l = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(String str) {
        this.f7316m = str;
    }

    public static o0 p() {
        if (f7303n == null) {
            synchronized (o0.class) {
                try {
                    if (f7303n == null) {
                        y();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7303n;
    }

    private void r(String str, final x1.f1.lb.util.w0.a<String> aVar) {
        x1.f1.lb.util.w0.f21452a.n(str, new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.e0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                o0.h(aVar, (String) obj);
            }
        }, "");
    }

    public static void y() {
        f7303n = new o0();
    }

    public String m() {
        return this.f7314k;
    }

    public String o() {
        return this.f7309f;
    }

    public String q() {
        return this.f7313j;
    }

    public String s() {
        return this.f7308e;
    }

    public String t() {
        return this.f7315l;
    }

    public String u() {
        return this.f7316m;
    }

    public String x() {
        if (!TextUtils.isEmpty(this.f7312i)) {
            File file = new File(this.f7312i);
            if (file.exists() && file.getName().endsWith(".mp4")) {
                return this.f7312i;
            }
        }
        return "android.resource://" + this.f7305b.getPackageName() + "/" + R$raw.bootvideo;
    }

    public boolean z() {
        return this.f7311h == 1;
    }

    private o0() {
        r("key_load_video_end", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.c0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7192a.A((String) obj);
            }
        });
        r("key_load_ecomode", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.g0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7235a.B((String) obj);
            }
        });
        r("key_load_play_icon", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.h0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7239a.D((String) obj);
            }
        });
        r("key_load_favorite_img", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.i0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7241a.E((String) obj);
            }
        });
        r("key_load_curtain", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.j0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7246a.F((String) obj);
            }
        });
        r("key_boot_media", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.k0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7249a.G((String) obj);
            }
        });
        x1.f1.lb.util.w0 w0Var = x1.f1.lb.util.w0.f21452a;
        w0Var.n("loading_view_color", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.l0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7272a.H((String) obj);
            }
        }, "");
        w0Var.n("epg_current_progress_color", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.m0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7284a.I((String) obj);
            }
        }, "");
        w0Var.n("playback_seekbar_progress_color", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.n0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7287a.J((String) obj);
            }
        }, "");
        w0Var.n("playback_seekbar_thumb_color", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.d0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7193a.K((String) obj);
            }
        }, "");
        w0Var.n("key_load_type", new x1.f1.lb.util.w0.a() { // from class: com.live.evo.util.f0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f7234a.C((String) obj);
            }
        }, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(String str) {
        int iIntValue;
        if (TextUtils.isEmpty(str)) {
            iIntValue = 0;
        } else {
            iIntValue = Integer.valueOf(str).intValue();
        }
        if (TextUtils.isEmpty(this.f7312i)) {
            this.f7311h = 0;
        } else {
            this.f7311h = iIntValue;
        }
    }

    public static /* synthetic */ void h(x1.f1.lb.util.w0.a aVar, String str) {
        i5.n nVar = (i5.n) w.a().n(str, i5.n.class);
        if (nVar == null) {
            return;
        }
        aVar.a(nVar.a());
    }

    public Drawable n() {
        try {
            if (new File(this.f7307d).exists()) {
                return Drawable.createFromPath(this.f7307d);
            }
            return x1.f(R$drawable.stopplay);
        } catch (Exception unused) {
            return x1.f(R$drawable.stopplay);
        }
    }

    public Drawable v() {
        return x1.f(R$drawable.load_bg);
    }

    public Drawable w() {
        return x1.f(R$drawable.load_bg);
    }
}
