package com.live.evo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0002\\]B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\fJ\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b#\u0010\fJ\u0019\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082D¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010SR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006^"}, d2 = {"Lcom/live/evo/fragment/k0;", "Lcom/live/evo/fragment/d;", "Lcom/live/evo/fragment/a2;", "<init>", "()V", "Lr8/z;", "r0", "q0", "p0", "", "tag", "A0", "(Ljava/lang/String;)V", "menuFirst", "", "o0", "(Ljava/lang/String;)I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "x0", "y0", "w0", "onResume", "onDestroy", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "D", "(Landroidx/fragment/app/Fragment;)V", "z0", "Lb5/g;", NotificationCompat.CATEGORY_EVENT, "onNotification", "(Lb5/g;)V", "Lq6/b;", "f", "Lq6/b;", "logger", "g", "Landroid/view/View;", "mView", "Landroid/widget/ListView;", "h", "Landroid/widget/ListView;", "mMenuListView", "Ljava/util/ArrayList;", "Li5/l;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "menuIdList", "", "Lcom/live/evo/fragment/k0$b;", "j", "Ljava/util/List;", "fragmentList", "Lcom/live/evo/fragment/w0;", "k", "Lcom/live/evo/fragment/w0;", "menuAdapter", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "mSessionId", "Lcom/live/evo/fragment/f0;", "m", "Lcom/live/evo/fragment/f0;", "mBaseFragment", "n", "I", "mPosition", "Landroid/os/Handler;", "o", "Landroid/os/Handler;", "mHandle", "", "p", "Z", "isFirstResume", "q", "hasFocus", "Lcom/live/evo/osd/q;", "r", "Lcom/live/evo/osd/q;", "mRefreshMenuListener", "s", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k0 extends d implements a2 {

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f5998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Window f5999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static y1 f6000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static com.live.evo.osd.persenter.a f6001w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f6002x;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View mView;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ListView mMenuListView;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<i5.l> menuIdList;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final List<b> fragmentList;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private w0 menuAdapter;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mSessionId;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private f0 mBaseFragment;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandle;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final boolean isFirstResume;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean hasFocus;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final com.live.evo.osd.q mRefreshMenuListener;

    /* JADX INFO: renamed from: com.live.evo.fragment.k0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/live/evo/fragment/k0$a;", "", "<init>", "()V", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/y1;", "onEventListener", "Landroid/view/Window;", "window", "", "menuFirst", "Lcom/live/evo/fragment/k0;", "a", "(Lcom/live/evo/osd/persenter/a;Lcom/live/evo/fragment/y1;Landroid/view/Window;Ljava/lang/String;)Lcom/live/evo/fragment/k0;", "TAG", "Ljava/lang/String;", "mWindow", "Landroid/view/Window;", "mOnEventListener", "Lcom/live/evo/fragment/y1;", "mPresenter", "Lcom/live/evo/osd/persenter/a;", "menu_first", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final k0 a(com.live.evo.osd.persenter.a presenter, y1 onEventListener, Window window, String menuFirst) {
            kotlin.jvm.internal.m.f(menuFirst, "menuFirst");
            k0.f6001w = presenter;
            k0.f6000v = onEventListener;
            k0.f5999u = window;
            k0.f6002x = menuFirst;
            return new k0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/live/evo/fragment/k0$b;", "", "<init>", "()V", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "fragmentTag", "Lcom/live/evo/fragment/f0;", "Lcom/live/evo/fragment/f0;", "()Lcom/live/evo/fragment/f0;", "c", "(Lcom/live/evo/fragment/f0;)V", TransactionPartnerType.FRAGMENT, "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String fragmentTag;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private f0 fragment;

        /* JADX INFO: renamed from: a, reason: from getter */
        public final f0 getFragment() {
            return this.fragment;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getFragmentTag() {
            return this.fragmentTag;
        }

        public final void c(f0 f0Var) {
            this.fragment = f0Var;
        }

        public final void d(String str) {
            this.fragmentTag = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/k0$c", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            k0.this.mPosition = position;
            w0 w0Var = k0.this.menuAdapter;
            kotlin.jvm.internal.m.c(w0Var);
            w0Var.a(k0.this.mPosition, k0.this.hasFocus);
            k0 k0Var = k0.this;
            Object obj = k0Var.fragmentList.get(position);
            kotlin.jvm.internal.m.c(obj);
            k0Var.A0(((b) obj).getFragmentTag());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    static {
        String name = k0.class.getName();
        kotlin.jvm.internal.m.e(name, "getName(...)");
        f5998t = name;
        f6002x = "Channel List";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(String tag) {
        List<b> list = this.fragmentList;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(tag) || !isAdded()) {
            return;
        }
        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(tag);
            if (fragmentFindFragmentByTag != null) {
                if (fragmentFindFragmentByTag.isHidden()) {
                    FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                    kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                    f0 f0Var = this.mBaseFragment;
                    if (f0Var != null) {
                        kotlin.jvm.internal.m.c(f0Var);
                        fragmentTransactionBeginTransaction.hide(f0Var);
                    }
                    fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
                    this.mBaseFragment = (f0) fragmentFindFragmentByTag;
                    return;
                }
                return;
            }
            int size = this.fragmentList.size();
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = this.fragmentList.get(i10);
                kotlin.jvm.internal.m.c(bVar);
                if (TextUtils.equals(tag, bVar.getFragmentTag())) {
                    b bVar2 = this.fragmentList.get(i10);
                    kotlin.jvm.internal.m.c(bVar2);
                    f0 fragment = bVar2.getFragment();
                    if (fragment != null && !kotlin.jvm.internal.m.a(fragment, this.mBaseFragment)) {
                        FragmentManager childFragmentManager2 = getChildFragmentManager();
                        kotlin.jvm.internal.m.e(childFragmentManager2, "getChildFragmentManager(...)");
                        FragmentTransaction fragmentTransactionBeginTransaction2 = childFragmentManager2.beginTransaction();
                        kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                        if (childFragmentManager2.findFragmentByTag(tag) == null || !fragment.isAdded()) {
                            try {
                                kotlin.jvm.internal.m.c(fragmentTransactionBeginTransaction2.add(R$id.child_fragemnt, fragment, tag));
                            } catch (Exception unused) {
                            }
                        }
                        f0 f0Var2 = this.mBaseFragment;
                        if (f0Var2 != null) {
                            kotlin.jvm.internal.m.c(f0Var2);
                            fragmentTransactionBeginTransaction2.hide(f0Var2);
                        }
                        fragmentTransactionBeginTransaction2.show(fragment);
                        fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
                        this.mBaseFragment = fragment;
                        kotlin.jvm.internal.m.c(fragment);
                        fragment.Y(this);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e10) {
            this.logger.error("switchFragment %s error %s", tag, e10.toString());
        }
    }

    private final void q0() {
        this.mPosition = o0(f6002x);
        if (ua.n.w(f6002x, "Channel List", true)) {
            return;
        }
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        if (listView.getCount() > this.mPosition) {
            ListView listView2 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView2);
            listView2.setSelection(this.mPosition);
        }
        w0 w0Var = this.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        if (w0Var.getCount() > this.mPosition) {
            w0 w0Var2 = this.menuAdapter;
            kotlin.jvm.internal.m.c(w0Var2);
            w0Var2.a(this.mPosition, false);
        }
    }

    private final void r0() {
        ArrayList<i5.l> arrayList = this.menuIdList;
        kotlin.jvm.internal.m.c(arrayList);
        arrayList.clear();
        List<b> list = this.fragmentList;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        p0();
        try {
            this.menuAdapter = new w0(getActivity(), this.menuIdList);
            ListView listView = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView);
            listView.setAdapter((ListAdapter) this.menuAdapter);
            ListView listView2 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView2);
            listView2.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.i0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                    return k0.s0(this.f5986a, view, i10, keyEvent);
                }
            });
            ListView listView3 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView3);
            listView3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.j0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    k0.t0(this.f5991a, view, z10);
                }
            });
            ListView listView4 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView4);
            listView4.setOnItemSelectedListener(new c());
            q0();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(k0 k0Var, View view, boolean z10) {
        k0Var.hasFocus = z10;
        w0 w0Var = k0Var.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        w0Var.a(k0Var.mPosition, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(k0 k0Var, String str) {
        w0 w0Var;
        ArrayList<i5.l> arrayList = k0Var.menuIdList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = k0Var.menuIdList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (TextUtils.equals(k0Var.menuIdList.get(i10).b(), str)) {
                if (k0Var.mMenuListView == null || (w0Var = k0Var.menuAdapter) == null) {
                    return;
                }
                kotlin.jvm.internal.m.c(w0Var);
                w0Var.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.live.evo.fragment.a2
    public void D(Fragment fragment) {
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        listView.requestFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.menu_fragment_function, container, false);
        this.mView = viewInflate;
        this.mMenuListView = viewInflate != null ? (ListView) viewInflate.findViewById(R$id.list_view) : null;
        View view = this.mView;
        TextView textView = view != null ? (TextView) view.findViewById(R$id.programmenuf_tv_menu_session) : null;
        this.mSessionId = textView;
        if (textView != null) {
            textView.setText(com.live.evo.l.n().w());
        }
        this.mHandle.postDelayed(new Runnable() { // from class: com.live.evo.fragment.h0
            @Override // java.lang.Runnable
            public final void run() {
                k0.v0(this.f5981a);
            }
        }, 1000L);
        return this.mView;
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onNotification(b5.g event) {
        try {
            ArrayList<i5.l> arrayList = this.menuIdList;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    i5.l lVar = this.menuIdList.get(i10);
                    kotlin.jvm.internal.m.e(lVar, "get(...)");
                    if (TextUtils.equals(lVar.b(), "Message")) {
                        w0 w0Var = this.menuAdapter;
                        if (w0Var != null) {
                            kotlin.jvm.internal.m.c(w0Var);
                            w0Var.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void w0() {
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        listView.requestFocus();
        ListView listView2 = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView2);
        listView2.setSelection(0);
        w0 w0Var = this.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        w0Var.a(0, true);
    }

    public final void x0() {
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        listView.requestFocus();
        ListView listView2 = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView2);
        if (listView2.getCount() > this.mPosition) {
            ListView listView3 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView3);
            listView3.setSelection(this.mPosition);
        }
        w0 w0Var = this.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        if (w0Var.getCount() > this.mPosition) {
            w0 w0Var2 = this.menuAdapter;
            kotlin.jvm.internal.m.c(w0Var2);
            w0Var2.a(this.mPosition, true);
        }
    }

    public final void y0(String menuFirst) {
        kotlin.jvm.internal.m.f(menuFirst, "menuFirst");
        this.mPosition = o0(menuFirst);
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        listView.requestFocus();
        ListView listView2 = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView2);
        if (listView2.getCount() > this.mPosition) {
            ListView listView3 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView3);
            listView3.setSelection(this.mPosition);
        }
        w0 w0Var = this.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        if (w0Var.getCount() > this.mPosition) {
            w0 w0Var2 = this.menuAdapter;
            kotlin.jvm.internal.m.c(w0Var2);
            w0Var2.a(this.mPosition, true);
        }
    }

    public final void z0(String menuFirst) {
        kotlin.jvm.internal.m.f(menuFirst, "menuFirst");
        if (this.mMenuListView == null || this.menuAdapter == null) {
            return;
        }
        this.mPosition = o0(menuFirst);
        List<b> list = this.fragmentList;
        kotlin.jvm.internal.m.c(list);
        b bVar = list.get(this.mPosition);
        kotlin.jvm.internal.m.c(bVar);
        A0(bVar.getFragmentTag());
        w0 w0Var = this.menuAdapter;
        kotlin.jvm.internal.m.c(w0Var);
        w0Var.a(this.mPosition, false);
        ListView listView = this.mMenuListView;
        kotlin.jvm.internal.m.c(listView);
        if (listView.getCount() > this.mPosition && !ua.n.w("Channel List", menuFirst, true)) {
            ListView listView2 = this.mMenuListView;
            kotlin.jvm.internal.m.c(listView2);
            listView2.setSelection(this.mPosition);
        }
        int size = this.fragmentList.size();
        int i10 = this.mPosition;
        if (size > i10) {
            try {
                b bVar2 = this.fragmentList.get(i10);
                kotlin.jvm.internal.m.c(bVar2);
                boolean z10 = !kotlin.jvm.internal.m.a(bVar2.getFragmentTag(), "Search");
                b bVar3 = this.fragmentList.get(this.mPosition);
                kotlin.jvm.internal.m.c(bVar3);
                f0 fragment = bVar3.getFragment();
                kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo.fragment.FunctionBaseFragment");
                fragment.X(z10);
            } catch (Exception unused) {
            }
        }
    }

    public k0() {
        q6.b bVarD = q6.c.d(k0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.menuIdList = new ArrayList<>();
        this.fragmentList = new ArrayList();
        this.mHandle = new Handler();
        this.isFirstResume = true;
        this.mRefreshMenuListener = new com.live.evo.osd.q() { // from class: com.live.evo.fragment.g0
            @Override // com.live.evo.osd.q
            public final void a(String str) {
                k0.u0(this.f5946a, str);
            }
        };
    }

    private final int o0(String menuFirst) {
        List<b> list;
        if (!TextUtils.isEmpty(menuFirst) && (list = this.fragmentList) != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.fragmentList.get(i10) != null) {
                    b bVar = this.fragmentList.get(i10);
                    kotlin.jvm.internal.m.c(bVar);
                    if (ua.n.w(menuFirst, bVar.getFragmentTag(), true)) {
                        return i10;
                    }
                }
            }
        }
        return 0;
    }

    private final void p0() {
        if (com.live.evo.k.b().m()) {
            i5.l lVar = new i5.l();
            lVar.k("Search");
            lVar.h("Search");
            lVar.j(com.live.evo.util.x1.j(R$string.menu_search));
            lVar.i(R$drawable.menu_fragment_lv_icon_search);
            ArrayList<i5.l> arrayList = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList);
            arrayList.add(lVar);
            b bVar = new b();
            bVar.d(lVar.e());
            bVar.c(g2.p0("Search", f6001w, f6000v));
            List<b> list = this.fragmentList;
            kotlin.jvm.internal.m.c(list);
            list.add(bVar);
        }
        if (com.live.evo.k.b().d()) {
            i5.l lVar2 = new i5.l();
            lVar2.k("Favorite");
            lVar2.h("Favorite");
            lVar2.j(com.live.evo.util.x1.j(2131952434));
            lVar2.i(R$drawable.menu_fragment_lv_icon_favorite);
            ArrayList<i5.l> arrayList2 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList2);
            arrayList2.add(lVar2);
            b bVar2 = new b();
            bVar2.d(lVar2.e());
            bVar2.c(a0.t0("Favorite", f6001w));
            List<b> list2 = this.fragmentList;
            kotlin.jvm.internal.m.c(list2);
            list2.add(bVar2);
        }
        if (com.live.evo.k.b().f()) {
            i5.l lVar3 = new i5.l();
            lVar3.k("Clear history");
            lVar3.h("Clear history");
            lVar3.j(com.live.evo.util.x1.j(2131952436));
            lVar3.i(R$drawable.menu_fragment_lv_icon_history);
            ArrayList<i5.l> arrayList3 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList3);
            arrayList3.add(lVar3);
            b bVar3 = new b();
            bVar3.d(lVar3.e());
            bVar3.c(n0.INSTANCE.a("Clear history", f6001w));
            List<b> list3 = this.fragmentList;
            kotlin.jvm.internal.m.c(list3);
            list3.add(bVar3);
        }
        if (com.live.evo.k.b().n()) {
            i5.l lVar4 = new i5.l();
            lVar4.k("Subscribe List");
            lVar4.h("Subscribe List");
            lVar4.j(com.live.evo.util.x1.j(R$string.menu_subscribe));
            lVar4.i(R$drawable.menu_fragment_lv_icon_subscribe);
            ArrayList<i5.l> arrayList4 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList4);
            arrayList4.add(lVar4);
            b bVar4 = new b();
            bVar4.d(lVar4.e());
            bVar4.c(k2.INSTANCE.a("Subscribe List"));
            List<b> list4 = this.fragmentList;
            kotlin.jvm.internal.m.c(list4);
            list4.add(bVar4);
        }
        if (com.live.evo.k.b().g()) {
            i5.l lVar5 = new i5.l();
            lVar5.k("Info");
            lVar5.h("Info");
            lVar5.j(com.live.evo.util.x1.j(R$string.menu_info));
            lVar5.i(R$drawable.menu_fragment_lv_icon_info);
            ArrayList<i5.l> arrayList5 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList5);
            arrayList5.add(lVar5);
            b bVar5 = new b();
            bVar5.d(lVar5.e());
            bVar5.c(r0.INSTANCE.c("Info", f6001w));
            List<b> list5 = this.fragmentList;
            kotlin.jvm.internal.m.c(list5);
            list5.add(bVar5);
        }
        if (com.live.evo.k.b().l()) {
            i5.l lVar6 = new i5.l();
            lVar6.k("Pip");
            lVar6.h("Pip");
            lVar6.j(com.live.evo.util.x1.j(R$string.menu_pip));
            lVar6.i(R$drawable.menu_fragment_lv_icon_pip);
            ArrayList<i5.l> arrayList6 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList6);
            arrayList6.add(lVar6);
            b bVar6 = new b();
            bVar6.d(lVar6.e());
            bVar6.c(b2.d0("Pip", f6001w));
            List<b> list6 = this.fragmentList;
            kotlin.jvm.internal.m.c(list6);
            list6.add(bVar6);
        }
        if (com.live.evo.k.b().h()) {
            i5.l lVar7 = new i5.l();
            lVar7.k("Lock");
            lVar7.h("Lock");
            lVar7.j(com.live.evo.util.x1.j(R$string.menu_lock));
            lVar7.i(R$drawable.menu_fragment_lv_icon_lock);
            ArrayList<i5.l> arrayList7 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList7);
            arrayList7.add(lVar7);
            b bVar7 = new b();
            bVar7.d(lVar7.e());
            bVar7.c(u0.p0("Lock", f6001w, f5999u));
            List<b> list7 = this.fragmentList;
            kotlin.jvm.internal.m.c(list7);
            list7.add(bVar7);
        }
        if (com.live.evo.k.b().k()) {
            i5.l lVar8 = new i5.l();
            lVar8.k("phone_login");
            lVar8.h("phone_login");
            lVar8.j(com.live.evo.util.x1.j(R$string.menu_phone_app));
            lVar8.i(R$drawable.menu_fragment_lv_icon_mobile);
            ArrayList<i5.l> arrayList8 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList8);
            arrayList8.add(lVar8);
            b bVar8 = new b();
            bVar8.d(lVar8.e());
            bVar8.c(c2.INSTANCE.a("phone_login"));
            List<b> list8 = this.fragmentList;
            kotlin.jvm.internal.m.c(list8);
            list8.add(bVar8);
        }
        if (com.live.evo.k.b().i()) {
            int iL = com.live.evo.util.s0.f7342a.L();
            i5.l lVar9 = new i5.l();
            lVar9.k("Message");
            lVar9.h("Message");
            lVar9.j(com.live.evo.util.x1.j(R$string.menu_message));
            lVar9.i(R$drawable.menu_fragment_lv_icon_message);
            lVar9.g(iL);
            if (iL > 0) {
                lVar9.l(true);
            }
            ArrayList<i5.l> arrayList9 = this.menuIdList;
            kotlin.jvm.internal.m.c(arrayList9);
            arrayList9.add(lVar9);
            b bVar9 = new b();
            bVar9.d(lVar9.e());
            bVar9.c(m1.k0("Message", f6001w, this.mRefreshMenuListener));
            List<b> list9 = this.fragmentList;
            kotlin.jvm.internal.m.c(list9);
            list9.add(bVar9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(k0 k0Var, View view, int i10, KeyEvent keyEvent) {
        y1 y1Var;
        f0 f0Var;
        if (keyEvent.getAction() == 0) {
            if (i10 != 19) {
                if (i10 == 22 && (f0Var = k0Var.mBaseFragment) != null) {
                    kotlin.jvm.internal.m.c(f0Var);
                    f0Var.W(true);
                    return true;
                }
            } else {
                ListView listView = k0Var.mMenuListView;
                if (listView != null) {
                    kotlin.jvm.internal.m.c(listView);
                    if (listView.getSelectedItemPosition() == 0 && (y1Var = f6000v) != null) {
                        kotlin.jvm.internal.m.c(y1Var);
                        y1Var.a(0);
                        w0 w0Var = k0Var.menuAdapter;
                        kotlin.jvm.internal.m.c(w0Var);
                        w0Var.a(0, false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(k0 k0Var) {
        k0Var.r0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x1.f1.lb.util.e0.f21385a.a(this);
    }
}
