package v4;

import a0.i;
import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import s.f0;
import s.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static e f19642k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f19645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f19646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f19647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f19648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f19650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f19651i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f19643a = q6.c.d(v4.b.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f19644b = new i();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Runnable f19652j = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements v4.b.f {
        b() {
        }
    }

    public static e b() {
        if (f19642k == null) {
            f19642k = new e();
        }
        return f19642k;
    }

    public void d(ImageView imageView, RelativeLayout relativeLayout, TextView textView, Activity activity) {
        this.f19645c = imageView;
        this.f19646d = relativeLayout;
        this.f19647e = textView;
        this.f19648f = activity;
        this.f19649g = false;
        this.f19651i = false;
        if (this.f19650h == null) {
            this.f19650h = new Handler();
        }
    }

    public void e() {
        this.f19643a.a("onDestroyAdPausePayback", new Object[0]);
        this.f19645c = null;
        this.f19648f = null;
        this.f19649g = false;
        this.f19651i = false;
        Handler handler = this.f19650h;
        if (handler != null) {
            handler.removeCallbacks(this.f19652j);
            this.f19650h = null;
        }
    }

    public e() {
        try {
            this.f19644b.q0(new k(), new f0(5));
        } catch (Exception unused) {
        }
    }

    public void a(boolean z10) {
        if (v4.b.o().r() && !TextUtils.isEmpty("AD_PLAY_BACK_PAUSE_KEY") && !TextUtils.isEmpty(v4.b.f19597p) && this.f19649g != z10) {
            this.f19649g = z10;
            if (this.f19650h == null) {
                this.f19650h = new Handler();
            }
            Handler handler = this.f19650h;
            if (handler != null && this.f19649g) {
                handler.postDelayed(this.f19652j, 600L);
                return;
            }
            if (handler != null && !this.f19649g) {
                handler.removeCallbacks(this.f19652j);
                RelativeLayout relativeLayout = this.f19646d;
                if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                    this.f19646d.setVisibility(8);
                }
            }
        }
    }

    public void c() {
        if (v4.b.o().r() && !TextUtils.isEmpty("AD_PLAY_BACK_PAUSE_KEY") && !TextUtils.isEmpty(v4.b.f19597p)) {
            v4.b.o().z("AD_PLAY_BACK_PAUSE_KEY", v4.b.f19597p, new b());
        }
    }
}
