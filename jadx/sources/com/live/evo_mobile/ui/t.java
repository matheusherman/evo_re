package com.live.evo_mobile.ui;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.apache.log4j.helpers.FileWatchdog;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u7.EpgData;
import u7.EpgDateData;
import u7.MessageEventData;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002STB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010&J\u0015\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020)¢\u0006\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u0016R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010P¨\u0006U"}, d2 = {"Lcom/live/evo_mobile/ui/t;", "Lcom/tvc/lib/mobile/ui/base/e;", "Lz4/c0;", "<init>", "()V", "Lr8/z;", "A0", "z0", "K0", "", "Lu7/c;", "epgList", "", "F0", "(Ljava/util/List;)Z", "y0", "", ExifInterface.LONGITUDE_WEST, "()I", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "G0", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D0", "y", "Lu7/h;", NotificationCompat.CATEGORY_EVENT, "onMessageEvent", "(Lu7/h;)V", "R", "onDestroy", "Lcom/live/evo_mobile/ui/t$b;", "playbackCallback", "H0", "(Lcom/live/evo_mobile/ui/t$b;)V", "position", "s0", "(I)V", "pos", "J0", "", "dateText", "I0", "(Ljava/lang/String;)V", "w0", "()Ljava/lang/String;", "e", "Z", "hasInitView", "f", "Lcom/live/evo_mobile/ui/t$b;", "g", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "x0", "()Lz1/b1/lb/m/meta/ChannelStreamResponse;", "setResponse", "Ljava/util/Timer;", "h", "Ljava/util/Timer;", "timer", "i", "I", "playingEpgPos", "j", "Ljava/lang/String;", "playingEpgDateText", "", "k", "J", "showEpgDate", "Lcom/live/evo_mobile/adapter/b;", "l", "Lr8/i;", "v0", "()Lcom/live/evo_mobile/adapter/b;", "mEpgTimeListAdapter", "Lcom/live/evo_mobile/adapter/d;", "m", "u0", "()Lcom/live/evo_mobile/adapter/d;", "mEpgListAdapter", "n", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t extends com.tvc.lib.mobile.ui.base.e<z4.c0> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f8177o = "Today";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f8178p = "None";

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasInitView;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b playbackCallback;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ChannelStreamResponse response;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Timer timer = new Timer();

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int playingEpgPos = -2;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String playingEpgDateText = f8178p;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long showEpgDate = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final r8.i mEpgTimeListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.p
        @Override // c9.a
        public final Object invoke() {
            return t.C0();
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final r8.i mEpgListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.q
        @Override // c9.a
        public final Object invoke() {
            return t.B0();
        }
    });

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.t$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/live/evo_mobile/ui/t$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/t;", "c", "()Lcom/live/evo_mobile/ui/t;", "", "EPG_DATE_TEXT_TODAY", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEPG_DATE_TEXT_TODAY", "(Ljava/lang/String;)V", "EPG_DATE_TEXT_NONE", "a", "setEPG_DATE_TEXT_NONE", "", "EPG_MAX_LEFT_DAYS", "I", "", "EPG_DATE_NONE", "J", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final t c() {
            return new t();
        }

        public final String a() {
            return t.f8178p;
        }

        public final String b() {
            return t.f8177o;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/live/evo_mobile/ui/t$b;", "", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "Lz1/b1/lb/m/meta/EPGProgramme;", "epgProgramme", "", IjkMediaMeta.IJKM_KEY_TYPE, "position", "Lr8/z;", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;II)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        void a(ChannelStreamResponse response, EPGProgramme epgProgramme, int type, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/t$c", "Lr7/e$a;", "Lu7/d;", "item", "", "position", "Lr8/z;", "h", "(Lu7/d;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements r7.e.a<EpgDateData> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$initListener$1$onItemSelected$1$1", f = "EpgListFragment.kt", l = {211}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ EpgDateData $item;
            final /* synthetic */ ChannelStreamResponse $streamResponse;
            final /* synthetic */ String $yyyyMMdd;
            int label;
            final /* synthetic */ t this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.t$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$initListener$1$onItemSelected$1$1$1", f = "EpgListFragment.kt", l = {207}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0143a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>>, Throwable, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ t this$0;

                /* JADX INFO: renamed from: com.live.evo_mobile.ui.t$c$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$initListener$1$onItemSelected$1$1$1$1", f = "EpgListFragment.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
                static final class C0144a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                    int label;
                    final /* synthetic */ t this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0144a(t tVar, v8.f<? super C0144a> fVar) {
                        super(2, fVar);
                        this.this$0 = tVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                        return new C0144a(this.this$0, fVar);
                    }

                    @Override // c9.p
                    public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                        return ((C0144a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r8.r.b(obj);
                            this.this$0.U();
                            this.this$0.K0();
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0143a(t tVar, v8.f<? super C0143a> fVar) {
                    super(3, fVar);
                    this.this$0 = tVar;
                }

                @Override // c9.q
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                    return new C0143a(this.this$0, fVar).invokeSuspend(r8.z.f17874a);
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
                        kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                        C0144a c0144a = new C0144a(this.this$0, null);
                        this.label = 1;
                        if (kotlinx.coroutines.h.g(g2VarC, c0144a, this) == objC) {
                            return objC;
                        }
                    }
                    return r8.z.f17874a;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class b<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ t f8189a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f8190b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ChannelStreamResponse f8191c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ EpgDateData f8192d;

                /* JADX INFO: renamed from: com.live.evo_mobile.ui.t$c$a$b$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$initListener$1$onItemSelected$1$1$2$1", f = "EpgListFragment.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
                static final class C0145a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                    final /* synthetic */ List<EPGProgramme> $it;
                    final /* synthetic */ EpgDateData $item;
                    final /* synthetic */ ChannelStreamResponse $streamResponse;
                    final /* synthetic */ String $yyyyMMdd;
                    int label;
                    final /* synthetic */ t this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0145a(t tVar, String str, ChannelStreamResponse channelStreamResponse, List<? extends EPGProgramme> list, EpgDateData epgDateData, v8.f<? super C0145a> fVar) {
                        super(2, fVar);
                        this.this$0 = tVar;
                        this.$yyyyMMdd = str;
                        this.$streamResponse = channelStreamResponse;
                        this.$it = list;
                        this.$item = epgDateData;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                        return new C0145a(this.this$0, this.$yyyyMMdd, this.$streamResponse, this.$it, this.$item, fVar);
                    }

                    @Override // c9.p
                    public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                        return ((C0145a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* JADX WARN: Multi-variable type inference failed */
                    public static final r8.z c(EpgDateData epgDateData, t tVar, List list) {
                        int i10;
                        long jD = x1.f1.lb.util.d1.d();
                        int i11 = -2;
                        if (kotlin.jvm.internal.m.a(epgDateData.getDate(), tVar.playingEpgDateText)) {
                            int i12 = tVar.playingEpgPos;
                            if (i12 != -2 && i12 != -1) {
                                i11 = tVar.playingEpgPos;
                                i10 = tVar.playingEpgPos;
                            } else {
                                Iterator<T> it = list.iterator();
                                int i13 = 0;
                                while (true) {
                                    if (it.hasNext()) {
                                        int i14 = i13 + 1;
                                        EpgData epgData = (EpgData) it.next();
                                        if (epgData.getStart() <= jD && epgData.getStop() > jD) {
                                            if (tVar.playingEpgPos == -1) {
                                                i11 = i13;
                                            }
                                            i10 = i13;
                                            break;
                                        }
                                        i13 = i14;
                                    } else {
                                        i10 = 0;
                                        break;
                                    }
                                }
                            }
                        } else {
                            long jD2 = x1.f1.lb.util.d1.d();
                            Iterator<T> it2 = list.iterator();
                            int i15 = 0;
                            while (true) {
                                if (it2.hasNext()) {
                                    int i16 = i15 + 1;
                                    EpgData epgData2 = (EpgData) it2.next();
                                    if (epgData2.getStart() <= jD2 && epgData2.getStop() > jD2) {
                                        i10 = i15;
                                        break;
                                    }
                                    i15 = i16;
                                } else {
                                    i10 = 0;
                                    break;
                                }
                            }
                        }
                        tVar.F0(list);
                        tVar.u0().U(list, Integer.valueOf(i11));
                        if (i10 > 0) {
                            RecyclerView.LayoutManager layoutManager = ((z4.c0) tVar.T()).f22724b.getLayoutManager();
                            kotlin.jvm.internal.m.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i10 - 1, z7.p.a(10, tVar.getContext()));
                        } else {
                            RecyclerView.LayoutManager layoutManager2 = ((z4.c0) tVar.T()).f22724b.getLayoutManager();
                            if (layoutManager2 != null) {
                                layoutManager2.scrollToPosition(0);
                            }
                        }
                        return r8.z.f17874a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r8.r.b(obj);
                            this.this$0.U();
                            t tVar = this.this$0;
                            String str = this.$yyyyMMdd;
                            kotlin.jvm.internal.m.c(str);
                            ChannelStreamResponse channelStreamResponse = this.$streamResponse;
                            List<EPGProgramme> list = this.$it;
                            final EpgDateData epgDateData = this.$item;
                            final t tVar2 = this.this$0;
                            tVar.a0(str, channelStreamResponse, list, new c9.l() { // from class: com.live.evo_mobile.ui.u
                                @Override // c9.l
                                public final Object invoke(Object obj2) {
                                    return t.c.a.b.C0145a.c(epgDateData, tVar2, (List) obj2);
                                }
                            });
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                b(t tVar, String str, ChannelStreamResponse channelStreamResponse, EpgDateData epgDateData) {
                    this.f8189a = tVar;
                    this.f8190b = str;
                    this.f8191c = channelStreamResponse;
                    this.f8192d = epgDateData;
                }

                @Override // kotlinx.coroutines.flow.g
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(List<? extends EPGProgramme> list, v8.f<? super r8.z> fVar) {
                    Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new C0145a(this.f8189a, this.f8190b, this.f8191c, list, this.f8192d, null), fVar);
                    if (objG == kotlin.coroutines.intrinsics.b.c()) {
                        return objG;
                    }
                    return r8.z.f17874a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ChannelStreamResponse channelStreamResponse, String str, t tVar, EpgDateData epgDateData, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$streamResponse = channelStreamResponse;
                this.$yyyyMMdd = str;
                this.this$0 = tVar;
                this.$item = epgDateData;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$streamResponse, this.$yyyyMMdd, this.this$0, this.$item, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                    t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                    String epgId = this.$streamResponse.getEpgId();
                    kotlin.jvm.internal.m.e(epgId, "getEpgId(...)");
                    String str = this.$yyyyMMdd;
                    kotlin.jvm.internal.m.c(str);
                    kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.E(epgId, str), new C0143a(this.this$0, null));
                    b bVar = new b(this.this$0, this.$yyyyMMdd, this.$streamResponse, this.$item);
                    this.label = 1;
                    if (fVarF.collect(bVar, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        c() {
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(EpgDateData item, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            String strH = x1.f1.lb.util.n.n().h(2, item.getTimestamp());
            ChannelStreamResponse response = t.this.getResponse();
            if (response != null) {
                t tVar = t.this;
                tVar.Z();
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(kotlinx.coroutines.a2.b(null, 1, null))), null, null, new a(response, strH, tVar, item, null), 3, null);
            }
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void e(EpgDateData epgDateData, int i10) {
            r7.e.a.C0344a.a(this, epgDateData, i10);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void a(EpgDateData epgDateData) {
            r7.e.a.C0344a.b(this, epgDateData);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(EpgDateData epgDateData, int i10, List<EpgDateData> list) {
            r7.e.a.C0344a.d(this, epgDateData, i10, list);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(boolean z10, EpgDateData epgDateData) {
            r7.e.a.C0344a.e(this, z10, epgDateData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/live/evo_mobile/ui/t$d", "Lcom/live/evo_mobile/adapter/d$a;", "Lu7/c;", "item", "", IjkMediaMeta.IJKM_KEY_TYPE, "position", "Lr8/z;", "a", "(Lu7/c;II)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements com.live.evo_mobile.adapter.d.a {
        d() {
        }

        @Override // com.live.evo_mobile.adapter.d.a
        public void a(EpgData item, int type, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            if (t.this.playbackCallback == null || t.this.getResponse() == null) {
                return;
            }
            if (t.this.v0().S() < t.this.v0().m().size()) {
                t tVar = t.this;
                tVar.playingEpgDateText = ((EpgDateData) tVar.v0().m().get(t.this.v0().S())).getDate();
            }
            b bVar = t.this.playbackCallback;
            if (bVar != null) {
                ChannelStreamResponse response = t.this.getResponse();
                kotlin.jvm.internal.m.c(response);
                bVar.a(response, item, type, position);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgDates$1", f = "EpgListFragment.kt", l = {299, 303}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgDates$1$1", f = "EpgListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ List<String> $dates;
            final /* synthetic */ long $minTime;
            final /* synthetic */ long $now;
            final /* synthetic */ String $today;
            int label;
            final /* synthetic */ t this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List<String> list, t tVar, long j10, String str, long j11, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$dates = list;
                this.this$0 = tVar;
                this.$minTime = j10;
                this.$today = str;
                this.$now = j11;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$dates, this.this$0, this.$minTime, this.$today, this.$now, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                String str;
                kotlin.coroutines.intrinsics.b.c();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
                if (this.$dates.isEmpty()) {
                    this.this$0.showEpgDate = -1L;
                    this.this$0.playingEpgDateText = t.INSTANCE.a();
                    ((z4.c0) this.this$0.T()).f22723a.setVisibility(8);
                    this.this$0.U();
                    return r8.z.f17874a;
                }
                int i10 = 0;
                ((z4.c0) this.this$0.T()).f22723a.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                this.this$0.showEpgDate = -1L;
                Iterator it = this.$dates.iterator();
                int i11 = 0;
                int i12 = -1;
                int i13 = -1;
                int i14 = 0;
                while (true) {
                    str = "yyyyMMdd";
                    if (!it.hasNext()) {
                        break;
                    }
                    int i15 = i11 + 1;
                    long jD = x1.f1.lb.util.n.n().d((String) it.next(), "yyyyMMdd");
                    Iterator it2 = it;
                    if (jD >= this.$minTime) {
                        String strH = x1.f1.lb.util.n.n().h(17, jD);
                        if (strH.equals(this.$today)) {
                            this.this$0.showEpgDate = jD;
                            strH = t.INSTANCE.b();
                            i12 = i11;
                            i13 = i12;
                            i14 = i13;
                        }
                        kotlin.jvm.internal.m.c(strH);
                        arrayList.add(new EpgDateData(strH, jD, false));
                    }
                    i11 = i15;
                    it = it2;
                }
                if (x1.f1.lb.config.b.f20643a.u() && arrayList.isEmpty()) {
                    long millis = TimeUnit.DAYS.toMillis(1L);
                    int i16 = -7;
                    int i17 = 0;
                    while (i16 < 8) {
                        String str2 = str;
                        long j10 = this.$now + (((long) i16) * millis);
                        String strH2 = x1.f1.lb.util.n.n().h(17, j10);
                        if (strH2.equals(this.$today)) {
                            this.this$0.showEpgDate = j10;
                            strH2 = t.INSTANCE.b();
                            i12 = i17;
                            i13 = i12;
                            i14 = i13;
                        }
                        kotlin.jvm.internal.m.c(strH2);
                        arrayList.add(new EpgDateData(strH2, j10, false));
                        i17++;
                        i16++;
                        str = str2;
                    }
                }
                String str3 = str;
                int i18 = i14 - 7;
                if (i18 <= 0) {
                    if (i18 < 0 && !this.$dates.isEmpty()) {
                        long millis2 = TimeUnit.DAYS.toMillis(1L);
                        long jD2 = x1.f1.lb.util.n.n().d(this.$dates.get(0), str3);
                        int i19 = 1;
                        while (true) {
                            int i20 = i18 + 1;
                            if (i18 >= 0) {
                                break;
                            }
                            i13++;
                            i12++;
                            int i21 = i19 + 1;
                            long j11 = jD2 - (((long) i19) * millis2);
                            String strH3 = x1.f1.lb.util.n.n().h(17, j11);
                            kotlin.jvm.internal.m.c(strH3);
                            arrayList.add(0, new EpgDateData(strH3, j11, false));
                            i19 = i21;
                            i18 = i20;
                        }
                    }
                } else {
                    while (true) {
                        int i22 = i18 - 1;
                        if (i18 <= 0) {
                            break;
                        }
                        i13--;
                        i12--;
                        arrayList.remove(0);
                        i18 = i22;
                    }
                }
                if (i12 == -1) {
                    i13 = 0;
                } else {
                    i10 = i12;
                }
                this.this$0.v0().U(arrayList, kotlin.coroutines.jvm.internal.b.b(i10));
                int i23 = i13 + 2;
                if (i23 < arrayList.size()) {
                    RecyclerView.LayoutManager layoutManager = ((z4.c0) this.this$0.T()).f22723a.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.scrollToPosition(i23);
                    }
                } else {
                    RecyclerView.LayoutManager layoutManager2 = ((z4.c0) this.this$0.T()).f22723a.getLayoutManager();
                    if (layoutManager2 != null) {
                        layoutManager2.scrollToPosition(i13);
                    }
                }
                return r8.z.f17874a;
            }
        }

        e(v8.f<? super e> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return t.this.new e(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (kotlinx.coroutines.h.g(r13, r3, r12) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            this.label = 1;
            obj = aVar.B("", this);
            if (obj != objC) {
            }
            return objC;
            long jD = x1.f1.lb.util.d1.d();
            String strH = x1.f1.lb.util.n.n().h(17, jD);
            kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
            a aVar2 = new a((List) obj, t.this, jD - 604800000, strH, jD, null);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgList$1", f = "EpgListFragment.kt", l = {153}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgList$1$1", f = "EpgListFragment.kt", l = {150}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>>, Throwable, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ t this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.t$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgList$1$1$1", f = "EpgListFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0146a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ t this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0146a(t tVar, v8.f<? super C0146a> fVar) {
                    super(2, fVar);
                    this.this$0 = tVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0146a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0146a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.K0();
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t tVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = tVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(this.this$0, fVar).invokeSuspend(r8.z.f17874a);
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
                    kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                    C0146a c0146a = new C0146a(this.this$0, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0146a, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ t f8194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8195b;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.EpgListFragment$loadEpgList$1$2$1", f = "EpgListFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ List<EPGProgramme> $it;
                final /* synthetic */ String $yyyyMMdd;
                int label;
                final /* synthetic */ t this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(List<? extends EPGProgramme> list, t tVar, String str, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$it = list;
                    this.this$0 = tVar;
                    this.$yyyyMMdd = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$it, this.this$0, this.$yyyyMMdd, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                public static final r8.z c(t tVar, List list) {
                    tVar.U();
                    int i10 = tVar.playingEpgPos;
                    long jD = x1.f1.lb.util.d1.d();
                    if (tVar.playingEpgPos == -1 || tVar.playingEpgPos == -2) {
                        Iterator<T> it = list.iterator();
                        int i11 = 0;
                        while (it.hasNext()) {
                            int i12 = i11 + 1;
                            EpgData epgData = (EpgData) it.next();
                            if (epgData.getStart() <= jD && epgData.getStop() > jD) {
                                if (tVar.playingEpgPos == -1) {
                                    tVar.playingEpgPos = i11;
                                }
                                i10 = i11;
                                break;
                            }
                            i11 = i12;
                        }
                    }
                    tVar.F0(list);
                    tVar.u0().U(list, Integer.valueOf(tVar.playingEpgPos));
                    if (i10 > 0) {
                        RecyclerView.LayoutManager layoutManager = ((z4.c0) tVar.T()).f22724b.getLayoutManager();
                        kotlin.jvm.internal.m.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i10 - 1, z7.p.a(10, tVar.getContext()));
                    } else {
                        RecyclerView.LayoutManager layoutManager2 = ((z4.c0) tVar.T()).f22724b.getLayoutManager();
                        if (layoutManager2 != null) {
                            layoutManager2.scrollToPosition(Math.max(i10, 0));
                        }
                    }
                    return r8.z.f17874a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.$it.isEmpty()) {
                            this.this$0.K0();
                            return r8.z.f17874a;
                        }
                        t tVar = this.this$0;
                        String str = this.$yyyyMMdd;
                        kotlin.jvm.internal.m.c(str);
                        ChannelStreamResponse response = this.this$0.getResponse();
                        List<EPGProgramme> list = this.$it;
                        final t tVar2 = this.this$0;
                        tVar.a0(str, response, list, new c9.l() { // from class: com.live.evo_mobile.ui.v
                            @Override // c9.l
                            public final Object invoke(Object obj2) {
                                return t.f.b.a.c(tVar2, (List) obj2);
                            }
                        });
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(t tVar, String str) {
                this.f8194a = tVar;
                this.f8195b = str;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<? extends EPGProgramme> list, v8.f<? super r8.z> fVar) {
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(list, this.f8194a, this.f8195b, null), fVar);
                if (objG == kotlin.coroutines.intrinsics.b.c()) {
                    return objG;
                }
                return r8.z.f17874a;
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return t.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                String strH = x1.f1.lb.util.n.n().h(2, t.this.showEpgDate);
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                ChannelStreamResponse response = t.this.getResponse();
                kotlin.jvm.internal.m.c(response);
                String epgId = response.getEpgId();
                kotlin.jvm.internal.m.e(epgId, "getEpgId(...)");
                kotlin.jvm.internal.m.c(strH);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.E(epgId, strH), new a(t.this, null));
                b bVar = new b(t.this, strH);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/t$g", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g extends TimerTask {
        g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = t.this.getActivity();
            if (activity != null) {
                final t tVar = t.this;
                activity.runOnUiThread(new Runnable() { // from class: com.live.evo_mobile.ui.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.g.b(tVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(t tVar) {
            List<T> listM = tVar.u0().m();
            int playingPos = tVar.u0().getPlayingPos();
            long jD = x1.f1.lb.util.d1.d();
            if (tVar.playingEpgPos != -2) {
                int i10 = -1;
                int i11 = 0;
                int i12 = -1;
                for (T t10 : listM) {
                    int i13 = i11 + 1;
                    if (t10.getStart() <= jD && t10.getStop() > jD) {
                        i10 = i11;
                    }
                    if (t10.getSelected()) {
                        i12 = i11;
                    }
                    i11 = i13;
                }
                if (i10 != playingPos) {
                    if (i12 != playingPos) {
                        tVar.u0().notifyDataSetChanged();
                        return;
                    } else {
                        tVar.u0().R(i10);
                        return;
                    }
                }
                return;
            }
            if (tVar.F0(listM)) {
                tVar.u0().notifyDataSetChanged();
            }
        }
    }

    private final void A0() {
        g gVar = new g();
        long j10 = ((long) (60 - Calendar.getInstance().get(13))) * 1000;
        Timer timer = this.timer;
        if (timer == null || timer == null) {
            return;
        }
        timer.scheduleAtFixedRate(gVar, Math.max(j10, CoroutineLiveDataKt.DEFAULT_TIMEOUT), FileWatchdog.DEFAULT_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.d B0() {
        return new com.live.evo_mobile.adapter.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.b C0() {
        return new com.live.evo_mobile.adapter.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F0(List<EpgData> epgList) {
        long jA = x1.f1.lb.util.c0.f21354a.a();
        boolean z10 = false;
        for (EpgData epgData : epgList) {
            if (epgData.getStop() <= jA && epgData.getHasCatchup()) {
                epgData.d(false);
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.d u0() {
        return (com.live.evo_mobile.adapter.d) this.mEpgListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.b v0() {
        return (com.live.evo_mobile.adapter.b) this.mEpgTimeListAdapter.getValue();
    }

    private final void z0() {
        if (this.response == null) {
            K0();
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(kotlinx.coroutines.a2.b(null, 1, null))), null, null, new f(null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0() {
        if (this.hasInitView) {
            if (!u0().m().isEmpty()) {
                ((z4.c0) T()).f22724b.post(new Runnable() { // from class: com.live.evo_mobile.ui.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.E0(this.f8173a);
                    }
                });
            }
            y0();
            z0();
        }
    }

    public final void G0(ChannelStreamResponse response) {
        kotlin.jvm.internal.m.f(response, "response");
        this.response = response;
        u0().a0(response);
    }

    public final void H0(b playbackCallback) {
        kotlin.jvm.internal.m.f(playbackCallback, "playbackCallback");
        this.playbackCallback = playbackCallback;
    }

    public final void I0(String dateText) {
        kotlin.jvm.internal.m.f(dateText, "dateText");
        this.playingEpgDateText = dateText;
    }

    public final void J0(int pos) {
        this.playingEpgPos = pos;
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        Timer timer = this.timer;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.purge();
            }
            this.timer = null;
        }
        com.tvc.lib.mobile.ext.f.d(this);
        super.onDestroy();
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(MessageEventData event) {
        kotlin.jvm.internal.m.f(event, "event");
    }

    public final void s0(final int position) {
        FragmentActivity activity;
        if (position < 0 || position >= u0().m().size() || (activity = getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.live.evo_mobile.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                t.t0(this.f8169a, position);
            }
        });
    }

    /* JADX INFO: renamed from: w0, reason: from getter */
    public final String getPlayingEpgDateText() {
        return this.playingEpgDateText;
    }

    /* JADX INFO: renamed from: x0, reason: from getter */
    public final ChannelStreamResponse getResponse() {
        return this.response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(t tVar) {
        tVar.u0().submitList(kotlin.collections.r.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0() {
        u0().z(true);
        u0().A(S(), R$layout.view_empty_data);
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(t tVar, int i10) {
        tVar.u0().Q(i10);
    }

    private final void y0() {
        f8177o = getString(2131953076);
        f8178p = getString(2131953071);
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(kotlinx.coroutines.a2.b(null, 1, null))), null, null, new e(null), 3, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        com.tvc.lib.mobile.ext.f.c(this);
        Z();
        ((z4.c0) T()).f22723a.setAdapter(v0());
        ((z4.c0) T()).f22724b.setAdapter(u0());
        if (this.response != null) {
            com.live.evo_mobile.adapter.d dVarU0 = u0();
            ChannelStreamResponse channelStreamResponse = this.response;
            kotlin.jvm.internal.m.c(channelStreamResponse);
            dVarU0.a0(channelStreamResponse);
        }
        y0();
        z0();
        this.hasInitView = true;
        A0();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_epg_list;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        v0().T(new c());
        u0().b0(new d());
    }
}
