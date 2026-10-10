package com.live.evo.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u001c\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010&J\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u0004R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010CR\u0018\u0010T\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010CR\u0018\u0010V\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010CR\u0018\u0010X\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010CR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010^R\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u00105R\u0016\u0010c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010FR\u0014\u0010g\u001a\u00020d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006n"}, d2 = {"Lcom/live/evo/fragment/n0;", "Lcom/live/evo/fragment/f0;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "", "R", "()I", "Landroid/view/View;", "view", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.LATITUDE_SOUTH, "(Landroid/os/Bundle;)V", "", "isVisible", "X", "(Z)V", "hasFocus", ExifInterface.LONGITUDE_WEST, "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onDestroy", "y0", "t0", "w0", "r0", "x0", "index", "z0", "(I)V", "s0", "q0", "position", "A0", "p0", "Lq6/b;", "f", "Lq6/b;", "logger", "", "g", "Ljava/lang/String;", "TAG", "h", "I", "INIT_CHANNELDATA", "i", "PREVIEW_SWITCH", "Lcom/live/evo/widget/ProgramListView;", "j", "Lcom/live/evo/widget/ProgramListView;", "mLvHistory", "Ln5/f;", "k", "Ln5/f;", "programListAdapter", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "mNoData", "m", "Z", "hasChange", "n", "Landroid/view/View;", "mContainer", "Landroid/widget/RelativeLayout;", "o", "Landroid/widget/RelativeLayout;", "mPreviewContainer", "p", "mVideoPreview", "q", "mClssifyName", "r", "mTvCurrent", "s", "mTvAll", "t", "mTvDes", "Ljava/util/Timer;", "u", "Ljava/util/Timer;", "mTimer", "Ljava/util/TimerTask;", "Ljava/util/TimerTask;", "timerTask", "w", "mSelect", "x", "mFocusFragment", "Landroid/os/Handler;", "y", "Landroid/os/Handler;", "mHandler", "Landroid/widget/AdapterView$OnItemSelectedListener;", "z", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mProgramItemSelectListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n0 extends f0 implements View.OnKeyListener {
    private static n0 B;
    private static com.live.evo.osd.persenter.a D;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int INIT_CHANNELDATA;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int PREVIEW_SWITCH;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ProgramListView mLvHistory;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private n5.f programListAdapter;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mNoData;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasChange;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private View mContainer;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mPreviewContainer;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mVideoPreview;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mClssifyName;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCurrent;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private TextView mTvAll;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private TextView mTvDes;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Timer mTimer;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private TimerTask timerTask;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int mSelect;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean mFocusFragment;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final AdapterView.OnItemSelectedListener mProgramItemSelectListener;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ChannelStreamResponse> C = new ArrayList();

    /* JADX INFO: renamed from: com.live.evo.fragment.n0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/live/evo/fragment/n0$a;", "", "<init>", "()V", "", "tag", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/n0;", "a", "(Ljava/lang/String;Lcom/live/evo/osd/persenter/a;)Lcom/live/evo/fragment/n0;", "instance", "Lcom/live/evo/fragment/n0;", "", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "mChannelList", "Ljava/util/List;", "mPresenter", "Lcom/live/evo/osd/persenter/a;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final n0 a(String tag, com.live.evo.osd.persenter.a presenter) {
            if (n0.B == null) {
                n0.B = new n0();
                Bundle bundle = new Bundle();
                bundle.putString("tag", tag);
                n0 n0Var = n0.B;
                kotlin.jvm.internal.m.c(n0Var);
                n0Var.setArguments(bundle);
                n0.D = presenter;
            }
            return n0.B;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/n0$b", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            n0.this.mHandler.sendEmptyMessage(n0.this.INIT_CHANNELDATA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/n0$c", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            int i10 = msg.what;
            if (i10 == n0.this.INIT_CHANNELDATA) {
                n0.this.q0();
            } else if (i10 == n0.this.PREVIEW_SWITCH) {
                n0.this.z0(msg.arg1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo/fragment/n0$d", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "arg0", "Landroid/view/View;", "view", "", "position", "", "arg3", "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "parent", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {
            TextView textView = n0.this.mTvCurrent;
            kotlin.jvm.internal.m.c(textView);
            textView.setText(String.valueOf(position + 1));
            if (n0.this.mLvHistory != null) {
                ProgramListView programListView = n0.this.mLvHistory;
                kotlin.jvm.internal.m.c(programListView);
                if (programListView.isFocused()) {
                    n5.f fVar = n0.this.programListAdapter;
                    kotlin.jvm.internal.m.c(fVar);
                    fVar.b(position);
                }
            }
            if (n0.this.mFocusFragment) {
                n0.this.A0(position);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean hasFocus) {
        this.mFocusFragment = true;
        ProgramListView programListView = this.mLvHistory;
        if (programListView != null) {
            kotlin.jvm.internal.m.c(programListView);
            programListView.requestFocus();
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean isVisible) {
        if (isVisible) {
            this.hasChange = false;
            y0();
            return;
        }
        this.mFocusFragment = false;
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            kotlin.jvm.internal.m.c(timerTask);
            timerTask.cancel();
        }
        p0();
    }

    private final void p0() {
        try {
            com.live.evo.osd.persenter.a aVar = D;
            if (aVar != null) {
                kotlin.jvm.internal.m.c(aVar);
                aVar.a(3, 1);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        TextView textView = this.mClssifyName;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(com.live.evo.util.x1.j(2131952436));
        s0();
        List<ChannelStreamResponse> list = C;
        if (list.isEmpty()) {
            TextView textView2 = this.mTvCurrent;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setText("0");
            TextView textView3 = this.mTvAll;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setText("/0");
            return;
        }
        TextView textView4 = this.mTvCurrent;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setText("1");
        TextView textView5 = this.mTvAll;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setText("/" + list.size());
        ProgramListView programListView = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView);
        programListView.setSelection(0);
    }

    private final void r0() {
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            kotlin.jvm.internal.m.c(timerTask);
            timerTask.cancel();
        }
        b bVar = new b();
        this.timerTask = bVar;
        this.mTimer.schedule(bVar, 100L);
    }

    private final void s0() {
        i5.h hVarI;
        List<ChannelStreamResponse> list = C;
        list.clear();
        list.addAll(t.v.c.i.a.f18646a.S());
        int iC = 0;
        if (list.isEmpty()) {
            ProgramListView programListView = this.mLvHistory;
            kotlin.jvm.internal.m.c(programListView);
            programListView.setVisibility(4);
            TextView textView = this.mNoData;
            kotlin.jvm.internal.m.c(textView);
            textView.setVisibility(0);
            n5.f fVar = this.programListAdapter;
            kotlin.jvm.internal.m.c(fVar);
            fVar.c(list, 0);
            return;
        }
        ProgramListView programListView2 = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView2);
        programListView2.setVisibility(0);
        TextView textView2 = this.mNoData;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setVisibility(4);
        com.live.evo.osd.persenter.a aVar = D;
        if (aVar != null && (hVarI = aVar.i()) != null) {
            iC = hVarI.c();
        }
        n5.f fVar2 = this.programListAdapter;
        if (fVar2 != null) {
            kotlin.jvm.internal.m.c(fVar2);
            fVar2.c(list, iC);
            return;
        }
        Context context = getContext();
        kotlin.jvm.internal.m.c(context);
        this.programListAdapter = new n5.f(context, list, iC);
        ProgramListView programListView3 = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView3);
        programListView3.setAdapter((ListAdapter) this.programListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(n0 n0Var, AdapterView adapterView, View view, int i10, long j10) {
        i5.h hVarI;
        List<ChannelStreamResponse> list = C;
        ChannelStreamResponse channelStreamResponse = list.get(i10);
        com.live.evo.osd.persenter.a aVar = D;
        Integer numValueOf = (aVar == null || (hVarI = aVar.i()) == null) ? null : Integer.valueOf(hVarI.c());
        t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
        int i11 = Integer.parseInt(aVar2.b(channelStreamResponse));
        if (numValueOf != null && i11 == numValueOf.intValue()) {
            return;
        }
        aVar2.D0(kotlin.collections.r.e(Integer.valueOf(channelStreamResponse.getKey())));
        list.remove(channelStreamResponse);
        n5.f fVar = n0Var.programListAdapter;
        if (fVar != null) {
            fVar.a(channelStreamResponse);
        }
        TextView textView = n0Var.mTvAll;
        kotlin.jvm.internal.m.c(textView);
        textView.setText("/" + list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(n0 n0Var, View view, boolean z10) {
        if (!z10) {
            n5.f fVar = n0Var.programListAdapter;
            kotlin.jvm.internal.m.c(fVar);
            fVar.b(-1);
            return;
        }
        n5.f fVar2 = n0Var.programListAdapter;
        kotlin.jvm.internal.m.c(fVar2);
        ProgramListView programListView = n0Var.mLvHistory;
        kotlin.jvm.internal.m.c(programListView);
        fVar2.b(programListView.getSelectedItemPosition());
        if (n0Var.mFocusFragment) {
            ProgramListView programListView2 = n0Var.mLvHistory;
            kotlin.jvm.internal.m.c(programListView2);
            n0Var.A0(programListView2.getSelectedItemPosition());
        }
    }

    private final void w0() {
        if (this.mPreviewContainer == null || D == null || !com.live.evo.k.b().l() || !com.live.evo.l.n().G()) {
            return;
        }
        if (!com.live.evo.l.n().H()) {
            z0(com.live.evo.l.n().s());
        }
        com.live.evo.osd.persenter.a aVar = D;
        kotlin.jvm.internal.m.c(aVar);
        aVar.e("HistoryDeleteFragment");
    }

    private final void y0() {
        if (this.mPreviewContainer != null && com.live.evo.k.b().l()) {
            RelativeLayout relativeLayout = this.mPreviewContainer;
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setVisibility(com.live.evo.l.n().G() ? 0 : 8);
        }
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(int index) {
        com.live.evo.osd.persenter.a aVar = D;
        if (aVar != null) {
            kotlin.jvm.internal.m.c(aVar);
            aVar.c("HistoryDeleteFragment", index);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        ProgramListView programListView = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView);
        programListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.live.evo.fragment.l0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                n0.u0(this.f6045a, adapterView, view, i10, j10);
            }
        });
        ProgramListView programListView2 = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView2);
        programListView2.setOnItemSelectedListener(this.mProgramItemSelectListener);
        ProgramListView programListView3 = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView3);
        programListView3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.m0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                n0.v0(this.f6452a, view, z10);
            }
        });
        ProgramListView programListView4 = this.mLvHistory;
        kotlin.jvm.internal.m.c(programListView4);
        programListView4.setOnKeyListener(this);
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        this.mContainer = view.findViewById(R$id.history_rl_parent);
        if (com.live.evo.l.n().j("pip_on_channel", true)) {
            this.mPreviewContainer = (RelativeLayout) view.findViewById(R$id.history_preview_container);
        }
        this.mClssifyName = (TextView) view.findViewById(R$id.history_tv_clssify_name);
        this.mTvCurrent = (TextView) view.findViewById(R$id.history_tv_program_current);
        this.mTvAll = (TextView) view.findViewById(R$id.history_tv_program_all);
        this.mTvDes = (TextView) view.findViewById(R$id.history_tv_program_des);
        this.mLvHistory = (ProgramListView) view.findViewById(R$id.history_lv);
        this.mNoData = (TextView) view.findViewById(R$id.history_tv_no_data);
        com.live.evo.util.t.d(this.mClssifyName);
        com.live.evo.util.t.a(this.mTvCurrent);
        com.live.evo.util.t.b(this.mTvAll);
        com.live.evo.util.t.c(this.mTvDes);
        com.live.evo.util.t.d(this.mNoData);
        x0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (this.mLvHistory == null) {
            return true;
        }
        if (event.getAction() == 0) {
            if (keyCode != 82) {
                switch (keyCode) {
                    case 19:
                        ProgramListView programListView = this.mLvHistory;
                        kotlin.jvm.internal.m.c(programListView);
                        if (programListView.getCount() > 0) {
                            ProgramListView programListView2 = this.mLvHistory;
                            kotlin.jvm.internal.m.c(programListView2);
                            if (programListView2.getSelectedItemPosition() == 0) {
                                ProgramListView programListView3 = this.mLvHistory;
                                kotlin.jvm.internal.m.c(programListView3);
                                ProgramListView programListView4 = this.mLvHistory;
                                kotlin.jvm.internal.m.c(programListView4);
                                programListView3.setSelection(programListView4.getCount() - 1);
                                return true;
                            }
                        }
                        break;
                    case 20:
                        ProgramListView programListView5 = this.mLvHistory;
                        kotlin.jvm.internal.m.c(programListView5);
                        if (programListView5.getCount() > 0) {
                            ProgramListView programListView6 = this.mLvHistory;
                            kotlin.jvm.internal.m.c(programListView6);
                            int selectedItemPosition = programListView6.getSelectedItemPosition();
                            ProgramListView programListView7 = this.mLvHistory;
                            kotlin.jvm.internal.m.c(programListView7);
                            if (selectedItemPosition == programListView7.getCount() - 1) {
                                ProgramListView programListView8 = this.mLvHistory;
                                kotlin.jvm.internal.m.c(programListView8);
                                programListView8.setSelection(0);
                                return true;
                            }
                        }
                        break;
                    case 21:
                        a2 a2Var = this.f5935e;
                        if (a2Var != null) {
                            a2Var.D(this);
                        }
                        break;
                    case 22:
                        Z(getView());
                        return true;
                }
            } else if (com.live.evo.k.b().l()) {
                ProgramListView programListView9 = this.mLvHistory;
                kotlin.jvm.internal.m.c(programListView9);
                if (programListView9.isFocused()) {
                    List<ChannelStreamResponse> list = C;
                    if (list.size() <= 0) {
                        return true;
                    }
                    if (!com.live.evo.l.n().G()) {
                        com.live.evo.util.r1.d(getActivity(), com.live.evo.util.x1.j(R$string.pip_not_open), 1);
                    } else if (this.mSelect >= 0) {
                        int size = list.size();
                        int i10 = this.mSelect;
                        if (size > i10) {
                            ChannelStreamResponse channelStreamResponse = list.get(i10);
                            if (D != null && !channelStreamResponse.c()) {
                                com.live.evo.osd.persenter.a aVar = D;
                                kotlin.jvm.internal.m.c(aVar);
                                aVar.a(1, Integer.parseInt(t.v.c.i.a.f18646a.b(channelStreamResponse)));
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public n0() {
        q6.b bVarD = q6.c.d(n0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.TAG = "HistoryDeleteFragment";
        this.INIT_CHANNELDATA = 262145;
        this.PREVIEW_SWITCH = 262146;
        this.mTimer = new Timer();
        this.mHandler = new c();
        this.mProgramItemSelectListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(int position) {
        if (com.live.evo.k.b().l() && com.live.evo.l.n().G()) {
            this.mHandler.removeMessages(this.PREVIEW_SWITCH);
            this.mSelect = position;
            Message message = new Message();
            message.what = this.PREVIEW_SWITCH;
            message.arg1 = this.mSelect;
            this.mHandler.sendMessageDelayed(message, com.live.evo.l.n().r());
        }
    }

    private final void t0() {
        r0();
        w0();
    }

    private final void x0() {
        Context context = getContext();
        kotlin.jvm.internal.m.d(context, "null cannot be cast to non-null type android.app.Activity");
        this.mVideoPreview = (RelativeLayout) ((Activity) context).findViewById(R$id.preview_container);
        if (D != null && com.live.evo.k.b().l() && this.mPreviewContainer != null) {
            com.live.evo.osd.persenter.a aVar = D;
            kotlin.jvm.internal.m.c(aVar);
            aVar.h("HistoryDeleteFragment", this.mPreviewContainer);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.history_delete_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle savedInstanceState) {
        y0();
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        B = null;
    }
}
