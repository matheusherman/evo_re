package com.live.evo.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.o0;
import com.live.evo.util.o1;
import com.live.evo.util.q1;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004*\u0001n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u001f\u0010\u0014\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u001b\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\nR\u001c\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010?R\u0018\u0010H\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010;R\u0018\u0010J\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010?R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010?R\u0018\u0010P\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010?R\u0018\u0010Q\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010?R\u0018\u0010R\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010?R\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010?R\u0018\u0010W\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010?R\u0018\u0010Y\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010?R\u0018\u0010Z\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010?R\u0018\u0010[\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010?R\u0018\u0010]\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010?R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010g\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010dR\u0016\u0010i\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u00107R\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010o¨\u0006q"}, d2 = {"Lcom/live/evo/widget/q;", "Landroid/widget/PopupWindow;", "Landroid/content/Context;", "context", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/content/Context;Landroid/os/Handler;)V", "Lr8/z;", "p", "()V", "r", "Li5/h;", "dataBean", "v", "(Li5/h;)V", "t", "u", "", "inputCode", "s", "(Li5/h;I)V", "Landroid/view/View;", "parent", "gravity", "x", "y", "showAtLocation", "(Landroid/view/View;III)V", "dismiss", "q", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "logger", "b", "Landroid/os/Handler;", "mHandler", "Landroid/view/LayoutInflater;", "c", "Landroid/view/LayoutInflater;", "mInflater", "d", "Landroid/view/View;", "mRootView", "e", "Landroid/content/Context;", "mContext", "", "f", "F", "mShowAlpha", "", "g", "J", "mAnimDuration", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "mIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTvEpgChannelPos", "j", "mTvEpgChannelName", "k", "mTvCurrentEpgTitle", "l", "mTvCurrentEpgName", "m", "mImgPlayBack", "n", "mStartTime", "Landroid/widget/ProgressBar;", "o", "Landroid/widget/ProgressBar;", "mProgressBar", "mStopTime", "mNextEpgTitle", "mNextEpgName", "mTvCurrentTime", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mLayoutKey", "mTvEpgOk", "mTvEpgLeft", "w", "mTvEpgRight", "mTvEpgDel", "mTvEpgMenu", "z", "mTvSession", "Ljava/text/SimpleDateFormat;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/text/SimpleDateFormat;", "formatter", "", "B", "Ljava/lang/String;", "mCurrentEpgId", "C", "lastChannelId", "D", "lastTime", "", ExifInterface.LONGITUDE_EAST, "Z", "isStop", "com/live/evo/widget/q$a", "Lcom/live/evo/widget/q$a;", "refreshRunnable", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q extends PopupWindow {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private SimpleDateFormat formatter;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private String mCurrentEpgId;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private String lastChannelId;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private long lastTime;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private boolean isStop;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private final a refreshRunnable;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LayoutInflater mInflater;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float mShowAlpha;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long mAnimDuration;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIcon;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgChannelPos;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgChannelName;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCurrentEpgTitle;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCurrentEpgName;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mImgPlayBack;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mStartTime;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ProgressBar mProgressBar;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mStopTime;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mNextEpgTitle;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView mNextEpgName;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCurrentTime;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mLayoutKey;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgOk;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgLeft;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgRight;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgDel;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private TextView mTvEpgMenu;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private TextView mTvSession;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/widget/q$a", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            boolean z10;
            String str;
            try {
                if (q.this.formatter == null) {
                    q.this.formatter = o1.a(x1.j(R$string.yyyyMMddHHmmss));
                    SimpleDateFormat simpleDateFormat = q.this.formatter;
                    if (simpleDateFormat != null) {
                        simpleDateFormat.setTimeZone(TimeZone.getDefault());
                    }
                }
                Date date = new Date(u1.b().a());
                SimpleDateFormat simpleDateFormat2 = q.this.formatter;
                if (simpleDateFormat2 == null || (str = simpleDateFormat2.format(date)) == null) {
                    str = "";
                }
                TextView textView = q.this.mTvCurrentTime;
                if (textView != null) {
                    textView.setText(str);
                }
                if (z10) {
                    return;
                }
            } catch (Exception e10) {
                q6.b bVar = q.this.logger;
                kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
                c5.b.c(bVar, e10, e10.getMessage());
                if (z10) {
                    return;
                }
            } finally {
                if (!q.this.isStop && (handler = q.this.mHandler) != null) {
                    handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.widget.PopupCurrentEpgWindow$satData$1", f = "PopupCurrentEpgWindow.kt", l = {248}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ b0<String> $epgId;
        final /* synthetic */ String $finalEpgId;
        int label;
        final /* synthetic */ q this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.widget.PopupCurrentEpgWindow$satData$1$1", f = "PopupCurrentEpgWindow.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Li5/p;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends i5.p>>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ q this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(q qVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = qVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends i5.p>> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    q6.b bVar = this.this$0.logger;
                    kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
                    c5.b.c(bVar, th, "PopupCurrentEpgWindow");
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.widget.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0119b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f7700a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f7701b;

            C0119b(q qVar, String str) {
                this.f7700a = qVar;
                this.f7701b = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(q qVar, List list, String str) {
                qVar.r();
                if (list.isEmpty() || !TextUtils.equals(str, qVar.mCurrentEpgId)) {
                    TextView textView = qVar.mTvCurrentEpgName;
                    kotlin.jvm.internal.m.c(textView);
                    textView.setText(x1.j(R$string.epg_none));
                    TextView textView2 = qVar.mNextEpgName;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setText(x1.j(R$string.epg_none));
                    return;
                }
                qVar.lastChannelId = qVar.mCurrentEpgId;
                qVar.lastTime = u1.b().a();
                long jA = u1.b().a();
                int size = list.size();
                boolean z10 = false;
                boolean z11 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    i5.p pVar = (i5.p) list.get(i10);
                    Long lF = pVar.f();
                    kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                    long jLongValue = lF.longValue();
                    if (jLongValue < jA && !z10) {
                        Long lG = pVar.g();
                        kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                        long jLongValue2 = lG.longValue();
                        String strM = q1.m(jLongValue, x1.j(R$string.HHmm));
                        kotlin.jvm.internal.m.e(strM, "toDate(...)");
                        String strM2 = q1.m(jLongValue2, x1.j(R$string.HHmm));
                        kotlin.jvm.internal.m.e(strM2, "toDate(...)");
                        String strE = pVar.e();
                        if (TextUtils.isEmpty(strE)) {
                            strE = x1.j(R$string.epg_none);
                        }
                        TextView textView3 = qVar.mTvCurrentEpgName;
                        kotlin.jvm.internal.m.c(textView3);
                        textView3.setText(strE);
                        TextView textView4 = qVar.mStartTime;
                        kotlin.jvm.internal.m.c(textView4);
                        textView4.setText(strM);
                        TextView textView5 = qVar.mStopTime;
                        kotlin.jvm.internal.m.c(textView5);
                        textView5.setText(strM2);
                        long j10 = jLongValue2 - jLongValue;
                        int iA = j10 <= 0 ? 0 : (int) (((u1.b().a() - jLongValue) * ((long) 100)) / j10);
                        ProgressBar progressBar = qVar.mProgressBar;
                        kotlin.jvm.internal.m.c(progressBar);
                        progressBar.setProgress(iA);
                        z10 = true;
                    } else if (!z11) {
                        String strE2 = pVar.e();
                        if (TextUtils.isEmpty(strE2)) {
                            strE2 = x1.j(R$string.epg_none);
                        }
                        TextView textView6 = qVar.mNextEpgName;
                        kotlin.jvm.internal.m.c(textView6);
                        textView6.setText(strE2);
                        z11 = true;
                    }
                }
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List<? extends i5.p> list, v8.f<? super z> fVar) {
                Handler handler = this.f7700a.mHandler;
                if (handler != null) {
                    final q qVar = this.f7700a;
                    final String str = this.f7701b;
                    kotlin.coroutines.jvm.internal.b.a(handler.post(new Runnable() { // from class: com.live.evo.widget.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.b.C0119b.d(qVar, list, str);
                        }
                    }));
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(b0<String> b0Var, q qVar, String str, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$epgId = b0Var;
            this.this$0 = qVar;
            this.$finalEpgId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$epgId, this.this$0, this.$finalEpgId, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(com.live.evo.util.p.f7317a.a(this.$epgId.element), new a(this.this$0, null));
                C0119b c0119b = new C0119b(this.this$0, this.$finalEpgId);
                this.label = 1;
                if (fVarF.collect(c0119b, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    private final void u() {
        this.isStop = true;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.refreshRunnable);
        }
    }

    private final void p() {
        LayoutInflater layoutInflater = this.mInflater;
        View viewInflate = layoutInflater != null ? layoutInflater.inflate(R$layout.current_epg_layout, (ViewGroup) null) : null;
        this.mRootView = viewInflate;
        setContentView(viewInflate);
        setFocusable(false);
        setBackgroundDrawable(x1.f(R$drawable.bg_popup_menu));
        setOutsideTouchable(false);
        setWidth(-1);
        setHeight(-2);
        View view = this.mRootView;
        kotlin.jvm.internal.m.c(view);
        this.mIcon = (ImageView) view.findViewById(R$id.currentepgl_iv_icon);
        View view2 = this.mRootView;
        kotlin.jvm.internal.m.c(view2);
        this.mTvEpgChannelPos = (TextView) view2.findViewById(R$id.currentepgl_tv_channel_pos);
        View view3 = this.mRootView;
        kotlin.jvm.internal.m.c(view3);
        this.mTvEpgChannelName = (TextView) view3.findViewById(R$id.currentepgl_tv_channel_name);
        View view4 = this.mRootView;
        kotlin.jvm.internal.m.c(view4);
        this.mTvCurrentEpgTitle = (TextView) view4.findViewById(R$id.currentepgl_tv_current_epg_title);
        View view5 = this.mRootView;
        kotlin.jvm.internal.m.c(view5);
        this.mTvCurrentEpgName = (TextView) view5.findViewById(R$id.currentepgl_mtv_current_epg_name);
        View view6 = this.mRootView;
        kotlin.jvm.internal.m.c(view6);
        this.mImgPlayBack = (ImageView) view6.findViewById(R$id.currentepgl_playback);
        View view7 = this.mRootView;
        kotlin.jvm.internal.m.c(view7);
        this.mTvCurrentTime = (TextView) view7.findViewById(R$id.currentepgl_tv_current_time);
        View view8 = this.mRootView;
        kotlin.jvm.internal.m.c(view8);
        this.mStartTime = (TextView) view8.findViewById(R$id.currentepgl_tv_current_epg_start);
        View view9 = this.mRootView;
        kotlin.jvm.internal.m.c(view9);
        this.mProgressBar = (ProgressBar) view9.findViewById(R$id.currentepgl_pb_progress);
        View view10 = this.mRootView;
        kotlin.jvm.internal.m.c(view10);
        this.mStopTime = (TextView) view10.findViewById(R$id.currentepgl_tv_current_epg_stop);
        View view11 = this.mRootView;
        kotlin.jvm.internal.m.c(view11);
        this.mNextEpgTitle = (TextView) view11.findViewById(R$id.currentepgl_tv_next_epg_title);
        View view12 = this.mRootView;
        kotlin.jvm.internal.m.c(view12);
        this.mNextEpgName = (TextView) view12.findViewById(R$id.currentepgl_mtv_next_epg_name);
        View view13 = this.mRootView;
        kotlin.jvm.internal.m.c(view13);
        this.mLayoutKey = (LinearLayout) view13.findViewById(R$id.currentepgl_layout_keyimag);
        View view14 = this.mRootView;
        kotlin.jvm.internal.m.c(view14);
        this.mTvEpgOk = (TextView) view14.findViewById(R$id.currentepgl_tv_epg_ok);
        View view15 = this.mRootView;
        kotlin.jvm.internal.m.c(view15);
        this.mTvEpgLeft = (TextView) view15.findViewById(R$id.currentepgl_tv_epg_left);
        View view16 = this.mRootView;
        kotlin.jvm.internal.m.c(view16);
        this.mTvEpgRight = (TextView) view16.findViewById(R$id.currentepgl_tv_epg_right);
        View view17 = this.mRootView;
        kotlin.jvm.internal.m.c(view17);
        this.mTvEpgDel = (TextView) view17.findViewById(R$id.currentepgl_tv_epg_del);
        View view18 = this.mRootView;
        kotlin.jvm.internal.m.c(view18);
        this.mTvEpgMenu = (TextView) view18.findViewById(R$id.currentepgl_tv_epg_menu);
        View view19 = this.mRootView;
        kotlin.jvm.internal.m.c(view19);
        this.mTvSession = (TextView) view19.findViewById(R$id.currentepgl_tv_sessionid);
        String strM = o0.p().m();
        if (!TextUtils.isEmpty(strM)) {
            kotlin.jvm.internal.m.c(strM);
            String strE = ua.n.E(strM, ",", "", false, 4, null);
            if (Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strE)) {
                ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(Color.parseColor(strE)), 19, 1);
                ProgressBar progressBar = this.mProgressBar;
                if (progressBar != null) {
                    progressBar.setProgressDrawable(clipDrawable);
                }
                ProgressBar progressBar2 = this.mProgressBar;
                if (progressBar2 != null) {
                    Context context = this.mContext;
                    kotlin.jvm.internal.m.c(context);
                    progressBar2.setBackgroundColor(context.getResources().getColor(R$color.progressbar_play_background));
                }
            }
        }
        com.live.evo.util.t.b(this.mTvCurrentTime);
        com.live.evo.util.t.b(this.mStartTime);
        com.live.evo.util.t.b(this.mStopTime);
        com.live.evo.util.t.b(this.mTvCurrentEpgTitle);
        com.live.evo.util.t.b(this.mTvCurrentEpgName);
        com.live.evo.util.t.b(this.mNextEpgTitle);
        com.live.evo.util.t.b(this.mNextEpgName);
        com.live.evo.util.t.b(this.mTvSession);
        com.live.evo.util.t.b(this.mTvEpgChannelPos);
        com.live.evo.util.t.c(this.mTvEpgChannelName);
        com.live.evo.util.t.c(this.mTvEpgOk);
        com.live.evo.util.t.c(this.mTvEpgLeft);
        com.live.evo.util.t.c(this.mTvEpgRight);
        com.live.evo.util.t.c(this.mTvEpgDel);
        com.live.evo.util.t.c(this.mTvEpgMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        TextView textView = this.mTvCurrentEpgName;
        kotlin.jvm.internal.m.c(textView);
        textView.setText("");
        TextView textView2 = this.mNextEpgName;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText("");
        TextView textView3 = this.mStartTime;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setText("");
        TextView textView4 = this.mStopTime;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setText("");
        ProgressBar progressBar = this.mProgressBar;
        kotlin.jvm.internal.m.c(progressBar);
        progressBar.setProgress(0);
    }

    private final void t() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(this.refreshRunnable);
        }
    }

    private final void v(i5.h dataBean) {
        ImageView imageView = this.mImgPlayBack;
        if (imageView == null || dataBean == null) {
            return;
        }
        kotlin.jvm.internal.m.c(imageView);
        imageView.setVisibility(8);
    }

    public final void q() {
        TextView textView = this.mTvCurrentEpgName;
        kotlin.jvm.internal.m.c(textView);
        textView.setSelected(true);
        TextView textView2 = this.mNextEpgName;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setSelected(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14, types: [T, java.lang.String] */
    public final void s(i5.h dataBean, int inputCode) {
        int i10;
        String strG;
        String strJ;
        b0 b0Var = new b0();
        b0Var.element = "";
        if (dataBean != null) {
            b0Var.element = dataBean.f();
            i10 = dataBean.i() + 1;
            strJ = dataBean.e();
            strG = dataBean.g();
        } else {
            i10 = inputCode + 1;
            strG = "";
            strJ = x1.j(R$string.no_program);
        }
        String strValueOf = String.valueOf(i10);
        if (i10 < 10) {
            strValueOf = "00" + i10;
        } else if (i10 < 100) {
            strValueOf = "0" + i10;
        }
        TextView textView = this.mTvEpgChannelPos;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(strValueOf);
        TextView textView2 = this.mTvEpgChannelName;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(strJ);
        com.live.evo.util.v.c(this.mContext, strG, 2131102158, this.mIcon);
        if (!kotlin.jvm.internal.m.a(this.lastChannelId, b0Var.element) || u1.b().a() - this.lastTime >= 2000) {
            T t10 = b0Var.element;
            this.mCurrentEpgId = (String) t10;
            if (dataBean == null) {
                r();
                TextView textView3 = this.mTvCurrentEpgName;
                kotlin.jvm.internal.m.c(textView3);
                textView3.setText(x1.j(R$string.epg_none));
                TextView textView4 = this.mNextEpgName;
                kotlin.jvm.internal.m.c(textView4);
                textView4.setText(x1.j(R$string.epg_none));
            } else {
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(b0Var, this, (String) t10, null), 3, null);
            }
            v(dataBean);
        }
    }

    public q(Context context, Handler handler) {
        super(context);
        this.logger = q6.c.d(q.class);
        this.mShowAlpha = 1.0f;
        this.mAnimDuration = 500L;
        this.lastChannelId = "";
        this.mHandler = handler;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        p();
        this.refreshRunnable = new a();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        u();
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View parent, int gravity, int x10, int y10) {
        super.showAtLocation(parent, gravity, x10, y10);
        t();
    }
}
