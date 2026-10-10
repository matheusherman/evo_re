package com.live.evo.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.TrafficStats;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.MyApplication;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.x1;
import kotlin.Metadata;
import x1.f1.lb.util.g1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001AB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001b2\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\u00020\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/live/evo/widget/LiveCatchUpVideoView;", "Lcom/live/evo/widget/k;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getLayoutId", "()I", "Lkotlinx/coroutines/flow/f;", "Lx4/c;", "getCatchUpPlayInfo", "()Lkotlinx/coroutines/flow/f;", "", "getUidRxBytes", "()J", "", "getConnectingMsg", "()Ljava/lang/String;", "getLoadingMsg", "Lcom/live/evo/widget/n;", "getPlayerSettings", "()Lcom/live/evo/widget/n;", "flow", "Lr8/z;", "setPlayInfoProvider", "(Lkotlinx/coroutines/flow/f;)V", "", "o", "()Z", "limit", "setMrtRetryLimit", "(I)V", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Lcom/live/evo/widget/LiveCatchUpVideoView$a;", "l", "setPlayStatusListener", "(Lcom/live/evo/widget/LiveCatchUpVideoView$a;)V", "message", "I", "(Landroid/content/Context;Ljava/lang/String;)V", "Lq6/b;", "x", "Lq6/b;", "logger", "y", "Lkotlinx/coroutines/flow/f;", "mPlayInfoProvider", "Landroid/content/pm/ApplicationInfo;", "z", "Landroid/content/pm/ApplicationInfo;", "mApplicationInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/live/evo/widget/n;", "mIjkSettingProvider", "B", "Lcom/live/evo/widget/LiveCatchUpVideoView$a;", "mKeyDownListener", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveCatchUpVideoView extends k {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private n mIjkSettingProvider;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private a mKeyDownListener;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private kotlinx.coroutines.flow.f<? extends x4.c> mPlayInfoProvider;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final ApplicationInfo mApplicationInfo;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/live/evo/widget/LiveCatchUpVideoView$a;", "", "", "bPlay", "Lr8/z;", "a", "(Z)V", "bFocus", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(boolean bPlay);

        void b(boolean bFocus);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCatchUpVideoView(Context context) {
        super(context);
        kotlin.jvm.internal.m.f(context, "context");
        q6.b bVarD = q6.c.d(LiveCatchUpVideoView.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        ApplicationInfo applicationInfo = MyApplication.a().getApplicationInfo();
        kotlin.jvm.internal.m.e(applicationInfo, "getApplicationInfo(...)");
        this.mApplicationInfo = applicationInfo;
    }

    @Override // com.live.evo.widget.k
    protected boolean o() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/live/evo/widget/LiveCatchUpVideoView$b", "Lcom/live/evo/widget/l;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends l {
        b() {
        }
    }

    @Override // com.live.evo.widget.k
    protected void I(Context context, String message) {
        if (message == null) {
            return;
        }
        g1.f21390a.c(message);
    }

    @Override // com.live.evo.widget.k
    protected kotlinx.coroutines.flow.f<x4.c> getCatchUpPlayInfo() {
        return this.mPlayInfoProvider;
    }

    @Override // com.live.evo.widget.k
    protected n getPlayerSettings() {
        n nVar = this.mIjkSettingProvider;
        if (nVar != null) {
            return nVar;
        }
        b bVar = new b();
        this.mIjkSettingProvider = bVar;
        return bVar;
    }

    @Override // com.live.evo.widget.k
    protected long getUidRxBytes() {
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(this.mApplicationInfo.uid);
            return uidRxBytes == -1 ? (long) Math.max(0.0d, TrafficStats.getTotalRxBytes()) : uidRxBytes;
        } catch (Exception e10) {
            this.logger.error("getUidRxBytes", e10);
            return 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    @Override // com.live.evo.widget.k, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        a aVar;
        a aVar2;
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode != 19) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 21:
                    case 22:
                        if (event.getRepeatCount() == 0 && (aVar2 = this.mKeyDownListener) != null) {
                            kotlin.jvm.internal.m.c(aVar2);
                            aVar2.a(true);
                        }
                        break;
                    case 23:
                        if (event.getRepeatCount() == 0 && (aVar = this.mKeyDownListener) != null) {
                            kotlin.jvm.internal.m.c(aVar);
                            aVar.a(true ^ isPlaying());
                        }
                        break;
                }
            } else if (event.getRepeatCount() == 0) {
                kotlin.jvm.internal.m.c(aVar);
                aVar.a(true ^ isPlaying());
            }
        } else if (!isPlaying()) {
            a aVar3 = this.mKeyDownListener;
            if (aVar3 != null) {
                kotlin.jvm.internal.m.c(aVar3);
                aVar3.b(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public final void setPlayInfoProvider(kotlinx.coroutines.flow.f<? extends x4.c> flow) {
        this.mPlayInfoProvider = flow;
    }

    public final void setPlayStatusListener(a l10) {
        this.mKeyDownListener = l10;
    }

    @Override // com.live.evo.widget.k
    protected String getConnectingMsg() {
        String strJ = x1.j(2131951929);
        kotlin.jvm.internal.m.e(strJ, "getString(...)");
        return strJ;
    }

    @Override // com.live.evo.widget.k
    protected int getLayoutId() {
        return R$layout.live_catch_up_vv;
    }

    @Override // com.live.evo.widget.k
    protected String getLoadingMsg() {
        String strJ = x1.j(R$string.video_loading);
        kotlin.jvm.internal.m.e(strJ, "getString(...)");
        return strJ;
    }

    public final void setMrtRetryLimit(int limit) {
        setMRT_RETRY_LIMIT(limit);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCatchUpVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.f(context, "context");
        q6.b bVarD = q6.c.d(LiveCatchUpVideoView.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        ApplicationInfo applicationInfo = MyApplication.a().getApplicationInfo();
        kotlin.jvm.internal.m.e(applicationInfo, "getApplicationInfo(...)");
        this.mApplicationInfo = applicationInfo;
    }
}
