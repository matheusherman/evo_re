package com.live.evo.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.live.evo.MyApplication;
import com.live.evo.R$id;
import com.live.evo.R$string;
import com.live.evo.widget.GaugeView;
import com.stub.StubApp;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0018\u0010$\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0018\u0010(\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0018\u0010*\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u0018\u00109\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0018\u0010:\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0018\u0010<\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0018\u0010=\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0018\u0010?\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u0019R\u0016\u0010@\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00101R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/live/evo/activity/SpeedTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ld6/a$a;", "<init>", "()V", "Lr8/z;", "o", "s", "n", "q", "u", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStop", "onResume", "onDestroy", "onBackPressed", "Ld6/a;", "a", "Ld6/a;", "speedtestManager", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "mTvStart", "Lcom/live/evo/widget/GaugeView;", "c", "Lcom/live/evo/widget/GaugeView;", "mGvDownload", "d", "mDownloadPer", "e", "mCurDownload", "f", "mGvUpload", "g", "mUploadPer", "h", "mCurUpload", "i", "mInfo", "Landroid/animation/ValueAnimator;", "j", "Landroid/animation/ValueAnimator;", "mAnimator", "", "k", "Z", "mBackPressedAgain", "Landroid/os/Handler;", "l", "Landroid/os/Handler;", "mHandler", "m", "mClientVal", "mServerVal", "mPingVal", "p", "mJitterVal", "mDownloadVal", "r", "mUploadVal", "mIsTesting", "Ljava/util/Locale;", "t", "Ljava/util/Locale;", "mLocale", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeedTestActivity extends AppCompatActivity implements d6.a.InterfaceC0171a {

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f5380v;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private d6.a speedtestManager;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView mTvStart;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private GaugeView mGvDownload;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mDownloadPer;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mCurDownload;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GaugeView mGvUpload;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mUploadPer;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mCurUpload;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mInfo;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mAnimator;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mBackPressedAgain;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mClientVal;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mServerVal;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView mPingVal;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mJitterVal;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mDownloadVal;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView mUploadVal;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTesting;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Locale mLocale;

    /* JADX INFO: renamed from: com.live.evo.activity.SpeedTestActivity$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo/activity/SpeedTestActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lr8/z;", "a", "(Landroid/content/Context;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final void a(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            context.startActivity(new Intent(context, (Class<?>) SpeedTestActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(SpeedTestActivity speedTestActivity) {
        speedTestActivity.mBackPressedAgain = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    static {
        StubApp.interface11(11815);
        INSTANCE = new Companion(null);
        f5380v = "SpeedTestActivity";
    }

    private final void n() {
        this.mLocale = Build.VERSION.SDK_INT >= 24 ? getApplication().getResources().getConfiguration().getLocales().get(0) : getApplication().getResources().getConfiguration().locale;
    }

    private final void o() {
        this.mHandler = new Handler();
        TextView textView = this.mTvStart;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.activity.p2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeedTestActivity.p(this.f5497a, view);
                }
            });
        }
        this.speedtestManager = d6.a.a(MyApplication.a());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setDuration(1500L);
        TextView textView2 = this.mTvStart;
        if (textView2 != null) {
            textView2.setAnimation(alphaAnimation);
        }
        alphaAnimation.start();
    }

    private final void q() {
        if (this.mAnimator == null) {
            this.mAnimator = ValueAnimator.ofInt(0, 100, 0);
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(3000L);
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.live.evo.activity.q2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    SpeedTestActivity.r(this.f5503a, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(SpeedTestActivity speedTestActivity, ValueAnimator animation) {
        kotlin.jvm.internal.m.f(animation, "animation");
        GaugeView gaugeView = speedTestActivity.mGvDownload;
        if (gaugeView != null) {
            Object animatedValue = animation.getAnimatedValue();
            kotlin.jvm.internal.m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            gaugeView.setValue(((Integer) animatedValue).intValue());
        }
        GaugeView gaugeView2 = speedTestActivity.mGvUpload;
        if (gaugeView2 != null) {
            Object animatedValue2 = animation.getAnimatedValue();
            kotlin.jvm.internal.m.d(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
            gaugeView2.setValue(((Integer) animatedValue2).intValue());
        }
        Object animatedValue3 = animation.getAnimatedValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(animatedValue3);
        String string = sb2.toString();
        TextView textView = speedTestActivity.mCurDownload;
        if (textView != null) {
            textView.setText(string);
        }
        TextView textView2 = speedTestActivity.mCurUpload;
        if (textView2 != null) {
            textView2.setText(string);
        }
        TextView textView3 = speedTestActivity.mDownloadPer;
        if (textView3 != null) {
            textView3.setText(string + "%");
        }
        TextView textView4 = speedTestActivity.mUploadPer;
        if (textView4 != null) {
            textView4.setText(string + "%");
        }
    }

    private final void u() {
        if (this.mIsTesting) {
            com.live.evo.util.r1.a(this, R$string.retry_later);
            return;
        }
        this.mIsTesting = true;
        q();
        GaugeView gaugeView = this.mGvDownload;
        if (gaugeView != null) {
            gaugeView.setValue(0);
        }
        TextView textView = this.mCurDownload;
        if (textView != null) {
            textView.setText("0.00");
        }
        TextView textView2 = this.mDownloadPer;
        if (textView2 != null) {
            textView2.setText("0%");
        }
        GaugeView gaugeView2 = this.mGvUpload;
        if (gaugeView2 != null) {
            gaugeView2.setValue(0);
        }
        TextView textView3 = this.mCurUpload;
        if (textView3 != null) {
            textView3.setText("0.00");
        }
        TextView textView4 = this.mUploadPer;
        if (textView4 != null) {
            textView4.setText("0%");
        }
        TextView textView5 = this.mInfo;
        if (textView5 != null) {
            textView5.setText(getResources().getString(R$string.init_env));
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mBackPressedAgain) {
            finish();
        } else {
            com.live.evo.util.r1.a(this, R$string.backpress_agrain_exit);
            this.mBackPressedAgain = true;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.live.evo.activity.o2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeedTestActivity.t(this.f5491a);
                    }
                }, 2500L);
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SpeedTestActivity speedTestActivity, View view) {
        speedTestActivity.u();
    }

    private final void s() {
        this.mTvStart = (TextView) findViewById(R$id.tv_start);
        this.mClientVal = (TextView) findViewById(R$id.client_val);
        this.mServerVal = (TextView) findViewById(R$id.server_val);
        this.mPingVal = (TextView) findViewById(R$id.ping_val);
        this.mJitterVal = (TextView) findViewById(R$id.jitter_val);
        this.mDownloadVal = (TextView) findViewById(R$id.download_val);
        this.mUploadVal = (TextView) findViewById(R$id.upload_val);
        this.mInfo = (TextView) findViewById(R$id.tv_info);
        this.mCurDownload = (TextView) findViewById(R$id.tv_download_current_speed);
        this.mDownloadPer = (TextView) findViewById(R$id.tv_download_per);
        this.mGvDownload = (GaugeView) findViewById(R$id.gv_download);
        this.mCurUpload = (TextView) findViewById(R$id.tv_upload_current_speed);
        this.mUploadPer = (TextView) findViewById(R$id.tv_upload_per);
        this.mGvUpload = (GaugeView) findViewById(R$id.gv_upload);
        TextView textView = this.mPingVal;
        if (textView != null) {
            textView.setText("-");
        }
        TextView textView2 = this.mJitterVal;
        if (textView2 != null) {
            textView2.setText("-");
        }
        TextView textView3 = this.mDownloadVal;
        if (textView3 != null) {
            textView3.setText("-");
        }
        TextView textView4 = this.mUploadVal;
        if (textView4 != null) {
            textView4.setText("-");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        d6.a aVar = this.speedtestManager;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        d6.a aVar = this.speedtestManager;
        if (aVar != null) {
            aVar.c();
        }
        d6.a aVar2 = this.speedtestManager;
        if (aVar2 != null) {
            aVar2.b(null);
        }
    }
}
