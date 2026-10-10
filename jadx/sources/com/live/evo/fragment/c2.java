package com.live.evo.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import java.lang.ref.SoftReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J)\u0010\u001f\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b#\u0010\u000fR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010&R\u0018\u0010<\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010&R\u0016\u0010@\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00106R\u0016\u0010C\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010&R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/live/evo/fragment/c2;", "Lcom/live/evo/fragment/f0;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "Lr8/z;", "e0", "f0", "", "R", "()I", "Landroid/view/View;", "view", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.LATITUDE_SOUTH, "(Landroid/os/Bundle;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "isVisible", "X", "(Z)V", "hasFocus", ExifInterface.LONGITUDE_WEST, "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onStop", "onDestroy", "onClick", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mRemind1", "g", "mRemind2", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "mQrCode", "i", "mAttention", "", "j", "Ljava/lang/String;", "lastQRCode", "", "k", "J", "lastRequsetTime", "l", "mDownloadUrl", "m", "Landroid/view/View;", "mRefresh", "n", "mTvRefresh", "o", "interval", "p", "Z", "isOnRequest", "q", "mLoginCode", "Ljava/util/Timer;", "r", "Ljava/util/Timer;", "mTimer", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "mHandler", "Ll5/a;", "t", "Ll5/a;", "loginCodeListener", "u", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c2 extends f0 implements View.OnClickListener, View.OnKeyListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static SoftReference<c2> f5898v;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mRemind1;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mRemind2;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mQrCode;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mAttention;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long lastRequsetTime;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mDownloadUrl;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mRefresh;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mTvRefresh;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long interval;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isOnRequest;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mLoginCode;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Timer mTimer;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String lastQRCode = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new d();

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final l5.a loginCodeListener = new c();

    /* JADX INFO: renamed from: com.live.evo.fragment.c2$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/live/evo/fragment/c2$a;", "", "<init>", "()V", "", "tag", "Lcom/live/evo/fragment/c2;", "a", "(Ljava/lang/String;)Lcom/live/evo/fragment/c2;", "", "INIT_DATA", "I", "Ljava/lang/ref/SoftReference;", "sfrInstance", "Ljava/lang/ref/SoftReference;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final c2 a(String tag) {
            c2 c2Var;
            SoftReference softReference = c2.f5898v;
            c2 c2Var2 = null;
            if (softReference != null) {
                c2Var = (c2) softReference.get();
            } else {
                c2Var = null;
            }
            if (c2Var != null) {
                return c2Var;
            }
            new Bundle().putString("tag", tag);
            synchronized (Companion.class) {
                SoftReference softReference2 = c2.f5898v;
                if (softReference2 != null) {
                    c2Var2 = (c2) softReference2.get();
                }
                if (c2Var2 != null) {
                    return c2Var2;
                }
                c2 c2Var3 = new c2();
                c2.f5898v = new SoftReference(c2Var3);
                return c2Var3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/c2$b", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c2.this.mHandler.sendEmptyMessage(262145);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/live/evo/fragment/c2$c", "Ll5/a;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements l5.a {
        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/c2$d", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            if (msg.what == 262145) {
                c2.this.f0();
            }
        }
    }

    private final void e0() {
        Timer timer = this.mTimer;
        if (timer != null) {
            kotlin.jvm.internal.m.c(timer);
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        kotlin.jvm.internal.m.c(timer2);
        timer2.schedule(new b(), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        if (this.lastRequsetTime + this.interval >= com.live.evo.util.u1.b().a() || this.isOnRequest) {
            return;
        }
        this.isOnRequest = true;
        com.live.evo.l.n().p(this.loginCodeListener);
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        View view = this.mRefresh;
        kotlin.jvm.internal.m.c(view);
        view.setNextFocusDownId(R$id.phoneloginf_ll_refresh);
        View view2 = this.mRefresh;
        kotlin.jvm.internal.m.c(view2);
        view2.setNextFocusUpId(R$id.phoneloginf_ll_refresh);
        View view3 = this.mRefresh;
        kotlin.jvm.internal.m.c(view3);
        view3.setOnClickListener(this);
        View view4 = this.mRefresh;
        kotlin.jvm.internal.m.c(view4);
        view4.setOnKeyListener(this);
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        this.mRemind1 = (TextView) view.findViewById(R$id.phoneloginf_tv_remind);
        this.mRemind2 = (TextView) view.findViewById(R$id.phoneloginf_tv_web_remind);
        this.mAttention = (TextView) view.findViewById(R$id.phoneloginf_tv_attention);
        this.mQrCode = (ImageView) view.findViewById(R$id.phoneloginf_iv_qrcode);
        this.mDownloadUrl = (TextView) view.findViewById(R$id.phoneloginf_tv_download_url);
        this.mRefresh = view.findViewById(R$id.phoneloginf_ll_refresh);
        this.mTvRefresh = (TextView) view.findViewById(R$id.phoneloginf_tv_refresh);
        this.mLoginCode = (TextView) view.findViewById(R$id.phoneloginf_tv_code);
        if (com.live.evo.l.n().q() == 0) {
            TextView textView = this.mLoginCode;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = this.mLoginCode;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.mRemind1);
            com.live.evo.util.t.b(this.mRemind2);
            com.live.evo.util.t.b(this.mAttention);
            com.live.evo.util.t.c(this.mTvRefresh);
            com.live.evo.util.t.b(this.mDownloadUrl);
            com.live.evo.util.t.b(this.mLoginCode);
        }
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean hasFocus) {
        View view = this.mRefresh;
        if (view != null) {
            kotlin.jvm.internal.m.c(view);
            view.requestFocus();
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean isVisible) {
        if (isVisible) {
            e0();
            return;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            kotlin.jvm.internal.m.c(timer);
            timer.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        if (view.getId() == 2131428910) {
            this.lastQRCode = "";
            com.bumptech.glide.k<Drawable> kVarT = com.bumptech.glide.c.t(requireContext()).t(Integer.valueOf(R$drawable.qr_placehodler));
            ImageView imageView = this.mQrCode;
            kotlin.jvm.internal.m.c(imageView);
            kVarT.E0(imageView);
            f0();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        a2 a2Var;
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode != 21 || event.getAction() != 0 || (a2Var = this.f5935e) == null) {
            return false;
        }
        a2Var.D(this);
        return false;
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newphone_login_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle savedInstanceState) {
        this.interval = com.live.evo.l.n().h("request_phone_code_interval", TimeUnit.MINUTES.toMillis(0L));
        String strA = com.live.evo.util.p1.a("phone_login_option_one", com.live.evo.util.x1.j(R$string.phone_login_remind1));
        TextView textView = this.mRemind1;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(Html.fromHtml(strA));
        String strA2 = com.live.evo.util.p1.a("phone_login_option_two", com.live.evo.util.x1.j(R$string.tv_phone_login_remind_2));
        TextView textView2 = this.mRemind2;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(Html.fromHtml(strA2));
        String strA3 = com.live.evo.util.p1.a("phone_login_attention", com.live.evo.util.x1.j(R$string.phone_login_attention));
        TextView textView3 = this.mAttention;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setText(Html.fromHtml(strA3));
        f0();
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f5898v = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
