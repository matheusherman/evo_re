package com.live.evo_mobile.ui;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import u7.ChannelTitleData;
import u7.MessageEventData;
import u7.StoryListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001[\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0011\u001a\u00020\b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0004J\u0015\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001e¢\u0006\u0004\b+\u0010#J3\u00101\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\u00052\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\b\b\u0002\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u00102J!\u00105\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u001eH\u0002¢\u0006\u0004\b8\u0010#J\u0017\u00109\u001a\u00020\n2\u0006\u00107\u001a\u00020\u001eH\u0002¢\u0006\u0004\b9\u0010#J\u0017\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010<J\u001b\u0010>\u001a\u00020\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b>\u0010?R\u001c\u0010D\u001a\n A*\u0004\u0018\u00010@0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010O\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010U\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010R\u001a\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006a"}, d2 = {"Lcom/live/evo_mobile/ui/n;", "Lcom/tvc/lib/mobile/ui/base/a;", "Lz4/y;", "<init>", "()V", "", ExifInterface.LONGITUDE_WEST, "()I", "", "hidden", "Lr8/z;", "onHiddenChanged", "(Z)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "y", "Lkotlin/Function0;", "channelListLoader", "v0", "(Lc9/a;)Z", "Lcom/live/evo_mobile/adapter/n$a;", "clickListner", "L0", "(Lcom/live/evo_mobile/adapter/n$a;)V", "Lu7/h;", NotificationCompat.CATEGORY_EVENT, "onMessageEvent", "(Lu7/h;)V", "Lnf/e;", "onEPGUpdateEndEvent", "(Lnf/e;)V", "", "u0", "()Ljava/lang/String;", "streamId", "J0", "(Ljava/lang/String;)V", "R", "onDestroy", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "q0", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", "channelId", "z0", "position", "", "Lu7/i;", "list", "isUserClick", "E0", "(ILjava/util/List;Z)V", "", "delayMs", "H0", "(IJ)V", "column", "p0", "x0", "index", "M0", "(I)V", "r0", "G0", "(Ljava/lang/Integer;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "g", "Lq6/b;", "logger", "h", "Lcom/live/evo_mobile/adapter/n$a;", "clickListener", "i", "Ljava/lang/String;", "currentColumn", "j", "lastColumn", "k", "Z", "isVisible", "Lcom/live/evo_mobile/adapter/a;", "l", "Lr8/i;", "s0", "()Lcom/live/evo_mobile/adapter/a;", "mChannelListAdapter", "Lcom/live/evo_mobile/adapter/n;", "m", "t0", "()Lcom/live/evo_mobile/adapter/n;", "mStoryListAdapter", "com/live/evo_mobile/ui/n$b", "n", "Lcom/live/evo_mobile/ui/n$b;", "handler", "o", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n extends com.tvc.lib.mobile.ui.base.a<z4.y> {

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.live.evo_mobile.adapter.n.a clickListener;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(n.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String currentColumn = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String lastColumn = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final r8.i mChannelListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.i
        @Override // c9.a
        public final Object invoke() {
            return n.B0();
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final r8.i mStoryListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.j
        @Override // c9.a
        public final Object invoke() {
            return n.C0();
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final b handler = new b(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.n$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/live/evo_mobile/ui/n$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/n;", "a", "()Lcom/live/evo_mobile/ui/n;", "", "MSG_CLICK_COLUMN", "I", "MSG_SCROLL_TO_LAST_CHANNEL", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final n a() {
            return new n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/n$b", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "dispatchMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            int iIntValue;
            kotlin.jvm.internal.m.f(msg, "msg");
            int i10 = msg.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                n nVar = n.this;
                Object obj = msg.obj;
                nVar.G0(obj instanceof Integer ? (Integer) obj : null);
                return;
            }
            Object obj2 = msg.obj;
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            if (num == null || (iIntValue = num.intValue()) < 0 || iIntValue >= n.this.s0().m().size()) {
                return;
            }
            n.this.x0(((ChannelTitleData) n.this.s0().m().get(iIntValue)).getText());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"com/live/evo_mobile/ui/n$c", "Lr7/e$a;", "Lu7/b;", "item", "", "position", "", "l", "(Lu7/b;I)Z", "Lr8/z;", "i", "(Lu7/b;I)V", "g", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements r7.e.a<ChannelTitleData> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/n$c$a", "Lx1/f1/lb/util/m;", "", "value", "Lr8/z;", "d", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.util.m<Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f8142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f8143b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f8144c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ChannelTitleData f8145d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ u5.i f8146e;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.n$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/n$c$a$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class C0141a implements x1.f1.lb.util.m<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ n f8147a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ c f8148b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ChannelTitleData f8149c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f8150d;

                C0141a(n nVar, c cVar, ChannelTitleData channelTitleData, int i10) {
                    this.f8147a = nVar;
                    this.f8148b = cVar;
                    this.f8149c = channelTitleData;
                    this.f8150d = i10;
                }

                @Override // x1.f1.lb.util.m
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void a(String v10) {
                    kotlin.jvm.internal.m.f(v10, "v");
                    x1.f1.lb.media.d.f20812a.w("");
                    if (this.f8147a.getActivity() != null) {
                        this.f8148b.l(this.f8149c, this.f8150d);
                    }
                }
            }

            public void d(int value) {
                if (value != 1) {
                    if (value != 2) {
                        return;
                    }
                    this.f8142a.s0().notifyDataSetChanged();
                    n.I0(this.f8142a, this.f8143b, 0L, 2, null);
                    return;
                }
                u5.c cVar = new u5.c();
                cVar.c0(1);
                cVar.b0(new C0141a(this.f8142a, this.f8144c, this.f8145d, this.f8143b));
                final n nVar = this.f8142a;
                final u5.i iVar = this.f8146e;
                cVar.a0(new DialogInterface.OnCancelListener() { // from class: com.live.evo_mobile.ui.o
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        n.c.a.e(nVar, iVar, dialogInterface);
                    }
                });
                if (this.f8142a.getActivity() != null) {
                    FragmentActivity activity = this.f8142a.getActivity();
                    kotlin.jvm.internal.m.c(activity);
                    cVar.show(activity.getSupportFragmentManager(), "reset_adult_lock_password");
                }
            }

            a(n nVar, int i10, c cVar, ChannelTitleData channelTitleData, u5.i iVar) {
                this.f8142a = nVar;
                this.f8143b = i10;
                this.f8144c = cVar;
                this.f8145d = channelTitleData;
                this.f8146e = iVar;
            }

            @Override // x1.f1.lb.util.m
            public /* bridge */ /* synthetic */ void a(Integer num) {
                d(num.intValue());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(n nVar, u5.i iVar, DialogInterface dialogInterface) {
                if (nVar.getActivity() != null) {
                    FragmentActivity activity = nVar.getActivity();
                    kotlin.jvm.internal.m.c(activity);
                    iVar.show(activity.getSupportFragmentManager(), "set_adult_lock_password");
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean l(ChannelTitleData item, int position) {
            if (!t.v.c.i.a.f18646a.d0(item.getText())) {
                return false;
            }
            if (kotlin.jvm.internal.m.a(item.getText(), n.this.currentColumn)) {
                return true;
            }
            if (u5.i.INSTANCE.a()) {
                return false;
            }
            u5.i iVar = new u5.i();
            iVar.l0(1);
            iVar.k0(new a(n.this, position, this, item, iVar));
            if (n.this.getActivity() != null) {
                iVar.show(n.this.requireActivity().getSupportFragmentManager(), "set_adult_lock_password");
            }
            return true;
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(ChannelTitleData item, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            l(item, position);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(ChannelTitleData item, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            if (l(item, position)) {
                return;
            }
            n.I0(n.this, position, 0L, 2, null);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void a(ChannelTitleData channelTitleData) {
            r7.e.a.C0344a.b(this, channelTitleData);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(ChannelTitleData channelTitleData, int i10, List<ChannelTitleData> list) {
            r7.e.a.C0344a.d(this, channelTitleData, i10, list);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void c(boolean z10, ChannelTitleData channelTitleData) {
            r7.e.a.C0344a.e(this, z10, channelTitleData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/live/evo_mobile/ui/n$d", "Lr7/e$a;", "Lu7/i;", "item", "", "position", "", "list", "Lr8/z;", "i", "(Lu7/i;ILjava/util/List;)V", "f", "(Lu7/i;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements r7.e.a<StoryListData> {
        d() {
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void e(StoryListData item, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            n.F0(n.this, position, null, true, 2, null);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(StoryListData item, int position, List<StoryListData> list) {
            kotlin.jvm.internal.m.f(item, "item");
            kotlin.jvm.internal.m.f(list, "list");
            n.F0(n.this, position, list, false, 4, null);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void a(StoryListData storyListData) {
            r7.e.a.C0344a.b(this, storyListData);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(StoryListData storyListData, int i10) {
            r7.e.a.C0344a.c(this, storyListData, i10);
        }

        @Override // r7.e.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(boolean z10, StoryListData storyListData) {
            r7.e.a.C0344a.e(this, z10, storyListData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/n$e", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements x1.f1.lb.util.w0.a<String> {
        @Override // x1.f1.lb.util.w0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String value) {
            kotlin.jvm.internal.m.f(value, "value");
            ChannelStreamResponse channelStreamResponseQ = t.v.c.i.a.q(t.v.c.i.a.f18646a, value, null, 2, null);
            if (channelStreamResponseQ == null || channelStreamResponseQ.c()) {
                return;
            }
            com.tvc.lib.mobile.ui.base.a.INSTANCE.b(value);
        }

        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/n$f", "Lcom/live/evo_mobile/adapter/n$a;", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "", "position", "Lr8/z;", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements com.live.evo_mobile.adapter.n.a {
        f() {
        }

        @Override // com.live.evo_mobile.adapter.n.a
        public void a(ChannelStreamResponse response, int position) {
            com.live.evo_mobile.adapter.n.a aVar;
            kotlin.jvm.internal.m.f(response, "response");
            if (n.this.clickListener == null || (aVar = n.this.clickListener) == null) {
                return;
            }
            aVar.a(response, position);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0(int index) {
        if (index > 0) {
            RecyclerView.LayoutManager layoutManager = ((z4.y) T()).f23036b.getLayoutManager();
            kotlin.jvm.internal.m.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(index, 0);
        } else {
            int iMax = Math.max(index, 0);
            RecyclerView.LayoutManager layoutManager2 = ((z4.y) T()).f23036b.getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.scrollToPosition(iMax);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0(int index) {
        if (index <= 0) {
            RecyclerView.LayoutManager layoutManager = ((z4.y) T()).f23035a.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPosition(Math.max(index, 0));
                return;
            }
            return;
        }
        RecyclerView.LayoutManager layoutManager2 = ((z4.y) T()).f23035a.getLayoutManager();
        kotlin.jvm.internal.m.d(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findFirstCompletelyVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager3 = ((z4.y) T()).f23035a.getLayoutManager();
        kotlin.jvm.internal.m.d(layoutManager3, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager3).findLastCompletelyVisibleItemPosition();
        if (iFindFirstCompletelyVisibleItemPosition > index || index > iFindLastCompletelyVisibleItemPosition) {
            RecyclerView.LayoutManager layoutManager4 = ((z4.y) T()).f23035a.getLayoutManager();
            kotlin.jvm.internal.m.d(layoutManager4, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager4).scrollToPositionWithOffset(index - 1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z A0(kotlin.jvm.internal.z zVar, n nVar, String str, List list, Integer num) {
        kotlin.jvm.internal.m.f(list, "list");
        for (Object obj : list) {
            if (kotlin.jvm.internal.m.a(((StoryListData) obj).getResponse().getStreamId(), str)) {
                zVar.element = kotlin.collections.r.l0(list, obj);
                nVar.U();
                nVar.t0().U(list, Integer.valueOf(zVar.element));
                Message messageObtainMessage = nVar.handler.obtainMessage(2);
                kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                messageObtainMessage.obj = Integer.valueOf(zVar.element);
                nVar.handler.sendMessage(messageObtainMessage);
                return r8.z.f17874a;
            }
        }
        obj = null;
        zVar.element = kotlin.collections.r.l0(list, obj);
        nVar.U();
        nVar.t0().U(list, Integer.valueOf(zVar.element));
        Message messageObtainMessage2 = nVar.handler.obtainMessage(2);
        kotlin.jvm.internal.m.e(messageObtainMessage2, "obtainMessage(...)");
        messageObtainMessage2.obj = Integer.valueOf(zVar.element);
        nVar.handler.sendMessage(messageObtainMessage2);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.a B0() {
        return new com.live.evo_mobile.adapter.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.n C0() {
        return new com.live.evo_mobile.adapter.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z D0(n nVar, List list, Integer num) {
        kotlin.jvm.internal.m.f(list, "list");
        nVar.t0().U(list, num);
        return r8.z.f17874a;
    }

    private final void E0(int position, List<StoryListData> list, boolean isUserClick) {
        if (position < 0 || position >= list.size()) {
            return;
        }
        com.tvc.lib.mobile.ext.f.a(isUserClick ? 65554 : 65552, String.valueOf(position), list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void F0(n nVar, int i10, List list, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            list = nVar.t0().m();
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        nVar.E0(i10, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    public final void G0(Integer position) {
        Object next;
        int iL0;
        String strA = com.tvc.lib.mobile.ui.base.a.INSTANCE.a();
        if (position == null || position.intValue() < 0 || position.intValue() >= t0().m().size()) {
            List<T> listM = t0().m();
            Iterator it = t0().m().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.m.a(((StoryListData) next).getResponse().getStreamId(), strA));
            iL0 = kotlin.collections.r.l0(listM, next);
        } else {
            iL0 = position.intValue();
        }
        int i10 = iL0;
        if (i10 >= 0 && i10 < t0().m().size()) {
            t0().Q(i10);
            M0(i10);
            F0(this, i10, null, false, 6, null);
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        ChannelStreamResponse channelStreamResponseQ = t.v.c.i.a.q(aVar, strA, null, 2, null);
        boolean z10 = true;
        if (channelStreamResponseQ == null || !channelStreamResponseQ.c()) {
            if (strA.length() != 0) {
                z10 = false;
            }
        } else if (aVar.d0(this.currentColumn)) {
            z10 = false;
        } else if (u5.i.INSTANCE.a()) {
            if (aVar.q0() ? aVar.e0() : true) {
                z10 = false;
            }
        }
        if (z10) {
            t0().Q(0);
            M0(0);
            F0(this, 0, null, false, 7, null);
        }
    }

    private final void H0(int position, long delayMs) {
        if (this.isVisible) {
            this.handler.removeMessages(1);
            Message messageObtainMessage = this.handler.obtainMessage(1);
            kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
            messageObtainMessage.obj = Integer.valueOf(position);
            if (delayMs > 0) {
                this.handler.sendMessageDelayed(messageObtainMessage, delayMs);
            } else {
                this.handler.sendMessage(messageObtainMessage);
            }
        }
    }

    static /* synthetic */ void I0(n nVar, int i10, long j10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j10 = 0;
        }
        nVar.H0(i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z K0() {
        return r8.z.f17874a;
    }

    private final void p0(String column) {
        this.lastColumn = this.currentColumn;
        this.currentColumn = column;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.a s0() {
        return (com.live.evo_mobile.adapter.a) this.mChannelListAdapter.getValue();
    }

    private final com.live.evo_mobile.adapter.n t0() {
        return (com.live.evo_mobile.adapter.n) this.mStoryListAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean w0(n nVar, c9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        return nVar.v0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z y0(n nVar, String str, List list, Integer num) {
        kotlin.jvm.internal.m.f(list, "list");
        nVar.U();
        nVar.p0(str);
        nVar.t0().U(list, num);
        Message messageObtainMessage = nVar.handler.obtainMessage(2);
        kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
        messageObtainMessage.obj = num;
        nVar.handler.sendMessage(messageObtainMessage);
        return r8.z.f17874a;
    }

    public final void J0(String streamId) {
        kotlin.jvm.internal.m.f(streamId, "streamId");
        ChannelStreamResponse channelStreamResponseQ = t.v.c.i.a.q(t.v.c.i.a.f18646a, streamId, null, 2, null);
        if (channelStreamResponseQ != null && !channelStreamResponseQ.c()) {
            u5.i.Companion companion = u5.i.INSTANCE;
            if (companion.a()) {
                companion.b(false);
                v0(new c9.a() { // from class: com.live.evo_mobile.ui.k
                    @Override // c9.a
                    public final Object invoke() {
                        return n.K0();
                    }
                });
            }
        }
        com.tvc.lib.mobile.ui.base.a.INSTANCE.b(streamId);
    }

    public final void L0(com.live.evo_mobile.adapter.n.a clickListner) {
        kotlin.jvm.internal.m.f(clickListner, "clickListner");
        this.clickListener = clickListner;
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onEPGUpdateEndEvent(nf.e event) {
        kotlin.jvm.internal.m.f(event, "event");
        c0(this.currentColumn, d0(this.currentColumn), new c9.p() { // from class: com.live.evo_mobile.ui.h
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return n.D0(this.f7954a, (List) obj, (Integer) obj2);
            }
        });
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(MessageEventData event) {
        kotlin.jvm.internal.m.f(event, "event");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(ChannelStreamResponse response) {
        kotlin.jvm.internal.m.f(response, "response");
        Iterator it = t0().m().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            if (((StoryListData) it.next()).getResponse().getStreamId().equals(response.getStreamId())) {
                t0().Q(i10);
                if (i10 > 0) {
                    RecyclerView.LayoutManager layoutManager = ((z4.y) T()).f23036b.getLayoutManager();
                    kotlin.jvm.internal.m.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i10, 0);
                    return;
                } else {
                    RecyclerView.LayoutManager layoutManager2 = ((z4.y) T()).f23036b.getLayoutManager();
                    if (layoutManager2 != null) {
                        layoutManager2.scrollToPosition(Math.max(i10, 0));
                        return;
                    }
                    return;
                }
            }
            i10 = i11;
        }
    }

    public final String u0() {
        return com.tvc.lib.mobile.ui.base.a.INSTANCE.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean v0(c9.a<r8.z> channelListLoader) {
        boolean zD0;
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        Boolean bool = aVar.q0() ? null : Boolean.TRUE;
        int iIndexOf = 0;
        if (aVar.q0() && !aVar.e0()) {
            u5.i.Companion companion = u5.i.INSTANCE;
            if (companion.a()) {
                companion.b(false);
                zD0 = aVar.d0(this.currentColumn);
            } else if (aVar.d0(this.currentColumn)) {
                zD0 = true;
            } else {
                zD0 = false;
            }
        } else if (aVar.q0() || u5.i.INSTANCE.a() || !aVar.d0(this.currentColumn)) {
            zD0 = false;
        } else {
            zD0 = true;
        }
        List<String> listU = aVar.u(bool);
        if (listU.isEmpty()) {
            ((z4.y) T()).f23035a.setVisibility(8);
            U();
            return false;
        }
        ((z4.y) T()).f23035a.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        int size = listU.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new ChannelTitleData(listU.get(i10), false, 2, null));
        }
        if (this.currentColumn.length() == 0 || zD0) {
            com.tvc.lib.mobile.ui.base.a.INSTANCE.b("");
        } else {
            iIndexOf = listU.indexOf(this.currentColumn);
        }
        s0().U(arrayList, Integer.valueOf(iIndexOf));
        r0(iIndexOf);
        if (channelListLoader != null) {
            channelListLoader.invoke();
        } else {
            H0(iIndexOf, 300L);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void z0(final String channelId) {
        Object next;
        int iL0;
        Object next2;
        kotlin.jvm.internal.m.f(channelId, "channelId");
        List<T> listM = t0().m();
        final kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
        Iterator it = listM.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.m.a(((StoryListData) next).getResponse().getStreamId(), channelId));
        int iL1 = kotlin.collections.r.l0(listM, next);
        zVar.element = iL1;
        if (iL1 != -1) {
            r0(iL1);
            Message messageObtainMessage = this.handler.obtainMessage(2);
            kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
            messageObtainMessage.obj = Integer.valueOf(zVar.element);
            this.handler.sendMessage(messageObtainMessage);
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        ChannelStreamResponse channelStreamResponseQ = t.v.c.i.a.q(aVar, channelId, null, 2, null);
        if (channelStreamResponseQ != null && channelStreamResponseQ.c() && u5.i.INSTANCE.a()) {
            if (aVar.q0() ? aVar.e0() : true) {
                List<T> listM2 = s0().m();
                Iterator it2 = s0().m().iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (!t.v.c.i.a.f18646a.d0(((ChannelTitleData) next2).getText()));
                iL0 = kotlin.collections.r.l0(listM2, next2);
            } else {
                iL0 = 0;
            }
        } else {
            iL0 = 0;
        }
        s0().Q(iL0);
        ChannelTitleData channelTitleData = (ChannelTitleData) s0().getItem(iL0);
        String text = channelTitleData != null ? channelTitleData.getText() : null;
        List<ChannelStreamResponse> listN = t.v.c.i.a.f18646a.n(text, Boolean.valueOf(iL0 > 0));
        p0(text == null ? "" : text);
        if (text == null) {
            text = "";
        }
        c0(text, listN, new c9.p() { // from class: com.live.evo_mobile.ui.l
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return n.A0(zVar, this, channelId, (List) obj, (Integer) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(final String column) {
        c0(column, d0(column), new c9.p() { // from class: com.live.evo_mobile.ui.m
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return n.y0(this.f8127a, column, (List) obj, (Integer) obj2);
            }
        });
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
        ((z4.y) T()).f23035a.setAdapter(s0());
        ((z4.y) T()).f23036b.setAdapter(t0());
        t0().z(true);
        t0().A(S(), R$layout.view_empty_data);
        x1.f1.lb.util.w0.p(x1.f1.lb.util.w0.f21452a, "last_play_stream_id", new e(), null, 4, null);
        t0().Y(new f());
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_channle_list;
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tvc.lib.mobile.ext.f.d(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.isVisible = !hidden;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        s0().T(new c());
        t0().T(new d());
    }
}
