package com.live.evo.util;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u0016\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/live/evo/util/r0;", "", "<init>", "()V", "", "channelId", "Lr8/z;", "e", "(Ljava/lang/String;)V", "programId", "eventType", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "activity", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "g", "(Landroid/app/Activity;Ljava/lang/String;)V", "fragmentId", "f", "Li5/x;", "item", "d", "(Landroid/app/Activity;Li5/x;)V", "Li5/v;", "bean", "", "b", "(Li5/v;)Z", "c", "(Landroid/app/Activity;Li5/v;)V", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f7337a = new r0();

    public final boolean a(i5.v bean) {
        if (bean == null) {
            return false;
        }
        String strB = bean.b();
        return kotlin.jvm.internal.m.a("channelId", strB) || kotlin.jvm.internal.m.a("h5Link", strB);
    }

    private final void g(Activity activity, String url) {
        if (activity == null || activity.isFinishing() || TextUtils.isEmpty(url)) {
            return;
        }
        b.c(activity, url);
    }

    public final boolean b(i5.v bean) {
        if (bean == null) {
            return false;
        }
        try {
            return !TextUtils.isEmpty(bean.b());
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c(Activity activity, i5.v bean) {
        if (bean == null) {
            return;
        }
        String strB = bean.b();
        String strA = bean.a();
        if (kotlin.jvm.internal.m.a("channelId", strB)) {
            kotlin.jvm.internal.m.c(strA);
            e(strA);
            return;
        }
        if (kotlin.jvm.internal.m.a("programId", strB)) {
            kotlin.jvm.internal.m.c(strA);
            String strJ = bean.j();
            kotlin.jvm.internal.m.e(strJ, "getSupplyId(...)");
            h(strA, strJ, "message");
            return;
        }
        if (kotlin.jvm.internal.m.a("h5Link", strB)) {
            kotlin.jvm.internal.m.c(strA);
            g(activity, strA);
        } else if (kotlin.jvm.internal.m.a("appPageId", strB)) {
            kotlin.jvm.internal.m.c(strA);
            f(strA);
        }
    }

    private r0() {
    }

    private final void e(String channelId) {
        if (TextUtils.isEmpty(channelId)) {
            return;
        }
        xe.c.c().o(new b5.b("", "", "", channelId));
    }

    private final void f(String fragmentId) {
        if (!TextUtils.isEmpty(fragmentId)) {
            if (kotlin.jvm.internal.m.a("footballPage", fragmentId)) {
                xe.c.c().o(new b5.b("subject", "", "", ""));
            } else if (kotlin.jvm.internal.m.a("accountPage", fragmentId)) {
                xe.c.c().o(new b5.b("My Account", "", "", ""));
            } else if (kotlin.jvm.internal.m.a("renewPage", fragmentId)) {
                xe.c.c().o(new b5.b("Renew", "", "", ""));
            }
        }
    }

    private final void h(String programId, String channelId, String eventType) {
        if (!TextUtils.isEmpty(channelId) && !TextUtils.isEmpty(programId)) {
            Map<String, i5.h> mapU = s0.f7342a.u();
            if (!mapU.isEmpty()) {
                mapU.get(channelId);
            }
        }
    }

    public final void d(Activity activity, i5.x item) {
    }
}
