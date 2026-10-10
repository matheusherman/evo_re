package t.v.c.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import c9.p;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.n;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\nB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00103\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010+R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010+R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010'R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00105R\u0016\u0010H\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010+R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lt/v/c/widget/GlobalMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lx1/f1/lb/marquee/a$a;", "Landroid/content/Context;", "con", "<init>", "(Landroid/content/Context;)V", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lt/v/c/widget/GlobalMarqueeTextView$a;", "speed", "p", "(Lt/v/c/widget/GlobalMarqueeTextView$a;)I", "Lr8/z;", "setSpeed", "(Lt/v/c/widget/GlobalMarqueeTextView$a;)V", "", "text", "setText", "(Ljava/lang/String;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "stop", "()Z", "isRunning", "content", "a", "(Ljava/lang/String;)Z", "Z", "mStopMarquee", "", "b", "F", "mRestartOffset", "c", "Ljava/lang/String;", "mText", "d", "mCoordinateX", "e", "mTextWidth", "f", "I", "step", "g", "mWithPerStep", "h", "mHalfWith", "i", "mMaxStep", "j", "y", "k", "isNotInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInDisplay", "m", "displayCnt", "n", "minSpeed", "Landroid/os/Handler;", "o", "Landroid/os/Handler;", "mHandler", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalMarqueeTextView extends AppCompatTextView implements x1.f1.lb.marquee.a.InterfaceC0417a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mStopMarquee;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float mRestartOffset;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mText;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mCoordinateX;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mTextWidth;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int step;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mWithPerStep;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mHalfWith;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mMaxStep;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float y;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isNotInit;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isInDisplay;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int displayCnt;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float minSpeed;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lt/v/c/widget/GlobalMarqueeTextView$a;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "c", "d", "e", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum a {
        VERY_SLOW,
        SLOW,
        MIDDLE,
        FAST,
        VERY_FAST;


        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ w8.a f18676g = w8.b.a(a());
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"t/v/c/widget/GlobalMarqueeTextView$c", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "", "a", "Z", "isListenerRemoved", "()Z", "setListenerRemoved", "(Z)V", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isListenerRemoved;

        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            float fAbs;
            m.f(msg, "msg");
            if (msg.what == 0) {
                if (GlobalMarqueeTextView.this.mCoordinateX < GlobalMarqueeTextView.this.mRestartOffset) {
                    if (GlobalMarqueeTextView.this.displayCnt > 0) {
                        GlobalMarqueeTextView.this.mText = "";
                        GlobalMarqueeTextView.this.isInDisplay.set(false);
                    } else {
                        GlobalMarqueeTextView globalMarqueeTextView = GlobalMarqueeTextView.this;
                        globalMarqueeTextView.mCoordinateX = globalMarqueeTextView.getWidth();
                        GlobalMarqueeTextView.this.displayCnt++;
                        GlobalMarqueeTextView.this.invalidate();
                        if (!GlobalMarqueeTextView.this.mStopMarquee) {
                            sendEmptyMessageDelayed(0, 30L);
                        }
                    }
                } else if (GlobalMarqueeTextView.this.isShown()) {
                    if (this.isListenerRemoved) {
                        x1.f1.lb.marquee.a.f20738a.n(GlobalMarqueeTextView.this);
                        this.isListenerRemoved = false;
                    }
                    if (GlobalMarqueeTextView.this.step == 0) {
                        float f10 = GlobalMarqueeTextView.this.mCoordinateX + GlobalMarqueeTextView.this.mTextWidth;
                        GlobalMarqueeTextView globalMarqueeTextView2 = GlobalMarqueeTextView.this;
                        float f11 = globalMarqueeTextView2.mCoordinateX;
                        if (f10 > 0.0f) {
                            fAbs = Math.abs(f10 - GlobalMarqueeTextView.this.mHalfWith) / GlobalMarqueeTextView.this.mWithPerStep;
                            if (fAbs <= GlobalMarqueeTextView.this.minSpeed) {
                                fAbs = GlobalMarqueeTextView.this.minSpeed;
                            }
                        } else {
                            fAbs = GlobalMarqueeTextView.this.minSpeed;
                        }
                        globalMarqueeTextView2.mCoordinateX = f11 - fAbs;
                    } else {
                        GlobalMarqueeTextView.this.mCoordinateX -= GlobalMarqueeTextView.this.step;
                    }
                    GlobalMarqueeTextView.this.invalidate();
                    if (!GlobalMarqueeTextView.this.mStopMarquee) {
                        sendEmptyMessageDelayed(0, 30L);
                    }
                } else {
                    if (!this.isListenerRemoved) {
                        x1.f1.lb.marquee.a.f20738a.s(GlobalMarqueeTextView.this);
                        this.isListenerRemoved = true;
                    }
                    if (!GlobalMarqueeTextView.this.mStopMarquee) {
                        sendEmptyMessageDelayed(0, 30L);
                    }
                }
            }
            super.handleMessage(msg);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "t.v.c.widget.GlobalMarqueeTextView$start$1", f = "GlobalMarqueeTextView.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $content;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$content = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return GlobalMarqueeTextView.this.new d(this.$content, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                GlobalMarqueeTextView.this.setVisibility(0);
                GlobalMarqueeTextView.this.setText(this.$content);
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "t.v.c.widget.GlobalMarqueeTextView$stop$1", f = "GlobalMarqueeTextView.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        e(v8.f<? super e> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return GlobalMarqueeTextView.this.new e(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                GlobalMarqueeTextView.this.setVisibility(8);
                GlobalMarqueeTextView.this.mText = "";
                if (GlobalMarqueeTextView.this.mHandler.hasMessages(0)) {
                    GlobalMarqueeTextView.this.mHandler.removeMessages(0);
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalMarqueeTextView(Context con) {
        super(con);
        m.f(con, "con");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        this.mStopMarquee = false;
        if (this.mText.length() > 0) {
            this.mHandler.sendEmptyMessageDelayed(0, 2000L);
        }
        x1.f1.lb.marquee.a.f20738a.n(this);
        super.onAttachedToWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        this.mStopMarquee = true;
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        x1.f1.lb.marquee.a.f20738a.s(this);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18677a;

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
            f18677a = iArr;
        }
    }

    private final int p(a speed) {
        int i10 = b.f18677a[speed.ordinal()];
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

    @Override // x1.f1.lb.marquee.a.InterfaceC0417a
    public boolean a(String content) {
        m.f(content, "content");
        if (this.mStopMarquee) {
            return false;
        }
        if ((getVisibility() == 0 && !isShown()) || !this.isInDisplay.compareAndSet(false, true)) {
            return false;
        }
        j.d(m0.b(), null, null, new d(content, null), 3, null);
        return true;
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

    @Override // x1.f1.lb.marquee.a.InterfaceC0417a
    public boolean isRunning() {
        if (isShown() && this.isInDisplay.get() && !this.mStopMarquee) {
            return true;
        }
        return false;
    }

    @Override // x1.f1.lb.marquee.a.InterfaceC0417a
    public boolean stop() {
        if (getVisibility() != 8 && !this.isInDisplay.get()) {
            j.d(m0.b(), null, null, new e(null), 3, null);
            return true;
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.f(context, "context");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalMarqueeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        this.mText = "";
        this.isNotInit = true;
        this.isInDisplay = new AtomicBoolean(false);
        this.minSpeed = 1.0f;
        this.mHandler = new c(Looper.getMainLooper());
    }
}
