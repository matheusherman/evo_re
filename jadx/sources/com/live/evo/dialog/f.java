package com.live.evo.dialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.exifinterface.media.ExifInterface;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.o1;
import com.live.evo.util.q1;
import com.live.evo.util.r1;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.net.SyslogAppender;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0004*\u0001~\u0018\u00002\u00020\u0001:\u0001%B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\f¢\u0006\u0004\b$\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010*R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010ER\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010AR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010OR\u0018\u0010d\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010OR\u0018\u0010e\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010AR\u0018\u0010f\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010AR\u0018\u0010g\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010AR\u0018\u0010h\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010AR\u0018\u0010i\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010AR\u0018\u0010j\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010AR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010lR\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010nR\u0016\u0010r\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010SR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010SR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010AR\u0018\u0010|\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010SR\u0016\u0010}\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010qR\u0015\u0010\u0080\u0001\u001a\u00020~8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010\u007f¨\u0006\u0081\u0001"}, d2 = {"Lcom/live/evo/dialog/f;", "", "Landroid/content/Context;", "mContext", "Li5/h;", "channelData", "Landroid/os/Handler;", "handler", "Lx4/a;", "catchupListener", "<init>", "(Landroid/content/Context;Li5/h;Landroid/os/Handler;Lx4/a;)V", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "z", "u", "", "channelId", "", "success", "s", "(Ljava/lang/String;Z)V", "r", "(Ljava/lang/String;)Z", ExifInterface.LONGITUDE_EAST, "C", "G", "y", "H", "I", "currentData", "F", "(Li5/h;)V", "D", "()Z", "t", "a", "Landroid/content/Context;", "x", "()Landroid/content/Context;", "b", "Li5/h;", "getChannelData", "()Li5/h;", "c", "Landroid/os/Handler;", "w", "()Landroid/os/Handler;", "d", "Lx4/a;", "v", "()Lx4/a;", "Lq6/b;", "e", "Lq6/b;", "logger", "f", "mChannelData", "Landroid/view/LayoutInflater;", "g", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "mTvProgram", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "mMainView", "Landroidx/leanback/widget/HorizontalGridView;", "j", "Landroidx/leanback/widget/HorizontalGridView;", "mRvParent", "k", "mLlyDesc", "Landroid/widget/ImageView;", "l", "Landroid/widget/ImageView;", "mIcon", "Landroid/view/View;", "m", "Landroid/view/View;", "mRoot", "Landroid/app/Dialog;", "n", "Landroid/app/Dialog;", "dialog", "o", "mCurrentTime", "Ljava/text/SimpleDateFormat;", "p", "Ljava/text/SimpleDateFormat;", "formatter", "Lcom/live/evo/osd/f;", "q", "Lcom/live/evo/osd/f;", "epgAdapter", "mTvEpgLeft", "mTvEpgRight", "mEpgProgram", "mEpgProgramName", "mEpgDuration", "mEpgTime", "mEpgDesc2", "mEpgDesc", "Lcom/live/evo/dialog/f$a;", "Lcom/live/evo/dialog/f$a;", "selectListener", "Ljava/lang/String;", "lastChannelId", "B", "Z", "lastSuccess", "mLoadingView", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "loadAnim", "mLoadingParent", "", "J", "adoocTimeInterval", "mEpgInit", "mEpgDataParent", "isStop", "com/live/evo/dialog/f$c", "Lcom/live/evo/dialog/f$c;", "refreshRunnable", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private String lastChannelId;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private boolean lastSuccess;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private View mLoadingView;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private ObjectAnimator loadAnim;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private View mLoadingParent;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private long adoocTimeInterval;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private TextView mEpgInit;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private View mEpgDataParent;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private boolean isStop;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private final c refreshRunnable;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final i5.h channelData;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final x4.a catchupListener;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private i5.h mChannelData;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private LayoutInflater layoutInflater;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvProgram;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMainView;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HorizontalGridView mRvParent;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mLlyDesc;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ImageView mIcon;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Dialog dialog;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView mCurrentTime;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private SimpleDateFormat formatter;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.f epgAdapter;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ImageView mTvEpgLeft;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private ImageView mTvEpgRight;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgProgram;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgProgramName;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgDuration;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgTime;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgDesc2;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgDesc;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private a selectListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/live/evo/dialog/f$a;", "Lcom/live/evo/osd/e;", "Lcom/live/evo/dialog/f;", "dialog", "<init>", "(Lcom/live/evo/dialog/f;)V", "", "time", "program", "desc", "Lr8/z;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "bFocus", "d", "(Z)V", "Li5/p;", "bean", "c", "(Li5/p;)V", "b", "(Li5/p;)Z", "Lcom/live/evo/dialog/f;", "getDialog", "()Lcom/live/evo/dialog/f;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class a implements com.live.evo.osd.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final f dialog;

        /* JADX INFO: renamed from: com.live.evo.dialog.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/dialog/f$a$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0072a implements x1.f1.lb.util.m<Boolean> {
            @Override // x1.f1.lb.util.m
            public /* bridge */ /* synthetic */ void a(Boolean bool) {
                c(bool.booleanValue());
            }

            C0072a() {
            }

            public void c(boolean v10) {
            }
        }

        @Override // com.live.evo.osd.e
        public boolean b(i5.p bean) {
            if (bean == null) {
                return false;
            }
            long jB = q1.b();
            Long lF = bean.f();
            kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
            long jLongValue = lF.longValue();
            if (jLongValue > jB || bean.g().longValue() > jB) {
                return false;
            }
            s0 s0Var = s0.f7342a;
            String strB = bean.b();
            i5.h hVar = this.dialog.mChannelData;
            return s0Var.M(strB, hVar != null ? hVar.b() : null, Long.valueOf(jLongValue));
        }

        public a(f dialog) {
            kotlin.jvm.internal.m.f(dialog, "dialog");
            this.dialog = dialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(a aVar, String str, String str2, String str3) {
            TextView textView = aVar.dialog.mEpgTime;
            if (textView != null) {
                textView.setText("\t" + str);
            }
            TextView textView2 = aVar.dialog.mEpgProgramName;
            if (textView2 != null) {
                textView2.setText("\t" + str2);
            }
            TextView textView3 = aVar.dialog.mEpgDesc;
            if (textView3 != null) {
                textView3.setText(String.format("%s %s", x1.j(R$string.epg_description), str3));
            }
            aVar.dialog.E();
        }

        @Override // com.live.evo.osd.e
        public void a(final String time, final String program, final String desc) {
            kotlin.jvm.internal.m.f(time, "time");
            kotlin.jvm.internal.m.f(program, "program");
            kotlin.jvm.internal.m.f(desc, "desc");
            Handler handler = this.dialog.getHandler();
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.live.evo.dialog.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.f(this.f5704a, time, program, desc);
                    }
                });
            }
        }

        @Override // com.live.evo.osd.e
        public void c(i5.p bean) {
            if (bean == null) {
                return;
            }
            long jB = q1.b();
            Long lF = bean.f();
            kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
            long jLongValue = lF.longValue();
            if (jLongValue <= jB) {
                s0 s0Var = s0.f7342a;
                String strB = bean.b();
                i5.h hVar = this.dialog.mChannelData;
                if (s0Var.M(strB, hVar != null ? hVar.b() : null, Long.valueOf(jLongValue))) {
                    x4.a catchupListener = this.dialog.getCatchupListener();
                    i5.h hVar2 = this.dialog.mChannelData;
                    catchupListener.a("bigEpg", bean, hVar2 != null ? hVar2.b() : null, new C0072a());
                } else {
                    Long lG = bean.g();
                    kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                    if (lG.longValue() < jB) {
                        r1.c(this.dialog.getMContext(), x1.j(R$string.not_supported_playback));
                    }
                }
            }
        }

        @Override // com.live.evo.osd.e
        public void d(boolean bFocus) {
            if (this.dialog.mTvEpgRight == null || !bFocus) {
                return;
            }
            this.dialog.E();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.dialog.EpgDialog$fetchData$1", f = "EpgDialog.kt", l = {186}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $epgId;
        int label;
        final /* synthetic */ f this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.dialog.EpgDialog$fetchData$1$1", f = "EpgDialog.kt", l = {SyslogAppender.LOG_LOCAL6}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ String $epgId;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ f this$0;

            /* JADX INFO: renamed from: com.live.evo.dialog.f$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.dialog.EpgDialog$fetchData$1$1$1", f = "EpgDialog.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0073a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ String $epgId;
                int label;
                final /* synthetic */ f this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0073a(f fVar, String str, v8.f<? super C0073a> fVar2) {
                    super(2, fVar2);
                    this.this$0 = fVar;
                    this.$epgId = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0073a(this.this$0, this.$epgId, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0073a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void c(f fVar) {
                    com.live.evo.osd.f fVar2 = fVar.epgAdapter;
                    if (fVar2 != null) {
                        fVar2.notifyDataSetChanged();
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.y();
                        a aVar = this.this$0.selectListener;
                        if (aVar != null) {
                            aVar.a("", "", "");
                        }
                        LinearLayout linearLayout = this.this$0.mMainView;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                        com.live.evo.osd.f fVar = this.this$0.epgAdapter;
                        if (fVar != null) {
                            fVar.d(null);
                        }
                        HorizontalGridView horizontalGridView = this.this$0.mRvParent;
                        if (horizontalGridView != null) {
                            final f fVar2 = this.this$0;
                            kotlin.coroutines.jvm.internal.b.a(horizontalGridView.post(new Runnable() { // from class: com.live.evo.dialog.g
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.b.a.C0073a.c(fVar2);
                                }
                            }));
                        }
                        this.this$0.s(this.$epgId, false);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar, String str, v8.f<? super a> fVar2) {
                super(3, fVar2);
                this.this$0 = fVar;
                this.$epgId = str;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, this.$epgId, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
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
                    c5.b.c(this.this$0.logger, (Throwable) this.L$0, "get epgId data error");
                    g2 g2VarC = a1.c();
                    C0073a c0073a = new C0073a(this.this$0, this.$epgId, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0073a, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: renamed from: com.live.evo.dialog.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0074b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f5735a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f5736b;

            /* JADX INFO: renamed from: com.live.evo.dialog.f$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.dialog.EpgDialog$fetchData$1$2$1", f = "EpgDialog.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ List<i5.p> $epgBeans;
                final /* synthetic */ String $epgId;
                int label;
                final /* synthetic */ f this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(f fVar, String str, List<? extends i5.p> list, v8.f<? super a> fVar2) {
                    super(2, fVar2);
                    this.this$0 = fVar;
                    this.$epgId = str;
                    this.$epgBeans = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void n(RecyclerView.ViewHolder viewHolder) {
                    kotlin.jvm.internal.m.d(viewHolder, "null cannot be cast to non-null type com.live.evo.osd.EpgParentAdapter.ParentViewHolder");
                    VerticalGridView verticalGridView = ((com.live.evo.osd.f.a) viewHolder).f7090a;
                    com.live.evo.osd.d dVar = (com.live.evo.osd.d) verticalGridView.getAdapter();
                    int iG = dVar != null ? dVar.g() : 0;
                    verticalGridView.scrollToPosition(iG);
                    verticalGridView.setSelectedPosition(iG);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$epgId, this.$epgBeans, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void k(final f fVar) {
                    com.live.evo.osd.f fVar2 = fVar.epgAdapter;
                    if (fVar2 != null) {
                        fVar2.notifyDataSetChanged();
                    }
                    fVar.getHandler().post(new Runnable() { // from class: com.live.evo.dialog.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.b.C0074b.a.l(fVar);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void l(final f fVar) {
                    com.live.evo.osd.f fVar2 = fVar.epgAdapter;
                    if (fVar2 != null) {
                        final int iC = fVar2.c();
                        HorizontalGridView horizontalGridView = fVar.mRvParent;
                        if (horizontalGridView != null) {
                            horizontalGridView.scrollToPosition(iC);
                        }
                        fVar.getHandler().post(new Runnable() { // from class: com.live.evo.dialog.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.b.C0074b.a.m(fVar, iC);
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void m(f fVar, int i10) {
                    try {
                        HorizontalGridView horizontalGridView = fVar.mRvParent;
                        if (horizontalGridView != null) {
                            horizontalGridView.setSelectedPosition(i10, new ViewHolderTask() { // from class: com.live.evo.dialog.l
                                @Override // androidx.leanback.widget.ViewHolderTask
                                public final void run(RecyclerView.ViewHolder viewHolder) {
                                    f.b.C0074b.a.n(viewHolder);
                                }
                            });
                        }
                    } catch (Exception e10) {
                        c5.b.c(fVar.logger, e10, "EpgDialog");
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void p(f fVar) {
                    LinearLayout linearLayout = fVar.mMainView;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    a aVar;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.y();
                        this.this$0.s(this.$epgId, true);
                        com.live.evo.osd.f fVar = this.this$0.epgAdapter;
                        if (fVar != null) {
                            fVar.d(this.$epgBeans);
                        }
                        HorizontalGridView horizontalGridView = this.this$0.mRvParent;
                        if (horizontalGridView != null) {
                            final f fVar2 = this.this$0;
                            kotlin.coroutines.jvm.internal.b.a(horizontalGridView.post(new Runnable() { // from class: com.live.evo.dialog.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.b.C0074b.a.k(fVar2);
                                }
                            }));
                        }
                        if (this.$epgBeans.isEmpty() && (aVar = this.this$0.selectListener) != null) {
                            aVar.a("", "", "");
                        }
                        Handler handler = this.this$0.getHandler();
                        final f fVar3 = this.this$0;
                        handler.post(new Runnable() { // from class: com.live.evo.dialog.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.b.C0074b.a.p(fVar3);
                            }
                        });
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0074b(f fVar, String str) {
                this.f5735a = fVar;
                this.f5736b = str;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<? extends EPGProgramme> list, v8.f<? super r8.z> fVar) {
                s0 s0Var = s0.f7342a;
                i5.h hVar = this.f5735a.mChannelData;
                List<i5.p> listK = s0Var.k(hVar != null ? hVar.b() : null, this.f5736b, list);
                this.f5735a.logger.debug("fetchEpgData query success size = " + listK.size(), new Object[0]);
                Object objG = kotlinx.coroutines.h.g(a1.c(), new a(this.f5735a, this.f5736b, listK, null), fVar);
                return objG == kotlin.coroutines.intrinsics.b.c() ? objG : r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, f fVar, v8.f<? super b> fVar2) {
            super(2, fVar2);
            this.$epgId = str;
            this.this$0 = fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$epgId, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.D(this.$epgId), new a(this.this$0, this.$epgId, null));
                C0074b c0074b = new C0074b(this.this$0, this.$epgId);
                this.label = 1;
                if (fVarF.collect(c0074b, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/dialog/f$c", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (f.this.formatter == null) {
                f.this.formatter = o1.a(x1.j(R$string.yyyyMMddHHmmss));
            }
            Date date = new Date(u1.b().a());
            SimpleDateFormat simpleDateFormat = f.this.formatter;
            if (simpleDateFormat == null || (str = simpleDateFormat.format(date)) == null) {
                str = "";
            }
            TextView textView = f.this.mCurrentTime;
            if (textView != null) {
                textView.setText(str);
            }
            Handler handler = f.this.getHandler();
            if (handler != null) {
                handler.postDelayed(this, 1000L);
            }
        }
    }

    private final void H() {
        this.isStop = false;
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(this.refreshRunnable);
        }
    }

    private final void I() {
        this.isStop = true;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.refreshRunnable);
        }
    }

    public f(Context mContext, i5.h hVar, Handler handler, x4.a catchupListener) {
        kotlin.jvm.internal.m.f(mContext, "mContext");
        kotlin.jvm.internal.m.f(handler, "handler");
        kotlin.jvm.internal.m.f(catchupListener, "catchupListener");
        this.mContext = mContext;
        this.channelData = hVar;
        this.handler = handler;
        this.catchupListener = catchupListener;
        q6.b bVarD = q6.c.d(f.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.mChannelData = hVar;
        this.lastChannelId = "";
        this.adoocTimeInterval = -1L;
        this.layoutInflater = LayoutInflater.from(mContext);
        C();
        z();
        this.refreshRunnable = new c();
    }

    private final void A() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.live.evo.dialog.d
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    return f.B(this.f5703a, dialogInterface, i10, keyEvent);
                }
            });
        }
    }

    private final void C() {
        LayoutInflater layoutInflater = this.layoutInflater;
        View viewInflate = layoutInflater != null ? layoutInflater.inflate(R$layout.epg_dialog, (ViewGroup) null, false) : null;
        this.mRoot = viewInflate;
        this.mTvEpgLeft = viewInflate != null ? (ImageView) viewInflate.findViewById(R$id.epgdlg_iv_epg_arrow_left) : null;
        View view = this.mRoot;
        this.mTvEpgRight = view != null ? (ImageView) view.findViewById(R$id.epgdlg_iv_epg_arrow_right) : null;
        View view2 = this.mRoot;
        View viewFindViewById = view2 != null ? view2.findViewById(R$id.epgdlg_tv_program) : null;
        kotlin.jvm.internal.m.d(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvProgram = (TextView) viewFindViewById;
        View view3 = this.mRoot;
        View viewFindViewById2 = view3 != null ? view3.findViewById(R$id.epgdlg_hgv_parent) : null;
        kotlin.jvm.internal.m.d(viewFindViewById2, "null cannot be cast to non-null type androidx.leanback.widget.HorizontalGridView");
        this.mRvParent = (HorizontalGridView) viewFindViewById2;
        View view4 = this.mRoot;
        View viewFindViewById3 = view4 != null ? view4.findViewById(R$id.epgdlg_ll_desc) : null;
        kotlin.jvm.internal.m.d(viewFindViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mLlyDesc = (LinearLayout) viewFindViewById3;
        View view5 = this.mRoot;
        View viewFindViewById4 = view5 != null ? view5.findViewById(R$id.epgdlg_iv_icon) : null;
        kotlin.jvm.internal.m.d(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mIcon = (ImageView) viewFindViewById4;
        View view6 = this.mRoot;
        View viewFindViewById5 = view6 != null ? view6.findViewById(R$id.epgdlg_tv_curtime) : null;
        kotlin.jvm.internal.m.d(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.mCurrentTime = (TextView) viewFindViewById5;
        View view7 = this.mRoot;
        View viewFindViewById6 = view7 != null ? view7.findViewById(R$id.epgdlg_tv_epg_desc2) : null;
        kotlin.jvm.internal.m.d(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgDesc2 = (TextView) viewFindViewById6;
        View view8 = this.mRoot;
        View viewFindViewById7 = view8 != null ? view8.findViewById(R$id.epgdlg_tv_epg_desc) : null;
        kotlin.jvm.internal.m.d(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgDesc = (TextView) viewFindViewById7;
        View view9 = this.mRoot;
        View viewFindViewById8 = view9 != null ? view9.findViewById(R$id.epgdlg_tv_time) : null;
        kotlin.jvm.internal.m.d(viewFindViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgDuration = (TextView) viewFindViewById8;
        View view10 = this.mRoot;
        View viewFindViewById9 = view10 != null ? view10.findViewById(R$id.epgdlg_tv_epg_time) : null;
        kotlin.jvm.internal.m.d(viewFindViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgTime = (TextView) viewFindViewById9;
        View view11 = this.mRoot;
        View viewFindViewById10 = view11 != null ? view11.findViewById(R$id.epgdlg_tv_name) : null;
        kotlin.jvm.internal.m.d(viewFindViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgProgram = (TextView) viewFindViewById10;
        View view12 = this.mRoot;
        View viewFindViewById11 = view12 != null ? view12.findViewById(R$id.epgdlg_tv_epg_channel_name) : null;
        kotlin.jvm.internal.m.d(viewFindViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.mEpgProgramName = (TextView) viewFindViewById11;
        View view13 = this.mRoot;
        View viewFindViewById12 = view13 != null ? view13.findViewById(R$id.epgdlg_ll_epg_main_view) : null;
        kotlin.jvm.internal.m.d(viewFindViewById12, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mMainView = (LinearLayout) viewFindViewById12;
        View view14 = this.mRoot;
        this.mLoadingView = view14 != null ? view14.findViewById(R$id.epgdlg_view_loading) : null;
        View view15 = this.mRoot;
        this.mLoadingParent = view15 != null ? view15.findViewById(R$id.epgdlg_rl_loading) : null;
        View view16 = this.mRoot;
        this.mEpgInit = view16 != null ? (TextView) view16.findViewById(R$id.epgdlg_tv_epg_init) : null;
        View view17 = this.mRoot;
        this.mEpgDataParent = view17 != null ? view17.findViewById(R$id.epgdlg_ll_epg_data_parent) : null;
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.mTvProgram);
        } else {
            com.live.evo.util.t.d(this.mTvProgram);
        }
        com.live.evo.util.t.b(this.mCurrentTime);
        com.live.evo.util.t.b(this.mEpgDuration);
        com.live.evo.util.t.b(this.mEpgTime);
        com.live.evo.util.t.b(this.mEpgProgram);
        com.live.evo.util.t.b(this.mEpgProgramName);
        com.live.evo.util.t.b(this.mEpgDesc2);
        com.live.evo.util.t.b(this.mEpgDesc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:44:0x0073  */
    /* JADX WARN: Code duplicated, block: B:48:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x007e  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    public final void E() {
        boolean z10;
        boolean z11;
        ImageView imageView;
        ImageView imageView2;
        int i10;
        HorizontalGridView horizontalGridView = this.mRvParent;
        int selectedPosition = horizontalGridView != null ? horizontalGridView.getSelectedPosition() : 0;
        HorizontalGridView horizontalGridView2 = this.mRvParent;
        int childCount = horizontalGridView2 != null ? horizontalGridView2.getChildCount() : 0;
        if (childCount > 0) {
            HorizontalGridView horizontalGridView3 = this.mRvParent;
            View childAt = horizontalGridView3 != null ? horizontalGridView3.getChildAt(0) : null;
            Object tag = childAt != null ? childAt.getTag() : null;
            kotlin.jvm.internal.m.d(tag, "null cannot be cast to non-null type kotlin.String");
            String str = (String) tag;
            HorizontalGridView horizontalGridView4 = this.mRvParent;
            z11 = true;
            View childAt2 = horizontalGridView4 != null ? horizontalGridView4.getChildAt(childCount - 1) : null;
            Object tag2 = childAt2 != null ? childAt2.getTag() : null;
            kotlin.jvm.internal.m.d(tag2, "null cannot be cast to non-null type kotlin.String");
            int i11 = Integer.parseInt(str);
            int i12 = Integer.parseInt((String) tag2);
            com.live.evo.osd.f fVar = this.epgAdapter;
            int itemCount = fVar != null ? fVar.getItemCount() : 0;
            z10 = selectedPosition >= 5 || i11 > 1;
            if (i12 >= itemCount && i12 - selectedPosition <= 5) {
            }
            imageView = this.mTvEpgLeft;
            if (imageView != null) {
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 4;
                }
                imageView.setVisibility(i10);
            }
            imageView2 = this.mTvEpgRight;
            if (imageView2 != null) {
                imageView2.setVisibility(z11 ? 0 : 8);
            }
        }
        z10 = false;
        z11 = false;
        imageView = this.mTvEpgLeft;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            imageView.setVisibility(i10);
        }
        imageView2 = this.mTvEpgRight;
        if (imageView2 != null) {
            imageView2.setVisibility(z11 ? 0 : 8);
        }
    }

    private final void G() {
        View view = this.mLoadingParent;
        if (view != null) {
            view.setVisibility(0);
        }
        ObjectAnimator objectAnimator = this.loadAnim;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    private final boolean r(String channelId) {
        return TextUtils.equals(this.lastChannelId, channelId) && this.lastSuccess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String channelId, boolean success) {
        this.lastChannelId = channelId;
        this.lastSuccess = success;
    }

    private final void u() {
        i5.h hVar = this.mChannelData;
        String strF = hVar != null ? hVar.f() : null;
        if (r(strF)) {
            LinearLayout linearLayout = this.mMainView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (s0.f7342a.R()) {
            TextView textView = this.mEpgInit;
            if (textView != null) {
                textView.setVisibility(0);
            }
            View view = this.mEpgDataParent;
            if (view != null) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.mEpgInit;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        View view2 = this.mEpgDataParent;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        G();
        LinearLayout linearLayout2 = this.mMainView;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(4);
        }
        if (strF == null) {
            return;
        }
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(strF, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ObjectAnimator objectAnimator = this.loadAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = this.mLoadingParent;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    private final void z() {
        Window window;
        Window window2;
        View decorView;
        Window window3;
        Dialog dialog;
        this.adoocTimeInterval = com.live.evo.a.f5195o;
        a aVar = new a(this);
        this.selectListener = aVar;
        com.live.evo.osd.f fVar = new com.live.evo.osd.f(this.mContext, aVar, this.mRvParent);
        this.epgAdapter = fVar;
        HorizontalGridView horizontalGridView = this.mRvParent;
        if (horizontalGridView != null) {
            horizontalGridView.setAdapter(fVar);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mLoadingView, Key.ROTATION, 360.0f, 0.0f);
        this.loadAnim = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setDuration(1000L);
        }
        ObjectAnimator objectAnimator = this.loadAnim;
        if (objectAnimator != null) {
            objectAnimator.setRepeatMode(1);
        }
        ObjectAnimator objectAnimator2 = this.loadAnim;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.loadAnim;
        if (objectAnimator3 != null) {
            objectAnimator3.setRepeatCount(-1);
        }
        Context context = this.mContext;
        if (context != null) {
            this.dialog = new com.live.evo.widget.o(context, R$style.EPGDialog);
        }
        View view = this.mRoot;
        if (view != null && (dialog = this.dialog) != null) {
            dialog.setContentView(view);
        }
        Dialog dialog2 = this.dialog;
        WindowManager.LayoutParams attributes = (dialog2 == null || (window3 = dialog2.getWindow()) == null) ? null : window3.getAttributes();
        if (attributes != null) {
            attributes.gravity = 80;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = -1;
        }
        Dialog dialog3 = this.dialog;
        if (dialog3 != null && (window2 = dialog3.getWindow()) != null && (decorView = window2.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Dialog dialog4 = this.dialog;
        if (dialog4 != null && (window = dialog4.getWindow()) != null) {
            window.setAttributes(attributes);
        }
        A();
    }

    public final boolean D() {
        Dialog dialog = this.dialog;
        return (dialog == null || dialog == null || !dialog.isShowing()) ? false : true;
    }

    public final void F(i5.h currentData) {
        kotlin.jvm.internal.m.f(currentData, "currentData");
        this.mChannelData = currentData;
        TextView textView = this.mTvProgram;
        if (textView != null) {
            textView.setText(currentData.e());
        }
        com.live.evo.util.v.d(this.mContext, currentData.g(), this.mIcon);
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.show();
        }
        H();
        u();
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final x4.a getCatchupListener() {
        return this.catchupListener;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(f fVar, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i10 == 82) {
            fVar.t();
            return true;
        }
        if (i10 == 4 || i10 == 111) {
            fVar.I();
            ObjectAnimator objectAnimator = fVar.loadAnim;
            if (objectAnimator != null && objectAnimator != null) {
                objectAnimator.cancel();
                return false;
            }
            return false;
        }
        return false;
    }

    public final void t() {
        Dialog dialog;
        if (D() && (dialog = this.dialog) != null) {
            dialog.cancel();
        }
        y();
        I();
    }
}
