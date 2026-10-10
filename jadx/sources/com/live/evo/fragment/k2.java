package com.live.evo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$dimen;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u001c\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u0004R\u001c\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010)R\u0018\u00105\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010)R\u0018\u00109\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010)R\u0018\u0010;\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010)R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010Z¨\u0006^"}, d2 = {"Lcom/live/evo/fragment/k2;", "Lcom/live/evo/fragment/f0;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "", "R", "()I", "Landroid/view/View;", "view", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.LATITUDE_SOUTH, "(Landroid/os/Bundle;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "hasFocus", ExifInterface.LONGITUDE_WEST, "(Z)V", "isVisible", "X", "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onDestroy", "x0", "w0", "y0", "Lq6/b;", "kotlin.jvm.PlatformType", "f", "Lq6/b;", "logger", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "mTvCureent", "h", "mTvAll", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "mTvLayout", "j", "mTvNodata", "k", "Landroid/view/View;", "mEpgDescParent", "l", "mEpgTime", "m", "mEpgProgramName", "n", "mEpgDesc", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "mIconChannel", "", "Li5/c0;", "p", "Ljava/util/List;", "mList", "Landroidx/recyclerview/widget/RecyclerView;", "q", "Landroidx/recyclerview/widget/RecyclerView;", "mSubscribeRecyclerView", "Lcom/live/evo/widget/ProgramListView;", "r", "Lcom/live/evo/widget/ProgramListView;", "mSubscribeListView", "Ln5/q;", "s", "Ln5/q;", "mListViewAdapter", "Ljava/util/Timer;", "t", "Ljava/util/Timer;", "mTimer", "Landroid/os/Handler;", "u", "Landroid/os/Handler;", "mHandler", "Lcom/live/evo/osd/v;", "Lcom/live/evo/osd/v;", "subscribeUpdateListener", "w", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k2 extends f0 implements View.OnKeyListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static SoftReference<k2> f6021x;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCureent;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvAll;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mTvLayout;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private TextView mTvNodata;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private View mEpgDescParent;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgTime;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgProgramName;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgDesc;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ImageView mIconChannel;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private List<i5.c0> mList;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mSubscribeRecyclerView;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ProgramListView mSubscribeListView;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private n5.q mListViewAdapter;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Timer mTimer;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(k2.class);

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler = new f(Looper.getMainLooper());

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final com.live.evo.osd.v subscribeUpdateListener = new com.live.evo.osd.v() { // from class: com.live.evo.fragment.h2
        @Override // com.live.evo.osd.v
        public final void onUpdate() {
            k2.A0(this.f5983a);
        }
    };

    /* JADX INFO: renamed from: com.live.evo.fragment.k2$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/live/evo/fragment/k2$a;", "", "<init>", "()V", "", "tag", "Lcom/live/evo/fragment/k2;", "a", "(Ljava/lang/String;)Lcom/live/evo/fragment/k2;", "", "INIT_SUBSCRIBEDATA", "I", "Ljava/lang/ref/SoftReference;", "sfrInstance", "Ljava/lang/ref/SoftReference;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final k2 a(String tag) {
            k2 k2Var;
            SoftReference softReference = k2.f6021x;
            k2 k2Var2 = null;
            if (softReference != null) {
                k2Var = (k2) softReference.get();
            } else {
                k2Var = null;
            }
            if (k2Var != null) {
                return k2Var;
            }
            synchronized (Companion.class) {
                SoftReference softReference2 = k2.f6021x;
                if (softReference2 != null) {
                    k2Var2 = (k2) softReference2.get();
                }
                if (k2Var2 != null) {
                    return k2Var2;
                }
                k2 k2Var3 = new k2();
                Bundle bundle = new Bundle();
                bundle.putString("tag", tag);
                k2Var3.setArguments(bundle);
                k2.f6021x = new SoftReference(k2Var3);
                return k2Var3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.SubscribeFragment$initSubscibeData$1", f = "SubscribeFragment.kt", l = {273}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.SubscribeFragment$initSubscibeData$1$1", f = "SubscribeFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Li5/c0;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends i5.c0>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ k2 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k2 k2Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = k2Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends i5.c0>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.logger.error("get subscribe data failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.fragment.k2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0076b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k2 f6039a;

            /* JADX INFO: renamed from: com.live.evo.fragment.k2$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.SubscribeFragment$initSubscibeData$1$2$1", f = "SubscribeFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ List<i5.c0> $subscribeBeans;
                int label;
                final /* synthetic */ k2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(k2 k2Var, List<? extends i5.c0> list, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = k2Var;
                    this.$subscribeBeans = list;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$subscribeBeans, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                /* JADX WARN: Code duplicated, block: B:20:0x00da  */
                /* JADX WARN: Code duplicated, block: B:22:0x0106  */
                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    ProgramListView programListView;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        List list = this.this$0.mList;
                        kotlin.jvm.internal.m.c(list);
                        List<i5.c0> list2 = this.$subscribeBeans;
                        kotlin.jvm.internal.m.c(list2);
                        list.addAll(list2);
                        if (this.this$0.mList != null) {
                            List list3 = this.this$0.mList;
                            kotlin.jvm.internal.m.c(list3);
                            if (list3.isEmpty()) {
                                LinearLayout linearLayout = this.this$0.mTvLayout;
                                kotlin.jvm.internal.m.c(linearLayout);
                                linearLayout.setVisibility(8);
                                RecyclerView recyclerView = this.this$0.mSubscribeRecyclerView;
                                kotlin.jvm.internal.m.c(recyclerView);
                                recyclerView.setVisibility(8);
                                TextView textView = this.this$0.mTvNodata;
                                kotlin.jvm.internal.m.c(textView);
                                textView.setVisibility(0);
                                programListView = this.this$0.mSubscribeListView;
                                if (programListView != null) {
                                    programListView.setVisibility(8);
                                }
                            } else {
                                TextView textView2 = this.this$0.mTvNodata;
                                kotlin.jvm.internal.m.c(textView2);
                                textView2.setVisibility(8);
                                LinearLayout linearLayout2 = this.this$0.mTvLayout;
                                kotlin.jvm.internal.m.c(linearLayout2);
                                linearLayout2.setVisibility(0);
                                TextView textView3 = this.this$0.mTvCureent;
                                kotlin.jvm.internal.m.c(textView3);
                                textView3.setText("1");
                                TextView textView4 = this.this$0.mTvAll;
                                kotlin.jvm.internal.m.c(textView4);
                                List list4 = this.this$0.mList;
                                kotlin.jvm.internal.m.c(list4);
                                textView4.setText("/" + list4.size());
                                RecyclerView recyclerView2 = this.this$0.mSubscribeRecyclerView;
                                kotlin.jvm.internal.m.c(recyclerView2);
                                recyclerView2.setVisibility(8);
                                ProgramListView programListView2 = this.this$0.mSubscribeListView;
                                if (programListView2 != null) {
                                    programListView2.setVisibility(0);
                                }
                                if (this.this$0.mListViewAdapter != null) {
                                    n5.q qVar = this.this$0.mListViewAdapter;
                                    if (qVar != null) {
                                        qVar.d(this.$subscribeBeans, 0);
                                    }
                                } else {
                                    this.this$0.mListViewAdapter = new n5.q(this.this$0.getContext(), this.$subscribeBeans);
                                    ProgramListView programListView3 = this.this$0.mSubscribeListView;
                                    if (programListView3 != null) {
                                        programListView3.setAdapter((ListAdapter) this.this$0.mListViewAdapter);
                                    }
                                }
                            }
                        } else {
                            LinearLayout linearLayout3 = this.this$0.mTvLayout;
                            kotlin.jvm.internal.m.c(linearLayout3);
                            linearLayout3.setVisibility(8);
                            RecyclerView recyclerView3 = this.this$0.mSubscribeRecyclerView;
                            kotlin.jvm.internal.m.c(recyclerView3);
                            recyclerView3.setVisibility(8);
                            TextView textView5 = this.this$0.mTvNodata;
                            kotlin.jvm.internal.m.c(textView5);
                            textView5.setVisibility(0);
                            programListView = this.this$0.mSubscribeListView;
                            if (programListView != null) {
                                programListView.setVisibility(8);
                            }
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0076b(k2 k2Var) {
                this.f6039a = k2Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<? extends i5.c0> list, v8.f<? super r8.z> fVar) {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    for (i5.c0 c0Var : list) {
                        this.f6039a.logger.debug("subject_date", c0Var.a() + "/" + c0Var.g() + ", " + c0Var.h() + ", " + c0Var.j());
                    }
                }
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.f6039a, list, null), 3, null);
                return r8.z.f17874a;
            }
        }

        b(v8.f<? super b> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return k2.this.new b(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(com.live.evo.util.s0.f7342a.K(), new a(k2.this, null));
                C0076b c0076b = new C0076b(k2.this);
                this.label = 1;
                if (fVarF.collect(c0076b, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/k2$c", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k2.this.mHandler.sendEmptyMessage(327681);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/k2$d", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            if (view == null || k2.this.mList == null) {
                return;
            }
            List list = k2.this.mList;
            kotlin.jvm.internal.m.c(list);
            if (position >= list.size()) {
                return;
            }
            TextView textView = k2.this.mTvCureent;
            kotlin.jvm.internal.m.c(textView);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(position + 1);
            textView.setText(sb2.toString());
            List list2 = k2.this.mList;
            kotlin.jvm.internal.m.c(list2);
            i5.c0 c0Var = (i5.c0) list2.get(position);
            Long lH = c0Var.h();
            kotlin.jvm.internal.m.e(lH, "getStartTime(...)");
            String strM = com.live.evo.util.q1.m(lH.longValue(), com.live.evo.util.x1.j(R$string.ddMMyyyy));
            TextView textView2 = k2.this.mEpgTime;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setText(strM);
            String strValueOf = String.valueOf(c0Var.f() + 1);
            if (strValueOf.length() <= 1) {
                strValueOf = "00" + strValueOf;
            } else if (strValueOf.length() <= 2) {
                strValueOf = "0" + strValueOf;
            }
            TextView textView3 = k2.this.mEpgProgramName;
            kotlin.jvm.internal.m.c(textView3);
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str = String.format("%s  %s", Arrays.copyOf(new Object[]{strValueOf, c0Var.b()}, 2));
            kotlin.jvm.internal.m.e(str, "format(...)");
            textView3.setText(str);
            TextView textView4 = k2.this.mEpgDesc;
            kotlin.jvm.internal.m.c(textView4);
            String str2 = String.format("%s%s", Arrays.copyOf(new Object[]{com.live.evo.util.x1.j(R$string.epg_description), c0Var.c()}, 2));
            kotlin.jvm.internal.m.e(str2, "format(...)");
            textView4.setText(str2);
            com.live.evo.util.v.d(k2.this.getContext(), c0Var.e(), k2.this.mIconChannel);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            View view2 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view2);
            view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            View view3 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view3);
            int height = view3.getHeight();
            int dimensionPixelOffset = k2.this.requireContext().getResources().getDimensionPixelOffset(R$dimen.epg_padding);
            int dimensionPixelOffset2 = k2.this.requireContext().getResources().getDimensionPixelOffset(R$dimen.epg_padding_width);
            Object systemService = k2.this.requireContext().getSystemService("window");
            kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            int height2 = ((WindowManager) systemService).getDefaultDisplay().getHeight();
            int top = view.getTop() + dimensionPixelOffset;
            if (height + top > height2) {
                top = height2 - height;
            }
            View view4 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view4);
            view4.setTranslationY(top);
            View view5 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view5);
            view5.setTranslationX(view.getWidth() + dimensionPixelOffset2);
            View view6 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view6);
            view6.requestLayout();
            View view7 = k2.this.mEpgDescParent;
            kotlin.jvm.internal.m.c(view7);
            if (view7.getVisibility() != 0) {
                View view8 = k2.this.mEpgDescParent;
                kotlin.jvm.internal.m.c(view8);
                view8.setVisibility(0);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.SubscribeFragment$initSubscribeList$2$1", f = "SubscribeFragment.kt", l = {391}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ i5.c0 $bean;
        int label;
        final /* synthetic */ k2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(i5.c0 c0Var, k2 k2Var, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$bean = c0Var;
            this.this$0 = k2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$bean, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            e eVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                    eVar = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String strA = this.$bean.a();
                kotlin.jvm.internal.m.e(strA, "getChannelId(...)");
                int i11 = Integer.parseInt(strA);
                Long lH = this.$bean.h();
                kotlin.jvm.internal.m.e(lH, "getStartTime(...)");
                long jLongValue = lH.longValue();
                String strD = this.$bean.d();
                kotlin.jvm.internal.m.e(strD, "getEpgId(...)");
                this.label = 1;
                eVar = this;
                if (t.v.c.i.a.K0(aVar, i11, jLongValue, strD, null, eVar, 8, null) == objC) {
                    return objC;
                }
            }
            eVar.this$0.w0();
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/k2$f", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            if (msg.what == 327681) {
                k2.this.w0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(final k2 k2Var) {
        com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.j2
            @Override // java.lang.Runnable
            public final void run() {
                k2.B0(this.f5993a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(k2 k2Var) {
        n5.q qVar = k2Var.mListViewAdapter;
        if (qVar != null) {
            qVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        List<i5.c0> list = this.mList;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(null), 3, null);
    }

    private final void x0() {
        Timer timer = this.mTimer;
        if (timer != null) {
            kotlin.jvm.internal.m.c(timer);
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        kotlin.jvm.internal.m.c(timer2);
        timer2.schedule(new c(), 10L);
    }

    private final void y0() {
        ProgramListView programListView = this.mSubscribeListView;
        if (programListView != null) {
            programListView.setOnItemSelectedListener(new d());
        }
        ProgramListView programListView2 = this.mSubscribeListView;
        if (programListView2 != null) {
            programListView2.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.i2
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                    return k2.z0(this.f5988a, view, i10, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0(k2 k2Var, View view, int i10, KeyEvent keyEvent) {
        List<i5.c0> list = k2Var.mList;
        if (list == null) {
            return false;
        }
        if ((i10 != 23 && i10 != 66) || keyEvent.getAction() != 0 || com.live.evo.util.x1.m(500L)) {
            return false;
        }
        ProgramListView programListView = k2Var.mSubscribeListView;
        int selectedItemPosition = programListView != null ? programListView.getSelectedItemPosition() : 0;
        int i11 = selectedItemPosition >= 0 ? selectedItemPosition : 0;
        if (i11 >= list.size()) {
            return true;
        }
        com.live.evo.util.q1.b();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new e(list.get(i11), k2Var, null), 3, null);
        return true;
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        RecyclerView recyclerView = this.mSubscribeRecyclerView;
        kotlin.jvm.internal.m.c(recyclerView);
        recyclerView.setOnKeyListener(this);
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        this.mTvLayout = (LinearLayout) view.findViewById(R$id.subscribef_ll_subscribe_layout);
        this.mTvCureent = (TextView) view.findViewById(R$id.subscribef_tv_subscribe_current);
        this.mTvAll = (TextView) view.findViewById(R$id.subscribef_tv_subscribe_all);
        this.mTvNodata = (TextView) view.findViewById(R$id.subscribef_tv_subscribe_nodata);
        this.mSubscribeRecyclerView = (RecyclerView) view.findViewById(R$id.subscribef_rv_subscribe_list);
        this.mEpgDescParent = view.findViewById(R$id.subscribef_l_epg_desc_parent);
        this.mEpgDesc = (TextView) view.findViewById(R$id.favepgdesc_tv_epg_desc);
        this.mEpgTime = (TextView) view.findViewById(R$id.favepgdesc_tv_epg_time);
        this.mEpgProgramName = (TextView) view.findViewById(R$id.favepgdesc_tv_epg_channel_name);
        this.mIconChannel = (ImageView) view.findViewById(R$id.favepgdesc_iv_icon_channel);
        this.mSubscribeListView = (ProgramListView) view.findViewById(R$id.lv_subscribe);
        int i10 = TextUtils.equals(com.live.evo.util.x1.j(R$string.subscribe_icon_show), "show") ? 0 : 8;
        ImageView imageView = this.mIconChannel;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
        y0();
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.mTvCureent);
            com.live.evo.util.t.b(this.mTvAll);
            com.live.evo.util.t.c(this.mTvNodata);
            com.live.evo.util.t.b(this.mEpgTime);
            com.live.evo.util.t.b(this.mEpgTime);
            com.live.evo.util.t.b(this.mEpgProgramName);
            com.live.evo.util.t.b(this.mEpgDesc);
            return;
        }
        com.live.evo.util.t.d(this.mTvCureent);
        com.live.evo.util.t.b(this.mTvAll);
        com.live.evo.util.t.c(this.mTvNodata);
        com.live.evo.util.t.c(this.mEpgTime);
        com.live.evo.util.t.c(this.mEpgTime);
        com.live.evo.util.t.c(this.mEpgProgramName);
        com.live.evo.util.t.b(this.mEpgDesc);
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean hasFocus) {
        ProgramListView programListView = this.mSubscribeListView;
        if (programListView != null) {
            ListAdapter adapter = programListView.getAdapter();
            if ((adapter != null ? adapter.getCount() : 0) > 0) {
                programListView.requestFocus();
                programListView.setSelection(0);
            }
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean isVisible) {
        if (isVisible) {
            x0();
            return;
        }
        View view = this.mEpgDescParent;
        if (view != null) {
            kotlin.jvm.internal.m.c(view);
            if (view.getVisibility() == 0) {
                View view2 = this.mEpgDescParent;
                kotlin.jvm.internal.m.c(view2);
                view2.setVisibility(8);
            }
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            kotlin.jvm.internal.m.c(timer);
            timer.cancel();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode == 20) {
            List<i5.c0> list = this.mList;
            if (list != null) {
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0) {
                    List<i5.c0> list2 = this.mList;
                    kotlin.jvm.internal.m.c(list2);
                    int size = list2.size();
                    RecyclerView recyclerView = this.mSubscribeRecyclerView;
                    kotlin.jvm.internal.m.c(recyclerView);
                    int i10 = size - 1;
                    if (recyclerView.findViewHolderForAdapterPosition(i10) != null) {
                        RecyclerView recyclerView2 = this.mSubscribeRecyclerView;
                        kotlin.jvm.internal.m.c(recyclerView2);
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(i10);
                        kotlin.jvm.internal.m.c(viewHolderFindViewHolderForAdapterPosition);
                        View itemView = viewHolderFindViewHolderForAdapterPosition.itemView;
                        kotlin.jvm.internal.m.e(itemView, "itemView");
                        if (itemView.isFocused()) {
                            itemView.requestFocus();
                        }
                    }
                }
            }
            return true;
        }
        if (keyCode == 19) {
            List<i5.c0> list3 = this.mList;
            if (list3 != null) {
                kotlin.jvm.internal.m.c(list3);
                if (list3.size() > 0) {
                    RecyclerView recyclerView3 = this.mSubscribeRecyclerView;
                    kotlin.jvm.internal.m.c(recyclerView3);
                    if (recyclerView3.findViewHolderForAdapterPosition(0) != null) {
                        RecyclerView recyclerView4 = this.mSubscribeRecyclerView;
                        kotlin.jvm.internal.m.c(recyclerView4);
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = recyclerView4.findViewHolderForAdapterPosition(0);
                        kotlin.jvm.internal.m.c(viewHolderFindViewHolderForAdapterPosition2);
                        View itemView2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                        kotlin.jvm.internal.m.e(itemView2, "itemView");
                        if (itemView2.isFocused()) {
                            itemView2.requestFocus();
                        }
                    }
                }
            }
            return true;
        }
        if (keyCode == 21 && event.getAction() == 0) {
            if (this.f5935e != null) {
                View view = this.mEpgDescParent;
                if (view != null) {
                    kotlin.jvm.internal.m.c(view);
                    if (view.getVisibility() == 0) {
                        View view2 = this.mEpgDescParent;
                        kotlin.jvm.internal.m.c(view2);
                        view2.setVisibility(8);
                    }
                }
                this.f5935e.D(this);
            }
        } else if (keyCode == 22 && event.getAction() == 0) {
            Z(getView());
        }
        return false;
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newfragment_subscribe;
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle savedInstanceState) {
        x0();
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f6021x = null;
    }
}
