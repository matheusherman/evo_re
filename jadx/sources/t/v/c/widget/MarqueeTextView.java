package t.v.c.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001FB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\tB#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010.\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010&R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010&R\u0016\u0010;\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00100R\u0016\u0010B\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010D¨\u0006G"}, d2 = {"Lt/v/c/widget/MarqueeTextView;", "Lt/v/c/widget/TextView;", "Landroid/content/Context;", "con", "<init>", "(Landroid/content/Context;)V", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "q", "()V", "Lt/v/c/widget/MarqueeTextView$a;", "speed", "p", "(Lt/v/c/widget/MarqueeTextView$a;)I", "setSpeed", "(Lt/v/c/widget/MarqueeTextView$a;)V", "", "text", "setText", "(Ljava/lang/String;)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "c", "Z", "mStopMarquee", "", "d", "F", "mRestartOffset", "e", "Ljava/lang/String;", "mText", "f", "mCoordinateX", "g", "mTextWidth", "h", "I", "step", "i", "mWithPerStep", "j", "mHalfWith", "k", "mMaxStep", "l", "y", "m", "isNotInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "n", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInDisplay", "o", "displayCnt", "minSpeed", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "a", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarqueeTextView extends TextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mStopMarquee;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mRestartOffset;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mText;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mCoordinateX;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mTextWidth;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int step;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mWithPerStep;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int mHalfWith;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int mMaxStep;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float y;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isNotInit;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isInDisplay;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int displayCnt;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float minSpeed;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lt/v/c/widget/MarqueeTextView$a;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "c", "d", "e", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum a {
        VERY_SLOW,
        SLOW,
        MIDDLE,
        FAST,
        VERY_FAST;


        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ w8.a f18706g = w8.b.a(a());
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"t/v/c/widget/MarqueeTextView$c", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            float fAbs;
            m.f(msg, "msg");
            if (msg.what == 0) {
                if (MarqueeTextView.this.mCoordinateX < MarqueeTextView.this.mRestartOffset) {
                    if (MarqueeTextView.this.displayCnt > 0) {
                        MarqueeTextView.this.mText = "";
                        MarqueeTextView.this.isInDisplay.set(false);
                    } else {
                        MarqueeTextView marqueeTextView = MarqueeTextView.this;
                        marqueeTextView.mCoordinateX = marqueeTextView.getWidth();
                        MarqueeTextView.this.displayCnt++;
                        MarqueeTextView.this.invalidate();
                        if (!MarqueeTextView.this.mStopMarquee) {
                            sendEmptyMessageDelayed(0, 30L);
                        }
                    }
                } else if (MarqueeTextView.this.isShown()) {
                    if (MarqueeTextView.this.step == 0) {
                        float f10 = MarqueeTextView.this.mCoordinateX + MarqueeTextView.this.mTextWidth;
                        MarqueeTextView marqueeTextView2 = MarqueeTextView.this;
                        float f11 = marqueeTextView2.mCoordinateX;
                        if (f10 > 0.0f) {
                            fAbs = Math.abs(f10 - MarqueeTextView.this.mHalfWith) / MarqueeTextView.this.mWithPerStep;
                            if (fAbs <= MarqueeTextView.this.minSpeed) {
                                fAbs = MarqueeTextView.this.minSpeed;
                            }
                        } else {
                            fAbs = MarqueeTextView.this.minSpeed;
                        }
                        marqueeTextView2.mCoordinateX = f11 - fAbs;
                    } else {
                        MarqueeTextView.this.mCoordinateX -= MarqueeTextView.this.step;
                    }
                    MarqueeTextView.this.invalidate();
                    if (!MarqueeTextView.this.mStopMarquee) {
                        sendEmptyMessageDelayed(0, 30L);
                    }
                } else if (!MarqueeTextView.this.mStopMarquee) {
                    sendEmptyMessageDelayed(0, 30L);
                }
            }
            super.handleMessage(msg);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context con) {
        super(con);
        m.f(con, "con");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
        q();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        this.mStopMarquee = false;
        if (this.mText.length() > 0) {
            this.mHandler.sendEmptyMessageDelayed(0, 2000L);
        }
        super.onAttachedToWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        this.mStopMarquee = true;
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18707a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.VERY_SLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.SLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.FAST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.VERY_FAST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f18707a = iArr;
        }
    }

    private final int p(a speed) {
        int i10 = b.f18707a[speed.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 3;
        }
        if (i10 == 3) {
            return 5;
        }
        if (i10 == 4) {
            return 7;
        }
        if (i10 == 5) {
            return 9;
        }
        throw new n();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mText.length() == 0) {
            return;
        }
        if (this.isNotInit) {
            this.y = (getHeight() * 3) >> 2;
            int width = (getWidth() >> 1) / this.mMaxStep;
            this.mWithPerStep = width;
            if (width < 1) {
                this.mWithPerStep = 1;
            }
            this.mHalfWith = (getWidth() + ((int) this.mTextWidth)) >> 1;
            this.minSpeed = p(a.SLOW);
            this.isNotInit = false;
        }
        canvas.drawText(this.mText, this.mCoordinateX, this.y, getPaint());
    }

    public final void setSpeed(a speed) {
        m.f(speed, "speed");
        this.step = p(speed);
    }

    public final void setText(String text) {
        if (text == null) {
            text = "";
        }
        this.mText = text;
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        if (this.mText.length() > 0) {
            float fMeasureText = getPaint().measureText(this.mText);
            this.mTextWidth = fMeasureText;
            float f10 = -(fMeasureText + 100);
            this.mRestartOffset = f10;
            this.isNotInit = true;
            this.displayCnt = 0;
            this.mCoordinateX = f10;
            this.mMaxStep = p(a.VERY_FAST);
            this.mHandler.sendEmptyMessageDelayed(0, 2000L);
        }
    }

    private final void q() {
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.f(context, "context");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
        q();
    }
}
