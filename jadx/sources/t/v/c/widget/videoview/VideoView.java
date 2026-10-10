package t.v.c.widget.videoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import q6.c;
import t.v.c.widget.FrameLayout;
import t.v.c.widget.ImageView;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.TextView;
import x1.f1.lb.util.d;
import x1.f1.lb.widget.videoview.e;
import x1.f1.lb.widget.videoview.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010\u0017J\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u0017J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J1\u0010/\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020*2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100R\u001c\u00104\u001a\n 2*\u0004\u0018\u000101018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00103R\u0018\u00106\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00105R\u0018\u00108\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010;R\u0016\u0010>\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010@¨\u0006B"}, d2 = {"Lt/v/c/widget/videoview/VideoView;", "Lt/v/c/widget/FrameLayout;", "Lx1/f1/lb/widget/videoview/e;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "i", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "q", "Landroid/view/View;", "view", "j", "(Landroid/view/View;)V", "h", "()I", "m", "n", "()V", "", "tip", "videoName", "errorCode", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "e", "f", "stopAnimation", NotificationCompat.CATEGORY_MESSAGE, "", "k", "(Ljava/lang/String;)Z", "Lx1/f1/lb/widget/videoview/z0;", "getVideoViewHandler", "()Lx1/f1/lb/widget/videoview/z0;", "Lt/v/c/widget/LinearLayout;", "tipLayout", "Lt/v/c/widget/TextView;", "tipTextview", "loadingTextView", "Lt/v/c/widget/ImageView;", "loadingImageview", "r", "(Lt/v/c/widget/LinearLayout;Lt/v/c/widget/TextView;Lt/v/c/widget/TextView;Lt/v/c/widget/ImageView;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lt/v/c/widget/ImageView;", "mLoadingImageView", "Lt/v/c/widget/TextView;", "mTipTextView", "g", "mLoadingTxtView", "Lt/v/c/widget/LinearLayout;", "mTipLinearLayout", "Lx1/f1/lb/widget/videoview/z0;", "mVideoViewHandler", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoView extends FrameLayout implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mLoadingImageView;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTipTextView;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mLoadingTxtView;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mTipLinearLayout;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private z0 mVideoViewHandler;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoView(Context context) {
        super(context);
        m.f(context, "context");
        this.logger = c.d(VideoView.class);
        this.mHandler = new Handler(Looper.getMainLooper());
        q(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(VideoView videoView) {
        LinearLayout linearLayout = videoView.mTipLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void q(Context context) {
        z0 z0Var = new z0();
        SurfaceRenderView surfaceRenderView = new SurfaceRenderView(context);
        surfaceRenderView.setVideoView(this);
        z0Var.m1(context, this, surfaceRenderView);
        this.mVideoViewHandler = z0Var;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void d(String tip, String videoName, Integer errorCode) {
        LinearLayout linearLayout;
        TextView textView;
        m.f(tip, "tip");
        TextView textView2 = this.mTipTextView;
        if (textView2 == null) {
            this.logger.warn(tip, new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(videoName) && tip.length() > 0) {
            if (errorCode == null) {
                tip = videoName + ": " + tip;
            } else {
                tip = videoName + ": " + tip + "[" + errorCode + "]";
            }
        }
        ImageView imageView = this.mLoadingImageView;
        if (imageView != null && imageView.getVisibility() != 8) {
            imageView.clearAnimation();
            imageView.setVisibility(8);
        }
        if (!m.a(this.mLoadingTxtView, textView2) && (textView = this.mLoadingTxtView) != null) {
            textView.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.mTipLinearLayout;
        if ((linearLayout2 == null || linearLayout2.getVisibility() != 0) && (linearLayout = this.mTipLinearLayout) != null) {
            linearLayout.setVisibility(0);
        }
        textView2.setText(tip);
        if (textView2.getVisibility() != 0) {
            textView2.setVisibility(0);
        }
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void e() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (!m.a(this.mTipTextView, this.mLoadingTxtView) && (((textView2 = this.mLoadingTxtView) == null || textView2.getVisibility() != 8) && (textView3 = this.mLoadingTxtView) != null)) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.mTipTextView;
        if ((textView4 == null || textView4.getVisibility() != 8) && (textView = this.mTipTextView) != null) {
            textView.setVisibility(8);
        }
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void f() {
        LinearLayout linearLayout = this.mTipLinearLayout;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            this.mHandler.post(new Runnable() { // from class: t.v.c.widget.videoview.b
                @Override // java.lang.Runnable
                public final void run() {
                    VideoView.p(this.f18859a);
                }
            });
        }
    }

    public z0 getVideoViewHandler() {
        z0 z0Var = this.mVideoViewHandler;
        if (z0Var != null) {
            return z0Var;
        }
        m.v("mVideoViewHandler");
        return null;
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void j(View view) {
        m.f(view, "view");
        addView(view);
    }

    @Override // x1.f1.lb.widget.videoview.e
    public boolean k(String msg) {
        LinearLayout linearLayout;
        m.f(msg, "msg");
        ImageView imageView = this.mLoadingImageView;
        if (imageView == null || imageView.getVisibility() == 0) {
            return false;
        }
        TextView textView = this.mLoadingTxtView;
        if (textView != null) {
            textView.setText(msg);
            textView.setVisibility(0);
        }
        imageView.setVisibility(0);
        LinearLayout linearLayout2 = this.mTipLinearLayout;
        if ((linearLayout2 == null || linearLayout2.getVisibility() != 0) && (linearLayout = this.mTipLinearLayout) != null) {
            linearLayout.setVisibility(0);
        }
        d.f21359a.a(imageView);
        return true;
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void n() {
        TextView textView;
        if (m.a(this.mLoadingTxtView, this.mTipTextView) || (textView = this.mLoadingTxtView) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void r(LinearLayout tipLayout, TextView tipTextview, TextView loadingTextView, ImageView loadingImageview) {
        m.f(loadingTextView, "loadingTextView");
        m.f(loadingImageview, "loadingImageview");
        this.mLoadingImageView = loadingImageview;
        loadingImageview.setVisibility(8);
        if (tipTextview == null) {
            tipTextview = loadingTextView;
        }
        this.mTipTextView = tipTextview;
        this.mLoadingTxtView = loadingTextView;
        this.mTipLinearLayout = tipLayout;
    }

    @Override // x1.f1.lb.widget.videoview.e
    public void stopAnimation() {
        ImageView imageView = this.mLoadingImageView;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        imageView.clearAnimation();
        imageView.setVisibility(8);
        LinearLayout linearLayout = this.mTipLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // x1.f1.lb.widget.videoview.e
    public int h() {
        return getMeasuredWidth();
    }

    @Override // x1.f1.lb.widget.videoview.e
    public int m() {
        return getMeasuredHeight();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.f(context, "context");
        this.logger = c.d(VideoView.class);
        this.mHandler = new Handler(Looper.getMainLooper());
        q(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"DefaultLocale"})
    public VideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        this.logger = c.d(VideoView.class);
        this.mHandler = new Handler(Looper.getMainLooper());
        q(context);
    }
}
