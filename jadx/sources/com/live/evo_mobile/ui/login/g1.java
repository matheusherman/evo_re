package com.live.evo_mobile.ui.login;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$layout;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003CDEB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0019\u0010\u001e\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u001a\u00105\u001a\u000602R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\u000606R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010;¨\u0006F"}, d2 = {"Lcom/live/evo_mobile/ui/login/g1;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/y0;", "<init>", "()V", "", ExifInterface.LONGITUDE_WEST, "()I", "R", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", NotificationCompat.CATEGORY_EMAIL, "X0", "(Ljava/lang/String;)V", "phone", "preCode", "Y0", "(Ljava/lang/String;Ljava/lang/String;)V", "y", "onDestroy", "Z0", "a1", "V0", "W0", "message", "d1", "Q0", "S0", "T0", "R0", "", "time", "b1", "(J)V", "c1", "tab", "U0", "(I)V", "e", "I", "TAB_EMAIL", "f", "TAB_PHONE", "", "g", "Z", "pwdShow", "h", "currentTab", "Lcom/live/evo_mobile/ui/login/g1$b;", "i", "Lcom/live/evo_mobile/ui/login/g1$b;", "timer", "Lcom/live/evo_mobile/ui/login/g1$c;", "j", "Lcom/live/evo_mobile/ui/login/g1$c;", "phoneTimer", "k", "Ljava/lang/String;", "account", "l", "m", "tmpEmail", "n", "tmpPhoneNumber", "o", "a", "b", "c", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g1 extends com.tvc.lib.mobile.ui.base.d<z4.y0> {

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f8035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f8036q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f8037r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static long f8038s;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean pwdShow;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int TAB_PHONE = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int TAB_EMAIL;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentTab = this.TAB_EMAIL;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b timer = new b(120000, 1000);

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private c phoneTimer = new c(120000, 1000);

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String account = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String preCode = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String tmpEmail = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String tmpPhoneNumber = "";

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.g1$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/live/evo_mobile/ui/login/g1$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/login/g1;", "c", "()Lcom/live/evo_mobile/ui/login/g1;", "", "sendErrCount", "I", "b", "()I", "g", "(I)V", "", "lastSendTimestamp", "J", "getLastSendTimestamp", "()J", "e", "(J)V", "resetErrCount", "a", "f", "lastResetTimestamp", "getLastResetTimestamp", "d", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final g1 c() {
            return new g1();
        }

        public final int a() {
            return g1.f8037r;
        }

        public final int b() {
            return g1.f8035p;
        }

        public final void d(long j10) {
            g1.f8038s = j10;
        }

        public final void e(long j10) {
            g1.f8036q = j10;
        }

        public final void f(int i10) {
            g1.f8037r = i10;
        }

        public final void g(int i10) {
            g1.f8035p = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/live/evo_mobile/ui/login/g1$b;", "Landroid/os/CountDownTimer;", "", "millisInFuture", "countDownInterval", "<init>", "(Lcom/live/evo_mobile/ui/login/g1;JJ)V", "millisUntilFinished", "Lr8/z;", "onTick", "(J)V", "onFinish", "()V", "", "a", "Z", "()Z", "b", "(Z)V", "finished", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                this.finished = true;
                if (g1.this.currentTab != g1.this.TAB_EMAIL) {
                    return;
                }
                g1.this.T().f23062z.setText(z7.p.b(2131952907));
                g1.this.T().f23062z.setClickable(true);
            } catch (Exception unused) {
            }
        }

        public b(long j10, long j11) {
            super(j10, j11);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void b(boolean z10) {
            this.finished = z10;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            g1.this.b1(millisUntilFinished);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/live/evo_mobile/ui/login/g1$c;", "Landroid/os/CountDownTimer;", "", "millisInFuture", "countDownInterval", "<init>", "(Lcom/live/evo_mobile/ui/login/g1;JJ)V", "millisUntilFinished", "Lr8/z;", "onTick", "(J)V", "onFinish", "()V", "", "a", "Z", "()Z", "b", "(Z)V", "finished", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                this.finished = true;
                if (g1.this.currentTab != g1.this.TAB_PHONE) {
                    return;
                }
                g1.this.T().f23062z.setText(z7.p.b(2131952907));
                g1.this.T().f23062z.setClickable(true);
            } catch (Exception unused) {
            }
        }

        public c(long j10, long j11) {
            super(j10, j11);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void b(boolean z10) {
            this.finished = z10;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            g1.this.c1(millisUntilFinished);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/g1$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            g1.this.T().f23042f.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !g1.this.T().f23038b.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo_mobile/ui/login/g1$e", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            g1.this.T().f23043g.setVisibility(((s10 != null ? s10.length() : 0) <= 0 || !g1.this.T().f23039c.isFocused()) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$resetPassword$1", f = "ResetPasswordFragment.kt", l = {441}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $account;
        final /* synthetic */ String $pwd;
        final /* synthetic */ String $verifyCode;
        int label;
        final /* synthetic */ g1 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$resetPassword$1$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ g1 this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.g1$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$resetPassword$1$1$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0135a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ g1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0135a(g1 g1Var, Throwable th, v8.f<? super C0135a> fVar) {
                    super(2, fVar);
                    this.this$0 = g1Var;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0135a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0135a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.R0(this.$it.getMessage());
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g1 g1Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = g1Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0135a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g1 f8055a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$resetPassword$1$2$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ g1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, g1 g1Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = g1Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$it, this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.$it.d().booleanValue()) {
                            this.this$0.T0();
                            Companion companion = g1.INSTANCE;
                            companion.f(0);
                            companion.d(SystemClock.elapsedRealtime());
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.Q0();
                            } else {
                                g1 g1Var = this.this$0;
                                String strF = this.$it.f();
                                g1Var.R0(((Object) strF) + "(" + this.$it.e() + ")");
                                Companion companion2 = g1.INSTANCE;
                                companion2.f(companion2.a() + 1);
                                companion2.d(SystemClock.elapsedRealtime());
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(g1 g1Var) {
                this.f8055a = g1Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8055a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, g1 g1Var, String str2, String str3, v8.f<? super f> fVar) {
            super(2, fVar);
            this.$account = str;
            this.this$0 = g1Var;
            this.$pwd = str2;
            this.$verifyCode = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new f(this.$account, this.this$0, this.$pwd, this.$verifyCode, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.F0(this.$account, this.this$0.preCode, this.$pwd, this.$verifyCode), new a(this.this$0, null));
                b bVar = new b(this.this$0);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$sendVerifyCode$1", f = "ResetPasswordFragment.kt", l = {308, 312, TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $account;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$sendVerifyCode$1$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ g1 this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.g1$g$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$sendVerifyCode$1$1$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0136a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ g1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0136a(g1 g1Var, Throwable th, v8.f<? super C0136a> fVar) {
                    super(2, fVar);
                    this.this$0 = g1Var;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0136a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0136a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.d1(this.$it.getMessage());
                        g1 g1Var = this.this$0;
                        g1Var.U0(g1Var.currentTab);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g1 g1Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = g1Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0136a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g1 f8056a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.login.ResetPasswordFragment$sendVerifyCode$1$2$1", f = "ResetPasswordFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ g1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r8.u<Boolean, Integer, String> uVar, g1 g1Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = uVar;
                    this.this$0 = g1Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$it, this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.$it.d().booleanValue()) {
                            this.this$0.W0();
                            Companion companion = g1.INSTANCE;
                            companion.g(0);
                            companion.e(0L);
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                this.this$0.Q0();
                            } else {
                                g1 g1Var = this.this$0;
                                String strF = this.$it.f();
                                g1Var.d1(((Object) strF) + "(" + this.$it.e() + ")");
                            }
                            g1 g1Var2 = this.this$0;
                            g1Var2.U0(g1Var2.currentTab);
                            Companion companion2 = g1.INSTANCE;
                            companion2.g(companion2.b() + 1);
                            companion2.e(SystemClock.elapsedRealtime());
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(g1 g1Var) {
                this.f8056a = g1Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(uVar, this.f8056a, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$account = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return g1.this.new g(this.$account, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        
            if (r7 == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        
            if (r7 == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.f fVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r8.r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r8.r.b(obj);
                        fVar = (kotlinx.coroutines.flow.f) obj;
                    }
                } else {
                    r8.r.b(obj);
                    fVar = (kotlinx.coroutines.flow.f) obj;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            if (g1.this.currentTab == g1.this.TAB_EMAIL) {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String str = this.$account;
                this.label = 1;
                obj = aVar.s(str, "FORGET", this);
            } else {
                com.live.evo_mobile.ui.login.c cVar = com.live.evo_mobile.ui.login.a.INSTANCE.a().c().get(g1.this.T().f23058v.getSelectedItemPosition());
                t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
                String phonePreCode = cVar.getPhonePreCode();
                if (phonePreCode == null) {
                    phonePreCode = "";
                }
                String str2 = this.$account;
                this.label = 2;
                obj = aVar2.t(phonePreCode, str2, "FORGET", this);
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(fVar, new a(g1.this, null));
            b bVar = new b(g1.this);
            this.label = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(g1 g1Var, View view) {
        if (g1Var.currentTab == g1Var.TAB_EMAIL) {
            return;
        }
        g1Var.tmpPhoneNumber = g1Var.T().f23037a.getText().toString();
        g1Var.Z0();
        g1Var.T().f23037a.setText(g1Var.tmpEmail);
        g1Var.T().f23037a.setSelection(g1Var.tmpEmail.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(g1 g1Var, View view) {
        if (g1Var.currentTab == g1Var.TAB_PHONE) {
            return;
        }
        g1Var.tmpEmail = g1Var.T().f23037a.getText().toString();
        g1Var.a1();
        g1Var.T().f23037a.setText(g1Var.tmpPhoneNumber);
        g1Var.T().f23037a.setSelection(g1Var.tmpPhoneNumber.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(g1 g1Var, View view) {
        g1Var.pwdShow = !g1Var.pwdShow;
        g1Var.T().f23044h.setImageResource(g1Var.pwdShow ? R$drawable.pwd_visible : R$drawable.pwd_invisible);
        int i10 = g1Var.pwdShow ? 145 : 129;
        g1Var.T().f23038b.setInputType(i10);
        g1Var.T().f23039c.setInputType(i10);
        try {
            g1Var.T().f23038b.setSelection(g1Var.T().f23038b.getText().length());
            g1Var.T().f23039c.setSelection(g1Var.T().f23039c.getText().length());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0071  */
    /* JADX WARN: Code duplicated, block: B:17:0x008c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0092  */
    /* JADX WARN: Code duplicated, block: B:20:0x009d  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00da  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:30:0x010b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0126  */
    /* JADX WARN: Code duplicated, block: B:38:0x0135  */
    /* JADX WARN: Code duplicated, block: B:40:0x0150  */
    /* JADX WARN: Code duplicated, block: B:42:0x0166  */
    /* JADX WARN: Code duplicated, block: B:44:0x0181  */
    /* JADX WARN: Code duplicated, block: B:46:0x0187  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a2  */
    private final void S0() {
        String string;
        String str;
        boolean zG;
        String string2;
        String string3;
        int length;
        boolean z10;
        String string4;
        if (this.currentTab != this.TAB_EMAIL) {
            String phonePreCode = a.INSTANCE.a().c().get(T().f23058v.getSelectedItemPosition()).getPhonePreCode();
            if (phonePreCode == null) {
                phonePreCode = "";
            }
            this.preCode = phonePreCode;
            String string5 = T().f23037a.getText().toString();
            if (kotlin.jvm.internal.m.a(string5, "")) {
                str = "";
            } else {
                string = this.preCode + string5;
            }
            if (TextUtils.isEmpty(str)) {
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                String strB = z7.p.b(2131951652);
                kotlin.jvm.internal.m.e(strB, "getString(...)");
                g1Var.c(strB);
                T().f23037a.requestFocus();
                return;
            }
            if (this.currentTab == this.TAB_EMAIL) {
                zG = a.INSTANCE.a().f(str);
            } else {
                zG = a.INSTANCE.a().g(str);
            }
            if (!zG) {
                x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                String strB2 = z7.p.b(2131953141);
                kotlin.jvm.internal.m.e(strB2, "getString(...)");
                g1Var2.c(strB2);
                T().f23037a.requestFocus();
                return;
            }
            string2 = T().f23040d.getText().toString();
            if (TextUtils.isEmpty(string2)) {
                x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
                String strB3 = z7.p.b(2131953166);
                kotlin.jvm.internal.m.e(strB3, "getString(...)");
                g1Var3.c(strB3);
                T().f23040d.requestFocus();
                return;
            }
            string3 = T().f23038b.getText().toString();
            if (TextUtils.isEmpty(string3)) {
                x1.f1.lb.util.g1 g1Var4 = x1.f1.lb.util.g1.f21390a;
                String strB4 = z7.p.b(2131952756);
                kotlin.jvm.internal.m.e(strB4, "getString(...)");
                g1Var4.c(strB4);
                T().f23038b.requestFocus();
                return;
            }
            length = string3.length();
            z10 = false;
            if (6 <= length && length < 17) {
                z10 = true;
            }
            if (!z10) {
                x1.f1.lb.util.g1 g1Var5 = x1.f1.lb.util.g1.f21390a;
                String strB5 = z7.p.b(2131952758);
                kotlin.jvm.internal.m.e(strB5, "getString(...)");
                g1Var5.c(strB5);
                T().f23038b.requestFocus();
                return;
            }
            string4 = T().f23039c.getText().toString();
            if (kotlin.jvm.internal.m.a(string4, "")) {
                x1.f1.lb.util.g1 g1Var6 = x1.f1.lb.util.g1.f21390a;
                String strB6 = z7.p.b(2131952754);
                kotlin.jvm.internal.m.e(strB6, "getString(...)");
                g1Var6.c(strB6);
                T().f23039c.requestFocus();
                return;
            }
            if (kotlin.jvm.internal.m.a(string3, string4)) {
                x1.f1.lb.util.g1 g1Var7 = x1.f1.lb.util.g1.f21390a;
                String strB7 = z7.p.b(2131952755);
                kotlin.jvm.internal.m.e(strB7, "getString(...)");
                g1Var7.c(strB7);
                T().f23039c.requestFocus();
            }
            if (f8037r >= 5 || f8038s + ((long) 60000) <= SystemClock.elapsedRealtime()) {
                Z();
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new f(str, this, string3, string2, null), 3, null);
            } else {
                x1.f1.lb.util.g1 g1Var8 = x1.f1.lb.util.g1.f21390a;
                String strB8 = z7.p.b(2131952016);
                kotlin.jvm.internal.m.e(strB8, "getString(...)");
                g1Var8.c(strB8);
                return;
            }
        }
        string = T().f23037a.getText().toString();
        str = string;
        if (TextUtils.isEmpty(str)) {
            x1.f1.lb.util.g1 g1Var9 = x1.f1.lb.util.g1.f21390a;
            String strB9 = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB9, "getString(...)");
            g1Var9.c(strB9);
            T().f23037a.requestFocus();
            return;
        }
        if (this.currentTab == this.TAB_EMAIL) {
            zG = a.INSTANCE.a().f(str);
        } else {
            zG = a.INSTANCE.a().g(str);
        }
        if (!zG) {
            x1.f1.lb.util.g1 g1Var10 = x1.f1.lb.util.g1.f21390a;
            String strB10 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB10, "getString(...)");
            g1Var10.c(strB10);
            T().f23037a.requestFocus();
            return;
        }
        string2 = T().f23040d.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            x1.f1.lb.util.g1 g1Var11 = x1.f1.lb.util.g1.f21390a;
            String strB11 = z7.p.b(2131953166);
            kotlin.jvm.internal.m.e(strB11, "getString(...)");
            g1Var11.c(strB11);
            T().f23040d.requestFocus();
            return;
        }
        string3 = T().f23038b.getText().toString();
        if (TextUtils.isEmpty(string3)) {
            x1.f1.lb.util.g1 g1Var12 = x1.f1.lb.util.g1.f21390a;
            String strB12 = z7.p.b(2131952756);
            kotlin.jvm.internal.m.e(strB12, "getString(...)");
            g1Var12.c(strB12);
            T().f23038b.requestFocus();
            return;
        }
        length = string3.length();
        z10 = false;
        if (6 <= length) {
            z10 = true;
        }
        if (!z10) {
            x1.f1.lb.util.g1 g1Var13 = x1.f1.lb.util.g1.f21390a;
            String strB13 = z7.p.b(2131952758);
            kotlin.jvm.internal.m.e(strB13, "getString(...)");
            g1Var13.c(strB13);
            T().f23038b.requestFocus();
            return;
        }
        string4 = T().f23039c.getText().toString();
        if (kotlin.jvm.internal.m.a(string4, "")) {
            x1.f1.lb.util.g1 g1Var14 = x1.f1.lb.util.g1.f21390a;
            String strB14 = z7.p.b(2131952754);
            kotlin.jvm.internal.m.e(strB14, "getString(...)");
            g1Var14.c(strB14);
            T().f23039c.requestFocus();
            return;
        }
        if (kotlin.jvm.internal.m.a(string3, string4)) {
            if (f8037r >= 5) {
            }
            Z();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new f(str, this, string3, string2, null), 3, null);
        } else {
            x1.f1.lb.util.g1 g1Var15 = x1.f1.lb.util.g1.f21390a;
            String strB15 = z7.p.b(2131952755);
            kotlin.jvm.internal.m.e(strB15, "getString(...)");
            g1Var15.c(strB15);
            T().f23039c.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(int tab) {
        if (tab == this.TAB_EMAIL) {
            this.timer.cancel();
            this.timer.onFinish();
        } else {
            this.phoneTimer.cancel();
            this.phoneTimer.onFinish();
        }
    }

    private final void Z0() {
        this.currentTab = this.TAB_EMAIL;
        Context context = T().f23059w.getContext();
        T().f23059w.setTextColor(context.getResources().getColor(R$color.color_focused));
        T().f23047k.setBackgroundColor(context.getResources().getColor(R$color.color_focused));
        T().f23047k.setVisibility(0);
        T().f23060x.setTextColor(context.getResources().getColor(R$color.text_color_normal));
        T().f23048l.setBackgroundColor(context.getResources().getColor(R$color.text_color_normal));
        T().f23048l.setVisibility(4);
        T().f23049m.setVisibility(8);
        T().f23037a.setHint(z7.p.b(2131951676));
        T().f23061y.setText(Html.fromHtml(z7.p.b(2131951988)));
        T().f23037a.setInputType(1);
        T().f23037a.getText().clear();
        T().f23038b.getText().clear();
        T().f23039c.getText().clear();
        T().f23040d.getText().clear();
        if (!this.timer.getFinished()) {
            T().f23062z.setClickable(false);
        } else {
            T().f23062z.setText(z7.p.b(2131952907));
            T().f23062z.setClickable(true);
        }
    }

    private final void a1() {
        this.currentTab = this.TAB_PHONE;
        Context context = T().f23059w.getContext();
        T().f23059w.setTextColor(context.getResources().getColor(R$color.text_color_normal));
        T().f23047k.setBackgroundColor(context.getResources().getColor(R$color.text_color_normal));
        T().f23047k.setVisibility(4);
        T().f23060x.setTextColor(context.getResources().getColor(R$color.color_focused));
        T().f23048l.setBackgroundColor(context.getResources().getColor(R$color.color_focused));
        T().f23048l.setVisibility(0);
        T().f23049m.setVisibility(0);
        T().f23037a.setHint(z7.p.b(2131951678));
        T().f23061y.setText(Html.fromHtml(z7.p.b(2131952675)));
        T().f23037a.setInputType(2);
        T().f23037a.getText().clear();
        T().f23038b.getText().clear();
        T().f23039c.getText().clear();
        T().f23040d.getText().clear();
        if (!this.phoneTimer.getFinished()) {
            T().f23062z.setClickable(false);
        } else {
            T().f23062z.setText(z7.p.b(2131952907));
            T().f23062z.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(long time) {
        try {
            if (this.currentTab != this.TAB_EMAIL) {
                return;
            }
            T().f23062z.setText(z7.p.b(2131952906) + TimeUnit.MILLISECONDS.toSeconds(time) + "s)");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(long time) {
        try {
            if (this.currentTab != this.TAB_PHONE) {
                return;
            }
            T().f23062z.setText(z7.p.b(2131952906) + TimeUnit.MILLISECONDS.toSeconds(time) + "s)");
        } catch (Exception unused) {
        }
    }

    public final void X0(String email) {
        kotlin.jvm.internal.m.f(email, "email");
        this.tmpEmail = "";
        this.tmpPhoneNumber = "";
        if (this.mDataBinding == 0) {
            this.currentTab = this.TAB_EMAIL;
            this.account = email;
        } else {
            Z0();
            T().f23037a.setText(email);
            T().f23037a.setSelection(email.length());
        }
    }

    public final void Y0(String phone, String preCode) {
        kotlin.jvm.internal.m.f(phone, "phone");
        kotlin.jvm.internal.m.f(preCode, "preCode");
        this.tmpEmail = "";
        this.tmpPhoneNumber = "";
        if (this.mDataBinding == 0) {
            this.currentTab = this.TAB_PHONE;
            this.account = phone;
            this.preCode = preCode;
            return;
        }
        a1();
        T().f23037a.setText(phone);
        T().f23037a.setSelection(phone.length());
        int i10 = 0;
        for (Object obj : a.INSTANCE.a().c()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            if (TextUtils.equals(((com.live.evo_mobile.ui.login.c) obj).getPhonePreCode(), preCode)) {
                T().f23058v.setSelection(i10);
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(g1 g1Var, View view) {
        LoginTypeActivity loginTypeActivity;
        FragmentActivity activity = g1Var.getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(g1 g1Var, View view) {
        g1Var.T().f23038b.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(g1 g1Var, View view) {
        g1Var.T().f23039c.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(g1 g1Var, View view) {
        g1Var.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(g1 g1Var, View view, boolean z10) {
        g1Var.T().f23050n.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(g1 g1Var, View view, boolean z10) {
        g1Var.T().f23055s.setSelected(z10);
        if (z10) {
            Editable text = g1Var.T().f23038b.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                g1Var.T().f23042f.setVisibility(0);
                return;
            }
            return;
        }
        g1Var.T().f23042f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(g1 g1Var, View view, boolean z10) {
        g1Var.T().f23056t.setSelected(z10);
        if (z10) {
            Editable text = g1Var.T().f23039c.getText();
            kotlin.jvm.internal.m.e(text, "getText(...)");
            if (text.length() > 0) {
                g1Var.T().f23043g.setVisibility(0);
                return;
            }
            return;
        }
        g1Var.T().f23043g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(g1 g1Var, View view, boolean z10) {
        g1Var.T().f23057u.setSelected(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(g1 g1Var, View view) {
        g1Var.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        U();
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952547);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(String message) {
        U();
        x1.f1.lb.util.g1.f21390a.c(z7.p.b(2131952856) + ": " + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0() {
        LoginTypeActivity loginTypeActivity;
        U();
        FragmentActivity activity = getActivity();
        if (activity instanceof LoginTypeActivity) {
            loginTypeActivity = (LoginTypeActivity) activity;
        } else {
            loginTypeActivity = null;
        }
        if (loginTypeActivity != null) {
            loginTypeActivity.Y();
        }
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strB = z7.p.b(2131952943);
        kotlin.jvm.internal.m.e(strB, "getString(...)");
        g1Var.c(strB);
        this.timer.cancel();
        this.phoneTimer.cancel();
        this.timer.b(true);
        this.phoneTimer.b(true);
        this.tmpEmail = "";
        this.tmpPhoneNumber = "";
    }

    private final void V0() {
        boolean zG;
        String string = T().f23037a.getText().toString();
        if (TextUtils.isEmpty(string)) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strB = z7.p.b(2131951652);
            kotlin.jvm.internal.m.e(strB, "getString(...)");
            g1Var.c(strB);
            T().f23037a.requestFocus();
            return;
        }
        if (this.currentTab == this.TAB_EMAIL) {
            zG = a.INSTANCE.a().f(string);
        } else {
            a.Companion companion = a.INSTANCE;
            com.live.evo_mobile.ui.login.c cVar = companion.a().c().get(T().f23058v.getSelectedItemPosition());
            zG = companion.a().g(cVar.getPhonePreCode() + string);
        }
        if (!zG) {
            x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
            String strB2 = z7.p.b(2131953141);
            kotlin.jvm.internal.m.e(strB2, "getString(...)");
            g1Var2.c(strB2);
            T().f23037a.requestFocus();
            return;
        }
        if (f8035p >= 5 && f8036q + ((long) 60000) > SystemClock.elapsedRealtime()) {
            x1.f1.lb.util.g1 g1Var3 = x1.f1.lb.util.g1.f21390a;
            String strB3 = z7.p.b(2131952016);
            kotlin.jvm.internal.m.e(strB3, "getString(...)");
            g1Var3.c(strB3);
            return;
        }
        Z();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new g(string, null), 3, null);
        if (this.currentTab == this.TAB_EMAIL) {
            this.timer.cancel();
            b bVar = new b(120000L, 1000L);
            this.timer = bVar;
            bVar.start();
        } else {
            this.phoneTimer.cancel();
            c cVar2 = new c(120000L, 1000L);
            this.phoneTimer = cVar2;
            cVar2.start();
        }
        T().f23062z.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(String message) {
        U();
        x1.f1.lb.util.g1.f21390a.c(z7.p.b(2131953168) + ": " + message);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        T().f23058v.setAdapter((SpinnerAdapter) new com.live.evo_mobile.ui.login.b(S(), a.INSTANCE.a().c()));
        if (this.currentTab == this.TAB_EMAIL) {
            X0(this.account);
        } else {
            Y0(this.account, this.preCode);
        }
        this.timer.b(true);
        this.phoneTimer.b(true);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_reset_password;
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.timer.cancel();
        this.phoneTimer.cancel();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        T().f23045i.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.E0(this.f8116a, view);
            }
        });
        T().f23051o.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.I0(this.f8126a, view);
            }
        });
        T().f23052p.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.J0(this.f8008a, view);
            }
        });
        T().f23037a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.b1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                g1.K0(this.f8015a, view, z10);
            }
        });
        T().f23038b.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.c1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                g1.L0(this.f8022a, view, z10);
            }
        });
        T().f23039c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.d1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                g1.M0(this.f8025a, view, z10);
            }
        });
        T().f23040d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo_mobile.ui.login.e1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                g1.N0(this.f8028a, view, z10);
            }
        });
        T().f23062z.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.O0(this.f8031a, view);
            }
        });
        T().f23044h.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.P0(this.f8118a, view);
            }
        });
        T().f23038b.addTextChangedListener(new d());
        T().f23039c.addTextChangedListener(new e());
        T().f23042f.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.F0(this.f8120a, view);
            }
        });
        T().f23043g.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.G0(this.f8122a, view);
            }
        });
        T().f23054r.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.login.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g1.H0(this.f8124a, view);
            }
        });
    }
}
