package com.live.evo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.BaseButton;
import com.live.evo.widget.ProgramListView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u001c\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u0015J\r\u0010 \u001a\u00020\n¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u0004J!\u0010&\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106R\u0018\u0010>\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010@\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00102R\u0018\u0010B\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00106R\u0018\u0010D\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00106R\u0018\u0010F\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106R\u0018\u0010H\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00106R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006n"}, d2 = {"Lcom/live/evo/fragment/p2;", "Lcom/live/evo/fragment/f0;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "", "R", "()I", "Landroid/view/View;", "view", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.LATITUDE_SOUTH, "(Landroid/os/Bundle;)V", "", "isVisible", "X", "(Z)V", "isVisibleToUser", "setUserVisibleHint", "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "hasFocus", ExifInterface.LONGITUDE_WEST, "u0", "onStop", "onDestroy", "q0", "v0", "position", "w0", "(Landroid/view/View;I)V", "Lcom/live/evo/widget/ProgramListView;", "f", "Lcom/live/evo/widget/ProgramListView;", "mLvMessage", "Ln5/l;", "g", "Ln5/l;", "messageListAdapter", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "mIvDown", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mMessagePip", "j", "Landroid/view/View;", "mLine", "k", "mTvNoData", "l", "mMessageDescParent", "m", "mMsgImage", "n", "mMsgTitle", "o", "mMsgContent", "p", "mMsgTime", "q", "mMsgFrom", "Lcom/live/evo/widget/BaseButton;", "r", "Lcom/live/evo/widget/BaseButton;", "mBtnWatch", "", "Li5/v;", "s", "Ljava/util/List;", "mList", "t", "Z", "mFocus", "Landroid/os/Handler;", "u", "Landroid/os/Handler;", "mHandler", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mItemSelectListener", "Landroid/widget/AdapterView$OnItemClickListener;", "w", "Landroid/widget/AdapterView$OnItemClickListener;", "mItemClickListener", "Landroid/widget/AdapterView$OnItemLongClickListener;", "x", "Landroid/widget/AdapterView$OnItemLongClickListener;", "mItemLongClickListener", "Landroid/view/View$OnFocusChangeListener;", "y", "Landroid/view/View$OnFocusChangeListener;", "mListViewFocusListener", "Landroid/widget/AbsListView$OnScrollListener;", "z", "Landroid/widget/AbsListView$OnScrollListener;", "mScrollListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p2 extends f0 implements View.OnKeyListener {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String B = "TabFunctionMessageFragment";
    private static SoftReference<p2> C;
    private static com.live.evo.osd.persenter.a D;
    private static com.live.evo.osd.q E;
    private static View F;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ProgramListView mLvMessage;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private n5.l messageListAdapter;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvDown;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mMessagePip;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private View mLine;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private TextView mTvNoData;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private View mMessageDescParent;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mMsgImage;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgTitle;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgContent;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgTime;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgFrom;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private BaseButton mBtnWatch;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean mFocus;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private List<i5.v> mList = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler = new b();

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final AdapterView.OnItemSelectedListener mItemSelectListener = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.live.evo.fragment.m2
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            p2.r0(this.f6480a, adapterView, view, i10, j10);
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final AdapterView.OnItemLongClickListener mItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.live.evo.fragment.n2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
            return p2.s0(this.f6524a, adapterView, view, i10, j10);
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final View.OnFocusChangeListener mListViewFocusListener = new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.o2
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z10) {
            p2.t0(this.f6527a, view, z10);
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final AbsListView.OnScrollListener mScrollListener = new d();

    /* JADX INFO: renamed from: com.live.evo.fragment.p2$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/live/evo/fragment/p2$a;", "", "<init>", "()V", "", "tag", "Landroid/view/View;", "functionView", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/osd/q;", "refreshMenuListener", "Lcom/live/evo/fragment/p2;", "a", "(Ljava/lang/String;Landroid/view/View;Lcom/live/evo/osd/persenter/a;Lcom/live/evo/osd/q;)Lcom/live/evo/fragment/p2;", "", "INIT_MESSAGEFRAGMENT", "I", "MESSAGE_COUNT", "Ljava/lang/ref/SoftReference;", "sflInstance", "Ljava/lang/ref/SoftReference;", "mPresenter", "Lcom/live/evo/osd/persenter/a;", "mRefreshMenuListener", "Lcom/live/evo/osd/q;", "mTabFunctionView", "Landroid/view/View;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final p2 a(String tag, View functionView, com.live.evo.osd.persenter.a presenter, com.live.evo.osd.q refreshMenuListener) {
            p2 p2Var;
            SoftReference softReference = p2.C;
            p2 p2Var2 = null;
            if (softReference != null) {
                p2Var = (p2) softReference.get();
            } else {
                p2Var = null;
            }
            if (p2Var != null) {
                return p2Var;
            }
            Bundle bundle = new Bundle();
            bundle.putString("tag", tag);
            p2.D = presenter;
            p2.E = refreshMenuListener;
            p2.F = functionView;
            synchronized (Companion.class) {
                SoftReference softReference2 = p2.C;
                if (softReference2 != null) {
                    p2Var2 = (p2) softReference2.get();
                }
                if (p2Var2 != null) {
                    return p2Var2;
                }
                p2 p2Var3 = new p2();
                p2Var3.setArguments(bundle);
                p2.C = new SoftReference(p2Var3);
                return p2Var3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/p2$b", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            if (msg.what == 327681) {
                p2.this.q0();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo/fragment/p2$c", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "arg0", "Landroid/view/View;", "view", "", "position", "", "arg3", "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "parent", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {
            if (p2.this.mList != null) {
                List list = p2.this.mList;
                kotlin.jvm.internal.m.c(list);
                if (list.size() <= position || view == null || !p2.this.mFocus) {
                    return;
                }
                p2 p2Var = p2.this;
                ProgramListView programListView = p2Var.mLvMessage;
                kotlin.jvm.internal.m.c(programListView);
                p2Var.w0(programListView.getSelectedView(), position);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/live/evo/fragment/p2$d", "Landroid/widget/AbsListView$OnScrollListener;", "Landroid/widget/AbsListView;", "view", "", "scrollState", "Lr8/z;", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScroll", "(Landroid/widget/AbsListView;III)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            kotlin.jvm.internal.m.f(view, "view");
            ProgramListView programListView = p2.this.mLvMessage;
            kotlin.jvm.internal.m.c(programListView);
            if (programListView.getLastVisiblePosition() == totalItemCount - 1) {
                if (p2.this.mIvDown != null) {
                    ImageView imageView = p2.this.mIvDown;
                    kotlin.jvm.internal.m.c(imageView);
                    if (imageView.getVisibility() == 0) {
                        ImageView imageView2 = p2.this.mIvDown;
                        kotlin.jvm.internal.m.c(imageView2);
                        imageView2.setBackgroundResource(R$drawable.arrow_down_disenabled);
                        return;
                    }
                    return;
                }
                return;
            }
            if (p2.this.mIvDown != null) {
                ImageView imageView3 = p2.this.mIvDown;
                kotlin.jvm.internal.m.c(imageView3);
                if (imageView3.getVisibility() == 0) {
                    ImageView imageView4 = p2.this.mIvDown;
                    kotlin.jvm.internal.m.c(imageView4);
                    imageView4.setBackgroundResource(R$drawable.arrow_down);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            kotlin.jvm.internal.m.f(view, "view");
        }
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean hasFocus) {
        List<i5.v> list;
        this.mFocus = true;
        if (this.mLvMessage == null || (list = this.mList) == null) {
            return;
        }
        kotlin.jvm.internal.m.c(list);
        if (list.size() > 0) {
            ProgramListView programListView = this.mLvMessage;
            kotlin.jvm.internal.m.c(programListView);
            programListView.requestFocus();
            ProgramListView programListView2 = this.mLvMessage;
            kotlin.jvm.internal.m.c(programListView2);
            programListView2.setSelection(0);
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean isVisible) {
        if (isVisible) {
            this.mHandler.sendEmptyMessageDelayed(327681, 100L);
            this.mFocus = false;
            return;
        }
        View view = this.mMessageDescParent;
        if (view != null) {
            kotlin.jvm.internal.m.c(view);
            if (view.getVisibility() == 0) {
                View view2 = this.mMessageDescParent;
                kotlin.jvm.internal.m.c(view2);
                view2.setVisibility(8);
            }
        }
        v0();
        this.mFocus = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(p2 p2Var, View view) {
        i5.v vVar;
        com.live.evo.osd.persenter.a aVar;
        try {
            List<i5.v> list = p2Var.mList;
            if (list != null) {
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0) {
                    ProgramListView programListView = p2Var.mLvMessage;
                    kotlin.jvm.internal.m.c(programListView);
                    int selectedItemPosition = programListView.getSelectedItemPosition();
                    List<i5.v> list2 = p2Var.mList;
                    kotlin.jvm.internal.m.c(list2);
                    if (selectedItemPosition < list2.size()) {
                        List<i5.v> list3 = p2Var.mList;
                        kotlin.jvm.internal.m.c(list3);
                        ProgramListView programListView2 = p2Var.mLvMessage;
                        kotlin.jvm.internal.m.c(programListView2);
                        vVar = list3.get(programListView2.getSelectedItemPosition());
                    } else {
                        vVar = null;
                    }
                    com.live.evo.util.r0 r0Var = com.live.evo.util.r0.f7337a;
                    if (r0Var.b(vVar)) {
                        r0Var.c(p2Var.getActivity(), vVar);
                        if (!r0Var.a(vVar) || (aVar = D) == null) {
                            return;
                        }
                        kotlin.jvm.internal.m.c(aVar);
                        aVar.hide();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        List<i5.v> list = this.mList;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            list.clear();
        } else {
            this.mList = new ArrayList();
        }
        List<i5.v> list2 = this.mList;
        kotlin.jvm.internal.m.c(list2);
        list2.addAll(com.live.evo.util.s0.f7342a.F());
        if (this.messageListAdapter == null) {
            this.messageListAdapter = new n5.l(getActivity(), this.mList);
        }
        n5.l lVar = this.messageListAdapter;
        if (lVar != null && this.mLvMessage != null) {
            kotlin.jvm.internal.m.c(lVar);
            lVar.a(this.mList);
            ProgramListView programListView = this.mLvMessage;
            kotlin.jvm.internal.m.c(programListView);
            programListView.setAdapter((ListAdapter) this.messageListAdapter);
            n5.l lVar2 = this.messageListAdapter;
            kotlin.jvm.internal.m.c(lVar2);
            lVar2.notifyDataSetChanged();
        }
        ImageView imageView = this.mIvDown;
        if (imageView != null) {
            kotlin.jvm.internal.m.c(imageView);
            List<i5.v> list3 = this.mList;
            kotlin.jvm.internal.m.c(list3);
            list3.size();
            imageView.setVisibility(8);
        }
        TextView textView = this.mTvNoData;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(com.live.evo.util.x1.j(R$string.not_data));
        TextView textView2 = this.mTvNoData;
        kotlin.jvm.internal.m.c(textView2);
        List<i5.v> list4 = this.mList;
        kotlin.jvm.internal.m.c(list4);
        textView2.setVisibility(list4.size() <= 0 ? 0 : 8);
        TextView textView3 = this.mMessagePip;
        kotlin.jvm.internal.m.c(textView3);
        List<i5.v> list5 = this.mList;
        kotlin.jvm.internal.m.c(list5);
        textView3.setVisibility(list5.size() > 0 ? 0 : 8);
        View view = this.mLine;
        kotlin.jvm.internal.m.c(view);
        List<i5.v> list6 = this.mList;
        kotlin.jvm.internal.m.c(list6);
        view.setVisibility(list6.size() > 0 ? 0 : 8);
        ProgramListView programListView2 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView2);
        List<i5.v> list7 = this.mList;
        kotlin.jvm.internal.m.c(list7);
        programListView2.setVisibility(list7.size() > 0 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(p2 p2Var, AdapterView adapterView, View view, int i10, long j10) {
        ImageView imageView;
        List<i5.v> list = p2Var.mList;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() <= i10) {
                return;
            }
            List<i5.v> list2 = p2Var.mList;
            kotlin.jvm.internal.m.c(list2);
            i5.v vVar = list2.get(i10);
            if (vVar.i()) {
                List<i5.v> list3 = p2Var.mList;
                kotlin.jvm.internal.m.c(list3);
                list3.remove(vVar);
                List<i5.v> list4 = p2Var.mList;
                kotlin.jvm.internal.m.c(list4);
                if (list4.size() <= 0) {
                    TextView textView = p2Var.mTvNoData;
                    if (textView != null) {
                        kotlin.jvm.internal.m.c(textView);
                        if (textView.getVisibility() != 0) {
                            TextView textView2 = p2Var.mTvNoData;
                            kotlin.jvm.internal.m.c(textView2);
                            textView2.setVisibility(0);
                            TextView textView3 = p2Var.mTvNoData;
                            kotlin.jvm.internal.m.c(textView3);
                            textView3.requestFocus();
                        }
                    }
                    TextView textView4 = p2Var.mMessagePip;
                    if (textView4 != null) {
                        kotlin.jvm.internal.m.c(textView4);
                        if (textView4.getVisibility() == 0) {
                            TextView textView5 = p2Var.mMessagePip;
                            kotlin.jvm.internal.m.c(textView5);
                            textView5.setVisibility(8);
                        }
                    }
                    View view2 = p2Var.mLine;
                    if (view2 != null) {
                        kotlin.jvm.internal.m.c(view2);
                        if (view2.getVisibility() == 0) {
                            View view3 = p2Var.mLine;
                            kotlin.jvm.internal.m.c(view3);
                            view3.setVisibility(8);
                        }
                    }
                    View view4 = p2Var.mMessageDescParent;
                    if (view4 != null) {
                        kotlin.jvm.internal.m.c(view4);
                        if (view4.getVisibility() == 0) {
                            View view5 = p2Var.mMessageDescParent;
                            kotlin.jvm.internal.m.c(view5);
                            view5.setVisibility(8);
                        }
                    }
                    ProgramListView programListView = p2Var.mLvMessage;
                    if (programListView != null) {
                        kotlin.jvm.internal.m.c(programListView);
                        if (programListView.getVisibility() == 0) {
                            ProgramListView programListView2 = p2Var.mLvMessage;
                            kotlin.jvm.internal.m.c(programListView2);
                            programListView2.setVisibility(8);
                        }
                    }
                } else {
                    List<i5.v> list5 = p2Var.mList;
                    kotlin.jvm.internal.m.c(list5);
                    if (list5.size() <= 5 && (imageView = p2Var.mIvDown) != null) {
                        kotlin.jvm.internal.m.c(imageView);
                        if (imageView.getVisibility() == 0) {
                            ImageView imageView2 = p2Var.mIvDown;
                            kotlin.jvm.internal.m.c(imageView2);
                            imageView2.setVisibility(8);
                        }
                    }
                }
                n5.l lVar = p2Var.messageListAdapter;
                kotlin.jvm.internal.m.c(lVar);
                lVar.a(p2Var.mList);
                com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
                String strE = vVar.e();
                kotlin.jvm.internal.m.e(strE, "getMsgId(...)");
                s0Var.V(2, strE);
                List<i5.v> list6 = p2Var.mList;
                kotlin.jvm.internal.m.c(list6);
                if (list6.size() > 0) {
                    ProgramListView programListView3 = p2Var.mLvMessage;
                    kotlin.jvm.internal.m.c(programListView3);
                    View selectedView = programListView3.getSelectedView();
                    ProgramListView programListView4 = p2Var.mLvMessage;
                    kotlin.jvm.internal.m.c(programListView4);
                    p2Var.w0(selectedView, programListView4.getSelectedItemPosition());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(p2 p2Var, AdapterView adapterView, View view, int i10, long j10) {
        List<i5.v> list = p2Var.mList;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > i10) {
                List<i5.v> list2 = p2Var.mList;
                kotlin.jvm.internal.m.c(list2);
                i5.v vVar = list2.get(i10);
                vVar.r(!vVar.p());
                n5.l lVar = p2Var.messageListAdapter;
                kotlin.jvm.internal.m.c(lVar);
                lVar.notifyDataSetChanged();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(p2 p2Var, View view, boolean z10) {
        if (z10 && p2Var.mFocus) {
            ProgramListView programListView = p2Var.mLvMessage;
            kotlin.jvm.internal.m.c(programListView);
            int selectedItemPosition = programListView.getSelectedItemPosition();
            ProgramListView programListView2 = p2Var.mLvMessage;
            kotlin.jvm.internal.m.c(programListView2);
            p2Var.w0(programListView2.getSelectedView(), selectedItemPosition);
            return;
        }
        if (z10) {
            return;
        }
        BaseButton baseButton = p2Var.mBtnWatch;
        if (baseButton != null) {
            kotlin.jvm.internal.m.c(baseButton);
            if (baseButton.getVisibility() == 0) {
                BaseButton baseButton2 = p2Var.mBtnWatch;
                kotlin.jvm.internal.m.c(baseButton2);
                if (baseButton2.isFocused()) {
                    return;
                }
            }
        }
        View view2 = p2Var.mMessageDescParent;
        kotlin.jvm.internal.m.c(view2);
        if (view2.getVisibility() == 0) {
            View view3 = p2Var.mMessageDescParent;
            kotlin.jvm.internal.m.c(view3);
            view3.setVisibility(8);
        }
    }

    private final void v0() {
        List<i5.v> list = this.mList;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() <= 0) {
                return;
            }
            List<i5.v> list2 = this.mList;
            kotlin.jvm.internal.m.c(list2);
            Iterator<i5.v> it = list2.iterator();
            while (it.hasNext()) {
                it.next().r(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(View view, int position) {
        List<i5.v> list = this.mList;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() <= position || view == null) {
                return;
            }
            List<i5.v> list2 = this.mList;
            kotlin.jvm.internal.m.c(list2);
            i5.v vVar = list2.get(position);
            if (vVar.f() == 0) {
                vVar.q(1);
                n5.l lVar = this.messageListAdapter;
                kotlin.jvm.internal.m.c(lVar);
                lVar.a(this.mList);
                com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
                String strE = vVar.e();
                kotlin.jvm.internal.m.e(strE, "getMsgId(...)");
                s0Var.V(1, strE);
                com.live.evo.osd.q qVar = E;
                if (qVar != null) {
                    kotlin.jvm.internal.m.c(qVar);
                    qVar.a("Message");
                }
            }
            View view2 = this.mMessageDescParent;
            kotlin.jvm.internal.m.c(view2);
            if (view2.getVisibility() != 0) {
                View view3 = this.mMessageDescParent;
                kotlin.jvm.internal.m.c(view3);
                view3.setVisibility(0);
            }
            TextView textView = this.mMsgTitle;
            kotlin.jvm.internal.m.c(textView);
            textView.setText(vVar.g());
            TextView textView2 = this.mMsgTitle;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setSelected(true);
            TextView textView3 = this.mMsgContent;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setText(vVar.c());
            String strM = com.live.evo.util.q1.m(vVar.n(), com.live.evo.util.x1.j(R$string.ddMMyyyy));
            String strM2 = com.live.evo.util.q1.m(vVar.n(), com.live.evo.util.x1.j(R$string.HHmm));
            TextView textView4 = this.mMsgTime;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setText(strM2 + "  " + strM);
            BaseButton baseButton = this.mBtnWatch;
            kotlin.jvm.internal.m.c(baseButton);
            baseButton.setVisibility(com.live.evo.util.r0.f7337a.b(vVar) ? 0 : 8);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle savedInstanceState) {
        this.mHandler.sendEmptyMessageDelayed(327681, 100L);
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        ProgramListView programListView = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView);
        programListView.setOnItemSelectedListener(this.mItemSelectListener);
        ProgramListView programListView2 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView2);
        programListView2.setOnItemClickListener(this.mItemClickListener);
        ProgramListView programListView3 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView3);
        programListView3.setOnItemLongClickListener(this.mItemLongClickListener);
        ProgramListView programListView4 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView4);
        programListView4.setOnFocusChangeListener(this.mListViewFocusListener);
        ProgramListView programListView5 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView5);
        programListView5.setOnScrollListener(this.mScrollListener);
        ProgramListView programListView6 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView6);
        programListView6.setNextFocusUpId(R$id.lv_message);
        ProgramListView programListView7 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView7);
        programListView7.setNextFocusDownId(R$id.lv_message);
        ProgramListView programListView8 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView8);
        programListView8.setOnKeyListener(this);
        BaseButton baseButton = this.mBtnWatch;
        kotlin.jvm.internal.m.c(baseButton);
        baseButton.setOnKeyListener(this);
        BaseButton baseButton2 = this.mBtnWatch;
        kotlin.jvm.internal.m.c(baseButton2);
        baseButton2.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.fragment.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p2.p0(this.f6075a, view);
            }
        });
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        this.mLvMessage = (ProgramListView) view.findViewById(R$id.lv_message);
        this.mIvDown = (ImageView) view.findViewById(R$id.iv_down);
        this.mMessagePip = (TextView) view.findViewById(R$id.tv_message_tip);
        this.mLine = view.findViewById(R$id.tv_message_tip_line);
        this.mTvNoData = (TextView) view.findViewById(R$id.tv_message_nodata);
        this.mMessageDescParent = view.findViewById(R$id.message_desc_parent);
        this.mMsgImage = (ImageView) view.findViewById(R$id.iv_message_logo);
        this.mMsgTitle = (TextView) view.findViewById(R$id.tv_message_title);
        this.mMsgContent = (TextView) view.findViewById(R$id.tv_message_content);
        this.mMsgTime = (TextView) view.findViewById(R$id.tv_message_time);
        this.mMsgFrom = (TextView) view.findViewById(R$id.tv_message_from);
        this.mBtnWatch = (BaseButton) view.findViewById(R$id.btn_message_direct);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        ProgramListView programListView;
        View view;
        View view2;
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode == 20 && event.getAction() == 0) {
            List<i5.v> list = this.mList;
            if (list != null) {
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0) {
                    return false;
                }
            }
            return true;
        }
        if (keyCode == 19 && event.getAction() == 0) {
            List<i5.v> list2 = this.mList;
            if (list2 != null) {
                kotlin.jvm.internal.m.c(list2);
                if (list2.size() > 0) {
                    BaseButton baseButton = this.mBtnWatch;
                    if (baseButton != null) {
                        kotlin.jvm.internal.m.c(baseButton);
                        if (baseButton.getVisibility() == 0) {
                            BaseButton baseButton2 = this.mBtnWatch;
                            kotlin.jvm.internal.m.c(baseButton2);
                            if (baseButton2.isFocused()) {
                                List<i5.v> list3 = this.mList;
                                if (list3 == null) {
                                    return false;
                                }
                                kotlin.jvm.internal.m.c(list3);
                                if (list3.size() <= 0) {
                                    return false;
                                }
                                ProgramListView programListView2 = this.mLvMessage;
                                kotlin.jvm.internal.m.c(programListView2);
                                programListView2.requestFocus();
                                return false;
                            }
                        }
                    }
                    ProgramListView programListView3 = this.mLvMessage;
                    kotlin.jvm.internal.m.c(programListView3);
                    if (programListView3.getSelectedItemPosition() != 0 || (view2 = F) == null) {
                        return false;
                    }
                    kotlin.jvm.internal.m.c(view2);
                    view2.requestFocus();
                }
            }
            return true;
        }
        if (keyCode != 21 || event.getAction() != 0) {
            if (keyCode != 22 || event.getAction() != 0) {
                return false;
            }
            ProgramListView programListView4 = this.mLvMessage;
            kotlin.jvm.internal.m.c(programListView4);
            if (programListView4.isFocused()) {
                BaseButton baseButton3 = this.mBtnWatch;
                if (baseButton3 != null) {
                    kotlin.jvm.internal.m.c(baseButton3);
                    if (baseButton3.getVisibility() == 0) {
                        BaseButton baseButton4 = this.mBtnWatch;
                        kotlin.jvm.internal.m.c(baseButton4);
                        baseButton4.requestFocus();
                    }
                }
            } else {
                BaseButton baseButton5 = this.mBtnWatch;
                if (baseButton5 != null) {
                    kotlin.jvm.internal.m.c(baseButton5);
                    if (baseButton5.getVisibility() == 0) {
                        BaseButton baseButton6 = this.mBtnWatch;
                        kotlin.jvm.internal.m.c(baseButton6);
                        if (baseButton6.isFocused()) {
                            BaseButton baseButton7 = this.mBtnWatch;
                            kotlin.jvm.internal.m.c(baseButton7);
                            baseButton7.requestFocus();
                        }
                    }
                }
            }
            return true;
        }
        BaseButton baseButton8 = this.mBtnWatch;
        if (baseButton8 != null) {
            kotlin.jvm.internal.m.c(baseButton8);
            if (baseButton8.getVisibility() == 0) {
                BaseButton baseButton9 = this.mBtnWatch;
                kotlin.jvm.internal.m.c(baseButton9);
                if (baseButton9.isFocused()) {
                    List<i5.v> list4 = this.mList;
                    if (list4 != null) {
                        kotlin.jvm.internal.m.c(list4);
                        if (list4.size() > 0) {
                            ProgramListView programListView5 = this.mLvMessage;
                            kotlin.jvm.internal.m.c(programListView5);
                            programListView5.requestFocus();
                        } else {
                            programListView = this.mLvMessage;
                            kotlin.jvm.internal.m.c(programListView);
                            if (!programListView.isFocused() && (view = F) != null) {
                                kotlin.jvm.internal.m.c(view);
                                view.requestFocus();
                            }
                        }
                    } else {
                        programListView = this.mLvMessage;
                        kotlin.jvm.internal.m.c(programListView);
                        if (!programListView.isFocused()) {
                            kotlin.jvm.internal.m.c(view);
                            view.requestFocus();
                        }
                    }
                }
            }
        }
        return true;
    }

    public final void u0() {
        ProgramListView programListView;
        List<i5.v> list = this.mList;
        kotlin.jvm.internal.m.c(list);
        if (list.size() <= 0 || (programListView = this.mLvMessage) == null) {
            return;
        }
        kotlin.jvm.internal.m.c(programListView);
        if (programListView.isFocused()) {
            return;
        }
        this.mFocus = true;
        ProgramListView programListView2 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView2);
        programListView2.requestFocus();
        ProgramListView programListView3 = this.mLvMessage;
        kotlin.jvm.internal.m.c(programListView3);
        programListView3.setSelection(0);
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.tab_message_fragment;
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            this.mHandler.sendEmptyMessageDelayed(327681, 100L);
            this.mFocus = false;
            return;
        }
        View view = this.mMessageDescParent;
        if (view != null) {
            kotlin.jvm.internal.m.c(view);
            if (view.getVisibility() == 0) {
                View view2 = this.mMessageDescParent;
                kotlin.jvm.internal.m.c(view2);
                view2.setVisibility(8);
            }
        }
        v0();
        this.mFocus = false;
    }
}
